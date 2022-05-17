 package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class User {
	
	DBConnection conn = new DBConnection();
	Connection con = conn.DBCon();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	int ID;
	String Adi,Soyadi,kAdi,Sifre,mailAdresi,telNo;
	
	public User() {}

	public User(int iD, String adi, String soyadi, String kAdi, String sifre, String mailAdresi, String telNo) {
		this.ID = iD;
		this.Adi = adi;
		this.Soyadi = soyadi;
		this.kAdi = kAdi;
		this.Sifre = sifre;
		this.mailAdresi = mailAdresi;
		this.telNo = telNo;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public String getAdi() {
		return Adi;
	}

	public void setAdi(String adi) {
		this.Adi = adi;
	}

	public String getSoyadi() {
		return Soyadi;
	}

	public void setSoyadi(String soyadi) {
		this.Soyadi = soyadi;
	}

	public String getkAdi() {
		return kAdi;
	}

	public void setkAdi(String kAdi) {
		this.kAdi = kAdi;
	}

	public String getSifre() {
		return Sifre;
	}

	public void setSifre(String sifre) {
		this.Sifre = sifre;
	}

	public String getMailAdresi() {
		return mailAdresi;
	}

	public void setMailAdresi(String mailAdresi) {
		this.mailAdresi = mailAdresi;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	
	//USER ÝÞLEMLERÝ
	public ArrayList<User> getUserList() throws SQLException{
		ArrayList<User> list = new ArrayList<>();
		User obj;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM users");
			while (rs.next()) {
				obj = new User(rs.getInt("id"),rs.getString("adi"),rs.getString("soyadi"),rs.getString("k_adi"),rs.getString("sifre"),rs.getString("mail_adresi"),rs.getString("tel_no"));
				list.add(obj);
			} 	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return list;
	}
	
	public boolean addUser(String adi, String soyadi, String kAdi, String sifre, String mailAdresi, String telNo) throws SQLException{
		int key = 0;
		boolean duplicate = false;
		System.out.println(kAdi);
		String query = "INSERT INTO users" + "(adi, soyadi, k_adi, sifre, mail_adresi, tel_no) VALUES" + "('"+adi+"','"+soyadi+"','"+kAdi+"','"+sifre+"','"+mailAdresi+"','"+telNo+"')";
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM users WHERE k_adi = '" + kAdi +  "'");
			while (rs.next()) {
				duplicate = true;
				break;
			}
			
			if (!duplicate) {
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, adi);
				preparedStatement.setString(2, soyadi);
				preparedStatement.setString(3, kAdi);
				preparedStatement.setString(4, sifre);
				preparedStatement.setString(5, mailAdresi);
				preparedStatement.setString(6, telNo);
				preparedStatement.executeUpdate();
				key = 1;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (key==1) {
			return true;
		} else {
			return false;
		}	
	}
	
	public boolean deleteUser(int ID) throws SQLException{
		String query = "DELETE FROM users WHERE id = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, ID);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.getStackTrace();
		}
		if (key) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean updateUser(int ID, String Adi, String Soyadi, String kAdi, String Sifre, String mailAdresi, String telNo) throws SQLException{
		String query = "UPDATE users SET adi=?, soyadi=?, k_adi=?, sifre=?, mail_adresi=?, tel_no=? WHERE id = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, Adi);
			preparedStatement.setString(2, Soyadi);
			preparedStatement.setString(3, kAdi);
			preparedStatement.setString(4, Sifre);
			preparedStatement.setString(5, mailAdresi);
			preparedStatement.setString(6, telNo);
			preparedStatement.setInt(7, ID);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.getStackTrace();
		}
		if (key) {
			return true;
		} else {
			return false;
		}	
	}
	
	public boolean changeUserpassword(String kAdi, String Sifre) throws SQLException{
		String query = "UPDATE users SET sifre=? WHERE k_adi=?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, Sifre);
			preparedStatement.setString(2, kAdi);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.getStackTrace();
		}
		if (key) {
			return true;
		} else {
			return false;
		}
	}
		
}
