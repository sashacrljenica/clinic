package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Edit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String userIdS = request.getParameter("userID");
		int userId = Integer.parseInt(userIdS);
		String name = request.getParameter("userName");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String nameAndSurname = request.getParameter("nameAndSurname");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		String numberOfIdCard = request.getParameter("numberOfIdCard");
		String bloodType = request.getParameter("bloodType");
		String sex = request.getParameter("sex");
		String nameOfJob = request.getParameter("nameOfJob");
		String typeOfUsers = request.getParameter("typeOfUsers");

		User u = new User();
		u.setUserID(userId);
		u.setUserName(name);
		u.setPassword(password);
		u.setNameAndSurname(nameAndSurname);
		u.setAddress(address);
		u.setPhoneNumber(phoneNumber);
		u.setEmail(email);
		u.setNumberOfIDCard(numberOfIdCard);
		u.setBloodType(bloodType);
		u.setSex(sex);
		u.setNameOfJob(nameOfJob);
		u.setTypeOfUsers(typeOfUsers);

//		if (UserDao.validateByUserNameExist(name)
//				&& typeOfUsers.equals("patient")) {
//			out.println("<p style='color: red;text-align: center;'>User name for patient exist, please choice another User name for updating!</p>");
//			request.getRequestDispatcher("addUserPatient.html").include(
//					request, response);
//		} else if (UserDao.validateByUserNameExist(name)
//				&& typeOfUsers.equals("medic")) {
//			out.println("<p style='color: red;text-align: center;'>User name for medic exist, please choice another User name for updating!</p>");
//			request.getRequestDispatcher("addUserMedic.html").include(request,
//					response);
//		} else 
			if (password.equals(repassword)) {

			int status = UserDao.update(u);
			if (status > 0) {
				out.print("<p style='color: lightblue;'>Updating saved successfully!</p>");
//				request.getRequestDispatcher("viewAdmin.jsp?page=1").include(
//						request, response);
				 response.sendRedirect("viewAdmin.jsp?page=1");
			} else {
				out.println("<p style='color: red;'>Sorry, unable to update user!</p>");
				request.getRequestDispatcher("viewAdmin.jsp?page=1").include(
						request, response);
			}

		} else {
			out.print("<p style='color: red;'>Sorry, your password and repassword is not same! Please repeat updating!</p>");
			request.getRequestDispatcher("editUser.jsp?id=" + u.getUserID())
					.include(request, response);
		}

		out.close();
	}

}
