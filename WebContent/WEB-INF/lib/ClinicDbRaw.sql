CREATE DATABASE clinicDB; 

create TABLE tblUsers(
UserID int NOT NULL AUTO_INCREMENT,
UserName VARCHAR(50) NOT NULL,
Password VARCHAR(50) NOT NULL,
NameAndSurname VARCHAR(50) NOT NULL,
Address VARCHAR(50) NOT NULL,
PhoneNumber VARCHAR(50) NOT NULL,
Email VARCHAR(50) NOT NULL,
NumberOfIdCard VARCHAR(50) NOT NULL,
BloodType VARCHAR(10) NOT NULL,
Sex VARCHAR(10) NOT NULL,
NameOfJob VARCHAR(20),
TypeOfUsers VARCHAR(10) NOT NULL,
PRIMARY KEY (UserID)
);

create table tblMedicalDepartments(
MedicalDepartmentID INT NOT NULL AUTO_INCREMENT,
NameOfDepartment varchar(50) NOT NULL,
ContactPhone VARCHAR(50) NOT NULL, 
PRIMARY KEY (MedicalDepartmentID)
);

create table tblDateOfScheduling(
DateOfSchedulingID INT NOT NULL AUTO_INCREMENT,
DateOfScheduling datetime NOT NULL,
Scheduled tinyint(1) NOT NULL,
MedicalDepartmentID INT NOT NULL,
PRIMARY KEY (DateOfSchedulingID),
FOREIGN KEY (MedicalDepartmentID) REFERENCES tblMedicalDepartments(MedicalDepartmentID)
);

create TABLE tblMedicalStaffs(
MedicalStaffID int NOT NULL AUTO_INCREMENT,
UserID int NOT NULL,
MedicalDepartmentID INT NOT NULL,
PRIMARY KEY (MedicalStaffID),
FOREIGN KEY (UserID) REFERENCES tblUsers(UserID),
FOREIGN KEY (MedicalDepartmentID) REFERENCES tblMedicalDepartments(MedicalDepartmentID)
);

create TABLE tblDoctorAppointments(
DoctorAppointmentID int NOT NULL AUTO_INCREMENT,
UserID int NOT NULL,
MedicalStaffID int NOT NULL,
DateOfSchedulingID int NOT NULL,
Examined tinyint(1) NOT NULL,
PRIMARY KEY (DoctorAppointmentID),
FOREIGN KEY (UserID) REFERENCES tblUsers(UserID),
FOREIGN KEY (MedicalStaffID) REFERENCES tblMedicalStaffs(MedicalStaffID),
FOREIGN KEY (DateOfSchedulingID) REFERENCES tblDateOfScheduling(DateOfSchedulingID)
);

create table tblManufacturers(
ManufacturerID INT NOT NULL AUTO_INCREMENT,
Name varchar(50) NOT NULL,
Address varchar(50) NOT NULL,
ContactPhone VARCHAR(50) NOT NULL,
Email VARCHAR(50) NOT NULL,
Note VARCHAR(50), 
PRIMARY KEY (ManufacturerID)
);

create TABLE tblPharmacy(
PharmacyID int NOT NULL AUTO_INCREMENT,
NameOfTheDrug VARCHAR(50) NOT NULL,
ScopeOfApplication VARCHAR(50) NOT NULL,
QuantityOnCondition int NOT NULL,
Note VARCHAR(50) NOT NULL,
ManufacturerID INT NOT NULL,
PRIMARY KEY (PharmacyID),
FOREIGN KEY (ManufacturerID) REFERENCES tblManufacturers(ManufacturerID)
);

create TABLE tblTakeMedications(
TakeMedicationID int NOT NULL AUTO_INCREMENT,
DateOfTaking timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
UserID int NOT NULL,
MedicalStaffID int NOT NULL,
PharmacyID int NOT NULL,
PRIMARY KEY (TakeMedicationID),
FOREIGN KEY (UserID) REFERENCES tblUsers(UserID),
FOREIGN KEY (MedicalStaffID) REFERENCES tblMedicalStaffs(MedicalStaffID),
FOREIGN KEY (PharmacyID) REFERENCES tblPharmacy(PharmacyID)
);

create TABLE tblLogin(
LoginID int NOT NULL AUTO_INCREMENT,
LoginDateTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
UserID int NOT NULL,
PRIMARY KEY (LoginID),
FOREIGN KEY (UserID) REFERENCES tblUsers(UserID)
);

create TABLE tblAdmin(
AdminID int NOT NULL AUTO_INCREMENT,
NameAndSurname VARCHAR(50) NOT NULL,
UserName VARCHAR(50) NOT NULL,
Password VARCHAR(50) NOT NULL,
PRIMARY KEY (AdminID)
);

