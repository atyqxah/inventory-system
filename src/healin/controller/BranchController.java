package healin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import healin.DAO.BranchDAO;
import healin.model.Branch;
/**
 * Servlet implementation class BranchController
 */
@WebServlet("/BranchController")
public class BranchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String LIST_BRANCH = "branch/viewBranchList.jsp";
	//private static String UPDATE_BRANCH = "branch/updateBranch.jsp";
	//private static String VIEW_BRANCH = "branch/viewBranch.jsp";
	
	private BranchDAO daoBranch;
	
	String forward="";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchController() {
        super();
        daoBranch = new BranchDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("listBranch")) {
			
			forward = LIST_BRANCH;
			request.setAttribute("branchs",daoBranch.getAllBranch());
			
		}else if (action.equalsIgnoreCase("deleteBranch")) {
	    	
				String id= request.getParameter("id");
	    	
				daoBranch.deleteBranch(id);
	    	
				forward = LIST_BRANCH;
				request.setAttribute("branchs", daoBranch.getAllBranch()); 
	   
		}/*else if(action.equalsIgnoreCase("updateBranch")) {
			
			String id = request.getParameter("id");
			
			Branch branch = new Branch();
			branch = daoBranch.getBranchById(id);
			
			forward = UPDATE_BRANCH;
			request.setAttribute("branch", branch);
			
		}else if(action.equalsIgnoreCase("viewBranch")) {
			
			String id = request.getParameter("id");
			
			Branch branch = new Branch();
			branch = daoBranch.getBranchById(id);
			
			forward = VIEW_BRANCH;
			request.setAttribute("branch", branch);
		}*/
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//int branchId = Integer.parseInt(request.getParameter("branchId"));
		String branchAddress = request.getParameter("branchAddress");
		String branchPhone = request.getParameter("branchPhone");
		String branchName = request.getParameter("branchName");
		
		Branch branch = new Branch(branchAddress,branchPhone, branchName);
		
		branch = BranchDAO.getBranch(branch);
		
		if(!branch.isValid()) {
			System.out.println("adding");
			daoBranch.add(branch);
			
			response.sendRedirect("./BranchController?action=listBranch");
		}
		/*else {
			System.out.println("Branch existed!");
			daoBranch.updateBranch(branch);
			
			RequestDispatcher view = request.getRequestDispatcher(VIEW_BRANCH);
			request.setAttribute("branch",daoBranch.getBranchById(branchId));
			view.forward(request, response);
		}*/
	}

}
