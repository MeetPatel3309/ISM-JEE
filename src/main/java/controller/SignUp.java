package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUp extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		System.out.println("Service method called..");

		String firstName = req.getParameter("firstName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		System.out.println("FirstName : " + firstName);
		System.out.println("Email : " + email);
		System.out.println("Password : " + password);

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		StringBuffer error = new StringBuffer("");

		out.print("<html><body>");

		boolean isError = false;

		if (firstName == null || firstName.trim().length() == 0) 
		{
			isError = true;
			out.print("<span style='color:red'>Please Enter FirstName..</span><br>");
		} 
		else if (firstName.trim().length() <= 2) 
		{
			isError = true;
			out.print("<span style='color:red'>Please Enter Atleast 3 Character Name <br></span>");
		} 
		else 
		{
			String alpha = "[a-zA-Z-\s]+";
			if (firstName.matches(alpha) == false) 
			{
				isError = true;
				error.append("<span style='color:red'>Please Enter Valid FirstName..</span><br>");
			}
		}

		if (email == null || email.trim().length() == 0) 
		{
			isError = true;
			out.print("<span style='color:red'>Please Enter Email..</span><br>");
		} 
		else 
		{
			String alpha = "[a-z.]{2,15}[0-9]{0,4}@[gmail]{5}.[com]{3}";
			if(email.matches(alpha) == false) 
			{
				isError = true;
				error.append("<span style='color:red'>Please Enter Valid Email..</span><br>");
			}
		}

		if (password == null || password.trim().length() == 0) {
			isError = true;
			out.print("<span style='color:red'>Please Enter Password..</span><br> ");
		}
		else
		{
			String alpha ="[0-9]{6,8}";
			if(password.matches(alpha)==false)
			{
				isError = true;
				out.print("<span style='color:red'>Please Enter Valid Password..</span><br> ");
			}
		}
		
		
		if (isError == true) 
		{
			out.print(error);
		}
		else 
		{
			out.print("FirstName : " + firstName + "<br>");
			out.print("Email : " + email + "<br>");
			out.print("Password : " + password + "<br>");
		}
		out.print("</body></html>");

	}

}
