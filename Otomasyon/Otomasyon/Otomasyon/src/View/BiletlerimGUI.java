package View;

//import java.awt.BorderLayout;
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
import Model.Admin;
import Model.SinemaBilet;
import Model.User;
import Model.TiyatroBilet;
import Model.KonserBilet;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BiletlerimGUI extends JFrame {

	static User user = new User();
	static SinemaBilet SinemaBilet = new SinemaBilet();
	static Admin admin = new Admin();
	static TiyatroBilet TiyatroBilet = new TiyatroBilet();
	static KonserBilet KonserBilet = new KonserBilet();
	private JPanel contentPane;
	private JTable table_sinemaBiletList;
	private JTable table_tiyatroBiletList;
	private JTable table_konserBiletList;
	private DefaultTableModel sinemabiletModel = null;
	private Object[] sinemabiletData = null;
	private DefaultTableModel tiyatrobiletModel = null;
	private Object[] tiyatrobiletData = null;
	private DefaultTableModel konserbiletModel = null;
	private Object[] konserbiletData = null;
	private JTextField fld_SinemaIslemNo;
	private JTextField fld_TiyatroIslemNo;
	private JTextField fld_KonserIslemNo;
	private JTextField fld_SinemaAdi;
	private JTextField fld_TiyatroAdi;
	private JTextField fld_KonserAdi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BiletlerimGUI frame = new BiletlerimGUI(user);
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
	public BiletlerimGUI(User user) throws SQLException {
		
		sinemabiletModel = new DefaultTableModel();
		Object[] colSinemaBilet = new Object[6];
		colSinemaBilet[0] = "��lem No";
		colSinemaBilet[1] = "Sinema Ad�";
		colSinemaBilet[2] = "Tarih";
		colSinemaBilet[3] = "Saat";
		colSinemaBilet[4] = "Salon";
		colSinemaBilet[5] = "Koltuk";
		sinemabiletModel.setColumnIdentifiers(colSinemaBilet);
		sinemabiletData = new Object[6];
		for(int i=0;i<SinemaBilet.getSinemaBiletList().size();i++) {
			sinemabiletData[0] = SinemaBilet.getSinemaBiletList().get(i).getID();
			sinemabiletData[1] = SinemaBilet.getSinemaBiletList().get(i).getSinemaAdi();
			sinemabiletData[2] = SinemaBilet.getSinemaBiletList().get(i).getTarih();
			sinemabiletData[3] = SinemaBilet.getSinemaBiletList().get(i).getSaat();
			sinemabiletData[4] = SinemaBilet.getSinemaBiletList().get(i).getSalon();
			sinemabiletData[5] = SinemaBilet.getSinemaBiletList().get(i).getKoltuk();
			sinemabiletModel.addRow(sinemabiletData);
		}
		
		tiyatrobiletModel = new DefaultTableModel();
		Object[] colTiyatroBilet = new Object[6];
		colTiyatroBilet[0] = "��lem No";
		colTiyatroBilet[1] = "Tiyatro Ad�";
		colTiyatroBilet[2] = "Tarih";
		colTiyatroBilet[3] = "Saat";
		colTiyatroBilet[4] = "Salon";
		colTiyatroBilet[5] = "Koltuk";
		tiyatrobiletModel.setColumnIdentifiers(colTiyatroBilet);
		tiyatrobiletData = new Object[6];
		for(int i=0;i<TiyatroBilet.getTiyatroBiletList().size();i++) {
			tiyatrobiletData[0] = TiyatroBilet.getTiyatroBiletList().get(i).getID();
			tiyatrobiletData[1] = TiyatroBilet.getTiyatroBiletList().get(i).getTiyatroAdi();
			tiyatrobiletData[2] = TiyatroBilet.getTiyatroBiletList().get(i).getTarih();
			tiyatrobiletData[3] = TiyatroBilet.getTiyatroBiletList().get(i).getSaat();
			tiyatrobiletData[4] = TiyatroBilet.getTiyatroBiletList().get(i).getSalon();
			tiyatrobiletData[5] = TiyatroBilet.getTiyatroBiletList().get(i).getKoltuk();
			tiyatrobiletModel.addRow(tiyatrobiletData);
		}
		
		konserbiletModel = new DefaultTableModel();
		Object[] colKonserBilet = new Object[6];
		colKonserBilet[0] = "��lem No";
		colKonserBilet[1] = "Konser Ad�";
		colKonserBilet[2] = "Tarih";
		colKonserBilet[3] = "Saat";
		colKonserBilet[4] = "Salon";
		colKonserBilet[5] = "Koltuk";
		konserbiletModel.setColumnIdentifiers(colKonserBilet);
		konserbiletData = new Object[6];
		for(int i=0;i<KonserBilet.getKonserBiletList().size();i++) {
			konserbiletData[0] = KonserBilet.getKonserBiletList().get(i).getID();
			konserbiletData[1] = KonserBilet.getKonserBiletList().get(i).getKonserAdi();
			konserbiletData[2] = KonserBilet.getKonserBiletList().get(i).getTarih();
			konserbiletData[3] = KonserBilet.getKonserBiletList().get(i).getSaat();
			konserbiletData[4] = KonserBilet.getKonserBiletList().get(i).getSalon();
			konserbiletData[5] = KonserBilet.getKonserBiletList().get(i).getKoltuk();
			konserbiletModel.addRow(konserbiletData);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_uName = new JLabel("Ho\u015F Geldiniz, Say\u0131n "+user.getAdi());
		lbl_uName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_uName.setBounds(10, 50, 210, 20);
		contentPane.add(lbl_uName);
		
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
		
		JButton btn_Cikis = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btn_Cikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI login = new LoginGUI();
				login.setVisible(true);
				dispose();
			}
		});
		btn_Cikis.setBounds(779, 10, 95, 23);
		contentPane.add(btn_Cikis);
		
		JTabbedPane w_ButunBiletler = new JTabbedPane(JTabbedPane.TOP);
		w_ButunBiletler.setBounds(10, 81, 864, 369);
		contentPane.add(w_ButunBiletler);
		
		JPanel biletler_panel = new JPanel();
		w_ButunBiletler.addTab("Biletlerim", null, biletler_panel, null);
		biletler_panel.setLayout(null);
		
		JTabbedPane w_AyrikBiletler = new JTabbedPane(JTabbedPane.TOP);
		w_AyrikBiletler.setBounds(10, 11, 839, 319);
		biletler_panel.add(w_AyrikBiletler);
		
		JPanel sinemaBilet_panel = new JPanel();
		w_AyrikBiletler.addTab("Sinema Biletlerim", null, sinemaBilet_panel, null);
		sinemaBilet_panel.setLayout(null);
		
		JScrollPane w_sinemasScrollPane = new JScrollPane();
		w_sinemasScrollPane.setBounds(10, 11, 634, 269);
		sinemaBilet_panel.add(w_sinemasScrollPane);
		
		table_sinemaBiletList = new JTable(sinemabiletModel);
		w_sinemasScrollPane.setViewportView(table_sinemaBiletList);
		table_sinemaBiletList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				try {
					fld_SinemaIslemNo.setText(table_sinemaBiletList.getValueAt(table_sinemaBiletList.getSelectedRow(),0).toString());
					fld_SinemaAdi.setText(table_sinemaBiletList.getValueAt(table_sinemaBiletList.getSelectedRow(),1).toString());
				} 
				catch (Exception e2) {
					// TODO: handle exception
				}				
			}
		});
		
		table_sinemaBiletList.getModel().addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
					int selectID = Integer.parseInt(table_sinemaBiletList.getValueAt(table_sinemaBiletList.getSelectedRow(),0).toString());
					String selectsinemaAdi = table_sinemaBiletList.getValueAt(table_sinemaBiletList.getSelectedRow(),1).toString();
					String selectTarih = table_sinemaBiletList.getValueAt(table_sinemaBiletList.getSelectedRow(),2).toString();
					String selectSaat = table_sinemaBiletList.getValueAt(table_sinemaBiletList.getSelectedRow(),3).toString();
					String selectSalon = table_sinemaBiletList.getValueAt(table_sinemaBiletList.getSelectedRow(),4).toString();
					//int selectKoltukID = Integer.parseInt(table_sinemaBiletList.getValueAt(table_sinemaBiletList.getSelectedRow(),5).toString());
					String selectKoltuk = table_sinemaBiletList.getValueAt(table_sinemaBiletList.getSelectedRow(),5).toString();
				
					try {
						boolean control = SinemaBilet.updateSinemaBilet(selectID, selectsinemaAdi, selectTarih, selectSaat, selectSalon, selectKoltuk);
					} catch (Exception e2) {
						e2.getStackTrace();
					}
				}
			}
		});
		
		JButton btn_SinemaSil = new JButton("\u0130ptal Et");
		btn_SinemaSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_SinemaIslemNo.getText().length()==0) {
					Helper.showMsg("L�tfen �ptal Etmek �stedi�iniz Bileti Se�iniz");
				}
				else {
					if (Helper.confirm("evet")) {
						int selectID = Integer.parseInt(fld_SinemaIslemNo.getText());
						try {
							boolean control = SinemaBilet.deleteSinemaBilet(selectID);
							if (control) {
								Helper.showMsg("success");
								fld_SinemaIslemNo.setText(null);
								//updateSinemaBiletModel();
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
					
				}
			}
		});
		btn_SinemaSil.setBounds(654, 257, 170, 23);
		sinemaBilet_panel.add(btn_SinemaSil);
		
		fld_SinemaIslemNo = new JTextField();
		fld_SinemaIslemNo.setBounds(654, 170, 170, 20);
		sinemaBilet_panel.add(fld_SinemaIslemNo);
		fld_SinemaIslemNo.setColumns(10);
		
		fld_SinemaAdi = new JTextField();
		fld_SinemaAdi.setColumns(10);
		fld_SinemaAdi.setBounds(654, 226, 170, 20);
		sinemaBilet_panel.add(fld_SinemaAdi);
		
		JLabel lbl_SinemaAdi = new JLabel("Sinema Ad\u0131");
		lbl_SinemaAdi.setBounds(654, 201, 170, 14);
		sinemaBilet_panel.add(lbl_SinemaAdi);
		
		JLabel lbl_IslemNo = new JLabel("\u0130\u015Flem Numaras\u0131");
		lbl_IslemNo.setBounds(654, 145, 170, 14);
		sinemaBilet_panel.add(lbl_IslemNo);
		
		JPanel tiyatroBilet_panel = new JPanel();
		w_AyrikBiletler.addTab("Tiyatro Biletlerim", null, tiyatroBilet_panel, null);
		tiyatroBilet_panel.setLayout(null);
		
		JScrollPane w_tiyatroScrollPane = new JScrollPane();
		w_tiyatroScrollPane.setBounds(10, 11, 634, 269);
		tiyatroBilet_panel.add(w_tiyatroScrollPane);
		
		table_tiyatroBiletList = new JTable(tiyatrobiletModel);
		w_tiyatroScrollPane.setViewportView(table_tiyatroBiletList);
		table_tiyatroBiletList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				try {
					fld_TiyatroIslemNo.setText(table_tiyatroBiletList.getValueAt(table_tiyatroBiletList.getSelectedRow(),0).toString());
					fld_TiyatroAdi.setText(table_tiyatroBiletList.getValueAt(table_tiyatroBiletList.getSelectedRow(),1).toString());
				} 
				catch (Exception e2) {
					// TODO: handle exception
				}				
			}
		});
		
		table_tiyatroBiletList.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
					int selectID = Integer.parseInt(table_tiyatroBiletList.getValueAt(table_tiyatroBiletList.getSelectedRow(),0).toString());
					String selectTiyatroAdi = table_tiyatroBiletList.getValueAt(table_tiyatroBiletList.getSelectedRow(),1).toString();
					String selectTarih = table_tiyatroBiletList.getValueAt(table_tiyatroBiletList.getSelectedRow(),2).toString();
					String selectSaat = table_tiyatroBiletList.getValueAt(table_tiyatroBiletList.getSelectedRow(),3).toString();
					String selectSalon = table_tiyatroBiletList.getValueAt(table_tiyatroBiletList.getSelectedRow(),4).toString();
					int selectKoltukID = Integer.parseInt(table_tiyatroBiletList.getValueAt(table_tiyatroBiletList.getSelectedRow(),5).toString());
					String selectKoltuk = table_tiyatroBiletList.getValueAt(table_tiyatroBiletList.getSelectedRow(),5).toString();
				
					try {
						boolean control = TiyatroBilet.updateTiyatroBilet(selectID, selectTiyatroAdi, selectTarih, selectSaat, selectSalon, selectKoltuk);
					} catch (Exception e2) {
						e2.getStackTrace();
					}
				}
			}
		});
		
		JButton btn_TiyatroSil = new JButton("\u0130ptal Et");
		btn_TiyatroSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_TiyatroIslemNo.getText().length()==0) {
					Helper.showMsg("L�tfen �ptal Etmek �stedi�iniz Bileti Se�iniz");
				}
				else {
					if (Helper.confirm("evet")) {
						int selectID = Integer.parseInt(fld_TiyatroIslemNo.getText());
						try {
							boolean control = SinemaBilet.deleteSinemaBilet(selectID);
							if (control) {
								Helper.showMsg("success");
								fld_TiyatroIslemNo.setText(null);
								//updateSinemaBiletModel();
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
			}
		});
		btn_TiyatroSil.setBounds(654, 257, 170, 23);
		tiyatroBilet_panel.add(btn_TiyatroSil);
		
		fld_TiyatroIslemNo = new JTextField();
		fld_TiyatroIslemNo.setColumns(10);
		fld_TiyatroIslemNo.setBounds(654, 170, 170, 20);
		tiyatroBilet_panel.add(fld_TiyatroIslemNo);
		
		JLabel lbl_TiyatroIslemNo = new JLabel("\u0130\u015Flem Numaras\u0131");
		lbl_TiyatroIslemNo.setBounds(654, 145, 170, 14);
		tiyatroBilet_panel.add(lbl_TiyatroIslemNo);
		
		JLabel lbl_TiyatroAdi = new JLabel("Tiyatro Ad\u0131");
		lbl_TiyatroAdi.setBounds(654, 201, 170, 14);
		tiyatroBilet_panel.add(lbl_TiyatroAdi);
		
		fld_TiyatroAdi = new JTextField();
		fld_TiyatroAdi.setBounds(654, 226, 170, 20);
		tiyatroBilet_panel.add(fld_TiyatroAdi);
		fld_TiyatroAdi.setColumns(10);
		
		JPanel konserBilet_panel = new JPanel();
		w_AyrikBiletler.addTab("Konser Biletlerim", null, konserBilet_panel, null);
		konserBilet_panel.setLayout(null);
		
		JScrollPane w_konserScrollPane = new JScrollPane();
		w_konserScrollPane.setBounds(10, 11, 634, 269);
		konserBilet_panel.add(w_konserScrollPane);
		
		table_konserBiletList = new JTable(konserbiletModel);
		w_konserScrollPane.setViewportView(table_konserBiletList);
		table_konserBiletList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				try {
					fld_KonserIslemNo.setText(table_konserBiletList.getValueAt(table_konserBiletList.getSelectedRow(),0).toString());
					fld_KonserAdi.setText(table_konserBiletList.getValueAt(table_konserBiletList.getSelectedRow(),1).toString());
				} 
				catch (Exception e2) {
					// TODO: handle exception
				}				
			}
		});
		
		
		JButton btn_KonserSil = new JButton("\u0130ptal Et");
		btn_KonserSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_KonserSil.setBounds(654, 257, 170, 23);
		konserBilet_panel.add(btn_KonserSil);
		
		fld_KonserIslemNo = new JTextField();
		fld_KonserIslemNo.setColumns(10);
		fld_KonserIslemNo.setBounds(654, 170, 170, 20);
		konserBilet_panel.add(fld_KonserIslemNo);
		
		JLabel lbl_KonserIslemNo = new JLabel("\u0130\u015Flem Numaras\u0131");
		lbl_KonserIslemNo.setBounds(654, 145, 170, 14);
		konserBilet_panel.add(lbl_KonserIslemNo);
		
		JLabel lbl_KonserAdi = new JLabel("Konser Ad\u0131");
		lbl_KonserAdi.setBounds(654, 201, 170, 14);
		konserBilet_panel.add(lbl_KonserAdi);
		
		fld_KonserAdi = new JTextField();
		fld_KonserAdi.setBounds(654, 226, 170, 20);
		konserBilet_panel.add(fld_KonserAdi);
		fld_KonserAdi.setColumns(10);
	}
	
	
	public void updateSinemaBiletModel() throws SQLException {
		DefaultTableModel updateSinemaModel = (DefaultTableModel) table_sinemaBiletList.getModel();
		updateSinemaModel.setRowCount(0);
		for(int i=0;i<SinemaBilet.getSinemaBiletList().size();i++) {
			sinemabiletData[0] = SinemaBilet.getSinemaBiletList().get(i).getID();
			sinemabiletData[1] = SinemaBilet.getSinemaBiletList().get(i).getSinemaAdi();
			sinemabiletData[2] = SinemaBilet.getSinemaBiletList().get(i).getTarih();
			sinemabiletData[3] = SinemaBilet.getSinemaBiletList().get(i).getSaat();
			sinemabiletData[4] = SinemaBilet.getSinemaBiletList().get(i).getSalon();
			sinemabiletData[5] = SinemaBilet.getSinemaBiletList().get(i).getKoltuk();
			sinemabiletModel.addRow(sinemabiletData);
		}		
	}
	
	public void updateTiyatroBiletModel() throws SQLException {
		DefaultTableModel updateTiyatroModel = (DefaultTableModel) table_tiyatroBiletList.getModel();
		updateTiyatroModel.setRowCount(0);
		for(int i=0;i<TiyatroBilet.getTiyatroBiletList().size();i++) {
			tiyatrobiletData[0] = TiyatroBilet.getTiyatroBiletList().get(i).getID();
			tiyatrobiletData[1] = TiyatroBilet.getTiyatroBiletList().get(i).getTiyatroAdi();
			tiyatrobiletData[2] = TiyatroBilet.getTiyatroBiletList().get(i).getTarih();
			tiyatrobiletData[3] = TiyatroBilet.getTiyatroBiletList().get(i).getSaat();
			tiyatrobiletData[4] = TiyatroBilet.getTiyatroBiletList().get(i).getSalon();
			tiyatrobiletData[5] = TiyatroBilet.getTiyatroBiletList().get(i).getKoltuk();
			tiyatrobiletModel.addRow(tiyatrobiletData);
		}		
	}
	
	public void updateKonserBiletModel() throws SQLException {
		DefaultTableModel updateKonserModel = (DefaultTableModel) table_konserBiletList.getModel();
		updateKonserModel.setRowCount(0);
		for(int i=0;i<KonserBilet.getKonserBiletList().size();i++) {
			konserbiletData[0] = KonserBilet.getKonserBiletList().get(i).getID();
			konserbiletData[1] = KonserBilet.getKonserBiletList().get(i).getKonserAdi();
			konserbiletData[2] = KonserBilet.getKonserBiletList().get(i).getTarih();
			konserbiletData[3] = KonserBilet.getKonserBiletList().get(i).getSaat();
			konserbiletData[4] = KonserBilet.getKonserBiletList().get(i).getSalon();
			konserbiletData[5] = KonserBilet.getKonserBiletList().get(i).getKoltuk();
			konserbiletModel.addRow(konserbiletData);
		}		
	}
}
