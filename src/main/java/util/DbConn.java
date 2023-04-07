package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {

		
		public static Connection getConnection() 
		{
			Connection con = null;
			try {
//				Class.forName("com.mysql.jdbc.Driver");
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/meet", "root", "root");
				con = DriverManager.getConnection("jdbc:sqlserver://localhost:58896;DatabaseName=ROYAL;trustServerCertificate=true;", "sa","root");			
				 		
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return con;

		}
	}
