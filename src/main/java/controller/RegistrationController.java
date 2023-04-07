package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import bean.UserBean;
import dao.UserDAO;
import util.DbConn;
@WebServlet("/registration")
public class RegistrationController extends HttpServlet {

		public void init()
		{
			System.out.println("RegistrationController :: init()");
		}
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
		{
		
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String confirmPassword = req.getParameter("confirmPassword");
			String city = req.getParameter("city");
			String gender = req.getParameter("gender");
			String hobby1 = req.getParameter("cricket");
			String hobby2 = req.getParameter("badminton");
			String hobby3 = req.getParameter("photography");
			
			
			System.out.println("FirstName : " + firstName);
			System.out.println("LastName : " + lastName);
			System.out.println("Email : " + email);
			System.out.println("Password : " + password);
			System.out.println("Confirm Password : "+confirmPassword);
			System.out.println("City : "+city);
			System.out.println("Gender : "+gender);
			System.out.println("Hobby1 : "+hobby1);
			System.out.println("Hobby2 : "+hobby2);
			System.out.println("Hobby3 : "+hobby3);
			
			
			
			StringBuffer error = new StringBuffer();
			
			StringBuffer hobby = new StringBuffer("Hobbies are : ");
						
			boolean isError = false;
			
			
			System.out.println("RegistrationController :: doPost()");
			
			UserBean bean = new UserBean();
		
			bean.setFirstName(firstName);
			
			bean.setLastName(lastName);
		
			bean.setEmail(email);
			
			bean.setPassword(password);
			
			bean.setCity(city);
			
			bean.setGender(gender);
			
			if(hobby1 != null)
				{
					bean.setHobby1(hobby1);
				}
			if(hobby2 != null)
				{
					bean.setHobby2(hobby2);
				}
			if(hobby3 != null)
				{
					bean.setHobby3(hobby3);
				}
				
			UserDAO userdao = new UserDAO();
			userdao.addUser(bean);
			resp.getWriter().print("Record Inserted Successfully...!");
			
			RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
//			resp.sendRedirect("Login.jsp");
			
			
		
//				req.setAttribute("hobby", hobby.toString());
				
//				UserDAO userdao = new UserDAO();
				
//				userdao.addUser(bean);
				resp.getWriter().print("Record Inserted Successfully...! 2nd time");
			
		}
		public void destroy()
		{
			System.out.println("RegistrationController::Destroy()");
		}
}