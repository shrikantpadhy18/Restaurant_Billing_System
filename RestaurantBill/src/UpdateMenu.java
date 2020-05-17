import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.List;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
public class UpdateMenu implements ItemListener{

	JFrame frame;
	String name;
	List list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateMenu window = new UpdateMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		 name=list.getSelectedItem();

	}

	/**
	 * Create the application.
	 */
	public UpdateMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 823, 702);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Update Menu");
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.RED, 3, true));
		panel.setBounds(61, 38, 664, 575);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		list = new List();
		list.addItemListener(this);
		list.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		list.setBounds(50, 67, 203, 434);
		panel.add(list);
		
			try {
			
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant?characterEncoding=latin1", "root", "S@s12345");
	        Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from food");
			String name;
			while(rs.next())
			{
				name=rs.getString(2);
				list.add(name);
				
			}
		}
		catch(Exception m)
		{
			
		}
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.YELLOW);
		panel_1.setBorder(new LineBorder(Color.RED, 3, true));
		panel_1.setBounds(312, 149, 340, 213);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAdditem = new JButton("ADD_ITEM");
		btnAdditem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddItem lo=new AddItem();
				frame.setVisible(false);
				lo.frame.setVisible(true);
				
			}
		});
		btnAdditem.setFont(new Font("Arial", Font.BOLD, 16));
		btnAdditem.setForeground(Color.MAGENTA);
		btnAdditem.setBounds(12, 38, 123, 42);
		panel_1.add(btnAdditem);
		
		JButton Delete_Item = new JButton("Delete");
		Delete_Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
								try {
					Class.forName("com.mysql.jdbc.Driver");
			        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant?characterEncoding=latin1", "root", "S@s12345");
			        
			        PreparedStatement stat1 = con.prepareStatement("Delete from `food` where item_name='"+name+"'");
					 
			       int x=stat1.executeUpdate();
			       if(x>0)
			       {
			    	   JOptionPane.showMessageDialog(new JFrame(),"Selected Item Has Been Deleted");
			       }
				}
				
				catch(Exception m)
				{
					System.out.println(m);
				}
								
			
								
				
			}
		});
		Delete_Item.setForeground(Color.MAGENTA);
		Delete_Item.setFont(new Font("Arial Black", Font.BOLD, 16));
		Delete_Item.setBounds(12, 120, 123, 42);
		panel_1.add(Delete_Item);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\shrikant padhy\\Desktop\\IMAGES\\operations-icon-19.png"));
		lblNewLabel.setBounds(118, 13, 210, 174);
		panel_1.add(lblNewLabel);
		
		JLabel MenuLabel = new JLabel("MenuItems");
		MenuLabel.setForeground(Color.BLUE);
		MenuLabel.setFont(new Font("Arial Black", Font.BOLD, 17));
		MenuLabel.setBounds(50, 27, 181, 25);
		panel.add(MenuLabel);
		
		JLabel lblSelectoperation = new JLabel("SelectOperation");
		lblSelectoperation.setFont(new Font("Arial", Font.BOLD, 16));
		lblSelectoperation.setForeground(Color.BLUE);
		lblSelectoperation.setBounds(377, 100, 157, 36);
		panel.add(lblSelectoperation);
		
		JButton ButtonBack = new JButton("BACK");
		ButtonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			AdminView1 lo=new AdminView1();
			frame.setVisible(false);
			lo.frame.setVisible(true);
			}
		});
		ButtonBack.setForeground(Color.MAGENTA);
		ButtonBack.setFont(new Font("Arial Black", Font.BOLD, 18));
		ButtonBack.setBounds(391, 423, 112, 36);
		panel.add(ButtonBack);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Frame3 lo =new Frame3();
			frame.setVisible(false);
			lo.frame.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Arial", Font.BOLD, 18));
		btnLogout.setForeground(Color.RED);
		btnLogout.setBounds(515, 13, 120, 36);
		panel.add(btnLogout);
	}
}
