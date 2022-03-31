package healin.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import healin.model.Inventory;
import healin.DAO.InventoryDAO;
import healin.DAO.OrderDAO;
import healin.DAO.ProductDAO;
import healin.model.Orders;

/**
 * Servlet implementation class InventoryController
 */
@WebServlet("/InventoryController")
public class InventoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static String LIST_ORDER = "inventory/viewInventoryList.jsp";
	private static String VIEW_INVENTORY = "inventory/viewInventory.jsp";
	private static String UPDATE_INVENTORY = "inventory/updateInventory.jsp";
	private static String ADD_INVENTORY= "inventory/addInventory.jsp";
    
	private InventoryDAO daoInventory;
	private OrderDAO daoOrder;
	String forward="";
	/**
     * @see HttpServlet#HttpServlet()
     */
    public InventoryController() {
        super();
        daoInventory = new InventoryDAO();
        daoOrder = new OrderDAO();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("listOrder")) {
			
			forward = LIST_ORDER;
			request.setAttribute("ordersa", daoOrder.getAllOrder());
			
		} else if (action.equalsIgnoreCase("viewInventory")) {
			String id = request.getParameter("id");
			Orders orders1 = new Orders();
			orders1 = daoOrder.getOrderById(id);
			
			List<Inventory> inventorys = new ArrayList<Inventory>();
			inventorys = daoInventory.getAllProductByOrder(id);
			orders1.setInventorys(inventorys);
			
			forward = VIEW_INVENTORY;		
            request.setAttribute("orders1", orders1);

		}else if (action.equalsIgnoreCase("deleteInventory")) {
			
				String inventoryId = request.getParameter("inventoryId");
				String orderId = request.getParameter("orderId");
				String productId = request.getParameter("productId");
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				String invdate = request.getParameter("invdate");
				String description = request.getParameter("description");
				
				daoInventory.deleteInventory(inventoryId, orderId, productId, quantity, invdate, description);
				
				Orders orders1 = new Orders();
				orders1 = daoOrder.getOrderById(orderId);
				
				List<Inventory> inventorys = new ArrayList<Inventory>();
				inventorys = daoInventory.getAllProductByOrder(orderId);
				orders1.setInventorys(inventorys);
				
				forward = VIEW_INVENTORY;		
				request.setAttribute("orders1", orders1);
				
		} else if (action.equalsIgnoreCase("updateInventory")) {	
        	
			String inventoryId = request.getParameter("inventoryId");
			String orderId = request.getParameter("orderId");
			String productId = request.getParameter("productId");
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			String invdate = request.getParameter("invdate");
			String description = request.getParameter("description");
        	
			Inventory inventory = new Inventory(inventoryId, orderId, productId, quantity, invdate, description);
        	
        	inventory = InventoryDAO.getInventory(inventory);
        	        
        	forward = UPDATE_INVENTORY;
            request.setAttribute("inventory", inventory); 
	
        }
		else if(action.equalsIgnoreCase("addInventory")) {
			String orderid = request.getParameter("id");
			String type = request.getParameter("type");
			forward = ADD_INVENTORY;
			ProductDAO daoProduct = new ProductDAO();
			request.setAttribute("products",daoProduct.getAllProduct());
			request.setAttribute("orderid", orderid);
			request.setAttribute("type", type);
			
		}
				
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("Add")) {
			
		String ordertype = request.getParameter("ordertype");
		String orderId = request.getParameter("orderid");
		String productId[] = request.getParameterValues("productId");
		String quantity[] = request.getParameterValues("quantity");
		String invdate = request.getParameter("invdate");
		System.out.println(ordertype);
		Inventory inventory = new Inventory();
		
		inventory.setInvdate(invdate);
		inventory.setOrderId(orderId);
		
		for (int i=0; i<productId.length; i++) {
			inventory.setProductId(productId[i]);
			inventory.setQuantity(Integer.parseInt(quantity[i]));
			
			try {
				InventoryDAO.add(inventory);
				if(ordertype.equalsIgnoreCase("Restock")) {
					ProductDAO.incrementProduct(productId[i], quantity[i]);
				}
				else if(ordertype.equalsIgnoreCase("Release Stock")) {
					ProductDAO.decrementProduct(productId[i], quantity[i]);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		response.sendRedirect("/healin/OrderController?action=listOrder");
		}

	}

}
