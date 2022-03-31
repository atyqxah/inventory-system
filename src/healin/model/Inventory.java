package healin.model;

import java.util.List;

public class Inventory {
	
	private String inventoryId;
	private int quantity;
	private String invdate;
	private String description;
	private String orderId;
	private String productId;
	private String productName;
	private String ordertype;
	private String orderstatus;
	private boolean valid;
	
	
	public Inventory() {
		super();
	}
	
	public Inventory(String inventoryId, String orderId, String productId, int quantity, String invdate, String description) {
		this.inventoryId = inventoryId;
		this.quantity = quantity;
		this.invdate = invdate;
		this.description = description;
		this.orderId = orderId;
		this.productId = productId;
	}
	
	public String getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getInvdate() {
		return invdate;
	}
	public void setInvdate(String invdate) {
		this.invdate = invdate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getOrdertype() {
		return ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}



	
	
	
	

}
