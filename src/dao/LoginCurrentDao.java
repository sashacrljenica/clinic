package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.LoginCurrent;
import model.LoginCurrentInner;
import model.User;

public class LoginCurrentDao {

	public static List<LoginCurrentInner> getAllLoginUsersByName() {
		List<LoginCurrentInner> listLogin = new ArrayList<LoginCurrentInner>();
		// List<User> listUser = new ArrayList<User>();
		// List<Object> newList = Stream.concat(listLogin.stream(),
		// listUser.stream()).collect(Collectors.toList());
//		List<User> listUser = UserDao.getAllUsers();

		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select tblLogin.LoginID,tblLogin.LoginDateTime,tblUsers.NameAndSurname FROM tblLogin INNER JOIN tblUsers ON tblLogin.UserID = tblUsers.UserID;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// ovde je objekat user unutar while petlje zato sto
				// postavljamo vise objekata user u listu listUser!
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

	public static List<LoginCurrent> getRecords(int start, int total) {
		List<LoginCurrent> listUser = new ArrayList<LoginCurrent>();
		LoginCurrent login = null;
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblLogin limit "
							+ (start - 1) + "," + total);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				login = new LoginCurrent();
				login.setLoginID(rs.getInt(1));
				login.setLoginDateTime(rs.getTimestamp(2));
				login.setUserID(rs.getInt(3));
				listUser.add(login);
			}
			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return listUser;
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
