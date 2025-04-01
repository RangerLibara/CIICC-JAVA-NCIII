package GcashApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction {

    private int id;
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/gcashappdb";
	private String username = "root";
	private String pass = "root";


     public void cashIn(int userId, double amount) {
        String sql = "UPDATE users SET balance = balance + ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(jdbcURL, username, pass);
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setDouble(1, amount);
            statement.setInt(2, userId);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Successfully added " + amount + " to user ID " + userId);
            } else {
                System.out.println("User not found!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
