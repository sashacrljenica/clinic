package model;

import java.sql.Timestamp;
import java.util.Date;

public class LoginCurrent {
	private int loginID;
	private Timestamp loginDateTime;
	private int userID;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getLoginID() {
		return loginID;
	}

	public void setLoginID(int loginID) {
		this.loginID = loginID;
	}

	public Date getLoginDateTime() {
		return loginDateTime;
	}

	public void setLoginDateTime(Timestamp date) {
		this.loginDateTime = date;
	}

}
