package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Model.Admin;
import Model.Sinema;
import Model.SinemaBilet;
import Model.User;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

import java.sql.*;
import java.text.SimpleDateFormat;

import Helper.DBConnection;
import Helper.Helper;
import Helper.Item;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.SystemColor;

public class CinemaTicketFE extends JFrame {
		private JPanel contentPane;
		static SinemaBilet SinemaBilet = new SinemaBilet();
		static User user = new User();
		private Admin admin = new Admin();
		private JTextField fld_SinemaAdi;
		private JTextField fld_SinemaTarih;
		private JTextField fld_SinemaSalonNo;
		private DBConnection conn = new DBConnection();
		Connection con = conn.DBCon();
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		private JTextField fld_SinemaSaat;
		
		private Object[] SinemaBiletData = null;
		private DefaultTableModel SinemaBiletiModel = null;
	
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						CinemaTicketFE frame = new CinemaTicketFE(user);
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
		public CinemaTicketFE(User user) throws SQLException {
			
			SinemaBiletiModel = new DefaultTableModel();
			Object[] colSinemaBiletName = new Object[6];
			colSinemaBiletName[0] = "ID";
			colSinemaBiletName[1] = "sinemaAdi";
			colSinemaBiletName[2] = "Tarih";
			colSinemaBiletName[3] = "Saat";
			colSinemaBiletName[4] = "Salon";
			colSinemaBiletName[5] = "Koltuk";
			SinemaBiletiModel.setColumnIdentifiers(colSinemaBiletName);
			SinemaBiletData = new Object[6];
			for(int i=0;i<SinemaBilet.getSinemaBiletList().size();i++) {
				SinemaBiletData[0] = SinemaBilet.getSinemaBiletList().get(i).getID();
				SinemaBiletData[1] = SinemaBilet.getSinemaBiletList().get(i).getSinemaAdi();
				SinemaBiletData[2] = SinemaBilet.getSinemaBiletList().get(i).getTarih();
				SinemaBiletData[3] = SinemaBilet.getSinemaBiletList().get(i).getSaat();
				SinemaBiletData[4] = SinemaBilet.getSinemaBiletList().get(i).getSalon();
				SinemaBiletData[5] = SinemaBilet.getSinemaBiletList().get(i).getKoltuk();
				SinemaBiletiModel.addRow(SinemaBiletData);
			}
					
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 706, 508);
			contentPane = new JPanel();
			contentPane.setBackground(SystemColor.info);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lbl_uName = new JLabel("Hoş Geldiniz, <dynamic>");
			lbl_uName.setForeground(new Color(128, 0, 0));
			lbl_uName.setFont(new Font("Arial Black", Font.PLAIN, 20));
			lbl_uName.setBounds(10, 10, 363, 29);
			contentPane.add(lbl_uName);
			
			JLabel lbl_Secim = new JLabel("Lütfen Etkinlik Seçiminizi Yapınız");
			lbl_Secim.setFont(new Font("Arial Black", Font.PLAIN, 12));
			lbl_Secim.setBounds(10, 50, 293, 20);
			contentPane.add(lbl_Secim);
				
			JComboBox cb_sinemaSec = new JComboBox();
			cb_sinemaSec.setFont(new Font("Arial", Font.PLAIN, 11));
			cb_sinemaSec.setModel(new DefaultComboBoxModel(new String[] {"Sinema Seç"}));
			cb_sinemaSec.setBounds(252, 47, 180, 22);
			for (int i = 0; i < admin.getSinemaList().size(); i++) {
				cb_sinemaSec.addItem(new Item(admin.getSinemaList().get(i).getID(), admin.getSinemaList().get(i).getSinemaAdi(), admin.getSinemaList().get(i).getTarih(), admin.getSinemaList().get(i).getSaat()));
			}
			contentPane.add(cb_sinemaSec); 
			
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
			btn_Geri.setFont(new Font("Arial Black", Font.PLAIN, 16));
			btn_Geri.setForeground(new Color(128, 0, 0));
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
			
			JPanel w_KoltukPanel = new JPanel();
			w_KoltukPanel.setBackground(new Color(245, 222, 179));
			w_KoltukPanel.setBounds(10, 11, 445, 295);
			w_Panel.add(w_KoltukPanel);
			w_KoltukPanel.setLayout(null);
			
			JToggleButton btn_Koltuk1 = new JToggleButton("A1");
			btn_Koltuk1.setBounds(95, 22, 75, 23);
			w_KoltukPanel.add(btn_Koltuk1);
			btn_Koltuk1.setBackground(Color.YELLOW);
			btn_Koltuk1.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk1.isSelected()) {
						btn_Koltuk1.setBackground(Color.red);
					}
					else {
						btn_Koltuk1.setBackground(Color.YELLOW);
					}
				}
			});
					
			JToggleButton btn_Koltuk2 = new JToggleButton("A2");
			btn_Koltuk2.setBounds(180, 22, 75, 23);
			w_KoltukPanel.add(btn_Koltuk2);
			btn_Koltuk2.setBackground(Color.YELLOW);
			btn_Koltuk2.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk2.isSelected()) {
						btn_Koltuk2.setBackground(Color.red);
					}
					else {
						btn_Koltuk2.setBackground(Color.YELLOW);
					}
				}
			});
			
			JToggleButton btn_Koltuk3 = new JToggleButton("A3");
			btn_Koltuk3.setBounds(265, 22, 75, 23);
			w_KoltukPanel.add(btn_Koltuk3);
			btn_Koltuk3.setBackground(Color.YELLOW);
			btn_Koltuk3.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk3.isSelected()) {
						btn_Koltuk3.setBackground(Color.red);
					}
					else {
						btn_Koltuk3.setBackground(Color.YELLOW);
					}
				}
			});
			
			JToggleButton btn_Koltuk4 = new JToggleButton("A4");
			btn_Koltuk4.setBounds(95, 71, 75, 23);
			w_KoltukPanel.add(btn_Koltuk4);
			btn_Koltuk4.setBackground(Color.YELLOW);
			btn_Koltuk4.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk4.isSelected()) {
						btn_Koltuk4.setBackground(Color.red);
					}
					else {
						btn_Koltuk4.setBackground(Color.YELLOW);
					}
				}
			});
			
			JToggleButton btn_Koltuk5 = new JToggleButton("A5");
			btn_Koltuk5.setBounds(180, 71, 75, 23);
			w_KoltukPanel.add(btn_Koltuk5);
			btn_Koltuk5.setBackground(Color.YELLOW);
			btn_Koltuk5.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk5.isSelected()) {
						btn_Koltuk5.setBackground(Color.red);
					}
					else {
						btn_Koltuk5.setBackground(Color.YELLOW);
					}
				}
			}); 
			
			JToggleButton btn_Koltuk6 = new JToggleButton("B1");
			btn_Koltuk6.setBounds(265, 71, 75, 23);
			w_KoltukPanel.add(btn_Koltuk6);
			btn_Koltuk6.setBackground(Color.YELLOW);
			btn_Koltuk6.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk6.isSelected()) {
						btn_Koltuk6.setBackground(Color.red);
					}
					else {
						btn_Koltuk6.setBackground(Color.YELLOW);
					}
				}
			});
			
			JToggleButton btn_Koltuk7 = new JToggleButton("B2");
			btn_Koltuk7.setBounds(45, 117, 75, 23);
			w_KoltukPanel.add(btn_Koltuk7);
			btn_Koltuk7.setBackground(Color.YELLOW);
			btn_Koltuk7.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk7.isSelected()) {
						btn_Koltuk7.setBackground(Color.red);
					}
					else {
						btn_Koltuk7.setBackground(Color.YELLOW);
					}
				}
			});
			
			JToggleButton btn_Koltuk8 = new JToggleButton("B3");
			btn_Koltuk8.setBounds(130, 117, 75, 23);
			w_KoltukPanel.add(btn_Koltuk8);
			btn_Koltuk8.setBackground(Color.YELLOW);
			btn_Koltuk8.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk8.isSelected()) {
						btn_Koltuk8.setBackground(Color.red);
					}
					else {
						btn_Koltuk8.setBackground(Color.YELLOW);
					}
				}
			});
			
			JToggleButton btn_Koltuk9_1 = new JToggleButton("B4");
			btn_Koltuk9_1.setBounds(130, 117, 75, 23);
			w_KoltukPanel.add(btn_Koltuk9_1);
			btn_Koltuk9_1.setBackground(Color.YELLOW);
			btn_Koltuk9_1.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk9_1.isSelected()) {
						btn_Koltuk9_1.setBackground(Color.red);
					}
					else {
						btn_Koltuk9_1.setBackground(Color.YELLOW);
					}
				}
			});
			
			JToggleButton btn_Koltuk10 = new JToggleButton("B5");
			btn_Koltuk10.setBounds(300, 117, 75, 23);
			w_KoltukPanel.add(btn_Koltuk10);
			btn_Koltuk10.setBackground(Color.YELLOW);
			btn_Koltuk10.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk10.isSelected()) {
						btn_Koltuk10.setBackground(Color.red);
					}
					else {
						btn_Koltuk10.setBackground(Color.YELLOW);
					}
				}
			}); 
			
			JToggleButton btn_Koltuk11 = new JToggleButton("C1");
			btn_Koltuk11.setBounds(10, 166, 75, 23);
			w_KoltukPanel.add(btn_Koltuk11);
			btn_Koltuk11.setBackground(Color.YELLOW);
			btn_Koltuk11.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk11.isSelected()) {
						btn_Koltuk11.setBackground(Color.red);
					}
					else {
						btn_Koltuk11.setBackground(Color.YELLOW);
					}
				}
			});
			
			JToggleButton btn_Koltuk12 = new JToggleButton("C2");
			btn_Koltuk12.setBounds(95, 166, 75, 23);
			w_KoltukPanel.add(btn_Koltuk12);
			btn_Koltuk12.setBackground(Color.YELLOW);
			btn_Koltuk12.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk12.isSelected()) {
						btn_Koltuk12.setBackground(Color.red);
					}
					else {
						btn_Koltuk12.setBackground(Color.YELLOW);
					}
				}
			});
			
			JToggleButton btn_Koltuk13 = new JToggleButton("C3");
			btn_Koltuk13.setBounds(180, 166, 75, 23);
			w_KoltukPanel.add(btn_Koltuk13);
			btn_Koltuk13.setBackground(Color.YELLOW);
			btn_Koltuk13.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk13.isSelected()) {
						btn_Koltuk13.setBackground(Color.red);
					}
					else {
						btn_Koltuk13.setBackground(Color.YELLOW);
					}
				}
			});
			
			JToggleButton btn_Koltuk14 = new JToggleButton("C4");
			btn_Koltuk14.setBounds(265, 166, 75, 23);
			w_KoltukPanel.add(btn_Koltuk14);
			btn_Koltuk14.setBackground(Color.YELLOW);
			btn_Koltuk14.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk14.isSelected()) {
						btn_Koltuk14.setBackground(Color.red);
					}
					else {
						btn_Koltuk14.setBackground(Color.YELLOW);
					}
				}
			});
			
			JToggleButton btn_Koltuk15 = new JToggleButton("C5");
			btn_Koltuk15.setBounds(350, 166, 75, 23);
			w_KoltukPanel.add(btn_Koltuk15);
			btn_Koltuk15.setBackground(Color.YELLOW);
			
			JToggleButton btn_Koltuk9_1_1 = new JToggleButton("B4");
			btn_Koltuk9_1_1.setBackground(Color.YELLOW);
			btn_Koltuk9_1_1.setBounds(215, 117, 75, 23);
			w_KoltukPanel.add(btn_Koltuk9_1_1);
			btn_Koltuk15.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk15.isSelected()) {
						btn_Koltuk15.setBackground(Color.red);
					}
					else {
						btn_Koltuk15.setBackground(Color.YELLOW);
					}
				}
			});
			
			JButton btn_SinemaSatinAl = new JButton("Sat\u0131n Al");
			btn_SinemaSatinAl.setBackground(new Color(255, 255, 255));
			btn_SinemaSatinAl.setFont(new Font("Arial Black", Font.PLAIN, 13));
			btn_SinemaSatinAl.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
			
					if (btn_Koltuk1.isSelected()||btn_Koltuk2.isSelected()||btn_Koltuk3.isSelected()|| btn_Koltuk4.isSelected()|| btn_Koltuk5.isSelected()|| btn_Koltuk6.isSelected()
							||btn_Koltuk7.isSelected()||btn_Koltuk8.isSelected()||btn_Koltuk9_1.isSelected()|| btn_Koltuk10.isSelected()||btn_Koltuk11.isSelected()||btn_Koltuk12.isSelected()
							||btn_Koltuk13.isSelected()||btn_Koltuk14.isSelected()||btn_Koltuk15.isSelected()) {
						
							System.out.println("World");
						
							/*boolean control;
							try {
								for (int i = 0; i < koltuk.length; i++) {
									koltuk[i] = new JToggleButton();
									Koltuk = koltuk[i].toString();
								}
								control = SinemaBilet.addSinemaBilet(SinemaAdi, SinemaTarih, SinemaSaat, SalonNo, Koltuk);
								if (control) {
									Helper.showMsg("success");
								}
								else {
									Helper.showMsg("fill");
								}
							} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							}*/
					} else {
						Helper.showMsg("koltuk");
					}
				}
			});
			btn_SinemaSatinAl.setBounds(465, 271, 184, 35);
			w_Panel.add(btn_SinemaSatinAl);
			
			fld_SinemaAdi = new JTextField();
			fld_SinemaAdi.setFont(new Font("Arial", Font.PLAIN, 11));
			fld_SinemaAdi.setEditable(false);
			fld_SinemaAdi.setBounds(465, 45, 184, 20);
			w_Panel.add(fld_SinemaAdi);
			fld_SinemaAdi.setColumns(10);
			
			fld_SinemaTarih = new JTextField();
			fld_SinemaTarih.setFont(new Font("Arial", Font.PLAIN, 11));
			fld_SinemaTarih.setEditable(false);
			fld_SinemaTarih.setBounds(465, 110, 184, 20);
			w_Panel.add(fld_SinemaTarih);
			fld_SinemaTarih.setColumns(10);
			
			fld_SinemaSalonNo = new JTextField();
			fld_SinemaSalonNo.setFont(new Font("Arial", Font.PLAIN, 11));
			fld_SinemaSalonNo.setEditable(false);
			fld_SinemaSalonNo.setBounds(465, 240, 184, 20);
			w_Panel.add(fld_SinemaSalonNo);
			fld_SinemaSalonNo.setColumns(10);
			
			JLabel lbl_SinemaAdi = new JLabel("Sinema Ad\u0131");
			lbl_SinemaAdi.setFont(new Font("Arial Black", Font.PLAIN, 12));
			lbl_SinemaAdi.setBounds(465, 11, 125, 23);
			w_Panel.add(lbl_SinemaAdi);
			
			JLabel lbl_SinemaTarih = new JLabel("Tarih");
			lbl_SinemaTarih.setFont(new Font("Arial Black", Font.PLAIN, 12));
			lbl_SinemaTarih.setBounds(465, 76, 125, 23);
			w_Panel.add(lbl_SinemaTarih);
			
			JLabel lbl_SinemaSalon = new JLabel("Salon");
			lbl_SinemaSalon.setFont(new Font("Arial Black", Font.PLAIN, 12));
			lbl_SinemaSalon.setBounds(465, 206, 125, 23);
			w_Panel.add(lbl_SinemaSalon);
			
			JLabel lbl_SinemaSaat = new JLabel("Saat");
			lbl_SinemaSaat.setFont(new Font("Arial Black", Font.PLAIN, 12));
			lbl_SinemaSaat.setBounds(465, 141, 125, 23);
			w_Panel.add(lbl_SinemaSaat);
			
			fld_SinemaSaat = new JTextField();
			fld_SinemaSaat.setFont(new Font("Arial", Font.PLAIN, 11));
			fld_SinemaSaat.setEditable(false);
			fld_SinemaSaat.setColumns(10);
			fld_SinemaSaat.setBounds(465, 175, 184, 20);
			w_Panel.add(fld_SinemaSaat);
			
			JButton btn_SinemaSec = new JButton("Se\u00E7");
			btn_SinemaSec.setFont(new Font("Arial Black", Font.PLAIN, 13));
			btn_SinemaSec.setForeground(new Color(128, 0, 0));
			btn_SinemaSec.setBackground(new Color(245, 222, 179));
			btn_SinemaSec.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					/*btn_Koltuk1.setEnabled(true);
					btn_Koltuk2.setEnabled(true);
					btn_Koltuk3.setEnabled(true);
					btn_Koltuk4.setEnabled(true);
					btn_Koltuk5.setEnabled(true);
					btn_Koltuk6.setEnabled(true);
					btn_Koltuk7.setEnabled(true);
					btn_Koltuk8.setEnabled(true);
					btn_Koltuk9_1.setEnabled(true);
					btn_Koltuk10.setEnabled(true);
					btn_Koltuk11.setEnabled(true);
					btn_Koltuk12.setEnabled(true);
					btn_Koltuk13.setEnabled(true);
					btn_Koltuk14.setEnabled(true);
					btn_Koltuk15.setEnabled(true);*/
									
					w_Panel.setVisible(true);
					String sinema = cb_sinemaSec.getSelectedItem().toString();
					if(cb_sinemaSec.getSelectedIndex()==0) {
						w_Panel.setVisible(false);
						Helper.showMsg("filmSec");
					}
					else {
						if (btn_Koltuk1.isSelected()||btn_Koltuk2.isSelected()||btn_Koltuk3.isSelected()||btn_Koltuk4.isSelected()||btn_Koltuk5.isSelected()||btn_Koltuk6.isSelected()
							||btn_Koltuk7.isSelected()||btn_Koltuk8.isSelected()||btn_Koltuk9_1.isSelected()||btn_Koltuk10.isSelected()||btn_Koltuk11.isSelected()||btn_Koltuk12.isSelected()
							||btn_Koltuk13.isSelected()||btn_Koltuk14.isSelected()||btn_Koltuk15.isSelected()) {
							
							w_KoltukPanel.validate();
							w_KoltukPanel.repaint();
						
						}
						else {
							
						}
						
						
						try {
							String query = "SELECT * FROM sinema WHERE sinema_adi=?";
							preparedStatement = con.prepareStatement(query);
							preparedStatement.setString(1, sinema);
							ResultSet rs = preparedStatement.executeQuery();						
							while(rs.next()) {
								fld_SinemaAdi.setText(rs.getString("sinema_adi"));
								fld_SinemaTarih.setText(rs.getString("tarih"));
								fld_SinemaSaat.setText(rs.getString("saat"));
								fld_SinemaSalonNo.setText(rs.getString("salon"));
							}
							preparedStatement.close();
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
			});
			btn_SinemaSec.setBounds(442, 47, 89, 23);
			contentPane.add(btn_SinemaSec);
		}
}
