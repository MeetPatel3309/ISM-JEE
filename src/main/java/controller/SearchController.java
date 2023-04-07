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

@WebServlet("/SearchController")
public class SearchController extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		UserDAO dao = new UserDAO();
		
		String searchString = req.getParameter("search");
		
		if(searchString == null || searchString.trim().length() == 0)
		{
			req.setAttribute("searchError", "<span style='color:red'>Please Enter Sub String For Search The Data</span>");
			
			req.getRequestDispatcher("Search.jsp").forward(req, resp);
		}
		else
		{
		
			
			ArrayList<UserBean> searchlist = dao.search(searchString);
			
			req.setAttribute("searchlist", searchlist);
			
			req.getRequestDispatcher("SearchedList.jsp").forward(req, resp);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

	}

}
