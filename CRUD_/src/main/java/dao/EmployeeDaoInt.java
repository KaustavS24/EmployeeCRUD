package dao;

import java.util.List;

import model.Employee;

public interface EmployeeDaoInt {
	
	void addEmployee(Employee emp);
	
	List<Employee> getEmployee();
	
	Employee getEmployeebyId(long id);
	
	void deleteEmployee(long id);
	
	void updateEmployeeName(String name, long id);
	
	void updateEmployeeAge(int age, long id);
	
	void updateEmployeeAddress(String address, long id);

}
