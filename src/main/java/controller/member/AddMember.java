package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Login;
import model.Member;
import service.impl.MemberServiceImpl;
import util.TimeUtil;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AddMember extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField phone;
	private JLabel errorMessage;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMember frame = new AddMember();
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
	public AddMember() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel.setBounds(73, 129, 47, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1.setBounds(73, 175, 47, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密碼");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_2.setBounds(73, 221, 47, 36);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("地址");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_3.setBounds(73, 267, 47, 36);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("電話");
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_4.setBounds(73, 313, 47, 36);
		contentPane.add(lblNewLabel_4);
		
		name = new JTextField();
		name.setBounds(145, 129, 295, 36);
		contentPane.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(145, 175, 295, 36);
		contentPane.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(145, 221, 295, 36);
		contentPane.add(password);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(145, 267, 295, 36);
		contentPane.add(address);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(145, 313, 295, 36);
		contentPane.add(phone);
		
		JButton btnNewButton = new JButton("確定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Name=name.getText();
				String UserName=username.getText();
				String Password=password.getText();
				String Address=address.getText();
				String Phone=phone.getText();
				
				Member member=new Member(Name,UserName,Password,Address,Phone);
				
				if(new MemberServiceImpl().addMember(member))
				{
					AddMemberSuccess addMembersuccess=new AddMemberSuccess();
					addMembersuccess.setVisible(true);
					dispose();
					
				}
				else
				{
					errorMessage.setText("帳號已有人使用");
				}
			
			}
			
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 40));
		btnNewButton.setBounds(73, 367, 367, 74);
		contentPane.add(btnNewButton);
		
		errorMessage = new JLabel("");
		errorMessage.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		errorMessage.setBounds(450, 367, 111, 74);
		contentPane.add(errorMessage);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_5.setBounds(404, 10, 182, 56);
		contentPane.add(lblNewLabel_5);
		Timer timer = new Timer(1000, e -> {
		    String now = TimeUtil.getCurrentTime();
		    lblNewLabel_5.setText(now);
		});
		timer.start();

	}

}
