package healin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import healin.connection.ConnectionManager;
import healin.model.Orders;

public class OrderDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static int ord;
	static String orderstatus,ordertype,staffid;
	
	public static Orders getOrder(Orders orders1) {
		ord = orders1.getOrderId();
				
		String searchQuery = "select * from orders where orderid='" + ord +"'";
		
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean yes = rs.next();
			
			System.out.println(searchQuery);
			
			if(yes) {
				orders1.setValid(true);
			}else if(!yes) {
				orders1.setValid(false);
			}
		}catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}
		finally {
			if(rs != null) {
				try {
					rs.close();
				}catch (Exception e) {
				}
				rs= null;
			}
			if(stmt !=null) {
				try {
					stmt.close();
				}catch(Exception e) {
				}
				stmt = null;
		    }
			if(currentCon != null) {
				try {
					currentCon.close();
				}catch (Exception e) {
			    }
				currentCon = null;}
		}return orders1;
		
	}
	
	public void add(Orders orders1) {
		ord = orders1.getOrderId();
		ordertype = orders1.getOrdertype();
		orderstatus = orders1.getOrderstatus();
		staffid = orders1.getStaffId();
		
		try {
			currentCon = ConnectionManager.getConnection();
			
			ps = currentCon.prepareStatement("Insert into orders(orderid, ordertype,orderstatus,staffid)values(?,?,?,?)");
			ps.setInt(1, ord);
			ps.setString(2, ordertype);
			ps.setString(3, orderstatus );
			ps.setString(4, staffid);
			ps.executeUpdate();
			
			System.out.println("orderid is "+ ord);
			
		}catch (Exception ex) {
			System.out.println("failed: An exception occurred!" + ex);
		}
		finally {
			if(ps != null) {
				try {
					ps.close();
				}catch (Exception e) {
				}
				ps = null;
			}
			if(currentCon != null) {
				try {
					currentCon.close();
				}catch(Exception e) {
			}
				currentCon = null;}
		}
	}
	
	public List<Orders> getAllOrder(){
		List<Orders> ordersa = new ArrayList<Orders>();
		
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			
			String q = "select * from orders";
			ResultSet rs = stmt.executeQuery(q);
			
			while(rs.next()) {
				Orders orders1 = new Orders();
				
				orders1.setOrderId(rs.getInt("orderid"));
				orders1.setOrdertype(rs.getString("ordertype"));
				orders1.setOrderstatus(rs.getString("orderstatus"));
				orders1.setStaffId(rs.getString("staffid"));
				ordersa.add(orders1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ordersa;
        }
	
	public void deleteOrder(String ord) {
		String searchQuery = "delete from orders where orderid=" + "'" + ord + "'";
		
		System.out.println(searchQuery);
		
		try {
	
	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public Orders getOrderById(String id) {
		Orders orders1 = new Orders();
		
		try {
			currentCon = ConnectionManager.getConnection();
	        ps=currentCon.prepareStatement("select * from orders where orderid=?");
	        
	        ps.setString(1, id);
	        ResultSet rs = ps.executeQuery();
	        
	        if(rs.next()) {
	        	orders1.setOrderId(rs.getInt("orderid"));
	        	orders1.setOrdertype(rs.getString("ordertype"));
				orders1.setOrderstatus(rs.getString("orderstatus"));
				orders1.setStaffId(rs.getString("staffid"));
	        }
		}catch (SQLException e) {
	        e.printStackTrace();
	    }
		return orders1;
	}
	
	public void updateOrder(Orders orders1) {
		ord = orders1.getOrderId();
		ordertype = orders1.getOrdertype();
		orderstatus = orders1.getOrderstatus();
		staffid = orders1.getStaffId();
		
		
		String searchQuery = "UPDATE orders SET ordertype = '" + ordertype + "' , orderstatus = '" + orderstatus + "' WHERE orderid='" + ord + "'";
		
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
