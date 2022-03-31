package healin.model;

public class Product {
	
	private int productId;
	private String productName;
	private String productSize;
	private Double productPrice;
	private int currentStock;
	private String productType;
	public boolean valid;
	
	public Product() {
		super();
	}
	
	public Product(int productId, String productName, String productSize, Double productPrice, int currentStock, String productType) {
		super();
		this.productId=productId;
		this.productName=productName;
		this.productSize=productSize;
		this.productPrice=productPrice;
		this.currentStock=currentStock;
		this.productType = productType;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId=productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName=productName;
	}
	
	public String getProductSize() {
		return productSize;
	}
	
	public void setProductSize(String productSize) {
		this.productSize=productSize;
	}
	
	public Double getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(Double productPrice) {
		this.productPrice=productPrice;
	}
	
	public int getCurrentStock() {
		return currentStock;
	}
	
	public void setCurrentStock(int currentStock) {
		this.currentStock=currentStock;
		
	}
	
	public String getProductType() {
		return productType;
	}
	
	public void setProductType(String productType) { 
		this.productType = productType;
	}
	
	public boolean isValid() {
		return valid;
	}
	
	public void setValid(boolean valid) {
		this.valid=valid;
	}

}
