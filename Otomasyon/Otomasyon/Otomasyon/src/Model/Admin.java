package Model;

import java.sql.*;
import java.util.ArrayList;

//import Helper.DBConnection;

public class Admin extends User{

	Connection con = conn.DBCon();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	int ID;
	String kAdi,Sifre;
	
	public Admin() {}

	public Admin(int iD, String kAdi, String sifre) {
		this.ID = iD;
		this.kAdi = kAdi;
		this.Sifre = sifre;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		this.ID = iD;
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
	
	
	//ADMİN İŞLEMLERİ
	public ArrayList<Admin> getAdminList() throws SQLException{
		ArrayList<Admin> list = new ArrayList<>();
		Admin obj;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM admin");
			while (rs.next()) {
				obj = new Admin(rs.getInt("id"),rs.getString("k_adi"),rs.getString("sifre"));
				list.add(obj);
			} 	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return list;
	}
	
	public boolean addAdmin(String kAdi,String Sifre) throws SQLException{
		
		String query = "INSERT INTO admin" + "(k_adi,sifre) VALUES" + "(?,?)";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, kAdi);
			preparedStatement.setString(2, Sifre);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (key) {
			return true;
		} else {
			return false;
		}	
	}
	
	public boolean deleteAdmin(int ID) throws SQLException{
		String query = "DELETE FROM admin WHERE id = ?";
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
	
	public boolean updateAdmin(int ID, String kAdi, String Sifre) throws SQLException{
		String query = "UPDATE admin SET k_adi=?, sifre=? WHERE id = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, kAdi);
			preparedStatement.setString(2, Sifre);
			preparedStatement.setInt(3, ID);
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
	
	
	//S�NEMA ��LEMLER�
	public ArrayList<Sinema> getSinemaList() throws SQLException{
		ArrayList<Sinema> list = new ArrayList<>();
		Sinema obj;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM sinema");
			while (rs.next()) {
				obj = new Sinema(rs.getInt("id"),rs.getString("sinem_adi"),rs.getString("tarih"),rs.getString("saat"),rs.getString("salon"));
				list.add(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
		
	}
	
	public boolean addSinema(String sinemaAdi,String Tarih,String Saat, String Salon) throws SQLException{
		String query = "INSERT INTO sinema" + "(sinema_adi,tarih,saat,salon) VALUES" + "(?,?,?,?)";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, sinemaAdi);
			preparedStatement.setString(2, Tarih);
			preparedStatement.setString(3, Saat);
			preparedStatement.setString(4, Salon);
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
	
	public boolean deleteSinema(int ID) throws SQLException{
		String query = "DELETE FROM sinema WHERE id = ?";
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
	
	public boolean updateSinema(int ID, String sinemaAdi, String Tarih, String Saat, String Salon) throws SQLException{
		String query = "UPDATE admin SET sinema_adi=?, tarih=?, saat=?, salon=? WHERE id = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, sinemaAdi);
			preparedStatement.setString(2, Tarih);
			preparedStatement.setString(3, Saat);
			preparedStatement.setString(4, Salon);
			preparedStatement.setInt(5, ID);
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
	
	
	
	//T�YATRO ��LEMLER�
	public ArrayList<Tiyatro> getTiyatroList() throws SQLException{
		ArrayList<Tiyatro> list = new ArrayList<>();
		Tiyatro obj;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM tiyatro");
			while (rs.next()) {
				obj = new Tiyatro(rs.getInt("id"),rs.getString("tiyatro_adi"),rs.getString("tarih"),rs.getString("saat"),rs.getString("salon"));
				list.add(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;	
	}
	
	public boolean addTiyatro(String tiyatroAdi, String Tarih, String Saat, String Salon) throws SQLException{
		String query = "INSERT INTO tiyatro" + "(tiyatro_adi,tarih,saat,salon) VALUES" + "(?,?,?,?)";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, tiyatroAdi);
			preparedStatement.setString(2, Tarih);
			preparedStatement.setString(3, Saat);
			preparedStatement.setString(4, Salon);
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
	
	public boolean deleteTiyatro(int ID) throws SQLException{
		String query = "DELETE FROM tiyatro WHERE id = ?";
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
	
	public boolean updateTiyatro(int ID, String tiyatroAdi, String Tarih, String Saat, String Salon) throws SQLException{
		String query = "UPDATE admin SET tiyatro_adi=?, tarih=?, saat=?, salon=? WHERE id = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, tiyatroAdi);
			preparedStatement.setString(2, Tarih);
			preparedStatement.setString(3, Saat);
			preparedStatement.setString(4, Salon);
			preparedStatement.setInt(5, ID);
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
		
	//KONSER ��LEMLER�
	public ArrayList<Konser> getKonserList() throws SQLException{
		ArrayList<Konser> list = new ArrayList<>();
		Konser obj;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM konser");
			while (rs.next()) {
				obj = new Konser(rs.getInt("id"),rs.getString("konser_adi"),rs.getString("tarih"),rs.getString("saat"),rs.getString("salon"));
				list.add(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
		
	}
	
	public boolean addKonser(String konserAdi, String Tarih, String Saat, String Salon) throws SQLException{
		String query = "INSERT INTO konser" + "(konser_adi,tarih,saat,salon) VALUES" + "(?,?,?,?)";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, konserAdi);
			preparedStatement.setString(2, Tarih);
			preparedStatement.setString(3, Saat);
			preparedStatement.setString(4, Salon);
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
	
	public boolean deleteKonser(int ID) throws SQLException{
		String query = "DELETE FROM konser WHERE id = ?";
		boolean key = true;
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
	
	public boolean updateKonser(int ID, String konserAdi, String Tarih, String Saat, String Salon) throws SQLException{
		String query = "UPDATE admin SET konser_adi=?, tarih=?, saat=?, salon=? WHERE id = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, konserAdi);
			preparedStatement.setString(2, Tarih);
			preparedStatement.setString(3, Saat);
			preparedStatement.setString(4, Salon);
			preparedStatement.setInt(5, ID);
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
