package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import model.Porder;
import service.impl.PorderServiceImpl;
import util.TimeUtil;
import util.Tool;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Confirm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Confirm frame = new Confirm();
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
	public Confirm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JTextArea showPorder = new JTextArea();
		showPorder.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		showPorder.setBounds(10, 53, 414, 144);
		contentPane.add(showPorder);
		
		JLabel showMember = new JLabel("");
		showMember.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		showMember.setBounds(10, 10, 211, 33);
		contentPane.add(showMember);
		Porder p=(Porder)Tool.readFile("porder.txt");
		Member m=(Member)Tool.readFile("member.txt");
		
		showMember.setText(m.getName());
		
		String show="您報名的項目:"+
		"\n肚皮舞課程:"+p.getLcd()+"期"+
		"\n正體瑜珈:"+p.getRam()+"期"+
		"\n芭蕾舞課程:"+p.getMouse()+"期"+
		"\n共:"+(p.getLcd()*6000+p.getRam()*4800+p.getMouse()*5400)+"元";
		
		
		showPorder.setText(show);
		
		JButton btnNewButton_1 = new JButton("回上一頁");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPorder addporder=new AddPorder();
				addporder.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton_1.setBounds(10, 207, 139, 44);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("前往結帳");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 *1-addPorder()-->資料庫
				 *2->切換到->finish 
				 */
				
				new PorderServiceImpl().addPorder(p);
				Finish finsh=new Finish();
				finsh.setVisible(true);
				dispose();
			
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton.setBounds(285, 207, 139, 44);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_2.setBounds(244, 0, 182, 43);
		contentPane.add(lblNewLabel_2);
		Timer timer = new Timer(1000, e -> {
		    String now = TimeUtil.getCurrentTime();
		    lblNewLabel_2.setText(now);
		});
		timer.start();
		

	}
}
