package healin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import healin.DAO.StaffDAO;
import healin.connection.ConnectionManager;
import healin.model.Staff;


/**
 * Servlet implementation class loginController
 */
@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.setAttribute("roles",null);
		session.setAttribute("staffName",null);
		session.setAttribute("staffId",null);
		session.invalidate();
		
		response.sendRedirect("/healin/login.jsp");
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String staffId = request.getParameter("staffId");
		String password = request.getParameter("password");
		HttpSession session = request.getSession(true);//declare session
		Staff s = new Staff();
		
		//System.out.println(staffID);
		//System.out.println(staffPassword);
		
		try {
			s = StaffDAO.login(staffId, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (!s.isValid()) {
			System.out.println("Invalid ID and/or Password");
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<script>");
			pw.println("alert('Invalid ID or Password');");
			pw.println("window.location.href='login.jsp'");
			pw.println("</script>");
			
//			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if (s.getRoles().equals("Admin")){
			System.out.println("Admin");
			session.setAttribute("roles","admin");
			session.setAttribute("staffName",s.getStaffName());
			session.setAttribute("staffId",s.getStaffId());
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else if (s.getRoles().equals("Staff")){
			System.out.println("Staff");
			session.setAttribute("roles","staff");
			session.setAttribute("staffName",s.getStaffName());
			session.setAttribute("staffId",s.getStaffId());
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else if (s.getRoles().equals("Manager")){
			System.out.println("Manager");
			session.setAttribute("roles","manager");
			session.setAttribute("staffName",s.getStaffName());
			session.setAttribute("staffId",s.getStaffId());
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	}

}
