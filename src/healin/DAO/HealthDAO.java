package healin.DAO;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import healin.model.Health;
import healin.model.Product;
import healin.connection.ConnectionManager;

public class HealthDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static int pid;
	static String supplement,suggestion;
	
	public void add(Health health) throws NoSuchAlgorithmException{
		
		pid = health.getProductId();
		supplement = health.getSupplementType();
		suggestion = health.getSuggestion();
		try {
			
			currentCon = ConnectionManager.getConnection();
    		ps=currentCon.prepareStatement("insert into health (productid,supplementType,suggestion)values(?,?,?)");
    		ps.setInt(1,pid);
    		ps.setString(2,supplement);
    		ps.setString(3, suggestion);
    		ps.executeUpdate();
    	
    		System.out.println("Your id is " + pid);
    		System.out.println("Your supplement is " + supplement);
		}
		catch (Exception ex) {
    		System.out.println("failed: An Exception has occurred! " + ex);
    	}

    	finally {
    		if (ps != null) {
    			try {
    				ps.close();
    			} catch (Exception e) {
    			}
    			ps = null;
    		}
    		
    		if (currentCon != null) {
    			try {
    				currentCon.close();
    			} catch (Exception e) {
    			}
    			currentCon = null;
    		}
    	}	
	}
	
	public Health getHealthById(Product product) {
		
		Health health = new Health();
		
		pid = product.getProductId();
		
		String searchQuery = "select * from health where productid = '" + pid + "'";
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();
			
			if(more) {
				health.setProductId(product.getProductId());
				health.setProductName(product.getProductName());
				health.setProductSize(product.getProductSize());
				health.setProductPrice(product.getProductPrice());
				health.setCurrentStock(product.getCurrentStock());
				health.setProductType(product.getProductType());
				health.setSupplementType(rs.getString("supplementtype"));
				health.setSuggestion(rs.getString("suggestion"));
			}
			
			else if(!more) {
				System.out.println("Sorry");
			}
			}catch (SQLException e) {
				e.printStackTrace();
				}
		
		return health;
	}
	
	public void updateHealth(Health health) {
		
		pid = health.getProductId();
		supplement = health.getSupplementType();
		suggestion = health.getSuggestion();
		
		String searchQuery = "UPDATE health set supplementType = '" + supplement + "' , suggestion = '" + suggestion + "' where productid='" + pid + "'";
		
		try {
			
	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void deleteHealth(String id) {
		String searchQuery = "delete from health where productid=" + pid;

		try {
			
	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

}
