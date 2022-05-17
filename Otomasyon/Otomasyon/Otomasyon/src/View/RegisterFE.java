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
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;

public class RegisterFE extends JFrame {

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
					RegisterFE frame = new RegisterFE(admin);
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
	public RegisterFE(Admin admin) {
				
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 612);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_userAdi = new JLabel("Ad");
		lbl_userAdi.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lbl_userAdi.setBounds(23, 142, 41, 21);
		contentPane.add(lbl_userAdi);
		
		JLabel lbl_userSoyadi = new JLabel("Soyad");
		lbl_userSoyadi.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lbl_userSoyadi.setBounds(23, 194, 58, 21);
		contentPane.add(lbl_userSoyadi);
		
		JLabel lbl_userKullaniciAdi = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lbl_userKullaniciAdi.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lbl_userKullaniciAdi.setBounds(23, 297, 97, 21);
		contentPane.add(lbl_userKullaniciAdi);
		
		lbl_userSifre = new JLabel("\u015Eifre");
		lbl_userSifre.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lbl_userSifre.setBounds(23, 245, 41, 21);
		contentPane.add(lbl_userSifre);
		
		JLabel lbl_usermailAdresi = new JLabel("Mail Adresi");
		lbl_usermailAdresi.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lbl_usermailAdresi.setBounds(23, 402, 89, 21);
		contentPane.add(lbl_usermailAdresi);
		
		JLabel lbl_usertelNo = new JLabel("Telefon Numaras\u0131:");
		lbl_usertelNo.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lbl_usertelNo.setBounds(23, 454, 142, 21);
		contentPane.add(lbl_usertelNo);
		
		JButton btn_kayitOl = new JButton("Kay\u0131t Ol");
		btn_kayitOl.setForeground(new Color(128, 0, 0));
		btn_kayitOl.setBackground(new Color(245, 222, 179));
		btn_kayitOl.setFont(new Font("Arial Black", Font.PLAIN, 16));
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
							LoginFE login = new LoginFE();
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
		btn_kayitOl.setBounds(152, 515, 116, 36);
		contentPane.add(btn_kayitOl);
		
		fld_userAdi = new JTextField();
		fld_userAdi.setFont(new Font("Arial", Font.PLAIN, 11));
		fld_userAdi.setBounds(23, 163, 245, 20);
		contentPane.add(fld_userAdi);
		fld_userAdi.setColumns(10);
		
		fld_userSoyadi = new JTextField();
		fld_userSoyadi.setFont(new Font("Arial", Font.PLAIN, 11));
		fld_userSoyadi.setColumns(10);
		fld_userSoyadi.setBounds(23, 214, 245, 20);
		contentPane.add(fld_userSoyadi);
		
		fld_userKullaniciAdi = new JTextField();
		fld_userKullaniciAdi.setFont(new Font("Arial", Font.PLAIN, 11));
		fld_userKullaniciAdi.setColumns(10);
		fld_userKullaniciAdi.setBounds(23, 316, 245, 20);
		contentPane.add(fld_userKullaniciAdi);
		
		fld_usermailAdresi = new JTextField();
		fld_usermailAdresi.setFont(new Font("Arial", Font.PLAIN, 11));
		fld_usermailAdresi.setColumns(10);
		fld_usermailAdresi.setBounds(23, 423, 245, 20);
		contentPane.add(fld_usermailAdresi);
		
		fld_usertelNo = new JTextField("");
		fld_usertelNo.setFont(new Font("Arial", Font.PLAIN, 11));
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
		fld_usertelNo.setBounds(23, 474, 245, 20);
		contentPane.add(fld_usertelNo);
		
		fld_userPass = new JPasswordField();
		fld_userPass.setFont(new Font("Arial", Font.PLAIN, 11));
		fld_userPass.setBounds(23, 266, 245, 20);
		contentPane.add(fld_userPass);
		
		JLabel lbl_kayitOl = new JLabel("");
		lbl_kayitOl.setIcon(new ImageIcon(RegisterFE.class.getResource("/images/logo.png")));
		lbl_kayitOl.setFont(new Font("Arial Black", Font.BOLD, 20));
		lbl_kayitOl.setBounds(10, 0, 329, 133);
		contentPane.add(lbl_kayitOl);
		
		JButton btn_Geri = new JButton("Geri");
		btn_Geri.setForeground(new Color(128, 0, 0));
		btn_Geri.setBackground(new Color(245, 222, 179));
		btn_Geri.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btn_Geri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFE login = new LoginFE();
				login.setVisible(true);
				dispose();
			}
		});
		btn_Geri.setBounds(23, 515, 116, 36);
		contentPane.add(btn_Geri);
		
		JLabel lblNewLabel = new JLabel("Doğum Tarihi");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblNewLabel.setBounds(23, 347, 116, 21);
		contentPane.add(lblNewLabel);
		
		JDateChooser dc_birthdate = new JDateChooser();
		dc_birthdate.setBounds(23, 371, 245, 20);
		contentPane.add(dc_birthdate);
	}
}
