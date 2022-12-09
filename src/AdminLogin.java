import javax.swing.*;
import java.awt.event.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;

public class AdminLogin extends JFrame implements ActionListener {

	JFrame Loginframe;
	JLabel userNameLabel;
	JLabel passwordLabel;
	JLabel loginPageImg;
	JLabel loginPageText;
	JLabel userLogo;
	JLabel passLogo;

	JTextField userNameText;
	JTextField passwordText;

	JButton loginB;
	JButton signup;
	JButton forgetpass;

	AdminLogin() {

		Loginframe = new JFrame();
		
		

		Font headerText = new Font("Montserrat", Font.BOLD, 35);

		// --------------------------------------------- User Name Label
		userNameLabel = new JLabel("Username");
		userNameLabel.setBounds(300, 180, 150, 20);
		userNameLabel.setForeground(Color.white);

		// --------------------------------------------- password Label
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(300, 230, 150, 20);
		passwordLabel.setForeground(Color.WHITE);

		// ---------------------------------------------- Login text label

		loginPageText = new JLabel("Admin   Login");
		loginPageText.setBounds(300, 120, 240, 50);
		loginPageText.setFont(headerText);
		loginPageText.setForeground(Color.orange);
		loginPageText.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.orange));
		// -------------------------------------------- Fields
		userNameText = new JTextField();
		userNameText.setBounds(300, 200, 240, 25);

		passwordText = new JPasswordField();
		passwordText.setBounds(300, 250, 240, 25);

		// ----------------------------------------------Login Button
		loginB = new JButton("Login");
		loginB.setBounds(300, 290, 240, 30);
		loginB.setBackground(Color.orange);
		loginB.setFocusable(false);
		// ----------------------------------------------SignUp Button
//      		signup= new JButton("Create a new account");
//      		signup.setBounds(300,290,240,30);
//      		signup.setBackground(Color.orange);
//      		signup.setFocusable(false);

		// ---------------------------------------------Login Page Image

		loginPageImg = new JLabel();
		loginPageImg.setIcon(new ImageIcon("admin.png"));
		loginPageImg.setBounds(0, -290, 1902, 1076);

		// --------------------------------------------- Adding

		Loginframe.add(userNameLabel);
		Loginframe.add(passwordLabel);
		Loginframe.add(userNameText);
		Loginframe.add(passwordText);
		Loginframe.add(loginPageText);
		Loginframe.add(loginB);
		Loginframe.add(loginPageImg);
		Loginframe.setResizable(false);

		Loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Loginframe.setLayout(null);

		Loginframe.setTitle("Traveller");
		Loginframe.setSize(813, 530);

		loginB.addActionListener(this);

		Loginframe.setVisible(true);
		Loginframe.setLocationRelativeTo(null);
		
		JOptionPane.showMessageDialog(null, "Admin default name admin and Pass admin");
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == loginB) {

			String user = userNameText.getText();
			String pass = passwordText.getText();

			if (user.isEmpty() || pass.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please fill up all information");
			}

			else {

				if (user.equals("admin") && pass.equals("admin")) {
					Loginframe.setVisible(false);

					Loginframe.setVisible(false);
					Login2 lg2 = new Login2();
					lg2.setVisible(true);
				}

			}
		}

	}

	public static void main(String[] args) {
		new AdminLogin();

	}

}
