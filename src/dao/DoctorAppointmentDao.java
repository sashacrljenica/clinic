package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DoctorAppointment;

public class DoctorAppointmentDao {
	
	public static DoctorAppointment getDoctorAppointmentById(int id) {
		DoctorAppointment doctorApp = new DoctorAppointment();
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblDoctorAppointments where DoctorAppointmentID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				doctorApp.setDoctorAppointmentID(rs.getInt(1));
				doctorApp.setUser(UserDao.getUserById(rs.getInt(2)));
				doctorApp.setMedicalStaff(MedicalStaffDao
						.getMedicalStaffById(rs.getInt(3)));
				doctorApp.setDateOfScheduling(DateOfSchedulingDao
						.getDateOfSchedulingById(rs.getInt(4)));
				doctorApp.setExamined(rs.getInt(5));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return doctorApp;
	}

	public static List<DoctorAppointment> getDoctorAppointmentByMedicalStaffID(
			int id) {
		List<DoctorAppointment> listDoctorAppointment = new ArrayList<DoctorAppointment>();
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblDoctorAppointments where MedicalStaffID=? And Examined=0;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DoctorAppointment doctorApp = new DoctorAppointment();

				doctorApp.setDoctorAppointmentID(rs.getInt(1));
				doctorApp.setUser(UserDao.getUserById(rs.getInt(2)));
				doctorApp.setMedicalStaff(MedicalStaffDao
						.getMedicalStaffById(rs.getInt(3)));
				doctorApp.setDateOfScheduling(DateOfSchedulingDao
						.getDateOfSchedulingById(rs.getInt(4)));

				listDoctorAppointment.add(doctorApp);
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return listDoctorAppointment;
	}

	public static DoctorAppointment getDoctorAppointmentObjectByUserIDAndMedicalStaffID(
			int userId, int staffId) {
		DoctorAppointment doctorApp = new DoctorAppointment();
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblDoctorAppointments where UserID=? AND MedicalStaffID=?;");
			ps.setInt(1, userId);
			ps.setInt(2, staffId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				doctorApp.setDoctorAppointmentID(rs.getInt(1));
				doctorApp.setUser(UserDao.getUserById(rs.getInt(2)));
				doctorApp.setMedicalStaff(MedicalStaffDao
						.getMedicalStaffById(rs.getInt(3)));
				doctorApp.setDateOfScheduling(DateOfSchedulingDao
						.getDateOfSchedulingById(rs.getInt(4)));
				doctorApp.setExamined(rs.getInt(5));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return doctorApp;
	}

	public static int save(int userID, int medicalStaffID, int date) {
		int status = 0;
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into tblDoctorAppointments(UserID,MedicalStaffID,DateOfSchedulingID,Examined) values (?,?,?,?)");
			ps.setInt(1, userID);
			ps.setInt(2, medicalStaffID);
			ps.setInt(3, date);
			ps.setInt(4, 0);

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	public static int updateExaminedTo1(int id) {
		int status = 0;

		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update tblDoctorAppointments set Examined=? where DoctorAppointmentID=?");
			ps.setInt(1, 1);
			ps.setInt(2, id);

			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
