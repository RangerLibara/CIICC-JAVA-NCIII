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
	
	public void Registration(String name, String email, String number, String pin) {
	
		try {
			Connection conn = DriverManager.getConnection(jdbcURL,username,pass);
			String sql = "INSERT INTO users (name, email, number, pin)"+
					" VALUES (?,?,?,?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, email);
			statement.setString(3, number);
			statement.setString(4, pin);
			
			statement.executeUpdate();
			
			conn.close();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			
		}
	}
	
	public void Login(String number, String pin) {
		try {
			Connection conn = DriverManager.getConnection(jdbcURL,username,pass);
			String sql = "SELECT * FROM users WHERE number = ? AND pin = ?;"+
					" VALUES (?,?,?,?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, number);
			statement.setString(2, pin);
			
			statement.executeQuery();
			conn.close();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			
		}
	}
	
//	public int getUserId(String pin, String number) {
//		try {
//			Connection conn = DriverManager.getConnection(jdbcURL,username,pass);
//			String sql = "SELECT id FROM users WHERE number = ? AND pin = ?;";
//			
//			PreparedStatement statement = conn.prepareStatement(sql);
//			statement.setString(1, pin);
//			statement.setString(2, number);
//			
//			int id = statement.executeUpdate();
//			
//		}catch(SQLException ex) {
//			ex.printStackTrace();
//			
//		}
//		return id;
//	}
	
	public void changePin(String number, String newpin, String pin) {
		
		
        try (Connection conn = DriverManager.getConnection(jdbcURL, username, pass)) {
            // 1. Retrieve the user ID
            String selectQuery = "SELECT id FROM users WHERE number = ? AND pin = ?";
            try (PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {
                selectStmt.setString(1, number);
                selectStmt.setString(2, newpin); // Assuming old pin; use user input if changing it

                ResultSet rs = selectStmt.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("id"); // Get user ID

                    // 2. Update the PIN
                    String updateQuery = "UPDATE users SET pin = ? WHERE id = ?";
                    try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                        updateStmt.setString(1, newpin);
                        updateStmt.setInt(2, id);

                    updateStmt.executeUpdate();
                       
                    }
                } else {
                    System.out.println("User not found or incorrect credentials.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		
//		try {
//			
//			Connection conn = DriverManager.getConnection(jdbcURL,username,pass);
//			String sqls = "SELECT id FROM users WHERE number = ? AND pin = ?;";
//			
//			PreparedStatement statements = conn.prepareStatement(sqls);
//			statements.setString(1, number);
//			statements.setString(2, pin);
//			
//			ResultSet rs = statements.executeQuery();
//			
//			if(rs.next()){
//				int id = rs.getInt("id");
//				
//				String sql = "UPDATE users SET pin = ? WHERE id = '?';";
//				
//				PreparedStatement statement = conn.prepareStatement(sql);
//				statement.setString(1, newpin);
//				statement.setInt(2, id);
//				
//				int rowsUpdated = statement.executeUpdate();
//                if (rowsUpdated > 0) {
//                    System.out.println("PIN updated successfully!");
//                } else {
//                    System.out.println("PIN update failed.");
//                }
//			}else {
//				System.out.println("User not found or incorrect credentials.");
//			}
//			
//		}catch(SQLException ex) {
//			ex.printStackTrace();
//			
//		}
	}
	
	public void logout() {
		System.exit(0);
	}
}
