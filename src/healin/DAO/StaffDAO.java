package healin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import healin.connection.ConnectionManager;
import healin.model.Staff;

public class StaffDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static String sic,name, address,phone,branchid, username, password,roles,staffid ,manager;

	public static Staff getStaff(Staff staff) {
		
		staffid = staff.getStaffId();

        String searchQuery = "select * from staff where staffid='" + staffid + "'";

        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            
            System.out.println(searchQuery);

            // if staff exists set the isValid variable to true
            if (more) {
            	staff.setValid(true);
           	}
           
            else if (!more) {
            	staff.setValid(false);
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

        return staff;
	}
	
	public void add(Staff staff) {
		
		staffid =staff.getStaffId();
		sic = staff.getStaffIc();
        name = staff.getStaffName();
        phone = staff.getStaffPhone();
        address = staff.getStaffAddress();
        manager = staff.getManagerId();
        roles = staff.getRoles();
        branchid = staff.getBranchId();
        username = staff.getUsername();
        password = staff.getPassword();
       
       
    	try {
    		currentCon = ConnectionManager.getConnection();
    		ps=currentCon.prepareStatement("insert into staff ( staffid,staffic, staffname, staffphone, staffaddress, managerid, roles,branchid, username, password)values(?,?,?,?,?,?,?,?,?,?)");
    		ps.setString(1, staffid);
    		ps.setString(2, sic);
    		ps.setString(3, name);
    		ps.setString(4, phone);
    		ps.setString(5, address);
    		ps.setString(6, manager);
    		ps.setString(7,  roles );
    		ps.setString(8,branchid);
    		ps.setString(9, username);
    		ps.setString(10, password);
    		ps.executeUpdate();
    	
    		System.out.println("staffid is " + staffid);
    		System.out.println("staffic is " + sic);
    		System.out.println("staffname is " + name);
    		System.out.println("staffphone is " + phone);
    		System.out.println("Address is " + address);
    		System.out.println("Manager id is " + manager);
    		System.out.println("Manager id is " +branchid);
            
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

	public List<Staff> getAllStaff() {
		List<Staff> staffs = new ArrayList<Staff>();
		  
		  try {
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  
		  	  String q = "select * from staff order by staffid asc";
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) {
		    	  Staff staff = new Staff();
		          		          
		    	  staff.setStaffId(rs.getString("staffid"));
		    	  staff.setStaffIc(rs.getString("staffic"));
		    	  staff.setStaffName(rs.getString("staffname"));
		    	  staff.setStaffPhone(rs.getString("staffphone"));
		    	  staff.setStaffAddress(rs.getString("staffaddress"));
		    	  staff.setManagerId(rs.getString("managerid"));
		    	  staff.setRoles(rs.getString("roles"));
		    	  staff.setBranchId(rs.getString("branchid"));
		    	  staff.setUsername(rs.getString("username"));
		    	  staff.setPassword(rs.getString("password"));
		    	  staffs.add(staff);
		      }
		  } catch (SQLException e) {
		      e.printStackTrace();
		  }

		  return staffs;
	}
	
	public void deleteStaff(String staffid) {
		String searchQuery = "delete from staff where staffid=" + "'" + staffid + "'";
		
		System.out.println(searchQuery);
		
		try {
	
	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}
	
	public Staff getStaffById(String id) {
		Staff staff = new Staff();
	    try {
	    	currentCon = ConnectionManager.getConnection();
	      //  ps=currentCon.prepareStatement("select staffid, staffic, staffname, staffphone, staffaddress, managerid, b.branchid from staff s join branch b on (s.branchid = b.branchid) where staffid=?");
	        ps=currentCon.prepareStatement("select staffid, staffic, staffname, staffphone, staffaddress, managerid, roles, b.branchname, b.branchid, username, password from staff s join branch b on (s.branchid = b.branchid) where staffid=?");
	        ps.setString(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	        	staff.setStaffId(rs.getString("staffid"));
		    	staff.setStaffIc(rs.getString("staffic"));
		    	staff.setStaffName(rs.getString("staffname"));
		    	staff.setStaffPhone(rs.getString("staffphone"));
		    	staff.setStaffAddress(rs.getString("staffaddress"));
		    	staff.setManagerId(rs.getString("managerid"));
		    	staff.setRoles(rs.getString("roles"));
		    	staff.setBranchId(rs.getString("branchid"));
		    	staff.setBranchName(rs.getString("branchname"));
		    	staff.setUsername(rs.getString("username"));
		    	staff.setPassword(rs.getString("password"));
		    
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    
	    return staff;
	}

	public void updateStaff(Staff staff) {
		
		staffid =staff.getStaffId();
		sic = staff.getStaffIc();
        name = staff.getStaffName();
        phone = staff.getStaffPhone();
        address = staff.getStaffAddress();
        manager = staff.getManagerId();
        roles = staff.getRoles();
        branchid = staff.getBranchId();
        username = staff.getUsername();
        password = staff.getPassword();
        
	    String searchQuery = "UPDATE staff SET  staffic='" + sic  + "' ,staffname='" + name  + "' , staffphone='" + phone + "', staffaddress='"+ address + "', managerid='"+ manager 
	    		+ "' , roles='"+ roles +"', branchid='"+ branchid + "', username='" + username +"',  password='" + password +"'  WHERE staffid= '" + staffid + "'";
	
		try {
	
	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static Staff login(String staffID, String staffPassword) throws SQLException {
  		Connection currentCon = ConnectionManager.getConnection();
  		
  		try {
  			String sql = "select * from STAFF where STAFFID=? and PASSWORD=?";
  			PreparedStatement ps = currentCon.prepareStatement(sql);
  			Staff s = new Staff();
  			ps.setString(1, staffID);
  			ps.setString(2, staffPassword);
  			ps.executeQuery();
  			
  			ResultSet rs = ps.executeQuery();
  			
  			if(rs.next()) {	
  				
  				s.setStaffId(rs.getString("STAFFID"));	
  				s.setPassword(rs.getString("PASSWORD"));	
  				s.setRoles(rs.getString("ROLES"));
  				s.setStaffName(rs.getString("STAFFNAME"));	
  				s.setValid(true);
  				return s;
  			}
  			else {
  				s.setValid(false);
  				return s;
  			}
  		}
  		catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}finally{
  			currentCon.close();
  		}
  		return null;
  	}

}