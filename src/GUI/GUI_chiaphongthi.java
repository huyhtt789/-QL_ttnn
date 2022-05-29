package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.BLL_chiaphongthi;
import BLL.BLL_khoathi;
import BLL.BLL_nhapdiem;
import BLL.BLL_phongthi;
import DAL.Connect;
import DTO.DTO_chiaphongthi;
import DTO.DTO_khoathi;
import DTO.DTO_phongthi;
import DTO.DTO_thisinh;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI_chiaphongthi extends JFrame {
	Connect a = new Connect();
    Connection conn = a.getConnection();
    DefaultTableModel model;
    private String so;
	private JPanel contentPane;
	private JTextField txt_mats;
	private JTextField txt_maphongthi;
	private JTable tb_chiaphongthi;
	private JTable tb_danhsachthisinh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_chiaphongthi frame = new GUI_chiaphongthi();
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
	public GUI_chiaphongthi() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 th\u00ED sinh");
		
		JLabel lblNewLabel_1 = new JLabel("Chia phong thi");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2 = new JLabel("M\u00E3 ph\u00F2ng thi");
		
		txt_mats = new JTextField();
		txt_mats.setColumns(10);
		
		txt_maphongthi = new JTextField();
		txt_maphongthi.setColumns(10);
		
		tb_chiaphongthi = new JTable();
		tb_chiaphongthi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 clickTable();
			}
		});
		try {
			load_chiaphongthi();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton btn_them = new JButton("Th\u00EAm");
		btn_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int k=0;
				BLL_chiaphongthi pt1=new BLL_chiaphongthi();
	        	try {
					pt1.docDSchiaphongthi();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				DTO_chiaphongthi pt = new DTO_chiaphongthi();
				JFrame frame = new JFrame("JOptionPane showMessageDialog example");
				 if (txt_mats.getText().equals("")) {
		        	 JOptionPane.showMessageDialog(frame, "Vui long nhap ma thí sinh","Error Title", JOptionPane.ERROR_MESSAGE);}
		        	 else
		        if (txt_maphongthi.getText().equals("")) {
		        	 JOptionPane.showMessageDialog(frame, "Vui long nhap mã phong thi","Error Title", JOptionPane.ERROR_MESSAGE);
		        } 
		        else {
		        	
		        	for (DTO_chiaphongthi ptt : BLL_chiaphongthi.dsts) {
		        		
		        		if(ptt.mats.equals(txt_mats.getText())) 
		        			k=k+1;
		        		}
		        	
				    
		           if(k>0)   JOptionPane.showMessageDialog(frame, "Đã nhập mã sinh viên này rồi yêu cầu nhập lại","Error Title", JOptionPane.ERROR_MESSAGE);
		           else if(k==0) {
		        	   try {
		        		   if(pt1.docmathisinh(txt_mats.getText()).equalsIgnoreCase("sai")) {
//		        			   System.out.println(pt1.docmathisinh(txt_mats.getText()));
		        			   JOptionPane.showMessageDialog(frame, "Khong co ma thi sinh nay","Error Title", JOptionPane.ERROR_MESSAGE);}
		        		   else {
		        			   if(pt1.docmaphongthi(txt_maphongthi.getText()).equalsIgnoreCase("sai")) {
//			        			   System.out.println(pt1.docmathisinh(txt_mats.getText()));
			        			   JOptionPane.showMessageDialog(frame, "Khong co ma phong thi nay","Error Title", JOptionPane.ERROR_MESSAGE);}
		        			  
			        		   else {
			        			   String sts=pt1.LoaiPhongthi(txt_maphongthi.getText());
		        		   if(sts.equalsIgnoreCase("huy")) JOptionPane.showMessageDialog(frame, "Phòng thi đã nhiều hơn 35 người","Error Title", JOptionPane.ERROR_MESSAGE);
						   else {
							   try {
							pt.mats = txt_mats.getText();
						    pt.mapt = txt_maphongthi.getText();
						    String k1;
							
							k1 = pt1.doctenphongthi(txt_maphongthi.getText());
							int sothutu=(pt1.capnhatSTT(k1,txt_maphongthi.getText()))+1;
							String stt = null;
							if(sothutu<10) stt="00"+String.valueOf(sothutu);
							else if((sothutu>=10) && (sothutu<100)) stt="0"+String.valueOf(sothutu);
							else if(sothutu>=100) stt=String.valueOf(sothutu);
							
						    pt.sbd = k1+stt;
						    pt.nghe=0;
						    pt.noi=0;
						    pt.doc=0;
						    pt.viet=0;
							pt1.ThemThisinh(pt);
							int sts1=Integer.valueOf(sts)+1;
							
							pt1.updateSothisinh(txt_maphongthi.getText(), sts1);
							
								load_chiaphongthi();
							} catch (SQLException e1) {
								 JOptionPane.showMessageDialog(frame, e1.getMessage(),"Error Title", JOptionPane.ERROR_MESSAGE);
								
							}
//	        			 JOptionPane.showMessageDialog(frame, "Vui long nhap ma khoa thi","Error Title", JOptionPane.ERROR_MESSAGE);
							JOptionPane.showMessageDialog(frame, "Them thanh cong"," ", JOptionPane.INFORMATION_MESSAGE);
							txt_mats.setText("");
//	        			txt_maphongthi.setText("");
//	        			txt_sothutu.setText("");
         }}}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}
		            
		        
		        } 
			}

		});
		
		JButton btn_danhsachthisinh = new JButton("Danh sach th\u00ED sinh");
		btn_danhsachthisinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 BLL_chiaphongthi bll = new BLL_chiaphongthi();
				 try {
					 bll.docDSthisinh(txt_maphongthi.getText());
					load_danhsachthisinh();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		tb_danhsachthisinh = new JTable();
		
		JButton btn_xoa = new JButton("Xoa");
		btn_xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("JOptionPane showMessageDialog example");
				BLL_chiaphongthi pt1=new BLL_chiaphongthi();
				try {
				if(txt_mats.getText().equalsIgnoreCase("")) 
					JOptionPane.showMessageDialog(frame, "Chua chon ma thi sinh can xoa"," ", JOptionPane.ERROR_MESSAGE);
				else
					{pt1.Xoa(txt_mats.getText());
					JOptionPane.showMessageDialog(frame, "Xoa thanh cong"," ", JOptionPane.INFORMATION_MESSAGE);
						int t=Integer.parseInt(pt1.LoaiPhongthi(txt_maphongthi.getText()));
						t=t-1;
						pt1.updateSothisinh(txt_maphongthi.getText(), t);
						pt1.docDSchiaphongthi();
						load_chiaphongthi();
					
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(314)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(351, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(tb_danhsachthisinh, GroupLayout.PREFERRED_SIZE, 721, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(38)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btn_danhsachthisinh, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txt_maphongthi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txt_mats, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btn_them, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btn_xoa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED, 45, GroupLayout.PREFERRED_SIZE)
							.addComponent(tb_chiaphongthi, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE)))
					.addGap(24))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(txt_mats, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(38)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(txt_maphongthi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(36)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn_them)
								.addComponent(btn_xoa))
							.addGap(18)
							.addComponent(btn_danhsachthisinh))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(tb_chiaphongthi, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))
					.addGap(44)
					.addComponent(tb_danhsachthisinh, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	 private void load_chiaphongthi() throws SQLException {
	        BLL_chiaphongthi bll = new BLL_chiaphongthi();
	        if (BLL_chiaphongthi.dsts == null) {
	            bll.docDSchiaphongthi();
	        }
	        Vector header = new Vector();
	        header.add("Mã thí sinh");
	        header.add("Mã phòng thi");
	        header.add("Số báo danh");

   
	        model = new DefaultTableModel(header,0);
	        model.addRow(header);
	        Comparator<DTO_chiaphongthi> com=new Comparator<DTO_chiaphongthi>() {
				
				@Override
				public int compare(DTO_chiaphongthi o1, DTO_chiaphongthi o2) {
					String name1=o1.mapt;
					String name2=o2.mapt;
					return name1.compareTo(name2);
				}
			};
	        Collections.sort(BLL_chiaphongthi.dsts,com);
	        
	        for (DTO_chiaphongthi nv : BLL_chiaphongthi.dsts) {
	            Vector row = new Vector();
	            row.add(nv.mats);
	     
	            row.add(nv.mapt);
	          
	            row.add(nv.sbd);
	    
	            model.addRow(row);
	        }
	        tb_chiaphongthi.setModel(model);
	    }
	 
	 //load danh sach thi sinh
	private void load_danhsachthisinh() throws SQLException {
	        BLL_chiaphongthi bll = new BLL_chiaphongthi();
	        if (BLL_chiaphongthi.dsts1 == null) {
	            bll.docDSthisinh(txt_maphongthi.getText());
	        }
	        Vector header = new Vector();
	        header.add("Mã thí sinh");
	        header.add("Mã phòng thi");
	        header.add("Số báo danh");
	        header.add("Ho Ten");
	        header.add("Gioi tinh");

	        model = new DefaultTableModel(header,0);
	        model.addRow(header);
	        for (DTO_thisinh nv : BLL_chiaphongthi.dsts1) {
	            Vector row = new Vector();
	            row.add(nv.mathisinh);
	     
	            row.add(txt_maphongthi.getText());
	          
	            row.add(nv.sbd);
	            row.add(nv.hoten);
	            row.add(nv.gioitinh);
	    
	            model.addRow(row);
	        }
	        tb_danhsachthisinh.setModel(model);
	    }
	  private void clickTable() {

	        int Row = tb_chiaphongthi.getSelectedRow();

	        String mats = (String.valueOf(tb_chiaphongthi.getValueAt(Row, 0)));
	        String mapt = (String.valueOf(tb_chiaphongthi.getValueAt(Row, 1)));
	        so = (String.valueOf(tb_chiaphongthi.getValueAt(Row, 2)));
	        txt_mats.setText(mats);
	        txt_maphongthi.setText(mapt);
	        }
}
