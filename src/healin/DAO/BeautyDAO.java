package healin.DAO;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import healin.connection.ConnectionManager;
import healin.model.Beauty;
import healin.model.Product;

public class BeautyDAO {
		
		static Connection currentCon = null;
		static ResultSet rs = null;
		static PreparedStatement ps = null;
		static Statement stmt = null;
		static int pid;
		static String makeup, direction;
		
		public void add(Beauty beauty) throws NoSuchAlgorithmException{
			
			pid = beauty.getProductId();
			makeup = beauty.getMakeupType();
			direction = beauty.getDirection();
			
			try {
				
				currentCon = ConnectionManager.getConnection();
	    		ps=currentCon.prepareStatement("insert into beauty (productid,makeuptype,direction)values(?,?,?)");
	    		ps.setInt(1,pid);
	    		ps.setString(2,makeup);
	    		ps.setString(3,direction);
	    		ps.executeUpdate();
	    	
	    		System.out.println("Your product id is " + pid);
	    		System.out.println("Your make up type is " + makeup);
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
		
		public Beauty getBeautyById(Product product) {
			
			Beauty beauty = new Beauty();
			
			pid =product.getProductId();
			
			String searchQuery = "select * from beauty where productid = '" + pid + "'";
			try {
				currentCon = ConnectionManager.getConnection();
				stmt = currentCon.createStatement();
				rs = stmt.executeQuery(searchQuery);
				boolean more = rs.next();
				
				if(more) {
					beauty.setProductId(product.getProductId());
					beauty.setProductName(product.getProductName());
					beauty.setProductSize(product.getProductSize());
					beauty.setProductPrice(product.getProductPrice());
					beauty.setCurrentStock(product.getCurrentStock());
					beauty.setProductType(product.getProductType());
					beauty.setMakeupType(rs.getString("makeuptype"));
					beauty.setDirection(rs.getString("direction"));
				}
				
				else if(!more) {
					System.out.println("Sorry");
				}
				}catch (SQLException e) {
					e.printStackTrace();
					}
			
			return beauty;
		}
		
		public void updateBeauty(Beauty beauty ) {
			
			pid = beauty.getProductId();
			makeup = beauty.getMakeupType();
			direction = beauty.getDirection();
			
			String searchQuery = "UPDATE beauty set makeupType = '" + makeup + "', direction = '" + direction + "' where productid='" + pid + "'";
			
			try {
				
		        currentCon = ConnectionManager.getConnection();
		        stmt = currentCon.createStatement();
		        stmt.executeUpdate(searchQuery);
		        
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		
		public void deleteBeauty(int id) {
			String searchQuery = "delete from beauty where productid=" + "'" + pid;

			try {
				
		        currentCon = ConnectionManager.getConnection();
		        stmt = currentCon.createStatement();
		        stmt.executeUpdate(searchQuery);
		        
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
			
		}

	

}
