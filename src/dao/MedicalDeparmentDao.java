package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.MedicalDepartment;

public class MedicalDeparmentDao {

	public static List<MedicalDepartment> getAll() {
		List<MedicalDepartment> listDepartments = new ArrayList<MedicalDepartment>();

		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblMedicalDepartments");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MedicalDepartment dep = new MedicalDepartment();

				dep.setMedicalDepartmentID(rs.getInt(1));
				dep.setNameOfDepartment(rs.getString(2));
				dep.setContactPhone(rs.getString(3));

				listDepartments.add(dep);
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listDepartments;
	}

	public static MedicalDepartment getMedicalDepartmentObjectByName(String name) {
		MedicalDepartment department = new MedicalDepartment();
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblMedicalDepartments where NameOfDepartment=?");

			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				department.setMedicalDepartmentID(rs.getInt(1));
				department.setNameOfDepartment(rs.getString(2));
				department.setContactPhone(rs.getString(3));
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return department;
	}

	public static MedicalDepartment getMedicalDepartmentById(int id) {
		MedicalDepartment dep = new MedicalDepartment();
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblMedicalDepartments where MedicalDepartmentID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dep.setMedicalDepartmentID(rs.getInt(1));
				dep.setNameOfDepartment(rs.getString(2));
				dep.setContactPhone(rs.getString(3));

			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return dep;
	}

}
