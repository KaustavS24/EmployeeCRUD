package com.Employee;

import java.util.List;
import java.util.Scanner;

public class Employee {
	
	Scanner sc = new Scanner (System.in);
	  private int empId;
	  private String empName;
	  private int empAge;
	  private String empAddress;
	 
	public Employee(List<Employee> emp) {
		
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public int getEmpAge() {
		return empAge;
	}


	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}


	public String getEmpAddress() {
		return empAddress;
	}


	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	
	public void addE ()
	{
		System.out.print("Enter your Name - ");
		String n = sc.nextLine();
		if (n != "")
		{
			empName = n;
		}
		else
		{
			System.out.println("Invalid input");
			addE();
		}
		
		System.out.println("Enter your age - ");
		int a = sc.nextInt();
		if (a != 0)
		{
			empAge = a;
		}
		else
		{
			System.out.println("Invalid input");
			addE();
		}
	
		System.out.println("Enter your Address - ");
		String b = sc.next();
		if (b != "")
		{
			empAddress = b;
		}
		else
		{
			System.out.println("Invalid input");
			addE();
		}
		
	
		
	}
	
	public void update()
	{
		System.out.println("Enter your Emp id - ");
		empId = sc.nextInt();
		System.out.println("Enter 1 to update name, 2 to age, 3 to address - ");
		int up = sc.nextInt();
		if (up > 3 && up < 1)
		{
			switch(up)
			{
				case 1:
					System.out.println("Enter the new name - ");
					String nam = sc.next();
					if (nam != "")
					{
						empName = nam;
					}
					else
					{
						System.out.println("Invalid input");
						update();
					}
					
					
				case 2:
					System.out.println("Enter the new age - ");
					int ag = sc.nextInt();
					if (ag > 0 )
					{
						empAge = ag;
					}
					else
					{
						System.out.println("Invalid input");
						update();
					}
					
					
				case 3:
					System.out.println("Enter the new address - ");
					String ad = sc.next();
					if (ad != "" )
					{
						empAddress = ad;
					}
					else
					{
						System.out.println("Invalid input");
						update();
					}
					
				default:
					System.out.println("Invalid input");
			}
			update();
			
		}
		else
		{
			System.out.println("Invalid input.");
			update();
		}
		
		
		
	}
	
	public void delete ()
	{
		System.out.println("Enter your emp id - ");
		int eId = sc.nextInt();
		empId = eId;
	
	}
	public void get()
	{
		
	}
	
}
