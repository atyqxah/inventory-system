package healin.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import healin.model.Inventory;
import healin.connection.ConnectionManager;
import healin.model.Inventory;
import healin.model.Product;


public class InventoryDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static String inventoryid, description, orderid, productid;
	static String invdate;
	static int quantity;
	static ProductDAO daoProduct;
	
	public static Inventory getInventory(Inventory inventory) {
		inventoryid = inventory.getInventoryId();
		orderid = inventory.getOrderId();
		productid = inventory.getProductId();
		quantity = inventory.getQuantity();
		invdate = inventory.getInvdate();
		description = inventory.getDescription();
		
		
		String searchQuery = "select * from inventory where inventoryid='" + inventoryid + "'"
							+ "and orderid='" + orderid + "and productid= '" + productid + "'";
		
		try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            
            System.out.println(searchQuery);
            
            if (more) {
            	inventory.setValid(true);
            }
            
            else if (!more) {
            	inventory.setValid(false);
            }
		}
		catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        }

        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt = null;
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                }

                currentCon = null;
            }
        }
		return inventory;
		
	}
	
	public static void add(Inventory inventory) throws ParseException {
		orderid = inventory.getOrderId();
		productid = inventory.getProductId();
		quantity = inventory.getQuantity();
		invdate = inventory.getInvdate();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf1.parse(invdate);
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
		
		
		try {
    		currentCon = ConnectionManager.getConnection();
    		ps=currentCon.prepareStatement("insert into inventory (orderid, productid, quantity, invdate)values(?,?,?,?)");
    		ps.setString(1, orderid);
    		ps.setString(2, productid);
    		ps.setInt(3, quantity);
    		ps.setDate(4, sqlStartDate);
    		ps.executeUpdate();
    		
    		System.out.println("Your orderid is " + orderid);            
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
	
	public static List<Inventory> getAllProductByOrder(String orderId) {
		  List<Inventory> inventorys = new ArrayList<Inventory>();
		  daoProduct = new ProductDAO();
		  Product product = new Product();
		  
		  try {
			  currentCon = ConnectionManager.getConnection();
			  	stmt = currentCon.createStatement();
			  
			  	String q = "select p.productname, i.quantity, TO_CHAR(i.invdate,'dd-MON-yyyy') from "
			  			+ "inventory i join product p on (p.productid = i.productid)"
			  			+ "where i.orderid = '"+ orderId +"'";
			  	System.out.println(q);
			    ResultSet rs = stmt.executeQuery(q);
			    
			    while(rs.next()) {
			    	Inventory inventory = new Inventory();
			    	
			    	inventory.setProductName(rs.getString(1));
			    	inventory.setQuantity(rs.getInt(2));
			    	inventory.setInvdate(rs.getString(3));			    	
			    	
			    	inventorys.add(inventory);
			    }
		  }catch (SQLException e) {
		      e.printStackTrace();
		  }

		  return inventorys;
	}
	
	public void deleteInventory(String inventoryid, String orderid, String productid, int quantity, String invdate, String description) {
		String searchQuery = "delete from inventory where inventoryid=" + "'" + inventoryid + "' "
				+ " and orderid='" + orderid + "'"
        		+ " and productid='" + productid + "'"
        		+ " and quantity='" + quantity + "'"
        		+ " and invdate='" + invdate + "'"
        		+ " and description='" + description + "'";
		
		System.out.println(searchQuery);
		
		try {
	
	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
		public void updateInventory(Inventory inventory) {
		
			inventoryid = inventory.getInventoryId();
			orderid = inventory.getOrderId();
			productid = inventory.getProductId();
			quantity = inventory.getQuantity();
			invdate = inventory.getInvdate();
			description = inventory.getDescription();
			

			String searchQuery = "UPDATE inventory SET quantity ='" + quantity + "' , description = '" + description + "' WHERE inventoryid= '" + inventoryid + "' and orderid= '" + orderid + "' and productid= '" + productid + "'" ;
		
			try {
	
				currentCon = ConnectionManager.getConnection();
				stmt = currentCon.createStatement();
	        	stmt.executeUpdate(searchQuery);
	        
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		
		
}

