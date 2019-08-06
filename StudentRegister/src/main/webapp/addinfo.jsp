<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Corner</title>
</head>
<body>
		<br><form align="right" action="/logout">  
		<button type="submit">Logout</button></form>
		<h2 align="center">Add Student Details</h2><br><br>
		<form><button type="submit" formaction="/home">Back</button></form><br><br>
		<form action="register" method="post" align="center">
		
		Name: <input type="text" name="name"/><br><br><br> 
		Age: &nbsp;&nbsp;&nbsp;<input type="text" name="age"/><br><br><br> 
		<button type="submit">Add Student</button></form>
</body>
</html>