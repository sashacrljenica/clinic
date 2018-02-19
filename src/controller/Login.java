package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import model.User;
import dao.AdminDao;
import dao.LoginDao;
import dao.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
		// request.getRequestDispatcher("link.html").include(request, response);

		String n = request.getParameter("name");
		String p = request.getParameter("password");

		User user = UserDao.getUserByNameAndPassword(n, p);
		Admin admin = AdminDao.getAdminByNameAndPassword(n, p);

		HttpSession session = request.getSession();

		if ((n.equals("admin") && p.equals("admin") || AdminDao.validateAdmin(
				n, p))) {
			session.setAttribute("name", n);
			session.setAttribute("admin", admin);
			response.sendRedirect("viewAdmin.jsp?page=1");
		} else if (UserDao.validatePatient(n, p)) {
			session.setAttribute("name", n);
			session.setAttribute("user", user);
			// Da bi snimili tekuceg korisnika koji se loguje u tabelu
			LoginDao.save(user);
			response.sendRedirect("doctorAppointment.jsp");
		} else if (UserDao.validateMedic(n, p) && user.getNameOfJob().equals("doctor")) {
			session.setAttribute("name", n);
			session.setAttribute("user", user);
			LoginDao.save(user);
			response.sendRedirect("takeMedication.jsp");
		} else if (UserDao.validateMedic(n, p) && !user.getNameOfJob().equals("doctor")) {
			session.setAttribute("name", n);
			session.setAttribute("user", user);
			LoginDao.save(user);
			response.sendRedirect("medicalStaffTools.jsp");
		} 
		
		else {
			out.print("<p style='text-align: center;color: red;'>Sorry username or password error! If You are not registered please register now!</p>");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
		out.close();

	}

}
