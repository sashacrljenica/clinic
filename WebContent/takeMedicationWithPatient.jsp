<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,dao.*,model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Doctor Take Medication</title>
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

		User patientObject = (User) session.getAttribute("patientObject");

		Pharmacy pharmacyObject = (Pharmacy) session
				.getAttribute("pharmacyObject");

		Pharmacy pharmacyObjectNew = (Pharmacy) session
				.getAttribute("pharmacyObjectNew");

		DoctorAppointment doctorAppointmentObject = (DoctorAppointment) session
				.getAttribute("doctorAppointmentObject");

		TakeMedication takeMedicationObject = (TakeMedication) session
				.getAttribute("takeMedicationObject");

		// Racunamo lekove koje smo uzeli
		// 		int quantityOld;
		int quantityOld = pharmacyObject.getQuantityOnCondition();
		// 		int quantityNew;
		int quantityNew = pharmacyObjectNew.getQuantityOnCondition();
		int quantity = quantityOld - quantityNew;

		session.setAttribute("user", user);
	%>
	<div id="div2">
		<a href="takeMedication.jsp">Take Medication page |</a>
		<a href="Logout">Logout</a>
	</div>
	<div id="center">
		<h4>Take medication with patient - View</h4>
		<p>
			<%
				out.print("<p>Name of doctor: " + user.getNameAndSurname() + "</p>");
			%>
		</p>
		<p>
			<%
				out.print("<p>Medical Staff Name and Surname: "
						+ medicalStaff.getUser().getNameAndSurname() + "</p>");
			%>
		</p>
		<p>
			<%
				out.print("<p>Patient Name: " + patientObject.getNameAndSurname()
						+ "</p>");
			%>
		</p>
		<p>
			<%
				out.print("<p>Number of medications prescribed for the patient: "
						+ quantity + "</p>");
			%>
		</p>
		<p>
			<%
				out.print("<p>Name Of Drugs What Give To Patient: "
						+ pharmacyObject.getNameOfTheDrug() + "</p> ");
			%>
		</p>
		<p>
			<%
				out.print("<p>Date of taking Drugs to patient: "
						+ takeMedicationObject.getDateOfTaking().toLocaleString()
						+ "</p>");
			%>
		</p>
	</div>

</body>
</html>