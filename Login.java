import java.awt.BorderLayout;
import java.sql.*;
import java.util.Scanner;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.SystemColor;

public class Login extends JFrame {
	private static Connection con1;
	private JPanel contentPane;
	public static JTextField textField;
	private static String dbname;
	private static String uname;
	private static String psswrd;
	private JTextField txtLocalhost;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JTextField textField_4;
	private JPasswordField passwordField_3;
	private JPasswordField passwordField_4;
	private JPasswordField passwordField_5;
	private JPasswordField passwordField_6;
	private JTextField txtLocalhost_1;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Login(Gui3 window,JavaDB data) throws SQLException {
		setBounds(new Rectangle(200, 200, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/icons/1469850726_User_group.png")));
		setTitle("Administrator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.inactiveCaptionBorder);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
		);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.control);
		tabbedPane.addTab("Login", null, panel_2, null);
		tabbedPane.setBackgroundAt(0, Color.GRAY);
		
		JLabel lblUsername = new JLabel("Username:");
		
		JLabel lblPassword = new JLabel("Password:");
		
		JLabel lblServerAddress = new JLabel("Server Address:");
		
		JLabel lblDatabaseName = new JLabel("Select Database:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		passwordField_3 = new JPasswordField();
		
		txtLocalhost = new JTextField();
		txtLocalhost.setText("localhost");
		txtLocalhost.setColumns(10);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setEnabled(false);
		
				JButton btnLogin = new JButton("Login");
				
				JButton btnStart = new JButton("Start");
				btnStart.setEnabled(true);
				btnStart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//String text=new String(passwordField_3.getPassword());
						/*try {
							*/
							//setcon(JavaDB.prepareConnection(textField.getText(), text,comboBox_1.getSelectedItem().toString(),txtLocalhost.getText()));
							window.getframe().setVisible(true);
							dispose();
						/*} catch (ClassNotFoundException | SQLException e1) {
							String message = "No privelege on mentioned database!";
							JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
						}*/
						
					}
				});
				btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						/*String text=new String(passwordField_3.getPassword());
						try {
							
							setcon(JavaDB.prepareConnection(textField.getText(), text, txtLocalhost.getText()));
							String message = "Login Successful!";
							comboBox_1.setEnabled(true);*/
							btnStart.setEnabled(true);
							/*Statement stmt=getcon().createStatement();
							ResultSet rs=stmt.executeQuery("Show databases");
							while(rs.next())
							{
								String a=rs.getString("DATABASE");
								if(a.equals("information_schema")==false)
								{
							    comboBox_1.addItem(a);
								}
							}
							JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
							textField.setEnabled(false);
							passwordField_3.setEnabled(false);
							txtLocalhost.setEnabled(false);
							btnLogin.setEnabled(false);

						} catch (ClassNotFoundException | SQLException e1) {
							String message = "Invalid Password or username or Server address";
							JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
							textField.setText("");
							passwordField_3.setText("");
							
						}*/
					}
				});
				
				JLabel label = new JLabel("*localhost/IP");
				label.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 12));
				
				GroupLayout gl_panel_2 = new GroupLayout(panel_2);
				gl_panel_2.setHorizontalGroup(
					gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(168)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPassword)
								.addComponent(lblUsername)
								.addComponent(lblServerAddress)
								.addComponent(lblDatabaseName))
							.addGap(18)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addComponent(comboBox_1, Alignment.LEADING, 0, 192, Short.MAX_VALUE)
								.addComponent(passwordField_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
								.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
								.addComponent(txtLocalhost, Alignment.LEADING, 192, 192, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(btnStart)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
							.addGap(89))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(272)
							.addComponent(btnLogin)
							.addContainerGap(320, Short.MAX_VALUE))
				);
				gl_panel_2.setVerticalGroup(
					gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(70)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUsername))
							.addGap(18)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPassword)
								.addComponent(passwordField_3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtLocalhost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblServerAddress)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDatabaseName)
								.addComponent(btnStart))
							.addGap(18)
							.addComponent(btnLogin)
							.addContainerGap(116, Short.MAX_VALUE))
				);
				panel_2.setLayout(gl_panel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		tabbedPane.addTab("Admin", null, panel, null);
		JLabel lblIpAddress = new JLabel("IP Address:");
		
		txtLocalhost_1 = new JTextField();
		txtLocalhost_1.setText("localhost");
		txtLocalhost_1.setColumns(10);
		txtLocalhost_1.setCursor(getCursor());
		
		JLabel lblAdminPassword_1 = new JLabel("Admin Password:");
		
		JRadioButton rdbtnChangePassword = new JRadioButton("Change Password");
		
		rdbtnChangePassword.setEnabled(false);
		
		passwordField_4 = new JPasswordField();
		
		JLabel lblNewPassword_1 = new JLabel("New Password:");
		
		JLabel lblConfirmPassword_1 = new JLabel("Confirm Password:");
		
		passwordField_5 = new JPasswordField();
		passwordField_5.setEnabled(false);
		
		passwordField_6 = new JPasswordField();
		passwordField_6.setEnabled(false);
		JButton btnLogin_1 = new JButton("Login");
		
		JLabel lbllocalhostip = new JLabel("*localhost/IP");
		lbllocalhostip.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 12));
		
		JButton btnChange = new JButton("Change");
		btnChange.setEnabled(false);
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String psswd1=new String(passwordField_5.getPassword());
				String psswd2=new String(passwordField_6.getPassword());
				if(psswd1.equals(psswd2))
				{
					try {
						data.changepassword(getcon(), psswd1, txtLocalhost_1.getText() );
						String message = "Changed the password successfully!";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
					}
				}
				else
				{
					String message = "Password Dont match!!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		rdbtnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnChangePassword.isSelected()==true)
				{
				passwordField_6.setEnabled(true);
				passwordField_5.setEnabled(true);
				btnChange.setEnabled(true);
				}
				else
				{
					passwordField_6.setEnabled(false);
					passwordField_5.setEnabled(false);
					btnChange.setEnabled(false);
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(209)
							.addComponent(lblIpAddress)
							.addGap(18)
							.addComponent(txtLocalhost_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lbllocalhostip))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(175)
							.addComponent(lblAdminPassword_1)
							.addGap(18)
							.addComponent(passwordField_4, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(256)
							.addComponent(rdbtnChangePassword))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(169)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(19)
									.addComponent(lblNewPassword_1))
								.addComponent(lblConfirmPassword_1))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField_5, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField_6, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLogin_1))
							.addGap(37)
							.addComponent(btnChange)))
					.addContainerGap(100, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIpAddress)
						.addComponent(txtLocalhost_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbllocalhostip))
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdminPassword_1)
						.addComponent(passwordField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addComponent(rdbtnChangePassword)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewPassword_1)
							.addGap(30)
							.addComponent(lblConfirmPassword_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(passwordField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(passwordField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(24)
							.addComponent(btnChange)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLogin_1)
					.addGap(97))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.control);
		tabbedPane.addTab("Create Database", null, panel_3, null);
		
		JLabel lblDatabaseName_2 = new JLabel("DataBase Name:");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setEnabled(false);
		
		JButton btnCreate_1 = new JButton("Create");
		btnCreate_1.setToolTipText("Admin Login required to activate");
		btnCreate_1.setEnabled(false);
		
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(202)
							.addComponent(lblDatabaseName_2)
							.addGap(18)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(288)
							.addComponent(btnCreate_1)))
					.addContainerGap(188, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(78)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDatabaseName_2)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addComponent(btnCreate_1)
					.addContainerGap(221, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		tabbedPane.addTab("Create User", null, panel_1, null);
		
		JLabel lblNewUsername = new JLabel("New Username:");
		
		JLabel lblNewPassword = new JLabel("New Password:");
		
		JLabel lblConfirmPassword = new JLabel("ConFirm Password:");
		
		JLabel lblDatabaseName_1 = new JLabel("Grant Privelege on Database :");
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setEnabled(false);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setEnabled(false);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setEnabled(false);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setToolTipText("Admin Login required to activate");
		btnCreate.setEnabled(false);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text=new String(passwordField_1.getPassword());
				String psswd1=new String(passwordField_1.getPassword());
				String psswd2=new String(passwordField_2.getPassword());
				if(psswd1.equals(psswd2))
				{
				try {
					String a="";
					Statement stmt=getcon().createStatement();
					ResultSet rs=stmt.executeQuery("Select user from mysql.user");
					while(rs.next())
					{
						a=rs.getString("user");
						if(a.equals(textField_4.getText()))
						{
							break;
						}	
					}
					if(a.equals(textField_4.getText()))
					{
						data.GrantPrivilegesToUser(textField_4.getText(), text,comboBox.getSelectedItem().toString(),txtLocalhost_1.getText(), getcon());
						String message = "User Existed granted permission on mentioned database!";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
					data.CreateNewUser(textField_4.getText(), text,txtLocalhost_1.getText(), getcon(),comboBox.getSelectedItem().toString());
					String message = "Created a New User!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (ClassNotFoundException | SQLException e1) {
					String message = "Oops!! Unable to do it... or No Left Fields blank!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
				}
				}
				else{
					String message = "Passwords didnot match!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCreate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						data.CreateNewDatabase(textField_5.getText(),getcon());
						textField_5.setText("");
						String message = "Created the Database!";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
						comboBox.removeAllItems();
						ResultSet rs = getcon().getMetaData().getCatalogs();

						while (rs.next()) {
						    comboBox.addItem(rs.getString("TABLE_CAT"));
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						String message = "Left the Fields Blank!";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		btnLogin_1.addActionListener(new ActionListener() {
			public  void actionPerformed(ActionEvent arg0) {
				String text=new String(passwordField_4.getPassword());
				try {
					Connection con=JavaDB.prepareConnection("root",text,txtLocalhost_1.getText());
					setcon(con);
					rdbtnChangePassword.setEnabled(true);
					passwordField_4.setText("");
					passwordField_1.setEnabled(true);
					passwordField_2.setEnabled(true);
					textField_4.setEnabled(true);
					textField_5.setEnabled(true);
					btnCreate_1.setEnabled(true);
					comboBox.setEnabled(true);
					btnLogin_1.setEnabled(false);
					btnCreate.setEnabled(true);
					String message = "Login Successful!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
					ResultSet rs = con.getMetaData().getCatalogs();

					while (rs.next()) {
						String a=rs.getString("TABLE_CAT");
						if(a.equals("information_schema")==false & a.equals("mysql")==false & a.equals("sys")==false)
						{
					    comboBox.addItem(a);
						}
					}
					
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					String message = "Invalid Password or No Input Provided";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(115)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewPassword)
						.addComponent(lblNewUsername)
						.addComponent(lblConfirmPassword)
						.addComponent(lblDatabaseName_1))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(passwordField_2, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(203, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(266)
					.addComponent(btnCreate)
					.addContainerGap(318, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(52)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewUsername)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewPassword)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConfirmPassword)
						.addComponent(passwordField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDatabaseName_1)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addComponent(btnCreate)
					.addGap(124))
		);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
	}
	public static void setcon(Connection con)
	{
		con1=con;
	}
	public static Connection getcon()
	{
		return con1;
	}
	public static void setdbname(String a)
	{
		dbname=a;
	}
	public static String getdbname()
	{
		return dbname;
	}
	public static void setuname(String a)
	{
		uname=a;
	}
	public static String getuname()
	{
		return uname;
	}
	public static void setpsswd(String a)
	{
		psswrd=a;
	}
	public static String getpsswd()
	{
		return psswrd;
	}
}
