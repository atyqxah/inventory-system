package healin.model;

import java.util.List;

public class Branch {
	
	private String branchId;
	private String branchAddress;
	private String branchPhone;
	private String branchName;
	private List<Staff> staff;
	public boolean valid;
	
	public Branch() {
		super();
	}
	
	public Branch( String branchAddress, String branchPhone, String branchName) {
		super();
		//this.branchId = branchId;
		this.branchAddress = branchAddress;
		this.branchPhone = branchPhone;
		this.branchName = branchName;
	}
	
	public String getBranchId() {
		return branchId;
	}
	
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	
	public String getBranchAddress() {
		return branchAddress;
	}
	
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
	
	public String getBranchPhone() {
		return branchPhone;
	}
	
	public void setBranchPhone(String branchPhone) {
		this.branchPhone = branchPhone;
	}
	
	public String getBranchName() {
		return branchName;
	}
	
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	public boolean isValid() {
		return valid;
	}
	
	public void setValid(boolean valid) {
		this.valid=valid;
	}

	public List<Staff> getStaff() {
		return staff;
	}

	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}
	
	

}

