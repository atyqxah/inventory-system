package healin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import healin.DAO.StaffDAO;
import healin.model.Staff;
/**
 * Servlet implementation class StaffController
 */
@WebServlet("/StaffController")
public class StaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static String LIST_STAFF = "staff/viewStaffList.jsp";
	private static String UPDATE_STAFF= "staff/updateStaff.jsp";
	private static String VIEW_STAFF = "staff/viewStaff.jsp";
	
	private StaffDAO daoStaff;
	
	String forward="";	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffController() {
        super();
        daoStaff = new StaffDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
			
			if (action.equalsIgnoreCase("listStaff")) {
				
				forward = LIST_STAFF;
	            request.setAttribute("staffs", daoStaff.getAllStaff());
						
			} else if (action.equalsIgnoreCase("deleteStaff")) {
	    	
				String id= request.getParameter("id");
	    	
				daoStaff.deleteStaff(id);
	    	
				forward = LIST_STAFF;
				request.setAttribute("staffs", daoStaff.getAllStaff()); 
	   
			} else if (action.equalsIgnoreCase("updateStaff")) {	
	        	
				String id= request.getParameter("id");
	        
	        	Staff staff = new Staff();
	        	staff = daoStaff.getStaffById(id);
	        	        	
	        	forward = UPDATE_STAFF;
	            request.setAttribute("staff", staff); 
		
	        } else if (action.equalsIgnoreCase("viewStaff")) {
	        	
	        	String id= request.getParameter("id");
	        	
	        	Staff staff = new Staff();
	        	staff = daoStaff.getStaffById(id);        	
	        	
	        	forward = VIEW_STAFF;       		
	            request.setAttribute("staff", staff);        	
	      
	        }
			
			RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String staffId =request.getParameter("staffId");
		String staffIc = request.getParameter("staffIc");
		String staffName = request.getParameter("staffName");
		String staffPhone = request.getParameter("staffPhone");
		String staffAddress = request.getParameter("staffAddress");
		String managerId = request.getParameter("managerId");
		String roles = request.getParameter("roles");
		String branchId = request.getParameter("branchId");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Staff staff = new Staff(staffId, staffIc,staffName , staffPhone, staffAddress, managerId, roles,branchId, username, password);				
		
		staff = StaffDAO.getStaff(staff);
	
		if(!staff.isValid()){
			System.out.println("adding");
        	daoStaff.add(staff);
        	
        	response.sendRedirect("./StaffController?action=listStaff");
        }
		
		else{
        	System.out.println("Staff existed!");
        	daoStaff.updateStaff(staff);
        	
        	//RequestDispatcher view = request.getRequestDispatcher(VIEW_STAFF);
			//request.setAttribute("staff", daoStaff.getStaffById(staffId));
			//view.forward(request, response);
        	response.sendRedirect("./StaffController?action=listStaff");
            
        } 
	}

}
