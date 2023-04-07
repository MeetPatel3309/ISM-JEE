<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp</title>

<style type="text/css">
.error
{
color: red;
}

</style>
</head>
<body>

<%
	String error = (String) request.getAttribute("error"); 
	String firstNameValue = (String) request.getAttribute("firstNameValue");
%>

<form action="registration" method="post" >

First Name : <input type="text" name="firstName" value=${firstNameValue}> <%=(request.getAttribute("firstNameError"))==null?"":request.getAttribute("firstNameError") %> <br><br>

Last Name : <input type="text" name="lastName" value=${lastNameValue}> <%=(request.getAttribute("lastNameError"))==null?"":request.getAttribute("lastNameError") %><br><br>

Email : <input type="text" name="email" value=${emailValue}> <%=(request.getAttribute("emailError"))==null?"":request.getAttribute("emailError") %><br><br>

Password : <input type="text" name="password"> <%=(request.getAttribute("passwordError")==null)?"":request.getAttribute("passwordError") %><br><br>

Confirm Password : <input type="text" name="confirmPassword"> <%=(request.getAttribute("passwordError")==null)?"":request.getAttribute("passwordError") %><br><br>

City :
<select name="city" value=${cityValue}>
	<optgroup label="Cities">
	<option>Select</option>
	<option>Ahmedabad</option>
	<option>Rajkot</option>
	<option>Baroda</option>
	<option>Junagadh</option>
	<option>Surat</option>
	</optgroup>
</select><%=(request.getAttribute("cityError")==null)?"":request.getAttribute("cityError") %>
<br><br>

Gender : 
Male <input type="radio" name="gender" value="Male">
Female <input type="radio" name="gender" value="Female">
Other <input type="radio" name="gender" value="Other">
<%=(request.getAttribute("genderError")==null)?"":request.getAttribute("genderError") %>
<br> <br>

Hobby : <br>
Cricket <input type="checkbox" name="cricket" value="Cricket"> <br>
Badminton <input type="checkbox" name="badminton" value="Badminton"> <br>
Photography <input type="checkbox" name="photography" value="Photography"> <br>
<%=(request.getAttribute("hobbyError")==null)?"":request.getAttribute("hobbyError") %>
 <br> <br>
<input type="submit" value="SignUp">
</form><br>

<%= error==null?"":error %>

</body>
</html>

<!-- 
		==>  Expression Langauge : ${key}
		==>  Turnory Operator : Condition ? Option1 : Option2
 -->