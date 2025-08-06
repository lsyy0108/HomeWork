package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import model.Porder;
import util.CreateExcel;
import util.ExcelUtil;
import util.TimeUtil;
import util.Tool;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.awt.Color;
import javax.swing.JTextField;

public class Finish extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Finish frame = new Finish();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Member member=(Member)Tool.readFile("member.txt");
	Porder porder=(Porder)Tool.readFile("porder.txt");

	/**
	 * Create the frame.
	 */
	public Finish() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		textArea.setBounds(10, 10, 254, 99);
		contentPane.add(textArea);
		String show="訂單完成"+
				"\n客戶名稱:"+member.getName()+
				"\n地址:"+member.getAddress()+
				"\n電話:"+member.getPhone();
				
				
		textArea.setText(show);
		
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		textArea_1.setBounds(10, 118, 254, 208);
		contentPane.add(textArea_1);
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String show1="您的購物明細:"+
				"\n肚皮舞課程:"+porder.getLcd()+"期"+
				"\n單人拉丁:"+porder.getRam()+"期"+
				"\n芭蕾舞課程:"+porder.getMouse()+"期"+
				"\n共:"+(porder.getLcd()*6000+porder.getRam()*4800+porder.getMouse()*5400)+
				"元\n=================\n"+now.format(formatter);
				
				
				
		textArea_1.setText(show1);
		
		JButton btnNewButton = new JButton("列印");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					textArea_1.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		btnNewButton.setBounds(10, 336, 126, 52);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回首頁");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PorderManager porderManager=new PorderManager();
				porderManager.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		btnNewButton_1.setBounds(10, 398, 254, 52);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("匯出");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ExcelUtil n=new ExcelUtil();
				n.main(null);
				ExcelUtil o=new ExcelUtil();
				o.main(null);
				CreateExcel m=new CreateExcel();
				m.insertMemberValue(member, "Member.xls", "會員表");
				CreateExcel q=new CreateExcel();
				q.insertPorderValue(porder, "Porder.xls", "周報表");
			}
		});
		btnNewButton_2.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		btnNewButton_2.setBounds(138, 337, 126, 51);
		contentPane.add(btnNewButton_2);
		
		

	}
}

