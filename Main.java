package com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Employee.Employee;

public class Main 
{
	Scanner s = new Scanner(System.in);
	List <Employee> emp = new ArrayList();
	Employee emp1 = new Employee(emp);
	int var;
	public void menu()
	{
		while (var > 4 || var <1) 
		{
			System.out.println("Enter 1,2,3,4 to ADD, UPDATE, DELETE and GET");
			var = s.nextInt();
		
			try
			{
				switch(var)
				{
					case 1:
						emp1.addE();
						menu();
					case 2 :
						emp1.update();
						menu();
					case 3:
						emp1.delete();
						menu();
					case 4:
						emp1.get();
						menu();
					default:
						System.out.println("Invalid input");
						menu();
				}
				
			}
			catch (Exception E)
			{
				
			}
		}
	}


	public static void main(String[] args) {
		
	  Main obj = new Main();
	  obj.menu();
	
		
		
		

	}

}
