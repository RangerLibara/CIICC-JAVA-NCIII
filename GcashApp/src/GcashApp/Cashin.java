package GcashApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cashin {
	
	int id;
	String jdbcURL = "jdbc:mysql://localhost:3306/gcashappdb";
	String username = "root";
	String pass = "root";

	 public void cashin(int userId, double amount) {
	        try {
	        	Connection conn = DriverManager.getConnection(jdbcURL,username,pass);
				String sql = "UPDATE balance SET amount = amount + ? WHERE user_ID = ?";
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setDouble(1, amount);
				statement.setInt(2, userId);
				statement.executeUpdate();
	            System.out.println("Cash-in successful.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
