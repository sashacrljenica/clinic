package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Admin;

public class AdminDao {
	public static Admin getAdminByNameAndPassword(String name, String password) {
		Admin admin = new Admin();
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblAdmin where UserName=? and Password=?");
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				admin.setAdminID(rs.getInt(1));
				admin.setNameAndSurname(rs.getString(2));
				admin.setUserName(rs.getString(3));
				admin.setPassword(rs.getString(4));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return admin;
	}

	public static Admin getAdminById() {
		Admin admin = new Admin();
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblUser where UserId=?");
			ps.setInt(1, 1);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				admin.setAdminID(rs.getInt(1));
				admin.setNameAndSurname(rs.getString(2));
				admin.setUserName(rs.getString(3));
				admin.setPassword(rs.getString(4));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return admin;
	}

	public static int save(Admin admin) {
		int status = 0;
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into tblAdmin(NameAndSurname,UserName,Password) values (?,?,?)");
			ps.setString(1, admin.getNameAndSurname());
			ps.setString(2, admin.getUserName());
			ps.setString(3, admin.getPassword());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	public static boolean validateAdmin(String name, String password) {
		boolean status = false;
		try {

			Connection con = ConnectionDao.getConnection();

			PreparedStatement ps = con
					.prepareStatement("select * from tblAdmin where UserName=? and Password=? and AdminID=1");
			ps.setString(1, name);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	// public static boolean validateOneAdmin(String name, String password) {
	// boolean status = false;
	// try {
	//
	// Connection con = ConnectionDao.getConnection();
	//
	// PreparedStatement ps = con
	// .prepareStatement("select * from tblAdmin where UserName=? and Password=? and AdminID>1");
	// ps.setString(1, name);
	// ps.setString(2, password);
	//
	// ResultSet rs = ps.executeQuery();
	// status = rs.next();
	//
	// } catch (Exception e) {
	// System.out.println(e);
	// }
	// return status;
	// }

	public static boolean validateAdminExist() {
		boolean status = false;
		try {

			Connection con = ConnectionDao.getConnection();

			PreparedStatement ps = con
					.prepareStatement("select * from tblAdmin where AdminID=?");
			ps.setInt(1, 1);

			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

}
