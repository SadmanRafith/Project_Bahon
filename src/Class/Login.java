import javax.swing.*;
import java.awt.event.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static javax.swing.JOptionPane.showMessageDialog;

public class Login extends JFrame implements ActionListener {

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
	ImageIcon icon;

	Login() {

		Loginframe = new JFrame();

		Font headerText = new Font("Montserrat", Font.BOLD, 35);

		// --------------------------------------------- User Name Label
		userNameLabel = new JLabel("Username");
		userNameLabel.setBounds(520, 130, 150, 20);
		userNameLabel.setForeground(Color.black);

		// --------------------------------------------- password Label
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(520, 180, 150, 20);
		passwordLabel.setForeground(Color.black);

		// ---------------------------------------------- Login text label

		loginPageText = new JLabel("Login");
		loginPageText.setBounds(520, 70, 110, 50);
		loginPageText.setFont(headerText);
		loginPageText.setForeground(Color.orange);
		loginPageText.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.orange));
		// -------------------------------------------- Fields
		userNameText = new JTextField();
		userNameText.setBounds(520, 150, 240, 25);

		passwordText = new JPasswordField();
		passwordText.setBounds(520, 200, 240, 25);

		// ----------------------------------------------Login Button
		loginB = new JButton("Login");
		loginB.setBounds(520, 250, 240, 30);
		loginB.setBackground(Color.orange);
		loginB.setFocusable(false);
		// ----------------------------------------------SignUp Button
		signup = new JButton("Create a new account");
		signup.setBounds(520, 290, 240, 30);
		signup.setBackground(Color.orange);
		signup.setFocusable(false);

		// ---------------------------------------------Login Page Image
		loginPageImg = new JLabel();
		loginPageImg.setIcon(new ImageIcon("Login Page.jpg"));
		loginPageImg.setBounds(0, -290, 1902, 1076);

		// --------------------------------------------- Adding

		Loginframe.add(userNameLabel);
		Loginframe.add(passwordLabel);
		Loginframe.add(userNameText);
		Loginframe.add(passwordText);
		Loginframe.add(loginPageText);
		Loginframe.add(loginB);
		Loginframe.add(signup);
		Loginframe.add(loginPageImg);
		Loginframe.setResizable(false);

		Loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Loginframe.setLayout(null);

		Loginframe.setTitle("Vromon");
		icon = new ImageIcon(getClass().getResource("welcome.png"));
		Loginframe.setSize(815, 530);
		Loginframe.setIconImage(icon.getImage());

		loginB.addActionListener(this);
		signup.addActionListener(this);

		Loginframe.setVisible(true);
		Loginframe.setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == signup) {

			Loginframe.setVisible(false);
			new Register();
		}

		if (e.getSource() == loginB) {

			String user = userNameText.getText();
			String pass = passwordText.getText();
            String file = "D:/AIUB/Class Materials/SEMESTER-2 (summer 21-22)/OOP-1 (JAVA)/FINAL/PROJECT/Ticket System/src/Data/Registration.txt";
			if (user.isEmpty() || pass.isEmpty()) {
				
				
				JOptionPane.showMessageDialog(null, "Please Enter Username and Password");
			}

			else {

	            try {
                    String userName = "User Name: " + user;
                    String password = "Password: " + pass;
                    BufferedReader reader = new BufferedReader(new FileReader(file));

                    int totalLines = 0;
                    while (reader.readLine() != null)
                        totalLines++;
                    reader.close();

                    for (int i = 0; i <= totalLines; i++) {
                        String line1 = Files.readAllLines(Paths.get(file)).get(i+2);
                        if (line1.equals(userName)) {
                            String line2 = Files.readAllLines(Paths.get(file)).get((i + 3));
                            if (line2.equals(password)) {
                            	Loginframe.setVisible(false);
                                Login2 l = new Login2();
                                l.setVisible(true);
                                break;
                            }
                        }  
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid User Name or Password!", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                }

			}

		}

	}

	public static void main(String[] args) {
		new Login();

	}

}
