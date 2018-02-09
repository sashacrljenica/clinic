package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDao {

	public static List<User> getAllUsers() {
		List<User> listUser = new ArrayList<User>();

		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblUsers");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// ovde je objekat user unutar while petlje zato sto
				// postavljamo vise objekata user u listu listUser!
				User user = new User();

				user.setUserID(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setNameAndSurname(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setPhoneNumber(rs.getString(6));
				user.setEmail(rs.getString(7));
				user.setNumberOfIDCard(rs.getString(8));
				user.setBloodType(rs.getString(9));
				user.setSex(rs.getString(10));
				user.setNameOfJob(rs.getString(11));
				user.setTypeOfUsers(rs.getString(12));

				listUser.add(user);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listUser;
	}

	public static User getUserById(int id) {
		User user = new User();
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblUsers where UserId=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setUserID(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setNameAndSurname(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setPhoneNumber(rs.getString(6));
				user.setEmail(rs.getString(7));
				user.setNumberOfIDCard(rs.getString(8));
				user.setBloodType(rs.getString(9));
				user.setSex(rs.getString(10));
				user.setNameOfJob(rs.getString(11));
				user.setTypeOfUsers(rs.getString(12));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return user;
	}

	// public static List<User> getUsersByNameOfJob(String nameOfJob) {
	// List<User> listUser = new ArrayList<User>();
	// try {
	// Connection con = ConnectionDao.getConnection();
	// PreparedStatement ps = con
	// .prepareStatement("select * from tblUsers where NameOfJob=?");
	// ps.setString(1, nameOfJob);
	// ResultSet rs = ps.executeQuery();
	// if (rs.next()) {
	// User user = new User();
	//
	// user.setUserID(rs.getInt(1));
	// user.setUserName(rs.getString(2));
	// user.setPassword(rs.getString(3));
	// user.setNameAndSurname(rs.getString(4));
	// user.setAddress(rs.getString(5));
	// user.setPhoneNumber(rs.getString(6));
	// user.setEmail(rs.getString(7));
	// user.setNumberOfIDCard(rs.getString(8));
	// user.setBloodType(rs.getString(9));
	// user.setSex(rs.getString(10));
	// user.setNameOfJob(rs.getString(11));
	// user.setTypeOfUsers(rs.getString(12));
	//
	// listUser.add(user);
	// }
	// con.close();
	// } catch (Exception ex) {
	// ex.printStackTrace();
	// }
	//
	// return listUser;
	// }

	public static User getUserByNameAndPassword(String name, String password) {
		User user = new User();
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblUsers where UserName=? and Password=?");
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setUserID(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setNameAndSurname(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setPhoneNumber(rs.getString(6));
				user.setEmail(rs.getString(7));
				user.setNumberOfIDCard(rs.getString(8));
				user.setBloodType(rs.getString(9));
				user.setSex(rs.getString(10));
				user.setNameOfJob(rs.getString(11));
				user.setTypeOfUsers(rs.getString(12));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return user;
	}

	public static User getUserByNameAndSurname(String name) {
		User user = new User();
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblUsers where NameAndSurname=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setUserID(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setNameAndSurname(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setPhoneNumber(rs.getString(6));
				user.setEmail(rs.getString(7));
				user.setNumberOfIDCard(rs.getString(8));
				user.setBloodType(rs.getString(9));
				user.setSex(rs.getString(10));
				user.setNameOfJob(rs.getString(11));
				user.setTypeOfUsers(rs.getString(12));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return user;
	}

	public static List<User> getAllUsersName(String name) {
		List<User> listUser = new ArrayList<User>();

		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblUsers WHERE NameAndSurname LIKE ? ORDER BY NameAndSurname");
			String value = '%' + name + '%';
			ps.setString(1, value);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// ovde je objekat user unutar while petlje zato sto
				// postavljamo vise objekata user u listu listUser!
				User user = new User();

				user.setUserID(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setNameAndSurname(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setPhoneNumber(rs.getString(6));
				user.setEmail(rs.getString(7));
				user.setNumberOfIDCard(rs.getString(8));
				user.setBloodType(rs.getString(9));
				user.setSex(rs.getString(10));
				user.setNameOfJob(rs.getString(11));
				user.setTypeOfUsers(rs.getString(12));

				listUser.add(user);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listUser;
	}

	public static List<User> getAllUsersEmail(String email) {
		List<User> listUser = new ArrayList<User>();

		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblUsers WHERE Email LIKE ? ORDER BY Email,NameAndSurname");
			String value = '%' + email + '%';
			ps.setString(1, value);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// ovde je objekat user unutar while petlje zato sto
				// postavljamo vise objekata user u listu listUser!
				User user = new User();

				user.setUserID(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setNameAndSurname(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setPhoneNumber(rs.getString(6));
				user.setEmail(rs.getString(7));
				user.setNumberOfIDCard(rs.getString(8));
				user.setBloodType(rs.getString(9));
				user.setSex(rs.getString(10));
				user.setNameOfJob(rs.getString(11));
				user.setTypeOfUsers(rs.getString(12));

				listUser.add(user);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listUser;
	}

	public static int update(User user) {
		int status = 0;

		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update tblUsers set UserName=?,Password=?,NameAndSurname=?,Address=?,PhoneNumber=?,Email=?,NumberOfIdCard=?,BloodType=?,Sex=?,NameOfJob=?,TypeOfUsers=? where UserID=?");
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getNameAndSurname());
			ps.setString(4, user.getAddress());
			ps.setString(5, user.getPhoneNumber());
			ps.setString(6, user.getEmail());
			ps.setString(7, user.getNumberOfIDCard());
			ps.setString(8, user.getBloodType());
			ps.setString(9, user.getSex());
			ps.setString(10, user.getNameOfJob());
			ps.setString(11, user.getTypeOfUsers());
			ps.setInt(12, user.getUserID());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int save(User user) {
		int status = 0;
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into tblUsers(UserName,Password,NameAndSurname,Address,PhoneNumber,Email,NumberOfIdCard,BloodType,Sex,NameOfJob,TypeOfUsers) values (?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getNameAndSurname());
			ps.setString(4, user.getAddress());
			ps.setString(5, user.getPhoneNumber());
			ps.setString(6, user.getEmail());
			ps.setString(7, user.getNumberOfIDCard());
			ps.setString(8, user.getBloodType());
			ps.setString(9, user.getSex());
			ps.setString(10, user.getNameOfJob());
			ps.setString(11, user.getTypeOfUsers());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("delete from tblUsers where UserID=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static boolean validate(String name, String password) {
		boolean status = false;
		try {

			Connection con = ConnectionDao.getConnection();

			PreparedStatement ps = con
					.prepareStatement("select * from tblUsers where UserName=? and Password=?");
			ps.setString(1, name);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static boolean validateMedic(String name, String password) {
		boolean status = false;
		try {

			Connection con = ConnectionDao.getConnection();

			PreparedStatement ps = con
					.prepareStatement("select * from tblUsers where UserName=? and Password=? and TypeOfUsers='medic'");
			ps.setString(1, name);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static boolean validatePatient(String name, String password) {
		boolean status = false;
		try {

			Connection con = ConnectionDao.getConnection();

			PreparedStatement ps = con
					.prepareStatement("select * from tblUsers where UserName=? and Password=? and TypeOfUsers='patient'");
			ps.setString(1, name);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static boolean validateByUserNameExist(String userName) {
		boolean status = false;
		try {

			Connection con = ConnectionDao.getConnection();

			PreparedStatement ps = con
					.prepareStatement("select * from tblUsers where UserName=?");
			ps.setString(1, userName);

			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static List<User> getRecords(int start, int total) {
		List<User> listUser = new ArrayList<User>();
		User e = null;
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblUsers limit "
							+ (start - 1) + "," + total);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				e = new User();
				e.setUserID(rs.getInt(1));
				e.setUserName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setNameAndSurname(rs.getString(4));
				e.setAddress(rs.getString(5));
				e.setPhoneNumber(rs.getString(6));
				e.setEmail(rs.getString(7));
				e.setNumberOfIDCard(rs.getString(8));
				e.setBloodType(rs.getString(9));
				e.setSex(rs.getString(10));
				e.setNameOfJob(rs.getString(11));
				e.setTypeOfUsers(rs.getString(12));
				listUser.add(e);
			}
			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return listUser;
	}

	public static int getAllNumberOfUsers() {
		// List<User> listUser = new ArrayList<User>();
		int numberOfUser = 0;

		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblUsers");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// ovde je objekat user unutar while petlje zato sto
				// postavljamo vise objekata user u listu listUser!
				User user = new User();

				user.setUserID(rs.getInt(1));

				numberOfUser++;

				// listUser.add(user);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// int numberOfUser = listUser.size();

		return numberOfUser;
	}

	public static int getAllNumberOfUsersPatient() {
		int numberOfUser = 0;

		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblUsers WHERE TypeOfUsers='patient'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserID(rs.getInt(1));
				numberOfUser++;
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numberOfUser;
	}

	public static int getAllNumberOfUsersMedic() {
		int numberOfUser = 0;

		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tblUsers WHERE TypeOfUsers='medic'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserID(rs.getInt(1));
				numberOfUser++;
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numberOfUser;
	}
}
