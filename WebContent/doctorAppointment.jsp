<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,dao.*,model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor Appointment</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body id="body_lightblue">
	<%
		User user = (User) session.getAttribute("user");

		// Ako je parametar user iz sesije prazan, znaci da se User izlogovao i 
		// sprecavamo neautorizovan pristup stranici!
		if (user == null) {
			out.print("<p style='text-align: center;color: red;'>Sorry, you must login first!</p>");
			request.getRequestDispatcher("login.html").include(request, response);
		}
	%>
	<div id="div2">
		<p><a href="Logout">logout</a></p>
	</div>
	<div id="center">
		<h1>Doctor Appointment Page</h1>
		<h4>Welcome <% out.print(" " + user.getNameAndSurname() + "!"); %></h4>
		<p>Please check if a medical examination can be scheduled</p>
		<form id="form3" action="CheckDepartment" method="get">
			<table>
				<tr>
					<td>Medical Department:</td>
					<td><select name="medicalDepartment">
							<%
								List<MedicalDepartment> listDepartment = MedicalDeparmentDao.getAll();
								for (MedicalDepartment mdep : listDepartment) {
							%>
							<option>
								<%
									out.print(mdep.getNameOfDepartment());
									}
								%>
							</option>
					</select></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Check" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>