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
import java.util.Random;
import java.awt.event.ActionEvent;

public class AddItem {

	JFrame frame;
	private JTextField FoodField;
	private JTextField PriceTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddItem window = new AddItem();
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
	public AddItem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 833, 643);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(69, 55, 624, 436);
		panel.setBorder(new LineBorder(Color.BLUE, 3, true));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAddnewitem = new JLabel("ADD NEW ITEM");
		lblAddnewitem.setForeground(Color.RED);
		lblAddnewitem.setFont(new Font("Arial", Font.BOLD, 25));
		lblAddnewitem.setBounds(12, 13, 199, 43);
		panel.add(lblAddnewitem);
		
		JButton AddButton = new JButton("ADD");
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random r = new Random();
			    String randomNumber = String.format("%04d", (Object) Integer.valueOf(r.nextInt(1001)));
			    int no=Integer.parseInt(randomNumber);
			    
			    
			    	try
			    	{
			    		Class.forName("com.mysql.jdbc.Driver");
				        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant?characterEncoding=latin1", "root", "S@s12345");
				      
				        PreparedStatement stat = con.prepareStatement("insert into `food` values(?,?,?)");
				        stat.setInt(1, no);
				        stat.setString(2, FoodField.getText());
				        stat.setInt(3, Integer.parseInt(PriceTextField.getText()));
				        int x=stat.executeUpdate();
				        if(x>0)
				        {
				        	
				        	JOptionPane.showMessageDialog(new JFrame(),"New Item Has Been Added");  
				        }
			    	}
			    	catch(Exception m)
			    	{
			    		System.out.println(m);
			    		JOptionPane.showMessageDialog(new JFrame(),"Something Went Wrong Try Again");  
			    	}
			    
			}
			
		});
		AddButton.setFont(new Font("Arial", Font.BOLD, 14));
		AddButton.setForeground(Color.MAGENTA);
		AddButton.setBounds(137, 298, 118, 33);
		panel.add(AddButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\shrikant padhy\\Desktop\\IMAGES\\FoodItemNew-removebg-preview (1).png"));
		lblNewLabel.setBounds(388, 89, 224, 242);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(12, 69, 364, 307);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel FoodItemName = new JLabel("FOOD_ITEM_NAME");
		FoodItemName.setBounds(12, 35, 157, 36);
		panel_1.add(FoodItemName);
		FoodItemName.setFont(new Font("Arial", Font.BOLD, 17));
		
		FoodField = new JTextField();
		FoodField.setBounds(184, 38, 168, 33);
		panel_1.add(FoodField);
		FoodField.setColumns(10);
		
		PriceTextField = new JTextField();
		PriceTextField.setBounds(184, 144, 168, 36);
		panel_1.add(PriceTextField);
		PriceTextField.setColumns(10);
		
		JLabel lblPricequantity = new JLabel("PRICE/QUANTITY");
		lblPricequantity.setBounds(12, 151, 157, 21);
		panel_1.add(lblPricequantity);
		lblPricequantity.setFont(new Font("Arial", Font.BOLD, 16));
		
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateMenu lo=new UpdateMenu();
				frame.setVisible(false);
				lo.frame.setVisible(true);
			}
		});
		BackButton.setForeground(Color.MAGENTA);
		BackButton.setFont(new Font("Arial Black", Font.BOLD, 18));
		BackButton.setBounds(441, 344, 118, 33);
		panel.add(BackButton);
		
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
		btnLogout.setBounds(459, 13, 133, 33);
		panel.add(btnLogout);
	}
}
