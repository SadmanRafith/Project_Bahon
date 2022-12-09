import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Login2 extends JFrame implements ActionListener {
	ImageIcon icon;
	JLabel iconLabel,jLabel1,jLabel2;
	JButton Button1,Button2,Button3,backButton, exitButton;
	ImageIcon icon2;
	
	public Login2() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(820,630);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		
		
		this.setTitle("Vromon");
		icon = new ImageIcon(getClass().getResource("welcomeicon.png"));
		this.setIconImage(icon.getImage());
		
		
		icon = new ImageIcon(getClass().getResource("login2i.jpg"));
		iconLabel = new JLabel(icon);
		iconLabel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
		this.add(iconLabel);
		
		jLabel1 = new JLabel("WHAT TYPE OF TRANSPORT");
		jLabel1.setBounds(70,150,350,30);
		jLabel1.setFont(new Font("Arial",Font.PLAIN,22));
		jLabel1.setForeground(Color.white);
		iconLabel.add(jLabel1);
		
		jLabel2 = new JLabel("YOU WANT TO TRAVEL ?");
		jLabel2.setBounds(70,175,350,40);
		jLabel2.setFont(new Font("Arial",Font.BOLD,25));
		jLabel2.setForeground(Color.white);
		iconLabel.add(jLabel2);
		
		Button1 = new JButton("BUS",new ImageIcon(getClass().getResource("bus.png")));
		
		Button1.setBounds(70,220,180,30);
		Button1.setFocusable(false);
		Button1.setIconTextGap(10);
		Button1.setFont(new Font("Arial",Font.PLAIN,20));
		iconLabel.add(Button1);
		
		Button2 = new JButton("SHIP",new ImageIcon(getClass().getResource("ship.png")));
		Button2.setBounds(70,265,180,30);
		Button2.setFont(new Font("Arial",Font.PLAIN,20));
		Button2.setFocusable(false);
		iconLabel.add(Button2);
		
		Button3 = new JButton("FLIGHT",new ImageIcon(getClass().getResource("plane.png")));
		Button3.setBounds(70,310,180,30);
		Button3.setFont(new Font("Arial",Font.PLAIN,20));
		Button3.setFocusable(false);
		iconLabel.add(Button3);
		
		backButton = new JButton("Logout");
		backButton.setBounds(23,0,100,30);
		backButton.setBackground(Color.white);
		backButton.setFocusable(false);
		iconLabel.add(backButton);
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(690,0,90,30);
		exitButton.setBackground(Color.red);
		exitButton.setForeground(Color.white);
		exitButton.setFocusable(false);
		iconLabel.add(exitButton);

		
		Button3.addActionListener(this);
		Button1.addActionListener(this);
		Button2.addActionListener(this);
		backButton.addActionListener(this);
		exitButton.addActionListener(this);
        }

	public static void main(String[] args) {
		Login2 login2 = new Login2();
		login2.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==Button3)
		{
			dispose();
			PlaneDashboard plndsh = new PlaneDashboard();
			plndsh.setVisible(true);
		}
		if (e.getSource()==Button1)
		{
			dispose();
			BusDashboard bus = new BusDashboard();
			bus.setVisible(true);
		}
		if (e.getSource()==Button2)
		{
			dispose();
			ShipDashboard plndsh = new ShipDashboard();
			plndsh.setVisible(true);
		}
		if (e.getSource() == backButton) {
			dispose();
			new Login();
		}
		if (e.getSource()== exitButton) {
			dispose();
		}
		
	}

}
