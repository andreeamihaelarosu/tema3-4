package servletContainer;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
	private static Connection conn;
	
	public void setConn(Connection conn) {
    	DBConnection.conn = conn;
    }
    
    public Connection getConn() {
    	return conn;
    }
    
    public void closeConn() {
    	try {
	         conn.close();
	      } catch (SQLException e) {
	         if ((e.getErrorCode() == 50000) && ("XJ015".equals(e.getSQLState()))) {
	               System.out.println("MySQL shut down normally");
	         } else {
	            System.err.println("MySQL did not shut down normally");
	            System.err.println(e.getMessage());
	         }
	      }
    }
}
