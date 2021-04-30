package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Employee;
import dao.Dao;
import dao.EmployeeDaoInt;



public class EmployeeServices implements EmployeeDaoInt {
	
	//private static HashMap<Long, Employee> empMap = new HashMap<Long, Employee>();
	EmployeeDaoInt dao;;
	
	

	
	
	//private static long empIdCounter = 1000;
	
	public void setDao(EmployeeDaoInt dao) {
		this.dao = dao;
	}

	public void addEmployee(Employee employee) 
	{
		//Long empIdCounter = dao.getLastEmployeeId();
		//long lastId = dao.getLastEmployeeId();
		//employee.setEmpId(++lastId);
		
		//empMap.put(empIdCounter, employee);
		//empIdCounter++;
		
		
		dao.addEmployee(employee);
	}
	
	public List<Employee> getEmployee()
	{
		List<Employee> list = dao.getEmployee();
		return list;
		
		//empMap = dao.getEmployee();
		//List<Employee> list = new ArrayList<Employee>(empMap.values());
		//return list.toString();
	}
	
	public Employee getEmployeebyId(long id) {
		Employee em = dao.getEmployeebyId(id);
		return em;
		
	}
	
	public void deleteEmployee(long id)
	{
		//if(empMap.containsKey(id))
		//{
			//empMap.remove(id);
			//return true;
		//}
		//return false;
		
		 dao.deleteEmployee(id);
		
	}
	
	public void updateEmployeeName(String name, long id)
	{
		//if (empMap.containsKey(id))
		//{
			//empMap.get(id).setEmpName(name);
			//return empMap.get(id).getEmpId();
		//}
		//return 0;
		
		dao.updateEmployeeName(name, id);
		//if (rs)
		//{
			//return id;
		//}
		//else
		//{
			//return 0;
		//}
	}
	
	public void updateEmployeeAge(int age, long id)
	{
		//if (empMap.containsKey(id))
		//{
			//empMap.get(id).setEmpAge(age);;
			//return empMap.get(id).getEmpId();
		//}
		//return 0;
		
		dao.updateEmployeeAge(age, id);
		//if (rs)
		//{
			//return id; 
	//	}
		//else
		//{
			//return 0;
		//}
	}
	
	public void updateEmployeeAddress(String address, long id)
	{
		//if (empMap.containsKey(id))
		//{
			//empMap.get(id).setEmpAddress(address);;
			//return empMap.get(id).getEmpId();
		//}
		//return 0;
		
		dao.updateEmployeeAddress(address, id);
	//	if (rs)
		//{
		//	return id;
		//}
		//else
		//{
			//return 0;
		//}
	}



	
	



	

}
