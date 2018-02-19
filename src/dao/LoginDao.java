package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Login;
import model.LoginCurrentInner;
import model.User;

public class LoginDao {

	public static List<Login> getAllLogin() {
		List<Login> listLogin = new ArrayList<Login>();

		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblLogin");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// ovde je objekat login unutar while petlje zato sto
				// postavljamo vise objekata user u listu listLogin!
				Login login = new Login();

				login.setLoginID(rs.getInt(1));
				login.setDatetime(rs.getTimestamp(2));
				login.setUser(UserDao.getUserById(rs.getInt(3)));

				listLogin.add(login);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listLogin;
	}

	public static List<Login> getRecords(int start, int total) {
		List<Login> listUser = new ArrayList<Login>();
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblLogin limit "
							+ (start - 1) + "," + total);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Login login = new Login();
				login.setLoginID(rs.getInt(1));
				login.setDatetime(rs.getTimestamp(2));
				login.setUser(UserDao.getUserById(rs.getInt(3)));
				listUser.add(login);
			}
			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return listUser;
	}

	public static List<LoginCurrentInner> getAllLoginUsersByName() {
		List<LoginCurrentInner> listLogin = new ArrayList<LoginCurrentInner>();

		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select tblLogin.LoginID,tblLogin.LoginDateTime,tblUsers.NameAndSurname FROM tblLogin INNER JOIN tblUsers ON tblLogin.UserID = tblUsers.UserID ORDER BY tblLogin.LoginDateTime;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				LoginCurrentInner login = new LoginCurrentInner();

				login.setLoginCurrentID(rs.getInt(1));
				login.setDatetime(rs.getTimestamp(2));
				login.setNameAndSurname(rs.getString(3));

				listLogin.add(login);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listLogin;
	}
	
	public static int save(User user) {
		int status = 0;
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into tblLogin(UserID) values (?)");
			ps.setInt(1, user.getUserID());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

}
