package healin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import healin.connection.ConnectionManager;
import healin.model.Product;

public class ProductDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static String name, size, type;
	static Double price;
	static int pid, stock;

	public static Product getProduct(Product product) {
		pid = product.getProductId();

		String searchQuery = "select * from product where productid='" + pid + "'";

		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			System.out.println(searchQuery);

			// if product exists set the isValid variable to true
			if (more) {
				product.setValid(true);
			} else if (!more) {
				product.setValid(false);
			}
		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		} finally {
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
		return product;

	}

	public void add(Product product) {
		pid = product.getProductId();
		name = product.getProductName();
		size = product.getProductSize();
		price = product.getProductPrice();
		stock = product.getCurrentStock();
		type = product.getProductType();

		try {
			currentCon = ConnectionManager.getConnection();

			ps = currentCon.prepareStatement(
					"Insert into product (productid,productname,productsize,productprice,currentstock,producttype) values (?,?,?,?,?,?)");
			ps.setInt(1, pid);
			ps.setString(2, name);
			ps.setString(3, size);
			ps.setDouble(4, price);
			ps.setInt(5, stock);
			ps.setString(6, type);
			ps.executeUpdate();

			System.out.println("productId is " + pid);
			System.out.println("productName is " + name);
			System.out.println("productSize is " + size);
			System.out.println("productPrice is " + price);
			System.out.println("currentStock is " + stock);
			System.out.println("producttype is " + type);

		} catch (Exception ex) {
			System.out.println("failed: An exception occurred!" + ex);
		} finally {
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

	public List<Product> getAllProduct() {
		List<Product> products = new ArrayList<Product>();

		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			String q = "select * from product order by productid asc ";
			ResultSet rs = stmt.executeQuery(q);

			while (rs.next()) {
				Product product = new Product();

				product.setProductId(rs.getInt("productid"));
				product.setProductName(rs.getString("productname"));
				product.setProductSize(rs.getString("productsize"));
				product.setProductPrice(rs.getDouble("productprice"));
				product.setCurrentStock(rs.getInt("currentstock"));
				product.setProductType(rs.getString("producttype"));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	public void deleteProduct(String pid) {
		String searchQuery = "delete from product where productid=" + "'" + pid + "'";

		System.out.println(searchQuery);

		try {

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Product getProductById(String pid) {
		Product product = new Product();
		try {
			currentCon = ConnectionManager.getConnection();
			ps = currentCon.prepareStatement("select * from product where productid=?");

			ps.setString(1, pid);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				product.setProductId(rs.getInt("productid"));
				product.setProductName(rs.getString("productname"));
				product.setProductSize(rs.getString("productsize"));
				product.setProductPrice(rs.getDouble("productprice"));
				product.setCurrentStock(rs.getInt("currentstock"));
				product.setProductType(rs.getString("producttype"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return product;
	}

	public void updateProduct(Product product) {

		pid = product.getProductId();
		name = product.getProductName();
		size = product.getProductSize();
		price = product.getProductPrice();
		stock = product.getCurrentStock();
		type = product.getProductType();

		String searchQuery = "UPDATE product SET productprice ='" + price + "', currentstock ='" + stock + "' WHERE productid='" + pid + "'";

		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void incrementProduct(String productId, String quantity) {


		String searchQuery = "UPDATE product SET currentstock = currentstock + '"+ quantity +"' WHERE productid='" + productId + "'";
		System.out.println(searchQuery);
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void decrementProduct(String productId, String quantity) {


		String searchQuery = "UPDATE product SET currentstock = currentstock - '"+ quantity +"' WHERE productid='" + productId + "'";
		System.out.println(searchQuery);
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
