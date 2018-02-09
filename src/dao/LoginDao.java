package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Login;
import model.User;

public class LoginDao {

	public static List<Login> getAllLogin() {
		List<Login> listLogin = new ArrayList<Login>();
		List<User> listUser = UserDao.getAllUsers();

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
				login.setUser(listUser.get(rs.getInt(3) - 1));

				listLogin.add(login);

			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listLogin;
	}

}
