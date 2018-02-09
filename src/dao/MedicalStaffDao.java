package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.MedicalStaff;

public class MedicalStaffDao {

	public static int save(MedicalStaff staff) {
		int status = 0;
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into tblMedicalStaffs(UserID,MedicalDepartmentID) values (?,?)");
			ps.setInt(1, staff.getUser().getUserID());
			ps.setInt(2, staff.getMedicalDepartment().getMedicalDepartmentID());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
	
	public static MedicalStaff getMedicalStaffById(int mecicalStaffID) {
		MedicalStaff staff = new MedicalStaff();
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblMedicalStaffs where MedicalStaffID=?");
			ps.setInt(1, mecicalStaffID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				staff.setMedicalStaffID(rs.getInt(1));
				staff.setUser(UserDao.getUserById(rs.getInt(2)));
				staff.setMedicalDepartment(MedicalDeparmentDao
						.getMedicalDepartmentById(rs.getInt(3)));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return staff;
	}
	

	public static List<MedicalStaff> getMedicalStaffByMedicalDepartmentID(int id) {
		List<MedicalStaff> listMedicalStaff = new ArrayList<MedicalStaff>();
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblMedicalStaffs where MedicalDepartmentID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MedicalStaff staff = new MedicalStaff();

				staff.setMedicalStaffID(rs.getInt(1));
				staff.setUser(UserDao.getUserById(rs.getInt(2)));
				staff.setMedicalDepartment(MedicalDeparmentDao
						.getMedicalDepartmentById(rs.getInt(3)));

				listMedicalStaff.add(staff);
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return listMedicalStaff;
	}

	public static MedicalStaff getMedicalStaffByUserID(int userId) {
		MedicalStaff staff = new MedicalStaff();
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblMedicalStaffs where UserID=?");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				staff.setMedicalStaffID(rs.getInt(1));
				staff.setUser(UserDao.getUserById(rs.getInt(2)));
				staff.setMedicalDepartment(MedicalDeparmentDao
						.getMedicalDepartmentById(rs.getInt(3)));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return staff;
	}

	public static MedicalStaff getMedicalStaffByUserIDAndMedicalDepartmentID(
			int userId, int departmentId) {
		MedicalStaff staff = new MedicalStaff();
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblMedicalStaffs where UserID=? AND MedicalDepartmentID=?");
			ps.setInt(1, userId);
			ps.setInt(2, departmentId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				staff.setMedicalStaffID(rs.getInt(1));
				staff.setUser(UserDao.getUserById(rs.getInt(2)));
				staff.setMedicalDepartment(MedicalDeparmentDao
						.getMedicalDepartmentById(rs.getInt(3)));

			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return staff;
	}

}
