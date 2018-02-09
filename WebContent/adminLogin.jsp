<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin login</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body id="body_lightblue">
	<jsp:include page="linkAdmin.jsp" />
	<div style="text-align: center;">

		<h3>Welcome admin, please login!</h3>
		<form id="form1" action="Administration" method="post">
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
					<td colspan="2"><input type="submit" value="login" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>