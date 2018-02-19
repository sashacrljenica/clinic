<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Logged User</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body id="body_lightblue">
<%@ page import="java.util.*,dao.*,model.*"%>
	<%
		String pageid;
			pageid = request.getParameter("page");
			String totalS;
			totalS = request.getParameter("total");
			
			int pageidInt;
			int total;
			
			if (pageid == null || pageid.equals("")) {
		pageidInt = 1;
			} else {
		int pageidInt02 = Integer.parseInt(pageid);
		pageidInt = pageidInt02;
			}
			
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
			
		// Lista svih logovanih Usera
		List<Login> listAllLoginUser = LoginDao.getAllLogin();

		//Ukupan broj Usera u bazi
		int totalUser = listAllLoginUser.size();

		int pageLast = totalUser / total + 1;
	%>
	
	<a href="viewAdmin.jsp?page=1">Back to Home page of admin</a>
	<br><br>
	<h1 id="center">Table of Login User:</h1>
	
	<%
			List<Login> listLogin = LoginDao.getRecords(pageBase, total);
// 			List<User> listUser = UserDao.getAllUsers();
// 			List<Login> listLogin=LoginDao.getAllLogin();
			
			if (listLogin.isEmpty() && pageidInt != 1) {
				response.sendRedirect("viewLoginUser.jsp?page=" + (pageidInt - 1));
			}
			// Prikaz tabele logovanih Usera
			if (!listLogin.isEmpty()) {
				out.print("<table border='1' width='100%'");
				out.print("<tr><th>LoginID</th><th>LoginDateTime</th><th>UserName</th><th>Type of User</th><th>Edit</th><th>Delete</th></tr>");
				for (Login e : listLogin) {
					out.print("<tr><td>"
							+ e.getLoginID()
							+ "</td><td>"
							+ e.getDatetime().toLocaleString()
							+ "</td><td>"
							+ e.getUser().getNameAndSurname() +

							"</td><td>"+ e.getUser().getTypeOfUsers() + "<td><a href='editUser.jsp?id="
							+ e.getUser().getUserID()
							+ "'>edit</a></td><td><a href='Delete?id="
							+ e.getUser().getUserID()
							+ "'>delete</a></td></tr>");
				}
				out.print("</table>");
				out.print("<br>");

				out.print("<a href='viewLoginUser.jsp?page=1"
						+ "'>Page 1 | </a>");
				out.print(pageid);
				out.print("&nbsp");
				if (pageidInt == 1) {
					out.print("<a href='viewLoginUser.jsp?page=1'"
							+ ">Previous... </a>");
				} else {
					out.print("<a href='viewLoginUser.jsp?page="
							+ (pageidInt - 1) + "'>Previous... </a>");
				}

				out.print("<a href='viewLoginUser.jsp?page=" + (pageidInt + 1)
						+ "'> | ...Next</a>");
				
				out.print("<a href='viewLoginUser.jsp?page=" + pageLast
						+ "'> | ...Page Last</a>");
			}

// 			out.print("<p>Ime Usera na poziciji 4 u listi: " + listLogin. + "</p>");
		%>
		<h3>Drugi nacin</h3>
	<%
		List<LoginCurrentInner> listLoginInner = LoginDao.getAllLoginUsersByName();

		if (!listLogin.isEmpty()) {
			out.print("<table border='1' width='100%'");
			out.print("<tr><th>LoginID</th><th>LoginDateTime</th><th>UserName</th></tr>");
			for (LoginCurrentInner l : listLoginInner) {
				out.print("<tr><td>" + l.getLoginCurrentID() + "</td><td>"
						+ l.getDatetime().toLocaleString() + "</td><td>"
						+ l.getNameAndSurname() + "</td></tr>");
			}
			out.print("</table>");
			out.print("<br>");
		}
		
// 		out.print("<h3>Treci nacin</h3>");
		
		//  3. NacinPrikaz tabele logovanih Usera
// 		List<Login> listLogin03 = LoginDao.getAllLogin();
// 		if (!listLogin03.isEmpty()) {
// 			out.print("<table border='1' width='100%'");
// 			out.print("<tr><th>LoginID</th><th>LoginDateTime</th><th>UserID</th><th>Edit</th><th>Delete</th></tr>");
// 			for (Login user : listLogin03) {
// 				out.print("<tr><td>" + user.getLoginID() + "</td><td>"
// 						+ user.getDatetime().toLocaleString() + "</td><td>"
// 						+ user.getUser().getNameAndSurname() +

// 						"</td>" + "<td><a href='editUser.jsp?id="
// 						+ user.getUser().getUserID()
// 						+ "'>edit</a></td><td><a href='Delete?id="
// 						+ user.getUser().getUserID()
// 						+ "'>delete</a></td></tr>");
// 			}
// 			out.print("</table>");
// 		}
	%>
</body>
</html>