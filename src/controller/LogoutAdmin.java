package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutAdmin
 */
@WebServlet("/LogoutAdmin")
public class LogoutAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogoutAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

//		request.getRequestDispatcher("linkAdmin.jsp")
//				.include(request, response);

		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");

		if (name != null) {

			out.print("<p style='text-align: center;'>" + name
					+ ", you are successfully logged out!</p>");

			session.invalidate();

			request.getRequestDispatcher("index.jsp")
					.include(request, response);
		} else {
			out.print("<p style='text-align: center;color: red;'>Please login first!</p>");
			request.getRequestDispatcher("adminLogin.jsp").include(request,
					response);
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
