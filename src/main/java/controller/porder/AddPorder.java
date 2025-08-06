package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.member.FacultyIntroduction1;
import controller.member.FacultyIntroduction2;
import controller.member.FacultyIntroduction3;
import controller.member.LoginError;
import controller.member.LoginSuccess;
import controller.member.MemberCenter;
import model.Member;
import model.Porder;
import util.TimeUtil;
import util.Tool;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class AddPorder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField lcd;
	private JTextField ram;
	private JTextField mouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPorder frame = new AddPorder();
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
	public AddPorder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(10, 69, 414, 192);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lcd = new JTextField();
		lcd.setBounds(239, 30, 165, 32);
		panel.add(lcd);
		lcd.setColumns(10);
		
		ram = new JTextField();
		ram.setColumns(10);
		ram.setBounds(239, 72, 165, 32);
		panel.add(ram);
		
		mouse = new JTextField();
		mouse.setColumns(10);
		mouse.setBounds(239, 114, 165, 32);
		panel.add(mouse);
		
		
		
		JLabel showmessage = new JLabel("");
		showmessage.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		showmessage.setBounds(10, 10, 206, 60);
		contentPane.add(showmessage);
		Member member=(Member)Tool.readFile("member.txt");
		String show=member.getName();
		
		showmessage.setText(show);
		
		JLabel lblNewLabel_1 = new JLabel("爸爸歡迎回家");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1.setBounds(226, 26, 198, 44);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("確定");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.擷取->lcd,ram,mouse-->轉型-->int
				 * 2.new Porder();
				 * 3.Tool-->porder.txt
				 * 4.切換到-->Confirm
				 */
				int Lcd=Integer.parseInt(lcd.getText());
				int Ram=Integer.parseInt(ram.getText());
				int Mouse=Integer.parseInt(mouse.getText());
				
				Porder p=new Porder(member.getName(),Lcd,Ram,Mouse);
				Tool.saveFile(p, "porder.txt");
				
				Confirm confirm=new Confirm();
				confirm.setVisible(true);
				dispose();
				
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton.setBounds(0, 156, 165, 26);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回首頁");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PorderManager pordermanger=new PorderManager();
				pordermanger.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton_1.setBounds(296, 156, 118, 26);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("會員中心");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MemberCenter membercenter=new MemberCenter();
				membercenter.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton_1_1.setBounds(168, 156, 118, 26);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("肚皮舞課程");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FacultyIntroduction1 facultyintroduction=new FacultyIntroduction1();
				facultyintroduction.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_2.setBounds(0, 33, 107, 29);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("單人拉丁");
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					FacultyIntroduction2 facultyintroduction=new FacultyIntroduction2();
					facultyintroduction.setVisible(true);
					dispose();
			}
		});
		btnNewButton_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_2_1.setBounds(0, 72, 107, 29);
		panel.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("芭蕾舞課程");
		btnNewButton_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FacultyIntroduction3 facultyintroduction=new FacultyIntroduction3();
				facultyintroduction.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_2_2.setBounds(0, 114, 107, 29);
		panel.add(btnNewButton_2_2);
		
		JLabel lblNewLabel = new JLabel("師資介紹");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 22));
		lblNewLabel.setBounds(0, 0, 107, 32);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("6000/期");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_3.setBounds(117, 30, 112, 32);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("4800/期");
		lblNewLabel_3_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(117, 72, 112, 32);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("5400/期");
		lblNewLabel_3_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_3_2.setBounds(117, 114, 112, 32);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_2.setBounds(242, 0, 182, 40);
		contentPane.add(lblNewLabel_2);
		Timer timer = new Timer(1000, e -> {
		    String now = TimeUtil.getCurrentTime();
		    lblNewLabel_2.setText(now);
		});
		timer.start();

	}
}
