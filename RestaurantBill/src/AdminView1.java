import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminView1 {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView1 window = new AdminView1();
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
	public AdminView1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setForeground(Color.GREEN);
		frame.getContentPane().setBackground(Color.MAGENTA);
		frame.setBounds(100, 100, 840, 615);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel UpdateNenuCardLabel = new JPanel();
		UpdateNenuCardLabel.setBorder(new LineBorder(Color.RED, 3, true));
		UpdateNenuCardLabel.setBounds(32, 180, 191, 227);
		frame.getContentPane().add(UpdateNenuCardLabel);
		UpdateNenuCardLabel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\shrikant padhy\\Desktop\\IMAGES\\menuCard1.jpg"));
		lblNewLabel.setBounds(12, 13, 168, 141);
		UpdateNenuCardLabel.add(lblNewLabel);
		
		JButton MenuUpdateButton = new JButton("UpdateMenu");
		MenuUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				UpdateMenu lo=new UpdateMenu();
				lo.frame.setVisible(true);
				
			}
		});
		MenuUpdateButton.setForeground(Color.MAGENTA);
		MenuUpdateButton.setFont(new Font("Arial", Font.BOLD, 17));
		MenuUpdateButton.setBounds(12, 169, 157, 45);
		UpdateNenuCardLabel.add(MenuUpdateButton);
		
		JPanel DeleteOrder = new JPanel();
		DeleteOrder.setBorder(new LineBorder(Color.RED, 3, true));
		DeleteOrder.setBounds(290, 180, 200, 227);
		frame.getContentPane().add(DeleteOrder);
		DeleteOrder.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\shrikant padhy\\Desktop\\IMAGES\\bill.jfif"));
		lblNewLabel_1.setBounds(12, 13, 176, 148);
		DeleteOrder.add(lblNewLabel_1);
		
		JButton ViewBillButton = new JButton("ViewBills");
		ViewBillButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewBill lo=new ViewBill();
				frame.setVisible(false);
				lo.frame.setVisible(true);
				
			}
		});
		ViewBillButton.setForeground(Color.MAGENTA);
		ViewBillButton.setFont(new Font("Arial", Font.BOLD, 16));
		ViewBillButton.setBounds(35, 174, 125, 40);
		DeleteOrder.add(ViewBillButton);
		
		JPanel View_Bills = new JPanel();
		View_Bills.setBorder(new LineBorder(Color.RED, 3, true));
		View_Bills.setBounds(563, 180, 200, 227);
		frame.getContentPane().add(View_Bills);
		View_Bills.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\shrikant padhy\\Desktop\\IMAGES\\ViewPayment.jfif"));
		lblNewLabel_2.setBounds(12, 13, 176, 162);
		View_Bills.add(lblNewLabel_2);
		
		JButton btnViewpayment = new JButton("UpdatePayment");
		btnViewpayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteOrders lo=new DeleteOrders();
				frame.setVisible(false);
				lo.frame.setVisible(true);
				
			}
		});
		btnViewpayment.setFont(new Font("Arial", Font.BOLD, 16));
		btnViewpayment.setForeground(Color.MAGENTA);
		btnViewpayment.setBounds(22, 178, 166, 36);
		View_Bills.add(btnViewpayment);
		
		JPanel AdminPanel = new JPanel();
		AdminPanel.setBackground(Color.WHITE);
		AdminPanel.setBorder(new LineBorder(Color.RED, 3, true));
		AdminPanel.setBounds(32, 13, 731, 124);
		frame.getContentPane().add(AdminPanel);
		AdminPanel.setLayout(null);
		
		JLabel AdminLabel = new JLabel("ADMIN VIEW");
		AdminLabel.setBackground(Color.WHITE);
		AdminLabel.setForeground(Color.BLUE);
		AdminLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 29));
		AdminLabel.setBounds(264, 50, 350, 48);
		AdminPanel.add(AdminLabel);
		
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
		btnLogout.setBounds(554, 13, 132, 25);
		AdminPanel.add(btnLogout);
	}

}
