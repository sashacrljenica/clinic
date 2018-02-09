package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import dao.AdminDao;

/**
 * Servlet implementation class Administration
 */
@WebServlet("/Administration")
public class Administration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Administration() {
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

		String n = request.getParameter("name");
		String p = request.getParameter("password");
		
		Admin admin = AdminDao.getAdminByNameAndPassword(n, p);

		HttpSession session = request.getSession();

		if ((n.equals("admin") && p.equals("admin"))
				|| AdminDao.validateAdmin(n, p)) {
			session.setAttribute("name", n);
			session.setAttribute("admin", admin);
			response.sendRedirect("viewAdmin.jsp?page=1");
		} else if (!AdminDao.validateAdmin(n, p)) {
			out.print("<p style='color: red;text-align: center;'>Sorry admin NOT exist, please register Administration user!</p>");
			request.getRequestDispatcher("addAdmin.jsp").include(request,
					response);
		} else {
			out.print("<p style='color: red;text-align: center;'>Sorry, username or password error! Please repeat entry!</p>");
			request.getRequestDispatcher("adminLogin.jsp").include(request,
					response);
		}
		out.close();

	}

}
