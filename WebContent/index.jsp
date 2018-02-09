<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Clinic Login page</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body id="body_index">
	<div id="div1">
		<h1>Welcome to Clinic! Please login or register!</h1>
	</div>
	<div id="lista">
    	<ul>
        	<li><a href="addUserPatient.html">Registration for Patient</a></li>
            <li><a href="addUserMedic.jsp">Registration for Medical Staff</a></li>
            <li><a href="adminLogin.jsp">Administration</a></li>
            <li><a href="login.html">Login</a></li>
            <li><a href="Logout">Logout</a></li>
        </ul>
    </div>
		<br>
		<br>
	<div>
		<form id="form1" action="Login" method="post">
			<table>
				<tr>
					<td>Name:</td>
					<td><input type="text" name="name" required="required" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" required="required" /></td>
				</tr>
				<tr>
				<td></td>
						<td><input type="submit" value="login" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>