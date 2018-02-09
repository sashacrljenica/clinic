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
	
		String department;
		department = request.getParameter("medicalDepartment");
		
		session.setAttribute("user", user);

		// Ako je parametar user iz sesije prazan, znaci da se User izlogovao i 
		// sprecavamo neautorizovan pristup stranici!
		if (user == null) {
			out.print("<p style='text-align: center;color: red;'>Sorry, you must login first!</p>");
			request.getRequestDispatcher("login.html").include(request,
					response);
		}
	%>
	<div id="div2">
		<p>
			<a href="Logout">logout</a>
		</p>
	</div>
	<div id="center">
		<h1>Doctor Appointment Page</h1>
		<h4>
			Welcome
			<%
			out.print(" " + user.getNameAndSurname() + "!");
		%>
		</h4>
		<p>
			<%
				out.print(department);
			%>
		</p>
	</div>
	<div>
		<form id="form5" action="SaveDoctorAppointment" method="get">
			<table>
				<tr>
					<td>Name of doctor who work in <%
						out.print(" " + department + " :");
					%></td>
					<td><select name="nameOfDoctor">
							<%
								// Medical Department objekat koji dobijamo na osnovu onoga sto
								// korisnik prosledjuje
								MedicalDepartment medicalDepartmentObject = MedicalDeparmentDao
										.getMedicalDepartmentObjectByName(department);
								session.setAttribute("medicalDepartment", medicalDepartmentObject);
								
								// Lista svih Medicinskih Stafova koji se nalaze na zeljenom
								// Medical Departmentu
								List<MedicalStaff> listMedicalStaff = MedicalStaffDao
										.getMedicalStaffByMedicalDepartmentID(medicalDepartmentObject
												.getMedicalDepartmentID());

								for (MedicalStaff staff : listMedicalStaff) {
							%>
							<option>
								<%
									if (staff.getUser().getNameOfJob().equals("doctor")){
											out.print(staff.getUser().getNameAndSurname());
									}
								}
								%>
							</option>
					</select></td>
				</tr>
				<tr>
					<td>Select a term :</td>
					<td><select name="dateOfScheduling">
							<%
								List<DateOfScheduling> listDateOfScheduling = DateOfSchedulingDao
										.getAllByMedicalDepartmentID(medicalDepartmentObject
												.getMedicalDepartmentID());

								for (DateOfScheduling date : listDateOfScheduling) {
							%>
							<option>
								<%
									out.print(date.getDateOfScheduling().toLocaleString());
									}
								%>
							</option>

					</select></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Save Appointment" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>