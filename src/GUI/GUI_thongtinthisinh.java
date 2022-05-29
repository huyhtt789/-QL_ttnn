package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.BLL_phongthi;
import BLL.BLL_thisinh;
import DAL.Connect;
import DTO.DTO_phongthi;
import DTO.DTO_thisinh;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_thongtinthisinh extends JFrame {
	Connect a = new Connect();
    Connection conn = a.getConnection();
    DefaultTableModel model;

	private JPanel contentPane;
	private JTextField txt_mats;
	private JTextField txt_hoten;
	private JTextField txt_gioitinh;
	private JTextField txt_email;
	private JTextField txt_ngaysinh;
	private JTextField txt_noisinh;
	private JTextField txt_cmnd;
	private JTextField txt_sdt;
	private JTextField txt_ngaycap;
	private JTextField txt_noicap;
	private JTable tb_thisinh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_thongtinthisinh frame = new GUI_thongtinthisinh();
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
	public GUI_thongtinthisinh() throws SQLException {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 th\u00ED sinh");
		
		JLabel lblNewLabel_1 = new JLabel("Ng\u00E0y sinh");
		
		JLabel lblNewLabel_2 = new JLabel("H\u1ECD t\u00EAn");
		
		JLabel lblNewLabel_3 = new JLabel("Gi\u1EDBi t\u00EDnh");
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		
		JLabel lblNewLabel_5 = new JLabel("N\u01A1i sinh");
		
		JLabel lblNewLabel_6 = new JLabel("CMND");
		
		JLabel lblNewLabel_7 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		
		JLabel lblNewLabel_8 = new JLabel("Ng\u00E0y c\u1EA5p");
		
		JLabel lblNewLabel_9 = new JLabel("N\u01A1i c\u1EA5p");
		
		txt_mats = new JTextField();
		txt_mats.setColumns(10);
		
		txt_hoten = new JTextField();
		txt_hoten.setColumns(10);
		
		txt_gioitinh = new JTextField();
		txt_gioitinh.setColumns(10);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		
		txt_ngaysinh = new JTextField();
		txt_ngaysinh.setColumns(10);
		
		txt_noisinh = new JTextField();
		txt_noisinh.setColumns(10);
		
		txt_cmnd = new JTextField();
		txt_cmnd.setColumns(10);
		
		txt_sdt = new JTextField();
		txt_sdt.setColumns(10);
		
		txt_ngaycap = new JTextField();
		txt_ngaycap.setColumns(10);
		
		txt_noicap = new JTextField();
		txt_noicap.setColumns(10);
		
		JButton btn_them = new JButton("Th\u00EAm");
		btn_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int k=0;
//				for (DTO_thisinh ptt : BLL_thisinh.dsts) {
//					System.out.println(ptt.mathisinh);
//				}
	        	BLL_thisinh ts1=new BLL_thisinh();
	        	try {
					ts1.docDSTS();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				DTO_thisinh pt = new DTO_thisinh();
				JFrame frame = new JFrame("JOptionPane showMessageDialog example");
				 if (txt_mats.getText().equals("")) {
		        	 JOptionPane.showMessageDialog(frame, "Vui long nhap ma thi sinh","Error Title", JOptionPane.ERROR_MESSAGE);}
		        	 else
		        if (txt_hoten.getText().equals("")) {
		        	 JOptionPane.showMessageDialog(frame, "Vui long nhap ho ten","Error Title", JOptionPane.ERROR_MESSAGE);
		        } else if(txt_gioitinh.getText().equals("")) {
		        	JOptionPane.showMessageDialog(frame, "Vui long nhap gioi tinh","Error Title", JOptionPane.ERROR_MESSAGE);
		        }
		        else if(txt_ngaysinh.getText().equals("")) {
		        	JOptionPane.showMessageDialog(frame, "Vui long nhap ngay sinh","Error Title", JOptionPane.ERROR_MESSAGE);
		        }
		        else if(txt_noisinh.getText().equals("")) {
		        	JOptionPane.showMessageDialog(frame, "Vui long nhap noi sinh","Error Title", JOptionPane.ERROR_MESSAGE);
		        }
		        else if(txt_cmnd.getText().equals("")) {
		        	JOptionPane.showMessageDialog(frame, "Vui long nhap cmnd","Error Title", JOptionPane.ERROR_MESSAGE);
		        }
		        else if(txt_ngaycap.getText().equals("")) {
		        	JOptionPane.showMessageDialog(frame, "Vui long nhap ngay cap","Error Title", JOptionPane.ERROR_MESSAGE);
		        }
		        else if(txt_noicap.getText().equals("")) {
		        	JOptionPane.showMessageDialog(frame, "Vui long nhap noi cap","Error Title", JOptionPane.ERROR_MESSAGE);
		        }
		        else if(txt_sdt.getText().equals("")) {
		        	JOptionPane.showMessageDialog(frame, "Vui long nhap so dien thoai","Error Title", JOptionPane.ERROR_MESSAGE);
		        }
		        else if(txt_email.getText().equals("")) {
		        	JOptionPane.showMessageDialog(frame, "Vui long nhap email","Error Title", JOptionPane.ERROR_MESSAGE);
		        }
		        else {
		        	
		        	for (DTO_thisinh ptt : BLL_thisinh.dsts) {
		        		
		        		if(ptt.mathisinh.equals(txt_mats.getText())) 
		        			k=k+1;
		        	
		        		}
		        	
				    
		           if(k>0)   JOptionPane.showMessageDialog(frame, "ma thi sinh da co","Error Title", JOptionPane.ERROR_MESSAGE);
		           else if(k==0) {
		        	   pt.mathisinh = txt_mats.getText();
	      		        pt.hoten = txt_hoten.getText();
	      		        pt.gioitinh = txt_gioitinh.getText();
	      		        pt.ngaysinh = txt_ngaysinh.getText();
	      		        pt.noisinh = txt_noisinh.getText();
	      		        pt.cmnd = txt_cmnd.getText();
	      		        pt.ngaycap = txt_ngaycap.getText();
	      		        pt.noicap = txt_noicap.getText();
	      		        pt.sdt = txt_sdt.getText();
	      		        pt.email = txt_email.getText();
	      		      
	        			
	        			try {
	        				ts1.ThemTS(pt);
	        				ts1.docDSTS();
							load_thisinh();
						} catch (SQLException e1) {
							
							System.out.print(e1.getMessage());
						}
//	        			 JOptionPane.showMessageDialog(frame, "Vui long nhap ma khoa thi","Error Title", JOptionPane.ERROR_MESSAGE);
	        		
	        		
//	        			 txt_mats.setText("");
//		      		     txt_hoten.setText("");
//		      		     txt_gioitinh.setText("");
//		      		     txt_ngaysinh.setText("");
//		      		     txt_noisinh.setText("");
//		      		     txt_cmnd.setText("");
//		      		     txt_ngaycap.setText("");
//		      		     txt_noicap.setText("");
//		      		     txt_sdt.setText("");
//		      		     txt_email.setText("");
		           }
		            
		        
		        } 
			}

		});
		
		JButton btn_sua = new JButton("S\u1EEDa");
		
		JButton btn_xoa = new JButton("X\u00F3a");
		
		tb_thisinh = new JTable();
		load_thisinh();
		
		JLabel lblNewLabel_10 = new JLabel("Th\u00F4ng tin th\u00ED sinh");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(btn_them)
									.addGap(40))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(21)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblNewLabel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(txt_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txt_mats, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
										.addComponent(txt_hoten, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
										.addComponent(txt_gioitinh, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(21)
									.addComponent(btn_sua, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(62)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(12)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txt_noisinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txt_ngaysinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txt_cmnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(lblNewLabel_8, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblNewLabel_9, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
										.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(txt_noicap, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txt_ngaycap, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txt_sdt, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(82)
									.addComponent(btn_xoa, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(258)
							.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(tb_thisinh, GroupLayout.PREFERRED_SIZE, 758, GroupLayout.PREFERRED_SIZE)))
					.addGap(8))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_8)
						.addComponent(txt_ngaycap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_mats, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(txt_ngaysinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_9)
						.addComponent(txt_noicap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_hoten, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(txt_noisinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_7)
						.addComponent(txt_sdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_gioitinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6)
						.addComponent(txt_cmnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(txt_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_them)
						.addComponent(btn_xoa)
						.addComponent(btn_sua))
					.addGap(18)
					.addComponent(tb_thisinh, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	  private void load_thisinh() throws SQLException {
	        BLL_thisinh bll = new BLL_thisinh();
	        if (BLL_thisinh.dsts == null) {
	            bll.docDSTS();
	        }
	        Vector header = new Vector();
	        header.add("Mã thí sinh");
	        header.add("Họ tên");
	        header.add("Giới tính");
	        header.add("Ngày sinh");
	        header.add("Nơi sinh");
	        header.add("CMND");
	        header.add("Ngày cấp");
	        header.add("Nơi cấp");
	        header.add("SDT");
	        header.add("Email");
      
	        model = new DefaultTableModel(header,0);
	        model.addRow(header);
	        for (DTO_thisinh nv : BLL_thisinh.dsts) {
	            Vector row = new Vector();
	            row.add(nv.mathisinh);
	     
	            row.add(nv.hoten);
	          
	            row.add(nv.gioitinh);
	            row.add(nv.ngaysinh);
	            row.add(nv.noisinh);
	            row.add(nv.cmnd);
	            row.add(nv.ngaycap);
	            row.add(nv.noicap);
	            row.add(nv.sdt);
	            row.add(nv.email);
	            model.addRow(row);
	        }
	        tb_thisinh.setModel(model);
	    }
}
