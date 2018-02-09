package model;

public class DoctorAppointment {
	private int doctorAppointmentID;
	private DateOfScheduling dateOfScheduling;
	private User user;
	private MedicalStaff medicalStaff;
	private int examined;

	public int getExamined() {
		return examined;
	}

	public void setExamined(int examined) {
		this.examined = examined;
	}

	public int getDoctorAppointmentID() {
		return doctorAppointmentID;
	}

	public void setDoctorAppointmentID(int doctorAppointmentID) {
		this.doctorAppointmentID = doctorAppointmentID;
	}

	public DateOfScheduling getDateOfScheduling() {
		return dateOfScheduling;
	}

	public void setDateOfScheduling(DateOfScheduling dateOfScheduling) {
		this.dateOfScheduling = dateOfScheduling;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MedicalStaff getMedicalStaff() {
		return medicalStaff;
	}

	public void setMedicalStaff(MedicalStaff medicalStaff) {
		this.medicalStaff = medicalStaff;
	}

}
