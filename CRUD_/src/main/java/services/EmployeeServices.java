package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Employee;
import dao.Dao;



public class EmployeeServices {
	
	private static HashMap<Long, Employee> empMap = new HashMap<Long, Employee>();
	Dao dao = new Dao();
	Long empIdCounter = dao.getLastEmployeeId();
	
	//private static long empIdCounter = 1000;
	
	public long addEmployee(Employee employee) 
	{
		long lastId = dao.getLastEmployeeId();
		employee.setEmpId(++lastId);
		
		//empMap.put(empIdCounter, employee);
		//empIdCounter++;
		
		
		return dao.addEmployee(employee);
	}
	
	public String getEmployee()
	{
		empMap = dao.getEmployee();
		List<Employee> list = new ArrayList<Employee>(empMap.values());
		return list.toString();
	}
	
	public Employee searchById(long id)
	{
		//if(empMap.containsKey(id))
		//{
			//return empMap.get(id);
		//}
		//return null;
		
		Employee em = new Employee();
		em = dao.getEmployeebyId(id);
		return em;
	}
	
	public boolean deleteEmployee(long id)
	{
		//if(empMap.containsKey(id))
		//{
			//empMap.remove(id);
			//return true;
		//}
		//return false;
		
		boolean rs = dao.deleteEmployee(id);
		return rs;
	}
	
	public long updatEmployeeName(String name, long id)
	{
		//if (empMap.containsKey(id))
		//{
			//empMap.get(id).setEmpName(name);
			//return empMap.get(id).getEmpId();
		//}
		//return 0;
		
		boolean rs = dao.updateEmployeeName(name, id);
		if (rs)
		{
			return id;
		}
		else
		{
			return 0;
		}
	}
	
	public long updatEmployeeAge(int age, long id)
	{
		//if (empMap.containsKey(id))
		//{
			//empMap.get(id).setEmpAge(age);;
			//return empMap.get(id).getEmpId();
		//}
		//return 0;
		
		Boolean rs = dao.updateEmployeeAge(age, id);
		if (rs)
		{
			return id; 
		}
		else
		{
			return 0;
		}
	}
	
	public long updatEmployeeAddress(String address, long id)
	{
		//if (empMap.containsKey(id))
		//{
			//empMap.get(id).setEmpAddress(address);;
			//return empMap.get(id).getEmpId();
		//}
		//return 0;
		
		boolean rs = dao.updateEmployeeAddress(address, id);
		if (rs)
		{
			return id;
		}
		else
		{
			return 0;
		}
	}

}
