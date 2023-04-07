<%@page import="bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View User By Id</title>
</head>
<body>

<% UserBean bean = (UserBean)request.getAttribute("bean"); %>

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
	</tr>
	
	 <tr>
	 	<td><%= bean.getUserId() %> </td>
	 	<td><%= bean.getFirstName() %> </td>
		<td><%= bean.getLastName() %></td>
	 	<td><%= bean.getEmail()%> </td>
	 	<td><%= bean.getPassword()%> </td>
	 	<td><%= bean.getCity()%> </td>
	  	<td><%= bean.getGender()%></td>
	 	<td><%= bean.getHobby1()%> </td>
	 	<td><%= bean.getHobby2()%> </td>
	 	<td><%= bean.getHobby3()%> </td>
	 </tr>
	
	
	</table> <br> <br>
	
	<button>
	<a href="ListUsersController" style="text-decoration: none">Back</a>
	</button>

</body>
</html>