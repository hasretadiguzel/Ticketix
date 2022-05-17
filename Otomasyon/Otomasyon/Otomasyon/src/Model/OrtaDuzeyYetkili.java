package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrtaDuzeyYetkili extends User{

	Connection con = conn.DBCon();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	
	int ID;
	String mudurAdi,Sifre;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMudurAdi() {
		return mudurAdi;
	}
	public void setMudurAdi(String mudurAdi) {
		this.mudurAdi = mudurAdi;
	}
	public String getSifre() {
		return Sifre;
	}
	public void setSifre(String sifre) {
		Sifre = sifre;
	}
	
	public OrtaDuzeyYetkili(int iD, String mudurAdi, String sifre) {
		super();
		this.ID = iD;
		this.mudurAdi = mudurAdi;
		this.Sifre = sifre;
	}
	
	
}
