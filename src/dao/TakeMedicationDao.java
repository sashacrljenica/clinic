package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DoctorAppointment;
import model.TakeMedication;

public class TakeMedicationDao {
	public static List<TakeMedication> getAllTakeMedications() {
		List<TakeMedication> listTakeMedications = new ArrayList<TakeMedication>();

		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblUsers");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TakeMedication take = new TakeMedication();

				take.setTakeMedicationID(rs.getInt(1));
				take.setDateOfTaking(rs.getTimestamp(2));
				take.setUser(UserDao.getUserById(rs.getInt(3)));
				take.setMedicalStaff(MedicalStaffDao.getMedicalStaffById(rs
						.getInt(4)));
				take.setPharmacy(PharmacyDao.getPharmacyById(rs.getInt(5)));

				listTakeMedications.add(take);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listTakeMedications;
	}

	public static TakeMedication getTakeMedicationById(int id) {
		TakeMedication take = new TakeMedication();
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblTakeMedications where TakeMedicationID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				take.setTakeMedicationID(rs.getInt(1));
				take.setDateOfTaking(rs.getTimestamp(2));
				take.setUser(UserDao.getUserById(rs.getInt(3)));
				take.setMedicalStaff(MedicalStaffDao.getMedicalStaffById(rs
						.getInt(4)));
				take.setPharmacy(PharmacyDao.getPharmacyById(rs.getInt(5)));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return take;
	}

	public static TakeMedication getTakeMedicationObjectByUserIDAndMedicalStaffID(
			int userId, int staffId) {
		TakeMedication take = new TakeMedication();
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblTakeMedications where UserID=? AND MedicalStaffID=? ORDER BY TakeMedicationID DESC;");
			ps.setInt(1, userId);
			ps.setInt(2, staffId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				take.setTakeMedicationID(rs.getInt(1));
				take.setDateOfTaking(rs.getTimestamp(2));
				take.setUser(UserDao.getUserById(rs.getInt(3)));
				take.setMedicalStaff(MedicalStaffDao.getMedicalStaffById(rs
						.getInt(4)));
				take.setPharmacy(PharmacyDao.getPharmacyById(rs.getInt(5)));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return take;
	}

	public static int save(int userID, int medicalStaffID, int pharmacyID) {
		int status = 0;
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into tblTakeMedications(UserID,MedicalStaffID,PharmacyID) values (?,?,?)");
			ps.setInt(1, userID);
			ps.setInt(2, medicalStaffID);
			ps.setInt(3, pharmacyID);

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

}
