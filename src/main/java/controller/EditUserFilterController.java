package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/EditUserController2")
public class EditUserFilterController implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		System.out.println("Edit_User_Filter_Controller :: init()");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Edit_User_Filter_Controller :: doFilter()");
		
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
		
		
		boolean isError = false;
		
		//This validation is for Edit the user data
//		(You can also write this validation in EditUserController2)
		
		if (firstName == null || firstName.trim().length() == 0) 
		{
			isError = true;
			////				error.append("<span style='color:red'>Please Enter FirstName..</span><br>");
			req.setAttribute("firstNameError", "<span class='error'>Please Enter FirstName..</span><br>");
			
		} 
		else
			if (firstName.trim().length() <= 2) 
		{
			isError = true;
			////				error.append("<span style='color:red'>Please Enter Atleast 3 Character Name <br></span>");
			req.setAttribute("firstNameError", "<span class='error'>Please Enter Atleast 3 Character Name </span><br>");
		
		} 
		else 
		{
			String alpha = "[a-zA-Z-\s]+";
			if (firstName.matches(alpha) == false) 
			{
				isError = true;
				////					error.append("<span style='color:red'>Please Enter Valid FirstName..</span><br>");
				req.setAttribute("firstNameError", "<span class='error'>Please Enter Valid FirstName..</span><br>");
			}
			
		}
		
		if (lastName == null || lastName.trim().length() == 0) 
		{
			isError = true;
			////				error.append("<span style='color:red'>Please Enter LastName..</span><br>");
			req.setAttribute("lastNameError", "<span class='error'>Please Enter LastName..</span>");
		} 
		else if (lastName.trim().length() <= 2) 
		{
			isError = true;
			////				error.append("<span style='color:red'>Please Enter Atleast 3 Character lastName <br></span>");
			req.setAttribute("lastNameError", "<span class='error'>Please Enter Atleast 3 Character lastName </span>");
		} 
		else 
		{
			String alpha = "[a-zA-Z-\s]+";
			if (lastName.matches(alpha) == false) 
			{
				isError = true;
				////					error.append("<span style='color:red'>Please Enter Valid LastName..</span><br>");
				req.setAttribute("lastNameError", "<span class='error'>Please Enter Valid lastName </span>");
			}
			
		}

		if (email == null || email.trim().length() == 0) 
		{
			isError = true;
			////				error.append("<span style='color:red'>Please Enter Email..</span><br>");
			req.setAttribute("emailError", "<span class='error'>Please Enter Email</span>");
		} 
		else 
		{
			String alpha = "[a-z.]{2,15}[0-9]{0,4}@[gmail]{5}.[com]{3}";
			if(email.matches(alpha) == false) 
			{
				isError = true;
				////					error.append("<span style='color:red'>Please Enter Valid Email..</span><br>");
				req.setAttribute("emailError", "<span class='error'>Please Enter Valid Email</span>");
			}
			
		}

		if (password == null || password.trim().length() == 0) {
			isError = true;
			////				error.append("<span style='color:red'>Please Enter Password..</span><br> ");
			req.setAttribute("passwordError", "<span class='error'>Please Enter Password</span>");
		}
		else if(confirmPassword == null || confirmPassword.trim().length() == 0) 
		{
			isError = true;
			////				error.append("<span style='color:red'>Please Enter Password..</span><br> ");
			req.setAttribute("passwordError", "<span class='error'>Please Enter Password</span>");
		}
		else if(!(password.equals(confirmPassword)))
		{
			isError = true;
			////				error.append("<span style='color:red'>Please Enter Same Password..</span><br> ");
			req.setAttribute("passwordError", "<span class='error'>Please Enter Same Password</span>");
		}
		else
		{
			String alpha ="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}";
			if(password.matches(alpha)==false)
			{
				isError = true;
				////					error.append("<span style='color:red'>Please Enter Valid Password..</span><br> ");
				req.setAttribute("passwordError", "<span class='error'>Please Enter Valid Password</span>");
			}
			
		}
		
		if(city == null || city.equals("Select"))
		{
			isError = true;
			////				error.append("<span style='color:red'>Please Select The City..</span><br>");
			req.setAttribute("cityError", "<span class='error'>Please Select The City..</span>");
		}
		
		
		if(gender == null)
		{
			isError = true;
			////				error.append("<span style='color:red'>Please Select The Gender..</span><br>");
			req.setAttribute("genderError", "<span class='error'>Please Select The Gender..</span>");
		}
		
//		StringBuffer hobby = new StringBuffer();
		
		if(hobby1 == null && hobby2 == null && hobby3 == null )
		{
			isError = true;
			////				error.append("<span style='color:red'>Please Select The Hobby..</span><br>");
			req.setAttribute("hobbyError", "<span class='error'>Please Select The Hobby..</span>");		
		}
	
	
	

		if(isError==true)
		{
			req.setAttribute("firstNameValue", firstName);
			req.setAttribute("lastNameValue", lastName);
			req.setAttribute("emailValue", email);
			req.setAttribute("cityValue", city);
			req.setAttribute("genderValue", gender);
//			req.setAttribute("hobbyValue", hobby);
			
//			RequestDispatcher rd = null;
//			 rd = req.getRequestDispatcher("EditUser.jsp");
//			rd.forward(req, resp);
			
//			System.out.println("rd : ");
			
			req.getRequestDispatcher("EditUser.jsp").forward(req, resp);
		}
	
		else
		{
			chain.doFilter(req, resp);
		}

		
	}
	
	@Override
	public void destroy() {
		System.out.println("Edit_User_Filter_Servlet :: destroy()");
	}

	
}
