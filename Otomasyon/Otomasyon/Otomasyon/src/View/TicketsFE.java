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
import java.awt.SystemColor;
import java.awt.Color;

public class TicketsFE extends JFrame {

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
					TicketsFE frame = new TicketsFE(user);
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
	public TicketsFE(User user) throws SQLException {
		
		sinemabiletModel = new DefaultTableModel();
		Object[] colSinemaBilet = new Object[6];
		colSinemaBilet[0] = "Id";
		colSinemaBilet[1] = "Sinema Adı";
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
		colTiyatroBilet[0] = "Id";
		colTiyatroBilet[1] = "Tiyatro Adı";
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
		colKonserBilet[0] = "Id";
		colKonserBilet[1] = "Konser Adı";
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
		setBounds(100, 100, 983, 547);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_uName = new JLabel("Ho\u015F Geldiniz ");
		lbl_uName.setForeground(new Color(128, 0, 0));
		lbl_uName.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lbl_uName.setBounds(10, 22, 318, 20);
		contentPane.add(lbl_uName);
		
		JButton btn_Geri = new JButton("Geri");
		btn_Geri.setForeground(new Color(128, 0, 0));
		btn_Geri.setBackground(new Color(245, 222, 179));
		btn_Geri.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btn_Geri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserFE kullanici = new UserFE(user);
				kullanici.setVisible(true);
				dispose();
			}
		});
		btn_Geri.setBounds(10, 461, 150, 36);
		contentPane.add(btn_Geri);
		
		JButton btn_Cikis = new JButton("ÇIKIŞ");
		btn_Cikis.setBackground(new Color(245, 222, 179));
		btn_Cikis.setForeground(new Color(128, 0, 0));
		btn_Cikis.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btn_Cikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFE login = new LoginFE();
				login.setVisible(true);
				dispose();
			}
		});
		btn_Cikis.setBounds(724, 461, 150, 36);
		contentPane.add(btn_Cikis);
		
		JTabbedPane w_ButunBiletler = new JTabbedPane(JTabbedPane.TOP);
		w_ButunBiletler.setFont(new Font("Arial Black", Font.PLAIN, 13));
		w_ButunBiletler.setBounds(10, 81, 864, 369);
		contentPane.add(w_ButunBiletler);
		
		JPanel biletler_panel = new JPanel();
		biletler_panel.setBackground(new Color(245, 222, 179));
		biletler_panel.setForeground(new Color(245, 222, 179));
		w_ButunBiletler.addTab("BİLETLERİM", null, biletler_panel, null);
		biletler_panel.setLayout(null);
		
		JTabbedPane w_AyrikBiletler = new JTabbedPane(JTabbedPane.TOP);
		w_AyrikBiletler.setFont(new Font("Arial Black", Font.PLAIN, 12));
		w_AyrikBiletler.setBackground(new Color(245, 222, 179));
		w_AyrikBiletler.setBounds(10, 11, 839, 319);
		biletler_panel.add(w_AyrikBiletler);
		
		JPanel sinemaBilet_panel = new JPanel();
		sinemaBilet_panel.setBackground(new Color(245, 222, 179));
		w_AyrikBiletler.addTab("SİNEMA BİLETLERİ", null, sinemaBilet_panel, null);
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
		btn_SinemaSil.setFont(new Font("Arial Black", Font.PLAIN, 13));
		btn_SinemaSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_SinemaAdi.getText().length()==100) {
					Helper.showMsg("Lütfen İptal Etmek İstediğiniz Sinema Adını Yazınız!");
				}
				else {
					if (Helper.confirm("evet")) {
						int selectID = Integer.parseInt(fld_SinemaAdi.getText());
						try {
							boolean control = SinemaBilet.deleteSinemaBilet(selectID);
							if (control) {
								Helper.showMsg("success");
								fld_SinemaAdi.setText(null);
								//updateSinemaBiletModel();
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
					
				}
			}
		});
		btn_SinemaSil.setBounds(654, 162, 170, 23);
		sinemaBilet_panel.add(btn_SinemaSil);
		
		/*fld_SinemaIslemNo = new JTextField();
		fld_SinemaIslemNo.setBounds(654, 260, 170, 20);
		sinemaBilet_panel.add(fld_SinemaIslemNo);
		fld_SinemaIslemNo.setColumns(10);*/
		
		fld_SinemaAdi = new JTextField();
		fld_SinemaAdi.setColumns(10);
		fld_SinemaAdi.setBounds(654, 132, 170, 20);
		sinemaBilet_panel.add(fld_SinemaAdi);
		
		JLabel lbl_SinemaAdi = new JLabel("Sinema Ad\u0131");
		lbl_SinemaAdi.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lbl_SinemaAdi.setBounds(654, 108, 84, 14);
		sinemaBilet_panel.add(lbl_SinemaAdi);
		
		/*JLabel lbl_IslemNo = new JLabel("\u0130\u015Flem Numaras\u0131");
		lbl_IslemNo.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lbl_IslemNo.setBounds(658, 236, 120, 14);
		sinemaBilet_panel.add(lbl_IslemNo);*/
		
		JPanel tiyatroBilet_panel = new JPanel();
		tiyatroBilet_panel.setBackground(new Color(245, 222, 179));
		w_AyrikBiletler.addTab("TİYATRO BİLETLERİ", null, tiyatroBilet_panel, null);
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
		btn_TiyatroSil.setFont(new Font("Arial Black", Font.PLAIN, 13));
		btn_TiyatroSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_TiyatroAdi.getText().length()==100) {
					Helper.showMsg("Lütfen İptal Etmek İstediğiniz Tiyatro Adını Yazınız!");
				}
				else {
					if (Helper.confirm("evet")) {
						int selectID = Integer.parseInt(fld_TiyatroAdi.getText());
						try {
							boolean control = TiyatroBilet.deleteTiyatroBilet(selectID);
							if (control) {
								Helper.showMsg("success");
								fld_TiyatroAdi.setText(null);
								//updateSinemaBiletModel();
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
			}
		});
		btn_TiyatroSil.setBounds(654, 162, 170, 23);
		tiyatroBilet_panel.add(btn_TiyatroSil);
		
		/*fld_TiyatroIslemNo = new JTextField();
		fld_TiyatroIslemNo.setColumns(10);
		fld_TiyatroIslemNo.setBounds(654, 227, 170, 20);
		tiyatroBilet_panel.add(fld_TiyatroIslemNo);*/
		
		/*JLabel lbl_TiyatroIslemNo = new JLabel("\u0130\u015Flem Numaras\u0131");
		lbl_TiyatroIslemNo.setBounds(654, 203, 170, 14);
		tiyatroBilet_panel.add(lbl_TiyatroIslemNo);*/
		
		JLabel lbl_TiyatroAdi = new JLabel("Tiyatro Ad\u0131");
		lbl_TiyatroAdi.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lbl_TiyatroAdi.setBounds(654, 108, 84, 14);
		tiyatroBilet_panel.add(lbl_TiyatroAdi);
		
		fld_TiyatroAdi = new JTextField();
		fld_TiyatroAdi.setBounds(654, 132, 170, 20);
		tiyatroBilet_panel.add(fld_TiyatroAdi);
		fld_TiyatroAdi.setColumns(10);
		
		JPanel konserBilet_panel = new JPanel();
		konserBilet_panel.setBackground(new Color(245, 222, 179));
		w_AyrikBiletler.addTab("KONSER BİLETLERİ", null, konserBilet_panel, null);
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
		
		
         table_konserBiletList.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
					int selectID = Integer.parseInt(table_konserBiletList.getValueAt(table_konserBiletList.getSelectedRow(),0).toString());
					String selectKonserAdi = table_konserBiletList.getValueAt(table_konserBiletList.getSelectedRow(),1).toString();
					String selectTarih = table_konserBiletList.getValueAt(table_konserBiletList.getSelectedRow(),2).toString();
					String selectSaat = table_konserBiletList.getValueAt(table_konserBiletList.getSelectedRow(),3).toString();
					String selectSalon = table_konserBiletList.getValueAt(table_konserBiletList.getSelectedRow(),4).toString();
					int selectKoltukID = Integer.parseInt(table_konserBiletList.getValueAt(table_konserBiletList.getSelectedRow(),5).toString());
					String selectKoltuk = table_konserBiletList.getValueAt(table_konserBiletList.getSelectedRow(),5).toString();
				
					try {
						boolean control = KonserBilet.updateKonserBilet(selectID, selectKonserAdi, selectTarih, selectSaat, selectSalon, selectKoltuk);
					} catch (Exception e2) {
						e2.getStackTrace();
					}
				}
			}
		});
		
		JButton btn_KonserSil = new JButton("\u0130ptal Et");
		btn_KonserSil.setFont(new Font("Arial Black", Font.PLAIN, 13));
		btn_KonserSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_KonserAdi.getText().length()==100) {
					Helper.showMsg("Lütfen İptal Etmek İstediğiniz Konser Adını Yazınız!");
				}
				else {
					if(Helper.confirm("evet")) {
						int selectID = Integer.parseInt(fld_KonserAdi.getText());
						try {
							boolean control = KonserBilet.deleteKonserBilet(selectID);
							if(control) {
								Helper.showMsg("success");
								fld_KonserAdi.setText(null);
								//updateKonserBiletModel();
							}
						} catch (Exception e2) {
							//
						}
					}
				}
			}
			});
		btn_KonserSil.setBounds(654, 162, 170, 23);
		konserBilet_panel.add(btn_KonserSil);
		
		/*fld_KonserIslemNo = new JTextField();
		fld_KonserIslemNo.setColumns(10);
		fld_KonserIslemNo.setBounds(654, 260, 170, 20);
		konserBilet_panel.add(fld_KonserIslemNo);*/
		
		/*JLabel lbl_KonserIslemNo = new JLabel("\u0130\u015Flem Numaras\u0131");
		lbl_KonserIslemNo.setBounds(654, 236, 170, 14);
		konserBilet_panel.add(lbl_KonserIslemNo);*/
		
		JLabel lbl_KonserAdi = new JLabel("Konser Ad\u0131");
		lbl_KonserAdi.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lbl_KonserAdi.setBounds(654, 108, 84, 14);
		konserBilet_panel.add(lbl_KonserAdi);
		
		fld_KonserAdi = new JTextField();
		fld_KonserAdi.setBounds(654, 132, 170, 20);
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
