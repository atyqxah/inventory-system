package healin.model;

import java.util.List;

import healin.model.Inventory;

public class Orders {
	
	private int orderId;
	private String ordertype;
	private String orderstatus;
	private String staffId;
	private List<Inventory> inventorys;
	public boolean valid;
	
	public Orders(){
		super();
	}
	
	public Orders(int orderId, String ordertype, String orderstatus, String staffId) {
		this.orderId = orderId;
		this.ordertype = ordertype;
		this.orderstatus = orderstatus;
		this.staffId = staffId;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	

	public String getOrdertype() {
		return ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
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
		this.valid=valid;
	}

	public List<Inventory> getInventorys() {
		return inventorys;
	}

	public void setInventorys(List<Inventory> inventorys) {
		this.inventorys = inventorys;
	}
	
	

}
