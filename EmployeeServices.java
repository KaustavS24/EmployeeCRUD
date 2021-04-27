package Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Model.Employee;



public class EmployeeServices {
	
	private static HashMap<Long, Employee> empMap = new HashMap<Long, Employee>();
	private static long empIdCounter = 1000;
	
	public long addEmployee(Employee employee) 
	{
		employee.setEmpId(empIdCounter);
		empMap.put(empIdCounter, employee);
		empIdCounter++;
		return employee.getEmpId();
	}
	
	public String getEmployee()
	{
		List<Employee> list = new ArrayList<Employee>(empMap.values());
		return list.toString();
	}
	
	public Employee searchById(long id)
	{
		if(empMap.containsKey(id))
		{
			return empMap.get(id);
		}
		return null;
	}
	
	public boolean deleteEmployee(long id)
	{
		if(empMap.containsKey(id))
		{
			empMap.remove(id);
			return true;
		}
		return false;
	}
	
	public long updatEmployeeName(String name, long id)
	{
		if (empMap.containsKey(id))
		{
			empMap.get(id).setEmpName(name);
			return empMap.get(id).getEmpId();
		}
		return 0;
	}
	
	public long updatEmployeeAge(int age, long id)
	{
		if (empMap.containsKey(id))
		{
			empMap.get(id).setEmpAge(age);;
			return empMap.get(id).getEmpId();
		}
		return 0;
	}
	
	public long updatEmployeeAddress(String address, long id)
	{
		if (empMap.containsKey(id))
		{
			empMap.get(id).setEmpAddress(address);;
			return empMap.get(id).getEmpId();
		}
		return 0;
	}

}
