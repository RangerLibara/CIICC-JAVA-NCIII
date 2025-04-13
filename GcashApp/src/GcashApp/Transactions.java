package GcashApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transactions extends DbContext  {

	 public void viewAll() {
	        try  {
	        	Connection conn = DriverManager.getConnection(jdbcURL,username,pass);
				String sql = "SELECT * FROM transactions";
				PreparedStatement statement = conn.prepareStatement(sql);
	            ResultSet rs = statement.executeQuery();
	            while (rs.next()) {
	                System.out.println("Transaction: " + " Amount: " + rs.getDouble("amount") + " Date: " + rs.getDate("date"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 }
    public void viewUserAll(int userId) {
        try  {
        	Connection conn = DriverManager.getConnection(jdbcURL,username,pass);
			String sql = "SELECT * FROM transactions WHERE account_ID = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println("Transaction ID: " + rs.getInt("ID") + " Amount: " + rs.getDouble("amount") + " Date: " + rs.getDate("date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
