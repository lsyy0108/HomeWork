package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import controller.porder.PorderManager;
import model.Member;
import service.MemberService;
import util.TimeUtil;
import util.Tool;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class LoginSuccess extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSuccess frame = new LoginSuccess();
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
	public LoginSuccess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("進入報名系統");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PorderManager porderManager=new PorderManager();
				porderManager.setVisible(true);
				dispose();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		btnNewButton.setBounds(10, 118, 414, 143);
		contentPane.add(btnNewButton);
		
		JLabel showMessage = new JLabel("");
		showMessage.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		showMessage.setBounds(10, 10, 225, 98);
		contentPane.add(showMessage);
		Member member=(Member)Tool.readFile("member.txt");
		String show=member.getName();
		
		showMessage.setText(show);
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("歡迎回來");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		lblNewLabel_1.setBounds(245, 10, 179, 98);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_2.setBounds(254, 0, 182, 56);
		contentPane.add(lblNewLabel_2);
		Timer timer = new Timer(1000, e -> {
		    String now = TimeUtil.getCurrentTime();
		    lblNewLabel_2.setText(now);
		});
		timer.start();

	}

}

