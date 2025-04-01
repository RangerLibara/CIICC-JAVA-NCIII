package GcashApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserAuthentication {
	
	int id;
	String jdbcURL = "jdbc:mysql://localhost:3306/gcashappdb";
	String username = "root";
	String pass = "root";
	

	
    public void register(String email, String name, String phoneNumber, String pin) {
        try  {
        	Connection conn = DriverManager.getConnection(jdbcURL,username,pass);
        	PreparedStatement statement = conn.prepareStatement("INSERT INTO users (Email, Name, Number, PIN) VALUES (?, ?, ?, ?)");
        	statement.setString(1, email);
        	statement.setString(2, name);
        	statement.setString(3, phoneNumber);
        	statement.setString(4, pin);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Registration successful.");
            } else {
                System.out.println("Registration failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    public int login(String email, String pin) {
        try {
        	Connection conn = DriverManager.getConnection(jdbcURL,username,pass);
			String sql = "SELECT ID FROM users WHERE Email = ? AND PIN = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, pin);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public void logout(int userId) {
        System.out.println("User " + userId + " logged out.");
    }
	
}
