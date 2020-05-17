import java.awt.EventQueue;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.Formatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.ResultSet;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.sql.*;
public class ViewBill {

	JFrame frame;
	private JTextField CustomerIdTexxtField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBill window = new ViewBill();
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
	public ViewBill() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 787, 683);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBorder(new LineBorder(Color.BLUE, 3, true));
		panel.setBounds(54, 13, 648, 134);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblViewBill = new JLabel("View Bill");
		lblViewBill.setForeground(Color.RED);
		lblViewBill.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 28));
		lblViewBill.setBounds(229, 42, 230, 48);
		panel.add(lblViewBill);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Frame3 lo=new Frame3();
				frame.setVisible(false);
				lo.frame.setVisible(true);
			}
		});
		btnLogout.setForeground(Color.RED);
		btnLogout.setFont(new Font("Arial", Font.BOLD, 18));
		btnLogout.setBounds(467, 13, 133, 25);
		panel.add(btnLogout);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminView1 lo=new AdminView1();
				frame.setVisible(false);
				lo.frame.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Arial", Font.BOLD, 18));
		btnBack.setForeground(Color.RED);
		btnBack.setBounds(12, 14, 97, 25);
		panel.add(btnBack);
		
		JTextArea l3 = new JTextArea();
		l3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 23));
		l3.setBounds(401, 191, 313, 382);
		frame.getContentPane().add(l3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.BLUE, 3, true));
		panel_1.setBounds(370, 170, 371, 439);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton Print = new JButton("Print");
		Print.setForeground(Color.MAGENTA);
		Print.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		Print.setBounds(142, 401, 117, 25);
		panel_1.add(Print);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.BLUE, 3, true));
		panel_2.setBounds(28, 170, 313, 439);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblEnterCustomerid = new JLabel("Enter CustomerId:");
		lblEnterCustomerid.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 23));
		lblEnterCustomerid.setBounds(51, 192, 222, 43);
		panel_2.add(lblEnterCustomerid);
		
		CustomerIdTexxtField = new JTextField();
		CustomerIdTexxtField.setBounds(77, 237, 163, 43);
		panel_2.add(CustomerIdTexxtField);
		CustomerIdTexxtField.setColumns(10);
		
		JButton Billbutton = new JButton("GenerateBill");
		Billbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				int id=Integer.parseInt(CustomerIdTexxtField.getText());
				String temp;
				try
				{
					
				
					Class.forName("com.mysql.jdbc.Driver");
					 Date date = new Date();  
					 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant?characterEncoding=latin1", "root", "S@s12345");
					 temp="YOUR BILL\nCustomer id:"+String.valueOf(id)+"\nDate "+String.valueOf(formatter.format(date))+"\n";
					Statement stat1=con.createStatement();
					
				   
					ResultSet rs=(ResultSet) stat1.executeQuery("select payment_state,name,sum(price) as total from `order` where id='"+String.valueOf(id)+"'group by name");
					int sum=0;
					while(rs.next())
					{
						temp=temp+"\n\n"+rs.getString(1)+"__\n\n"+rs.getString(2)+" "+rs.getInt(3)+"/-Rs";
						sum+=rs.getInt(3);
					}
						
					temp=temp+"\n\nTOTAL="+String.valueOf(sum)+" /-Rs";
					l3.setText(temp);
					
					BufferedWriter bf=new BufferedWriter(new FileWriter("C:\\Users\\shrikant padhy\\Desktop\\Bill.txt",false));
			    	bf.write(String.valueOf(temp));
					bf.close();
				}
				catch(Exception m)
				{
					
				}
				
			}
		});
		Billbutton.setForeground(Color.MAGENTA);
		Billbutton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		Billbutton.setBounds(77, 293, 163, 53);
		panel_2.add(Billbutton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\shrikant padhy\\Desktop\\IMAGES\\bill.jfif"));
		lblNewLabel.setBounds(51, 13, 222, 184);
		panel_2.add(lblNewLabel);
	}

}
