package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.UserBean;
import util.DbConn;

public class UserDAO {

	public void addUser(UserBean bean)
	{
		Connection con = null;
		
		try {
			
			con = DbConn.getConnection();
//			System.out.println("con : "+con);
			PreparedStatement ps = con.prepareStatement("INSERT INTO UserCrud(firstName,lastName,email,password,city,gender,hobby1,hobby2,hobby3) VALUES(?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, bean.getFirstName());
			ps.setString(2, bean.getLastName());
			ps.setString(3, bean.getEmail());
			ps.setString(4, bean.getPassword());
			ps.setString(5, bean.getCity());
			ps.setString(6, bean.getGender());
			ps.setString(7, bean.getHobby1());
			ps.setString(8, bean.getHobby2());
			ps.setString(9, bean.getHobby3());
			
			int recordAffected = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public UserBean authenticate(String email,String password)
	{
		UserBean bean = null;
		
		Connection con = null;
		
		try 
		{
			con = DbConn.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM UserCrud WHERE email=? and password=?");

			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				bean = new UserBean();
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setCity(rs.getString("city"));
				bean.setHobby1(rs.getString("hobby1"));
				bean.setHobby2(rs.getString("hobby2"));
				bean.setHobby3(rs.getString("hobby3"));
				
			}
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
			try 
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return bean;
	}
	
	public ArrayList<UserBean> getAllUsers()
	{
		
		ArrayList<UserBean> list = new ArrayList<>();
		Connection con = null;
		
		try {
			
			con = DbConn.getConnection();
			PreparedStatement ps = con.prepareStatement("Select * from userCrud");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				UserBean bean = new UserBean();
				
				bean.setUserId(rs.getInt("userId"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setCity(rs.getString("city"));
				bean.setGender(rs.getString("gender"));
				bean.setHobby1(rs.getString("hobby1"));
				bean.setHobby2(rs.getString("hobby2"));
				bean.setHobby3(rs.getString("hobby3"));
				
				list.add(bean);
				
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return list;
	}


	public ArrayList<UserBean> search(String searchData) {

		ArrayList<UserBean> searchlist = new ArrayList<>();
		
		Connection con = null;
		
		
		try {
			
			con = DbConn.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from UserCrud where firstName like ?");
			ps.setString(1, searchData+"%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				UserBean bean = new UserBean();
				
				bean.setUserId(rs.getInt("userId"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setCity(rs.getString("city"));
				bean.setGender(rs.getString("gender"));
				bean.setHobby1(rs.getString("hobby1"));
				bean.setHobby2(rs.getString("hobby2"));
				bean.setHobby3(rs.getString("hobby3"));
				
				searchlist.add(bean);
			}			
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	
		return searchlist;
	}


	public void deleteUser(Integer userId) {

		Connection con =null;
		
		try 
		{	
			con = DbConn.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM UserCrud WHERE userId = ?");
			
			ps.setInt(1, userId);
			
			ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	public UserBean getUserById(Integer userId) {

		UserBean bean =null;
		Connection con = null;
		
		try {
			
			con = DbConn.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from UserCrud WHERE userId = ?");
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				bean = new UserBean();
				
				bean.setUserId(rs.getInt("userId"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setCity(rs.getString("city"));
				bean.setGender(rs.getString("gender"));
				bean.setHobby1(rs.getString("hobby1"));
				bean.setHobby2(rs.getString("hobby2"));
				bean.setHobby3(rs.getString("hobby3"));
			}			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
			try 
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return bean;
	}


	public void UpdateUser(UserBean bean) {
		
//		System.out.println("----------id---------- : "+bean.getUserId());
				
		Connection con = null;
		
		try 
		{
			con = DbConn.getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE UserCrud SET firstName=?, "
					+ "lastName=?, email=?, password=?, city=?, gender=?, "
					+ "hobby1=?, hobby2=?, hobby3=? WHERE userId=?");
			
			ps.setString(1, bean.getFirstName());
			ps.setString(2, bean.getLastName());
			ps.setString(3, bean.getEmail());
			ps.setString(4, bean.getPassword());
			ps.setString(5, bean.getCity());
			ps.setString(6, bean.getGender());
			ps.setString(7, bean.getHobby1());
			ps.setString(8, bean.getHobby2());
			ps.setString(9, bean.getHobby3());
			ps.setInt(10, bean.getUserId());
			
			ps.executeUpdate();
			
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
			try 
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
	}
	
}
