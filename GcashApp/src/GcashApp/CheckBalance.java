package GcashApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckBalance extends DbContext  {
	
	
	 public double checkBalance(int userId) {
	        try {
	        	Connection conn = DriverManager.getConnection(jdbcURL,username,pass);
				String sql = "SELECT amount FROM balance WHERE user_ID = ?";
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1, userId);
	            ResultSet rs = statement.executeQuery();
	            if (rs.next()) {
	                return rs.getDouble("amount");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return 0.0;
	    }

}
