package Helper;

public class Item {
	private int key;
	private String Ad, Tarih, Saat;
	
	public Item(int key, String Ad, String Tarih, String Saat) {
		super();
		this.key = key;
		this.Ad = Ad;
		this.Tarih = Tarih;
		this.Saat = Saat;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getAd() {
		return Ad;
	}

	public void setAd(String ad) {
		this.Ad = ad;
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
	
	public String toString() {
		return this.Ad;
	}

	
	
	
	
}
