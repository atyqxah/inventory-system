package healin.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import healin.model.Staff;

public class ConnectionManager {
	
	static Connection con;

	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DB_USER = "househealin";
	private static final String DB_PASSWORD = "house";
	
    public static Connection getConnection() {

        try {

            Class.forName(DB_DRIVER);

            try {
                con = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
                System.out.println("connected");

            }

            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        return con;
    }
    
  //staffLogin
  	public Staff login(String staffID, String staffPassword) throws SQLException {
  		Connection currentCon = ConnectionManager.getConnection();
  		
  		try {
  			String sql = "select * from STAFF where STAFFID=? and STAFFPASSWORD=?";
  			PreparedStatement ps = con.prepareStatement(sql);
  			
  			ps.setString(1, staffID);
  			ps.setString(2, staffPassword);
  			ps.executeQuery();
  			
  			ResultSet rs = ps.executeQuery();
  			
  			if(rs.next()) {	
  				Staff s = new Staff();
  				s.setStaffId(rs.getString("STAFFID"));	
  				s.setPassword(rs.getString("PASSWORD"));	
  				s.setRoles(rs.getString("ROLES"));
  				s.setStaffName(rs.getString("STAFFNAME"));	
  				return s;
  			}
  		}
  		catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}finally{
  			con.close();
  		}
  		return null;
  	}


}
