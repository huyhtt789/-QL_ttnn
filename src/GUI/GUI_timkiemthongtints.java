package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.BLL_khoathi;
import BLL.BLL_timkiem;
import DAL.Connect;
import DTO.DTO_chiaphongthi;
import DTO.DTO_khoathi;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class GUI_timkiemthongtints extends JFrame {
	Connect a = new Connect();
    Connection conn = a.getConnection();
    DefaultTableModel model;

	private JPanel contentPane;
	private JTextField txt_ten;
	private JTextField txt_sdt;
	private JTable tbl_thongtints;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_timkiemthongtints frame = new GUI_timkiemthongtints();
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
	public GUI_timkiemthongtints() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Tim kiem thong tin sinh vien");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Ten thi sinh");
		
		JLabel lblNewLabel_2 = new JLabel("So dien thoai");
		
		txt_ten = new JTextField();
		txt_ten.setColumns(10);
		
		txt_sdt = new JTextField();
		txt_sdt.setColumns(10);
		
		JButton btn_tim = new JButton("Tim kiem");
		btn_tim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("JOptionPane showMessageDialog example");
				if((txt_ten.getText().equalsIgnoreCase(""))&&(txt_sdt.getText().equals("")))  
						JOptionPane.showMessageDialog(frame, "Vui long nhap tu can tim","Error Title", JOptionPane.ERROR_MESSAGE);
				else {
					try {
						BLL_timkiem bl=new BLL_timkiem();
						bl.docDSTS(txt_ten.getText(), txt_sdt.getText());
						load_thisinh();
					} catch (SQLException e1) {
					
						System.out.println(e1.getMessage());
					}
				}
			}
		});
		
		tbl_thongtints = new JTable();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(267)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(37)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
									.addGap(38)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txt_sdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txt_ten, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addComponent(tbl_thongtints, GroupLayout.PREFERRED_SIZE, 695, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(51)
							.addComponent(btn_tim)))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txt_ten, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(txt_sdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(btn_tim)
					.addGap(29)
					.addComponent(tbl_thongtints, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(67, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private void load_thisinh() throws SQLException {
        BLL_timkiem bll = new BLL_timkiem();
        if (BLL_timkiem.dsts == null) {
            bll.docDSTS(txt_ten.getText(), txt_sdt.getText());
        }
        Vector header = new Vector();
        header.add("Ho ten");
        header.add("So bao danh");
        header.add("Ma phong thi");
      
        header.add("So dien thoai");
        header.add("Nghe");
        header.add("Noi");
        header.add("Doc");
        header.add("Viet");
//        String []colsName = {"Mã khoathi", "Tên khoathi","ngaythi"};
//        model.setColumnIdentifiers(colsName);
//      
        model = new DefaultTableModel(header,0);
        model.addRow(header);
        for (DTO_chiaphongthi nv : BLL_timkiem.dsts) {
            Vector row = new Vector();
            row.add(nv.hoten);
     
            row.add(nv.sbd);
          
            row.add(nv.mapt);
         
            row.add(nv.sdt);
            row.add(nv.nghe);
            row.add(nv.noi);
            row.add(nv.doc);
            row.add(nv.viet);
    
            model.addRow(row);
        }
        tbl_thongtints.setModel(model);
    }

}
