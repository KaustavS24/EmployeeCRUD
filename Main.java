package Main;

import Controller.EmployeeControl;
import Model.Employee;
import Services.EmployeeServices;




public class Main {

	public static void main(String[] args) {
		EmployeeControl emc = new EmployeeControl();
		emc.handleRequest();
	}

}
