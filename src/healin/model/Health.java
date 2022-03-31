package healin.model;

public class Health extends Product{
	
	private String supplementType;
	private String suggestion;
	
	public Health() {
		super();
	}
	
	public Health(int productId, String productName, String productSize, Double productPrice, int currentStock, String productType, boolean valid, String supplementType, String suggestion) {
		super(productId, productName, productSize, productPrice, currentStock, productType);
		this.supplementType = supplementType;
		this.suggestion = suggestion;
	}
	
	public String getSupplementType()
	{
		return supplementType;
	}
	
	public void setSupplementType(String supplementType) 
	{
		this.supplementType = supplementType;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	
	

}
