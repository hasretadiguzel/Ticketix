package Model;

import java.sql.*;

import Helper.DBConnection;

public class Sinema {
	
	DBConnection conn = new DBConnection();
	Connection con = conn.DBCon();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	int ID;
	String sinemaAdi,Saat,Tarih,Salon;
	
	public Sinema() {}

	public Sinema(int iD, String sinemaAdi,String tarih , String saat, String salon) {
		this.ID = iD;
		this.sinemaAdi = sinemaAdi;
		this.Saat = saat;
		this.Tarih = tarih;
		this.Salon = salon;
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

	public String getSaat() {
		return Saat;
	}

	public void setSaat(String saat) {
		this.Saat = saat;
	}

	public String getTarih() {
		return Tarih;
	}

	public void setTarih(String tarih) {
		this.Tarih = tarih;
	}

	public String getSalon() {
		return Salon;
	}

	public void setSalon(String salon) {
		this.Salon = salon;
	}



	
	
	
}
