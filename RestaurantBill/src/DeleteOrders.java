import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class DeleteOrders {

	JFrame frame;
	private JTextField CustomerIdTextfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteOrders window = new DeleteOrders();
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
	public DeleteOrders() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 813, 647);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(Color.RED, 3, true));
		panel.setBounds(225, 174, 331, 362);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel CustomerIdLabel = new JLabel("CustomerId");
		CustomerIdLabel.setFont(new Font("Arial Black", Font.BOLD, 18));
		CustomerIdLabel.setBounds(12, 221, 135, 44);
		panel.add(CustomerIdLabel);
		
		CustomerIdTextfield = new JTextField();
		CustomerIdTextfield.setBounds(173, 221, 146, 44);
		panel.add(CustomerIdTextfield);
		CustomerIdTextfield.setColumns(10);
		
		JButton PayButton = new JButton("Paid");
		PayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				int id=Integer.parseInt(CustomerIdTextfield.getText());
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant?characterEncoding=latin1", "root", "S@s12345");
    
					PreparedStatement stat1 = con.prepareStatement("Delete from `order` where id='"+String.valueOf(id)+"'");
	 
					int x=stat1.executeUpdate();
					if(x>0)
					{
						JOptionPane.showMessageDialog(new JFrame(),"Status Has Been Updated");
					}
					}
				

				catch(Exception m)
				{
					System.out.println(m);
				}
				
				
			}
		});
		PayButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		PayButton.setForeground(Color.RED);
		PayButton.setBounds(108, 278, 111, 35);
		panel.add(PayButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\shrikant padhy\\Desktop\\IMAGES\\pay.png"));
		label.setBounds(33, 13, 260, 185);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(Color.RED, 3, true));
		panel_1.setBounds(93, 29, 569, 99);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPaymentStatus = new JLabel("Payment Status");
		lblPaymentStatus.setForeground(Color.BLUE);
		lblPaymentStatus.setFont(new Font("Arial", Font.BOLD, 25));
		lblPaymentStatus.setBounds(195, 24, 276, 39);
		panel_1.add(lblPaymentStatus);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewBill lo=new ViewBill();
				frame.setVisible(false);
				lo.frame.setVisible(true);
			}
		});
		btnBack.setForeground(Color.RED);
		btnBack.setFont(new Font("Arial", Font.BOLD, 18));
		btnBack.setBounds(25, 61, 97, 25);
		panel_1.add(btnBack);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame3 lo=new Frame3();
				frame.setVisible(false);
				lo.frame.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Arial", Font.BOLD, 18));
		btnLogout.setForeground(Color.RED);
		btnLogout.setBounds(435, 62, 122, 25);
		panel_1.add(btnLogout);
	}

}
