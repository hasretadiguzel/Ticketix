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
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Helper.Helper;
import Model.Admin;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.SystemColor;

public class OperatorFE extends JFrame {

	static Admin admin = new Admin();
	private JPanel contentPane;
	private JTextField fld_sinemaAdi;
	private JTextField fld_sinemaID;
	private JTable table_sList;

	private DefaultTableModel sinemaModel = null;
	private Object[] sinemaData = null;
	private DefaultTableModel tiyatroModel = null;
	private Object[] tiyatroData = null;
	private DefaultTableModel konserModel = null;
	private Object[] konserData = null;
	private JTextField fld_tiyatroAdi;
	private JTextField fld_tiyatroID;
	private JTextField fld_konserAdi;
	private JTextField fld_konserID;
	private JTable table_tList;
	private JTable table_kList;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperatorFE frame = new OperatorFE(admin);
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
	public OperatorFE(Admin admin) throws SQLException {
		
		sinemaModel = new DefaultTableModel();
		Object[] colSinemaName = new Object[5];
		colSinemaName[0] = "Id";
		colSinemaName[1] = "Sinema Adı";
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
		
		//T YATRO TABLE
		tiyatroModel = new DefaultTableModel();
		Object[] colTiyatroName = new Object[5];
		colTiyatroName[0] = "Id";
		colTiyatroName[1] = "Tiyatro Adı";
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
		colKonserName[0] = "Id";
		colKonserName[1] = "Konser Adı";
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
		setBounds(100, 100, 1140, 474);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_aName = new JLabel("Ho\u015F Geldiniz");
		lbl_aName.setForeground(new Color(128, 0, 0));
		lbl_aName.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lbl_aName.setBounds(10, 10, 363, 29);
		contentPane.add(lbl_aName);
		
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
		btn_Cikis.setBounds(966, 387, 150, 36);
		contentPane.add(btn_Cikis);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Arial Black", Font.PLAIN, 10));
		tabbedPane.setBackground(new Color(245, 222, 179));
		tabbedPane.setBounds(10, 41, 1106, 343);
		contentPane.add(tabbedPane);
		
		JPanel sinema_panel = new JPanel();
		sinema_panel.setBackground(new Color(245, 222, 179));
		tabbedPane.addTab("SİNEMA YÖNETİMİ", null, sinema_panel, null);
		sinema_panel.setLayout(null);
		
		JLabel lbl_SinemaAdi = new JLabel("Film Ad\u0131:");
		lbl_SinemaAdi.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbl_SinemaAdi.setBounds(863, 38, 58, 14);
		sinema_panel.add(lbl_SinemaAdi);
		
		fld_sinemaAdi = new JTextField();
		fld_sinemaAdi.setFont(new Font("Arial", Font.PLAIN, 11));
		fld_sinemaAdi.setColumns(10);
		fld_sinemaAdi.setBounds(863, 62, 205, 20);
		sinema_panel.add(fld_sinemaAdi);
		
		JLabel lbl_sTarih = new JLabel("Tarih:");
		lbl_sTarih.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbl_sTarih.setBounds(863, 92, 38, 14);
		sinema_panel.add(lbl_sTarih);
		
		JDateChooser dc_sinemaTarih = new JDateChooser();
		dc_sinemaTarih.setBounds(863, 116, 205, 20);
		sinema_panel.add(dc_sinemaTarih);
		
		JLabel lbl_sSaat = new JLabel("Saat:");
		lbl_sSaat.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbl_sSaat.setBounds(986, 146, 49, 14);
		sinema_panel.add(lbl_sSaat);
		
		JComboBox sinemaSaatCombo = new JComboBox();
		sinemaSaatCombo.setFont(new Font("Arial", Font.PLAIN, 11));
		sinemaSaatCombo.setModel(new DefaultComboBoxModel(new String[] {" ", "10.00", "11.00", "12.00", "13.00", "14.00", "15.00", "16.00", "17.00", "18.00", "19.00", "20.00", "21.00", "22.00", "23.00"}));
		sinemaSaatCombo.setBounds(986, 170, 82, 22);
		sinema_panel.add(sinemaSaatCombo);
		
		JLabel lbl_SinemaSalonNo = new JLabel("Salon Numaras\u0131:");
		lbl_SinemaSalonNo.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbl_SinemaSalonNo.setBounds(863, 146, 113, 14);
		sinema_panel.add(lbl_SinemaSalonNo);
		
		JComboBox SinemaSalonCombo = new JComboBox();
		SinemaSalonCombo.setFont(new Font("Arial", Font.PLAIN, 11));
		SinemaSalonCombo.setModel(new DefaultComboBoxModel(new String[] {" ", "1", "2", "3", "4"}));
		SinemaSalonCombo.setBounds(863, 170, 63, 22);
		sinema_panel.add(SinemaSalonCombo);
		
		JButton btn_sinemaEkle = new JButton("Sinema Ekle");
		btn_sinemaEkle.setFont(new Font("Arial Black", Font.PLAIN, 13));
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
		btn_sinemaEkle.setBounds(863, 202, 205, 23);
		sinema_panel.add(btn_sinemaEkle);
		
		JLabel lbl_sKaldir = new JLabel("Sinema ID:");
		lbl_sKaldir.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbl_sKaldir.setBounds(863, 272, 71, 14);
		sinema_panel.add(lbl_sKaldir);
		
		fld_sinemaID = new JTextField();
		fld_sinemaID.setColumns(10);
		fld_sinemaID.setBounds(938, 271, 40, 20);
		sinema_panel.add(fld_sinemaID);
		
		JButton btn_sinemaKaldir = new JButton("Kald\u0131r");
		btn_sinemaKaldir.setFont(new Font("Arial Black", Font.PLAIN, 13));
		btn_sinemaKaldir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_sinemaID.getText().length()==0) {
					Helper.showMsg("Lütfen Tüm Alanları Eksiksiz Doldurunuz!");
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
		btn_sinemaKaldir.setBounds(986, 269, 82, 23);
		sinema_panel.add(btn_sinemaKaldir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 825, 248);
		sinema_panel.add(scrollPane);
		
		table_sList = new JTable(sinemaModel);
		scrollPane.setViewportView(table_sList);
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
		
		JPanel tiyatro_panel = new JPanel();
		tiyatro_panel.setBackground(new Color(245, 222, 179));
		tabbedPane.addTab("TİYATRO YÖNETİMİ", null, tiyatro_panel, null);
		tiyatro_panel.setLayout(null);
		
		JLabel lbl_tiyatroAdi = new JLabel("Tiyatro Ad\u0131:");
		lbl_tiyatroAdi.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbl_tiyatroAdi.setBounds(863, 38, 115, 14);
		tiyatro_panel.add(lbl_tiyatroAdi);
		
		fld_tiyatroAdi = new JTextField();
		fld_tiyatroAdi.setFont(new Font("Arial", Font.PLAIN, 11));
		fld_tiyatroAdi.setColumns(10);
		fld_tiyatroAdi.setBounds(863, 62, 198, 20);
		tiyatro_panel.add(fld_tiyatroAdi);
		
		JLabel lbl_tTarih = new JLabel("Tarih:");
		lbl_tTarih.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbl_tTarih.setBounds(863, 92, 174, 14);
		tiyatro_panel.add(lbl_tTarih);
		
		JDateChooser dc_tiyatroTarih = new JDateChooser();
		dc_tiyatroTarih.setBounds(863, 116, 198, 20);
		tiyatro_panel.add(dc_tiyatroTarih);
		
		JLabel lbl_tSaat = new JLabel("Saat:");
		lbl_tSaat.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbl_tSaat.setBounds(986, 146, 49, 14);
		tiyatro_panel.add(lbl_tSaat);
		
		JComboBox tiyatroSaatCombo = new JComboBox();
		tiyatroSaatCombo.setFont(new Font("Arial", Font.PLAIN, 11));
		tiyatroSaatCombo.setModel(new DefaultComboBoxModel(new String[] {" ", "10.00", "11.00", "12.00", "13.00", "14.00", "15.00", "16.00", "17.00", "18.00", "19.00"}));
		tiyatroSaatCombo.setBounds(986, 170, 73, 22);
		tiyatro_panel.add(tiyatroSaatCombo);
		
		JLabel lbl_TiyatroSalonNo = new JLabel("Salon Numaras\u0131:");
		lbl_TiyatroSalonNo.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbl_TiyatroSalonNo.setBounds(863, 146, 108, 14);
		tiyatro_panel.add(lbl_TiyatroSalonNo);
		
		JComboBox TiyatroSalonCombo = new JComboBox();
		TiyatroSalonCombo.setFont(new Font("Arial", Font.PLAIN, 11));
		TiyatroSalonCombo.setModel(new DefaultComboBoxModel(new String[] {" ", "1", "2", "3", "4"}));
		TiyatroSalonCombo.setBounds(863, 170, 63, 22);
		tiyatro_panel.add(TiyatroSalonCombo);
		
		JButton btn_tiyatroEkle = new JButton("Tiyatro Ekle");
		btn_tiyatroEkle.setFont(new Font("Arial Black", Font.PLAIN, 13));
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
		btn_tiyatroEkle.setBounds(863, 202, 198, 23);
		tiyatro_panel.add(btn_tiyatroEkle);
		
		JLabel lbl_tKaldir = new JLabel("Tiyatro ID:");
		lbl_tKaldir.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbl_tKaldir.setBounds(863, 272, 71, 14);
		tiyatro_panel.add(lbl_tKaldir);
		
		fld_tiyatroID = new JTextField();
		fld_tiyatroID.setColumns(10);
		fld_tiyatroID.setBounds(938, 271, 40, 20);
		tiyatro_panel.add(fld_tiyatroID);
		
		JButton btn_tiyatroKaldir = new JButton("Kald\u0131r");
		btn_tiyatroKaldir.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btn_tiyatroKaldir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_tiyatroID.getText().length()==0) {
					Helper.showMsg("Lütfen Tüm Alanları Doldurunuz!");
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
		btn_tiyatroKaldir.setBounds(986, 269, 75, 23);
		tiyatro_panel.add(btn_tiyatroKaldir);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 38, 825, 248);
		tiyatro_panel.add(scrollPane_2);
		
		table_tList = new JTable(tiyatroModel);
		scrollPane_2.setViewportView(table_tList);
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
		
		JPanel konser_panel = new JPanel();
		konser_panel.setBackground(new Color(245, 222, 179));
		tabbedPane.addTab("KONSER YÖNETİMİ", null, konser_panel, null);
		konser_panel.setLayout(null);
		
		JLabel lbl_konserAdi = new JLabel("Konser Ad\u0131:");
		lbl_konserAdi.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbl_konserAdi.setBounds(863, 38, 115, 14);
		konser_panel.add(lbl_konserAdi);
		
		fld_konserAdi = new JTextField();
		fld_konserAdi.setFont(new Font("Arial", Font.PLAIN, 11));
		fld_konserAdi.setColumns(10);
		fld_konserAdi.setBounds(863, 62, 198, 20);
		konser_panel.add(fld_konserAdi);
		
		JLabel lbl_kTarih = new JLabel("Tarih:");
		lbl_kTarih.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbl_kTarih.setBounds(863, 92, 174, 14);
		konser_panel.add(lbl_kTarih);
		
		JDateChooser dc_konserTarih = new JDateChooser();
		dc_konserTarih.setBounds(863, 116, 198, 20);
		konser_panel.add(dc_konserTarih);
		
		JLabel lbl_kSaat = new JLabel("Saat:");
		lbl_kSaat.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbl_kSaat.setBounds(986, 146, 49, 14);
		konser_panel.add(lbl_kSaat);
		
		JComboBox konserSaatCombo = new JComboBox();
		konserSaatCombo.setFont(new Font("Arial", Font.PLAIN, 11));
		konserSaatCombo.setModel(new DefaultComboBoxModel(new String[] {" ", "19.00", "20.00", "21.00", "22.00", "23.00"}));
		konserSaatCombo.setBounds(986, 170, 73, 22);
		konser_panel.add(konserSaatCombo);
		
		JLabel lbl_KonserSalonNo = new JLabel("Salon Numaras\u0131:");
		lbl_KonserSalonNo.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbl_KonserSalonNo.setBounds(863, 146, 115, 14);
		konser_panel.add(lbl_KonserSalonNo);
		
		JComboBox KonserSalonCombo = new JComboBox();
		KonserSalonCombo.setFont(new Font("Arial", Font.PLAIN, 11));
		KonserSalonCombo.setModel(new DefaultComboBoxModel(new String[] {" ", "1", "2", "3", "4"}));
		KonserSalonCombo.setBounds(863, 170, 63, 22);
		konser_panel.add(KonserSalonCombo);
		
		JButton btn_konserEkle = new JButton("Konser Ekle");
		btn_konserEkle.setFont(new Font("Arial Black", Font.PLAIN, 13));
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
		btn_konserEkle.setBounds(863, 202, 198, 23);
		konser_panel.add(btn_konserEkle);
		
		JLabel lbl_kKaldir = new JLabel("Konser ID:");
		lbl_kKaldir.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbl_kKaldir.setBounds(863, 272, 71, 14);
		konser_panel.add(lbl_kKaldir);
		
		fld_konserID = new JTextField();
		fld_konserID.setColumns(10);
		fld_konserID.setBounds(938, 271, 40, 20);
		konser_panel.add(fld_konserID);
		
		JButton btn_konserKaldir = new JButton("Kald\u0131r");
		btn_konserKaldir.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btn_konserKaldir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_konserID.getText().length()==0) {
					Helper.showMsg("Lütfen Tüm Alanları Doldurunuz!");
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
		btn_konserKaldir.setBounds(986, 269, 75, 23);
		konser_panel.add(btn_konserKaldir);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 38, 825, 248);
		konser_panel.add(scrollPane_1);
		
		table_kList = new JTable(konserModel);
		scrollPane_1.setViewportView(table_kList);
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
