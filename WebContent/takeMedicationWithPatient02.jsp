<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,dao.*,model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Take medication with patient</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body id="body_lightblue">
	<%
		User user = (User) session.getAttribute("user");

		// Ako je parametar user iz sesije prazan, znaci da se User izlogovao i 
		// sprecavamo neautorizovan pristup stranici!
		if (user == null) {
			out.print("<p style='text-align: center;color: red;'>Sorry, you must login first!</p>");
			request.getRequestDispatcher("login.html").include(request,
					response);
		}
		MedicalStaff medicalStaff = (MedicalStaff) session
				.getAttribute("medicalStaff");

		String patientIDString = request.getParameter("patientID");
		int patientID = Integer.parseInt(patientIDString);

		String pharmacyIDString = request.getParameter("pharmacyID");
		int pharmacyID = Integer.parseInt(pharmacyIDString);

		String quantityString = request.getParameter("quantity");
		int quantityInt = Integer.parseInt(quantityString);
		int quantity = quantityInt;
	%>
	<div id="center">
		<h4>Take medication with patient</h4>
		<p>
			<%
				out.print("<p>Name of doctor: " + user.getNameAndSurname() + "</p>");
			%>
		</p>
		<p>
			<%
				out.print("<p>Medical Staff ID: "
						+ medicalStaff.getMedicalStaffID() + "</p>");
			%>
		</p>
		<p>
			<%
				out.print("<p>Patient ID: " + patientID + "</p>");
			%>
		</p>
		<p>
			<%
				out.print("<p>Pharmacy ID: " + pharmacyID + "</p>");
			%>
		</p>
		<p>
			<%
				out.print("<p>Quantity Of Drugs What Give To Patient: " + quantity
						+ "</p> ");
			%>
		</p>
	</div>
</body>
</html>