package GcashApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CashTransfer extends DbContext {
	
	
    public void cashTransfer(int senderId, int recipientId, double amount) {
        try {
        	    Connection conn = DriverManager.getConnection(jdbcURL,username,pass);
        	    conn.setAutoCommit(false);
            	PreparedStatement deductStmt = conn.prepareStatement("UPDATE balance SET amount = amount - ? WHERE user_ID = ? AND amount >= ?");
            	PreparedStatement addStmt = conn.prepareStatement("UPDATE balance SET amount = amount + ? WHERE user_ID = ?");
				
                deductStmt.setDouble(1, amount);
                deductStmt.setInt(2, senderId);
                deductStmt.setDouble(3, amount);
                int rowsAffected = deductStmt.executeUpdate();
                if (rowsAffected == 0) {
                    System.out.println("Insufficient balance.");
                    conn.rollback();
                    return;
                }
                addStmt.setDouble(1, amount);
                addStmt.setInt(2, recipientId);
                addStmt.executeUpdate();
                conn.commit();
                System.out.println("Transfer successful.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

}
