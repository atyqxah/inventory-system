package healin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import healin.DAO.InventoryDAO;
import healin.DAO.OrderDAO;
import healin.model.Orders;

/**
 * Servlet implementation class OrderController
 */
@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String LIST_ORDER= "order/viewOrderList.jsp";
	private static String UPDATE_ORDER = "order/updateOrder.jsp";
	private static String VIEW_ORDER= "order/viewOrder.jsp";
	
	private OrderDAO daoOrder;
	
	String forward="";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderController() {
        super();
        daoOrder = new OrderDAO();
   
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("listOrder")) {
			
			forward = LIST_ORDER;
			request.setAttribute("ordersa", daoOrder.getAllOrder());
			
		}else if (action.equalsIgnoreCase("deleteOrder")) {
	    	
				String id= request.getParameter("id");
	    	
				daoOrder.deleteOrder(id);
	    	
				forward =  LIST_ORDER;
				request.setAttribute("ordersa", daoOrder.getAllOrder()); 
	   
		}else if(action.equalsIgnoreCase("updateOrder")) {
			
			String id = request.getParameter("id");
			
			Orders orders1 = new Orders();
			orders1 = daoOrder.getOrderById(id);
			
			forward = UPDATE_ORDER;
			request.setAttribute("orders1", orders1);
			
		}else if(action.equalsIgnoreCase("viewOrder")) {
			
			String id = request.getParameter("id");
			
			Orders orders1 = new Orders();
			orders1 = daoOrder.getOrderById(id);
			
			forward =VIEW_ORDER;
			request.setAttribute("orders1", orders1);
			request.setAttribute("inventories", InventoryDAO.getAllProductByOrder(id));
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		String ordertype = request.getParameter("ordertype");
		String orderstatus = request.getParameter("orderstatus");
		String staffid = request.getParameter("staffid");
		
		Orders orders1 = new Orders(orderId,ordertype,orderstatus,staffid);
		
		orders1 = OrderDAO.getOrder(orders1);
		
		if(!orders1.isValid()) {
			System.out.println("adding");
			daoOrder.add(orders1);
			
			response.sendRedirect("./OrderController?action=listOrder");
		}
		else {
			System.out.println("Order existed!");
			daoOrder.updateOrder(orders1);
			
			//RequestDispatcher view = request.getRequestDispatcher(VIEW_ORDER);
			//request.setAttribute("orders1",daoOrder.getOrderById(orderId));
			//view.forward(request, response);
			response.sendRedirect("./OrderController?action=listOrder");
		}
		
	}

}
