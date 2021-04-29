package model;

public class Employee {
	private long EmpId;
	private String empName;
	private int empAge;
	private String empAddress;
	
	public void setEmpId(long empId) {
		EmpId = empId;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public long getEmpId() {
		return EmpId;
	}
	public String getEmpName() {
		return empName;
	}
	public int getEmpAge() {
		return empAge;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	
	public String toString()
	{
		return EmpId + " " + empName + " " + empAge + " " + empAddress;
	}
	
	
	
	

}

