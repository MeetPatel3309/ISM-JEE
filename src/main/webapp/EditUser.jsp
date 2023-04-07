<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit User</title>
</head>
<body>

<form action="EditUserController2" method="post" >

<input type="hidden" name="userId" value="${param.userId}">

First Name : <input type="text" name="firstName" value="${bean.firstName}">  ${firstNameError}  <br><br>

Last Name : <input type="text" name="lastName" value="${bean.lastName}">  ${lastNameError}<br><br>

Email : <input type="text" name="email" value="${bean.email}">  ${emailError }<br><br>

Password : <input type="text" name="password" value="${bean.password}">  ${passwordError } <br><br>

Confirm Password : <input type="text" name="confirmPassword" value="${bean.password}">  ${passwordError }<br><br>

City :
<select name="city" value="${bean.city}">  
	<optgroup label="Cities">
	<option>Select</option>
	<option>Ahmedabad</option>
	<option>Rajkot</option>
	<option>Baroda</option>
	<option>Junagadh</option>
	<option>Surat</option>
	</optgroup>
</select>
${cityError }
<br><br>

Gender : 
Male <input type="radio" name="gender" value="Male">
Female <input type="radio" name="gender" value="Female">
Other <input type="radio" name="gender" value="Other">
${genderError }
<br> <br>

Hobby : <br>
Cricket <input type="checkbox" name="cricket" value="Cricket"> <br>
Badminton <input type="checkbox" name="badminton" value="Badminton"> <br>
Photography <input type="checkbox" name="photography" value="Photography"> <br>
${hobbyError }
 <br> <br>
<input type="submit" value="Update">
</form><br>



</body>
</html>