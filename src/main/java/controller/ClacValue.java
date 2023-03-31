package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClacValue extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		String value = req.getParameter("radio");
		
		if(value.equals("add"))
		{
			System.out.println("Addition is : "+(num1+num2));
		}else if(value.equals("sub"))
		{
			System.out.println("Substraction is :"+(num1-num2));
		}else if(value.equals("mul"))
		{
			System.out.println("Multiplication is : "+(num1*num2));
		}else
		{
			System.out.println("Division is : "+(num1/num2));
		}
		
	}
}
