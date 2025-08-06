package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import controller.Login;
import controller.member.LoginSuccess;
import model.Member;
import service.impl.MemberServiceImpl;
import util.TimeUtil;
import util.Tool;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class PorderManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PorderManager frame = new PorderManager();
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
	public PorderManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddPorder addporder=new AddPorder();
				addporder.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton.setBounds(37, 137, 128, 56);
		contentPane.add(btnNewButton);
		
		Member member=(Member)Tool.readFile("member.txt");
		String show=member.getUsername();
		JButton btnNewButton_1 = new JButton("查詢");
		btnNewButton_1.setVisible(false);
		if (show.equals("admin")) {
			btnNewButton_1.setVisible(true);
		}
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				FindAllPorder findallporder=new FindAllPorder();
				findallporder.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton_1.setBounds(260, 137, 120, 56);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_2.setBounds(244, 10, 182, 56);
		contentPane.add(lblNewLabel_2);
		Timer timer = new Timer(1000, e -> {
		    String now = TimeUtil.getCurrentTime();
		    lblNewLabel_2.setText(now);
		    
		    
		});
		timer.start();
		JLabel lblNewLabel = new JLabel("用戶功能");
	    lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
	    lblNewLabel.setBounds(42, 76, 120, 54);
	    contentPane.add(lblNewLabel);
	    
	    JLabel lblNewLabel_1 = new JLabel("管理者權限");
	    lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
	    lblNewLabel_1.setBounds(260, 73, 120, 54);
	    contentPane.add(lblNewLabel_1);
	    
	    JButton btnNewButton_2 = new JButton("重新登入");
	    btnNewButton_2.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		Login login=new Login();
				login.setVisible(true);
				dispose();
	    	}
	    });
	    btnNewButton_2.setFont(new Font("微軟正黑體", Font.BOLD, 24));
	    btnNewButton_2.setBounds(100, 200, 218, 56);
	    contentPane.add(btnNewButton_2);
	}
}
