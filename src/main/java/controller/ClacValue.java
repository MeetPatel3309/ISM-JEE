package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClacValue extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		String value = req.getParameter("radio");
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.print("<html><body>");
		
		
		if(value.equals("add"))
		{
			System.out.println("Addition is : "+(num1+num2));
			out.print(num1+" + "+num2+" = "+(num1+num2));
			
		}else if(value.equals("sub"))
		{
			System.out.println("Substraction is :"+(num1-num2));
			out.print(num1+" - "+num2+" = "+(num1-num2));
			
		}else if(value.equals("mul"))	
		{
			System.out.println("Multiplication is : "+(num1*num2));
			out.print(num1+" * "+num2+" = "+(num1*num2));
			
		}else
		{
			System.out.println("Division is : "+(num1/num2));
			out.print(num1+" / "+num2+" = "+(num1/num2));
		}
		out.print("</body></html>");
	}
}
