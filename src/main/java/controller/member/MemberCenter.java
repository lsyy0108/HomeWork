package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import controller.porder.AddPorder;
import model.Member;
import service.MemberService;
import service.impl.MemberServiceImpl;
import util.TimeUtil;
import util.Tool;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class MemberCenter extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberCenter frame = new MemberCenter();
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
	public MemberCenter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton material_1_1 = new JButton("回上一頁");
		material_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddPorder addporder=new AddPorder();
				addporder.setVisible(true);
				dispose();
			}
		});
		material_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		material_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		material_1_1.setBounds(244, 177, 146, 49);
		contentPane.add(material_1_1);
		
		JButton material_1_1_1 = new JButton("刪除帳號");
		material_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DelMember  delmember=new DelMember();
				delmember.setVisible(true);
				dispose();
			}
		});
		material_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

	       
	   
		material_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		material_1_1_1.setBounds(20, 177, 146, 49);
		contentPane.add(material_1_1_1);
		
		JLabel showmessage = new JLabel("");
		showmessage.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		showmessage.setBounds(10, 24, 206, 60);
		contentPane.add(showmessage);
		Member member=(Member)Tool.readFile("member.txt");
		String show=member.getName();
		
		showmessage.setText(show);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_2.setBounds(244, 0, 182, 56);
		contentPane.add(lblNewLabel_2);
		Timer timer = new Timer(1000, e -> {
		    String now = TimeUtil.getCurrentTime();
		    lblNewLabel_2.setText(now);
		});
		timer.start();

	}
}
