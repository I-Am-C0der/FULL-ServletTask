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
	<form align="right" action="/logout">
		<button type="submit">Logout</button>
	</form>
	<h2 align="center">Display Student Details</h2>
	<br>
	<form>
		<button type=submit formaction=/home>Back</button>
	</form>
	<form action="display" method="get">

		<table border=1 style="border-collapse: collapse;" cellpadding="15" align="center">
			<tr>
				<td height="100"><input type="radio" name="display" value="1">&nbsp;
					Display by Age<br>
				<br> Age: <input type="number" name="age"><br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio"	name="filter" value="1">&nbsp;
					Greater Than<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio"	name="filter" value="2">&nbsp;
					Lesser Than <br> <br></td>
			</tr>
			<tr>
				<td height="100"><input type="radio" name="display" value="2">&nbsp;
					Display by Name<br>
				<br> Name: <input type="text" name="name"><br> <br></td>
			</tr>
			<tr>
				<td height="100"><input type="radio" name="display" value="3">&nbsp;
					Display All<br></td>
			</tr>
		</table>
		<br>
		<div align="center">
			<button type="submit">Display</button>
		</div>

	</form>



</body>
</html>