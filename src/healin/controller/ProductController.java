package healin.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import healin.DAO.BeautyDAO;
import healin.DAO.HealthDAO;
import healin.DAO.ProductDAO;
import healin.model.Beauty;
import healin.model.Health;
import healin.model.Product;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static String UPDATE_HEALTH= "product/updateHealth.jsp";
	private static String UPDATE_BEAUTY = "product/updateBeauty.jsp";
	private static String VIEW_HEALTH = "product/viewHealth.jsp";
	private static String VIEW_BEAUTY = "product/viewBeauty.jsp";
	
	private static String LIST_PRODUCT= "product/viewProductList.jsp";
	private static String ADD_INVENTORY= "inventory/addInventory.jsp";
	//private static String UPDATE_PRODUCT = "product/updateProduct.jsp";
    //private static String VIEW_PRODUCT = "product/viewProduct.jsp";
	
	private ProductDAO daoProduct;
	private HealthDAO daoHealth;
	private BeautyDAO daoBeauty;
	
	String forward="";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        daoProduct = new ProductDAO();
        daoHealth = new HealthDAO();
        daoBeauty = new BeautyDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("listProduct")) {
			
			forward = LIST_PRODUCT;
			request.setAttribute("products",daoProduct.getAllProduct());
			
		}else if (action.equalsIgnoreCase("deleteProduct")) {
	    	
				String id= request.getParameter("id");
	    	
				daoProduct.deleteProduct(id);
	    	
				forward = LIST_PRODUCT;
				request.setAttribute("products", daoProduct.getAllProduct()); 
	   
		}else if(action.equalsIgnoreCase("updateProduct")) {
			
			String id = request.getParameter("id");
			
			Product product = new Product();
			product = daoProduct.getProductById(id);
			
			if(product.getProductType().contentEquals("Health")) {
				
				if(product.getProductType().contentEquals("Health")) {
					
					Health health = new Health();
					health = daoHealth.getHealthById(product);
					forward = UPDATE_HEALTH;
					request.setAttribute("health", health);
				
				}
			}
			else if(product.getProductType().contentEquals("Beauty")) {
				
					if(product.getProductType().contentEquals("Beauty")) {
					Beauty beauty = new Beauty();
					beauty = daoBeauty.getBeautyById(product);
					forward = UPDATE_BEAUTY;
					request.setAttribute("beauty", beauty);
				}
			}
			
		}else if(action.equalsIgnoreCase("viewProduct")) {
			
			String id = request.getParameter("id");
			
			Product product = new Product();
			product = daoProduct.getProductById(id);
			
		
				if(product.getProductType().contentEquals("Health")) {
					
					Health health = new Health();
					health = daoHealth.getHealthById(product);
					forward = VIEW_HEALTH;
					request.setAttribute("health", health);
				
				} else if(product.getProductType().contentEquals("Beauty")) {
					
					Beauty beauty = new Beauty();
					beauty = daoBeauty.getBeautyById(product);
					forward = VIEW_BEAUTY;
					request.setAttribute("beauty", beauty);
				}
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int productId = Integer.parseInt(request.getParameter("productId"));
		String productName = request.getParameter("productName");
		String productSize = request.getParameter("productSize");
		double productPrice = Double.parseDouble(request.getParameter("productPrice"));
		String productType = request.getParameter("productType");
		Integer currentStock = Integer.parseInt(request.getParameter("currentStock"));
		String supplementType = request.getParameter("supplementType");
		String makeupType = request.getParameter("makeupType");
		String suggestion = request.getParameter("suggestion");
		String direction = request.getParameter("direction");
		
	//	if(productType.equalsIgnoreCase("Health")) {
			
		//	supplement = String.parse(supplementType);
	
		//}
		
		//else if(productType.equalsIgnoreCase("Beauty")) {
			
			//beauty  = String.parseString(makeupType);
	
		//}
		Product product = new Product(productId,productName,productSize,productPrice, currentStock, productType);
		
		product = ProductDAO.getProduct(product);
		
		if(!product.isValid()) {
			System.out.println("adding");
			daoProduct.add(product);
			
			if (productType.equalsIgnoreCase("Health")) {
				Health health = new Health(productId,productName,productSize,productPrice, currentStock, productType, false, supplementType, suggestion);
				try {
					daoHealth.add(health);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
			} else if (productType.equalsIgnoreCase("Beauty")) {
				Beauty beauty = new Beauty(productId,productName, productSize, productPrice, currentStock, productType, false, makeupType, direction);
				try {
					daoBeauty.add(beauty);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
			}
			response.sendRedirect("./ProductController?action=listProduct");
		}
		else {
			System.out.println("Product existed!");
			daoProduct.updateProduct(product);
			
			if (productType.equalsIgnoreCase("Health")) {
				Health health = new Health(productId,productName,productSize,productPrice, currentStock, productType,false, supplementType, suggestion);
				daoHealth.updateHealth(health);
				
				//RequestDispatcher view = request.getRequestDispatcher("./ProductController?action=listProduct");
				//request.setAttribute("Health",daoHealth.getHealthById(product));
				//view.forward(request, response);
			}
			
			else if (productType.equalsIgnoreCase("Beauty")) {
				Beauty beauty = new Beauty (productId,productName, productSize, productPrice, currentStock, productType, false, makeupType, direction);
				daoBeauty.updateBeauty(beauty);
				
			//RequestDispatcher view = request.getRequestDispatcher(VIEW_BEAUTY);
			//request.setAttribute("Beauty",daoBeauty.getBeautyById(product));
			//view.forward(request, response);
			}
			response.sendRedirect("./ProductController?action=listProduct");
		}
	}

}
