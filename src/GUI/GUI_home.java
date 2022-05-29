package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class GUI_home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_home frame = new GUI_home();
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
	public GUI_home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		panel.setBackground(Color.blue);
		JButton btn_taophongthi = new JButton("Tao phong thi");
		btn_taophongthi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DANHSACHPHONGTHI frame;
				try {
					frame = new DANHSACHPHONGTHI();
					frame.setVisible(true);
				
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("Quan ly trung tam ngoai ngu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btn_nhapthongtin = new JButton("Nhap thong tin thi sinh");
		btn_nhapthongtin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_thongtinthisinh frame;
				try {
					frame = new GUI_thongtinthisinh();
					frame.setVisible(true);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btn_xepphongthi = new JButton("Xep phong thi va hien thi danh sach thi sinh");
		btn_xepphongthi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_chiaphongthi frame = new GUI_chiaphongthi();
				frame.setVisible(true);
				
				
			}
		});
		
		JButton btn_timkiem = new JButton("Tim kiem thong tin thi sinh");
		btn_timkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_timkiemthongtints frame = new GUI_timkiemthongtints();
				frame.setVisible(true);
				
			}
		});
		
		JButton btn_nhapdiem = new JButton("Nhap diem thi");
		btn_nhapdiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_nhapdiem frame = new GUI_nhapdiem();
				frame.setVisible(true);
				
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btn_nhapthongtin, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
						.addComponent(btn_timkiem, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
						.addComponent(btn_nhapdiem, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
						.addComponent(btn_taophongthi, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btn_xepphongthi, GroupLayout.PREFERRED_SIZE, 218, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGap(10)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
					.addGap(27))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(267)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(281, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btn_taophongthi, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btn_nhapthongtin, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btn_xepphongthi, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btn_timkiem, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btn_nhapdiem, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addGap(18))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
