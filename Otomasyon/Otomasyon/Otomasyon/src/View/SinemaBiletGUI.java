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

public class SinemaBiletGUI extends JFrame {
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
						SinemaBiletGUI frame = new SinemaBiletGUI(user);
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
		public SinemaBiletGUI(User user) throws SQLException {
			
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
			setBounds(100, 100, 915, 480);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lbl_uName = new JLabel("Ho\u015F Geldiniz, Say\u0131n "+user.getAdi());
			lbl_uName.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbl_uName.setBounds(10, 50, 210, 20);
			contentPane.add(lbl_uName);
			
			JLabel lbl_Secim = new JLabel("Bilet Almak \u0130stedi\u011Finiz Sinemay\u0131 Se\u00E7iniz:");
			lbl_Secim.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbl_Secim.setBounds(10, 81, 230, 20);
			contentPane.add(lbl_Secim);
				
			JComboBox cb_sinemaSec = new JComboBox();
			cb_sinemaSec.setModel(new DefaultComboBoxModel(new String[] {"--Sinema Se\u00E7--"}));
			cb_sinemaSec.setBounds(250, 81, 180, 22);
			for (int i = 0; i < admin.getSinemaList().size(); i++) {
				cb_sinemaSec.addItem(new Item(admin.getSinemaList().get(i).getID(), admin.getSinemaList().get(i).getSinemaAdi(), admin.getSinemaList().get(i).getTarih(), admin.getSinemaList().get(i).getSaat()));
			}
			contentPane.add(cb_sinemaSec); 
			
			JButton btn_Cikis = new JButton("\u00C7\u0131k\u0131\u015F Yap");
			btn_Cikis.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LoginGUI login = new LoginGUI();
					login.setVisible(true);
					dispose(); 
				}
			});
			btn_Cikis.setBounds(794, 10, 95, 23);
			contentPane.add(btn_Cikis);
			
			JButton btn_Geri = new JButton("Geri");
			btn_Geri.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UserGUI kullanici = new UserGUI(user);
					kullanici.setVisible(true);
					dispose();
				}
			});
			btn_Geri.setBounds(10, 11, 58, 21);
			contentPane.add(btn_Geri);
			
			JPanel w_Panel = new JPanel();
			w_Panel.setBounds(10, 112, 879, 320);
			contentPane.add(w_Panel);
			w_Panel.setLayout(null);
			w_Panel.setVisible(false);
			
			JPanel w_KoltukPanel = new JPanel();
			w_KoltukPanel.setBounds(10, 11, 665, 295);
			w_Panel.add(w_KoltukPanel);
			w_KoltukPanel.setLayout(null);
			
			JToggleButton btn_Koltuk1 = new JToggleButton("A1");
			btn_Koltuk1.setBounds(10, 11, 121, 23);
			w_KoltukPanel.add(btn_Koltuk1);
			btn_Koltuk1.setBackground(Color.green);
			btn_Koltuk1.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk1.isSelected()) {
						btn_Koltuk1.setBackground(Color.red);
					}
					else {
						btn_Koltuk1.setBackground(Color.green);
					}
				}
			});
					
			JToggleButton btn_Koltuk2 = new JToggleButton("A2");
			btn_Koltuk2.setBounds(141, 11, 121, 23);
			w_KoltukPanel.add(btn_Koltuk2);
			btn_Koltuk2.setBackground(Color.green);
			btn_Koltuk2.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk2.isSelected()) {
						btn_Koltuk2.setBackground(Color.red);
					}
					else {
						btn_Koltuk2.setBackground(Color.green);
					}
				}
			});
			
			JToggleButton btn_Koltuk3 = new JToggleButton("A3");
			btn_Koltuk3.setBounds(272, 11, 121, 23);
			w_KoltukPanel.add(btn_Koltuk3);
			btn_Koltuk3.setBackground(Color.green);
			btn_Koltuk3.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk3.isSelected()) {
						btn_Koltuk3.setBackground(Color.red);
					}
					else {
						btn_Koltuk3.setBackground(Color.green);
					}
				}
			});
			
			JToggleButton btn_Koltuk4 = new JToggleButton("A4");
			btn_Koltuk4.setBounds(403, 11, 121, 23);
			w_KoltukPanel.add(btn_Koltuk4);
			btn_Koltuk4.setBackground(Color.green);
			btn_Koltuk4.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk4.isSelected()) {
						btn_Koltuk4.setBackground(Color.red);
					}
					else {
						btn_Koltuk4.setBackground(Color.green);
					}
				}
			});
			
			JToggleButton btn_Koltuk5 = new JToggleButton("A5");
			btn_Koltuk5.setBounds(534, 11, 121, 23);
			w_KoltukPanel.add(btn_Koltuk5);
			btn_Koltuk5.setBackground(Color.green);
			btn_Koltuk5.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk5.isSelected()) {
						btn_Koltuk5.setBackground(Color.red);
					}
					else {
						btn_Koltuk5.setBackground(Color.green);
					}
				}
			});
			
			JToggleButton btn_Koltuk6 = new JToggleButton("B1");
			btn_Koltuk6.setBounds(10, 120, 121, 23);
			w_KoltukPanel.add(btn_Koltuk6);
			btn_Koltuk6.setBackground(Color.green);
			btn_Koltuk6.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk6.isSelected()) {
						btn_Koltuk6.setBackground(Color.red);
					}
					else {
						btn_Koltuk6.setBackground(Color.green);
					}
				}
			});
			
			JToggleButton btn_Koltuk7 = new JToggleButton("B2");
			btn_Koltuk7.setBounds(141, 120, 121, 23);
			w_KoltukPanel.add(btn_Koltuk7);
			btn_Koltuk7.setBackground(Color.green);
			btn_Koltuk7.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk7.isSelected()) {
						btn_Koltuk7.setBackground(Color.red);
					}
					else {
						btn_Koltuk7.setBackground(Color.green);
					}
				}
			});
			
			JToggleButton btn_Koltuk8 = new JToggleButton("B3");
			btn_Koltuk8.setBounds(272, 120, 121, 23);
			w_KoltukPanel.add(btn_Koltuk8);
			btn_Koltuk8.setBackground(Color.green);
			btn_Koltuk8.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk8.isSelected()) {
						btn_Koltuk8.setBackground(Color.red);
					}
					else {
						btn_Koltuk8.setBackground(Color.green);
					}
				}
			});
			
			JToggleButton btn_Koltuk9 = new JToggleButton("B4");
			btn_Koltuk9.setBounds(403, 120, 121, 23);
			w_KoltukPanel.add(btn_Koltuk9);
			btn_Koltuk9.setBackground(Color.green);
			btn_Koltuk9.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk9.isSelected()) {
						btn_Koltuk9.setBackground(Color.red);
					}
					else {
						btn_Koltuk9.setBackground(Color.green);
					}
				}
			});
			
			JToggleButton btn_Koltuk10 = new JToggleButton("B5");
			btn_Koltuk10.setBounds(534, 120, 121, 23);
			w_KoltukPanel.add(btn_Koltuk10);
			btn_Koltuk10.setBackground(Color.green);
			btn_Koltuk10.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk10.isSelected()) {
						btn_Koltuk10.setBackground(Color.red);
					}
					else {
						btn_Koltuk10.setBackground(Color.green);
					}
				}
			});
			
			JToggleButton btn_Koltuk11 = new JToggleButton("C1");
			btn_Koltuk11.setBounds(10, 230, 121, 23);
			w_KoltukPanel.add(btn_Koltuk11);
			btn_Koltuk11.setBackground(Color.green);
			btn_Koltuk11.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk11.isSelected()) {
						btn_Koltuk11.setBackground(Color.red);
					}
					else {
						btn_Koltuk11.setBackground(Color.green);
					}
				}
			});
			
			JToggleButton btn_Koltuk12 = new JToggleButton("C2");
			btn_Koltuk12.setBounds(141, 230, 121, 23);
			w_KoltukPanel.add(btn_Koltuk12);
			btn_Koltuk12.setBackground(Color.green);
			btn_Koltuk12.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk12.isSelected()) {
						btn_Koltuk12.setBackground(Color.red);
					}
					else {
						btn_Koltuk12.setBackground(Color.green);
					}
				}
			});
			
			JToggleButton btn_Koltuk13 = new JToggleButton("C3");
			btn_Koltuk13.setBounds(272, 230, 121, 23);
			w_KoltukPanel.add(btn_Koltuk13);
			btn_Koltuk13.setBackground(Color.green);
			btn_Koltuk13.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk13.isSelected()) {
						btn_Koltuk13.setBackground(Color.red);
					}
					else {
						btn_Koltuk13.setBackground(Color.green);
					}
				}
			});
			
			JToggleButton btn_Koltuk14 = new JToggleButton("C4");
			btn_Koltuk14.setBounds(403, 230, 121, 23);
			w_KoltukPanel.add(btn_Koltuk14);
			btn_Koltuk14.setBackground(Color.green);
			btn_Koltuk14.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk14.isSelected()) {
						btn_Koltuk14.setBackground(Color.red);
					}
					else {
						btn_Koltuk14.setBackground(Color.green);
					}
				}
			});
			
			JToggleButton btn_Koltuk15 = new JToggleButton("C5");
			btn_Koltuk15.setBounds(534, 230, 121, 23);
			w_KoltukPanel.add(btn_Koltuk15);
			btn_Koltuk15.setBackground(Color.green);
			btn_Koltuk15.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(btn_Koltuk15.isSelected()) {
						btn_Koltuk15.setBackground(Color.red);
					}
					else {
						btn_Koltuk15.setBackground(Color.green);
					}
				}
			});
			
			JButton btn_SinemaSatinAl = new JButton("Sat\u0131n Al");
			btn_SinemaSatinAl.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
			
					if (btn_Koltuk1.isSelected()||btn_Koltuk2.isSelected()||btn_Koltuk3.isSelected()||btn_Koltuk4.isSelected()||btn_Koltuk5.isSelected()||btn_Koltuk6.isSelected()
							||btn_Koltuk7.isSelected()||btn_Koltuk8.isSelected()||btn_Koltuk9.isSelected()||btn_Koltuk10.isSelected()||btn_Koltuk11.isSelected()||btn_Koltuk12.isSelected()
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
			btn_SinemaSatinAl.setBounds(685, 283, 184, 23);
			w_Panel.add(btn_SinemaSatinAl);
			
			fld_SinemaAdi = new JTextField();
			fld_SinemaAdi.setEditable(false);
			fld_SinemaAdi.setBounds(685, 45, 184, 20);
			w_Panel.add(fld_SinemaAdi);
			fld_SinemaAdi.setColumns(10);
			
			fld_SinemaTarih = new JTextField();
			fld_SinemaTarih.setEditable(false);
			fld_SinemaTarih.setBounds(685, 110, 184, 20);
			w_Panel.add(fld_SinemaTarih);
			fld_SinemaTarih.setColumns(10);
			
			fld_SinemaSalonNo = new JTextField();
			fld_SinemaSalonNo.setEditable(false);
			fld_SinemaSalonNo.setBounds(685, 240, 184, 20);
			w_Panel.add(fld_SinemaSalonNo);
			fld_SinemaSalonNo.setColumns(10);
			
			JLabel lbl_SinemaAdi = new JLabel("Sinema Ad\u0131");
			lbl_SinemaAdi.setBounds(685, 11, 125, 23);
			w_Panel.add(lbl_SinemaAdi);
			
			JLabel lbl_SinemaTarih = new JLabel("Tarih");
			lbl_SinemaTarih.setBounds(685, 76, 125, 23);
			w_Panel.add(lbl_SinemaTarih);
			
			JLabel lbl_SinemaSalon = new JLabel("Salon");
			lbl_SinemaSalon.setBounds(685, 206, 125, 23);
			w_Panel.add(lbl_SinemaSalon);
			
			JLabel lbl_SinemaSaat = new JLabel("Saat");
			lbl_SinemaSaat.setBounds(685, 141, 125, 23);
			w_Panel.add(lbl_SinemaSaat);
			
			fld_SinemaSaat = new JTextField();
			fld_SinemaSaat.setEditable(false);
			fld_SinemaSaat.setColumns(10);
			fld_SinemaSaat.setBounds(685, 175, 184, 20);
			w_Panel.add(fld_SinemaSaat);
			
			JButton btn_SinemaSec = new JButton("Se\u00E7");
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
					btn_Koltuk9.setEnabled(true);
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
							||btn_Koltuk7.isSelected()||btn_Koltuk8.isSelected()||btn_Koltuk9.isSelected()||btn_Koltuk10.isSelected()||btn_Koltuk11.isSelected()||btn_Koltuk12.isSelected()
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
			btn_SinemaSec.setBounds(440, 81, 89, 23);
			contentPane.add(btn_SinemaSec);
		}
}
