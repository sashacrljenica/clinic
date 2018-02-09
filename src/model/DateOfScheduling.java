package model;

import java.sql.Timestamp;

public class DateOfScheduling {

	private int dateOfSchedulingID;
	private Timestamp dateOfScheduling;
	private int scheduled;
	private MedicalDepartment department;

	public int getDateOfSchedulingID() {
		return dateOfSchedulingID;
	}

	public void setDateOfSchedulingID(int dateOfSchedulingID) {
		this.dateOfSchedulingID = dateOfSchedulingID;
	}

	public Timestamp getDateOfScheduling() {
		return dateOfScheduling;
	}

	public void setDateOfScheduling(Timestamp dateOfScheduling) {
		this.dateOfScheduling = dateOfScheduling;
	}

	public int getScheduled() {
		return scheduled;
	}

	public void setScheduled(int scheduled) {
		this.scheduled = scheduled;
	}

	public MedicalDepartment getDepartment() {
		return department;
	}

	public void setDepartment(MedicalDepartment department) {
		this.department = department;
	}

}
