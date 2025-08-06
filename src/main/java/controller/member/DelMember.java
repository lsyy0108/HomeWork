package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Login;
import model.Member;
import service.impl.MemberServiceImpl;
import util.TimeUtil;

import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DelMember extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField delmember;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DelMember frame = new DelMember();
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
	public DelMember() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		delmember = new JTextField();
		delmember.setForeground(new Color(192, 192, 192));
		delmember.setBounds(58, 65, 197, 36);
		contentPane.add(delmember);
		delmember.setColumns(10);
		
		JButton btnNewButton = new JButton("確認刪除");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = delmember.getText().trim();
		        
		        MemberServiceImpl msi = new MemberServiceImpl();
		        boolean success = msi.deleteMember(username); 

			    Login login=new Login();
			    login.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(58, 142, 198, 55);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("請輸入欲刪除帳號");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel.setBounds(58, 24, 197, 31);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1.setBounds(244, 207, 182, 56);
		contentPane.add(lblNewLabel_1);
		Timer timer = new Timer(1000, e -> {
		    String now = TimeUtil.getCurrentTime();
		    lblNewLabel_1.setText(now);
		});
		timer.start();

	}
}
