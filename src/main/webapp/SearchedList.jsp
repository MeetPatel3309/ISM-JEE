<%@page import="bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Searched List</title>
</head>
<body>

		<%
		
		ArrayList<UserBean> searchlist = (ArrayList<UserBean>) request.getAttribute("searchlist"); 
		
		%>
		<h2>SearchList :- </h2>
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
	
	 <% 
	 	for(UserBean bean : searchlist) 
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
	 	
	 </tr>
	 <%
	 	} 
	 %>
	
	</table> <br> <br>
	
	<h2>SearchList Using JSTL</h2>
	<table border="2">
	
	<tr>
		<th>UserId</th>
	 	<th>FirstName </th>
	 	<th>LastName </th>
	 	<th>Email</th>
	 	<th>Password</th>
	 	<th>City</th>
	 	<th>Gender</th>
	 	<th>Hobby1</th>
	 	<th>Hobby2</th>
	 	<th>Hobby3</th>
	 </tr>
	 
	 <c:forEach items="${searchlist}" var="searchlist">
	 
	 <tr> 
	 
	 <td>${ searchlist.userId} </td>
	 <td>${ searchlist.firstName}</td>
	 <td>${ searchlist.lastName}</td>
	 <td>${ searchlist.email}</td>
	 <td>${ searchlist.password}</td>
	 <td>${ searchlist.city}</td>
	 <td>${ searchlist.gender}</td>
	 <td>${ searchlist.hobby1}</td>
	 <td>${ searchlist.hobby2}</td>
	 <td>${ searchlist.hobby3}</td>
	 
	 
	 </tr>
	 
	 </c:forEach>
	
	
	</table>


</body>
</html>