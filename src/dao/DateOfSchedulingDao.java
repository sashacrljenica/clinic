package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DateOfScheduling;
import model.MedicalDepartment;

public class DateOfSchedulingDao {

	public static List<DateOfScheduling> getAll() {
		List<DateOfScheduling> listDate = new ArrayList<DateOfScheduling>();

		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblDateOfScheduling");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DateOfScheduling sch = new DateOfScheduling();

				sch.setDateOfSchedulingID(rs.getInt(1));
				sch.setDateOfScheduling(rs.getTimestamp(2));
				sch.setScheduled(rs.getInt(3));

				MedicalDepartment dep = MedicalDeparmentDao
						.getMedicalDepartmentById(rs.getInt(4));

				sch.setDepartment(dep);

				listDate.add(sch);
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listDate;
	}

	public static DateOfScheduling getDateOfSchedulingById(int id) {
		DateOfScheduling date = new DateOfScheduling();

		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblDateOfScheduling where DateOfSchedulingID=?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				date.setDateOfSchedulingID(rs.getInt(1));
				date.setDateOfScheduling(rs.getTimestamp(2));
				date.setScheduled(rs.getInt(3));
				date.setDepartment(MedicalDeparmentDao
						.getMedicalDepartmentById(rs.getInt(4)));
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;
	}

	public static List<DateOfScheduling> getAllByMedicalDepartmentID(int id) {
		List<DateOfScheduling> listDate = new ArrayList<DateOfScheduling>();

		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblDateOfScheduling where MedicalDepartmentID=? and Scheduled=0 ORDER BY DateOfScheduling;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DateOfScheduling sch = new DateOfScheduling();

				sch.setDateOfSchedulingID(rs.getInt(1));
				sch.setDateOfScheduling(rs.getTimestamp(2));
				sch.setScheduled(rs.getInt(3));

				MedicalDepartment dep = MedicalDeparmentDao
						.getMedicalDepartmentById(rs.getInt(4));

				sch.setDepartment(dep);

				listDate.add(sch);
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listDate;
	}

	public static DateOfScheduling getDateOfSchedulingObjectByDateOfSchedulingAndMedicalDepartmentID(
			String date, int id) {
		DateOfScheduling sch = new DateOfScheduling();

		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblDateOfScheduling where DateOfScheduling=? AND MedicalDepartmentID=?;");
			ps.setString(1, date);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				sch.setDateOfSchedulingID(rs.getInt(1));
				sch.setDateOfScheduling(rs.getTimestamp(2));
				sch.setScheduled(rs.getInt(3));

				MedicalDepartment dep = MedicalDeparmentDao
						.getMedicalDepartmentById(rs.getInt(4));

				sch.setDepartment(dep);

			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sch;
	}

	public static boolean validateDateOfSchedulingByMedicalDepartmentExist(
			String medDepartment) {
		boolean status = false;
		try {

			Connection con = ConnectionDao.getConnection();

			PreparedStatement ps = con
					.prepareStatement("select * from tblDateOfScheduling where MedicalDepartmentID=?");
			MedicalDepartment depObject = MedicalDeparmentDao
					.getMedicalDepartmentObjectByName(medDepartment);

			int upit = depObject.getMedicalDepartmentID();

			ps.setInt(1, upit);

			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int updateScheduledTo1(int id) {
		int status = 0;

		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update tblDateOfScheduling set Scheduled=? where DateOfSchedulingID=?");
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
