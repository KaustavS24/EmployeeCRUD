package dao.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Employee emp = new Employee();
		emp.setEmpId(rs.getLong("empId"));
		emp.setEmpName(rs.getString("empName"));
		emp.setEmpAge(rs.getInt("empAge"));
		emp.setEmpAddress(rs.getString("empAddress"));
		
		return emp;

	}


}
