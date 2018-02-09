package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DoctorAppointmentDao;
import dao.PharmacyDao;
import dao.TakeMedicationDao;
import dao.UserDao;
import model.DoctorAppointment;
import model.MedicalStaff;
import model.Pharmacy;
import model.TakeMedication;
import model.User;

/**
 * Servlet implementation class TakeMedications
 */
@WebServlet("/TakeMedicationPatient")
public class TakeMedicationPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TakeMedicationPatient() {
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
		}

		MedicalStaff medicalStaff = (MedicalStaff) session
				.getAttribute("medicalStaff");

		String patientIDString = request.getParameter("patientID");
		int patientID = Integer.parseInt(patientIDString);

		String pharmacyIDString = request.getParameter("pharmacyID");
		int pharmacyID = Integer.parseInt(pharmacyIDString);

		String quantityString = request.getParameter("quantity");
		int quantityInt = Integer.parseInt(quantityString);
		int quantity = quantityInt;

		// Podaci o pacijent smesteni o objekat patientObject zbog sesije
		User patientObject = UserDao.getUserById(patientID);

		// izvlacimo objekat sa podacima iz tabele Pharmacy
		Pharmacy pharmacyObject = PharmacyDao.getPharmacyById(pharmacyID);

		// izvlacimo kolicinu lekova za objekat pharmacyObject
		int quantityOnCondition = pharmacyObject.getQuantityOnCondition();

		// Nova kolicina lekova nakon sto smo izdali lekove pacijentu
		int newQuantity;
		newQuantity = quantityOnCondition - quantity;

		// Upisujemo novo stanje u tabelu tblPharmacy
		int statusQuantity = PharmacyDao.updateQuantityOnCondition(newQuantity,
				pharmacyID);

		// Novi podaci iz tabele Pharmacy, zbog sesije
		Pharmacy pharmacyObjectNew = PharmacyDao.getPharmacyById(pharmacyID);

		// Snimamo u tabelu tblTakeMedication UserID, MedicalStaffID, PharmacyID
		int statusTakeMedication = TakeMedicationDao.save(patientID,
				medicalStaff.getMedicalStaffID(), pharmacyID);

		// Iz tabele tblDoctorAppointment izvlacimo objekat
		// doctorAppointmentObject na osnovu UserID i MedicalStaffID
		DoctorAppointment doctorAppointmentObject = DoctorAppointmentDao
				.getDoctorAppointmentObjectByUserIDAndMedicalStaffID(patientID,
						medicalStaff.getMedicalStaffID());

		// Iz tabele tblTakeMedications izvlacimo podatke, zbog sesije
		TakeMedication takeMedicationObject = TakeMedicationDao
				.getTakeMedicationObjectByUserIDAndMedicalStaffID(patientID,
						medicalStaff.getMedicalStaffID());

		// U tabeli tblDoctorAppointment menjamo atribut u koloni Examined sa 0
		// na 1 da obelezimo da je za tog pacijenta obavljen pregled.
		// To radimo na nacin da prosledimo objekat iz tabele
		// tblDoctorAppointments za koji zelimo da izvrsimo promenu.
		int statusExaminedTo1 = DoctorAppointmentDao
				.updateExaminedTo1(doctorAppointmentObject
						.getDoctorAppointmentID());

		// Postavljamo sesije koje prenosimo na sledecu stranicu

		if (statusTakeMedication > 0 && statusExaminedTo1 > 0
				&& statusQuantity > 0) {
			session.setAttribute("user", user);
			session.setAttribute("medicalStaff", medicalStaff);
			session.setAttribute("patientObject", patientObject);
			session.setAttribute("pharmacyObject", pharmacyObject);
			session.setAttribute("pharmacyObjectNew", pharmacyObjectNew);
			session.setAttribute("doctorAppointmentObject",
					doctorAppointmentObject);
			session.setAttribute("takeMedicationObject", takeMedicationObject);
			response.sendRedirect("takeMedicationWithPatient.jsp");
		} else {
			out.println("<p style='color: red;'>Sorry, unable to save record, please try again!</p>");
			request.getRequestDispatcher("takeMedication.jsp").include(request,
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
