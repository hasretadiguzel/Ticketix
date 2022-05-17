package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class SinemaBilet extends User{
	DBConnection conn = new DBConnection();
	Connection con = conn.DBCon();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	int ID;
	String sinemaAdi, Tarih ,Saat, Salon, Koltuk;
	
	public SinemaBilet() {}
	
	public SinemaBilet(int iD, String sinemaAdi, String tarih, String saat, String salon, String koltuk) {
		super();
		this.ID = iD;
		this.sinemaAdi = sinemaAdi;
		this.Tarih = tarih;
		this.Saat = saat;
		this.Salon = salon;
		this.Koltuk = koltuk;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		this.ID = iD;
	}
	
	public String getSinemaAdi() {
		return sinemaAdi;
	}
	
	public void setSinemaAdi(String sinemaAdi) {
		this.sinemaAdi = sinemaAdi;
	}
	
	public String getTarih() {
		return Tarih;
	}
	
	public void setTarih(String tarih) {
		this.Tarih = tarih;
	}
	
	public String getSaat() {
		return Saat;
	}
	
	public void setSaat(String saat) {
		this.Saat = saat;
	}
	
	public String getSalon() {
		return Salon;
	}
	
	public void setSalon(String salon) {
		this.Salon = salon;
	}
	
	public String getKoltuk() {
		return Koltuk;
	}
	
	public void setKoltukID(String koltuk) {
		this.Koltuk = koltuk;
	}
	
	public ArrayList<SinemaBilet> getSinemaBiletList() throws SQLException{
		ArrayList<SinemaBilet> list = new ArrayList<>();
		SinemaBilet obj;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM sinemabilet");
			while (rs.next()) {
				obj = new SinemaBilet(rs.getInt("id"),rs.getString("sinema_adi"),rs.getString("tarih"),rs.getString("saat"),rs.getString("salon"),rs.getString("koltuk_id"));
				list.add(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;	
	}
	
	public boolean addSinemaBilet(String sinemaAdi, String Tarih, String Saat, String Salon, int KoltukID) throws SQLException{
		String query = "INSERT INTO sinemabilet" + "(sinema_adi,tarih,saat,salon,koltuk_id) VALUES" + "('"+sinemaAdi+"','"+Tarih+"','"+Salon+"','"+KoltukID+"')";
		boolean key = false;
		try {
			
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, sinemaAdi);
			preparedStatement.setString(2, Tarih);
			preparedStatement.setString(3, Saat);
			preparedStatement.setString(4, Salon);
			preparedStatement.setInt(5, KoltukID);
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
	
	public boolean deleteSinemaBilet(int ID) throws SQLException{
		String query = "DELETE FROM sinemabilet WHERE id = ?";
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
	
	public boolean updateSinemaBilet(int ID, String sinemaAdi, String Tarih, String Saat, String Salon, String Koltuk) throws SQLException{
		String query = "UPDATE sinemabilet SET sinema_adi=?, tarih=?, saat=?, salon=?, koltuk=? WHERE id = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, sinemaAdi);
			preparedStatement.setString(2, Tarih);
			preparedStatement.setString(3, Saat);
			preparedStatement.setString(4, Salon);
			preparedStatement.setString(5, Koltuk);
			preparedStatement.setInt(6, ID);
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
