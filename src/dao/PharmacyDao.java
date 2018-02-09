package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Pharmacy;
import model.User;

public class PharmacyDao {

	public static List<Pharmacy> getAllPharmacy() {
		List<Pharmacy> listPharmacy = new ArrayList<Pharmacy>();

		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblPharmacy;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// ovde je objekat user unutar while petlje zato sto
				// postavljamo vise objekata user u listu listUser!
				Pharmacy ph = new Pharmacy();

				ph.setPharmacyID(rs.getInt(1));
				ph.setNameOfTheDrug(rs.getString(2));
				ph.setScopeOfApplication(rs.getString(3));
				ph.setQuantityOnCondition(rs.getInt(4));
				ph.setNote(rs.getString(5));
				ph.setManufacturer(ManufacturerDao.getManufacturerById(rs
						.getInt(6)));

				listPharmacy.add(ph);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listPharmacy;
	}
	
	public static List<Pharmacy> getAllPharmacySortedByNameOfTheDrug() {
		List<Pharmacy> listPharmacy = new ArrayList<Pharmacy>();

		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblPharmacy ORDER BY NameOfTheDrug;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// ovde je objekat user unutar while petlje zato sto
				// postavljamo vise objekata user u listu listUser!
				Pharmacy ph = new Pharmacy();

				ph.setPharmacyID(rs.getInt(1));
				ph.setNameOfTheDrug(rs.getString(2));
				ph.setScopeOfApplication(rs.getString(3));
				ph.setQuantityOnCondition(rs.getInt(4));
				ph.setNote(rs.getString(5));
				ph.setManufacturer(ManufacturerDao.getManufacturerById(rs
						.getInt(6)));

				listPharmacy.add(ph);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listPharmacy;
	}
	
	public static Pharmacy getPharmacyById(int id) {
		Pharmacy ph = new Pharmacy();
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblPharmacy where PharmacyId=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ph.setPharmacyID(rs.getInt(1));
				ph.setNameOfTheDrug(rs.getString(2));
				ph.setScopeOfApplication(rs.getString(3));
				ph.setQuantityOnCondition(rs.getInt(4));
				ph.setNote(rs.getString(5));
				ph.setManufacturer(ManufacturerDao.getManufacturerById(rs
						.getInt(6)));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return ph;
	}
	
	public static int updateQuantityOnCondition(int quantity, int pharmacyID ) {
		int status = 0;

		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update tblPharmacy set QuantityOnCondition=? where PharmacyID=?");
			ps.setInt(1, quantity);
			ps.setInt(2, pharmacyID);

			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
