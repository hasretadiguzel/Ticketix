package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.DBConnection;
import Helper.Helper;
import Model.Admin;
import Model.User;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.*;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField fld_kAdi;
	private JPasswordField fld_kPass;
	private JTextField fld_aAdi;
	private JPasswordField fld_aPass;
	private DBConnection conn = new DBConnection();
	private JTextField fld_mudurAdi;
	private JPasswordField fld_mudurPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 116, 464, 218);
		contentPane.add(tabbedPane);
		
		JPanel kulPanel = new JPanel();
		tabbedPane.addTab("Kullanýcý Giriþi", null, kulPanel, null);
		kulPanel.setLayout(null);
		
		JLabel lbl_kAdi = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lbl_kAdi.setBounds(60, 37, 79, 14);
		kulPanel.add(lbl_kAdi);
		
		JLabel lbl_kPass = new JLabel("\u015Eifre");
		lbl_kPass.setBounds(60, 78, 67, 14);
		kulPanel.add(lbl_kPass);
		
		fld_kAdi = new JTextField();
		fld_kAdi.setColumns(10);
		fld_kAdi.setBounds(181, 33, 163, 20);
		kulPanel.add(fld_kAdi);
		
		fld_kPass = new JPasswordField();
		fld_kPass.setBounds(181, 74, 163, 20);
		kulPanel.add(fld_kPass);
		
		JButton btn_kGiris = new JButton("Giri\u015F");
		btn_kGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_kAdi.getText().length()==0||fld_kPass.getText().length()==0) {
					Helper.showMsg("fill");
				}
				else {
					try {
						Connection con = conn.DBCon();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM users");
						while(rs.next()) {
							if (fld_kAdi.getText().equals(rs.getString("k_adi")) && fld_kPass.getText().equals(rs.getString("sifre"))) {
								User user = new User();
								user.setID(rs.getInt("id"));
								user.setAdi(rs.getString("adi"));
								user.setSoyadi(rs.getString("soyadi"));
								user.setkAdi(rs.getString("k_adi"));
								user.setSifre(rs.getString("sifre"));
								user.setMailAdresi(rs.getString("mail_adresi"));
								user.setTelNo(rs.getString("tel_no"));
								UserGUI giris = new UserGUI(user);
								giris.setVisible(true);
								dispose();
								
							}
							/*else {
								Helper.showMsg("wrong");
							}*/
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
 			}
		});
		btn_kGiris.setBounds(255, 119, 89, 23);
		kulPanel.add(btn_kGiris);
		
		JButton btn_kayitOl = new JButton("Kay\u0131t Ol");
		btn_kayitOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KayitOlGUI frame = new KayitOlGUI(null);
				frame.setVisible(true);
				dispose();
			}
		});
		btn_kayitOl.setBounds(156, 119, 89, 23);
		kulPanel.add(btn_kayitOl);
		
		/*JButton btn_SifreUnuttum = new JButton("\u015Eifremi Unuttum");
		btn_SifreUnuttum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SifremiUnuttumGUI sifreUnuttum = new SifremiUnuttumGUI(null);
				sifreUnuttum.setVisible(true);
				dispose();
			}
		});
		btn_SifreUnuttum.setBounds(156, 156, 188, 23);
		kulPanel.add(btn_SifreUnuttum); */
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Müdür Giriþi", null, panel, null);
		panel.setLayout(null);
		
		JLabel lbl_kAdi_1_1 = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lbl_kAdi_1_1.setBounds(60, 37, 79, 14);
		panel.add(lbl_kAdi_1_1);
		
		fld_mudurAdi = new JTextField();
		fld_mudurAdi.setColumns(10);
		fld_mudurAdi.setBounds(181, 33, 163, 20);
		panel.add(fld_mudurAdi);
		
		JLabel lbl_kPass_1_1 = new JLabel("\u015Eifre");
		lbl_kPass_1_1.setBounds(60, 78, 67, 14);
		panel.add(lbl_kPass_1_1);
		
		fld_mudurPass = new JPasswordField();
		fld_mudurPass.setBounds(181, 74, 163, 20);
		panel.add(fld_mudurPass);
		
		JButton btn_aGiris_1 = new JButton("Giri\u015F");
		btn_aGiris_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_mudurAdi.getText().length()==0||fld_mudurPass.getText().length()==0) {
					Helper.showMsg("fill");
				}
				else {
					try {
						Connection con = conn.DBCon();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM orta_duzey_yetkili");
						while(rs.next()) {
							if (fld_mudurAdi.getText().equals(rs.getString("mudur_adi")) && fld_mudurPass.getText().equals(rs.getString("sifre"))) {
								Admin admin = new Admin();
								admin.setID(rs.getInt("id"));
								admin.setkAdi(rs.getString("mudur_adi"));
								admin.setSifre(rs.getString("sifre"));
								OrtaDuzeyYetkili mudur = new OrtaDuzeyYetkili(admin);
								mudur.setVisible(true);
								dispose();
							}
							/*else {
								Helper.showMsg("wrong");
							}*/
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		btn_aGiris_1.setBounds(255, 119, 89, 23);
		panel.add(btn_aGiris_1);
		
		JPanel adminPanel = new JPanel();
		tabbedPane.addTab("Admin Giriþi", null, adminPanel, null);
		adminPanel.setLayout(null);
		
		JLabel lbl_kAdi_1 = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lbl_kAdi_1.setBounds(60, 37, 79, 14);
		adminPanel.add(lbl_kAdi_1);
		
		JLabel lbl_kPass_1 = new JLabel("\u015Eifre");
		lbl_kPass_1.setBounds(60, 78, 67, 14);
		adminPanel.add(lbl_kPass_1);
		
		fld_aAdi = new JTextField();
		fld_aAdi.setColumns(10);
		fld_aAdi.setBounds(181, 33, 163, 20);
		adminPanel.add(fld_aAdi);
		
		fld_aPass = new JPasswordField();
		fld_aPass.setBounds(181, 74, 163, 20);
		adminPanel.add(fld_aPass);
		
		JButton btn_aGiris = new JButton("Giri\u015F");
		btn_aGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_aAdi.getText().length()==0||fld_aPass.getText().length()==0) {
					Helper.showMsg("fill");
				}
				else {
					try {
						Connection con = conn.DBCon();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM admin");
						while(rs.next()) {
							if (fld_aAdi.getText().equals(rs.getString("k_adi")) && fld_aPass.getText().equals(rs.getString("sifre"))) {
								Admin admin = new Admin();
								admin.setID(rs.getInt("id"));
								admin.setkAdi(rs.getString("k_adi"));
								admin.setSifre(rs.getString("sifre"));
								AdminGUI admin2 = new AdminGUI(admin);
								admin2.setVisible(true);
								dispose();
							}
							/*else {
								Helper.showMsg("wrong");
							}*/
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		btn_aGiris.setBounds(255, 119, 89, 23);
		adminPanel.add(btn_aGiris);
		
		JLabel lbl_Baslik = new JLabel("B\u0130LET SATI\u015EI OTOMASYONU");
		lbl_Baslik.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_Baslik.setBounds(90, 46, 296, 29);
		contentPane.add(lbl_Baslik);
		
		
	}
}
