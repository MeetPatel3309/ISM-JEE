<%@page import="java.beans.beancontext.BeanContext"%>
<%@page import="bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users List</title>

<style type="text/css">
.button
{
text-decoration: none
}
</style>
</head>
<body>

	<% 
		ArrayList<UserBean> list =(ArrayList<UserBean>) request.getAttribute("listUsers"); 
	%>
	
	<h3>List Of Users</h3>
	
	<table border="1">
	
	<tr> 
	
		<th>UserId </th>
		<th>FirstName </th>
		<th>LastName </th>
		<th>Email </th>
		<th>Password </th>
		<th>City </th>
		<th>Gender </th>
		<th>Hobby1 </th>
		<th>Hobby2 </th>
		<th>Hobby3 </th>
		<th>Action </th>
		<th>View </th>
		<th>Edit </th>
		
	</tr>
	
	 <% 
	 	for(UserBean bean : list) 
	 	{
	 %>
	 
	 <tr>
	 	<td><%=bean.getUserId() %> </td>
	 	<td><%= bean.getFirstName() %> </td>
		<td><%= bean.getLastName() %></td>
	 	<td><%= bean.getEmail()%> </td>
	 	<td><%= bean.getPassword()%> </td>
	 	<td><%= bean.getCity()%> </td>
	  	<td><%= bean.getGender()%></td>
	 	<td><%= bean.getHobby1()%> </td>
	 	<td><%= bean.getHobby2()%> </td>
	 	<td><%= bean.getHobby3()%> </td>
	    <td> <a href="DeleteUserController?userId=<%=bean.getUserId()%>"> Delete </a>  </td>
	    <td><a href="ViewUserController?userId=<%=bean.getUserId()%>"> View</a></td>
	    <td><a href="EditUserController?userId=<%=bean.getUserId()%>"> Edit</a> </td>
	    
	 </tr>
	 <%
	 	} 
	 %>
	
	</table> <br> <br>
	
	<h3>List Of Users Using JSTL</h3>
	
	<table border="1">
	
	<tr> 
	
		<th>UserId </th>
		<th>FirstName </th>
		<th>LastName </th>
		<th>Email </th>
		<th>Password </th>
		<th>City </th>
		<th>Gender </th>
		<th>Hobby1 </th>
		<th>Hobby2 </th>
		<th>Hobby3 </th>
		<th>Action </th>
		<th>View </th>
		<th>Edit </th>
		
	</tr>
		
		<c:forEach items="${listUsers}" var="bean">
	<tr>
		<td>${bean.userId}</td>
		<td>${bean.firstName}</td>
		<td>${bean.lastName}</td>
		<td>${bean.email}</td>
		<td>${bean.password}</td>
		<td>${bean.city}</td>
		<td>${bean.gender}</td>
		<td>${bean.hobby1}</td>
		<td>${bean.hobby2}</td>
		<td>${bean.hobby3}</td>
		<td><a href="DeleteUserController?userId=${bean.getUserId() }"> Delete </a> </td>
		<td><a href="ViewUserController?userId=${bean.getUserId()}"> View</a></td>
		<td> <a href="EditUserController?userId=${bean.getUserId() }"> Edit </a> </td>
		
	</tr>	
		</c:forEach>


	</table> <br> <br>
		
	
	
	
	
	

	 <button>
	 
	 	<a href="Search.jsp" class="button">Press For Search</a>  
	 
	 </button>
	 
	 <button>
	 
	 	<a href="Registration.jsp" class="button">Add New User</a>  
	 
	 </button>
</body>
</html>