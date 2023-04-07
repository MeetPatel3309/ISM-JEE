package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import dao.UserDAO;

@WebServlet("/EditUserController2")
public class EditUserController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
	
		
			Integer userId =Integer.valueOf(req.getParameter("userId"));
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

//			System.out.println("FirstName : " + firstName);
//			System.out.println("LastName : " + lastName);
//			System.out.println("Email : " + email);
//			System.out.println("Password : " + password);
//			System.out.println("Confirm Password : " + confirmPassword);
//			System.out.println("City : " + city);
//			System.out.println("Gender : " + gender);
//			System.out.println("Hobby1 : " + hobby1);
//			System.out.println("Hobby2 : " + hobby2);
//			System.out.println("Hobby3 : " + hobby3);

			UserBean bean = new UserBean();
			
			bean.setUserId(userId);
			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			bean.setEmail(email);
			bean.setPassword(password);
			bean.setCity(city);
			bean.setGender(gender);
			bean.setHobby1(hobby1);
			bean.setHobby2(hobby2);
			bean.setHobby3(hobby3);
			
			UserDAO dao = new UserDAO();
			
			dao.UpdateUser(bean);
			 
			System.out.println("----Edit = 2----");
			
//			resp.sendRedirect("ListUsersController");
			resp.sendRedirect("ListUsersController");
			
		}

}
