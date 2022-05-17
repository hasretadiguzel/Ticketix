package Model;

import java.sql.*;

import Helper.DBConnection;

public class Konser {
	
	DBConnection conn = new DBConnection();
	Connection con = conn.DBCon();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	int ID;
	String konserAdi, Saat, Tarih, Salon;
	
	public Konser()	{}
	
	public Konser(int iD, String konserAdi, String tarih, String saat, String salon) {
		this.ID = iD;
		this.konserAdi = konserAdi;
		this.Tarih = tarih;
		this.Saat = saat;
		this.Salon = salon;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public String getKonserAdi() {
		return konserAdi;
	}

	public void setKonserAdi(String konserAdi) {
		this.konserAdi = konserAdi;
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

	
	
	
	
	
	
	
}
