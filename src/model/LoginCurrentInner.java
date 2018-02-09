package model;

import java.sql.Timestamp;

public class LoginCurrentInner {
	private int loginCurrentID;
	private Timestamp datetime;
	private String nameAndSurname;

	public int getLoginCurrentID() {
		return loginCurrentID;
	}

	public void setLoginCurrentID(int loginCurrentID) {
		this.loginCurrentID = loginCurrentID;
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public String getNameAndSurname() {
		return nameAndSurname;
	}

	public void setNameAndSurname(String nameAndSurname) {
		this.nameAndSurname = nameAndSurname;
	}

}
