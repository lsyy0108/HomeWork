package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.member.AddMember;
import controller.member.ChangePassword;
import controller.member.LoginError;
import controller.member.LoginSuccess;
import model.Member;
import service.impl.MemberServiceImpl;
import util.TimeUtil;
import util.Tool;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel uu;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		uu = new JPanel();
		uu.setBackground(new Color(199, 33, 222));
		uu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(uu);
		uu.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		lblNewLabel.setBounds(97, 189, 75, 56);
		uu.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		lblNewLabel_1.setBounds(97, 270, 75, 56);
		uu.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(194, 198, 235, 47);
		uu.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(194, 279, 235, 47);
		uu.add(password);
		
		JButton loginsuccess = new JButton("登入");
		loginsuccess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		loginsuccess.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=username.getText();
				String Password=password.getText();
				Member m=new MemberServiceImpl().login(Username, Password);
				
				if(m!=null)
				{	
					Tool.saveFile(m,"member.txt");
					LoginSuccess loginSuccess=new LoginSuccess();
					loginSuccess.setVisible(true);
					dispose();
				}
				else
				{
					LoginError loginError=new LoginError();
					loginError.setVisible(true);
					dispose();
				}
			}
		});
		loginsuccess.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		loginsuccess.setBounds(118, 362, 166, 56);
		uu.add(loginsuccess);
		
		JButton pp = new JButton("註冊");
		pp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddMember addmember=new AddMember();
				addmember.setVisible(true);
				dispose();
				
			}
		});
		pp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pp.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		pp.setBounds(329, 362, 166, 56);
		uu.add(pp);
		
		JButton btnNewButton = new JButton("忘記密碼");
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePassword changepassword=new ChangePassword();
				changepassword.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(439, 277, 118, 49);
		uu.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_2.setBounds(404, 10, 182, 56);
		uu.add(lblNewLabel_2);
		Timer timer = new Timer(1000, e -> {
		    String now = TimeUtil.getCurrentTime();
		    lblNewLabel_2.setText(now);
		    
		    
		   
		});
		 timer.start();
		 JLabel lblNewLabel_3 = new JLabel("WI DANCE舞蹈學院");
		    lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 48));
		    lblNewLabel_3.setBounds(64, 66, 452, 113);
		    uu.add(lblNewLabel_3);
		    
		    JLabel lblNewLabel_4 = new JLabel("地址：台北市松山區南京東路四段164號3樓");
		    lblNewLabel_4.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		    lblNewLabel_4.setBounds(10, 437, 566, 39);
		    uu.add(lblNewLabel_4);
		    
		    JLabel lblNewLabel_5 = new JLabel("instagram：widance_dance_troupe");
		    lblNewLabel_5.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		    lblNewLabel_5.setBackground(new Color(199, 33, 222));
		    lblNewLabel_5.setBounds(10, 486, 341, 47);
		    uu.add(lblNewLabel_5);
		    
		    JLabel lblNewLabel_6 = new JLabel("管理者admin");
		    lblNewLabel_6.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		    lblNewLabel_6.setBounds(97, 155, 75, 33);
		    uu.add(lblNewLabel_6);
	}
}
