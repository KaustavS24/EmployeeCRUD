package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Employee;
import dao.Dao;
import dao.EmployeeDaoInt;



public class EmployeeServices implements EmployeeServicesInt {
	
	//private static HashMap<Long, Employee> empMap = new HashMap<Long, Employee>();
	EmployeeDaoInt dao;;
	
	
	public void setDao(EmployeeDaoInt dao) {
		this.dao = dao;
	}

	public void addEmployee(Employee employee) 
	{
		
		dao.addEmployee(employee);
	}
	
	public List<Employee> getEmployee()
	{
		List<Employee> list = dao.getEmployee();
		return list;
		
		
	}
	
	public Employee getEmployeebyId(long id) {
		Employee em = dao.getEmployeebyId(id);
		return em;
		
	}
	
	public void deleteEmployee(long id)
	{
		
		
		 dao.deleteEmployee(id);
		
	}
	
	public void updateEmployeeName(String name, long id)
	{
		
		dao.updateEmployeeName(name, id);
		
	}
	
	public void updateEmployeeAge(int age, long id)
	{
	
		
		dao.updateEmployeeAge(age, id);
		
	}
	
	public void updateEmployeeAddress(String address, long id)
	{
		
		dao.updateEmployeeAddress(address, id);
	}



	
	



	

}
