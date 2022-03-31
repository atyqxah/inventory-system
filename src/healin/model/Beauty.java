package healin.model;

public class Beauty extends Product{
	
	private String makeupType;
	private String direction;
	
	public Beauty() {
		super();
	}
	
	public Beauty(int productId, String productName, String productSize, Double productPrice, int currentStock, String productType, boolean valid, String makeupType, String direction) {
		super(productId, productName, productSize, productPrice, currentStock, productType);
		this.makeupType=makeupType;
		this.direction = direction;
	}

	public String getMakeupType() {
		return makeupType;
	}

	public void setMakeupType(String makeupType) {
		this.makeupType = makeupType;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	

}
