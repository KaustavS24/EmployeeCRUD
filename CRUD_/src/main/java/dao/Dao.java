package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import model.Employee;
import connectionUtil.ConnectionUtil;

public class Dao {
	
	ConnectionUtil util = new ConnectionUtil();
	Connection con = util.getConnection();
	
	
	public long addEmployee(Employee emp)
	{
		try
		{
			String query = "insert into Employee values(?,?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setLong(1, emp.getEmpId());
			st.setString(2, emp.getEmpName());
			st.setInt(3, emp.getEmpAge());
			st.setString(4, emp.getEmpAddress());
			
			int count = st.executeUpdate();
			if (count != 0)
			{
				return emp.getEmpId();
			}
		}
		catch(Exception ex)
		{
			System.out.println("Cannont insert details.");
		}
		return 0;
		
	}
	
	public HashMap<Long, Employee> getEmployee()
	{
		HashMap<Long, Employee> empMap = new HashMap<>();
		Employee em = new Employee();
		
		try
		{
			String query = "select * from Employee";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				em.setEmpId(rs.getLong(1));
				em.setEmpName(rs.getString(2));
				em.setEmpAge(rs.getInt(3));
				em.setEmpAddress(rs.getString(4));
				
				empMap.put(em.getEmpId(), em);
			}
			
			return empMap;
		}
		catch(Exception ex)
		{
			System.out.println("Error");
		}
		return null;
		
	}
	
	public Employee getEmployeebyId(long id)
	{
		Employee em = new Employee();
		
		try
		{
			String query = "select * from Employee where empId=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setLong(1, id);
			
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				em.setEmpId(rs.getLong(1));
				em.setEmpName(rs.getString(2));
				em.setEmpAge(rs.getInt(3));
				em.setEmpAddress(rs.getString(4));
			}
			return em;
		}
		catch(Exception e)
		{
			System.out.println("Error occured");
		}
		return null;
		
	}
	
	public boolean deleteEmployee(long id)
	{
		
		try {
			String query = "select * from Employee where empId=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setLong(1, id);
			
			int rs = st.executeUpdate();
			if(rs != 0)
			{
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error occured.");
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean updateEmployeeName(String name, long id)
	{
		try 
		{
			String query = "update Employee set empName=? where empId=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, name);
			st.setLong(2, id);
			int rs = st.executeUpdate();
			if(rs!=0)
			{
				return true;
			}
		}
		catch (Exception e) 
		{
			System.out.println("Error Occurred.");
		}
		return false;
	}
	
	public boolean updateEmployeeAge(int age, long id)
	{
		try 
		{
			String query = "update Employee set empAge=? where empId=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, age);
			st.setLong(2, id);
			int rs = st.executeUpdate();
			if(rs!=0)
			{
				return true;
			}
		}
		catch (Exception e) 
		{
			System.out.println("Error Occurred.");
		}
		return false;
	}
	
	public boolean updateEmployeeAddress(String address, long id)
	{
		try 
		{
			String query = "update Employee set empAddress=? where empId=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, address);
			st.setLong(2, id);
			int rs = st.executeUpdate();
			if(rs!=0)
			{
				return true;
			}
		}
		catch (Exception e) 
		{
			System.out.println("Error Occurred.");
		}
		return false;
	}
	
	public long getLastEmployeeId()
	{
		long id = 1000;
		try 
		{
			String query = "select empId from Employee where rownum <=1 order by empId desc";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				id = rs.getLong(1);
			}
			return id;
		} 
		catch (SQLException e)
		{
			System.out.println("Error Occurred.");
		}
		return 0;
	}

}
