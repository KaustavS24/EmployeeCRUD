package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import controller.EmployeeControl;
import model.Employee;
import services.EmployeeServices;



public class Main {

	public static void main(String[] args) {
		
	
		
		ApplicationContext context = new ClassPathXmlApplicationContext("NewFile.xml");
		EmployeeControl emc  = context.getBean("emc" , EmployeeControl.class);
		
		emc.handleRequest();
		
	
		
		
	}

}
