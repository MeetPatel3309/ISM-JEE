<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<style type="text/css">
.button
{
color: white;
text-decoration: none;
font-size: 20px;
}
button
{
border: 5px solid black;
background-color: green;
}

.button:active
{
color: red;
text-decoration: none;
text-align: center;
}
.button:hover
{
color: Yellow;
}

.container
{
margin: 10px ;
padding: 20px 30px;
}
.container : hover
{
height: 46px;
width: 126px;
border-left-color: white;
border-right-color: white;
}

</style>
</head>
<body>

<div class="container">
	<button>
		<a href="ListUsersController" class="button" >Users List</a>
	</button>
</div>
</body>
</html>