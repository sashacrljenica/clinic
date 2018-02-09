package model;

public class MedicalStaff {
	private int medicalStaffID;
	private User user;
	private MedicalDepartment medicalDepartment;

	public int getMedicalStaffID() {
		return medicalStaffID;
	}

	public void setMedicalStaffID(int medicalStaffID) {
		this.medicalStaffID = medicalStaffID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MedicalDepartment getMedicalDepartment() {
		return medicalDepartment;
	}

	public void setMedicalDepartment(MedicalDepartment medicalDepartment) {
		this.medicalDepartment = medicalDepartment;
	}

}
