package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;

import BLL.BLL_chiaphongthi;
import BLL.BLL_khoathi;
import BLL.BLL_phongthi;
import DAL.Connect;
import DTO.DTO_chiaphongthi;
import DTO.DTO_khoathi;
import DTO.DTO_phongthi;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DANHSACHPHONGTHI extends JFrame {
	Connect a = new Connect();
    Connection conn = a.getConnection();
    DefaultTableModel model,modelpn;
	private JPanel contentPane;
	private JTextField txt_makhoathi;
	private JTextField txt_tenkhoathi;
	private JTextField txt_ngaythi;
	private JTable tb_khoathi;
	private JTable tb_phongthi;
	private JLabel lblNewLabel_3;
	private JTextField txt_makhoathi1;
	private JLabel lblNewLabel_5;
	private JTextField txt_trinhdo;
	private JTextField txt_mapt;
	private JTextField txt_magiamthi2;
	private JTextField txt_magiamthi1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DANHSACHPHONGTHI frame = new DANHSACHPHONGTHI();
//					 System.out.println("makt "+nv.makt);
//			           
//			            System.out.println("tenn "+nv.tenkt);
//			            row.add(nv.ngaythi);
//			            System.out.println("ngay "+nv.ngaythi);
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
	
	public DANHSACHPHONGTHI() throws SQLException {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lb_khoa = new JLabel("M\u00E3 kh\u00F3a thi");
		
		txt_makhoathi = new JTextField();
		txt_makhoathi.setColumns(10);
		
		JButton btn_taokhoa = new JButton("T\u1EA1o kh\u00F3a");
		btn_taokhoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int k=0;
			
	        	BLL_khoathi kt1=new BLL_khoathi();
	        	try {
					kt1.docDSKT();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				DTO_khoathi kt = new DTO_khoathi();
				JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		       
		        if (txt_makhoathi.getText().equals("")) {
		        	 JOptionPane.showMessageDialog(frame, "Vui long nhap ma khoa thi","Error Title", JOptionPane.ERROR_MESSAGE);
		        } else if(txt_tenkhoathi.getText().equals("")) {
		        	JOptionPane.showMessageDialog(frame, "Vui long nhap ma ten khoa thi","Error Title", JOptionPane.ERROR_MESSAGE);
		        }else if (txt_ngaythi.getText().equals("")) {
		        	JOptionPane.showMessageDialog(frame, "Vui long nhap ngay thi","Error Title", JOptionPane.ERROR_MESSAGE);
		       
		        }
		        else {
		        	
		        	for (DTO_khoathi nv : BLL_khoathi.dskt) {
		        		
		        		if(nv.makt.equals(txt_makhoathi.getText())) 
		        			k=k+1;
		        	
		        		}
		        	
				    
		           if(k>0)   JOptionPane.showMessageDialog(frame, "khoa trung voi khoa trong database","Error Title", JOptionPane.ERROR_MESSAGE);
		           else if(k==0) {
		        	   kt.makt = txt_makhoathi.getText();
	      		        kt.tenkt = txt_tenkhoathi.getText();
	      		        kt.ngaythi = txt_ngaythi.getText();
	        			
	        			try {
//	        				String k1;
	        				kt1.ThemKH(kt);
//	        				if(k1.equalsIgnoreCase("huy")) {
	        				kt1.docDSKT();
							load_khoathi();
							
//		        			txt_makhoathi.setText("");
//		        			txt_tenkhoathi.setText("");
//		        			txt_ngaythi.setText("");
						} catch (SQLException e1) {
							
							JOptionPane.showMessageDialog(frame, "sai dinh dang ngay yeu cau nhap lai","Error Title", JOptionPane.ERROR_MESSAGE);
						}
//	        			 JOptionPane.showMessageDialog(frame, "Vui long nhap ma khoa thi","Error Title", JOptionPane.ERROR_MESSAGE);
	        			
		           }
		            
		        
		        } 
			}

		});
		
		JLabel lblNewLabel = new JLabel("T\u00EAn kh\u00F3a thi");
		
		JLabel lblNewLabel_1 = new JLabel("Ng\u00E0y thi");
		
		txt_tenkhoathi = new JTextField();
		txt_tenkhoathi.setColumns(10);
		
		txt_ngaythi = new JTextField();
		txt_ngaythi.setColumns(10);
		
		tb_khoathi = new JTable();
		tb_khoathi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 clickTable();
			}
		});
//		   tb_khoathi.addMouseListener((MouseListener) new MouseAdapter() {
//	            @Override
//	            public void mouseClicked(MouseEvent e) {
//	                clickTable();
////	                super.mouseClicked(e);
//	            }
//	        });
	
		load_khoathi();
		
		JLabel lblNewLabel_2 = new JLabel("T\u1EA1o kh\u00F3a thi");
		
		lblNewLabel_3 = new JLabel("M\u00E3 kh\u00F3a thi");
		
		txt_makhoathi1 = new JTextField();
		txt_makhoathi1.setEditable(false);
		txt_makhoathi1.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Tr\u00ECnh \u0111\u1ED9");
		
		txt_trinhdo = new JTextField();
		txt_trinhdo.setColumns(10);
		
		tb_phongthi = new JTable();
		load_phongthi();
//		tb_phongthi.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//			}
//		});
//		
		JLabel lblNewLabel_6 = new JLabel("T\u1EA1o ph\u00F2ng thi");
		
		JButton btn_taophong = new JButton("T\u1EA1o ph\u00F2ng thi");
		btn_taophong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int k=0;
				
	        	BLL_phongthi pt1=new BLL_phongthi();
	        	try {
					pt1.docDSPT();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				DTO_phongthi pt = new DTO_phongthi();
				JFrame frame = new JFrame("JOptionPane showMessageDialog example");
				 if (txt_makhoathi1.getText().equals("")) {
		        	 JOptionPane.showMessageDialog(frame, "Vui long chon ma khoa thi","Error Title", JOptionPane.ERROR_MESSAGE);}
		        	 else
				 if (txt_mapt.getText().equals("")) {
		        	 JOptionPane.showMessageDialog(frame, "Vui long nhap ma phong thi","Error Title", JOptionPane.ERROR_MESSAGE);}
		        	
		        else if(txt_magiamthi1.getText().equals("")) {
		        	JOptionPane.showMessageDialog(frame, "Vui long nhap ma giam thi 1","Error Title", JOptionPane.ERROR_MESSAGE);
		        }
		        else if(txt_magiamthi2.getText().equals("")) {
		        	JOptionPane.showMessageDialog(frame, "Vui long nhap ma giam thi 2","Error Title", JOptionPane.ERROR_MESSAGE);
		        }
		        else if(txt_magiamthi2.getText().equalsIgnoreCase(txt_magiamthi1.getText())) {
		        	JOptionPane.showMessageDialog(frame, "2 ma giam thi khong duoc trung nhau","Error Title", JOptionPane.ERROR_MESSAGE);
		        }
				 
		        else if(txt_trinhdo.getText().equals("")) {
		        	JOptionPane.showMessageDialog(frame, "Vui long nhap trinh do","Error Title", JOptionPane.ERROR_MESSAGE);
		        }
		        else if((txt_trinhdo.getText().equalsIgnoreCase("A2"))||(txt_trinhdo.getText().equalsIgnoreCase("B1"))) 
		        	
		        	{
		        	
		        	for (DTO_phongthi ptt : BLL_phongthi.dspt) {
		        		
		        		if(ptt.maphongthi.equals(txt_mapt.getText())) 
		        			k=k+1;
		        		}
		        	
				    
		           if(k>0)   JOptionPane.showMessageDialog(frame, "Ma phong thi da co yeu cau nhap lai","Error Title", JOptionPane.ERROR_MESSAGE);
		           else if(k==0) {
		        	   try {
		        		   
						if(pt1.docMAgiamthi(txt_magiamthi1.getText()).equalsIgnoreCase("sai"))
							   JOptionPane.showMessageDialog(frame, "khong co ma giam thi nay","Error Title", JOptionPane.ERROR_MESSAGE);
						   else {
							   if(pt1.docMAgiamthi(txt_magiamthi2.getText()).equalsIgnoreCase("sai"))
								   JOptionPane.showMessageDialog(frame, "khong co ma giam thi nay","Error Title", JOptionPane.ERROR_MESSAGE);
							   else {
								   if(pt1.docMAgiamthiTuphongthi(txt_magiamthi1.getText()).equalsIgnoreCase("sai"))
									   JOptionPane.showMessageDialog(frame, "ma giam thi da co yeu cau nhap lai","Error Title", JOptionPane.ERROR_MESSAGE);
								   else {
									   if(pt1.docMAgiamthiTuphongthi(txt_magiamthi2.getText()).equalsIgnoreCase("sai"))
										   JOptionPane.showMessageDialog(frame, "ma giam thi da co yeu cau nhap lai","Error Title", JOptionPane.ERROR_MESSAGE);
									   else {
						   pt.maphongthi = txt_mapt.getText();
						   int stt=(pt1.capnhatSTT(txt_trinhdo.getText(), txt_makhoathi1.getText()))+1;
						   String sothutu = null;
						   
							   if((stt>0)&&(stt<10)) sothutu="0"+String.valueOf(stt);
							   if((stt>=10)&&(stt<100)) sothutu=String.valueOf(stt);
						    pt.tenphongthi = txt_trinhdo.getText()+"P"+sothutu;
						    pt.makt = txt_makhoathi1.getText();
						    pt.magt1=txt_magiamthi1.getText();
						    pt.magt2=txt_magiamthi2.getText();
						    pt.sothisinh=0;
						   
							pt1.ThemPT(pt);
						   
							try {
								pt1.docDSPT();
								load_phongthi();
							} catch (SQLException e1) {
								
								System.out.print(e1.getMessage());
							}
//	        			 JOptionPane.showMessageDialog(frame, "Vui long nhap ma khoa thi","Error Title", JOptionPane.ERROR_MESSAGE);
//							JOptionPane.showMessageDialog(frame, "Them thanh cong"," ", JOptionPane.INFORMATION_MESSAGE);
//							txt_mapt.setText("");
//							txt_stt.setText("");
//							txt_trinhdo.setText("");
         }}}}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}
		            
		        
		        } 
		        else JOptionPane.showMessageDialog(frame, "Nhập trình độ A2 hoặc B1","Error Title", JOptionPane.ERROR_MESSAGE);
			}

		});
		
		JButton btn_thoat = new JButton("Tho\u00E1t");
		btn_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 setVisible(false);
			}
		});
		
		JLabel lblNewLabel_7 = new JLabel("Mã phòng thi");
		
		txt_mapt = new JTextField();
		txt_mapt.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Ma giam thi 1");
		
		JLabel lblNewLabel_9 = new JLabel("Ma giam thi 2");
		
		txt_magiamthi2 = new JTextField();
		txt_magiamthi2.setColumns(10);
		
		txt_magiamthi1 = new JTextField();
		txt_magiamthi1.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(20)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lb_khoa, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addComponent(lblNewLabel_7, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
									.addComponent(lblNewLabel_8, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
									.addComponent(lblNewLabel_9)
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(30)
								.addComponent(btn_taokhoa)
								.addGap(20)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btn_taophong)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txt_makhoathi1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_makhoathi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_ngaythi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_tenkhoathi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_thoat, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_mapt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_magiamthi1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_magiamthi2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(tb_khoathi, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)
								.addComponent(tb_phongthi, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE))
							.addGap(38))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txt_trinhdo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lb_khoa)
								.addComponent(txt_makhoathi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(txt_tenkhoathi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(18)
									.addComponent(btn_taokhoa))
								.addComponent(txt_ngaythi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(tb_khoathi, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
					.addGap(21)
					.addComponent(lblNewLabel_6)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txt_makhoathi1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3))
							.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_7)
								.addComponent(txt_mapt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_8)
								.addComponent(txt_magiamthi1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(21)
									.addComponent(lblNewLabel_9))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(txt_magiamthi2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(25))
						.addComponent(tb_phongthi, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txt_trinhdo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_taophong)
						.addComponent(btn_thoat))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	 
		  private void load_khoathi() throws SQLException {
		        BLL_khoathi bll = new BLL_khoathi();
		        if (BLL_khoathi.dskt == null) {
		            bll.docDSKT();
		        }
		        Vector header = new Vector();
		        header.add("makt");
		        header.add("tenkt");
		        header.add("ngaythi");
//		        String []colsName = {"Mã khoathi", "Tên khoathi","ngaythi"};
//		        model.setColumnIdentifiers(colsName);
//		      
		        model = new DefaultTableModel(header,0);
		        model.addRow(header);
		        for (DTO_khoathi nv : BLL_khoathi.dskt) {
		            Vector row = new Vector();
		            row.add(nv.makt);
		     
		            row.add(nv.tenkt);
		          
		            row.add(nv.ngaythi);
		    
		            model.addRow(row);
		        }
		        tb_khoathi.setModel(model);
		    }
		  
		  private void load_phongthi() throws SQLException {
		        BLL_phongthi bll = new BLL_phongthi();
		        if (BLL_phongthi.dspt == null) {
		            bll.docDSPT();
		        }
		        Vector header = new Vector();
		        header.add("mapt");
		        header.add("tenpt");
		        header.add("makt");
		        header.add("Giam thi 1");
		        header.add("Giam thi 2");
		        header.add("sothisinh");

		        model = new DefaultTableModel(header,0);
		        model.addRow(header);
		        Comparator<DTO_phongthi> com=new Comparator<DTO_phongthi>() {
					
					@Override
					public int compare(DTO_phongthi o1, DTO_phongthi o2) {
						String name1=o1.makt;
						String name2=o2.makt;
						return name1.compareTo(name2);
					}
				};
		        Collections.sort(BLL_phongthi.dspt,com);
		        for (DTO_phongthi pt : BLL_phongthi.dspt) {
		            Vector row = new Vector();
		            row.add(pt.maphongthi);
		     
		            row.add(pt.tenphongthi);
		            row.add(pt.makt);
		            row.add(pt.magt1);
		            row.add(pt.magt2);
		            row.add(pt.sothisinh);
		    
		            model.addRow(row);
		        }
		        tb_phongthi.setModel(model);
		    }
		  private void clickTable() {

			        int Row = tb_khoathi.getSelectedRow();

			        String namesp = (String.valueOf(tb_khoathi.getValueAt(Row, 0)));
			        txt_makhoathi1.setText(namesp);
			        }
}
