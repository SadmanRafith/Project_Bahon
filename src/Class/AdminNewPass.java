import javax.swing.*;
import java.awt.event.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import static javax.swing.JOptionPane.showMessageDialog;

public class AdminNewPass extends JFrame implements ActionListener {

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

	AdminNewPass() {

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

		loginPageText = new JLabel("Change Pass");
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
		loginB = new JButton("Change");
		loginB.setBounds(300, 290, 240, 30);
		loginB.setBackground(Color.orange);
		loginB.setFocusable(false);
		// ----------------------------------------------Change Pass Button
		
//		changePassButton = new JButton("Change Password");
//		changePassButton.setBounds(300, 330, 240, 30);
//		changePassButton.setBackground(Color.orange);
//		changePassButton.setFocusable(false);

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
		//Loginframe.add(changePassButton);
		Loginframe.add(loginPageImg);
		Loginframe.setResizable(false);

		Loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Loginframe.setLayout(null);

		Loginframe.setTitle("Traveller");
		Loginframe.setSize(813, 530);

		loginB.addActionListener(this);

		Loginframe.setVisible(true);
		Loginframe.setLocationRelativeTo(null);
		
		//JOptionPane.showMessageDialog(null, "Admin default name admin and Pass admin");
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == loginB) {

			String user = userNameText.getText();
			String pass = passwordText.getText();

			if (user.isEmpty() || pass.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please fill up all information");
			}

			else {

				try {
					String file = "D:/AIUB/Class Materials/SEMESTER-2 (summer 21-22)/OOP-1 (JAVA)/FINAL/PROJECT/Ticket System/src/Data/AdminData.txt";
					
					File oldfile = new File (file);
					oldfile.delete();
					File newfile = new File (file);
		    		
		    		if(!newfile.exists()) {
		    			
		    			newfile.createNewFile();
		    		}
		    		
		    		FileWriter fileWriter = new FileWriter(file,true);
		    		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		    		PrintWriter printWriter = new PrintWriter(fileWriter);
		    		
		    		
		    		printWriter.println("User Name: "+user);
		    		printWriter.println("Password: "+pass);
		    		printWriter.println("=========================================");
		    		
		    		
		    		printWriter.flush();
		    		printWriter.close();
		    		bufferedWriter.close();
		    		fileWriter.close();
		    		
		    		JOptionPane.showMessageDialog(null,"Password Change Successful");
		    		Loginframe.setVisible(false);
		    		new AdminLogin();
				} 
				
				
				catch (Exception e2) {
					
					System.out.println(e2);
				}

			}
		}
		
	}

	public static void main(String[] args) {
		new AdminNewPass();

	}

}
