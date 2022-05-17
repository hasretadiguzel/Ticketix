package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Helper.Helper;
import Helper.Item;
import Model.Admin;
import Model.User;

import java.sql.*;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSpinner;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AdminGUI extends JFrame {

	static Admin admin = new Admin();
	private JPanel contentPane;
	private JTable table_uList;
	private DefaultTableModel userModel = null;
	private Object[] userData = null;
	private DefaultTableModel adminModel = null;
	private Object[] adminData = null;
	private DefaultTableModel sinemaModel = null;
	private Object[] sinemaData = null;
	private DefaultTableModel tiyatroModel = null;
	private Object[] tiyatroData = null;
	private DefaultTableModel konserModel = null;
	private Object[] konserData = null;
	private JTable table_sList;
	private JTable table_tList;
	private JTable table_kList;
	private JTextField fld_userKullaniciAdi;
	private JTextField fld_sinemaAdi;
	private JTextField fld_tiyatroAdi;
	private JTextField fld_konserAdi;
	private JTextField fld_userID;
	private JPasswordField fld_userPass;
	private JTextField fld_aAdi;
	private JPasswordField fld_aPass;
	private JTable table_aList;
	private JTextField fld_sinemaID;
	private JTextField fld_tiyatroID;
	private JTextField fld_konserID;
	private JTextField fld_adminID;
	private JTextField fld_userAdi;
	private JTextField fld_userSoyadi;
	private JTextField fld_usermailAdresi;
	private JTextField fld_usertelNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGUI frame = new AdminGUI(admin);
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
	public AdminGUI(Admin admin) throws SQLException {
		
		//ADMÝN TABLE
		adminModel = new DefaultTableModel();
		Object[] colAdminName = new Object[3];
		colAdminName[0] = "ID";
		colAdminName[1] = "kAdi";
		colAdminName[2] = "Sifre";		
		adminModel.setColumnIdentifiers(colAdminName);
		adminData = new Object[3];
		for(int i=0;i<admin.getAdminList().size();i++) {
			adminData[0] = admin.getAdminList().get(i).getID();
			adminData[1] = admin.getAdminList().get(i).getkAdi();
			adminData[2] = admin.getAdminList().get(i).getSifre();
			adminModel.addRow(adminData);
		}
		
		//USER TABLE
		userModel = new DefaultTableModel();
		Object[] colUserName = new Object[7];
		colUserName[0] = "ID";
		colUserName[1] = "Adi";
		colUserName[2] = "Soyadi";
		colUserName[3] = "kAdi";
		colUserName[4] = "Sifre";
		colUserName[5] = "mailAdresi";
		colUserName[6] = "telNo";		
		userModel.setColumnIdentifiers(colUserName);
		userData = new Object[7];
		for(int i=0;i<admin.getUserList().size();i++) {
			userData[0] = admin.getUserList().get(i).getID();
			userData[1] = admin.getUserList().get(i).getAdi();
			userData[2] = admin.getUserList().get(i).getSoyadi();
			userData[3] = admin.getUserList().get(i).getkAdi();
			userData[4] = admin.getUserList().get(i).getSifre();
			userData[5] = admin.getUserList().get(i).getMailAdresi();
			userData[6] = admin.getUserList().get(i).getTelNo();
			userModel.addRow(userData);
		}
		
		//SÝNEMA TABLE
		sinemaModel = new DefaultTableModel();
		Object[] colSinemaName = new Object[5];
		colSinemaName[0] = "ID";
		colSinemaName[1] = "sinemaAdi";
		colSinemaName[2] = "Tarih";	
		colSinemaName[3] = "Saat";	
		colSinemaName[4] = "Salon";
		sinemaModel.setColumnIdentifiers(colSinemaName);
		sinemaData = new Object[5];
		for(int i=0;i<admin.getSinemaList().size();i++) {
			sinemaData[0] = admin.getSinemaList().get(i).getID();
			sinemaData[1] = admin.getSinemaList().get(i).getSinemaAdi();
			sinemaData[2] = admin.getSinemaList().get(i).getTarih();
			sinemaData[3] = admin.getSinemaList().get(i).getSaat();
			sinemaData[4] = admin.getSinemaList().get(i).getSalon();
			sinemaModel.addRow(sinemaData);
		}
		
		//TÝYATRO TABLE
		tiyatroModel = new DefaultTableModel();
		Object[] colTiyatroName = new Object[5];
		colTiyatroName[0] = "ID";
		colTiyatroName[1] = "tiyatroAdi";
		colTiyatroName[2] = "Tarih";
		colTiyatroName[3] = "Saat";
		colTiyatroName[4] = "Salon";
		tiyatroModel.setColumnIdentifiers(colTiyatroName);
		tiyatroData = new Object[5];
		for(int i=0;i<admin.getTiyatroList().size();i++) {
			tiyatroData[0] = admin.getTiyatroList().get(i).getID();
			tiyatroData[1] = admin.getTiyatroList().get(i).getTiyatroAdi();
			tiyatroData[2] = admin.getTiyatroList().get(i).getTarih();
			tiyatroData[3] = admin.getTiyatroList().get(i).getSaat();
			tiyatroData[4] = admin.getTiyatroList().get(i).getSalon();
			tiyatroModel.addRow(tiyatroData);
		}
		
		//KONSER TABLE
		konserModel = new DefaultTableModel();
		Object[] colKonserName = new Object[5];
		colKonserName[0] = "ID";
		colKonserName[1] = "konserAdi";
		colKonserName[2] = "Tarih";
		colKonserName[3] = "Saat";
		colKonserName[4] = "Salon";
		konserModel.setColumnIdentifiers(colKonserName);
		konserData = new Object[5];
		for(int i=0;i<admin.getKonserList().size();i++) {
			konserData[0] = admin.getKonserList().get(i).getID();
			konserData[1] = admin.getKonserList().get(i).getKonserAdi();
			konserData[2] = admin.getKonserList().get(i).getTarih();
			konserData[3] = admin.getKonserList().get(i).getSaat();
			konserData[4] = admin.getKonserList().get(i).getSalon();
			konserModel.addRow(konserData);
		}
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_aName = new JLabel("Ho\u015F Geldiniz, Say\u0131n "+admin.getkAdi());
		lbl_aName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_aName.setBounds(10, 11, 210, 20);
		contentPane.add(lbl_aName);
		
		JButton btn_Cikis = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btn_Cikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI login = new LoginGUI();
				login.setVisible(true);
				dispose();
			}
		});
		btn_Cikis.setBounds(879, 12, 95, 23);
		contentPane.add(btn_Cikis);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 74, 964, 526);
		contentPane.add(tabbedPane);
		
		JPanel user_panel = new JPanel();
		tabbedPane.addTab("Kullanýcý Yönetim Paneli", null, user_panel, null);
		user_panel.setLayout(null);
		
		JScrollPane w_KullaniciscrollPane = new JScrollPane();
		w_KullaniciscrollPane.setBounds(10, 11, 755, 476);
		user_panel.add(w_KullaniciscrollPane);
		
		table_uList = new JTable(userModel);
		w_KullaniciscrollPane.setViewportView(table_uList);
		table_uList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				try {
					fld_userID.setText(table_uList.getValueAt(table_uList.getSelectedRow(),0).toString());
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		
		table_uList.getModel().addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
					int selectID = Integer.parseInt(table_uList.getValueAt(table_uList.getSelectedRow(),0).toString());
					String selectAdi = table_uList.getValueAt(table_uList.getSelectedRow(),1).toString();
					String selectSoyadi = table_uList.getValueAt(table_uList.getSelectedRow(),2).toString();
					String selectkAdi = table_uList.getValueAt(table_uList.getSelectedRow(),3).toString();
					String selectSifre = table_uList.getValueAt(table_uList.getSelectedRow(),4).toString();
					String selectmailAdresi = table_uList.getValueAt(table_uList.getSelectedRow(),5).toString();
					String selecttelNo = table_uList.getValueAt(table_uList.getSelectedRow(),6).toString();
					
					try {
						boolean control = admin.updateUser(selectID, selectAdi, selectSoyadi, selectkAdi, selectSifre, selectmailAdresi, selecttelNo);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		
		
		fld_userKullaniciAdi = new JTextField();
		fld_userKullaniciAdi.setBounds(775, 149, 174, 20);
		user_panel.add(fld_userKullaniciAdi);
		fld_userKullaniciAdi.setColumns(10);
		
		JLabel lbl_kAdi = new JLabel("Kullan\u0131c\u0131 Ad\u0131:");
		lbl_kAdi.setBounds(775, 124, 115, 14);
		user_panel.add(lbl_kAdi);
		
		JLabel lbl_kPass = new JLabel("\u015Eifre:");
		lbl_kPass.setBounds(775, 180, 115, 14);
		user_panel.add(lbl_kPass);
		
		fld_userID = new JTextField();
		fld_userID.setBounds(775, 433, 174, 20);
		user_panel.add(fld_userID);
		fld_userID.setColumns(10);
		
		JButton btn_userKaldir = new JButton("Kald\u0131r");
		btn_userKaldir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_userID.getText().length()==0) {
					Helper.showMsg("Lütfen geçerli alan seçiniz");
				}
				else {
					if (Helper.confirm("evet")) {
						int selectID = Integer.parseInt(fld_userID.getText());
						try {
							boolean control = admin.deleteUser(selectID);
							if (control) {
								Helper.showMsg("success");
								fld_userID.setText(null);
								updateUserModel();
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
					
				}
			}
		});
		btn_userKaldir.setBounds(775, 464, 174, 23);
		user_panel.add(btn_userKaldir);
		
		fld_userPass = new JPasswordField();
		fld_userPass.setBounds(775, 205, 174, 20);
		user_panel.add(fld_userPass);
		
		JLabel lbl_kID = new JLabel("Kullan\u0131c\u0131 ID:");
		lbl_kID.setBounds(775, 408, 174, 14);
		user_panel.add(lbl_kID);
		
		JLabel lbl_Adi = new JLabel("Ad\u0131:");
		lbl_Adi.setBounds(775, 12, 174, 14);
		user_panel.add(lbl_Adi);
		
		fld_userAdi = new JTextField();
		fld_userAdi.setBounds(775, 37, 174, 20);
		user_panel.add(fld_userAdi);
		fld_userAdi.setColumns(10);
		
		JLabel lbl_Soyadi = new JLabel("Soyad\u0131:");
		lbl_Soyadi.setBounds(775, 68, 174, 14);
		user_panel.add(lbl_Soyadi);
		
		fld_userSoyadi = new JTextField();
		fld_userSoyadi.setBounds(775, 93, 174, 20);
		user_panel.add(fld_userSoyadi);
		fld_userSoyadi.setColumns(10);
		
		JLabel lbl_mailAdresi = new JLabel("Mail Adresi:");
		lbl_mailAdresi.setBounds(775, 236, 174, 14);
		user_panel.add(lbl_mailAdresi);
		
		fld_usermailAdresi = new JTextField();
		fld_usermailAdresi.setBounds(775, 261, 174, 20);
		user_panel.add(fld_usermailAdresi);
		fld_usermailAdresi.setColumns(10);
		
		JLabel lbl_telNo = new JLabel("Tel No:");
		lbl_telNo.setBounds(775, 292, 174, 14);
		user_panel.add(lbl_telNo);
		
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
		fld_usertelNo.setBounds(775, 317, 174, 20);
		user_panel.add(fld_usertelNo);
		fld_usertelNo.setColumns(10);
		
		JButton btn_kullaniciEkle = new JButton("Kullan\u0131c\u0131 Ekle");
		btn_kullaniciEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (fld_userAdi.getText().length()==0||fld_userSoyadi.getText().length()==0||fld_userKullaniciAdi.getText().length()==0||fld_userPass.getText().length()==0||fld_usermailAdresi.getText().length()==0||fld_usertelNo.getText().length()!=11) {
					Helper.showMsg("fill");
				}
				else {
					try {
						boolean control = admin.addUser(fld_userAdi.getText(), fld_userSoyadi.getText(), fld_userKullaniciAdi.getText(), fld_userPass.getText(), fld_usermailAdresi.getText(), fld_usertelNo.getText());
						if (control) {
							Helper.showMsg("success");
							fld_userAdi.setText(null);
							fld_userSoyadi.setText(null);
							fld_userKullaniciAdi.setText(null);
							fld_userPass.setText(null);
							fld_usermailAdresi.setText(null);
							fld_usertelNo.setText(null);
							updateUserModel();
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
		btn_kullaniciEkle.setBounds(775, 348, 174, 23);
		user_panel.add(btn_kullaniciEkle);
		
		JPanel admin_panel = new JPanel();
		tabbedPane.addTab("Admin Yönetici Paneli", null, admin_panel, null);
		admin_panel.setLayout(null);
		
		JScrollPane w_AdminscrollPane = new JScrollPane();
		w_AdminscrollPane.setBounds(10, 11, 755, 476);
		admin_panel.add(w_AdminscrollPane);
		
		table_aList = new JTable(adminModel);
		w_AdminscrollPane.setViewportView(table_aList);
		table_aList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				try {
					fld_adminID.setText(table_aList.getValueAt(table_aList.getSelectedRow(),0).toString());
				} 
				catch (Exception e2) {
					// TODO: handle exception
				}				
			}
		});
		
		table_aList.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
					int selectID = Integer.parseInt(table_aList.getValueAt(table_aList.getSelectedRow(),0).toString());
					String selectkAdi = table_aList.getValueAt(table_aList.getSelectedRow(),1).toString();
					String selectSifre = table_aList.getValueAt(table_aList.getSelectedRow(),2).toString();
				
					try {
						boolean control = admin.updateAdmin(selectID, selectkAdi, selectSifre);
					} catch (Exception e2) {
						e2.getStackTrace();
					}
				}
			}
		});
		
		JLabel lbl_kAdi_1 = new JLabel("Kullan\u0131c\u0131 Ad\u0131:");
		lbl_kAdi_1.setBounds(775, 11, 115, 14);
		admin_panel.add(lbl_kAdi_1);
		
		fld_aAdi = new JTextField();
		fld_aAdi.setColumns(10);
		fld_aAdi.setBounds(775, 36, 174, 20);
		admin_panel.add(fld_aAdi);
		
		JLabel lbl_kPass_1 = new JLabel("\u015Eifre:");
		lbl_kPass_1.setBounds(775, 61, 115, 14);
		admin_panel.add(lbl_kPass_1);
		
		fld_aPass = new JPasswordField();
		fld_aPass.setBounds(775, 86, 174, 20);
		admin_panel.add(fld_aPass);
		
		JButton btn_adminEkle = new JButton("Admin Ekle");
		btn_adminEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (fld_aAdi.getText().length()==0||fld_aPass.getText().length()==0) {
					Helper.showMsg("fill");
				}
				else {
					try {
						boolean control = admin.addAdmin(fld_aAdi.getText(), fld_aPass.getText());
						if (control) {
							Helper.showMsg("success");
							fld_aAdi.setText(null);
							fld_aPass.setText(null);
							updateAdminModel();
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
		btn_adminEkle.setBounds(775, 117, 174, 23);
		admin_panel.add(btn_adminEkle);
		
		fld_adminID = new JTextField();
		fld_adminID.setColumns(10);
		fld_adminID.setBounds(775, 433, 174, 20);
		admin_panel.add(fld_adminID);
		
		JButton btn_adminKaldir = new JButton("Kald\u0131r");
		btn_adminKaldir.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				if (fld_adminID.getText().length()==0) {
					Helper.showMsg("Lütfen geçerli alan seçiniz");
				}
				else {
					if (Helper.confirm("evet")) {
						int selectID = Integer.parseInt(fld_adminID.getText());
						try {
							boolean control = admin.deleteAdmin(selectID);
							if (control) {
								Helper.showMsg("success");
								fld_adminID.setText(null);
								updateAdminModel();
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
					
				}
			}
		});
		btn_adminKaldir.setBounds(775, 464, 174, 23);
		admin_panel.add(btn_adminKaldir);
		
		JLabel lbl_aKaldir = new JLabel("Admin ID:");
		lbl_aKaldir.setBounds(775, 408, 174, 14);
		admin_panel.add(lbl_aKaldir);
		
		JPanel sinema_panel = new JPanel();
		tabbedPane.addTab("Sinema Yönetim Paneli", null, sinema_panel, null);
		sinema_panel.setLayout(null);
		
		JScrollPane w_SinemascrollPane = new JScrollPane();
		w_SinemascrollPane.setBounds(10, 11, 755, 476);
		sinema_panel.add(w_SinemascrollPane);
		
		table_sList = new JTable(sinemaModel);
		w_SinemascrollPane.setViewportView(table_sList);
		table_sList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				try {
					fld_sinemaID.setText(table_sList.getValueAt(table_sList.getSelectedRow(),0).toString());
				} 
				catch (Exception e2) {
					// TODO: handle exception
				}				
			}
		});
		
		table_sList.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
					int selectID = Integer.parseInt(table_sList.getValueAt(table_sList.getSelectedRow(),0).toString());
					String selectsinemaAdi = table_sList.getValueAt(table_sList.getSelectedRow(),1).toString();
					String selectTarih = table_sList.getValueAt(table_sList.getSelectedRow(),2).toString();
					String selectSaat = table_sList.getValueAt(table_sList.getSelectedRow(),3).toString();
					String selectSalon = table_sList.getValueAt(table_sList.getSelectedRow(),4).toString();
				
					try {
						boolean control = admin.updateSinema(selectID, selectsinemaAdi, selectTarih, selectSaat, selectSalon);
					} catch (Exception e2) {
						e2.getStackTrace();
					}
				}
			}
		});
		
		JLabel lbl_sinema = new JLabel("Film Ad\u0131:");
		lbl_sinema.setBounds(775, 11, 115, 14);
		sinema_panel.add(lbl_sinema);
		
		fld_sinemaAdi = new JTextField();
		fld_sinemaAdi.setColumns(10);
		fld_sinemaAdi.setBounds(775, 36, 174, 20);
		sinema_panel.add(fld_sinemaAdi);
				
		JDateChooser dc_sinemaTarih = new JDateChooser();
		dc_sinemaTarih.setBounds(775, 92, 174, 20);
		sinema_panel.add(dc_sinemaTarih);
		
		JComboBox sinemaSaatCombo = new JComboBox();
		sinemaSaatCombo.setModel(new DefaultComboBoxModel(new String[] {"Saat Se\u00E7", "10.00", "10.30", "11.00", "11.30", "12.00", "12.30", "13.00", "13.30", "14.00", "14.30", "15.00", "15.30", "16.00", "16.30", "17.00", "17.30", "18.00", "18.30", "19.00", "19.30", "20.00", "20.30", "21.00", "21.30", "22.00", "22.30", "23.00"}));
		sinemaSaatCombo.setBounds(775, 148, 174, 22);
		sinema_panel.add(sinemaSaatCombo);
		
		JComboBox SinemaSalonCombo = new JComboBox();
		SinemaSalonCombo.setModel(new DefaultComboBoxModel(new String[] {"Salon Se\u00E7", "1", "2", "3", "4", "5"}));
		SinemaSalonCombo.setBounds(775, 202, 174, 22);
		sinema_panel.add(SinemaSalonCombo);		
		
		JButton btn_sinemaEkle = new JButton("Sinema Ekle");
		btn_sinemaEkle.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = "";
				String time = sinemaSaatCombo.getSelectedItem().toString();
				String sinemaSalon = SinemaSalonCombo.getSelectedItem().toString();
				try {
					date = sdf.format(dc_sinemaTarih.getDate());
				} catch (Exception e2) {
					// TODO: handle exception
				}
				if(sinemaSaatCombo.getSelectedIndex()!=0 && SinemaSalonCombo.getSelectedIndex()!=0) {
					if (fld_sinemaAdi.getText().length()==0 || date.length()==0 || time.length()==0 || sinemaSalon.length()==0) {
					Helper.showMsg("date");
					}
					else {
						boolean control;
						try {
							control = admin.addSinema(fld_sinemaAdi.getText(), dc_sinemaTarih.getDate().toString(), time, sinemaSalon);
							if (control) {
								Helper.showMsg("success");
								updateSinemaModel();
							}
							else {
								Helper.showMsg("fill");
							}
						} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						}
					}
				}
				else {
					Helper.showMsg("date");
				}
								
			}
		});
		btn_sinemaEkle.setBounds(775, 235, 174, 23);
		sinema_panel.add(btn_sinemaEkle);
		
		fld_sinemaID = new JTextField();
		fld_sinemaID.setColumns(10);
		fld_sinemaID.setBounds(775, 433, 174, 20);
		sinema_panel.add(fld_sinemaID);
		
		JButton btn_sinemaKaldir = new JButton("Kald\u0131r");
		btn_sinemaKaldir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_sinemaID.getText().length()==0) {
					Helper.showMsg("Lütfen geçerli alan seçiniz");
				}
				else {
					if (Helper.confirm("evet")) {
						int selectID = Integer.parseInt(fld_sinemaID.getText());
						try {
							boolean control = admin.deleteSinema(selectID);
							if (control) {
								Helper.showMsg("success");
								fld_sinemaID.setText(null);
								updateSinemaModel();
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
					
				}
				
			}
		});
		btn_sinemaKaldir.setBounds(775, 464, 174, 23);
		sinema_panel.add(btn_sinemaKaldir);
		
		JLabel lbl_sKaldir = new JLabel("Sinema ID:");
		lbl_sKaldir.setBounds(775, 408, 174, 14);
		sinema_panel.add(lbl_sKaldir);
		
		JLabel lbl_sTarih = new JLabel("Tarih:");
		lbl_sTarih.setBounds(775, 67, 174, 14);
		sinema_panel.add(lbl_sTarih);
		
		JLabel lbl_sSaat = new JLabel("Saat:");
		lbl_sSaat.setBounds(775, 123, 174, 14);
		sinema_panel.add(lbl_sSaat);
		
		JLabel lbl_SinemaSalonNo = new JLabel("Salon Numaras\u0131:");
		lbl_SinemaSalonNo.setBounds(775, 181, 174, 14);
		sinema_panel.add(lbl_SinemaSalonNo);
		
		JPanel tiyatro_panel = new JPanel();
		tabbedPane.addTab("Tiyatro Yönetim Paneli", null, tiyatro_panel, null);
		tiyatro_panel.setLayout(null);
		
		JScrollPane w_tiyatroscrollPane = new JScrollPane();
		w_tiyatroscrollPane.setBounds(10, 11, 755, 476);
		tiyatro_panel.add(w_tiyatroscrollPane);
		
		table_tList = new JTable(tiyatroModel);
		w_tiyatroscrollPane.setViewportView(table_tList);
		table_tList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				try {
					fld_tiyatroID.setText(table_tList.getValueAt(table_tList.getSelectedRow(),0).toString());
				} 
				catch (Exception e2) {
					// TODO: handle exception
				}				
			}
		});
		
		table_tList.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
					int selectID = Integer.parseInt(table_tList.getValueAt(table_tList.getSelectedRow(),0).toString());
					String selecttiyatroAdi = table_tList.getValueAt(table_tList.getSelectedRow(),1).toString();
					String selectTarih = table_tList.getValueAt(table_tList.getSelectedRow(),2).toString();
					String selectSaat = table_tList.getValueAt(table_tList.getSelectedRow(),3).toString();
					String selectSalon = table_tList.getValueAt(table_tList.getSelectedRow(),4).toString();
				
					try {
						boolean control = admin.updateTiyatro(selectID, selecttiyatroAdi, selectTarih, selectSaat, selectSalon);
					} catch (Exception e2) {
						e2.getStackTrace();
					}
				}
			}
		});
		
		JLabel lbl_tiyatroAdi = new JLabel("Tiyatro Ad\u0131:");
		lbl_tiyatroAdi.setBounds(775, 11, 115, 14);
		tiyatro_panel.add(lbl_tiyatroAdi);
		
		fld_tiyatroAdi = new JTextField();
		fld_tiyatroAdi.setColumns(10);
		fld_tiyatroAdi.setBounds(775, 36, 174, 20);
		tiyatro_panel.add(fld_tiyatroAdi);
		
		JDateChooser dc_tiyatroTarih = new JDateChooser();
		dc_tiyatroTarih.setBounds(775, 92, 174, 20);
		tiyatro_panel.add(dc_tiyatroTarih);
		
		JComboBox tiyatroSaatCombo = new JComboBox();
		tiyatroSaatCombo.setModel(new DefaultComboBoxModel(new String[] {"Saat Se\u00E7", "10.00", "10.30", "11.00", "11.30", "12.00", "12.30", "13.00", "13.30", "14.00", "14.30", "15.00", "15.30", "16.00", "16.30", "17.00", "17.30", "18.00", "18.30", "19.00", "19.30", "20.00", "20.30", "21.00", "21.30", "22.00", "22.30", "23.00"}));
		tiyatroSaatCombo.setBounds(775, 148, 174, 22);
		tiyatro_panel.add(tiyatroSaatCombo);
		
		JComboBox TiyatroSalonCombo = new JComboBox();
		TiyatroSalonCombo.setModel(new DefaultComboBoxModel(new String[] {"Salon Se\u00E7", "1", "2", "3", "4", "5"}));
		TiyatroSalonCombo.setBounds(775, 202, 174, 22);
		tiyatro_panel.add(TiyatroSalonCombo);
		
		JButton btn_tiyatroEkle = new JButton("Tiyatro Ekle");
		btn_tiyatroEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = "";
				String time = tiyatroSaatCombo.getSelectedItem().toString();
				String tiyatroSalon = TiyatroSalonCombo.getSelectedItem().toString();
				try {
					date = sdf.format(dc_tiyatroTarih.getDate());
				} catch (Exception e2) {
					// TODO: handle exception
				}

				if (tiyatroSaatCombo.getSelectedIndex()!=0 && TiyatroSalonCombo.getSelectedIndex()!=0) {
					if (fld_tiyatroAdi.getText().length()==0 || date.length()==0 || time.length()==0 || tiyatroSalon.length()==0) {
						Helper.showMsg("date");
					}
					else {
						boolean control;
						try {
							control = admin.addTiyatro(fld_tiyatroAdi.getText(), dc_tiyatroTarih.getDate().toString(), time, tiyatroSalon);
							if (control) {
								Helper.showMsg("success");
								updateTiyatroModel();
							}
							else {
								Helper.showMsg("fill");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} 
				else {
					Helper.showMsg("date");
				}
				
				
			}			
		});
		btn_tiyatroEkle.setBounds(775, 235, 174, 23);
		tiyatro_panel.add(btn_tiyatroEkle);
		
		fld_tiyatroID = new JTextField();
		fld_tiyatroID.setColumns(10);
		fld_tiyatroID.setBounds(775, 433, 174, 20);
		tiyatro_panel.add(fld_tiyatroID);
		
		JLabel lbl_tTarih = new JLabel("Tarih:");
		lbl_tTarih.setBounds(775, 67, 174, 14);
		tiyatro_panel.add(lbl_tTarih);
		
		JLabel lbl_tSaat = new JLabel("Saat:");
		lbl_tSaat.setBounds(775, 123, 174, 14);
		tiyatro_panel.add(lbl_tSaat);
		
		JLabel lbl_TiyatroSalonNo = new JLabel("Salon Numaras\u0131:");
		lbl_TiyatroSalonNo.setBounds(775, 181, 174, 14);
		tiyatro_panel.add(lbl_TiyatroSalonNo);
		
		JButton btn_tiyatroKaldir = new JButton("Kald\u0131r");
		btn_tiyatroKaldir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_tiyatroID.getText().length()==0) {
					Helper.showMsg("Lütfen geçerli alan seçiniz");
				}
				else {
					if (Helper.confirm("evet")) {
						int selectID = Integer.parseInt(fld_tiyatroID.getText());
						try {
							boolean control = admin.deleteTiyatro(selectID);
							if (control) {
								Helper.showMsg("success");
								fld_tiyatroID.setText(null);
								updateTiyatroModel();
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
					
				}
			}
		});
		btn_tiyatroKaldir.setBounds(775, 464, 174, 23);
		tiyatro_panel.add(btn_tiyatroKaldir);
		
		JLabel lbl_tKaldir = new JLabel("Tiyatro ID:");
		lbl_tKaldir.setBounds(775, 408, 174, 14);
		tiyatro_panel.add(lbl_tKaldir);
		
		JPanel konser_panel = new JPanel();
		tabbedPane.addTab("Konser Yönetim Paneli", null, konser_panel, null);
		konser_panel.setLayout(null);
		
		JScrollPane w_KonserscrollPane = new JScrollPane();
		w_KonserscrollPane.setBounds(10, 10, 755, 477);
		konser_panel.add(w_KonserscrollPane);
		
		table_kList = new JTable(konserModel);
		w_KonserscrollPane.setViewportView(table_kList);
		table_kList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				try {
					fld_konserID.setText(table_kList.getValueAt(table_kList.getSelectedRow(),0).toString());
				} 
				catch (Exception e2) {
					// TODO: handle exception
				}				
			}
		});
		
		table_kList.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
					int selectID = Integer.parseInt(table_kList.getValueAt(table_kList.getSelectedRow(),0).toString());
					String selectkonserAdi = table_kList.getValueAt(table_kList.getSelectedRow(),1).toString();
					String selectTarih = table_kList.getValueAt(table_kList.getSelectedRow(),2).toString();
					String selectSaat = table_kList.getValueAt(table_kList.getSelectedRow(),3).toString();
					String selectSalon = table_kList.getValueAt(table_kList.getSelectedRow(),4).toString();
				
					try {
						boolean control = admin.updateKonser(selectID, selectkonserAdi, selectTarih, selectSaat, selectSalon);
					} catch (Exception e2) {
						e2.getStackTrace();
					}
				}
			}
		});
		
		JLabel lbl_konserAdi = new JLabel("Konser Ad\u0131:");
		lbl_konserAdi.setBounds(775, 11, 115, 14);
		konser_panel.add(lbl_konserAdi);
		
		fld_konserAdi = new JTextField();
		fld_konserAdi.setColumns(10);
		fld_konserAdi.setBounds(775, 36, 174, 20);
		konser_panel.add(fld_konserAdi);
		
		JDateChooser dc_konserTarih = new JDateChooser();
		dc_konserTarih.setBounds(775, 92, 174, 20);
		konser_panel.add(dc_konserTarih);
		
		JComboBox konserSaatCombo = new JComboBox();
		konserSaatCombo.setModel(new DefaultComboBoxModel(new String[] {"Saat Se\u00E7", "10.00", "10.30", "11.00", "11.30", "12.00", "12.30", "13.00", "13.30", "14.00", "14.30", "15.00", "15.30", "16.00", "16.30", "17.00", "17.30", "18.00", "18.30", "19.00", "19.30", "20.00", "20.30", "21.00", "21.30", "22.00", "22.30", "23.00"}));
		konserSaatCombo.setBounds(775, 148, 174, 22);
		konser_panel.add(konserSaatCombo);
		
		JComboBox KonserSalonCombo = new JComboBox();
		KonserSalonCombo.setModel(new DefaultComboBoxModel(new String[] {"Salon Se\u00E7", "1", "2", "3", "4", "5"}));
		KonserSalonCombo.setBounds(775, 202, 174, 22);
		konser_panel.add(KonserSalonCombo);
		
		JButton btn_konserEkle = new JButton("Konser Ekle");
		btn_konserEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = "";
				String time = konserSaatCombo.getSelectedItem().toString();
				String KonserSalon = KonserSalonCombo.getSelectedItem().toString();
				try {
					date = sdf.format(dc_konserTarih.getDate());
				} catch (Exception e2) {
					// TODO: handle exception
				}
				if(konserSaatCombo.getSelectedIndex()!=0 && KonserSalonCombo.getSelectedIndex()!=0) {
					if (fld_konserAdi.getText().length()==0 || date.length()==0 || time.length()==0 || KonserSalon.length()==0) {
						Helper.showMsg("date");
					}
					else {
						boolean control;
						try {
							control = admin.addKonser(fld_konserAdi.getText(), dc_konserTarih.getDate().toString(), time, KonserSalon);
							if (control) {
								Helper.showMsg("success");
								updateKonserModel();
							}
							else {
								Helper.showMsg("fill");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				else {
					Helper.showMsg("date");
				}
			}
		});
		btn_konserEkle.setBounds(775, 235, 174, 23);
		konser_panel.add(btn_konserEkle);
		
		fld_konserID = new JTextField();
		fld_konserID.setColumns(10);
		fld_konserID.setBounds(775, 433, 174, 20);
		konser_panel.add(fld_konserID);
		
		JButton btn_konserKaldir = new JButton("Kald\u0131r");
		btn_konserKaldir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_konserID.getText().length()==0) {
					Helper.showMsg("Lütfen geçerli alan seçiniz");
				}
				else {
					if (Helper.confirm("evet")) {
						int selectID = Integer.parseInt(fld_konserID.getText());
						try {
							boolean control = admin.deleteKonser(selectID);
							if (control) {
								Helper.showMsg("success");
								fld_konserID.setText(null);
								updateKonserModel();
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
					
				}
			}
		});
		btn_konserKaldir.setBounds(775, 464, 174, 23);
		konser_panel.add(btn_konserKaldir);
		
		JLabel lbl_kKaldir = new JLabel("Konser ID:");
		lbl_kKaldir.setBounds(775, 408, 174, 14);
		konser_panel.add(lbl_kKaldir); 
		
		JLabel lbl_kTarih = new JLabel("Tarih:");
		lbl_kTarih.setBounds(775, 67, 174, 14);
		konser_panel.add(lbl_kTarih);
		
		JLabel lbl_kSaat = new JLabel("Saat:");
		lbl_kSaat.setBounds(775, 123, 174, 14);
		konser_panel.add(lbl_kSaat);
		
		JLabel lbl_KonserSalonNo = new JLabel("Salon Numaras\u0131:");
		lbl_KonserSalonNo.setBounds(775, 181, 174, 14);
		konser_panel.add(lbl_KonserSalonNo);
		
	}
	
	public void updateUserModel() throws SQLException {
		
		DefaultTableModel updateUserModel = (DefaultTableModel) table_uList.getModel();
		updateUserModel.setRowCount(0);
		for(int i=0;i<admin.getUserList().size();i++) {
			userData[0] = admin.getUserList().get(i).getID();
			userData[1] = admin.getUserList().get(i).getAdi();
			userData[2] = admin.getUserList().get(i).getSoyadi();
			userData[3] = admin.getUserList().get(i).getkAdi();
			userData[4] = admin.getUserList().get(i).getSifre();
			userData[5] = admin.getUserList().get(i).getMailAdresi();
			userData[6] = admin.getUserList().get(i).getTelNo();
			userModel.addRow(userData);
		}
	}
	
	public void updateAdminModel() throws SQLException {
		
		DefaultTableModel updateAdminModel = (DefaultTableModel) table_aList.getModel();
		updateAdminModel.setRowCount(0);
		for(int i=0;i<admin.getAdminList().size();i++) {
			adminData[0] = admin.getAdminList().get(i).getID();
			adminData[1] = admin.getAdminList().get(i).getkAdi();
			adminData[2] = admin.getAdminList().get(i).getSifre();
			adminModel.addRow(adminData);
		}
	}
		
	public void updateSinemaModel() throws SQLException {
		DefaultTableModel updateSinemaModel = (DefaultTableModel) table_sList.getModel();
		updateSinemaModel.setRowCount(0);
		for(int i=0;i<admin.getSinemaList().size();i++) {
			sinemaData[0] = admin.getSinemaList().get(i).getID();
			sinemaData[1] = admin.getSinemaList().get(i).getSinemaAdi();
			sinemaData[2] = admin.getSinemaList().get(i).getTarih();
			sinemaData[3] = admin.getSinemaList().get(i).getSaat();
			sinemaData[4] = admin.getSinemaList().get(i).getSalon();
			sinemaModel.addRow(sinemaData);
		}
		
	}
	
	public void updateTiyatroModel() throws SQLException {
		DefaultTableModel updateTiyatroModel = (DefaultTableModel) table_tList.getModel();
		updateTiyatroModel.setRowCount(0);
		for(int i=0;i<admin.getTiyatroList().size();i++) {
			tiyatroData[0] = admin.getTiyatroList().get(i).getID();
			tiyatroData[1] = admin.getTiyatroList().get(i).getTiyatroAdi();
			tiyatroData[2] = admin.getTiyatroList().get(i).getTarih();
			tiyatroData[3] = admin.getTiyatroList().get(i).getSaat();
			tiyatroData[4] = admin.getTiyatroList().get(i).getSalon();
			tiyatroModel.addRow(tiyatroData);
		}
		
	}
	
	public void updateKonserModel() throws SQLException {
		DefaultTableModel updateKonserModel = (DefaultTableModel) table_kList.getModel();
		updateKonserModel.setRowCount(0);
		for(int i=0;i<admin.getKonserList().size();i++) {
			konserData[0] = admin.getKonserList().get(i).getID();
			konserData[1] = admin.getKonserList().get(i).getKonserAdi();
			konserData[2] = admin.getKonserList().get(i).getTarih();
			konserData[3] = admin.getKonserList().get(i).getSaat();
			konserData[4] = admin.getKonserList().get(i).getSalon();
			konserModel.addRow(konserData);
		}
		
	}
}