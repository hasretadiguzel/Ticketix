package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.User;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class UserFE extends JFrame {

	static User user = new User();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFE frame = new UserFE(user);
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
	public UserFE(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 347);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_Cikis = new JButton("ÇIKIŞ");
		btn_Cikis.setForeground(new Color(128, 0, 0));
		btn_Cikis.setBackground(new Color(245, 222, 179));
		btn_Cikis.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btn_Cikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFE login = new LoginFE();
				login.setVisible(true);
				dispose();
			}
		});
		btn_Cikis.setBounds(651, 244, 150, 36);
		contentPane.add(btn_Cikis);
		
		JLabel lbl_uName = new JLabel("Hoş Geldiniz, <dynamic>");
		lbl_uName.setForeground(new Color(128, 0, 0));
		lbl_uName.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lbl_uName.setBounds(10, 10, 321, 36);
		contentPane.add(lbl_uName);
		
		JButton btn_Biletlerim = new JButton("Biletlerim");
		btn_Biletlerim.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btn_Biletlerim.setBackground(new Color(245, 222, 179));
		btn_Biletlerim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TicketsFE bilet = null;
				try {
					bilet = new TicketsFE(user);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				bilet.setVisible(true);
				dispose();
			}
		});
		btn_Biletlerim.setBounds(289, 76, 251, 64);
		contentPane.add(btn_Biletlerim);
		
		JButton btn_SinemaBiletiAl = new JButton("Sinema Bileti Satın Al");
		btn_SinemaBiletiAl.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btn_SinemaBiletiAl.setBackground(new Color(245, 222, 179));
		btn_SinemaBiletiAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CinemaTicketFE sinema = null;
				try {
					sinema = new CinemaTicketFE(user);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sinema.setVisible(true);
				dispose();
			}
		});
		btn_SinemaBiletiAl.setBounds(560, 156, 251, 64);
		contentPane.add(btn_SinemaBiletiAl);
		
		JButton btn_TiyatroBiletiAl = new JButton("Tiyatro Bileti Satın Al");
		btn_TiyatroBiletiAl.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btn_TiyatroBiletiAl.setBackground(new Color(245, 222, 179));
		btn_TiyatroBiletiAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 TheatreTicketFE tiyatro = null;
				 try {
					tiyatro = new TheatreTicketFE(user);
				 } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				 }
				 tiyatro.setVisible(true);
				 dispose();
			}
		});
		btn_TiyatroBiletiAl.setBounds(289, 156, 251, 64);
		contentPane.add(btn_TiyatroBiletiAl);
		
		JButton btn_KonserBiletiAl = new JButton("Konser Bileti Satın Al");
		btn_KonserBiletiAl.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btn_KonserBiletiAl.setBackground(new Color(245, 222, 179));
		btn_KonserBiletiAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConcertTicketFE konser = null;
				try {
					konser = new ConcertTicketFE(user);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				konser.setVisible(true);
				dispose();
			}
		});
		btn_KonserBiletiAl.setBounds(10, 156, 251, 64);
		contentPane.add(btn_KonserBiletiAl);
	}

}
