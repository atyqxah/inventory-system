package healin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import healin.connection.ConnectionManager;
import healin.model.Branch;


public class BranchDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static String  branchid,badd, bphone, bname;
	
	public static Branch getBranch(Branch branch) {
		branchid = branch.getBranchId();
		
		String searchQuery = "select * from branch where branchid='" + branchid + "'";
		
		try { currentCon = ConnectionManager.getConnection();
		stmt = currentCon.createStatement();
		rs = stmt.executeQuery(searchQuery);
		boolean more = rs.next();
		
		System.out.println(searchQuery);
		
		//if branch exists set the isValid variable to true
		if(more) {
			branch.setValid(true);
		}else if(!more) {
			branch.setValid(false);
		}
		}
		catch (Exception ex) {
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
		}return branch;
		
	}
	
	public void add(Branch branch) {
		branchid = branch.getBranchId();
		badd = branch.getBranchAddress();
		bphone = branch.getBranchPhone();
		bname = branch.getBranchName();
		
		try {
			currentCon = ConnectionManager.getConnection();
			
			ps = currentCon.prepareStatement("Insert into branch (branchid, branchAddress,branchPhone, branchName) values (branchid.nextval,?,?,?)", Statement.RETURN_GENERATED_KEYS);
		
			ps.setString(1, badd);
			ps.setString(2, bphone);
			ps.setString(3, bname);
			ps.executeUpdate();
			
			System.out.println("branchId is " + branchid);
			System.out.println("branchAddress is " + badd);
			System.out.println("branchPhone is " + bphone);
			System.out.println("branchName is " + bname);
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
	
	public List<Branch> getAllBranch(){
		List<Branch> branchs = new ArrayList<Branch>();
		
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			
			String q = "select * from branch ORDER BY branchid asc";
			ResultSet rs = stmt.executeQuery(q);
			
			while(rs.next()) {
				Branch branch = new Branch();
				
				branch.setBranchId(rs.getString("branchid"));
				branch.setBranchAddress(rs.getString("branchaddress"));
				branch.setBranchPhone(rs.getString("branchphone"));
				branch.setBranchName(rs.getString("branchName"));
				branchs.add(branch);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return branchs;
	}
	
	public void deleteBranch(String id) {
		String searchQuery = "delete from branch where branchid=" + "'" + id + "'";
		
		System.out.println(searchQuery);
		
		try {
	
	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}
	
	public Branch getBranchById(String id) {
		Branch branch = new Branch();
	    try {
	    	currentCon = ConnectionManager.getConnection();
	        ps=currentCon.prepareStatement("select * from branch where branchid=?");
	        
	        ps.setString(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	        	branch.setBranchId(rs.getString("branchid"));
	        	branch.setBranchAddress(rs.getString("branchaddress"));
	        	branch.setBranchPhone(rs.getString("branchphone"));
	        	branch.setBranchName(rs.getString("branchname"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    
	    return branch;
	}
	/*
	public void updateBranch(Branch branch) {
		
		id = branch.getBranchId();
		badd = branch.getBranchAddress();
		bphone = branch.getBranchPhone();
		
		String searchQuery = "UPDATE branch SET branchaddress = '" + badd + "', branchphone ='" + bphone+ "' WHERE branchid='" + id + "'";
		
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
	
}
