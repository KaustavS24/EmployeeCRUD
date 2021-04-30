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

	//public long addEmployee(Employee emp)
	//{
		//try
		//{
			//String query = "insert into Employee values(?,?,?,?)";
			//PreparedStatement st = con.prepareStatement(query);
			//st.setLong(1, emp.getEmpId());
			//st.setString(2, emp.getEmpName());
			//st.setInt(3, emp.getEmpAge());
			//st.setString(4, emp.getEmpAddress());
			
			//int count = st.executeUpdate();
			//if (count != 0)
			//{
				//return emp.getEmpId();
			//}
		//}
		//catch(Exception ex)
		//{
			//System.out.println("Cannont insert details.");
	//	}
		//return 0;
		
	//}
	
	public List<Employee> getEmployee()
	{
		final String SQL_GET_ALL_EMPLOYEE = "select * from Employee";
		List <Employee> results = jdbcTemplate.query(SQL_GET_ALL_EMPLOYEE, new EmployeeRowMapper());
		return results;
	}
	
	//public HashMap<Long, Employee> getEmployee()
	//{
		//HashMap<Long, Employee> empMap = new HashMap<>();
		//Employee em = new Employee();
		
		//try
		//{
			//String query = "select * from Employee";
			//PreparedStatement st = con.prepareStatement(query);
			//ResultSet rs = st.executeQuery(query);
			//while(rs.next())
			//{
				//em.setEmpId(rs.getLong(1));
				//em.setEmpName(rs.getString(2));
				//em.setEmpAge(rs.getInt(3));
				//em.setEmpAddress(rs.getString(4));
				
			//	empMap.put(em.getEmpId(), em);
		//	}
			
			//return empMap;
		//}
		//catch(Exception ex)
		//{
			//System.out.println("Error");
		//}
		//return null;
		
	//}
	
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
	
	//public Employee getEmployeebyId(long id)
	//{
		//Employee em = new Employee();
		
		//try
		//{
			//String query = "select * from Employee where empId=?";
			//PreparedStatement st = con.prepareStatement(query);
			//st.setLong(1, id);
			
			//ResultSet rs = st.executeQuery();
			//while(rs.next())
			//{
				//em.setEmpId(rs.getLong(1));
				//em.setEmpName(rs.getString(2));
				//em.setEmpAge(rs.getInt(3));
				//em.setEmpAddress(rs.getString(4));
			//}
		//	return em;
	//	}
		//catch(Exception e)
		//{
		//	System.out.println("Error occured");
	//	}
		//return null;
		
	//}
	
	public void deleteEmployee(long id)
	{
		final String DELETE_EMPLOYEE_SQL = "delete from Employee where empId = :empId";
		Map <String, Object> parameters = new HashMap<>();
		parameters.put("empId", id);
		namedParameterJdbcTemplate.update(DELETE_EMPLOYEE_SQL, parameters);
	}
	
	
	//public boolean deleteEmployee(long id)
	//{
		
		//try {
			//String query = "select * from Employee where empId=?";
			//PreparedStatement st = con.prepareStatement(query);
			//st.setLong(1, id);
			
			//int rs = st.executeUpdate();
			//if(rs != 0)
			//{
				//return true;
			//}
//		} catch (SQLException e) {
	//		System.out.println("Error occured.");
			//e.printStackTrace();
		//}
		//return false;
		
	//}
	
	public void updateEmployeeName(String name, long id)
	{
		final String UPDATE_EMPLOYEE_NAME_SQL = "update Employee set empName = :empName where empId = :empId";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("empName", name);
		parameters.put("empId", id);
		namedParameterJdbcTemplate.update(UPDATE_EMPLOYEE_NAME_SQL, parameters);
	}
	
	
	
	//public boolean updateEmployeeName(String name, long id)
	//{
		//try 
		//{
			//String query = "update Employee set empName=? where empId=?";
			//PreparedStatement st = con.prepareStatement(query);
			//st.setString(1, name);
			//st.setLong(2, id);
			//int rs = st.executeUpdate();
			//if(rs!=0)
			//{
				//return true;
			//}
		//}
		//catch (Exception e) 
	//	{
		//	System.out.println("Error Occurred.");
		//}
		//return false;
	//}
	
	public void updateEmployeeAge(int age, long id)
	{
		final String UPDATE_EMPLOYEE_AGE_SQL = "update Employee set empAge = :empAge where empId = :empId";
		Map<String,Object> parameters = new HashMap<>();
		parameters.put("empAge", age);
		parameters.put("empId", id);
		namedParameterJdbcTemplate.update(UPDATE_EMPLOYEE_AGE_SQL, parameters);
	}
	//public boolean updateEmployeeAge(int age, long id)
	//{
		//try 
		//{
			//String query = "update Employee set empAge=? where empId=?";
			//PreparedStatement st = con.prepareStatement(query);
			//st.setInt(1, age);
			//st.setLong(2, id);
			//int rs = st.executeUpdate();
			//if(rs!=0)
			//{
				//return true;
			//}
		//}
		//catch (Exception e) 
		//{
			//System.out.println("Error Occurred.");
		//}
		//return false;
	//}
	
	public void updateEmployeeAddress(String address, long id)
	{
		final String UPDATE_EMPLOYEE_ADDRESS_SQL = "update Employee set empAddress = :empAddress where empId = :empId";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("empAddress", address);
		parameters.put("empId", id);
		namedParameterJdbcTemplate.update(UPDATE_EMPLOYEE_ADDRESS_SQL, parameters);
 	}
	
	//public boolean updateEmployeeAddress(String address, long id)
	//{
	//	try 
		//{
			//String query = "update Employee set empAddress=? where empId=?";
			//PreparedStatement st = con.prepareStatement(query);
			//st.setString(1, address);
			//st.setLong(2, id);
			//int rs = st.executeUpdate();
			//if(rs!=0)
		//	{
			//	return true;
			//}
	//	}
		//catch (Exception e) 
		//{
			//System.out.println("Error Occurred.");
		//}
		//return false;
	//}
	
	//public long getLastEmployeeId()
	//{
		//long id = 0;
		//try 
		//{
			//String query = "select empId from Employee where rownum <=1 order by empId desc";
			//PreparedStatement st = con.prepareStatement(query);
			//ResultSet rs = st.executeQuery();
			//while(rs.next())
			//{
				//id = rs.getLong(1);
			//}
		//	return id;
		//}
		//catch (SQLException e)
	//	{
		//	System.out.println("Error Occurred.");
		//}
		//return 0;
	//}

}
