package Helper;

import javax.swing.JOptionPane;

public class Helper {

	public static void showMsg(String str) {
		
		String msg;
		
		switch (str) {
		case "fill": 
			msg = "L�tfen B�t�n Alanlar� Doldurunuz.";
			break;
		case "success":
			msg = "��lem Ba�ar�l�";
			break;
		case "unsuccess":
			msg = "��lem Ba�ar�s�z";
			break;
		case "wrong":
			msg = "Kullan�c� Ad� veya �ifre yanl��";
			break;
		case "same":
			msg = "Girdi�iniz De�erlerde B�yle Bir Kullan�c� Mevcut";
			break;
		case "date":
			msg = "�sim, Tarih, Saat veya Salon Belirtmediniz.";
			break;
		case "dateforkonser":
			msg = "Tarih veya Saat Se�mediniz.";
			break;
		case "sifre":
			msg = "�ifreniz De�i�tirilmi�tir.";
			break;
		case "koltuk":
			msg = "L�tfen Koltuk Se�iniz.";
			break;
		case "filmSec":
			msg = "L�tfen Bir Film Se�iniz.";
			break;
		case "tiyatroSec":
			msg = "L�tfen Bir Film Se�iniz.";
			break;
		case "konserSec":
			msg = "L�tfen Bir Film Se�iniz.";
			break;
		
		default:
			msg = str;
		}
		
		JOptionPane.showMessageDialog(null, msg);
	}
		
	public static boolean confirm(String str) {
		String msg;
		switch (str) {
		case "evet": 
			msg = "Bu i�lemi onayl�yor musunuz?";
			break;
		default:
			msg = str;
			break;
		}
	
	int res = JOptionPane.showConfirmDialog(null, msg,"Dikkat !", JOptionPane.YES_NO_OPTION);
		if (res==0) {
			return true;
		}
		else {
			return false;
		}
	
	}
}
