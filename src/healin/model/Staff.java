package healin.model;

//import java.util.List;

public class Staff {
	
	private String staffId;
	private String staffIc;
	private String staffName;
	private String staffPhone;
	private String staffAddress;
	private String managerId;
	private String branchId;
	private String branchName;
	private String password;
	private String username;
	private String roles;
	private boolean valid;
	
	public Staff() {
		super();
	}

	public Staff(String staffId,String staffIc,String staffName, String staffPhone,String staffAddress, String managerId, String roles,String branchId,  String username, String password) {
		super();
		this.staffId = staffId;
		this.staffIc = staffIc;
		this.staffName = staffName;
		this.staffPhone = staffPhone;
		this.staffAddress= staffAddress;
		this.managerId= managerId;
		this.branchId=branchId;
		this.roles = roles;
		this.username=username;
		this.password=password;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	
	public String getStaffIc() {
		return staffIc;
	}

	public void setStaffIc(String staffIc) {
		this.staffIc = staffIc;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffAddress() {
		return staffAddress;
	}

	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}

	public String getStaffPhone() {
		return staffPhone;
	}

	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}
		
	/*public List<TeacherSubject> getTeacherSubjects() {
		return teacherSubjects;
	}

	public void setTeacherSubjects(List<TeacherSubject> teacherSubjects) {
		this.teacherSubjects = teacherSubjects;
	}*/
	
	public String getManagerId() {
		return managerId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	
	

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	
	
	
	}
