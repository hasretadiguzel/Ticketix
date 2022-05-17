package Helper;

import javax.swing.JOptionPane;

public class Helper {

	public static void showMsg(String str) {
		
		String msg;
		
		switch (str) {
		case "fill": 
			msg = "Lütfen Bütün Alanlarý Doldurunuz.";
			break;
		case "success":
			msg = "Ýþlem Baþarýlý";
			break;
		case "unsuccess":
			msg = "Ýþlem Baþarýsýz";
			break;
		case "wrong":
			msg = "Kullanýcý Adý veya Þifre yanlýþ";
			break;
		case "same":
			msg = "Girdiðiniz Deðerlerde Böyle Bir Kullanýcý Mevcut";
			break;
		case "date":
			msg = "Ýsim, Tarih, Saat veya Salon Belirtmediniz.";
			break;
		case "dateforkonser":
			msg = "Tarih veya Saat Seçmediniz.";
			break;
		case "sifre":
			msg = "Þifreniz Deðiþtirilmiþtir.";
			break;
		case "koltuk":
			msg = "Lütfen Koltuk Seçiniz.";
			break;
		case "filmSec":
			msg = "Lütfen Bir Film Seçiniz.";
			break;
		case "tiyatroSec":
			msg = "Lütfen Bir Film Seçiniz.";
			break;
		case "konserSec":
			msg = "Lütfen Bir Film Seçiniz.";
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
			msg = "Bu iþlemi onaylýyor musunuz?";
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
