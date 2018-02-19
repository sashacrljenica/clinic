<%@ page import="java.util.*,dao.*,model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administration View</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body id="body_lightblue">
	<%
		String name = (String) session.getAttribute("name");
		Admin admin = (Admin) session.getAttribute("admin");

		String pageid;
		pageid = request.getParameter("page");
		String totalS;
		totalS = request.getParameter("total");
		String nameLike;
		nameLike = request.getParameter("searchName");
		String emailLike;
		emailLike = request.getParameter("searchEmail");

		int pageidInt;
		int total;

		// Ako je pageid ne postoji, prilikom ucitavanja stranice postavlja se na 1, 
		// u suprotnom dobija vrednost koja se prosledjuje kroz request viewAdmin?page=(broj stranice za prikazati)

		if (pageid == null || pageid.equals("")) {
			pageidInt = 1;
		} else {
			int pageidInt02 = Integer.parseInt(pageid);
			pageidInt = pageidInt02;
		}
		// Ako je total(broj usera koje treba prikazati po strani) prilikom ucitavanja stranice jednak nuli, 
		// onda taj broj inicijalizujemo na 5, proizvoljno.

		if (totalS == null) {
			total = 5;
		} else {
			int totalInt = Integer.parseInt(totalS);
			total = totalInt;
		}

		// Paginacija 
		int pageBase = pageidInt;
		if (pageBase == 1) {
		} else {
			pageBase = pageBase - 1;
			pageBase = pageBase * total + 1;
		}

		// U listu tipa List<User> postavljamo objekte usere iz baze, ograniceno, npr. 5 mogucih
		List<User> list = UserDao.getRecords(pageBase, total);

		// Ako je sledeca stranica koju ucitavamo prazna, onda ostajemo na stranici koja moze da
		// prikaze podatke.
		if (list.isEmpty() && pageidInt != 1) {
			response.sendRedirect("viewAdmin.jsp?page=" + (pageidInt - 1));
		}
		
		// Lista svih Usera
		List<User> listAllUser = UserDao.getAllUsers();

		//Ukupan broj Usera u bazi
		int totalUser = listAllUser.size();

		int pageLast = totalUser / total + 1;

		// Ako je parametar name iz sesije prazan, znaci da se admin izlogovao i sprecavamo neautorizovan pristup stranici!
		if (name == null || admin == null) {
			response.sendRedirect("adminLogin.jsp");
		} else {

			out.println("<div class='fr'><p><a href='LogoutAdmin'>Logout</a></p></div>");

			if (admin.getNameAndSurname() != null) {
				out.print("<div class='fr'><p style='color: blue;'>Hello, "
						+ admin.getNameAndSurname()
						+ " , Welcome to Admin Profile!</p></div>");
			} else {
				out.print("<div class='fr'><p style='color: blue;'>Hello, "
						+ name + " , Welcome to Admin Profile!</p></div>");
			}

			out.println("<h1>Users List</h1>");

			out.print("<h1>Page No: " + pageid + "</h1>");
			// Dodavanje novog usera
			out.println("<a href='addUserAdmin.html'>Add New User</a>");

			// Prikaz ukupnog broja Usera u bazi
			int numberOfUser = UserDao.getAllNumberOfUsers();
			out.print("<p>Total number of Users: " + numberOfUser + "</p>");

			// Prikaz ukupnog broja pacijenata u bazi
			int numberOfUserPatient = UserDao.getAllNumberOfUsersPatient();
			out.print("<p>Total number of Patients: " + numberOfUserPatient
					+ "</p>");

			// Prikaz ukupnog broja pacijenata u bazi
			int numberOfUserMedic = UserDao.getAllNumberOfUsersMedic();
			out.print("<p>Total number of Medic: " + numberOfUserMedic
					+ "</p>");

			// Prikaz tabele sa Userima
			out.print("<table border='1' width='100%'");
			out.print("<tr><th>Id</th><th>UserName</th><th>Password</th><th>NameAndSurname</th><th>Address</th><th>PhoneNumber</th><th>Email</th><th>NumberOfIdCard</th><th>BloodType</th><th>Sex</th><th>NameOfJob</th><th>TypeOfUsers</th><th>Edit</th><th>Delete</th></tr>");
			for (User e : list) {
				out.print("<tr><td>" + e.getUserID() + "</td><td>"
						+ e.getUserName() + "</td><td>" + e.getPassword()
						+ "</td><td>" + e.getNameAndSurname() + "</td><td>"
						+ e.getAddress() + "</td><td>" + e.getPhoneNumber()
						+ "</td><td>" + e.getEmail() + "</td><td>"
						+ e.getNumberOfIDCard() + "</td><td>"
						+ e.getBloodType() + "</td><td>" + e.getSex()
						+ "</td><td>" + e.getNameOfJob() + "</td><td>"
						+ e.getTypeOfUsers()
						+ "</td><td><a href='editUser.jsp?id="
						+ e.getUserID()
						+ "'>edit</a></td><td><a href='Delete?id="
						+ e.getUserID() + "'>delete</a></td></tr>");
			}
			out.print("</table>");
			out.print("<br>");

			out.print("<a href='viewAdmin.jsp?page=1" + "'>Page 1 | </a>");
			out.print(pageid);
			out.print("&nbsp");
			if (pageidInt == 1) {
				out.print("<a href='viewAdmin.jsp?page=1'"
						+ ">Previous... </a>");
			} else {
				out.print("<a href='viewAdmin.jsp?page=" + (pageidInt - 1)
						+ "'>Previous... </a>");
			}

			out.print("<a href='viewAdmin.jsp?page=" + (pageidInt + 1)
					+ "'> | ...Next</a>");
			
			out.print("<a href='viewAdmin.jsp?page=" + pageLast
					+ "'> | ...Page Last</a>");

		}
	%>
	<br>
	<br>
	<div class="fl">
		<!-- 	Forma za prikaz zeljenog broja Usera po stranici -->
		<form action="viewAdmin.jsp">
			Please enter the number of page to view:<br>
			<input type="number" name="page" min="1" value="1" /><br>
			Please enter total number of user per page:<br>
			<input type=number name="total" min="1" value="5" />
			<input type="submit" value="enter" />
		</form>
	</div>
	<div class="fl">
		<!-- Forma za pretragu Usera po imenu -->
		<form action="viewAdmin.jsp">
			<input type="hidden" name="page" value="1" />
			Please enter Name for search:<br> 
			<input type="text" name="searchName" />
			<input type="submit" value="enter" />
		</form>
	
		<!-- Forma za pretragu Usera po emailu -->
		<form action="viewAdmin.jsp">
			<input type="hidden" name="page" value="1" />
			Please enter Email for search:<br> 
			<input type="text" name="searchEmail" />
			<input type="submit" value="enter" />
		</form>
		<br>
	</div>
	<div class="fl">
		<!-- Forma za pretragu logovanih Usera  -->
		<form action="viewLoginUser.jsp">
			<input type="hidden" name="page" value="1" />
			<input type="hidden" name="total" value="5" />
			Search logged User: 
			<input type="submit" value="view Logged" />
		</form>
	</div>
	<div  id="clear"></div>
	<hr>
	
	<%
		List<User> listUserName = UserDao.getAllUsersName(nameLike);
		List<User> listUserEmail = UserDao.getAllUsersEmail(emailLike);

		// Prikaz tabela za pretragu po imenu i emailu
		if (!listUserName.isEmpty()) {
			out.print("<table border='1' width='100%'");
			out.print("<tr><th>Id</th><th>UserName</th><th>Password</th><th>NameAndSurname</th><th>Address</th><th>PhoneNumber</th><th>Email</th><th>NumberOfIdCard</th><th>BloodType</th><th>Sex</th><th>NameOfJob</th><th>TypeOfUsers</th><th>Edit</th><th>Delete</th></tr>");
			for (User e : listUserName) {
				out.print("<tr><td>" + e.getUserID() + "</td><td>"
						+ e.getUserName() + "</td><td>" + e.getPassword()
						+ "</td><td>" + e.getNameAndSurname() + "</td><td>"
						+ e.getAddress() + "</td><td>" + e.getPhoneNumber()
						+ "</td><td>" + e.getEmail() + "</td><td>"
						+ e.getNumberOfIDCard() + "</td><td>"
						+ e.getBloodType() + "</td><td>" + e.getSex()
						+ "</td><td>" + e.getNameOfJob() + "</td><td>"
						+ e.getTypeOfUsers()
						+ "</td><td><a href='editUser.jsp?id="
						+ e.getUserID()
						+ "'>edit</a></td><td><a href='Delete?id="
						+ e.getUserID() + "'>delete</a></td></tr>");
			}
			out.print("</table>");
		}
		if (!listUserEmail.isEmpty()) {
			out.print("<table border='1' width='100%'");
			out.print("<tr><th>Id</th><th>UserName</th><th>Password</th><th>NameAndSurname</th><th>Address</th><th>PhoneNumber</th><th>Email</th><th>NumberOfIdCard</th><th>BloodType</th><th>Sex</th><th>NameOfJob</th><th>TypeOfUsers</th><th>Edit</th><th>Delete</th></tr>");
			for (User e : listUserEmail) {
				out.print("<tr><td>" + e.getUserID() + "</td><td>"
						+ e.getUserName() + "</td><td>" + e.getPassword()
						+ "</td><td>" + e.getNameAndSurname() + "</td><td>"
						+ e.getAddress() + "</td><td>" + e.getPhoneNumber()
						+ "</td><td>" + e.getEmail() + "</td><td>"
						+ e.getNumberOfIDCard() + "</td><td>"
						+ e.getBloodType() + "</td><td>" + e.getSex()
						+ "</td><td>" + e.getNameOfJob() + "</td><td>"
						+ e.getTypeOfUsers()
						+ "</td><td><a href='editUser.jsp?id="
						+ e.getUserID()
						+ "'>edit</a></td><td><a href='Delete?id="
						+ e.getUserID() + "'>delete</a></td></tr>");
			}
			out.print("</table>");
		}
	%>
	<div id="footer">&copy Copyright Sasha Crljenica 2018</div>
</body>
</html>