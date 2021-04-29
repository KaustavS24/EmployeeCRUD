package main;

import controller.EmployeeControl;
import model.Employee;
import services.EmployeeServices;




public class Main {

	public static void main(String[] args) {
		EmployeeControl emc = new EmployeeControl();
		emc.handleRequest();
	}

}
