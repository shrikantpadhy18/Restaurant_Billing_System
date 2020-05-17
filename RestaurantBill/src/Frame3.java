import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Frame3 {

	JFrame frame;
	private JTextField UserNameTextField;
	private JPasswordField PasswordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame3 window = new Frame3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.ORANGE, 3, true));
		panel.setBounds(89, 66, 780, 560);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel LOGINLABEL = new JLabel("LOGIN HERE");
		LOGINLABEL.setBounds(12, 13, 275, 29);
		LOGINLABEL.setForeground(Color.RED);
		LOGINLABEL.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
		panel.add(LOGINLABEL);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.GREEN, 3, true));
		panel_1.setBounds(23, 79, 363, 366);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel LabelUserName = new JLabel("UserName");
		LabelUserName.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		LabelUserName.setBounds(12, 108, 131, 38);
		panel_1.add(LabelUserName);
		
		UserNameTextField = new JTextField();
		UserNameTextField.setBounds(138, 113, 212, 32);
		panel_1.add(UserNameTextField);
		UserNameTextField.setColumns(10);
		
		JLabel LabelPassword = new JLabel("PassWord");
		LabelPassword.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		LabelPassword.setBounds(12, 174, 98, 32);
		panel_1.add(LabelPassword);
		
		JButton Login = new JButton("Login");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username= UserNameTextField.getText();
				String password=PasswordTextField.getText();
				try {
					int count=0;
					Class.forName("com.mysql.jdbc.Driver");
			        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant?characterEncoding=latin1", "root", "S@s12345");
			        Statement stmt=con.createStatement();  
					ResultSet rs=stmt.executeQuery("SELECT * from register WHERE username='" + username + "' and password='"+password+"'");
					while(rs.next())
						count+=1;
					if(count>0 && username.equals("ADMIN") && password.equals("ADMIN")) {
						JOptionPane.showMessageDialog(new JFrame(),"Login has been successfull"); 
						frame.setVisible(false);
						AdminView1 lo1=new AdminView1();
						lo1.frame.setVisible(true);
					}
					else if(count>0 ) {
						JOptionPane.showMessageDialog(new JFrame(),"Login has been successfull"); 
						frame.setVisible(false);
						CustomerView lo=new CustomerView();
						lo.frame.setVisible(true);
						
					}
					
					
						else
						{
							JOptionPane.showMessageDialog(new JFrame(),"Login has been Unsuccessfull");
						}
					}
				catch(Exception m)
				{
					System.out.println(m);
					
				}
					
				
				
				//
			}
		});
		Login.setForeground(Color.MAGENTA);
		Login.setBackground(Color.CYAN);
		Login.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		Login.setBounds(138, 252, 113, 38);
		panel_1.add(Login);
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(119, -50, 98, 182);
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\shrikant padhy\\Desktop\\IMAGES\\Login-removebg-preview (1).png"));
		
		PasswordTextField = new JPasswordField();
		PasswordTextField.setBounds(138, 176, 212, 32);
		panel_1.add(PasswordTextField);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\shrikant padhy\\Desktop\\IMAGES\\Key2.png"));
		label.setBounds(398, 79, 358, 366);
		panel.add(label);
		frame.setBounds(100, 100, 986, 745);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
