package model;

public class MedicalDepartment {
	private int medicalDepartmentID;
	private String nameOfDepartment, contactPhone;

	public int getMedicalDepartmentID() {
		return medicalDepartmentID;
	}

	public void setMedicalDepartmentID(int medicalDepartmentID) {
		this.medicalDepartmentID = medicalDepartmentID;
	}

	public String getNameOfDepartment() {
		return nameOfDepartment;
	}

	public void setNameOfDepartment(String nameOfDepartment) {
		this.nameOfDepartment = nameOfDepartment;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

}
