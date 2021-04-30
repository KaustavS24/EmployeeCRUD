package dao;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//mport java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import dao.rowMapper.EmployeeRowMapper;
import model.Employee;
//import connectionUtil.ConnectionUtil;

public class Dao implements EmployeeDaoInt {
	
	//ConnectionUtil util = new ConnectionUtil();
	//Connection con = util.getConnection();
	
	JdbcTemplate jdbcTemplate;
	
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	public void addEmployee(Employee emp)
	{
		final String INSERT_SQL = "insert into Employee(empName,empAge,empAddress) values(:empName, :empAge, :empAddress)"; 
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("empName", emp.getEmpName());
		parameters.put("empAge", emp.getEmpAge());
		parameters.put("empAddress", emp.getEmpAddress());
		namedParameterJdbcTemplate.update(INSERT_SQL, parameters);
	}

	
	public List<Employee> getEmployee()
	{
		final String SQL_GET_ALL_EMPLOYEE = "select * from Employee";
		List <Employee> results = jdbcTemplate.query(SQL_GET_ALL_EMPLOYEE, new EmployeeRowMapper());
		return results;
	}
	

	
	public Employee getEmployeebyId(long id)
	{
		final String SQL_GET_EMPLOYEE_BY_ID = "select * from Employee where empId = :empId";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("empId", id);
		List<Employee> result = namedParameterJdbcTemplate.query(SQL_GET_EMPLOYEE_BY_ID, parameters, new EmployeeRowMapper());
		if(result != null && !result.isEmpty())
		{
			return result.get(0);
		}
		return null;
	}
	
	
	public void deleteEmployee(long id)
	{
		final String DELETE_EMPLOYEE_SQL = "delete from Employee where empId = :empId";
		Map <String, Object> parameters = new HashMap<>();
		parameters.put("empId", id);
		namedParameterJdbcTemplate.update(DELETE_EMPLOYEE_SQL, parameters);
	}
	
	
	
	
	public void updateEmployeeName(String name, long id)
	{
		final String UPDATE_EMPLOYEE_NAME_SQL = "update Employee set empName = :empName where empId = :empId";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("empName", name);
		parameters.put("empId", id);
		namedParameterJdbcTemplate.update(UPDATE_EMPLOYEE_NAME_SQL, parameters);
	}
	
	
	
	
	
	public void updateEmployeeAge(int age, long id)
	{
		final String UPDATE_EMPLOYEE_AGE_SQL = "update Employee set empAge = :empAge where empId = :empId";
		Map<String,Object> parameters = new HashMap<>();
		parameters.put("empAge", age);
		parameters.put("empId", id);
		namedParameterJdbcTemplate.update(UPDATE_EMPLOYEE_AGE_SQL, parameters);
	}
	
	
	public void updateEmployeeAddress(String address, long id)
	{
		final String UPDATE_EMPLOYEE_ADDRESS_SQL = "update Employee set empAddress = :empAddress where empId = :empId";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("empAddress", address);
		parameters.put("empId", id);
		namedParameterJdbcTemplate.update(UPDATE_EMPLOYEE_ADDRESS_SQL, parameters);
 	}
	


}
