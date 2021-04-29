package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import controller.EmployeeControl;
import model.Employee;
import services.EmployeeServices;



public class Main {

	public static void main(String[] args) {
		
		//EmployeeControl emc = new EmployeeControl();
		//emc.handleRequest();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("NewFile.xml");
		EmployeeControl emc = context.getBean("emc" , EmployeeControl.class);
		emc.handleRequest();
		
		
	}

}
