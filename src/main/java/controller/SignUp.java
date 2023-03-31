package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUp extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
	{

		System.out.println("Service method called..");
		
		String firstName = req.getParameter("firstName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		System.out.println("FirstName : "+firstName);
		System.out.println("Email : "+email);
		System.out.println("Password : "+password);
		
	}
	

}
