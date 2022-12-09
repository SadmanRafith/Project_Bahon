import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class AdminDashboard extends JFrame implements ActionListener{
	
	JPanel menuPanel,titleJPanel,dataTablePanel,busTablePanel,SteamerTablePanel,airplaneTablePanel;
	JLabel menuLabel,titleJLabel;
	JButton button,busButton,steamerButton,airPlaneButton,adduserButton,logoutButton,dltButton;
	JTable table,busTable,steamerTable,airPlanetTable;
	DefaultTableModel model,busModel,steamerModel,airPlaneModel;
	JScrollPane pane,busPane,steamerPane,airPlanePane;
	ImageIcon icon;
	
	String[] column= new String[] {"First Name","Last Name","User Name","Password","Phone Number","Email"};
	String[] row = new String[6];
	
	
	String[] column2= new String[] {"From","To","Booking Date","Arrival","Seat No","Type","Coach","Time","Total Cost"};
	String[] row2 = new String[9];
	
	String[] column3= new String[] {"From","To","Booking Date","Arrival","Seat No","Type","Time","Total Cost"};
	String[] row3 = new String[8];
	
	String[] column4= new String[] {"From","To","Booking Date","Arrival","Seat No","Type","Coach","Time","Total Cost"};
	String[] row4 = new String[9];
	
	
	public AdminDashboard() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		
		
		this.setTitle("Vromon");
		icon = new ImageIcon(getClass().getResource("welcomeicon.png"));
		this.setIconImage(icon.getImage());
		
		titleJPanel = new JPanel();
		titleJPanel.setBounds(0,0,900,50);
		titleJPanel.setBackground(Color.gray);
		titleJPanel.setLayout(null);
		this.add(titleJPanel);
		
		titleJLabel = new JLabel("**Vromon** Admin Dashboard");
		titleJLabel.setBounds(250,0,500,40);
		titleJLabel.setForeground(Color.white);
		titleJLabel.setFont(new Font("Segoe UI SemiBold",Font.ITALIC,35));
		titleJPanel.add(titleJLabel);
		
		
		
		menuPanel = new JPanel();
		menuPanel.setBounds(0,50,170,600);
		menuPanel.setBackground(Color.decode("#a2d2ff"));
		menuPanel.setLayout(null);
		this.add(menuPanel);
		
		menuLabel = new JLabel("Menu");
		menuLabel.setBounds(10,20,100,30);
		menuLabel.setFont(new Font("Arial",Font.BOLD,20));
		menuPanel.add(menuLabel);
		
				
		button = new JButton("User Data");
		button.setBounds(0,60,170,40);
		button.setFocusable(false);
		button.setFont(new Font("Segoe UI SemiBold",Font.PLAIN,20));
		button.setForeground(Color.white);
		button.setBackground(Color.decode("#3a86ff"));
		menuPanel.add(button);
		
		busButton = new JButton("Bus Data");
		busButton.setBounds(0,110,170,40);
		busButton.setFocusable(false);
		busButton.setFont(new Font("Segoe UI SemiBold",Font.PLAIN,20));
		busButton.setForeground(Color.white);
		busButton.setBackground(Color.decode("#3a86ff"));
		menuPanel.add(busButton);
		
		steamerButton = new JButton("Steamer Data");
		steamerButton.setBounds(0,160,170,40);
		steamerButton.setFocusable(false);
		steamerButton.setFont(new Font("Segoe UI SemiBold",Font.PLAIN,20));
		steamerButton.setForeground(Color.white);
		steamerButton.setBackground(Color.decode("#3a86ff"));
		menuPanel.add(steamerButton);
		
		airPlaneButton = new JButton("Airplane Data");
		airPlaneButton.setBounds(0,210,170,40);
		airPlaneButton.setFocusable(false);
		airPlaneButton.setFont(new Font("Segoe UI SemiBold",Font.PLAIN,20));
		airPlaneButton.setForeground(Color.white);
		airPlaneButton.setBackground(Color.decode("#3a86ff"));
		menuPanel.add(airPlaneButton);
		
		adduserButton = new JButton("ADD User");
		adduserButton.setBounds(0, 260, 170, 40);
		adduserButton.setFocusable(false);
		adduserButton.setFont(new Font("Segoe UI SemiBold",Font.PLAIN,20));
		adduserButton.setForeground(Color.white);
		adduserButton.setBackground(Color.decode("#3a86ff"));
		menuPanel.add(adduserButton);
		
		
		logoutButton = new JButton("Logout");
		logoutButton.setBounds(0, 310, 170, 40);
		logoutButton.setFocusable(false);
		logoutButton.setFont(new Font("Segoe UI SemiBold",Font.PLAIN,20));
		logoutButton.setForeground(Color.white);
		logoutButton.setBackground(Color.decode("#3a86ff"));
		menuPanel.add(logoutButton);
		
		
		userDataTable();
		busDataTable();
		steamerDataTable();
		airPlaneDataTable();
			
		
		button.addActionListener(this);
		busButton.addActionListener(this);
		steamerButton.addActionListener(this);
		airPlaneButton.addActionListener(this);
		dltButton.addActionListener(this);
		logoutButton.addActionListener(this);
		adduserButton.addActionListener(this);
		
	
	}
	
		
public void userDataTable() {
		dataTablePanel = new JPanel();
		dataTablePanel.setBounds(170,50,730,550);
		dataTablePanel.setBackground(Color.darkGray);
		dataTablePanel.setLayout(null);
	//	dataTablePanel.setVisible(false);
		this.add(dataTablePanel);
		
		
		
		
		
		table = new JTable();
		model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		table.setModel(model);
		table.setFont(new Font("Segoe UI", Font.BOLD, 10));
		table.setSelectionBackground(Color.pink);
		table.setRowHeight(30);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.getColumnModel().getColumn(5).setPreferredWidth(120);

		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBackground(Color.gray);
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("Segoe UI", Font.ITALIC, 15));

		pane = new JScrollPane(table);
		pane.setBounds(20, 20, 650, 360);
		dataTablePanel.add(pane);
		
		
		
		String file1 = "D:\\AIUB\\Class Materials\\SEMESTER-2 (summer 21-22)\\OOP-1 (JAVA)\\FINAL\\PROJECT\\Ticket System\\src\\Data\\Registration.txt";
		// ============================================add data
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file1));
			int totalLines = 0;

			while (reader.readLine() != null)
				totalLines++;
			reader.close();

			for (int i = 0; i < totalLines; i++) {
				String line = Files.readAllLines(Paths.get(file1)).get(i);
				String a = line.substring(0, 10);
				if (a.equals("First Name")) {
					row[0] = Files.readAllLines(Paths.get(file1)).get(i).substring(12);
					row[1] = Files.readAllLines(Paths.get(file1)).get(i + 1).substring(11);
					row[2] = Files.readAllLines(Paths.get(file1)).get(i + 2).substring(11);
					row[3] = Files.readAllLines(Paths.get(file1)).get(i + 3).substring(10);
					row[4] = Files.readAllLines(Paths.get(file1)).get(i + 4).substring(14);
					row[5] = Files.readAllLines(Paths.get(file1)).get(i + 5).substring(7);
					model.addRow(row);
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		
		dltButton = new JButton("Delete");
		dltButton.setBounds(270, 400, 130, 30);
		dltButton.setFocusable(false);
		dataTablePanel.add(dltButton);
}
	
	
public void busDataTable() {
		
		
		busTablePanel = new JPanel();
		busTablePanel.setBounds(170,50,730,550);
		busTablePanel.setBackground(Color.darkGray);
		busTablePanel.setLayout(null);
		busTablePanel.setVisible(false);
		this.add(busTablePanel);
		
		busTable = new JTable();
		busModel = new DefaultTableModel();
		busModel.setColumnIdentifiers(column2);
		busTable.setModel(busModel);
		busTable.setFont(new Font("Segoe UI", Font.BOLD, 10));
		busTable.setSelectionBackground(Color.pink);
		busTable.setRowHeight(30);
		
		busTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		busTable.getColumnModel().getColumn(0).setPreferredWidth(100);
		busTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		busTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		busTable.getColumnModel().getColumn(3).setPreferredWidth(100);
		busTable.getColumnModel().getColumn(4).setPreferredWidth(100);
		busTable.getColumnModel().getColumn(5).setPreferredWidth(100);
		busTable.getColumnModel().getColumn(6).setPreferredWidth(100);
		busTable.getColumnModel().getColumn(7).setPreferredWidth(100);
		busTable.getColumnModel().getColumn(8).setPreferredWidth(100);

		JTableHeader tableHeader = busTable.getTableHeader();
		tableHeader.setBackground(Color.gray);
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("Segoe UI", Font.ITALIC, 15));

		busPane = new JScrollPane(busTable);
		busPane.setBounds(20, 20, 670, 400);
		busTablePanel.add(busPane);
		
		String file1 = "D:\\AIUB\\Class Materials\\SEMESTER-2 (summer 21-22)\\OOP-1 (JAVA)\\FINAL\\PROJECT\\Ticket System\\src\\Data\\BusData.txt";
		
		// ============================================add data
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file1));
			int totalLines = 0;

			while (reader.readLine() != null)
				totalLines++;
			reader.close();

			for (int i = 0; i < totalLines; i++) {
				String line = Files.readAllLines(Paths.get(file1)).get(i);
				String a = line.substring(0, 4);
				if (a.equals("From")) {
					row2[0] = Files.readAllLines(Paths.get(file1)).get(i ).substring(7);
					row2[1] = Files.readAllLines(Paths.get(file1)).get(i + 1).substring(5);
					row2[2] = Files.readAllLines(Paths.get(file1)).get(i + 2).substring(14);
					row2[3] = Files.readAllLines(Paths.get(file1)).get(i + 3).substring(10);
					row2[4] = Files.readAllLines(Paths.get(file1)).get(i + 4).substring(10);
					row2[5] = Files.readAllLines(Paths.get(file1)).get(i + 5).substring(7);
					row2[6] = Files.readAllLines(Paths.get(file1)).get(i + 6).substring(7);
					row2[7] = Files.readAllLines(Paths.get(file1)).get(i + 7).substring(7);
					row2[8] = Files.readAllLines(Paths.get(file1)).get(i + 8).substring(13);
					busModel.addRow(row2);
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
public void steamerDataTable() {
	
		SteamerTablePanel = new JPanel();
		SteamerTablePanel.setBounds(170,50,730,550);
		SteamerTablePanel.setBackground(Color.darkGray);
		SteamerTablePanel.setLayout(null);
		SteamerTablePanel.setVisible(false);
		this.add(SteamerTablePanel);
		
		steamerTable = new JTable();
		steamerModel = new DefaultTableModel();
		steamerModel.setColumnIdentifiers(column3);
		steamerTable.setModel(steamerModel);
		steamerTable.setFont(new Font("Segoe UI", Font.BOLD, 10));
		steamerTable.setSelectionBackground(Color.pink);
		steamerTable.setRowHeight(30);
		
		steamerTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		steamerTable.getColumnModel().getColumn(0).setPreferredWidth(100);
		steamerTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		steamerTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		steamerTable.getColumnModel().getColumn(3).setPreferredWidth(100);
		steamerTable.getColumnModel().getColumn(4).setPreferredWidth(100);
		steamerTable.getColumnModel().getColumn(5).setPreferredWidth(100);
		steamerTable.getColumnModel().getColumn(6).setPreferredWidth(100);
		steamerTable.getColumnModel().getColumn(7).setPreferredWidth(100);

		JTableHeader tableHeader = steamerTable.getTableHeader();
		tableHeader.setBackground(Color.gray);
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("Segoe UI", Font.ITALIC, 15));

		steamerPane = new JScrollPane(steamerTable);
		steamerPane.setBounds(20, 20, 650, 360);
		SteamerTablePanel.add(steamerPane);
		
		String file1 = "D:\\AIUB\\Class Materials\\SEMESTER-2 (summer 21-22)\\OOP-1 (JAVA)\\FINAL\\PROJECT\\Ticket System\\src\\Data\\ShipData.txt";
		// ============================================add data
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file1));
			int totalLines = 0;

			while (reader.readLine() != null)
				totalLines++;
			reader.close();

			for (int i = 0; i < totalLines; i++) {
				String line = Files.readAllLines(Paths.get(file1)).get(i);
				String a = line.substring(0, 4);
				if (a.equals("From")) {
					row3[0] = Files.readAllLines(Paths.get(file1)).get(i).substring(7);
					row3[1] = Files.readAllLines(Paths.get(file1)).get(i + 1).substring(5);
					row3[2] = Files.readAllLines(Paths.get(file1)).get(i + 2).substring(14);
					row3[3] = Files.readAllLines(Paths.get(file1)).get(i + 3).substring(10);
					row3[4] = Files.readAllLines(Paths.get(file1)).get(i + 4).substring(10);
					row3[5] = Files.readAllLines(Paths.get(file1)).get(i + 5).substring(7);
					row3[6] = Files.readAllLines(Paths.get(file1)).get(i + 6).substring(7);
					row3[7] = Files.readAllLines(Paths.get(file1)).get(i + 7).substring(13);
					steamerModel.addRow(row3);
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
public void airPlaneDataTable() {
		
		
		airplaneTablePanel = new JPanel();
		airplaneTablePanel.setBounds(170,50,730,550);
		airplaneTablePanel.setBackground(Color.darkGray);
		airplaneTablePanel.setLayout(null);
		airplaneTablePanel.setVisible(false);
		this.add(airplaneTablePanel);
		
		airPlanetTable = new JTable();
		airPlaneModel = new DefaultTableModel();
		airPlaneModel.setColumnIdentifiers(column4);
		airPlanetTable.setModel(airPlaneModel);
		airPlanetTable.setFont(new Font("Segoe UI", Font.BOLD, 10));
		airPlanetTable.setSelectionBackground(Color.pink);
		airPlanetTable.setRowHeight(30);
		
		airPlanetTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		airPlanetTable.getColumnModel().getColumn(0).setPreferredWidth(100);
		airPlanetTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		airPlanetTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		airPlanetTable.getColumnModel().getColumn(3).setPreferredWidth(100);
		airPlanetTable.getColumnModel().getColumn(4).setPreferredWidth(100);
		airPlanetTable.getColumnModel().getColumn(5).setPreferredWidth(100);
		airPlanetTable.getColumnModel().getColumn(6).setPreferredWidth(100);
		airPlanetTable.getColumnModel().getColumn(7).setPreferredWidth(100);
		airPlanetTable.getColumnModel().getColumn(8).setPreferredWidth(100);

		JTableHeader tableHeader = airPlanetTable.getTableHeader();
		tableHeader.setBackground(Color.gray);
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("Segoe UI", Font.ITALIC, 15));

		airPlanePane = new JScrollPane(airPlanetTable);
		airPlanePane.setBounds(20, 20, 650, 360);
		airplaneTablePanel.add(airPlanePane);
		
		String file1 = "D:\\AIUB\\Class Materials\\SEMESTER-2 (summer 21-22)\\OOP-1 (JAVA)\\FINAL\\PROJECT\\Ticket System\\src\\Data\\PlaneData.txt";
		// ============================================add data
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file1));
			int totalLines = 0;

			while (reader.readLine() != null)
				totalLines++;
			reader.close();

			for (int i = 0; i < totalLines; i++) {
				String line = Files.readAllLines(Paths.get(file1)).get(i);
				String a = line.substring(0, 4);
				if (a.equals("From")) {
					row4[0] = Files.readAllLines(Paths.get(file1)).get(i).substring(7);
					row4[1] = Files.readAllLines(Paths.get(file1)).get(i + 1).substring(5);
					row4[2] = Files.readAllLines(Paths.get(file1)).get(i + 2).substring(14);
					row4[3] = Files.readAllLines(Paths.get(file1)).get(i + 3).substring(10);
					row4[4] = Files.readAllLines(Paths.get(file1)).get(i + 4).substring(10);
					row4[5] = Files.readAllLines(Paths.get(file1)).get(i + 5).substring(7);
					row4[6] = Files.readAllLines(Paths.get(file1)).get(i + 6).substring(11);
					row4[7] = Files.readAllLines(Paths.get(file1)).get(i + 7).substring(7);
					row4[8] = Files.readAllLines(Paths.get(file1)).get(i + 8).substring(13);
					airPlaneModel.addRow(row4);
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			dataTablePanel.setVisible(true);
			busTablePanel.setVisible(false);
			SteamerTablePanel.setVisible(false);
			airplaneTablePanel.setVisible(false);
		}
		if (e.getSource()==busButton) {
			busTablePanel.setVisible(true);
			dataTablePanel.setVisible(false);
			SteamerTablePanel.setVisible(false);
			airplaneTablePanel.setVisible(false);
		}
		if (e.getSource()==steamerButton) {
			SteamerTablePanel.setVisible(true);
			busTablePanel.setVisible(false);
			dataTablePanel.setVisible(false);
			airplaneTablePanel.setVisible(false);
		}
		if (e.getSource()==airPlaneButton) {
			airplaneTablePanel.setVisible(true);
			busTablePanel.setVisible(false);
			dataTablePanel.setVisible(false);
			SteamerTablePanel.setVisible(false);
			
		}
		
		if (e.getSource()==dltButton) {
			String file = "D:\\AIUB\\Class Materials\\SEMESTER-2 (summer 21-22)\\OOP-1 (JAVA)\\FINAL\\PROJECT\\Ticket System\\src\\Data\\Registration.txt";
			String temp = "D:\\AIUB\\Class Materials\\SEMESTER-2 (summer 21-22)\\\\OOP-1 (JAVA)\\FINAL\\PROJECT\\Ticket System\\src\\Data\\trmp.txt";
			
	
			 if (table.getSelectionModel().isSelectionEmpty()) {
                 JOptionPane.showMessageDialog(null, "Please select a user to delete", "Warning!",
                         JOptionPane.WARNING_MESSAGE);
             } else {
                 String removeUser = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();

                 File oldFile = new File(file);
                 File newFile = new File(temp);

                 int q = 0;

                 try {

                     BufferedReader reader = new BufferedReader(new FileReader(file));
                     int totalLines = 0;
                     while (reader.readLine() != null)
                         totalLines++;
                     reader.close();
                     

                     for (int i = 0; i < totalLines; i++) {
                         String line = Files.readAllLines(Paths.get(file)).get(i);
                         String x = line.substring(0, 10);
                         if (x.equals("First Name")) {
                             String userName = Files.readAllLines(Paths.get(file)).get(i);
                             if (userName.substring(12).equals(removeUser)) {
                                 q = i;
                             }
                         }
                     }
                 } catch (Exception ex) {
                     return;
                 }

                 try {

                     FileWriter fw = new FileWriter(temp, true);
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter pw = new PrintWriter(bw);

                     FileReader fr = new FileReader(file);
                     BufferedReader br = new BufferedReader(fr);

                     BufferedReader reader = new BufferedReader(new FileReader(file));
                     int totalLines = 0;
                     while (reader.readLine() != null)
                         totalLines++;
                     reader.close();

                     for (int j = 0; j < totalLines; j++) {
                         String line = Files.readAllLines(Paths.get(file)).get(j);
                         String x = line.substring(0, 10);

                         if (q != 0 && (j == q || j == (q + 1) || j == (q + 2) || j == (q + 3) || j == (q + 4) || j == (q + 5))) {
                             String userName = Files.readAllLines(Paths.get(file)).get(j);
                             pw.println("#Removed! " + userName);
                         } else {
                             String userName = Files.readAllLines(Paths.get(file)).get(j);
                             pw.println(userName);
                         }
                     }
                     pw.flush();
                     pw.close();
                     fr.close();
                     br.close();
                     bw.close();
                     fw.close();

                 } catch (Exception ex) {
                     System.out.print(ex);
                 }

                 oldFile.delete();
                 File dump = new File(file);
                 newFile.renameTo(dump);
                 
                 dispose();
                 AdminDashboard a=new AdminDashboard();
                 a.setVisible(true);

             }
		}
		
		
		if (e.getSource()==logoutButton) {
			
			System.exit(0);
		}
		
		if (e.getSource()==adduserButton) {
			dispose();
			new AddUserByAdmin();
			
		}
	
		
	}	
	
	public static void main(String[] args) {
		AdminDashboard a = new AdminDashboard();
		a.setVisible(true);
	}
}