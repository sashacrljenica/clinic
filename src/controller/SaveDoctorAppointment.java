package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DateOfSchedulingDao;
import dao.DoctorAppointmentDao;
import dao.MedicalStaffDao;
import dao.UserDao;
import model.DateOfScheduling;
import model.MedicalDepartment;
import model.MedicalStaff;
import model.User;

/**
 * Servlet implementation class SaveDoctorAppointment
 */
@WebServlet("/SaveDoctorAppointment")
public class SaveDoctorAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveDoctorAppointment() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if (user == null) {
			out.print("<p style='text-align: center;color: red;'>Sorry, you must login first!</p>");
			request.getRequestDispatcher("login.html").include(request,
					response);
			// response.sendRedirect("login.html");
		}

		MedicalDepartment department = (MedicalDepartment) session
				.getAttribute("medicalDepartment");

		String nameOfDoctor = request.getParameter("nameOfDoctor");
		String dateOfScheduling = request.getParameter("dateOfScheduling");

		String splitPattern = " ";
		String splitPattern02 = "\\.";
		String[] dateOfSchedulingForm = dateOfScheduling.split(splitPattern);
		String string01 = dateOfSchedulingForm[0];
		String[] dateOfSchedulingForm02 = string01.split(splitPattern02);

		String dateOfSchedulingConcat = dateOfSchedulingForm02[2] + "-"
				+ dateOfSchedulingForm02[1] + "-" + dateOfSchedulingForm02[0]
				+ " " + dateOfSchedulingForm[1];

		User medicalStaffUser = UserDao.getUserByNameAndSurname(nameOfDoctor);
		MedicalStaff medicalStaff = MedicalStaffDao
				.getMedicalStaffByUserIDAndMedicalDepartmentID(
						medicalStaffUser.getUserID(),
						department.getMedicalDepartmentID());

		DateOfScheduling dateOfSchedulingObject = DateOfSchedulingDao
				.getDateOfSchedulingObjectByDateOfSchedulingAndMedicalDepartmentID(
						dateOfSchedulingConcat,
						department.getMedicalDepartmentID());

//		out.print("<p>Name of Doctor: " + nameOfDoctor + " !!!</p>");
//		out.print("<p>DateOfScheduling: " + dateOfScheduling + " !!!</p>");
//		out.print("<p>DateOfSchedulingConcat: " + dateOfSchedulingConcat
//				+ " !!!</p>");
//		out.print("<p>DepartmentID: " + department.getNameOfDepartment()
//				+ " !!!</p>");
//
//		out.print("<p>UserID: " + user.getUserID() + " !!!</p>");
//		out.print("<p>MedicalStaffUserID: " + medicalStaffUser.getUserID()
//				+ " !!!</p>");
//
//		out.print("<p>MedicalStaffID: " + medicalStaff.getMedicalStaffID()
//				+ " !!!</p>");
//
//		out.print("<p>DateOfSchedulingID: "
//				+ dateOfSchedulingObject.getDateOfSchedulingID() + " !!!</p>");

		int statusUpdateScheduledTo1 = DateOfSchedulingDao
				.updateScheduledTo1(dateOfSchedulingObject
						.getDateOfSchedulingID());
		int statusSaveDoctorAppointment = DoctorAppointmentDao.save(
				user.getUserID(), medicalStaff.getMedicalStaffID(),
				dateOfSchedulingObject.getDateOfSchedulingID());

		if (statusUpdateScheduledTo1 > 0 && statusSaveDoctorAppointment > 0) {
//			out.print("<p style='color: green;'>Doctor Appointment saved successfully!</p>");
//			request.getRequestDispatcher("doctorAppointmentSuccess.jsp")
//					.include(request, response);
			session.setAttribute("user", user);
			session.setAttribute("department", department);
			session.setAttribute("dateOfScheduling", dateOfSchedulingObject);
			session.setAttribute("doctor", medicalStaffUser);
//			request.getRequestDispatcher("doctorAppointmentSuccess.jsp").include(
//					request, response);
			 response.sendRedirect("doctorAppointmentSuccess.jsp");
		} else {
			out.println("<p style='color: red;'>Sorry, unable to save Doctor Appointment! Please try again!</p>");
			session.setAttribute("user", user);
			request.getRequestDispatcher("doctorAppointment.jsp").include(
					request, response);
		}

		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
