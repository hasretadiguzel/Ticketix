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

public class TiyatroBiletGUI extends JFrame {
	
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
					TiyatroBiletGUI frame = new TiyatroBiletGUI(user);
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
	public TiyatroBiletGUI(User user) throws SQLException {
		
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
		setBounds(100, 100, 915, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_uName = new JLabel("Ho\u015F Geldiniz, Say\u0131n "+user.getAdi());
		lbl_uName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_uName.setBounds(10, 50, 210, 20);
		contentPane.add(lbl_uName);
		
		JLabel lbl_Secim = new JLabel("Bilet Almak \u0130stedi\u011Finiz Tiyatroyu Se\u00E7iniz:");
		lbl_Secim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_Secim.setBounds(10, 81, 230, 20);
		contentPane.add(lbl_Secim);
		
		JComboBox cb_tiyatroSec = new JComboBox();
		cb_tiyatroSec.setModel(new DefaultComboBoxModel(new String[] {"--Tiyatro Se\u00E7--"}));
		cb_tiyatroSec.setBounds(250, 81, 180, 22);
		for (int i = 0; i < admin.getTiyatroList().size(); i++) {
			cb_tiyatroSec.addItem(new Item(admin.getTiyatroList().get(i).getID(), admin.getTiyatroList().get(i).getTiyatroAdi(), admin.getTiyatroList().get(i).getTarih(),admin.getTiyatroList().get(i).getSaat()));
		}
		contentPane.add(cb_tiyatroSec);
		
		JButton btn_Cikis = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btn_Cikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI login = new LoginGUI();
				login.setVisible(true);
				dispose();
			}
		});
		btn_Cikis.setBounds(779, 11, 95, 23);
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
		w_Panel.setBounds(10, 112, 879, 318);
		contentPane.add(w_Panel);
		w_Panel.setLayout(null);
		w_Panel.setVisible(false);
		
		JLabel lbl_TiyatroAdi = new JLabel("Tiyatro Ad\u0131");
		lbl_TiyatroAdi.setBounds(685, 11, 125, 23);
		w_Panel.add(lbl_TiyatroAdi);
		
		fld_TiyatroAdi = new JTextField();
		fld_TiyatroAdi.setEditable(false);
		fld_TiyatroAdi.setColumns(10);
		fld_TiyatroAdi.setBounds(685, 45, 184, 20);
		w_Panel.add(fld_TiyatroAdi);
		
		JLabel lbl_TiyatroTarih = new JLabel("Tarih");
		lbl_TiyatroTarih.setBounds(685, 76, 125, 23);
		w_Panel.add(lbl_TiyatroTarih);
		
		fld_TiyatroTarih = new JTextField();
		fld_TiyatroTarih.setEditable(false);
		fld_TiyatroTarih.setColumns(10);
		fld_TiyatroTarih.setBounds(685, 110, 184, 20);
		w_Panel.add(fld_TiyatroTarih);
		
		JLabel lbl_TiyatroSaat = new JLabel("Saat");
		lbl_TiyatroSaat.setBounds(685, 141, 125, 23);
		w_Panel.add(lbl_TiyatroSaat);
		
		fld_TiyatroSaat = new JTextField();
		fld_TiyatroSaat.setEditable(false);
		fld_TiyatroSaat.setColumns(10);
		fld_TiyatroSaat.setBounds(685, 175, 184, 20);
		w_Panel.add(fld_TiyatroSaat);
		
		JLabel lbl_TiyatroSalon = new JLabel("Salon");
		lbl_TiyatroSalon.setBounds(685, 206, 125, 23);
		w_Panel.add(lbl_TiyatroSalon);
		
		fld_TiyatroSalonNo = new JTextField();
		fld_TiyatroSalonNo.setEditable(false);
		fld_TiyatroSalonNo.setColumns(10);
		fld_TiyatroSalonNo.setBounds(685, 240, 184, 20);
		w_Panel.add(fld_TiyatroSalonNo);
		
		JButton btn_TiyatroSatinAl = new JButton("Sat\u0131n Al");
		btn_TiyatroSatinAl.setBounds(685, 283, 184, 23);
		w_Panel.add(btn_TiyatroSatinAl);
		
		JPanel w_KoltukPanel = new JPanel();
		w_KoltukPanel.setBounds(10, 11, 665, 295);
		w_Panel.add(w_KoltukPanel);
		w_KoltukPanel.setLayout(null);
		
		JToggleButton btn_Koltuk1 = new JToggleButton("A1");
		btn_Koltuk1.setBackground(Color.GREEN);
		btn_Koltuk1.setBounds(10, 11, 121, 23);
		w_KoltukPanel.add(btn_Koltuk1);
		
		JToggleButton btn_Koltuk2 = new JToggleButton("A2");
		btn_Koltuk2.setBackground(Color.GREEN);
		btn_Koltuk2.setBounds(141, 11, 121, 23);
		w_KoltukPanel.add(btn_Koltuk2);
		
		JToggleButton btn_Koltuk3 = new JToggleButton("A3");
		btn_Koltuk3.setBackground(Color.GREEN);
		btn_Koltuk3.setBounds(272, 11, 121, 23);
		w_KoltukPanel.add(btn_Koltuk3);
		
		JToggleButton btn_Koltuk4 = new JToggleButton("A4");
		btn_Koltuk4.setBackground(Color.GREEN);
		btn_Koltuk4.setBounds(403, 11, 121, 23);
		w_KoltukPanel.add(btn_Koltuk4);
		
		JToggleButton btn_Koltuk5 = new JToggleButton("A5");
		btn_Koltuk5.setBackground(Color.GREEN);
		btn_Koltuk5.setBounds(534, 11, 121, 23);
		w_KoltukPanel.add(btn_Koltuk5);
		
		JToggleButton btn_Koltuk6 = new JToggleButton("B1");
		btn_Koltuk6.setBackground(Color.GREEN);
		btn_Koltuk6.setBounds(10, 120, 121, 23);
		w_KoltukPanel.add(btn_Koltuk6);
		
		JToggleButton btn_Koltuk7 = new JToggleButton("B2");
		btn_Koltuk7.setBackground(Color.GREEN);
		btn_Koltuk7.setBounds(141, 120, 121, 23);
		w_KoltukPanel.add(btn_Koltuk7);
		
		JToggleButton btn_Koltuk8 = new JToggleButton("B3");
		btn_Koltuk8.setBackground(Color.GREEN);
		btn_Koltuk8.setBounds(272, 120, 121, 23);
		w_KoltukPanel.add(btn_Koltuk8);
		
		JToggleButton btn_Koltuk9 = new JToggleButton("B4");
		btn_Koltuk9.setBackground(Color.GREEN);
		btn_Koltuk9.setBounds(403, 120, 121, 23);
		w_KoltukPanel.add(btn_Koltuk9);
		
		JToggleButton btn_Koltuk10 = new JToggleButton("B5");
		btn_Koltuk10.setBackground(Color.GREEN);
		btn_Koltuk10.setBounds(534, 120, 121, 23);
		w_KoltukPanel.add(btn_Koltuk10);
		
		JToggleButton btn_Koltuk11 = new JToggleButton("C1");
		btn_Koltuk11.setBackground(Color.GREEN);
		btn_Koltuk11.setBounds(10, 230, 121, 23);
		w_KoltukPanel.add(btn_Koltuk11);
		
		JToggleButton btn_Koltuk12 = new JToggleButton("C2");
		btn_Koltuk12.setBackground(Color.GREEN);
		btn_Koltuk12.setBounds(141, 230, 121, 23);
		w_KoltukPanel.add(btn_Koltuk12);
		
		JToggleButton btn_Koltuk13 = new JToggleButton("C3");
		btn_Koltuk13.setBackground(Color.GREEN);
		btn_Koltuk13.setBounds(272, 230, 121, 23);
		w_KoltukPanel.add(btn_Koltuk13);
		
		JToggleButton btn_Koltuk14 = new JToggleButton("C4");
		btn_Koltuk14.setBackground(Color.GREEN);
		btn_Koltuk14.setBounds(403, 230, 121, 23);
		w_KoltukPanel.add(btn_Koltuk14);
		
		JToggleButton btn_Koltuk15 = new JToggleButton("C5");
		btn_Koltuk15.setBackground(Color.GREEN);
		btn_Koltuk15.setBounds(534, 230, 121, 23);
		w_KoltukPanel.add(btn_Koltuk15);
		
		JButton btn_turSec = new JButton("Se\u00E7");
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
		btn_turSec.setBounds(440, 81, 89, 23);
		contentPane.add(btn_turSec);
	}
}
