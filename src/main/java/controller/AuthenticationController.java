package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import dao.UserDAO;

/**
 * Servlet implementation class AuthenticationController
 */
@WebServlet("/AuthenticationController")
public class AuthenticationController extends HttpServlet {
		
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
//		UserDAO dao = new UserDAO();
//		UserBean bean=  dao.authenticate(email, password);
		
		UserBean bean = new UserDAO().authenticate(email, password);
		
		RequestDispatcher rd = null;
		
		if(bean == null)
		{
			req.setAttribute("error", "Please Enter valid Credentials..");
			rd = req.getRequestDispatcher("Login.jsp");
		}
		else
		{
			rd = req.getRequestDispatcher("Home.jsp");
		}
		rd.forward(req, resp);
	
	}
}
