package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.BLL_chiaphongthi;
import BLL.BLL_nhapdiem;
import BLL.BLL_phongthi;
import DAL.Connect;
import DTO.DTO_chiaphongthi;
import DTO.DTO_phongthi;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class GUI_nhapdiem extends JFrame {
	Connect a = new Connect();
    Connection conn = a.getConnection();
    DefaultTableModel model;
	private JPanel contentPane;
	private JTextField txt_mapt;
	private JTextField txt_mats;
	private JTable tb_mapt;
	private JTable tb_mats;
	private JTextField txt_nghe;
	private JTextField txt_doc;
	private JTextField txt_noi;
	private JTextField txt_viet;
	private JTable tb_diem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_nhapdiem frame = new GUI_nhapdiem();
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
	public GUI_nhapdiem() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Nhap diem");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Ma phong thi");
		
		JLabel lblNewLabel_2 = new JLabel("Ma thi sinh");
		
		txt_mapt = new JTextField();
		txt_mapt.setColumns(10);
		txt_mapt.setEditable(false);
		
		txt_mats = new JTextField();
		txt_mats.setEditable(false);
		txt_mats.setColumns(10);
		
		tb_mapt = new JTable();
		tb_mapt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickTable();
			}
		});
		try {
			load_phongthi();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tb_mats = new JTable();
		tb_mats.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickTable2();
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("Nghe");
		
		JLabel lblNewLabel_4 = new JLabel("\u0110\u1ECDc");
		
		JLabel lblNewLabel_5 = new JLabel("N\u00F3i");
		
		JLabel lblNewLabel_6 = new JLabel("Vi\u1EBFt");
		
		txt_nghe = new JTextField();
		txt_nghe.setColumns(10);
		
		txt_doc = new JTextField();
		txt_doc.setColumns(10);
		
		txt_noi = new JTextField();
		txt_noi.setColumns(10);
		
		txt_viet = new JTextField();
		txt_viet.setColumns(10);
		
		JButton btn_nhap = new JButton("Nh\u1EADp \u0111i\u1EC3m");
		btn_nhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("JOptionPane showMessageDialog example");
				BLL_nhapdiem bl=new BLL_nhapdiem();
				if(txt_mats.getText().equals("")) JOptionPane.showMessageDialog(frame, "Vui long chon ma thi sinh de nhap diem","Error Title", JOptionPane.ERROR_MESSAGE);
				else {
					float nghe,noi,doc,viet;
					if(txt_nghe.getText().equals("")) nghe=0; else nghe=Float.parseFloat(txt_nghe.getText());
					if(txt_noi.getText().equals("")) noi=0; else noi=Float.parseFloat(txt_noi.getText());
					if(txt_doc.getText().equals("")) doc=0; else doc=Float.parseFloat(txt_doc.getText());
					if(txt_viet.getText().equals("")) viet=0; else viet=Float.parseFloat(txt_viet.getText());
				bl.updateDiem(txt_mats.getText(), nghe,noi, doc, viet);
				try {
					bl.docDSchiaphongthi();
					load_diem();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}}
		});
		
		tb_diem = new JTable();
		try {
			load_diem();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txt_nghe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_mats, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_mapt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_doc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(91)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(346, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(46)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(tb_mapt, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
									.addComponent(tb_mats, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
									.addGap(308))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
									.addGap(47)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txt_viet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(txt_noi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(76)
											.addComponent(btn_nhap)))
									.addGap(155))))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(83)
					.addComponent(tb_diem, GroupLayout.PREFERRED_SIZE, 589, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(104, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(txt_mapt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(txt_mats, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(tb_mapt, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addComponent(tb_mats, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(txt_nghe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_noi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_nhap)
						.addComponent(lblNewLabel_5))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_6)
						.addComponent(txt_doc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_viet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(tb_diem, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(90, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	  private void load_phongthi() throws SQLException {
	        BLL_nhapdiem bll = new BLL_nhapdiem();
	        if (BLL_nhapdiem.dspt == null) {
	            bll.docDSphongthi();
	        }
	        Vector header = new Vector();
	        header.add("mapt");
	       
	        
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
	        Collections.sort(BLL_nhapdiem.dspt,com);
	        for (DTO_chiaphongthi pt : BLL_nhapdiem.dspt) {
	            Vector row = new Vector();
	            row.add(pt.mapt);
	     
	            model.addRow(row);
	        }
	      
	        tb_mapt.setModel(model);
	    }
	  
	  private void load_mats() throws SQLException {
	        BLL_nhapdiem bll = new BLL_nhapdiem();
	        if (BLL_nhapdiem.dsts == null) {
	            bll.docDSthisinh(txt_mapt.getText());
	        }
	        Vector header = new Vector();
	        header.add("ma thi sinh");
	       
	        
	        model = new DefaultTableModel(header,0);
	        model.addRow(header);
//	        Comparator<DTO_chiaphongthi> com=new Comparator<DTO_chiaphongthi>() {
//				
//				@Override
//				public int compare(DTO_chiaphongthi o1, DTO_chiaphongthi o2) {
//					String name1=o1.mapt;
//					String name2=o2.mapt;
//					return name1.compareTo(name2);
//				}
//			};
//	        Collections.sort(BLL_nhapdiem.dspt,com);
	        for (DTO_chiaphongthi pt : BLL_nhapdiem.dsts) {
	            Vector row = new Vector();
	            row.add(pt.mats);
	     
	            model.addRow(row);
	        }
	      
	        tb_mats.setModel(model);
	    }
	  private void clickTable() {

	        int Row = tb_mapt.getSelectedRow();

	        String mapt = (String.valueOf(tb_mapt.getValueAt(Row, 0)));
	      
	        txt_mapt.setText(mapt);
	        try {
	        	BLL_nhapdiem bl=new BLL_nhapdiem();
	        	bl.docDSthisinh(txt_mapt.getText());
				load_mats();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        }
	  private void clickTable2() {

	        int Row = tb_mats.getSelectedRow();

	        String mats = (String.valueOf(tb_mats.getValueAt(Row, 0)));
	      
	        txt_mats.setText(mats);
	       
	        }
	  private void load_diem() throws SQLException {
	        BLL_nhapdiem bll = new BLL_nhapdiem();
	        if (BLL_nhapdiem.dsdiem == null) {
	            bll.docDSchiaphongthi();
	        }
	        Vector header = new Vector();
	        header.add("Mã thí sinh");
	       
	        header.add("Số báo danh");
	        header.add("Nghe");
	        header.add("Noi");
	        header.add("Doc");
	        header.add("Viet");

 
	        model = new DefaultTableModel(header,0);
	        model.addRow(header);
	        for (DTO_chiaphongthi nv : BLL_nhapdiem.dsdiem) {
	            Vector row = new Vector();
	            row.add(nv.mats);
	     
	            row.add(nv.sbd);
	            row.add(nv.nghe);
	            row.add(nv.noi);
	            row.add(nv.doc);
	            row.add(nv.viet);
	    
	            model.addRow(row);
	        }
	        tb_diem.setModel(model);
	    }
}
