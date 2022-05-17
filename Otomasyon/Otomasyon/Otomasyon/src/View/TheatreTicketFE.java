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
import Model.TiyatroBilet;
import Model.User;
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

public class TheatreTicketFE extends JFrame {
	
	protected static final User User = null;
	static User user = new User();
	private Admin admin = new Admin();
	static TiyatroBilet TiyatroBilet = new TiyatroBilet();
	private JPanel contentPane;
	private JTextField fld_TiyatroAdi;
	private JTextField fld_TiyatroTarih;
	private JTextField fld_TiyatroSaat;
	private JTextField fld_TiyatroSalonNo;
	
	private DBConnection conn = new DBConnection();
	Connection con = conn.DBCon();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	private JTextField fld_SinemaSaat;
	
	private Object[] TiyatroBiletData = null;
	private DefaultTableModel TiyatroBiletiModel = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TheatreTicketFE frame = new TheatreTicketFE(user);
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
	public TheatreTicketFE(User user) throws SQLException {
		
		TiyatroBiletiModel = new DefaultTableModel();
		Object[] colSinemaBiletName = new Object[6];
		colSinemaBiletName[0] = "ID";
		colSinemaBiletName[1] = "sinemaAdi";
		colSinemaBiletName[2] = "Tarih";
		colSinemaBiletName[3] = "Saat";
		colSinemaBiletName[4] = "Salon";
		colSinemaBiletName[5] = "Koltuk";
		TiyatroBiletiModel.setColumnIdentifiers(colSinemaBiletName);
		TiyatroBiletData = new Object[6];
		for(int i=0;i<TiyatroBilet.getTiyatroBiletList().size();i++) {
			TiyatroBiletData[0] = TiyatroBilet.getTiyatroBiletList().get(i).getID();
			TiyatroBiletData[1] = TiyatroBilet.getTiyatroBiletList().get(i).getTiyatroAdi();
			TiyatroBiletData[2] = TiyatroBilet.getTiyatroBiletList().get(i).getTarih();
			TiyatroBiletData[3] = TiyatroBilet.getTiyatroBiletList().get(i).getSaat();
			TiyatroBiletData[4] = TiyatroBilet.getTiyatroBiletList().get(i).getSalon();
			TiyatroBiletData[5] = TiyatroBilet.getTiyatroBiletList().get(i).getKoltuk();
			TiyatroBiletiModel.addRow(TiyatroBiletData);
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
		
		JComboBox cb_tiyatroSec = new JComboBox();
		cb_tiyatroSec.setFont(new Font("Arial", Font.PLAIN, 11));
		cb_tiyatroSec.setModel(new DefaultComboBoxModel(new String[] {"Tiyatro Seç"}));
		cb_tiyatroSec.setBounds(252, 47, 180, 22);
		for (int i = 0; i < admin.getTiyatroList().size(); i++) {
			cb_tiyatroSec.addItem(new Item(admin.getTiyatroList().get(i).getID(), admin.getTiyatroList().get(i).getTiyatroAdi(), admin.getTiyatroList().get(i).getTarih(),admin.getTiyatroList().get(i).getSaat()));
		}
		contentPane.add(cb_tiyatroSec);
		
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
		
		JLabel lbl_TiyatroAdi = new JLabel("Tiyatro Ad\u0131");
		lbl_TiyatroAdi.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbl_TiyatroAdi.setBounds(465, 11, 125, 23);
		w_Panel.add(lbl_TiyatroAdi);
		
		fld_TiyatroAdi = new JTextField();
		fld_TiyatroAdi.setFont(new Font("Arial", Font.PLAIN, 11));
		fld_TiyatroAdi.setEditable(false);
		fld_TiyatroAdi.setColumns(10);
		fld_TiyatroAdi.setBounds(465, 45, 184, 20);
		w_Panel.add(fld_TiyatroAdi);
		
		JLabel lbl_TiyatroTarih = new JLabel("Tarih");
		lbl_TiyatroTarih.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbl_TiyatroTarih.setBounds(465, 76, 125, 23);
		w_Panel.add(lbl_TiyatroTarih);
		
		fld_TiyatroTarih = new JTextField();
		fld_TiyatroTarih.setFont(new Font("Arial", Font.PLAIN, 11));
		fld_TiyatroTarih.setEditable(false);
		fld_TiyatroTarih.setColumns(10);
		fld_TiyatroTarih.setBounds(465, 110, 184, 20);
		w_Panel.add(fld_TiyatroTarih);
		
		JLabel lbl_TiyatroSaat = new JLabel("Saat");
		lbl_TiyatroSaat.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbl_TiyatroSaat.setBounds(465, 141, 125, 23);
		w_Panel.add(lbl_TiyatroSaat);
		
		fld_TiyatroSaat = new JTextField();
		fld_TiyatroSaat.setFont(new Font("Arial", Font.PLAIN, 11));
		fld_TiyatroSaat.setEditable(false);
		fld_TiyatroSaat.setColumns(10);
		fld_TiyatroSaat.setBounds(465, 175, 184, 20);
		w_Panel.add(fld_TiyatroSaat);
		
		JLabel lbl_TiyatroSalon = new JLabel("Salon");
		lbl_TiyatroSalon.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbl_TiyatroSalon.setBounds(465, 206, 125, 23);
		w_Panel.add(lbl_TiyatroSalon);
		
		fld_TiyatroSalonNo = new JTextField();
		fld_TiyatroSalonNo.setFont(new Font("Arial", Font.PLAIN, 11));
		fld_TiyatroSalonNo.setEditable(false);
		fld_TiyatroSalonNo.setColumns(10);
		fld_TiyatroSalonNo.setBounds(465, 240, 184, 20);
		w_Panel.add(fld_TiyatroSalonNo);
		
		JButton btn_TiyatroSatinAl = new JButton("Sat\u0131n Al");
		btn_TiyatroSatinAl.setBackground(new Color(255, 255, 255));
		btn_TiyatroSatinAl.setFont(new Font("Arial Black", Font.PLAIN, 13));
		btn_TiyatroSatinAl.setForeground(new Color(0, 0, 0));
		btn_TiyatroSatinAl.setBounds(465, 271, 184, 35);
		w_Panel.add(btn_TiyatroSatinAl);
		
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
		btn_Koltuk6.setBounds(265, 71, 75, 23);
		w_KoltukPanel.add(btn_Koltuk6);
		
		JToggleButton btn_Koltuk7 = new JToggleButton("B2");
		btn_Koltuk7.setBackground(Color.YELLOW);
		btn_Koltuk7.setBounds(45, 117, 75, 23);
		w_KoltukPanel.add(btn_Koltuk7);
		
		JToggleButton btn_Koltuk8 = new JToggleButton("B3");
		btn_Koltuk8.setBackground(Color.YELLOW);
		btn_Koltuk8.setBounds(130, 117, 75, 23);
		w_KoltukPanel.add(btn_Koltuk8);
		
		JToggleButton btn_Koltuk9 = new JToggleButton("B4");
		btn_Koltuk9.setBackground(Color.YELLOW);
		btn_Koltuk9.setBounds(215, 117, 75, 23);
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
		
		JButton btn_turSec = new JButton("Se\u00E7");
		btn_turSec.setFont(new Font("Arial Black", Font.PLAIN, 13));
		btn_turSec.setForeground(new Color(128, 0, 0));
		btn_turSec.setBackground(new Color(245, 222, 179));
		btn_turSec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				w_Panel.setVisible(true);
				String tiyatro = cb_tiyatroSec.getSelectedItem().toString();
				if(cb_tiyatroSec.getSelectedIndex()==0) {
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
						String query = "SELECT * FROM tiyatro WHERE tiyatro_adi=?";
						preparedStatement = con.prepareStatement(query);
						preparedStatement.setString(1, tiyatro);
						ResultSet rs = preparedStatement.executeQuery();						
						while(rs.next()) {
							fld_TiyatroAdi.setText(rs.getString("tiyatro_adi"));
							fld_TiyatroTarih.setText(rs.getString("tarih"));
							fld_TiyatroSaat.setText(rs.getString("saat"));
							fld_TiyatroSalonNo.setText(rs.getString("salon"));
						}
						preparedStatement.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		btn_turSec.setBounds(442, 47, 89, 23);
		contentPane.add(btn_turSec);
	}
}
