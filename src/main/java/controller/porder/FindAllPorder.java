package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Porder;
import service.impl.PorderServiceImpl;
import util.TimeUtil;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FindAllPorder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField lcd;
	private JTextField ram;
	private JTextField mouse;
	private static  PorderServiceImpl psi=new PorderServiceImpl();
	private JTextField delID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindAllPorder frame = new FindAllPorder();
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
	public FindAllPorder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		List<Porder> l=new PorderServiceImpl().findAllPorder();
		String show="";
		int count=0;//筆數
		int LCD=0;
		int RAM=0;
		int MOUSE=0;
		
		for(Porder p:l)
		{
			show=show+
					"序號:"+p.getId()+"\t名稱:"+p.getName()+"\tlcd:"+p.getLcd()+"\tram:"+p.getRam()+"\tmouse:"+p.getMouse()+"\n";
			count++;
			LCD=LCD+p.getLcd();
			RAM=RAM+p.getRam();
			MOUSE=MOUSE+p.getMouse();
		}
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 10, 464, 128);
		contentPane.add(textArea);
		
		textArea.setText(show);
		
		JButton btnNewButton = new JButton("返回首頁");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PorderManager porderManager=new PorderManager();
				porderManager.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		btnNewButton.setBounds(10, 390, 464, 61);
		contentPane.add(btnNewButton);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(10, 148, 464, 99);
		contentPane.add(textArea_1);
		
		int allSum=LCD*6000+RAM*4800+MOUSE*5400;
		textArea_1.setText("總筆數:"+count+"\n肚皮舞課程:"+LCD+"期"+
				"\n單人拉丁:"+RAM+"期"+"\n芭蕾舞課程:"+MOUSE+"期"+
				"\n總金額:"+allSum+"元");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(10, 244, 464, 78);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("序號:");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 10, 37, 21);
		panel.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(51, 14, 31, 21);
		panel.add(id);
		id.setColumns(10);
		
		JLabel lblLcd = new JLabel("肚皮舞:");
		lblLcd.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblLcd.setBounds(89, 10, 63, 21);
		panel.add(lblLcd);
		
		lcd = new JTextField();
		lcd.setColumns(10);
		lcd.setBounds(150, 14, 49, 21);
		panel.add(lcd);
		
		JLabel lblRam = new JLabel("拉丁:");
		lblRam.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblRam.setBounds(209, 10, 49, 21);
		panel.add(lblRam);
		
		ram = new JTextField();
		ram.setColumns(10);
		ram.setBounds(258, 14, 49, 21);
		panel.add(ram);
		
		JLabel lblMouse = new JLabel("芭蕾:");
		lblMouse.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblMouse.setBounds(331, 10, 49, 21);
		panel.add(lblMouse);
		
		mouse = new JTextField();
		mouse.setColumns(10);
		mouse.setBounds(375, 15, 49, 21);
		panel.add(mouse);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ID=Integer.parseInt(id.getText());
				int Lcd=Integer.parseInt(lcd.getText());
				int Ram=Integer.parseInt(ram.getText());
				int Mouse=Integer.parseInt(mouse.getText());
				Porder p=new Porder();
				p.setId(ID);
				p.setLcd(Lcd);
				p.setRam(Ram);
				p.setMouse(Mouse);
				
				psi.updatePorder(p);
				
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton_1.setBounds(10, 45, 428, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 255, 255));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 332, 464, 48);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("序號:");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 10, 41, 21);
		panel_1.add(lblNewLabel_1);
		
		delID = new JTextField();
		delID.setColumns(10);
		delID.setBounds(51, 14, 49, 21);
		panel_1.add(delID);
		
		JButton btnNewButton_1_2 = new JButton("刪除");
		btnNewButton_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					int DELID=Integer.parseInt(delID.getText());
					
					Porder p=new Porder();
					p.setId(DELID);
					
					psi.deletePorder(p);
				}
			
			
		});
		btnNewButton_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton_1_2.setBounds(110, 13, 144, 23);
		panel_1.add(btnNewButton_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_2.setBounds(272, 0, 182, 38);
		panel_1.add(lblNewLabel_2);
		Timer timer = new Timer(1000, e -> {
		    String now = TimeUtil.getCurrentTime();
		    lblNewLabel_2.setText(now);
		});
		timer.start();

	}

}

