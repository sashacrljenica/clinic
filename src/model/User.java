package model;

public class User {
	private int userID;
	private String userName, password, nameAndSurname, address, phoneNumber,
			email, numberOfIDCard, bloodType, sex, nameOfJob, typeOfUsers;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNameAndSurname() {
		return nameAndSurname;
	}

	public void setNameAndSurname(String nameAndSurname) {
		this.nameAndSurname = nameAndSurname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumberOfIDCard() {
		return numberOfIDCard;
	}

	public void setNumberOfIDCard(String numberOfIDCard) {
		this.numberOfIDCard = numberOfIDCard;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNameOfJob() {
		return nameOfJob;
	}

	public void setNameOfJob(String nameOfJob) {
		this.nameOfJob = nameOfJob;
	}

	public String getTypeOfUsers() {
		return typeOfUsers;
	}

	public void setTypeOfUsers(String typeOfUsers) {
		this.typeOfUsers = typeOfUsers;
	}

}
