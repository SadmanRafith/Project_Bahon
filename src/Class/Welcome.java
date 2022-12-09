import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.basic.BasicDesktopIconUI;

public class Welcome extends JFrame implements ActionListener {

	JLabel loginPageimg;
	JButton loginButton, registerButton, exitButton, adminloginButton;

	public Welcome() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		

		loginPageimg = new JLabel();
		loginPageimg.setIcon(new ImageIcon("welcome.png"));
		loginPageimg.setBounds(0, 0, 900, 590);
		loginPageimg.setLayout(null);
		this.add(loginPageimg);

		loginButton = new JButton("Login");
		loginButton.setBounds(150, 480, 130, 40);
		loginButton.setFocusable(false);
		loginButton.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 25));
		loginButton.setBackground(Color.decode("#2E75B6"));
		loginButton.setForeground(Color.white);
		loginPageimg.add(loginButton);

		registerButton = new JButton("Register");
		registerButton.setBounds(300, 480, 130, 40);
		registerButton.setFocusable(false);
		registerButton.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 25));
		registerButton.setBackground(Color.decode("#2E75B6"));
		registerButton.setForeground(Color.white);
		loginPageimg.add(registerButton);

		adminloginButton = new JButton("Admin Login");
		adminloginButton.setBounds(450, 480, 200, 40);
		adminloginButton.setFocusable(false);
		adminloginButton.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 25));
		adminloginButton.setBackground(Color.decode("#2E75B6"));
		adminloginButton.setForeground(Color.white);
		loginPageimg.add(adminloginButton);

		exitButton = new JButton("Exit");
		exitButton.setBounds(670, 480, 130, 40);
		exitButton.setFocusable(false);
		exitButton.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 25));
		exitButton.setBackground(Color.decode("#C00000"));
		exitButton.setForeground(Color.white);
		loginPageimg.add(exitButton);
		
		
		
		loginButton.addActionListener(this);
		registerButton.addActionListener(this);
		adminloginButton.addActionListener(this);
		exitButton.addActionListener(this);
		
		
		
	}

	public static void main(String[] args) {

		Welcome welcome = new Welcome();
		welcome.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==loginButton) {
		
			dispose();
			Login l = new Login();
			
	}
		
		if (e.getSource()==registerButton) {
			
			dispose();
			new Register();
			
	}
		
		
		if (e.getSource()==adminloginButton) {
			
			dispose();
			new AdminLogin();
	}
		
		if (e.getSource()==exitButton) {
			
			System.exit(0);
		
	}
		
	}
}
