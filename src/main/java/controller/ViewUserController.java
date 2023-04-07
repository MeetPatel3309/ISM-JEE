package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import dao.UserDAO;

@WebServlet("/ViewUserController")
public class ViewUserController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Integer userId =Integer.valueOf(req.getParameter("userId"));
		
		UserDAO dao = new UserDAO();
		
		UserBean bean = dao.getUserById(userId);
	
		req.setAttribute("bean", bean);
		
		req.getRequestDispatcher("ViewUser.jsp").forward(req, resp);
	}
	

}
