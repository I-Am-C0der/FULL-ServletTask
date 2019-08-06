<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Corner</title>
</head>
<body>
	<br>
	<h1 align="center">Student Corner</h1>
	<br>
	<h2 align="center">Log In</h2>
	<br>
	<br>
	<form align="center" action="loginpage" method="post">
		Username: <input type="text" name="username" placeholder="Username" required /><br /> <br /> 
		Password: <input type="password" name="password" placeholder="Password" required /><br /> <br /> 
		<input type="submit" value="Log In" /> <br> <br>
		Don't have a Account? <a href="signup">Sign Up </a>
	</form>
</body>
</html>