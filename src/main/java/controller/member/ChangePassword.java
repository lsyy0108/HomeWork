package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import controller.Login;
import model.Member;
import model.Porder;
import service.impl.MemberServiceImpl;
import service.impl.PorderServiceImpl;
import util.TimeUtil;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;


public class ChangePassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField newpassword;
	protected JTextComponent usernameField;
	protected Member passwordField;
	private JTextField usernamea;
	private JLabel lblNewLabel;
	private JTabbedPane tabbedPane;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
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
	public ChangePassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		newpassword = new JTextField();
		newpassword.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		newpassword.setBounds(224, 56, 153, 45);
		contentPane.add(newpassword);
		newpassword.setColumns(10);
		
		usernamea = new JTextField();
		usernamea.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		usernamea.setColumns(10);
		usernamea.setBounds(33, 56, 153, 45);
		contentPane.add(usernamea);
		
		JButton btnNewButton = new JButton("修改並返回");
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = usernamea.getText().trim();
		        String pwd = newpassword.getText().trim();

		        Member p = new Member();
		        p.setUsername(username);
		        p.setPassword(pwd);

		        
		        MemberServiceImpl msi = new MemberServiceImpl();
		        boolean success = msi.updateMember(p); 

		        
		        
		
			    Login login=new Login();
			    login.setVisible(true);
				dispose();

			}
		});
		btnNewButton.setBounds(33, 161, 171, 69);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		lblNewLabel_1.setBounds(33, 10, 153, 36);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("新密碼");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		lblNewLabel_2.setBounds(224, 10, 153, 36);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_3.setBounds(244, 196, 182, 56);
		contentPane.add(lblNewLabel_3);
		Timer timer = new Timer(1000, e -> {
		    String now = TimeUtil.getCurrentTime();
		    lblNewLabel_3.setText(now);
		});
		timer.start();
		
		
		
		
		
	}
}
		
		
		

	

