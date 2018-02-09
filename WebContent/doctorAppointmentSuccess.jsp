<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,dao.*,model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor Appointment Success</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body id="body_lightblue">
	<div id="div2">
		<a href="index.jsp">Home</a> | <a href="Logout">Logout</a>
		<hr>
	</div>
	<%
		User user = (User) session.getAttribute("user");
		MedicalDepartment department = (MedicalDepartment) session
				.getAttribute("department");
		DateOfScheduling dateOfScheduling = (DateOfScheduling) session
				.getAttribute("dateOfScheduling");
		User doctor = (User) session.getAttribute("doctor");

		//Ako je parametar user iz sesije prazan, znaci da se User izlogovao i 
		// sprecavamo neautorizovan pristup stranici!
		if (user == null) {
			out.print("<p style='text-align: center;color: red;'>Sorry, you must login first!</p>");
			request.getRequestDispatcher("login.html").include(request,
					response);
		}
	%>
	<div id="div1">
		<p style='color: green;'>
			Congratulations <% out.print(user.getNameAndSurname()); %>
			, you have successfully scheduled a doctor's appointment term!
		</p>
		<p>
			Name of Medical department: <% out.print(department.getNameOfDepartment()); %>
		</p>
		<p>
			Name of doctor: <% out.print(doctor.getNameAndSurname()); %>
		</p>
		<p>
			Phone number of Medical department: <% out.print(department.getContactPhone()); %>
		</p>
		<p>
			Date of scheduling: <% out.print(dateOfScheduling.getDateOfScheduling().toLocaleString()); %>
		</p>
	</div>
</body>
</html>