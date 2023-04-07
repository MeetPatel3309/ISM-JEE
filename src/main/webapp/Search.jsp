<%@page import="bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Page</title>
</head>
<body>

<form action="SearchController">
		
		<h2 style="color: green">Enter SubString : </h2> 
		<input type="text" name="search" >
		<input type="submit" value="Search">
</form>
<br> <br>
<% String searchError = (String)request.getAttribute("searchError"); %>

<%= (searchError)==null?"":searchError%>

</body>
</html>