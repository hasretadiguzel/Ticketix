package Model;

import java.sql.*;

import Helper.DBConnection;

public class Tiyatro {
	
	DBConnection conn = new DBConnection();
	Connection con = conn.DBCon();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	int ID;
	String tiyatroAdi,Tarih,Saat,Salon;
	
	public Tiyatro() {}

	public Tiyatro(int iD, String tiyatroAdi, String tarih, String saat, String salon) {
		this.ID = iD;
		this.tiyatroAdi = tiyatroAdi;
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

	public String getTiyatroAdi() {
		return tiyatroAdi;
	}

	public void setTiyatroAdi(String tiyatroAdi) {
		this.tiyatroAdi = tiyatroAdi;
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
