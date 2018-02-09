package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Manufacturer;

public class ManufacturerDao {
	public static Manufacturer getManufacturerById(int id) {
		Manufacturer man = new Manufacturer();
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblManufacturers where ManufacturerID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				man.setManufacturerID(rs.getInt(1));
				man.setName(rs.getString(2));
				man.setAddress(rs.getString(3));
				man.setContactPhone(rs.getString(4));
				man.setEmail(rs.getString(5));
				man.setNote(rs.getString(6));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return man;
	}

}
