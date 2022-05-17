package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Helper.DBConnection;
import Helper.Helper;
import Model.Admin;
import Model.User;

import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

public class KayitOlGUI extends JFrame {

	static Admin admin = new Admin();
	private JPanel contentPane;
	private JLabel lbl_userSifre;
	private JTextField fld_userAdi;
	private JTextField fld_userSoyadi;
	private JTextField fld_userKullaniciAdi;
	private JTextField fld_usermailAdresi;
	private JTextField fld_usertelNo;
	private JPasswordField fld_userPass;
	static User user = new User();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KayitOlGUI frame = new KayitOlGUI(admin);
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
	public KayitOlGUI(Admin admin) {
				
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_userAdi = new JLabel("Ad\u0131:");
		lbl_userAdi.setBounds(50, 100, 110, 21);
		contentPane.add(lbl_userAdi);
		
		JLabel lbl_userSoyadi = new JLabel("Soyad\u0131:");
		lbl_userSoyadi.setBounds(50, 140, 110, 21);
		contentPane.add(lbl_userSoyadi);
		
		JLabel lbl_userKullaniciAdi = new JLabel("Kullan\u0131c\u0131 Ad\u0131:");
		lbl_userKullaniciAdi.setBounds(50, 180, 110, 21);
		contentPane.add(lbl_userKullaniciAdi);
		
		lbl_userSifre = new JLabel("\u015Eifre:");
		lbl_userSifre.setBounds(50, 220, 110, 21);
		contentPane.add(lbl_userSifre);
		
		JLabel lbl_usermailAdresi = new JLabel("Mail Adresi:");
		lbl_usermailAdresi.setBounds(50, 260, 110, 21);
		contentPane.add(lbl_usermailAdresi);
		
		JLabel lbl_usertelNo = new JLabel("Telefon Numaras\u0131:");
		lbl_usertelNo.setBounds(50, 300, 110, 21);
		contentPane.add(lbl_usertelNo);
		
		JButton btn_kayitOl = new JButton("Kay\u0131t Ol");
		btn_kayitOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_userAdi.getText().length()==0||fld_userSoyadi.getText().length()==0||fld_userKullaniciAdi.getText().length()==0||fld_userPass.getText().length()==0||fld_usermailAdresi.getText().length()==0||fld_usertelNo.getText().length()!=11) {
					Helper.showMsg("fill");
				}
				else {
					try {
						boolean control = user.addUser(fld_userAdi.getText(), fld_userSoyadi.getText(), fld_userKullaniciAdi.getText(), fld_userPass.getText(), fld_usermailAdresi.getText(), fld_usertelNo.getText());
						if (control) {
							Helper.showMsg("success");
							LoginGUI login = new LoginGUI();
							login.setVisible(true);
							dispose();
						}
						else {
							Helper.showMsg("same");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}	            
		});
		btn_kayitOl.setBounds(313, 342, 89, 23);
		contentPane.add(btn_kayitOl);
		
		fld_userAdi = new JTextField();
		fld_userAdi.setBounds(170, 100, 232, 20);
		contentPane.add(fld_userAdi);
		fld_userAdi.setColumns(10);
		
		fld_userSoyadi = new JTextField();
		fld_userSoyadi.setColumns(10);
		fld_userSoyadi.setBounds(170, 140, 232, 20);
		contentPane.add(fld_userSoyadi);
		
		fld_userKullaniciAdi = new JTextField();
		fld_userKullaniciAdi.setColumns(10);
		fld_userKullaniciAdi.setBounds(170, 180, 232, 20);
		contentPane.add(fld_userKullaniciAdi);
		
		fld_usermailAdresi = new JTextField();
		fld_usermailAdresi.setColumns(10);
		fld_usermailAdresi.setBounds(170, 260, 232, 20);
		contentPane.add(fld_usermailAdresi);
		
		fld_usertelNo = new JTextField("");
		fld_usertelNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String telNo = fld_usertelNo.getText();
				int length = telNo.length();
				char c = e.getKeyChar();
				if (e.getKeyChar()>='0' && e.getKeyChar()<='9') {
					if (length<11) {
						fld_usertelNo.setEditable(true);
					}
					else {
						fld_usertelNo.setEditable(false);
					}
				}
				else {
					if (e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
						fld_usertelNo.setEditable(true);
					}
					else {
						fld_usertelNo.setEditable(false);
					}
				}	
			}
		});
		fld_usertelNo.setColumns(10);
		fld_usertelNo.setBounds(170, 300, 232, 20);
		contentPane.add(fld_usertelNo);
		
		fld_userPass = new JPasswordField();
		fld_userPass.setBounds(170, 220, 232, 20);
		contentPane.add(fld_userPass);
		
		JLabel lbl_kayitOl = new JLabel("Kay\u0131t Ol");
		lbl_kayitOl.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_kayitOl.setBounds(170, 33, 89, 34);
		contentPane.add(lbl_kayitOl);
		
		JButton btn_Geri = new JButton("Geri");
		btn_Geri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI login = new LoginGUI();
				login.setVisible(true);
				dispose();
			}
		});
		btn_Geri.setBounds(10, 11, 58, 21);
		contentPane.add(btn_Geri);
	}
}
