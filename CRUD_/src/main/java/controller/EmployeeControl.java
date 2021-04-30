package controller;

import java.util.List;
import java.util.Scanner;

import dao.EmployeeDaoInt;
import services.EmployeeServices;
import services.EmployeeServicesInt;
import model.Employee;

public class EmployeeControl {

		Scanner s = new Scanner(System.in);
	

		EmployeeServicesInt emp;
		public void setEmp(EmployeeServicesInt emp) {
			this.emp = emp;
		}

		public void addEmployee()
		{
			try
			{
				System.out.print("Enter your name - ");
				String name = s.nextLine();
				System.out.print("Enter your age - ");
				int age = s.nextInt(); s.nextLine();
				System.out.print("Enter your address - ");
				String address = s.nextLine();
				System.out.println();
				
				
				Employee e = new Employee();
				e.setEmpName(name);
				e.setEmpAge(age);
				e.setEmpAddress(address);
				//return emp.addEmployee(e);
				
				emp.addEmployee(e);
			}
			catch(Exception e)
			{
				//System.out.print("Add did not immplement");
				e.printStackTrace();
			}
			
			
		}
		
		public List<Employee> displayallEmployees()
		{
		
			List<Employee> list = emp.getEmployee();
			return list;
			//	return emp.getEmployee();
		}
		
		public Employee displayEmployeeById()
		{
			try
			{
				System.out.print("Enter your employee id - ");
				String id = s.nextLine();
				return emp.getEmployeebyId(Long.parseLong(id));
			}
			catch(Exception e)
			{
				System.out.print("Display method did not implement.");
			}
			return null;
		}
		
		public void deleteEmployee()
		{
			try
			{
				System.out.print("Enter employee id - ");
				String id = s.nextLine();
				emp.deleteEmployee(Long.parseLong(id));
			}
			catch(Exception e)
			{
				System.out.print("Delete operation did not implement.");
			}
	
		}
		
		public void updateDetails()
		{
			boolean temp = true;
			System.out.print("Enter your employee id to update details - ");
			String id = s.nextLine();
			long longId = Long.MIN_VALUE;
			
			while (temp)
			{
				System.out.print("Enter the fields you want to update - 1. Name 2.Age 3.Address 4. To End process");
				String rawChoice = s.nextLine();
				int choice = Integer.MIN_VALUE;
				try
				{
					longId = Long.parseLong(id);
					choice = Integer.parseInt(rawChoice);
					
					switch(choice)
					{
						case 1:
							System.out.print("Enter the updated name - ");
							String uName = s.nextLine();
							emp.updateEmployeeName(uName, longId);
							System.out.println("Name updated for " + longId);
							break;
							//long updatedNameId = emp.updatEmployeeName(uName, longId);
							//if (updatedNameId != 0)
							//{
								//System.out.println("Name is updated for employee id " + updatedNameId);
							//}
							//else
						//	{
							//	System.out.println("Employee not found.");
							//}
							
						case 2:
							System.out.println("Enter the updated age - ");
							String uAge = s.nextLine();
							emp.updateEmployeeAge(Integer.parseInt(uAge), longId);
							System.out.println("Age updated for " + longId);
							break;
							//long updatedAgeId = emp.updatEmployeeAge(Integer.parseInt(uAge), longId);
							//if (updatedAgeId != 0)
							//{
								//System.out.print("Age has been updated for employee id " + updatedAgeId);
							//}
							//else
							//{
								//System.out.print("Employee not present");
							//}
						case 3:
							System.out.println("Enter the updated address - ");
							String address = s.nextLine();
							emp.updateEmployeeAddress(address, longId);
							System.out.println("Address updated for " + longId);
							break;
							//long updatedAddressId = emp.updatEmployeeAddress(address, longId);
							//if (updatedAddressId != 0)
							//{
								//System.out.print("Address is changed for employee id " + updatedAddressId);
							//}
							//else
							//{
								//System.out.print("Employee not found");
							//}
						case 4:
							temp = false;
							break;
						default:
							break;
								
					}
				}
				catch(Exception e)
				{
					System.out.print("Wrong input. To return enter 1, enter to terminate process -  ");
					rawChoice = s.nextLine();
					
					try
					{
						choice = Integer.parseInt(rawChoice);
					}
					catch(Exception ex)
					{
						temp = false;
					}
					
					switch(choice)
					{
						case 1:
							temp = true;
							break;
						default:
							temp = false;
							break;
					}
				}
			}
		}
		
		public void handleRequest()
		{
			System.out.print("Welcome to Employee Database Portal...");
			System.out.println();
					
			boolean temp1 = true;
			
			while (temp1)
			{
				System.out.println("Enter 1 to Add Employee, 2 to Display Employees, 3 to Search Employee by ID, 4 to Delete Employee, 5 to Update Employee Details, 6 to Terminate Process.");
				String rawChoice1 = s.nextLine();
				System.out.println("Your choice is " + rawChoice1);
				int choice1 = Integer.MIN_VALUE;
				
				
				try
				{
					choice1 = Integer.parseInt(rawChoice1);
					switch(choice1)
					{
						case 1:
							addEmployee();
							System.out.print("employee details added");
							System.out.println();
							break;
							
						case 2:
							
							List<Employee> list = displayallEmployees();
							for (Employee display : list)
							{
								System.out.println(display);
							}
							//System.out.println(displayallEmployees());
							//System.out.println();
							break;
							
						case 3:
							Employee search = displayEmployeeById();
							if (search != null)
							{
								System.out.print(search);
								System.out.println();
							}
							else
							{
								System.out.println("Employee not present.");
							}
							break;
							
						case 4:
							deleteEmployee();
							//{
							System.out.println("Employee details has been deleted.");
							//}
							//else
							//{
								//System.out.println("Employee not found.");
							//}
							break;
							
						case 5:
							updateDetails();
							System.out.println();
							break;
							
						case 6:
							
							temp1 = false;
							break;
							
						default:
							break;
								
					}
				}
				catch(Exception exe)
				{
					System.out.println("Invalid input. Press 1 to Go Back, Enter to Terminate.");
					rawChoice1 = s.nextLine();
					
					
					try
					{
						choice1 = Integer.parseInt(rawChoice1);
					}
					catch(Exception exce)
					{
						temp1 = false;
					}
					switch(choice1)
					{
						case 1:
							temp1 = true;
							break;
						default:
							temp1 = false;
							break;
					}
					
				}
				
				
			}
			s.close();
			
		}

	}



