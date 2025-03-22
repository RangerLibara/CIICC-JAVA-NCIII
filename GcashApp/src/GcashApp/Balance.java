package GcashApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Balance {
    
    private int id;
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/gcashappdb";
	private String username = "root";
	private String pass = "root";


    public double checkBalance(int userId) {
        String sql = "SELECT balance FROM users WHERE id = ?";
        double balance = -1; 

        try (Connection conn = DriverManager.getConnection(jdbcURL, username, pass);
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                balance = resultSet.getDouble("balance");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return balance;
    }
}


