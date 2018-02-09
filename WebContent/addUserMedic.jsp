<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,dao.*,model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration for Medical Staff</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body id="body_lightblue">
	<div id="div2">
		<a href="index.jsp">Home</a> | <a href="login.html">Login</a> | <a
			href="Logout">Logout</a>
		<hr>
	</div>
	<div id="div1">
		<h1>Add New Medical Staff</h1>
		<p>We ask medical staff to enter their data for successful registration and further use of the application</p>
		<form id="form4" action="SaveUser" method="post">
			<table>
				<tr>
					<td>User Name:</td>
					<td><input type="text" name="userName" required="required" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" required="required" /></td>
				</tr>
				<tr>
					<td>Re enter Password:</td>
					<td><input type="password" name="repassword"
						required="required" /></td>
				</tr>
				<tr>
					<td>Name and Surname:</td>
					<td><input type="text" name="nameAndSurname"
						required="required" /></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><input type="text" name="address" required="required" /></td>
				</tr>
				<tr>
					<td>Phone number:</td>
					<td><input type="text" name="phoneNumber" required="required" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="email" name="email" required="required" /></td>
				</tr>
				<tr>
					<td>Number of ID card:</td>
					<td><input type="text" name="numberOfIdCard" required="required"/></td>
				</tr>
				<tr>
					<td>Blood type:</td>
					<td><select name="bloodType">
							<option>O+</option>
							<option>A+</option>
							<option>B+</option>
							<option>O-</option>
							<option>A-</option>
							<option>AB+</option>
							<option>B-</option>
							<option>AB-</option>
					</select></td>
				</tr>

				<tr>
					<td>Medical Department:</td>
					<td><select name="medicalDepartment" style="width: 90%">
							<%
								List<MedicalDepartment> listDepartments = MedicalDeparmentDao.getAll();
								for (MedicalDepartment dep : listDepartments) {
							%>
							<option>
								<%
									out.print(dep.getNameOfDepartment());
									}
								%>
							</option>
					</select></td>
				</tr>
				<tr>
					<td>Name of job:</td>
					<td><select name="nameOfJob">
						<option>nurse</option>
						<option>doctor</option>
						<option>tehnician</option>
						<option>helpful staff</option>
						<option>student</option>
						<option>practician</option>
						<option>official</option>
						<option>sheriff's officer</option>
						<option>other</option>
					</select></td>
				</tr>
				<tr>
					<td>Sex:</td>
					<td><input type="radio" name="sex" value="male" checked="checked" />Male 
						<input type="radio" name="sex" value="female" />Female</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="hidden" name="typeOfUsers" value="medic">
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Save User" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>