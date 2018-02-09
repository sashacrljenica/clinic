<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,dao.*,model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body id="body_lightblue">
	<h1 id="center">Update User</h1>
	<%
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		User user = UserDao.getUserById(id);
	%>
	<div id="div1">
		<form id="form3" action="Edit" method="post">
			<table>
				<tr>
					<td>User Name:</td>
					<td><input type="text" name="userName" value="<% out.print(user.getUserName()); %>" required="required" /></td>
					<td><input type="hidden" name="userID" value="<% out.print(user.getUserID()); %>"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" value="<% out.print(user.getPassword()); %>" required="required" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Re enter Password:</td>
					<td><input type="password" name="repassword" value="<% out.print(user.getPassword()); %>" required="required" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Name and Surname:</td>
					<td><input type="text" name="nameAndSurname" value="<% out.print(user.getNameAndSurname()); %>"required="required" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><input type="text" name="address" value="<% out.print(user.getAddress()); %>" required="required" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Phone number:</td>
					<td><input type="text" name="phoneNumber" value="<% out.print(user.getPhoneNumber()); %>" required="required" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="email" name="email" value="<% out.print(user.getEmail()); %>" required="required" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Number of ID card:</td>
					<td><input type="text" name="numberOfIdCard" value="<% out.print(user.getNumberOfIDCard()); %>" required="required" /></td>
					<td></td>
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
					<td>In Database:
					<input type="text" value="<% out.print(user.getBloodType()); %>"/></td>
				</tr>
				<tr>
					<td>Sex:</td>
					<td><input type="radio" name="sex" value="male" checked="checked" />Male 
					<input type="radio" name="sex" value="female" />Female</td>
					<td>In Database:
					<input type="text" value="<% out.print(user.getSex()); %>"/></td>
				</tr>
				<tr>
					<td>Name of job:</td>
					<td><select name="nameOfJob" >
							<option></option>
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
					
					<td>In Database:
					<input type="text" value="<% out.print(user.getNameOfJob()); %>"/></td>
				</tr>
				<tr>
					<td>TypeOfUsers:</td>
					<td><input type="radio" name="typeOfUsers" value="patient" checked="checked" />Patient 
					<input type="radio" name="typeOfUsers" value="medic" />Medical Staff</td>
					<td>In Database:
					<input type="text" value="<% out.print(user.getTypeOfUsers()); %>"/></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="Edit&Save" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>