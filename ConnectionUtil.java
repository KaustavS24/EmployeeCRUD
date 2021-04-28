package connectionUtil;

import java.sql.*;

public class ConnectionUtil {
	
	String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	String username = "system";
	String password = "1234";
	
	public Connection getConnection()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, username, password);
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Cannot connect to database.");
			e.printStackTrace();
		}
		return null;
	}

}
