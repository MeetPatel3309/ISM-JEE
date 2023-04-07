<%@page import="javax.net.ssl.SNIHostName"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style type="text/css">
.button
{
color: blue
}
</style>

</head>
<body>

	<%="This is a Login Page <br><br>"%>
	<%="Insert Your Credentials For Login"%>
	
<!-- 
	
	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String confirmPassword = request.getParameter("confirmPassword");
	String city = request.getParameter("city");
	String gender = request.getParameter("gender");
	String hobby = (String)request.getAttribute("hobby");
	
 -->
	<br> <br>
	<!-- 
	out.print("<br>FirstName : " + firstName);
	out.print("<br>LastName : " +lastName);
	out.print("<br>Email : "+email);
	out.print("<br>Password : "+password);
	out.print("<br>Confirm Password : "+confirmPassword);
	out.print("<br>City : "+city);
	out.print("<br>Gender : "+gender);
	out.print("<br>"+hobby);
	
	 -->
	
	 
	 <form action="AuthenticationController" method="post">
	 
	 Email : <input type="text" name="email">  <br> <br>
	 Password : <input type="text" name="password"> <br> <br>
	 <input type="submit" value="Login" class="button"> 
	 
	 <button > <a class="button" href="Registration.jsp" style="text-decoration: none">Add New User</a> </button>
	 
	</form>
	 <br> <br>
	 <%=(request.getAttribute("error"))==null?"":request.getAttribute("error") %>
	 <br> ${error}
	
</body>
</html>