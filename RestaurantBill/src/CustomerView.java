import java.awt.EventQueue;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
  
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.List;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTextArea;
public class CustomerView implements ItemListener{

	JFrame frame;
	 List list,list_1;
	 String selected,customer1=null;
	 private JTextField CustomerTextField;

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
		String itemname = null;
		if(e.getSource()==list) {
		 itemname=list.getSelectedItem();
		}
		list_1.add(itemname);
		selected=list_1.getSelectedItem();
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
		frame.setBounds(100, 100, 1034, 1058);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GREEN, 1, true));
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBackground(Color.WHITE);
		panel.setBounds(41, 45, 915, 924);
		frame.getContentPane().add(panel);
		list = new List();
		list.setBounds(40, 77, 159, 479);
		list.setFont(new Font("Dialog", Font.PLAIN, 25));
		list.setForeground(Color.BLACK);
		HashMap<String,Integer>map=new HashMap<String,Integer>();
		HashMap<String,Integer>origin=new HashMap<String,Integer>();
		JTextArea l5 = new JTextArea();
		l5.setForeground(Color.BLUE);
		l5.setFont(new Font("Arial Black", Font.BOLD, 17));
		l5.setEditable(false);
		l5.setBounds(39, 48, 285, 333);
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.RED, 3, true));
		panel_3.setBounds(535, 77, 353, 799);
		panel.add(panel_3);
		panel_3.add(l5);
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant?characterEncoding=latin1", "root", "S@s12345");
	        Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from food");
			String name,temp1 ="";
			int price;
			
			while(rs.next())
			{
				name=rs.getString(2);
				list.add(name);
				price=rs.getInt(3);
				map.put(name,price);
				origin.put(name,price);
			}
			
			for (String name1 : map.keySet())  
			{
				temp1=temp1+"\nFood_Item_Name:"+name1+"\n Price/Quantity:"+String.valueOf(origin.get(name1))+" /-Rs"+"\n---------";
			}
			l5.setText(temp1);
			System.out.println(map);
		}
		catch(Exception m)
		{
			
		}
		panel.setLayout(null);
		panel.add(list);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(25, 24, 221, 543);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new LineBorder(Color.RED, 3, true));
		panel.add(panel_1);
		
		JLabel LabelMenu = new JLabel("Menu_Items");
		panel_1.add(LabelMenu);
		LabelMenu.setBackground(Color.ORANGE);
		LabelMenu.setForeground(Color.BLUE);
		LabelMenu.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(272, 24, 202, 543);
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBorder(new LineBorder(new Color(255, 0, 0), 3, true));
		panel_2.setForeground(Color.BLACK);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		 list_1 = new List();
		 list_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		list.addItemListener(this);
		list_1.addItemListener(this);
		list_1.setBounds(23, 55, 143, 467);
		panel_2.add(list_1);
		
		JLabel LabelItemSelected = new JLabel("Selected_Items");
		LabelItemSelected.setForeground(Color.BLUE);
		LabelItemSelected.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		LabelItemSelected.setBounds(23, 13, 156, 29);
		panel_2.add(LabelItemSelected);
		
		JButton DeleteButton = new JButton("Delete");
		DeleteButton.setBounds(70, 697, 143, 36);
		DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				list_1.remove(selected);
			}
		});
		
		
		DeleteButton.setForeground(Color.MAGENTA);
		DeleteButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		panel.add(DeleteButton);
		
		JButton OrderButton = new JButton("OrderItem");
		OrderButton.setBounds(241, 697, 159, 33);
		OrderButton.addActionListener(new ActionListener() {
			@SuppressWarnings({ "deprecation", "unused" })
			public void actionPerformed(ActionEvent e) {
				int sizs=list_1.getItemCount();
				int flag=0,flag2=0;
				String name;
				
				try {
					 
					Class.forName("com.mysql.jdbc.Driver");
			        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant?characterEncoding=latin1", "root", "S@s12345");
			        Statement stmt=con.createStatement();  
					ResultSet rs=stmt.executeQuery("select * from register");
					while(rs.next()) {
						if(Integer.parseInt(CustomerTextField.getText())==rs.getInt(6)) {
							flag2=1;
							customer1=rs.getString(2);
							break;}
					}
					}
					catch(Exception m)
					{
						
					}
				for(int i=0;i<sizs;i++)
				{
					name=list_1.getItem(i);
					
					
					if(name.length()>0) {
						
					
					System.out.println(name);
					
					PreparedStatement stat;
					
					try {
						
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant?characterEncoding=latin1", "root", "S@s12345");
				        Statement st=con.createStatement();
				        //JOptionPane.showMessageDialog(null,"Data is inserted successfully");
				        // con = DriverManager.getConnection(url);
				         stat = con.prepareStatement("insert into `order` values (?,?, ?, ?)");
				         
				         if(CustomerTextField.getText().length()>0)
				         {
				        	 
				         
				        stat.setInt(1,Integer.parseInt(CustomerTextField.getText()));
				        System.out.println(Integer.parseInt(CustomerTextField.getText()));
				        stat.setString(2,String.valueOf(name));
				        System.out.println(String.valueOf(name));
				        stat.setInt(3,origin.get(name));
				        stat.setString(4,"pending");
				       
				    	
				    	
				        int ans=origin.get(name);
				        map.put(name,ans+map.get(name));
				        System.out.println(map);
				        
						stat.executeUpdate();
						 flag=1;
				         }
				         
				         
				        
				        
				        
					}
					
					catch(Exception m)
					{
						flag=0;
						break;
						
					}
					}
					
				}
				if(flag==1 && flag2==1)
				{
					JOptionPane.showMessageDialog(new JFrame(),"Order Submitted Successfully");
				}
				else
				{
					JOptionPane.showMessageDialog(new JFrame(),"Please Enter The CustomerId");
				}
					
				
				
			}
		});
		OrderButton.setForeground(Color.MAGENTA);
		OrderButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		panel.add(OrderButton);
		
		JLabel CustomerIdLabel = new JLabel("Enter Customer Id");
		CustomerIdLabel.setBounds(486, 24, 185, 36);
		CustomerIdLabel.setForeground(Color.MAGENTA);
		CustomerIdLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		panel.add(CustomerIdLabel);
		
		CustomerTextField = new JTextField();
		CustomerTextField.setBounds(683, 24, 184, 36);
		panel.add(CustomerTextField);
		CustomerTextField.setColumns(10);
		
		
		
		JButton GenerateBill = new JButton("Generate Bill");
		GenerateBill.setBounds(79, 394, 196, 25);
		panel_3.setLayout(null);
		GenerateBill.setForeground(Color.MAGENTA);
		GenerateBill.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		panel_3.add(GenerateBill);
		
		JTextArea l3 = new JTextArea();
		l3.setForeground(Color.BLUE);
		l3.setFont(new Font("Arial", Font.BOLD, 18));
		l3.setEditable(false);
		l3.setBounds(39, 432, 285, 354);
		panel_3.add(l3);
		
		JLabel lblMenuitems = new JLabel("Menu_Items");
		lblMenuitems.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblMenuitems.setBounds(112, 10, 185, 25);
		panel_3.add(lblMenuitems);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame3 lo=new Frame3();
				frame.setVisible(false);
				lo.frame.setVisible(true);
				map.clear();
				origin.clear();
			}
		});
		btnLogout.setForeground(Color.RED);
		btnLogout.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnLogout.setBounds(179, 758, 129, 36);
		panel.add(btnLogout);
		
		
		
		GenerateBill.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				
				for (String name : map.keySet()) {  
					
		            map.put(name,map.get(name)-origin.get(name));
		            }
				float sum = 0.0f;
				for (float f : map.values()) {
				    sum += f;
				}
				
				if(customer1!=null) {
				String temp="CUSTOMER ID: "+CustomerTextField.getText()+"\n\nCUSTOMER NAME :"+customer1;
				for (String name : map.keySet())  
				{
					if(map.get(name)>0)
					temp=temp+"\n Food_Item_Name:"+name+"\nTotal price:"+String.valueOf(map.get(name));
				}
				temp=temp+"\n\n\n TOTAL_AMOUNT="+String.valueOf(sum)+"/-";
				l3.setText(temp);
				}
				else
				{
					JOptionPane.showMessageDialog(new JFrame(),"Please Enter The CustomerId");	
				}
				
			}
		});
		
	}
}
