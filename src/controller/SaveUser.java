package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MedicalDeparmentDao;
import dao.MedicalStaffDao;
import dao.UserDao;
import model.MedicalDepartment;
import model.MedicalStaff;
import model.User;

/**
 * Servlet implementation class SaveUser
 */
@WebServlet("/SaveUser")
public class SaveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveUser() {
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
		String medicalDepartment = request.getParameter("medicalDepartment");
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

			// Kreiranje Usera
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

			// Izvlacenje informacije iz baze o Medical Departmentu
			MedicalDepartment department = MedicalDeparmentDao
					.getMedicalDepartmentObjectByName(medicalDepartment);

			// Izvlacenje informacija iz baze o Useru
			User newUser = UserDao.getUserByNameAndPassword(name, password);

			// Kreiranje Medical Staffa
			MedicalStaff staff = new MedicalStaff();
			staff.setUser(newUser);
			staff.setMedicalDepartment(department);
			
			int statusForMedicalStaff = 0;

			if (typeOfUsers.equals("medic")) {
				statusForMedicalStaff = MedicalStaffDao.save(staff);
			}

			if (status > 0) {
				switch (typeOfUsers) {
				case "patient":
					out.print("<p style='color: green;text-align: center;'>Registration for patient saved successfully! Please continue with login!</p>");
					request.getRequestDispatcher("login.html").include(request,
							response);
					break;
				case "medic":
					if (statusForMedicalStaff > 0) {

						out.print("<p style='color: green;text-align: center;'>Registration for medic saved successfully! Please continue with login!</p>");
						request.getRequestDispatcher("login.html").include(
								request, response);
					} else {
						out.println("<p style='color: red;text-align: center;'>Sorry, unable to save record! Please check your database connection!</p>");
						request.getRequestDispatcher("index.jsp").include(
								request, response);
					}
					break;
				default:
					out.println("<p style='color: red;text-align: center;'>Registration saved successfully! Please continue with login!</p>");
					request.getRequestDispatcher("index.jsp").include(request,
							response);
					break;
				}
			} else {
				out.println("<p style='color: red;text-align: center;'>Sorry, unable to save record! Please check your database connection!</p>");
				request.getRequestDispatcher("index.jsp").include(request,
						response);
			}

		} else {
			switch (typeOfUsers) {
			case "patient":
				out.print("<p style='color: red;text-align: center;'>Sorry, your password and repassword is not same! Please repeat the registration!</p>");
				request.getRequestDispatcher("addUserPatient.html").include(
						request, response);
				break;
			case "medic":
				out.print("<p style='color: red;text-align: center;'>Sorry, your password and repassword is not same! Please repeat the registration!</p>");
				request.getRequestDispatcher("addUserMedic.jsp").include(
						request, response);
				break;
			default:
				out.println("<p style='color: red;text-align: center;'>Sorry, your password and repassword is not same! Please repeat the registration!</p>");
				request.getRequestDispatcher("index.jsp").include(request,
						response);
				break;
			}
		}

		out.close();

	}
}
