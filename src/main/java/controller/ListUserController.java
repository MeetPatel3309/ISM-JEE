package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import dao.UserDAO;
@WebServlet("/ListUsersController")
public class ListUserController extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

//		ArrayList<UserBean> list = new ArrayList<>();
		

//		UserDAO dao = new UserDAO();
//		UserBean bean = dao.getAllUsers();
		
		
		ArrayList<UserBean> list = new UserDAO().getAllUsers();
		
		req.setAttribute("listUsers", list);
		
		req.getRequestDispatcher("ListUser.jsp").forward(req, resp);
	}

}
