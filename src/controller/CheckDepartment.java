package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import dao.DateOfSchedulingDao;

/**
 * Servlet implementation class CheckDepartment
 */
@WebServlet("/CheckDepartment")
public class CheckDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckDepartment() {
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

		String department = request.getParameter("medicalDepartment");
		
		User user = (User) session.getAttribute("user");

		boolean status = DateOfSchedulingDao
				.validateDateOfSchedulingByMedicalDepartmentExist(department);
		if (status) {
			session.setAttribute("user", user);
			session.setAttribute("medicalDepartment", department);
			out.print("<p style='color: green;text-align: center;'>There are vacant terms at the chosen medical department, please choose the desired term and the name of the doctor you want to schedule a review!</p>");
			request.getRequestDispatcher("doctorAppointment02.jsp").include(
					request, response);
			// response.sendRedirect("viewAdmin.jsp?page=1");
		} else {
			out.println("<p style='color: red;text-align: center;'>Sorry, there are no free terms at the chosen medical department!</p>");
			request.getRequestDispatcher("doctorAppointment.jsp").include(
					request, response);
		}
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
