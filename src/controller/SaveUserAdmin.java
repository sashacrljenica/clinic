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
 * Servlet implementation class SaveUserAdmin
 */
@WebServlet("/SaveUserAdmin")
public class SaveUserAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveUserAdmin() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

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

		if (UserDao.validateByUserNameExist(name)
				&& typeOfUsers.equals("patient")) {
			out.println("<p style='color: red;text-align: center;'>User name for patient exist, please choice another User name for registration!</p>");
			request.getRequestDispatcher("addUserPatient.html").include(
					request, response);
		} else if (UserDao.validateByUserNameExist(name)
				&& typeOfUsers.equals("medic")) {
			out.println("<p style='color: red;text-align: center;'>User name for medic exist, please choice another User name for registration!</p>");
			request.getRequestDispatcher("addUserMedic.html").include(request,
					response);
		} else if (password.equals(repassword)) {

			User u = new User();
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

			int status = UserDao.save(u);
			if (status > 0) {
				out.print("<p style='color: lightblue;'>Registration saved successfully!</p>");
//				request.getRequestDispatcher("viewAdmin.jsp?page=1").include(
//						request, response);
				response.sendRedirect("viewAdmin.jsp?page=1");
			} else {
				out.println("<p style='color: red;'>Sorry, unable to save record!</p>");
				request.getRequestDispatcher("viewAdmin.jsp?page=1").include(
						request, response);
			}

		} else {
			out.print("<p style='color: red;'>Sorry, your password and repassword is not same! Please repeat registration!</p>");
			request.getRequestDispatcher("addUserAdmin.html").include(request,
					response);
		}

		out.close();

	}

}
