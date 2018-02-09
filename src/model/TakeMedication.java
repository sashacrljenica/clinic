package model;

import java.sql.Timestamp;
import java.util.Date;

public class TakeMedication {
	private int takeMedicationID;
	private Timestamp dateOfTaking;
	private User user;
	private MedicalStaff medicalStaff;
	private Pharmacy pharmacy;

	public int getTakeMedicationID() {
		return takeMedicationID;
	}

	public void setTakeMedicationID(int takeMedicationID) {
		this.takeMedicationID = takeMedicationID;
	}

	public Timestamp getDateOfTaking() {
		return dateOfTaking;
	}

	public void setDateOfTaking(Timestamp dateOfTaking) {
		this.dateOfTaking = dateOfTaking;
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

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

}
