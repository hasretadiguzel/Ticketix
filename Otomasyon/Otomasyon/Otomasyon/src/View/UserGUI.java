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

public class UserGUI extends JFrame {

	static User user = new User();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGUI frame = new UserGUI(user);
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
	public UserGUI(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_Cikis = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btn_Cikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI login = new LoginGUI();
				login.setVisible(true);
				dispose();
			}
		});
		btn_Cikis.setBounds(379, 11, 95, 23);
		contentPane.add(btn_Cikis);
		
		JLabel lbl_uName = new JLabel("Ho\u015F Geldiniz, Say\u0131n "+user.getAdi());
		lbl_uName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_uName.setBounds(10, 50, 210, 20);
		contentPane.add(lbl_uName);
		
		JButton btn_Biletlerim = new JButton("Biletlerim");
		btn_Biletlerim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BiletlerimGUI bilet = null;
				try {
					bilet = new BiletlerimGUI(user);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				bilet.setVisible(true);
				dispose();
			}
		});
		btn_Biletlerim.setBounds(10, 81, 464, 64);
		contentPane.add(btn_Biletlerim);
		
		JButton btn_SinemaBiletiAl = new JButton("Sinema Bileti Al");
		btn_SinemaBiletiAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SinemaBiletGUI sinema = null;
				try {
					sinema = new SinemaBiletGUI(user);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sinema.setVisible(true);
				dispose();
			}
		});
		btn_SinemaBiletiAl.setBounds(10, 156, 464, 64);
		contentPane.add(btn_SinemaBiletiAl);
		
		JButton btn_TiyatroBiletiAl = new JButton("Tiyatro Bileti Al");
		btn_TiyatroBiletiAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 TiyatroBiletGUI tiyatro = null;
				 try {
					tiyatro = new TiyatroBiletGUI(user);
				 } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				 }
				 tiyatro.setVisible(true);
				 dispose();
			}
		});
		btn_TiyatroBiletiAl.setBounds(10, 231, 464, 64);
		contentPane.add(btn_TiyatroBiletiAl);
		
		JButton btn_KonserBiletiAl = new JButton("Konser Bileti Al");
		btn_KonserBiletiAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KonserBiletGUI konser = null;
				try {
					konser = new KonserBiletGUI(user);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				konser.setVisible(true);
				dispose();
			}
		});
		btn_KonserBiletiAl.setBounds(10, 306, 464, 64);
		contentPane.add(btn_KonserBiletiAl);
	}

}
