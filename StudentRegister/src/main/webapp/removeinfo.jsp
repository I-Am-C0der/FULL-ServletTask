<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Corner</title>
</head>
<body>
<br><form align="right" action="/logout"><button type="submit">Logout</button></form>

<h2 align="center">Remove Student Details</h2><br><br>
<form><button type=submit formaction=/home>Back</button><br><br>
</form>
<form action="deregister" method="get" align="center">
				 Name: <input type="text" name="name"><br><br><br>
				 <button type=submit>Get Details</button></form>
				 
				 		
</body>
</html>