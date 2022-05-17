package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Helper.DBConnection;
import Helper.Helper;
import Helper.Item;
import Model.Admin;
import Model.User;
import Model.Konser;
import Model.KonserBilet;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import java.awt.Color;
import java.awt.SystemColor;

public class ConcertTicketFE extends JFrame {
		private JPanel contentPane;
		static KonserBilet KonserBilet = new KonserBilet();
		static User user = new User();
		private Admin admin = new Admin();
		private JTextField fld_KonserAdi;
		private JTextField fld_KonserTarih;
		private JTextField fld_KonserSaat;
		private JTextField fld_KonserSalonNo;
		private JLabel lbl_KonserAdi;
		
		private DBConnection conn = new DBConnection();
		Connection con = conn.DBCon();
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		private JTextField fld_SinemaSaat;
		
		private Object[] KonserBiletData = null;
		private DefaultTableModel KonserBiletiModel = null;
	
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ConcertTicketFE frame = new ConcertTicketFE(user);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	
		/**
		 * Create the frame.
		 * @throws SQLException 
		 */
		public ConcertTicketFE(User user) throws SQLException {
			
			KonserBiletiModel = new DefaultTableModel();
			Object[] colKonserBiletName = new Object[6];
			colKonserBiletName[0] = "Id";
			colKonserBiletName[1] = "Konser Adı";
			colKonserBiletName[2] = "Tarih";
			colKonserBiletName[3] = "Saat";
			colKonserBiletName[4] = "Salon";
			colKonserBiletName[5] = "Koltuk";
			KonserBiletiModel.setColumnIdentifiers(colKonserBiletName);
			KonserBiletData = new Object[6];
			for(int i=0;i<KonserBilet.getKonserBiletList().size();i++) {
				KonserBiletData[0] = KonserBilet.getKonserBiletList().get(i).getID();
				KonserBiletData[1] = KonserBilet.getKonserBiletList().get(i).getKonserAdi();
				KonserBiletData[2] = KonserBilet.getKonserBiletList().get(i).getTarih();
				KonserBiletData[3] = KonserBilet.getKonserBiletList().get(i).getSaat();
				KonserBiletData[4] = KonserBilet.getKonserBiletList().get(i).getSalon();
				KonserBiletData[5] = KonserBilet.getKonserBiletList().get(i).getKoltuk();
				KonserBiletiModel.addRow(KonserBiletData);
			}
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 706, 508);
			contentPane = new JPanel();
			contentPane.setBackground(SystemColor.info);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lbl_uName = new JLabel("Hoş Geldiniz" + " " + admin.getkAdi());
			lbl_uName.setForeground(new Color(128, 0, 0));
			lbl_uName.setFont(new Font("Arial Black", Font.PLAIN, 20));
			lbl_uName.setBounds(10, 10, 363, 29);
			contentPane.add(lbl_uName);
			
			JLabel lbl_Secim = new JLabel("Lütfen Konser Seçiminizi Yapınız");
			lbl_Secim.setFont(new Font("Arial Black", Font.PLAIN, 12));
			lbl_Secim.setBounds(10, 50, 293, 20);
			contentPane.add(lbl_Secim);
			
			JComboBox cb_konserSec = new JComboBox();
			cb_konserSec.setFont(new Font("Arial", Font.PLAIN, 11));
			cb_konserSec.setModel(new DefaultComboBoxModel(new String[] {"Konser Se\u00E7"}));
			cb_konserSec.setBounds(252, 47, 180, 22);
			for (int i = 0; i < admin.getKonserList().size(); i++) {
				cb_konserSec.addItem(new Item(admin.getKonserList().get(i).getID(), admin.getKonserList().get(i).getKonserAdi(), admin.getKonserList().get(i).getTarih(), admin.getKonserList().get(i).getSaat()));
			}
			contentPane.add(cb_konserSec);
			
			JButton btn_Cikis = new JButton("ÇIKIŞ");
			btn_Cikis.setFont(new Font("Arial Black", Font.PLAIN, 16));
			btn_Cikis.setForeground(new Color(128, 0, 0));
			btn_Cikis.setBackground(new Color(245, 222, 179));
			btn_Cikis.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LoginFE login = new LoginFE();
					login.setVisible(true);
					dispose();
				}
			});
			btn_Cikis.setBounds(528, 412, 150, 36);
			contentPane.add(btn_Cikis);
			
			JButton btn_Geri = new JButton("Geri");
			btn_Geri.setForeground(new Color(128, 0, 0));
			btn_Geri.setFont(new Font("Arial Black", Font.PLAIN, 16));
			btn_Geri.setBackground(new Color(245, 222, 179));
			btn_Geri.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UserFE kullanici = new UserFE(user);
					kullanici.setVisible(true);
					dispose();
				}
			});
			btn_Geri.setBounds(10, 412, 150, 36);
			contentPane.add(btn_Geri);
			
			JPanel w_Panel = new JPanel();
			w_Panel.setBackground(new Color(245, 222, 179));
			w_Panel.setBounds(10, 81, 668, 320);
			contentPane.add(w_Panel);
			w_Panel.setLayout(null);
			w_Panel.setVisible(false);
			
			lbl_KonserAdi = new JLabel("Konser Adı");
			lbl_KonserAdi.setFont(new Font("Arial Black", Font.PLAIN, 12));
			lbl_KonserAdi.setBounds(465, 11, 125, 23);
			w_Panel.add(lbl_KonserAdi);
			
			fld_KonserAdi = new JTextField();
			fld_KonserAdi.setFont(new Font("Arial", Font.PLAIN, 11));
			fld_KonserAdi.setEditable(false);
			fld_KonserAdi.setColumns(10);
			fld_KonserAdi.setBounds(465, 45, 184, 20);
			w_Panel.add(fld_KonserAdi);
			
			JLabel lbl_KonserTarih = new JLabel("Tarih");
			lbl_KonserTarih.setFont(new Font("Arial Black", Font.PLAIN, 12));
			lbl_KonserTarih.setBounds(465, 76, 125, 23);
			w_Panel.add(lbl_KonserTarih);
			
			fld_KonserTarih = new JTextField();
			fld_KonserTarih.setFont(new Font("Arial", Font.PLAIN, 11));
			fld_KonserTarih.setEditable(false);
			fld_KonserTarih.setColumns(10);
			fld_KonserTarih.setBounds(465, 110, 184, 20);
			w_Panel.add(fld_KonserTarih);
			
			JLabel lbl_KonserSaat = new JLabel("Saat");
			lbl_KonserSaat.setFont(new Font("Arial Black", Font.PLAIN, 12));
			lbl_KonserSaat.setBounds(465, 141, 125, 23);
			w_Panel.add(lbl_KonserSaat);
			
			fld_KonserSaat = new JTextField();
			fld_KonserSaat.setFont(new Font("Arial", Font.PLAIN, 11));
			fld_KonserSaat.setEditable(false);
			fld_KonserSaat.setColumns(10);
			fld_KonserSaat.setBounds(465, 175, 184, 20);
			w_Panel.add(fld_KonserSaat);
			
			JLabel lbl_KonserSalon = new JLabel("Salon");
			lbl_KonserSalon.setFont(new Font("Arial Black", Font.PLAIN, 12));
			lbl_KonserSalon.setBounds(465, 206, 125, 23);
			w_Panel.add(lbl_KonserSalon);
			
			fld_KonserSalonNo = new JTextField();
			fld_KonserSalonNo.setFont(new Font("Arial", Font.PLAIN, 11));
			fld_KonserSalonNo.setEditable(false);
			fld_KonserSalonNo.setColumns(10);
			fld_KonserSalonNo.setBounds(465, 240, 184, 20);
			w_Panel.add(fld_KonserSalonNo);
			
			JButton btn_KonserSatinAl = new JButton("Sat\u0131n Al");
			btn_KonserSatinAl.setBackground(new Color(255, 255, 255));
			btn_KonserSatinAl.setFont(new Font("Arial Black", Font.PLAIN, 13));
			btn_KonserSatinAl.setBounds(465, 271, 184, 35);
			w_Panel.add(btn_KonserSatinAl);
			
			JPanel w_KoltukPanel = new JPanel();
			w_KoltukPanel.setBackground(new Color(245, 222, 179));
			w_KoltukPanel.setBounds(10, 11, 445, 295);
			w_Panel.add(w_KoltukPanel);
			w_KoltukPanel.setLayout(null);
			
			JToggleButton btn_Koltuk1 = new JToggleButton("A1");
			btn_Koltuk1.setBackground(Color.YELLOW);
			btn_Koltuk1.setBounds(95, 22, 75, 23);
			w_KoltukPanel.add(btn_Koltuk1);
			
			JToggleButton btn_Koltuk2 = new JToggleButton("A2");
			btn_Koltuk2.setBackground(Color.YELLOW);
			btn_Koltuk2.setBounds(180, 22, 75, 23);
			w_KoltukPanel.add(btn_Koltuk2);
			
			JToggleButton btn_Koltuk3 = new JToggleButton("A3");
			btn_Koltuk3.setBackground(Color.YELLOW);
			btn_Koltuk3.setBounds(265, 22, 75, 23);
			w_KoltukPanel.add(btn_Koltuk3);
			
			JToggleButton btn_Koltuk4 = new JToggleButton("A4");
			btn_Koltuk4.setBackground(Color.YELLOW);
			btn_Koltuk4.setBounds(95, 71, 75, 23);
			w_KoltukPanel.add(btn_Koltuk4);
			
			JToggleButton btn_Koltuk5 = new JToggleButton("A5");
			btn_Koltuk5.setBackground(Color.YELLOW);
			btn_Koltuk5.setBounds(180, 71, 75, 23);
			w_KoltukPanel.add(btn_Koltuk5);
			
			JToggleButton btn_Koltuk6 = new JToggleButton("B1");
			btn_Koltuk6.setBackground(Color.YELLOW);
			btn_Koltuk6.setBounds(40, 90, 75, 23);
			w_KoltukPanel.add(btn_Koltuk6);
			
			JToggleButton btn_Koltuk7 = new JToggleButton("B2");
			btn_Koltuk7.setBackground(Color.YELLOW);
			btn_Koltuk7.setBounds(125, 90, 75, 23);
			w_KoltukPanel.add(btn_Koltuk7);
			
			JToggleButton btn_Koltuk8 = new JToggleButton("B3");
			btn_Koltuk8.setBackground(Color.YELLOW);
			btn_Koltuk8.setBounds(225, 90, 75, 23);
			w_KoltukPanel.add(btn_Koltuk8);
			
			JToggleButton btn_Koltuk9 = new JToggleButton("B4");
			btn_Koltuk9.setBackground(Color.YELLOW);
			btn_Koltuk9.setBounds(317, 90, 75, 23);
			w_KoltukPanel.add(btn_Koltuk9);
			
			JToggleButton btn_Koltuk10 = new JToggleButton("B5");
			btn_Koltuk10.setBackground(Color.YELLOW);
			btn_Koltuk10.setBounds(300, 117, 75, 23);
			w_KoltukPanel.add(btn_Koltuk10);
			
			JToggleButton btn_Koltuk11 = new JToggleButton("C1");
			btn_Koltuk11.setBackground(Color.YELLOW);
			btn_Koltuk11.setBounds(10, 166, 75, 23);
			w_KoltukPanel.add(btn_Koltuk11);
			
			JToggleButton btn_Koltuk12 = new JToggleButton("C2");
			btn_Koltuk12.setBackground(Color.YELLOW);
			btn_Koltuk12.setBounds(95, 166, 75, 23);
			w_KoltukPanel.add(btn_Koltuk12);
			
			JToggleButton btn_Koltuk13 = new JToggleButton("C3");
			btn_Koltuk13.setBackground(Color.YELLOW);
			btn_Koltuk13.setBounds(180, 166, 75, 23);
			w_KoltukPanel.add(btn_Koltuk13);
			
			JToggleButton btn_Koltuk14 = new JToggleButton("C4");
			btn_Koltuk14.setBackground(Color.YELLOW);
			btn_Koltuk14.setBounds(265, 166, 75, 23);
			w_KoltukPanel.add(btn_Koltuk14);
			
			JToggleButton btn_Koltuk15 = new JToggleButton("C5");
			btn_Koltuk15.setBackground(Color.YELLOW);
			btn_Koltuk15.setBounds(350, 166, 75, 23);
			w_KoltukPanel.add(btn_Koltuk15);
			
			JButton btn_KonserSec = new JButton("Se\u00E7");
			btn_KonserSec.setForeground(new Color(128, 0, 0));
			btn_KonserSec.setBackground(new Color(245, 222, 179));
			btn_KonserSec.setFont(new Font("Arial Black", Font.PLAIN, 13));
			btn_KonserSec.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					w_Panel.setVisible(true);
					String konser = cb_konserSec.getSelectedItem().toString();
					if(cb_konserSec.getSelectedIndex()==0) {
						w_Panel.setVisible(false);
						Helper.showMsg("filmSec");
					}
					else {
						if (btn_Koltuk1.isSelected()||btn_Koltuk2.isSelected()||btn_Koltuk3.isSelected()||btn_Koltuk4.isSelected()||btn_Koltuk5.isSelected()|btn_Koltuk6.isSelected()
							||btn_Koltuk7.isSelected()||btn_Koltuk8.isSelected()||btn_Koltuk9.isSelected()|| btn_Koltuk10.isSelected()||btn_Koltuk11.isSelected()||btn_Koltuk12.isSelected()
							||btn_Koltuk13.isSelected()||btn_Koltuk14.isSelected()||btn_Koltuk15.isSelected()) {
							
							w_KoltukPanel.validate();
							w_KoltukPanel.repaint();
						
						}
						else {
							
						}
						
						
						try {
							String query = "SELECT * FROM konser WHERE konser_adi=?";
							preparedStatement = con.prepareStatement(query);
							preparedStatement.setString(1, konser);
							ResultSet rs = preparedStatement.executeQuery();						
							while(rs.next()) {
								fld_KonserAdi.setText(rs.getString("konser_adi"));
								fld_KonserTarih.setText(rs.getString("tarih"));
								fld_KonserSaat.setText(rs.getString("saat"));
								fld_KonserSalonNo.setText(rs.getString("salon"));
							}
							preparedStatement.close();
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
			});
			btn_KonserSec.setBounds(442, 47, 89, 23);
			contentPane.add(btn_KonserSec);
		}
	}
