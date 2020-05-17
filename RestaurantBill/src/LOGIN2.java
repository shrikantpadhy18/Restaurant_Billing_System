import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LOGIN2 {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOGIN2 window = new LOGIN2();
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
	public LOGIN2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 719, 684);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(Color.GREEN, 3, true));
		panel.setBounds(27, 31, 644, 572);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		frame.setTitle("Choose Login");
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.ORANGE, 3, true));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(74, 92, 200, 375);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\shrikant padhy\\Desktop\\IMAGES\\AdminLoginType.jfif"));
		label.setBounds(0, 0, 202, 232);
		panel_1.add(label);
		
		JButton AdminButton = new JButton("ADMIN");
		AdminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Frame3 lo=new Frame3();
				lo.frame.setVisible(true);
			}
		});
		AdminButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		AdminButton.setForeground(Color.MAGENTA);
		AdminButton.setBounds(48, 272, 125, 38);
		panel_1.add(AdminButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBorder(new LineBorder(Color.ORANGE, 3, true));
		panel_2.setBounds(367, 92, 214, 375);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\shrikant padhy\\Desktop\\IMAGES\\CustomerLoginType.jfif"));
		label_1.setBounds(0, -11, 214, 242);
		panel_2.add(label_1);
		
		JButton btnCustomer = new JButton("CUSTOMER");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Frame3 lo=new Frame3();
				lo.frame.setVisible(true);
				
			}
		});
		btnCustomer.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		btnCustomer.setForeground(Color.MAGENTA);
		btnCustomer.setBounds(34, 277, 149, 39);
		panel_2.add(btnCustomer);
		
		JLabel LoginLabel = new JLabel("LOGIN HERE");
		LoginLabel.setForeground(Color.RED);
		LoginLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		LoginLabel.setBounds(12, 13, 150, 42);
		panel.add(LoginLabel);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
