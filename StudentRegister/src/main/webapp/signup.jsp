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
	<h2 align="center">Sign Up</h2>
	<br>
	<br>
	<form align="center" action="signuppage" method="post">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		Name: <input type="text" name="name" required /><br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${message2}
		<br /> Username: <input type="text" name="username" required /><br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${message1}
		<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		Email: <input type="email" name="email" required /><br />
		<br />&nbsp; 
		Password: <input type="password" name="password" required /><br />
		<br /> <input type="submit" value="Sign Up" /> <br> <br>
		Already have a Account? <a href="/">Log In </a>
	</form>

</body>
</html>