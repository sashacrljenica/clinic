<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,dao.*,model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Take Medication</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body id="body_lightblue">
	<div id="div2">
		<a href="Logout">logout</a>
	</div>
	<div id="center">
		<h1>Take Medication</h1>
	</div>
	<%
		User user = (User) session.getAttribute("user");

		// Ako je parametar user iz sesije prazan, znaci da se User izlogovao i 
		// sprecavamo neautorizovan pristup stranici!
		if (user == null) {
			out.print("<p style='text-align: center;color: red;'>Sorry, you must login first!</p>");
			request.getRequestDispatcher("login.html").include(request,
					response);
		}
		// Objekat medicalStaff koji odgovara id-u Medic usera
		MedicalStaff medicalStaffObject = MedicalStaffDao
				.getMedicalStaffByUserID(user.getUserID());

		int idMedicalStaff = medicalStaffObject.getMedicalStaffID();

		// Lista svih Doctor Appointmenta koji odgovaraju id-u medicalStaffa
		List<DoctorAppointment> listDoctorAppointment = DoctorAppointmentDao
				.getDoctorAppointmentByMedicalStaffID(idMedicalStaff);

		// Lista svih Pharmacy
		List<Pharmacy> listPharmacy = PharmacyDao.getAllPharmacy();
		// Lista svih Pharmacy sortirana po Imenu leka
		List<Pharmacy> listPharmacySortedByName = PharmacyDao
				.getAllPharmacySortedByNameOfTheDrug();

		session.setAttribute("medicalStaff", medicalStaffObject);
		session.setAttribute("user", user);
	%>
	<div id="center">
		<h4>
			Welcome doctor
			<%
			out.print(user.getNameAndSurname());
		%>!
		</h4>
		<%
			if (listDoctorAppointment.isEmpty()) {
				response.sendRedirect("takeMedicationNoPatient.jsp");
			} else {
		%>
		<div id="form6">
			<p id="left">List of patient who has scheduled a medical
				examination and overwrite the therapy:</p>
			<table border="1">
				<tr>
					<th>Id Patient</th>
					<th>Name and Surname</th>
					<th>Address</th>
					<th>Phone number</th>
					<th>Date of Scheduling</th>
				</tr>
				<%
					for (DoctorAppointment dapp : listDoctorAppointment) {
				%>
				<tr>
					<td>
						<%
							out.print(dapp.getUser().getUserID());
						%>
					</td>
					<td>
						<%
							out.print(dapp.getUser().getNameAndSurname());
						%>
					</td>
					<td>
						<%
							out.print(dapp.getUser().getAddress());
						%>
					</td>
					<td>
						<%
							out.print(dapp.getUser().getPhoneNumber());
						%>
					</td>
					<td>
						<%
							out.print(dapp.getDateOfScheduling().getDateOfScheduling()
											.toLocaleString());
						%>
					</td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
		<div id="form6">
			<p id="left">Pharmacy:</p>
			<table border="1">
				<tr>
					<th>PharmacyID</th>
					<th>NameOfTheDrug</th>
					<th>ScopeOfApplication</th>
					<th>QuantityOnCondition</th>
					<th>Note</th>
					<th>Manufacturer Name</th>
					<th>Manufacturer Contact Phone</th>
					<th>Manufacturer Email</th>
				</tr>
				<%
					for (Pharmacy pha : listPharmacySortedByName) {
				%>
				<tr>
					<td>
						<%
							out.print(pha.getPharmacyID());
						%>
					</td>
					<td>
						<%
							out.print(pha.getNameOfTheDrug());
						%>
					</td>
					<td>
						<%
							out.print(pha.getScopeOfApplication());
						%>
					</td>
					<td>
						<%
							out.print(pha.getQuantityOnCondition());
						%>
					</td>
					<td>
						<%
							out.print(pha.getNote());
						%>
					</td>
					<td>
						<%
							out.print(pha.getManufacturer().getName());
						%>
					</td>
					<td>
						<%
							out.print(pha.getManufacturer().getContactPhone());
						%>
					</td>
					<td>
						<%
							out.print(pha.getManufacturer().getEmail());
						%>
					</td>
				</tr>
				<%
					}
				%>
			</table>
		</div>

		<form id="form6" action="TakeMedicationPatient" method="get">
			<table>
				<tr>
					<td>Patient ID:</td>
					<td id="left"><select name="patientID">
							<%
								for (DoctorAppointment dapp : listDoctorAppointment) {
							%>
							<option>
								<%
									out.print(dapp.getUser().getUserID());

										}
								%>
							</option>
					</select></td>
				</tr>
				<tr>
					<td>Pharmacy ID:</td>
					<td id="left"><select name="pharmacyID">
							<%
								for (Pharmacy pha : listPharmacy) {
							%>
							<option>
								<%
									out.print(pha.getPharmacyID());

										}
								%>
							</option>
					</select></td>
				</tr>
				<tr>
					<td>Please select the number of medications what you give to
						the patient:</td>
					<td><input type="number" name="quantity" min="1" value="1" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Take Medication" /></td>
				</tr>
			</table>
		</form>
		<%
			}
		%>
	</div>
</body>
</html>