import java.awt.EventQueue;

import java.util.*; 
import javax.mail.*; 
import javax.mail.internet.*; 
import javax.activation.*; 
import javax.mail.Session; 
import javax.mail.Transport; 
  
  
import java.lang.Math;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;


import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
public class Home {
	
	private JFrame frame;
	private JTextField NameTextField;
	private JTextField TextFieldUserName;
	private JPasswordField PasswordTextField;
	private JPasswordField ConfirmPasswordField;
	private JTextField EmailField;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window= new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("REGISTER");
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 937, 747);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.ORANGE, 3, true));
		panel.setBounds(97, 197, 776, 467);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel LabelName = new JLabel("Name");
		LabelName.setBounds(12, 66, 84, 41);
		LabelName.setFont(new Font("Arial Black", Font.BOLD, 20));
		panel.add(LabelName);
		
		NameTextField = new JTextField();
		NameTextField.setBounds(225, 66, 285, 40);
		panel.add(NameTextField);
		NameTextField.setColumns(10);
		
		JLabel LabelUsername = new JLabel("UserName");
		LabelUsername.setBounds(12, 139, 112, 24);
		LabelUsername.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		panel.add(LabelUsername);
		
		TextFieldUserName = new JTextField();
		TextFieldUserName.setBounds(225, 136, 285, 41);
		panel.add(TextFieldUserName);
		TextFieldUserName.setColumns(10);
		
		JLabel LabelPassword = new JLabel("Password");
		LabelPassword.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		LabelPassword.setBounds(12, 209, 112, 24);
		panel.add(LabelPassword);
		
		JLabel ConfirmPasswordLabel = new JLabel("ConfirmPassword");
		ConfirmPasswordLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		ConfirmPasswordLabel.setBounds(12, 265, 201, 34);
		panel.add(ConfirmPasswordLabel);
		
		JButton RegisterButton = new JButton("Register");
		RegisterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mssge) {
				String Emailadd=String.valueOf(EmailField.getText());
				String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
				Boolean b=Emailadd.matches(regex);
				
				String Name=String.valueOf(NameTextField.getText());
				String Username=String.valueOf(TextFieldUserName.getText());
				String Password=String.valueOf(PasswordTextField.getText());
				String confirmation=String.valueOf(ConfirmPasswordField.getText());
				int customerid=(int)((Math.random() * 9000000)+1000000);
				if(b) {
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
			        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant?characterEncoding=latin1", "root", "S@s12345");
			      
			        PreparedStatement stat = con.prepareStatement("insert into register values(?,?,?,?,?,?,?)");
			        stat.setInt(1, 0);
			        stat.setString(2, Name);
			        stat.setString(3, Username);
			        stat.setString(4, Password);
			        stat.setString(5, confirmation);
			        stat.setInt(6, customerid);
			        stat.setString(7, Emailadd);
			        if(Password.length()>0 && Name.length()>0 && Username.length()>0) {
			        	
			        if(Password.equals(confirmation)) {
			        int x=stat.executeUpdate();
			        if(x>0){
				        	JOptionPane.showMessageDialog(new JFrame(),"Registration Successfull");  
				        	JOptionPane.showMessageDialog(new JFrame(),"Your Customerid is :"+String.valueOf(customerid)); 
				        	 
				        	  
				        	
				            String recipient = "prashantpadhy21@gmail.com"; 
				        
				            // email ID of  Sender. 
				            String sender = String.valueOf(EmailField.getText()); 
				        
				            // using host as localhost 
				            String host = "127.0.0.1"; 
				        
				            // Getting system properties 
				            Properties properties = System.getProperties(); 
				        
				            // Setting up mail server 
				            properties.setProperty("mail.smtp.host", host); 
				        
				            // creating session object to get properties 
				            Session session = Session.getDefaultInstance(properties); 
				        
				            try 
				            { 
				               // MimeMessage object. 
				               MimeMessage message = new MimeMessage(session); 
				        
				               // Set From Field: adding senders email to from field. 
				               message.setFrom(new InternetAddress(sender)); 
				        
				               // Set To Field: adding recipient's email to from field. 
				               message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); 
				        
				               // Set Subject: subject of the email 
				               message.setSubject("This is Suject"); 
				        
				               // set body of the email. 
				               message.setText("This is a test mail"); 
				        
				               // Send email. 
				               Transport.send(message); 
				               System.out.println("Mail successfully sent"); 
				            } 
				            catch (MessagingException mex)  
				            { 
				               mex.printStackTrace(); 
				            }   
				        	    
				        	 
				        	
				        	frame.setVisible(false);
				        	LOGIN2 lo=new LOGIN2();
				        	lo.frame.setVisible(true);
				        	
				        	
				        	
				        }
				        else
				        {
				        	JOptionPane.showMessageDialog(new JFrame(),"Registration Failed");  
				        }
				        
				        con.close();
				     }
			        else
			        {
			        	JOptionPane.showMessageDialog(new JFrame(),"Password Mismatch,Try Again");  
			        }
			        }
			        else
			        {
			        	JOptionPane.showMessageDialog(new JFrame(),"Please Fill The Details Correctly");  

			        }
				}

				catch(Exception m)
				  {
				      System.out.println(m.getMessage());
				}
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(),"Please Enter Valid Email Id");
				}
			}
		});
		RegisterButton.setBackground(Color.CYAN);
		RegisterButton.setForeground(Color.MAGENTA);
		RegisterButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		RegisterButton.setBounds(137, 398, 128, 34);
		panel.add(RegisterButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(522, 80, 234, 226);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\shrikant padhy\\Desktop\\IMAGES\\customer.jpg"));
		
		JLabel LabelCreateAccount = new JLabel("Create Account");
		LabelCreateAccount.setForeground(new Color(255, 0, 0));
		LabelCreateAccount.setFont(new Font("Arial Black", Font.BOLD, 24));
		LabelCreateAccount.setBounds(29, 0, 227, 53);
		panel.add(LabelCreateAccount);
		
		JButton LoginButton = new JButton("Login");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
	        	LOGIN2 lo=new LOGIN2();
	        	lo.frame.setVisible(true);
			}
		});
		LoginButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		LoginButton.setForeground(Color.MAGENTA);
		LoginButton.setBackground(Color.CYAN);
		LoginButton.setBounds(280, 399, 97, 33);
		panel.add(LoginButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(49, 0, 10, 10);
		panel.add(panel_1);
		
		PasswordTextField = new JPasswordField();
		PasswordTextField.setBounds(225, 200, 285, 41);
		panel.add(PasswordTextField);
		
		ConfirmPasswordField = new JPasswordField();
		ConfirmPasswordField.setBounds(225, 265, 285, 41);
		panel.add(ConfirmPasswordField);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblEmail.setBounds(12, 323, 121, 34);
		panel.add(lblEmail);
		
		EmailField = new JTextField();
		EmailField.setBounds(225, 323, 285, 41);
		panel.add(EmailField);
		EmailField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.ORANGE, 3, true));
		panel_2.setBounds(97, 46, 776, 134);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblRestaurantBillingSystem = new JLabel("Restaurant Billing System");
		lblRestaurantBillingSystem.setForeground(Color.BLUE);
		lblRestaurantBillingSystem.setFont(new Font("Arial", Font.BOLD, 36));
		lblRestaurantBillingSystem.setBounds(182, 38, 517, 68);
		panel_2.add(lblRestaurantBillingSystem);
	}

	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
