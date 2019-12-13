import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
public class CustomerView implements ItemListener{

	JFrame frame;
	 List list,list_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerView window = new CustomerView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void itemStateChanged(ItemEvent e)
	{
		String itemname=list.getSelectedItem();
		list_1.add(itemname);
	}

	/**
	 * Create the application.
	 */
	public CustomerView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 982, 755);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBackground(Color.WHITE);
		panel.setBounds(42, 45, 886, 663);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		list = new List();
		list.setFont(new Font("Dialog", Font.PLAIN, 25));
		list.setForeground(Color.BLACK);
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant?characterEncoding=latin1", "root", "S@s12345");
	        Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select item_name from food");
			String name;
			
			while(rs.next())
			{
				name=rs.getString(1);
				list.add(name);
			}
		}
		catch(Exception m)
		{
			
		}
		
		list.setBounds(40, 77, 159, 479);
		panel.add(list);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new LineBorder(Color.RED, 3, true));
		panel_1.setBounds(25, 24, 221, 543);
		panel.add(panel_1);
		
		JLabel LabelMenu = new JLabel("Menu_Items");
		panel_1.add(LabelMenu);
		LabelMenu.setBackground(Color.ORANGE);
		LabelMenu.setForeground(Color.BLUE);
		LabelMenu.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBorder(new LineBorder(new Color(255, 0, 0), 3, true));
		panel_2.setForeground(Color.BLACK);
		panel_2.setBounds(272, 24, 202, 543);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		 list_1 = new List();
		list.addItemListener(this);
		list_1.addItemListener(this);
		list_1.setBounds(23, 55, 143, 467);
		panel_2.add(list_1);
		
		JLabel LabelItemSelected = new JLabel("Selected_Items");
		LabelItemSelected.setForeground(Color.BLUE);
		LabelItemSelected.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		LabelItemSelected.setBounds(23, 13, 156, 29);
		panel_2.add(LabelItemSelected);
	}
	
}
