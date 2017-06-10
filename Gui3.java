import java.awt.EventQueue;
import com.itextpdf.text.Document;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

import org.jdatepicker.util.*;
import org.jdatepicker.impl.*;
import org.jdatepicker.*;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.Color;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.DefaultEditorKit;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Rectangle;
import java.awt.ScrollPane;
import java.awt.Dimension;
import javax.swing.JFormattedTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.SystemColor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.awt.event.InputEvent;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JToolBar;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Gui3 {

	private  JFrame frame;
	private JFormattedTextField ano;
	private JFormattedTextField cno;
	private JFormattedTextField publisher;
	private JFormattedTextField title;
	private JFormattedTextField author;
	private JFormattedTextField isbn;
	static JTable table_1;
	private JFormattedTextField textField_8;
	private JFormattedTextField textField_12;
	private JFormattedTextField textField_13;
	private JFormattedTextField textField_14;
	private JFormattedTextField textField_15;
	private JFormattedTextField magname;
	private JFormattedTextField society;
	private JFormattedTextField edition;
	private JFormattedTextField pname;
	private JFormattedTextField domain;
	private JFormattedTextField members;
	private JFormattedTextField dname;
	private JFormattedTextField dsub;
	private JFormattedTextField txtCallno;
	private JFormattedTextField ano1;
	static JFormattedTextField cno1;
	private JFormattedTextField issuerid;
	private JFormattedTextField Stuname;
	private JFormattedTextField email;
	private JFormattedTextField phone;
	static JTable table;
	private JFormattedTextField textField_2;
	private JFormattedTextField count;
	private JFormattedTextField dcount;
	public static Connection con;
	static Login ui;
	static JavaDB data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws SQLException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui3 window=new Gui3();
					window.frame.setVisible(true);
					//data=new JavaDB();
					//ui=new Login(window,data);
					//ui.setVisible(false);
					//Login.textField.requestFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		try{
    		for(LookAndFeelInfo info: UIManager.getInstalledLookAndFeels())
    		{
    			if("Nimbus".equals(info.getName())){
    				UIManager.setLookAndFeel(info.getClassName());
    				break;
    			}
    		}
    	}
    	catch(Exception e)
    	{
    	}
	}
	public JFrame getframe()
	{
		return this.frame;
	}

	

	/**
	 * Create the application.
	 */
	public Gui3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame("Computer Department Library System");
		frame.setBackground(new Color(102, 204, 102));
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setSize(1365,728);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(createImageIcon("book library.png").getImage());
		JToolBar bar=new JToolBar();
		bar.setBackground(new Color(204, 255, 204));
		bar.setOpaque(true);
		UndoManager undo=new UndoManager();
		bar.setRollover(true);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBackground(new Color(102, 153, 204));
		tabbedPane.setOpaque(true);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		UtilDateModel model=new UtilDateModel();
		UtilDateModel model1=new UtilDateModel();
		UtilDateModel model2=new UtilDateModel();
		UtilDateModel model3=new UtilDateModel();
		UtilDateModel model4=new UtilDateModel();
		Properties p=new Properties();
		p.put("text.today","Today");
		p.put("text.month","Month");
		p.put("text.year","Year");
		LocalDate now = LocalDate.now();
		model.setDate(now.getYear(), now.getMonthValue()-1, now.getDayOfMonth());
		
		model.setSelected(true);
		model1.setDate(now.getYear(), now.getMonthValue()-1, now.getDayOfMonth());
		model1.addDay(30);
		model1.setSelected(true);
		model2.setDate(now.getYear(), now.getMonthValue()-1, now.getDayOfMonth());
		model2.setSelected(true);
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, p);
		
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p);
		
		String[] subjects={"Sub","Discrete Mathematics","Digital Electronics and Logic Design","Computer Organisation and Architecture","Object Oriented Programming","Soft Skills","Engineering Mathematics III","Computer Graphics","Advanced Data Structures","Microprocessor","Principles of Programming Languages","Theory of Computation","Operating Systems Design","Data Communication and Wireless Sensor Networks","Database Management Systems Applications","Computer Forensics and Cyber Applications","Principles of Concurrent and Ditributed Programming","Embedded Operating Systems","Computer Networks","Software Engineering","Digital Signal Processing Applications","Design & Analysis of Algorithms","Principles of Modern Compiler Design","Smart System Design and Applications","Image Processing","Computer Network Design and Modeling","Advanced Computer Programming","Data Mining Techniquesand Applications","Problem Solving with Gamification","Pervasive Computing","Embedded Security","Multidisciplinary NLP","Software Design Methodologies and Testing","High Performance Computing","Mobile Computing","Web Technology","Cloud Computing","Cyber Security","Business Analytic and Intelligence","Operations Research for Algorithms in Scientific Applications","Mobile Applications","Open Elective"};
		
		//PicPanel panel = new PicPanel("bck.jpg");
		//JPanel panel=new JPanel();
		ImagePanel panel = new ImagePanel(System.getProperty("user.dir").replace("\\", "/")+"/src/icons/green-abstract-wallpaper7.jpg");
		panel.setBackground(SystemColor.control);
		tabbedPane.addTab("", new ImageIcon(Gui3.class.getResource("/icons/issue.png")), panel, null);
		
		JLabel lblBookInfo = new JLabel("Book Info:");
		lblBookInfo.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		
		JLabel lblAno = new JLabel("A.No. :");
		
		ano1 = new JFormattedTextField();
		ano1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				data.getbook(ano1.getText(), Login.getcon());
				ano1.setText("");
			}
		});
		ano1.setColumns(10);
		
		JLabel lblCa = new JLabel("Call No. :");
		lblCa.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		cno1 = new JFormattedTextField();
		cno1.setColumns(10);
		
		JLabel lblIssueDate = new JLabel("Issue Date:");
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		panel.add(datePicker);
		
		JLabel lblReturnDate = new JLabel("Return Date:");
		JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
		panel.add(datePicker1);
		
		datePicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model1.setDate(model.getYear(),model.getMonth(),model.getDay());
				model1.addDay(30);
				model1.setSelected(true);
			}
		});
		JSeparator separator_9 = new JSeparator();
		separator_9.setOrientation(SwingConstants.VERTICAL);
		
		JLabel lblIssuerId = new JLabel("Issuer ID:");
		
		issuerid = new JFormattedTextField(new RegexFormatter("^C2K\\d{8}"));
		issuerid.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name:");
		
		Stuname = new JFormattedTextField(new RegexFormatter("\\D{1,}\\s{1}\\D{1,}"));
		Stuname.setColumns(10);
		
		JLabel lblEmailid = new JLabel("Email-id:");
		
		email = new JFormattedTextField(new RegexFormatter("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$"));
		email.setColumns(10);
		
		JLabel lblMobile = new JLabel("Mobile:");
		
		phone = new JFormattedTextField(new RegexFormatter("^[1-9]{1}[0-9]{9}"));
		phone.setColumns(10);
		
		JLabel lblClass = new JLabel("Class:");
		
		JLabel lblDivision = new JLabel("Division:");
		
		JComboBox classbox = new JComboBox();
		classbox.setModel(new DefaultComboBoxModel(new String[] {"BE", "TE", "SE", "FE"}));
		
		JComboBox divisionbox = new JComboBox();
		divisionbox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		
		JButton btnGetInfo = new JButton("Get Info");
		
		JSeparator separator_10 = new JSeparator();
		
		JLabel lblStudentInfo = new JLabel("Student Info:");
		lblStudentInfo.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		
		JButton btnIssue = new JButton("ISSUE");
		
		JButton btnReturn = new JButton("RETURN");
		
		JButton btnReissue = new JButton("REISSUE");
		
		JSeparator separator_11 = new JSeparator();
		
		JSeparator separator_18 = new JSeparator();
		separator_18.setOrientation(SwingConstants.VERTICAL);
		
		JSeparator separator_19 = new JSeparator();
		separator_19.setOrientation(SwingConstants.VERTICAL);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblonlyThreeBooks = new JLabel("-Only three Books are permitted at a time.");
		lblonlyThreeBooks.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lbltheBookKeeping = new JLabel("-The Book Keeping Window is of 30 days, after which Student needs to reissue/return the books.");
		lbltheBookKeeping.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblstudentsInCase = new JLabel("-Students, in case of lost books, should donate the same book to the library as a fine.");
		lblstudentsInCase.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 14));
		
		table = new JTable(){/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {                
            return false;               
    };};
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"S.No.", "A.No.", "Call No.", "Title", "Author", "ISBN No."
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(2).setPreferredWidth(98);
		table.getColumnModel().getColumn(3).setPreferredWidth(374);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(143);
		scrollPane_1.setViewportView(table);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);
		
		JMenuItem mntmDelete_1 = new JMenuItem("Delete");
		mntmDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index=table.getSelectedRow();
				for(int j=index;j<6;j++)
				{
					table.setValueAt(table.getValueAt(j, 0), j, 0);
					for(int i=1;i<6;i++)
					{
						table.setValueAt(table.getValueAt(j+1, i), j, i);
					}
				}
				data.setcount1();
			}
		});
		popupMenu.add(mntmDelete_1);
		btnIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count=data.getcount();
				if(table.getValueAt(0, 1)!=null & Stuname.getText().equals("")==false & issuerid.getText().equals("")==false & email.getText().equals("")==false & phone.getText().equals("")==false)
				{	
				try {
					if(3-(data.GetBooksCount(Login.getcon(), issuerid.getText()))>=count)
					{
						for(int i=0;i<table.getRowCount();i++)
						{
						data.IssueBook(Login.getcon(),issuerid.getText() , table.getValueAt(i, 1).toString(), table.getValueAt(i, 2).toString(), datePicker.getJFormattedTextField().getText(), datePicker1.getJFormattedTextField().getText(), Stuname.getText(), classbox.getSelectedItem().toString().concat(divisionbox.getSelectedItem().toString()), phone.getText(), email.getText());
						}
						 for(int i=0;i<Gui3.table.getRowCount();i++)
						  {
							   Gui3.table.setValueAt("", i, 0);
							   Gui3.table.setValueAt("", i, 1);
							   Gui3.table.setValueAt("", i, 2);
							   Gui3.table.setValueAt("", i, 3);
							   Gui3.table.setValueAt("", i, 4);
							   Gui3.table.setValueAt("", i, 5);
						  }
						String message = "Books Issued ;)";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
						ano1.setText("");
						cno1.setText("");
						issuerid.setText("");
						Stuname.setText("");
						phone.setText("");
						email.setText("");
					}
					else
					{
						String message = "No. of BOoks that can be issued are: "+(3-(data.GetBooksCount(Login.getcon(), issuerid.getText())));
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
						for(int i=0;i<Gui3.table.getRowCount();i++)
						  {
							   Gui3.table.setValueAt("", i, 0);
							   Gui3.table.setValueAt("", i, 1);
							   Gui3.table.setValueAt("", i, 2);
							   Gui3.table.setValueAt("", i, 3);
							   Gui3.table.setValueAt("", i, 4);
							   Gui3.table.setValueAt("", i, 5);
						  }
						data.setcount();
					}
				} catch (HeadlessException | ClassNotFoundException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				else{
					String message = "Fill All the Details!!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		btnReissue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getValueAt(0, 1)!=null & table.getValueAt(0, 2)!=null)
				{
				try{
				data.ReIssueBook(Login.getcon(), table.getValueAt(0, 1).toString(), table.getValueAt(0, 2).toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
				String message = "Books Issued ;)";
				JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
				ano1.setText("");
				cno1.setText("");
				for(int i=0;i<Gui3.table.getRowCount();i++)
				  {
					   Gui3.table.setValueAt("", i, 0);
					   Gui3.table.setValueAt("", i, 1);
					   Gui3.table.setValueAt("", i, 2);
					   Gui3.table.setValueAt("", i, 3);
					   Gui3.table.setValueAt("", i, 4);
					   Gui3.table.setValueAt("", i, 5);
				  }
				data.setcount();
			}
			catch (ClassNotFoundException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				}	
				else
				{
					String message = "Fields are empty!!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int fine=0;
				if(table.getValueAt(0, 1)!=null & table.getValueAt(0, 2)!=null)
				{
				try{
					fine=data.ReturnBook(Login.getcon(), table.getValueAt(0, 1).toString(), table.getValueAt(0, 2).toString(), datePicker1.getJFormattedTextField().getText());
					String message = "Books Returned and fine to be paid: "+fine;
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
					ano1.setText("");
					cno1.setText("");
					for(int i=0;i<Gui3.table.getRowCount();i++)
					  {
						   Gui3.table.setValueAt("", i, 0);
						   Gui3.table.setValueAt("", i, 1);
						   Gui3.table.setValueAt("", i, 2);
						   Gui3.table.setValueAt("", i, 3);
						   Gui3.table.setValueAt("", i, 4);
						   Gui3.table.setValueAt("", i, 5);
					  }
					data.setcount();
				}
				catch (ClassNotFoundException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				else
				{
					String message = "Fields are empty!!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		
		JPopupMenu popupMenu_1 = new JPopupMenu();
		addPopup(panel, popupMenu_1);
		
		JMenuItem mntmCopy_1 = new JMenuItem("Copy");
		mntmCopy_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_COPY, 0));
		popupMenu_1.add(mntmCopy_1);
		
		JMenuItem mntmCut_1 = new JMenuItem("Cut");
		mntmCut_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_CUT, 0));
		popupMenu_1.add(mntmCut_1);
		
		JMenuItem mntmPaste_1 = new JMenuItem("Paste");
		mntmPaste_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PASTE, 0));
		popupMenu_1.add(mntmPaste_1);
		
		JMenuItem mntmFind = new JMenuItem("Find");
		mntmFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_FIND, 0));
		popupMenu_1.add(mntmFind);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBookInfo)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(28)
									.addComponent(lblAno))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(28)
									.addComponent(lblCa))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(28)
									.addComponent(lblIssueDate))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(28)
									.addComponent(lblReturnDate)))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(ano1, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
								.addComponent(cno1, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
								.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
								.addComponent(datePicker1, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(separator_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblStudentInfo)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblIssuerId)
									.addGap(18)
									.addComponent(issuerid, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(34)
									.addComponent(Stuname, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblEmailid)
									.addGap(22)
									.addComponent(email, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblMobile)
									.addGap(32)
									.addComponent(phone, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))
							.addGap(72)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblClass)
								.addComponent(lblDivision))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(7)
									.addComponent(classbox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(6)
									.addComponent(divisionbox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addGap(59)
							.addComponent(btnGetInfo))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(42)
							.addComponent(separator_10, GroupLayout.PREFERRED_SIZE, 1178, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(175)
							.addComponent(btnIssue)
							.addGap(162)
							.addComponent(separator_18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(172)
							.addComponent(btnReturn)
							.addGap(161)
							.addComponent(separator_19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(183)
							.addComponent(btnReissue))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(42)
							.addComponent(separator_11, GroupLayout.PREFERRED_SIZE, 1178, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(6, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(54, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblstudentsInCase)
						.addComponent(lbltheBookKeeping)
						.addComponent(lblonlyThreeBooks)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 1166, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(46)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblBookInfo)
							.addGap(30)
							.addComponent(lblAno)
							.addGap(30)
							.addComponent(lblCa)
							.addGap(30)
							.addComponent(lblIssueDate)
							.addGap(24)
							.addComponent(lblReturnDate))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(40)
							.addComponent(ano1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(cno1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(datePicker1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(separator_9, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblStudentInfo)
							.addGap(24)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(6)
									.addComponent(lblIssuerId))
								.addComponent(issuerid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(6)
									.addComponent(lblNewLabel))
								.addComponent(Stuname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(6)
									.addComponent(lblEmailid))
								.addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(12)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(6)
									.addComponent(lblMobile))
								.addComponent(phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(92)
							.addComponent(lblClass)
							.addGap(30)
							.addComponent(lblDivision))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(87)
							.addComponent(classbox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(divisionbox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(110)
							.addComponent(btnGetInfo)))
					.addGap(24)
					.addComponent(separator_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(23)
							.addComponent(btnIssue))
						.addComponent(separator_18, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(23)
							.addComponent(btnReturn))
						.addComponent(separator_19, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(23)
							.addComponent(btnReissue)))
					.addGap(6)
					.addComponent(separator_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblonlyThreeBooks)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbltheBookKeeping)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblstudentsInCase)
					.addGap(154))
		);
		panel.setLayout(gl_panel);
		
		ImagePanel panel_1 = new ImagePanel(System.getProperty("user.dir").replace("\\", "/")+"/src/icons/green-abstract-wallpaper7.jpg");
		panel_1.setBackground(new Color(255, 204, 153));
		tabbedPane.addTab("", new ImageIcon("C:\\Users\\pranay\\workspace1\\Library\\src\\update.png"), panel_1, null);
		
		JInternalFrame internalFrame = new JInternalFrame("Book Update");
		UIManager.put("InternalFrame.activeTitleBackground", new ColorUIResource(Color.black ));
		internalFrame.setContentPane(new ImagePanel(System.getProperty("user.dir").replace("\\", "/")+"/src/icons/l1.jpg"));
		internalFrame.getContentPane();
		internalFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		internalFrame.setVisible(true);
		
		publisher = new JFormattedTextField(new RegexFormatter("[A-Za-z\\s\\,\\.]{1,}"));
		publisher.setEnabled(false);
		publisher.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		
		author = new JFormattedTextField(new RegexFormatter("[A-Za-z\\s\\,\\.]{1,}"));
		author.setEnabled(false);
		author.setColumns(10);
		
		JLabel lblIsbn = new JLabel("ISBN");
		
		title = new JFormattedTextField();
		title.setEnabled(false);
		title.setColumns(10);
		
		JLabel lblPublisher = new JLabel("Publisher");
		
		isbn = new JFormattedTextField(new RegexFormatter("^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$"));
		isbn.setEnabled(false);
		isbn.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author");
		
		cno = new JFormattedTextField();
		cno.setEnabled(false);
		cno.setColumns(10);
		
		JLabel lblCallNo_1 = new JLabel("Call no.");
		
		ano = new JFormattedTextField();
		ano.setEnabled(false);
		ano.setColumns(10);
		
		JLabel lblANo_1 = new JLabel("A. No.");
		
		JLabel lblRegDate = new JLabel("Reg. Date");
		
		JLabel lblSubjectid = new JLabel("Subject_id");
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setEnabled(false);
		
		
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"BE", "TE", "SE", "FE"}));
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setEnabled(false);
		
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Sem1", "Sem2"}));
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setEnabled(false);
		comboBox_5.setToolTipText("R: Reference\r\nT: Text\r\nO: Others");
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"R", "T", "O"}));
		
		JComboBox<String> comboBox_4 = new JComboBox();
		comboBox_4.setEnabled(false);
		comboBox_4.setModel(new DefaultComboBoxModel(subjects));

		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox_2.getSelectedItem().equals("BE"))
				{
					if(comboBox_3.getSelectedItem().equals("Sem1"))
					{
						comboBox_4.removeAllItems();
						for(int i=21;i<32;i++)
						{
							comboBox_4.addItem(subjects[i]);;
						}
					}
					if(comboBox_3.getSelectedItem().equals("Sem2"))
					{
						comboBox_4.removeAllItems();
						for(int i=32;i<42;i++)
						{
							comboBox_4.addItem(subjects[i]);;
						}
					}
				}
				if(comboBox_2.getSelectedItem().equals("TE"))
				{
					if(comboBox_3.getSelectedItem().equals("Sem1"))
					{
						comboBox_4.removeAllItems();
						for(int i=11;i<16;i++)
						{
							comboBox_4.addItem(subjects[i]);;
						}
					}
					if(comboBox_3.getSelectedItem().equals("Sem2"))
					{
						comboBox_4.removeAllItems();
						for(int i=16;i<21;i++)
						{
							comboBox_4.addItem(subjects[i]);;
						}
					}
				}
				if(comboBox_2.getSelectedItem().equals("SE"))
				{
					if(comboBox_3.getSelectedItem().equals("Sem1"))
					{
						comboBox_4.removeAllItems();
						for(int i=1;i<6;i++)
						{
							comboBox_4.addItem(subjects[i]);;
						}
					}
					if(comboBox_3.getSelectedItem().equals("Sem2"))
					{
						comboBox_4.removeAllItems();
						for(int i=6;i<11;i++)
						{
							comboBox_4.addItem(subjects[i]);;
						}
					}
				}
			}
		});
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox_2.getSelectedItem().equals("BE"))
				{
					if(comboBox_3.getSelectedItem().equals("Sem1"))
					{
						comboBox_4.removeAllItems();
						for(int i=21;i<32;i++)
						{
							comboBox_4.addItem(subjects[i]);;
						}
					}
					if(comboBox_3.getSelectedItem().equals("Sem2"))
					{
						comboBox_4.removeAllItems();
						for(int i=32;i<42;i++)
						{
							comboBox_4.addItem(subjects[i]);;
						}
					}
				}
				if(comboBox_2.getSelectedItem().equals("TE"))
				{
					if(comboBox_3.getSelectedItem().equals("Sem1"))
					{
						comboBox_4.removeAllItems();
						for(int i=11;i<16;i++)
						{
							comboBox_4.addItem(subjects[i]);;
						}
					}
					if(comboBox_3.getSelectedItem().equals("Sem2"))
					{
						comboBox_4.removeAllItems();
						for(int i=16;i<21;i++)
						{
							comboBox_4.addItem(subjects[i]);;
						}
					}
				}
				if(comboBox_2.getSelectedItem().equals("SE"))
				{
					if(comboBox_3.getSelectedItem().equals("Sem1"))
					{
						comboBox_4.removeAllItems();
						for(int i=1;i<6;i++)
						{
							comboBox_4.addItem(subjects[i]);;
						}
					}
					if(comboBox_3.getSelectedItem().equals("Sem2"))
					{
						comboBox_4.removeAllItems();
						for(int i=6;i<11;i++)
						{
							comboBox_4.addItem(subjects[i]);;
						}
					}
				}
			}
		});
		
		JButton btnUpdate = new JButton("UPDATE");
		
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.setEnabled(false);
		
		JSeparator separator_15 = new JSeparator();
		separator_15.setOrientation(SwingConstants.VERTICAL);
		
		JLabel lblMagazineName = new JLabel("Magazine Name:");
		
		magname = new JFormattedTextField();
		magname.setEnabled(false);
		magname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Society/Field:");
		
		society = new JFormattedTextField();
		society.setEnabled(false);
		society.setColumns(10);
		
		JLabel lblEdition = new JLabel("Edition:");
		
		edition = new JFormattedTextField();
		edition.setEnabled(false);
		edition.setColumns(10);
		
		JSeparator separator_16 = new JSeparator();
		
		JLabel lblProjectName = new JLabel("Project Name:");
		
		pname = new JFormattedTextField();
		pname.setEnabled(false);
		pname.setColumns(10);
		
		JLabel lblDomain = new JLabel("Domain:");
		
		domain = new JFormattedTextField();
		domain.setEnabled(false);
		domain.setColumns(10);
		
		JLabel lblMembers = new JLabel("Members:");
		
		members = new JFormattedTextField();
		members.setEnabled(false);
		members.setColumns(10);
		
		JSeparator separator_17 = new JSeparator();
		
		JLabel lblTitle_1 = new JLabel("Title:");
		
		dname = new JFormattedTextField();
		dname.setEnabled(false);
		dname.setColumns(10);
		
		JLabel lblSubject = new JLabel("Subject:");
		
		dsub = new JFormattedTextField();
		dsub.setEnabled(false);
		dsub.setColumns(10);
		
		JLabel lblBooks = new JLabel("Books:");
		lblBooks.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		
		JLabel lblDonatedBooks = new JLabel("Donated Books:");
		lblDonatedBooks.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		
		JLabel lblBeProjects = new JLabel("BE Projects:");
		lblBeProjects.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		
		JLabel lblMagazines = new JLabel("Magazines:");
		lblMagazines.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		
		JLabel lblCount = new JLabel("Count:");
		
		count = new JFormattedTextField(new RegexFormatter("^[1-9][0-9]{0,1}"));
		count.setEnabled(false);
		count.setColumns(10);
		
		dcount = new JFormattedTextField(new RegexFormatter("^[1-9][0-9]{0,1}"));
		dcount.setEnabled(false);
		dcount.setColumns(10);
		
		JLabel lblCount_1 = new JLabel("Count:");
		JDatePickerImpl reg = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
		reg.getJFormattedTextField().setEnabled(false);
		reg.setBounds(new Rectangle(0, 0, 30, 20));
		
		JRadioButton rdbtnBooks = new JRadioButton("Books");
		rdbtnBooks.setBackground(Color.WHITE);
		JRadioButton rdbtnBeProjects = new JRadioButton("BE Projects");
		rdbtnBeProjects.setBackground(Color.WHITE);
		JRadioButton rdbtnMagazines = new JRadioButton("Magazines");
		rdbtnMagazines.setBackground(Color.WHITE);
		JRadioButton rdbtnDonated = new JRadioButton("Donated");
		rdbtnDonated.setBackground(Color.WHITE);
		JRadioButton rdbtnDelete = new JRadioButton("Delete");
		internalFrame.getContentPane().add(reg);
		reg.setEnabled(false);
		rdbtnBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnBooks.isSelected()==true)
				{
					if(rdbtnDelete.isSelected())
					{
						rdbtnBeProjects.setSelected(false);
						rdbtnMagazines.setSelected(false);
						rdbtnDonated.setSelected(false);
						count.setEnabled(false);
						magname.setEnabled(false);
						society.setEnabled(false);
						edition.setEnabled(false);
						ano.setEnabled(true);
						cno.setEnabled(true);
						publisher.setEnabled(false);
						title.setEnabled(false);
						author.setEnabled(false);
						isbn.setEnabled(false);
						reg.getComponent(0).setEnabled(false);
						pname.setEnabled(false);
						domain.setEnabled(false);
						members.setEnabled(false);
						dname.setEnabled(false);
						dsub.setEnabled(false);
						dcount.setEnabled(false);
						comboBox_2.setEnabled(false);
						comboBox_3.setEnabled(false);
						comboBox_4.setEnabled(false);
						comboBox_5.setEnabled(false);
						count.setText("");
						magname.setText("");
						society.setText("");
						edition.setText("");
						pname.setText("");
						domain.setText("");
						members.setText("");
						dname.setText("");
						dsub.setText("");
						dcount.setText("");
						ano.setText("");
						cno.setText("");
						publisher.setText("");
						title.setText("");
						author.setText("");
						isbn.setText("");
					}
					else
					{
					rdbtnBeProjects.setSelected(false);
					rdbtnMagazines.setSelected(false);
					rdbtnDonated.setSelected(false);
					count.setEnabled(false);
					magname.setEnabled(false);
					society.setEnabled(false);
					edition.setEnabled(false);
					ano.setEnabled(true);
					cno.setEnabled(true);
					publisher.setEnabled(true);
					title.setEnabled(true);
					author.setEnabled(true);
					isbn.setEnabled(true);
					reg.getComponent(0).setEnabled(true);
					pname.setEnabled(false);
					domain.setEnabled(false);
					members.setEnabled(false);
					dname.setEnabled(false);
					dsub.setEnabled(false);
					dcount.setEnabled(false);
					comboBox_2.setEnabled(true);
					comboBox_3.setEnabled(true);
					comboBox_4.setEnabled(true);
					comboBox_5.setEnabled(true);
					count.setText("");
					magname.setText("");
					society.setText("");
					edition.setText("");
					pname.setText("");
					domain.setText("");
					members.setText("");
					dname.setText("");
					dsub.setText("");
					dcount.setText("");
					ano.setText("");
					cno.setText("");
					publisher.setText("");
					title.setText("");
					author.setText("");
					isbn.setText("");
					}
					
					
				}
				else
				{
					rdbtnBeProjects.setSelected(false);
					rdbtnMagazines.setSelected(false);
					rdbtnDonated.setSelected(false);
					count.setEnabled(false);
					magname.setEnabled(false);
					society.setEnabled(false);
					edition.setEnabled(false);
					ano.setEnabled(false);
					cno.setEnabled(false);
					publisher.setEnabled(false);
					title.setEnabled(false);
					author.setEnabled(false);
					isbn.setEnabled(false);
					reg.getComponent(0).setEnabled(false);
					pname.setEnabled(false);
					domain.setEnabled(false);
					members.setEnabled(false);
					dname.setEnabled(false);
					dsub.setEnabled(false);
					dcount.setEnabled(false);
					comboBox_2.setEnabled(false);
					comboBox_3.setEnabled(false);
					comboBox_4.setEnabled(false);
					comboBox_5.setEnabled(false);
					count.setText("");
					magname.setText("");
					society.setText("");
					edition.setText("");
					pname.setText("");
					domain.setText("");
					members.setText("");
					dname.setText("");
					dsub.setText("");
					dcount.setText("");
					ano.setText("");
					cno.setText("");
					publisher.setText("");
					title.setText("");
					author.setText("");
					isbn.setText("");
				}
			}
		});
		
		rdbtnMagazines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnMagazines.isSelected())
				{
					if(rdbtnDelete.isSelected())
					{
						rdbtnBooks.setSelected(false);
						rdbtnBeProjects.setSelected(false);
						rdbtnDonated.setSelected(false);
						count.setEnabled(false);
						magname.setEnabled(true);
						society.setEnabled(false);
						edition.setEnabled(false);
						ano.setEnabled(false);
						cno.setEnabled(false);
						publisher.setEnabled(false);
						title.setEnabled(false);
						author.setEnabled(false);
						isbn.setEnabled(false);
						reg.getComponent(0).setEnabled(false);
						pname.setEnabled(false);
						domain.setEnabled(false);
						members.setEnabled(false);
						dname.setEnabled(false);
						dsub.setEnabled(false);
						dcount.setEnabled(false);
						comboBox_2.setEnabled(false);
						comboBox_3.setEnabled(false);
						comboBox_4.setEnabled(false);
						comboBox_5.setEnabled(false);
						count.setText("");
						magname.setText("");
						society.setText("");
						edition.setText("");
						pname.setText("");
						domain.setText("");
						members.setText("");
						dname.setText("");
						dsub.setText("");
						dcount.setText("");
						ano.setText("");
						cno.setText("");
						publisher.setText("");
						title.setText("");
						author.setText("");
						isbn.setText("");
					
					}
					else
					{
					rdbtnBooks.setSelected(false);
					rdbtnBeProjects.setSelected(false);
					rdbtnDonated.setSelected(false);
					count.setEnabled(true);
					magname.setEnabled(true);
					society.setEnabled(true);
					edition.setEnabled(true);
					ano.setEnabled(false);
					cno.setEnabled(false);
					publisher.setEnabled(false);
					title.setEnabled(false);
					author.setEnabled(false);
					isbn.setEnabled(false);
					reg.getComponent(0).setEnabled(false);
					pname.setEnabled(false);
					domain.setEnabled(false);
					members.setEnabled(false);
					dname.setEnabled(false);
					dsub.setEnabled(false);
					dcount.setEnabled(false);
					comboBox_2.setEnabled(false);
					comboBox_3.setEnabled(false);
					comboBox_4.setEnabled(false);
					comboBox_5.setEnabled(false);
					count.setText("");
					magname.setText("");
					society.setText("");
					edition.setText("");
					pname.setText("");
					domain.setText("");
					members.setText("");
					dname.setText("");
					dsub.setText("");
					dcount.setText("");
					ano.setText("");
					cno.setText("");
					publisher.setText("");
					title.setText("");
					author.setText("");
					isbn.setText("");
					}
					
				}
				else
				{
					rdbtnBeProjects.setSelected(false);
					rdbtnMagazines.setSelected(false);
					rdbtnDonated.setSelected(false);
					count.setEnabled(false);
					magname.setEnabled(false);
					society.setEnabled(false);
					edition.setEnabled(false);
					ano.setEnabled(false);
					cno.setEnabled(false);
					publisher.setEnabled(false);
					title.setEnabled(false);
					author.setEnabled(false);
					isbn.setEnabled(false);
					reg.getComponent(0).setEnabled(false);
					pname.setEnabled(false);
					domain.setEnabled(false);
					members.setEnabled(false);
					dname.setEnabled(false);
					dsub.setEnabled(false);
					dcount.setEnabled(false);
					comboBox_2.setEnabled(false);
					comboBox_3.setEnabled(false);
					comboBox_4.setEnabled(false);
					comboBox_5.setEnabled(false);
					count.setText("");
					magname.setText("");
					society.setText("");
					edition.setText("");
					pname.setText("");
					domain.setText("");
					members.setText("");
					dname.setText("");
					dsub.setText("");
					dcount.setText("");
					ano.setText("");
					cno.setText("");
					publisher.setText("");
					title.setText("");
					author.setText("");
					isbn.setText("");
				}
			}
		});
		
		rdbtnBeProjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnBeProjects.isSelected()==true)
				{
					if(rdbtnDelete.isSelected())
					{
						rdbtnBooks.setSelected(false);
						rdbtnMagazines.setSelected(false);
						rdbtnDonated.setSelected(false);
						count.setEnabled(false);
						magname.setEnabled(false);
						society.setEnabled(false);
						edition.setEnabled(false);
						ano.setEnabled(false);
						cno.setEnabled(false);
						publisher.setEnabled(false);
						title.setEnabled(false);
						author.setEnabled(false);
						isbn.setEnabled(false);
						reg.getComponent(0).setEnabled(false);
						pname.setEnabled(true);
						domain.setEnabled(false);
						members.setEnabled(false);
						dname.setEnabled(false);
						dsub.setEnabled(false);
						dcount.setEnabled(false);
						comboBox_2.setEnabled(false);
						comboBox_3.setEnabled(false);
						comboBox_4.setEnabled(false);
						comboBox_5.setEnabled(false);
						count.setText("");
						magname.setText("");
						society.setText("");
						edition.setText("");
						pname.setText("");
						domain.setText("");
						members.setText("");
						dname.setText("");
						dsub.setText("");
						dcount.setText("");
						ano.setText("");
						cno.setText("");
						publisher.setText("");
						title.setText("");
						author.setText("");
						isbn.setText("");
					}
					else
					{
					rdbtnBooks.setSelected(false);
					rdbtnMagazines.setSelected(false);
					rdbtnDonated.setSelected(false);
					count.setEnabled(false);
					magname.setEnabled(false);
					society.setEnabled(false);
					edition.setEnabled(false);
					ano.setEnabled(false);
					cno.setEnabled(false);
					publisher.setEnabled(false);
					title.setEnabled(false);
					author.setEnabled(false);
					isbn.setEnabled(false);
					reg.getComponent(0).setEnabled(false);
					pname.setEnabled(true);
					domain.setEnabled(true);
					members.setEnabled(true);
					dname.setEnabled(false);
					dsub.setEnabled(false);
					dcount.setEnabled(false);
					comboBox_2.setEnabled(false);
					comboBox_3.setEnabled(false);
					comboBox_4.setEnabled(false);
					comboBox_5.setEnabled(false);
					count.setText("");
					magname.setText("");
					society.setText("");
					edition.setText("");
					pname.setText("");
					domain.setText("");
					members.setText("");
					dname.setText("");
					dsub.setText("");
					dcount.setText("");
					ano.setText("");
					cno.setText("");
					publisher.setText("");
					title.setText("");
					author.setText("");
					isbn.setText("");
					}
				}
				else
				{
					rdbtnBeProjects.setSelected(false);
					rdbtnMagazines.setSelected(false);
					rdbtnDonated.setSelected(false);
					count.setEnabled(false);
					magname.setEnabled(false);
					society.setEnabled(false);
					edition.setEnabled(false);
					ano.setEnabled(false);
					cno.setEnabled(false);
					publisher.setEnabled(false);
					title.setEnabled(false);
					author.setEnabled(false);
					isbn.setEnabled(false);
					reg.getComponent(0).setEnabled(false);
					pname.setEnabled(false);
					domain.setEnabled(false);
					members.setEnabled(false);
					dname.setEnabled(false);
					dsub.setEnabled(false);
					dcount.setEnabled(false);
					comboBox_2.setEnabled(false);
					comboBox_3.setEnabled(false);
					comboBox_4.setEnabled(false);
					comboBox_5.setEnabled(false);
					count.setText("");
					magname.setText("");
					society.setText("");
					edition.setText("");
					pname.setText("");
					domain.setText("");
					members.setText("");
					dname.setText("");
					dsub.setText("");
					dcount.setText("");
					ano.setText("");
					cno.setText("");
					publisher.setText("");
					title.setText("");
					author.setText("");
					isbn.setText("");
				}
			}
		});
		
		
		rdbtnDonated.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnDonated.isSelected()==true)
				{
					if(rdbtnDelete.isSelected())
					{
						rdbtnBooks.setSelected(false);
						rdbtnMagazines.setSelected(false);
						rdbtnBeProjects.setSelected(false);
						count.setEnabled(false);
						magname.setEnabled(false);
						society.setEnabled(false);
						edition.setEnabled(false);
						ano.setEnabled(false);
						cno.setEnabled(false);
						publisher.setEnabled(false);
						title.setEnabled(false);
						author.setEnabled(false);
						isbn.setEnabled(false);
						reg.getComponent(0).setEnabled(false);
						pname.setEnabled(false);
						domain.setEnabled(false);
						members.setEnabled(false);
						dname.setEnabled(true);
						dsub.setEnabled(false);
						dcount.setEnabled(false);
						comboBox_2.setEnabled(false);
						comboBox_3.setEnabled(false);
						comboBox_4.setEnabled(false);
						comboBox_5.setEnabled(false);
						count.setText("");
						magname.setText("");
						society.setText("");
						edition.setText("");
						pname.setText("");
						domain.setText("");
						members.setText("");
						dname.setText("");
						dsub.setText("");
						dcount.setText("");
						ano.setText("");
						cno.setText("");
						publisher.setText("");
						title.setText("");
						author.setText("");
						isbn.setText("");
					}
					else
					{
					rdbtnBooks.setSelected(false);
					rdbtnMagazines.setSelected(false);
					rdbtnBeProjects.setSelected(false);
					count.setEnabled(false);
					magname.setEnabled(false);
					society.setEnabled(false);
					edition.setEnabled(false);
					ano.setEnabled(false);
					cno.setEnabled(false);
					publisher.setEnabled(false);
					title.setEnabled(false);
					author.setEnabled(false);
					isbn.setEnabled(false);
					reg.getComponent(0).setEnabled(false);
					pname.setEnabled(false);
					domain.setEnabled(false);
					members.setEnabled(false);
					dname.setEnabled(true);
					dsub.setEnabled(true);
					dcount.setEnabled(true);
					comboBox_2.setEnabled(false);
					comboBox_3.setEnabled(false);
					comboBox_4.setEnabled(false);
					comboBox_5.setEnabled(false);
					count.setText("");
					magname.setText("");
					society.setText("");
					edition.setText("");
					pname.setText("");
					domain.setText("");
					members.setText("");
					dname.setText("");
					dsub.setText("");
					dcount.setText("");
					ano.setText("");
					cno.setText("");
					publisher.setText("");
					title.setText("");
					author.setText("");
					isbn.setText("");
					}
				}
				else
				{
					rdbtnBeProjects.setSelected(false);
					rdbtnMagazines.setSelected(false);
					rdbtnDonated.setSelected(false);
					count.setEnabled(false);
					magname.setEnabled(false);
					society.setEnabled(false);
					edition.setEnabled(false);
					ano.setEnabled(false);
					cno.setEnabled(false);
					publisher.setEnabled(false);
					title.setEnabled(false);
					author.setEnabled(false);
					isbn.setEnabled(false);
					reg.getComponent(0).setEnabled(false);
					pname.setEnabled(false);
					domain.setEnabled(false);
					members.setEnabled(false);
					dname.setEnabled(false);
					dsub.setEnabled(false);
					dcount.setEnabled(false);
					comboBox_2.setEnabled(false);
					comboBox_3.setEnabled(false);
					comboBox_4.setEnabled(false);
					comboBox_5.setEnabled(false);
					count.setText("");
					magname.setText("");
					society.setText("");
					edition.setText("");
					pname.setText("");
					domain.setText("");
					members.setText("");
					dname.setText("");
					dsub.setText("");
					dcount.setText("");
					ano.setText("");
					cno.setText("");
					publisher.setText("");
					title.setText("");
					author.setText("");
					isbn.setText("");
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{if(rdbtnBooks.isSelected()==true & ano.getText().equals("")==false & cno.getText().equals("")==false)
				{
					con=Login.getcon();
					data.deletebook(ano.getText(), cno.getText(), con);
					String message = "Book has been deleted!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
				}
				if(rdbtnMagazines.isSelected()==true & magname.getText().equals("")==false)
				{
					con=Login.getcon();
					data.deleteMagazine(magname.getText(), con);
					String message = "Magazine has been deleted!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
				}
				if(rdbtnBeProjects.isSelected()==true & pname.getText().equals("")==false)
				{
					con=Login.getcon();
					data.deleteProjects(pname.getText(), con);
					String message = "Project has been deleted!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
				}
				if(rdbtnDonated.isSelected()==true & dname.getText().equals("")==false)
				{
					con=Login.getcon();
					data.deleteDonated(dname.getText(), con);
					String message = "Book has been deleted!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
				}
				}
				catch(ClassNotFoundException | ParseException e)
				{
					String message = "Oops!! Unable to do it... or No Left Fields blank!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnBooks.isSelected()==true & ano.getText().equals("")==false & cno.getText().equals("")==false & title.getText().equals("")==false & author.getText().equals("")==false & publisher.getText().equals("")==false & isbn.getText().equals("")==false)
				{
					con=Login.getcon();
					String sub=null;
					String a_no=ano.getText();
					String c_no=cno.getText();
					String title1=title.getText();
					String author1=author.getText();
					String pub=publisher.getText();
					String isbn1=isbn.getText();
					String reg1=reg.getJFormattedTextField().getText();
					String ret="InStock";
					try {
						sub=data.SearchSubject_id(con, comboBox_4.getSelectedItem().toString(), comboBox_5.getSelectedItem().toString());
					} catch (ClassNotFoundException | ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						data.InsertValuesInBooks(a_no, c_no, title1, author1, pub, isbn1, sub, reg1, ret, Login.getcon());
						String message = "New Book Inserted! ;)";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
						ano.setText("");
						cno.setText("");
					} catch (ClassNotFoundException | ParseException e) {
						e.printStackTrace();
						String message = "Oops!! Unable to do it...";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				else if(rdbtnMagazines.isSelected()==true & magname.getText().equals("")==false & society.getText().equals("")==false & edition.getText().equals("")==false & count.getText().equals("")==false)
				{
					con=Login.getcon();
					String name=magname.getText();
					String society1=society.getText();
					String edition1=edition.getText();
					int count1=Integer.parseInt(count.getText());
					try {
						data.InsertValuesInMagazine(name, society1, edition1, count1, con);
						String message = "New Magazine Inserted! ;)";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
						magname.setText("");
						society.setText("");
						edition.setText("");
						count.setText("");
					} catch (ClassNotFoundException | ParseException e) {
						String message = "Oops!! Unable to do it... or No Left Fields blank!";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				else if(rdbtnBeProjects.isSelected()==true & pname.getText().equals("")==false & domain.getText().equals("")==false & members.getText().equals("")==false)
				{
					con=Login.getcon();
					String name=pname.getText();
					String domain1=domain.getText();
					String members1=members.getText();
					try {
						data.InsertValuesInBEP(name, domain1, members1, con);
						String message = "New Project Inserted! ;)";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
						pname.setText("");
						domain.setText("");
						members.setText("");
					} catch (ClassNotFoundException | ParseException e) {
						String message = "Oops!! Unable to do it... or No Left Fields blank!";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				else if(rdbtnDonated.isSelected()==true & dname.getText().equals("")==false & dsub.getText().equals("")==false & dcount.getText().equals("")==false)
				{
					con=Login.getcon();
					String title1=dname.getText();
					String author=dsub.getText();
					int count1=Integer.parseInt(dcount.getText());
					try {
						data.InsertValuesInDonated(title1, author, count1, con);
						String message = "New Book Inserted! ;)";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
						dname.setText("");
						dsub.setText("");
						dcount.setText("");
					} catch (ClassNotFoundException | ParseException e) {
						String message = "Oops!! Unable to do it... or No Left Fields blank!";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				else
				{
					String message = "Oops!! Left Fields blank!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		rdbtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnDelete.isSelected()==true)
				{
					btnNewButton_1.setEnabled(true);
					btnUpdate.setEnabled(false);
					if(rdbtnBeProjects.isSelected()==true)
					{
						rdbtnBooks.setSelected(false);
						rdbtnMagazines.setSelected(false);
						rdbtnDonated.setSelected(false);
						count.setEnabled(false);
						magname.setEnabled(false);
						society.setEnabled(false);
						edition.setEnabled(false);
						ano.setEnabled(false);
						cno.setEnabled(false);
						publisher.setEnabled(false);
						title.setEnabled(false);
						author.setEnabled(false);
						isbn.setEnabled(false);
						reg.getComponent(0).setEnabled(false);
						pname.setEnabled(true);
						domain.setEnabled(false);
						members.setEnabled(false);
						dname.setEnabled(false);
						dsub.setEnabled(false);
						dcount.setEnabled(false);
						comboBox_2.setEnabled(false);
						comboBox_3.setEnabled(false);
						comboBox_4.setEnabled(false);
						comboBox_5.setEnabled(false);
						count.setText("");
						magname.setText("");
						society.setText("");
						edition.setText("");
						pname.setText("");
						domain.setText("");
						members.setText("");
						dname.setText("");
						dsub.setText("");
						dcount.setText("");
						ano.setText("");
						cno.setText("");
						publisher.setText("");
						title.setText("");
						author.setText("");
						isbn.setText("");
						
					}
					else
					{
						rdbtnBeProjects.setSelected(false);
						rdbtnMagazines.setSelected(false);
						rdbtnDonated.setSelected(false);
						count.setEnabled(false);
						magname.setEnabled(false);
						society.setEnabled(false);
						edition.setEnabled(false);
						ano.setEnabled(false);
						cno.setEnabled(false);
						publisher.setEnabled(false);
						title.setEnabled(false);
						author.setEnabled(false);
						isbn.setEnabled(false);
						reg.getComponent(0).setEnabled(false);
						pname.setEnabled(false);
						domain.setEnabled(false);
						members.setEnabled(false);
						dname.setEnabled(false);
						dsub.setEnabled(false);
						dcount.setEnabled(false);
						comboBox_2.setEnabled(false);
						comboBox_3.setEnabled(false);
						comboBox_4.setEnabled(false);
						comboBox_5.setEnabled(false);
						count.setText("");
						magname.setText("");
						society.setText("");
						edition.setText("");
						pname.setText("");
						domain.setText("");
						members.setText("");
						dname.setText("");
						dsub.setText("");
						dcount.setText("");
						ano.setText("");
						cno.setText("");
						publisher.setText("");
						title.setText("");
						author.setText("");
						isbn.setText("");
					}
					if(rdbtnDonated.isSelected()==true)
					{
						rdbtnBooks.setSelected(false);
						rdbtnMagazines.setSelected(false);
						rdbtnBeProjects.setSelected(false);
						count.setEnabled(false);
						magname.setEnabled(false);
						society.setEnabled(false);
						edition.setEnabled(false);
						ano.setEnabled(false);
						cno.setEnabled(false);
						publisher.setEnabled(false);
						title.setEnabled(false);
						author.setEnabled(false);
						isbn.setEnabled(false);
						reg.getComponent(0).setEnabled(false);
						pname.setEnabled(false);
						domain.setEnabled(false);
						members.setEnabled(false);
						dname.setEnabled(true);
						dsub.setEnabled(false);
						dcount.setEnabled(false);
						comboBox_2.setEnabled(false);
						comboBox_3.setEnabled(false);
						comboBox_4.setEnabled(false);
						comboBox_5.setEnabled(false);
						count.setText("");
						magname.setText("");
						society.setText("");
						edition.setText("");
						pname.setText("");
						domain.setText("");
						members.setText("");
						dname.setText("");
						dsub.setText("");
						dcount.setText("");
						ano.setText("");
						cno.setText("");
						publisher.setText("");
						title.setText("");
						author.setText("");
						isbn.setText("");
						
					}
					else
					{
						rdbtnBeProjects.setSelected(false);
						rdbtnMagazines.setSelected(false);
						rdbtnDonated.setSelected(false);
						count.setEnabled(false);
						magname.setEnabled(false);
						society.setEnabled(false);
						edition.setEnabled(false);
						ano.setEnabled(false);
						cno.setEnabled(false);
						publisher.setEnabled(false);
						title.setEnabled(false);
						author.setEnabled(false);
						isbn.setEnabled(false);
						reg.getComponent(0).setEnabled(false);
						pname.setEnabled(false);
						domain.setEnabled(false);
						members.setEnabled(false);
						dname.setEnabled(false);
						dsub.setEnabled(false);
						dcount.setEnabled(false);
						comboBox_2.setEnabled(false);
						comboBox_3.setEnabled(false);
						comboBox_4.setEnabled(false);
						comboBox_5.setEnabled(false);
						count.setText("");
						magname.setText("");
						society.setText("");
						edition.setText("");
						pname.setText("");
						domain.setText("");
						members.setText("");
						dname.setText("");
						dsub.setText("");
						dcount.setText("");
						ano.setText("");
						cno.setText("");
						publisher.setText("");
						title.setText("");
						author.setText("");
						isbn.setText("");
					}
					if(rdbtnMagazines.isSelected()==true)
					{
						rdbtnBooks.setSelected(false);
						rdbtnBeProjects.setSelected(false);
						rdbtnDonated.setSelected(false);
						count.setEnabled(false);
						magname.setEnabled(true);
						society.setEnabled(false);
						edition.setEnabled(false);
						ano.setEnabled(false);
						cno.setEnabled(false);
						publisher.setEnabled(false);
						title.setEnabled(false);
						author.setEnabled(false);
						isbn.setEnabled(false);
						reg.getComponent(0).setEnabled(false);
						pname.setEnabled(false);
						domain.setEnabled(false);
						members.setEnabled(false);
						dname.setEnabled(false);
						dsub.setEnabled(false);
						dcount.setEnabled(false);
						comboBox_2.setEnabled(false);
						comboBox_3.setEnabled(false);
						comboBox_4.setEnabled(false);
						comboBox_5.setEnabled(false);
						count.setText("");
						magname.setText("");
						society.setText("");
						edition.setText("");
						pname.setText("");
						domain.setText("");
						members.setText("");
						dname.setText("");
						dsub.setText("");
						dcount.setText("");
						ano.setText("");
						cno.setText("");
						publisher.setText("");
						title.setText("");
						author.setText("");
						isbn.setText("");
						
					}
					else
					{
						rdbtnBeProjects.setSelected(false);
						rdbtnMagazines.setSelected(false);
						rdbtnDonated.setSelected(false);
						count.setEnabled(false);
						magname.setEnabled(false);
						society.setEnabled(false);
						edition.setEnabled(false);
						ano.setEnabled(false);
						cno.setEnabled(false);
						publisher.setEnabled(false);
						title.setEnabled(false);
						author.setEnabled(false);
						isbn.setEnabled(false);
						reg.getComponent(0).setEnabled(false);
						pname.setEnabled(false);
						domain.setEnabled(false);
						members.setEnabled(false);
						dname.setEnabled(false);
						dsub.setEnabled(false);
						dcount.setEnabled(false);
						comboBox_2.setEnabled(false);
						comboBox_3.setEnabled(false);
						comboBox_4.setEnabled(false);
						comboBox_5.setEnabled(false);
						count.setText("");
						magname.setText("");
						society.setText("");
						edition.setText("");
						pname.setText("");
						domain.setText("");
						members.setText("");
						dname.setText("");
						dsub.setText("");
						dcount.setText("");
						ano.setText("");
						cno.setText("");
						publisher.setText("");
						title.setText("");
						author.setText("");
						isbn.setText("");
					}
					if(rdbtnBooks.isSelected()==true)
					{
						rdbtnBeProjects.setSelected(false);
						rdbtnMagazines.setSelected(false);
						rdbtnDonated.setSelected(false);
						count.setEnabled(false);
						magname.setEnabled(false);
						society.setEnabled(false);
						edition.setEnabled(false);
						ano.setEnabled(true);
						cno.setEnabled(true);
						publisher.setEnabled(false);
						title.setEnabled(false);
						author.setEnabled(false);
						isbn.setEnabled(false);
						reg.getComponent(0).setEnabled(false);
						pname.setEnabled(false);
						domain.setEnabled(false);
						members.setEnabled(false);
						dname.setEnabled(false);
						dsub.setEnabled(false);
						dcount.setEnabled(false);
						comboBox_2.setEnabled(false);
						comboBox_3.setEnabled(false);
						comboBox_4.setEnabled(false);
						comboBox_5.setEnabled(false);
						count.setText("");
						magname.setText("");
						society.setText("");
						edition.setText("");
						pname.setText("");
						domain.setText("");
						members.setText("");
						dname.setText("");
						dsub.setText("");
						dcount.setText("");
						ano.setText("");
						cno.setText("");
						publisher.setText("");
						title.setText("");
						author.setText("");
						isbn.setText("");
						
					}
					else
					{
					rdbtnBeProjects.setSelected(false);
					rdbtnMagazines.setSelected(false);
					rdbtnDonated.setSelected(false);
					count.setEnabled(false);
					magname.setEnabled(false);
					society.setEnabled(false);
					edition.setEnabled(false);
					ano.setEnabled(false);
					cno.setEnabled(false);
					publisher.setEnabled(false);
					title.setEnabled(false);
					author.setEnabled(false);
					isbn.setEnabled(false);
					reg.getComponent(0).setEnabled(false);
					pname.setEnabled(false);
					domain.setEnabled(false);
					members.setEnabled(false);
					dname.setEnabled(false);
					dsub.setEnabled(false);
					dcount.setEnabled(false);
					comboBox_2.setEnabled(false);
					comboBox_3.setEnabled(false);
					comboBox_4.setEnabled(false);
					comboBox_5.setEnabled(false);
					count.setText("");
					magname.setText("");
					society.setText("");
					edition.setText("");
					pname.setText("");
					domain.setText("");
					members.setText("");
					dname.setText("");
					dsub.setText("");
					dcount.setText("");
					ano.setText("");
					cno.setText("");
					publisher.setText("");
					title.setText("");
					author.setText("");
					isbn.setText("");
					}
				}
				else
				{
					btnNewButton_1.setEnabled(false);
					btnUpdate.setEnabled(true);
					if(rdbtnDonated.isSelected()==true)
					{
						rdbtnBooks.setSelected(false);
						rdbtnMagazines.setSelected(false);
						rdbtnBeProjects.setSelected(false);
						count.setEnabled(false);
						magname.setEnabled(false);
						society.setEnabled(false);
						edition.setEnabled(false);
						ano.setEnabled(false);
						cno.setEnabled(false);
						publisher.setEnabled(false);
						title.setEnabled(false);
						author.setEnabled(false);
						isbn.setEnabled(false);
						reg.getComponent(0).setEnabled(false);
						pname.setEnabled(false);
						domain.setEnabled(false);
						members.setEnabled(false);
						dname.setEnabled(true);
						dsub.setEnabled(true);
						dcount.setEnabled(true);
						comboBox_2.setEnabled(false);
						comboBox_3.setEnabled(false);
						comboBox_4.setEnabled(false);
						comboBox_5.setEnabled(false);
						count.setText("");
						magname.setText("");
						society.setText("");
						edition.setText("");
						pname.setText("");
						domain.setText("");
						members.setText("");
						dname.setText("");
						dsub.setText("");
						dcount.setText("");
						ano.setText("");
						cno.setText("");
						publisher.setText("");
						title.setText("");
						author.setText("");
						isbn.setText("");
				}
					else
					{
					rdbtnBeProjects.setSelected(false);
					rdbtnMagazines.setSelected(false);
					rdbtnDonated.setSelected(false);
					count.setEnabled(false);
					magname.setEnabled(false);
					society.setEnabled(false);
					edition.setEnabled(false);
					ano.setEnabled(false);
					cno.setEnabled(false);
					publisher.setEnabled(false);
					title.setEnabled(false);
					author.setEnabled(false);
					isbn.setEnabled(false);
					reg.getComponent(0).setEnabled(false);
					pname.setEnabled(false);
					domain.setEnabled(false);
					members.setEnabled(false);
					dname.setEnabled(false);
					dsub.setEnabled(false);
					dcount.setEnabled(false);
					comboBox_2.setEnabled(false);
					comboBox_3.setEnabled(false);
					comboBox_4.setEnabled(false);
					comboBox_5.setEnabled(false);
					count.setText("");
					magname.setText("");
					society.setText("");
					edition.setText("");
					pname.setText("");
					domain.setText("");
					members.setText("");
					dname.setText("");
					dsub.setText("");
					dcount.setText("");
					ano.setText("");
					cno.setText("");
					publisher.setText("");
					title.setText("");
					author.setText("");
					isbn.setText("");
					}
					if(rdbtnBeProjects.isSelected()==true)
					{
						rdbtnBooks.setSelected(false);
						rdbtnMagazines.setSelected(false);
						rdbtnDonated.setSelected(false);
						count.setEnabled(false);
						magname.setEnabled(false);
						society.setEnabled(false);
						edition.setEnabled(false);
						ano.setEnabled(false);
						cno.setEnabled(false);
						publisher.setEnabled(false);
						title.setEnabled(false);
						author.setEnabled(false);
						isbn.setEnabled(false);
						reg.getComponent(0).setEnabled(false);
						pname.setEnabled(true);
						domain.setEnabled(true);
						members.setEnabled(true);
						dname.setEnabled(false);
						dsub.setEnabled(false);
						dcount.setEnabled(false);
						comboBox_2.setEnabled(false);
						comboBox_3.setEnabled(false);
						comboBox_4.setEnabled(false);
						comboBox_5.setEnabled(false);
						count.setText("");
						magname.setText("");
						society.setText("");
						edition.setText("");
						pname.setText("");
						domain.setText("");
						members.setText("");
						dname.setText("");
						dsub.setText("");
						dcount.setText("");
						ano.setText("");
						cno.setText("");
						publisher.setText("");
						title.setText("");
						author.setText("");
						isbn.setText("");
				}
					else
					{
						rdbtnBeProjects.setSelected(false);
						rdbtnMagazines.setSelected(false);
						rdbtnDonated.setSelected(false);
						count.setEnabled(false);
						magname.setEnabled(false);
						society.setEnabled(false);
						edition.setEnabled(false);
						ano.setEnabled(false);
						cno.setEnabled(false);
						publisher.setEnabled(false);
						title.setEnabled(false);
						author.setEnabled(false);
						isbn.setEnabled(false);
						reg.getComponent(0).setEnabled(false);
						pname.setEnabled(false);
						domain.setEnabled(false);
						members.setEnabled(false);
						dname.setEnabled(false);
						dsub.setEnabled(false);
						dcount.setEnabled(false);
						comboBox_2.setEnabled(false);
						comboBox_3.setEnabled(false);
						comboBox_4.setEnabled(false);
						comboBox_5.setEnabled(false);
						count.setText("");
						magname.setText("");
						society.setText("");
						edition.setText("");
						pname.setText("");
						domain.setText("");
						members.setText("");
						dname.setText("");
						dsub.setText("");
						dcount.setText("");
						ano.setText("");
						cno.setText("");
						publisher.setText("");
						title.setText("");
						author.setText("");
						isbn.setText("");
					}
					if(rdbtnBooks.isSelected()==true)
					{
						rdbtnBeProjects.setSelected(false);
						rdbtnMagazines.setSelected(false);
						rdbtnDonated.setSelected(false);
						count.setEnabled(false);
						magname.setEnabled(false);
						society.setEnabled(false);
						edition.setEnabled(false);
						ano.setEnabled(true);
						cno.setEnabled(true);
						publisher.setEnabled(true);
						title.setEnabled(true);
						author.setEnabled(true);
						isbn.setEnabled(true);
						reg.getComponent(0).setEnabled(true);
						pname.setEnabled(false);
						domain.setEnabled(false);
						members.setEnabled(false);
						dname.setEnabled(false);
						dsub.setEnabled(false);
						dcount.setEnabled(false);
						comboBox_2.setEnabled(true);
						comboBox_3.setEnabled(true);
						comboBox_4.setEnabled(true);
						comboBox_5.setEnabled(true);
						count.setText("");
						magname.setText("");
						society.setText("");
						edition.setText("");
						pname.setText("");
						domain.setText("");
						members.setText("");
						dname.setText("");
						dsub.setText("");
						dcount.setText("");
						ano.setText("");
						cno.setText("");
						publisher.setText("");
						title.setText("");
						author.setText("");
						isbn.setText("");
						}
					else
					{
						rdbtnBeProjects.setSelected(false);
						rdbtnMagazines.setSelected(false);
						rdbtnDonated.setSelected(false);
						count.setEnabled(false);
						magname.setEnabled(false);
						society.setEnabled(false);
						edition.setEnabled(false);
						ano.setEnabled(false);
						cno.setEnabled(false);
						publisher.setEnabled(false);
						title.setEnabled(false);
						author.setEnabled(false);
						isbn.setEnabled(false);
						reg.getComponent(0).setEnabled(false);
						pname.setEnabled(false);
						domain.setEnabled(false);
						members.setEnabled(false);
						dname.setEnabled(false);
						dsub.setEnabled(false);
						dcount.setEnabled(false);
						comboBox_2.setEnabled(false);
						comboBox_3.setEnabled(false);
						comboBox_4.setEnabled(false);
						comboBox_5.setEnabled(false);
						count.setText("");
						magname.setText("");
						society.setText("");
						edition.setText("");
						pname.setText("");
						domain.setText("");
						members.setText("");
						dname.setText("");
						dsub.setText("");
						dcount.setText("");
						ano.setText("");
						cno.setText("");
						publisher.setText("");
						title.setText("");
						author.setText("");
						isbn.setText("");
					}
						if(rdbtnMagazines.isSelected())
						{	
						rdbtnBooks.setSelected(false);
						rdbtnBeProjects.setSelected(false);
						rdbtnDonated.setSelected(false);
						count.setEnabled(true);
						magname.setEnabled(true);
						society.setEnabled(true);
						edition.setEnabled(true);
						ano.setEnabled(false);
						cno.setEnabled(false);
						publisher.setEnabled(false);
						title.setEnabled(false);
						author.setEnabled(false);
						isbn.setEnabled(false);
						reg.getComponent(0).setEnabled(false);
						pname.setEnabled(false);
						domain.setEnabled(false);
						members.setEnabled(false);
						dname.setEnabled(false);
						dsub.setEnabled(false);
						dcount.setEnabled(false);
						comboBox_2.setEnabled(false);
						comboBox_3.setEnabled(false);
						comboBox_4.setEnabled(false);
						comboBox_5.setEnabled(false);
						count.setText("");
						magname.setText("");
						society.setText("");
						edition.setText("");
						pname.setText("");
						domain.setText("");
						members.setText("");
						dname.setText("");
						dsub.setText("");
						dcount.setText("");
						ano.setText("");
						cno.setText("");
						publisher.setText("");
						title.setText("");
						author.setText("");
						isbn.setText("");
						}
						else
						{
							rdbtnBeProjects.setSelected(false);
							rdbtnMagazines.setSelected(false);
							rdbtnDonated.setSelected(false);
							count.setEnabled(false);
							magname.setEnabled(false);
							society.setEnabled(false);
							edition.setEnabled(false);
							ano.setEnabled(false);
							cno.setEnabled(false);
							publisher.setEnabled(false);
							title.setEnabled(false);
							author.setEnabled(false);
							isbn.setEnabled(false);
							reg.getComponent(0).setEnabled(false);
							pname.setEnabled(false);
							domain.setEnabled(false);
							members.setEnabled(false);
							dname.setEnabled(false);
							dsub.setEnabled(false);
							dcount.setEnabled(false);
							comboBox_2.setEnabled(false);
							comboBox_3.setEnabled(false);
							comboBox_4.setEnabled(false);
							comboBox_5.setEnabled(false);
							count.setText("");
							magname.setText("");
							society.setText("");
							edition.setText("");
							pname.setText("");
							domain.setText("");
							members.setText("");
							dname.setText("");
							dsub.setText("");
							dcount.setText("");
							ano.setText("");
							cno.setText("");
							publisher.setText("");
							title.setText("");
							author.setText("");
							isbn.setText("");
						}
				}
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(internalFrame.getContentPane());
		
		JPopupMenu popupMenu_2 = new JPopupMenu();
		addPopup(internalFrame.getContentPane(), popupMenu_2);
		
		JMenuItem menuItem = new JMenuItem("Copy");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_COPY, 0));
		popupMenu_2.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Cut");
		menuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_CUT, 0));
		popupMenu_2.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("Paste");
		menuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PASTE, 0));
		popupMenu_2.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("Find");
		menuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_FIND, 0));
		popupMenu_2.add(menuItem_3);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBooks)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(lblANo_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(lblCallNo_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(lblIsbn))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(lblTitle))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(lblAuthor))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(lblPublisher, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(lblRegDate))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(lblSubjectid))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addComponent(rdbtnBooks)))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(ano, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(cno, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(isbn, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(title, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(author, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rdbtnMagazines)
							.addGap(6)
							.addComponent(rdbtnBeProjects)
							.addGap(6)
							.addComponent(rdbtnDonated))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(reg, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(publisher, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
					.addGap(6)
					.addComponent(separator_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblMagazines))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(lblMagazineName)
							.addGap(12)
							.addComponent(magname, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(society, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(67)
							.addComponent(lblEdition)
							.addGap(18)
							.addComponent(edition, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(72)
							.addComponent(lblCount)
							.addGap(18)
							.addComponent(count, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
						.addComponent(separator_16, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(lblBeProjects))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(lblProjectName)
							.addGap(26)
							.addComponent(pname, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addComponent(lblDomain)
							.addGap(26)
							.addComponent(domain, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addComponent(lblMembers)
							.addGap(26)
							.addComponent(members, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
						.addComponent(separator_17, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(lblDonatedBooks))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(71)
							.addComponent(lblTitle_1)
							.addGap(31)
							.addComponent(dname, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addComponent(lblSubject)
							.addGap(31)
							.addComponent(dsub, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(61)
								.addComponent(lblCount_1)
								.addGap(31)
								.addComponent(dcount, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(22)
								.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(rdbtnDelete)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblBooks)
							.addGap(11)
							.addComponent(lblANo_1)
							.addGap(30)
							.addComponent(lblCallNo_1)
							.addGap(37)
							.addComponent(lblIsbn)
							.addGap(37)
							.addComponent(lblTitle)
							.addGap(35)
							.addComponent(lblAuthor)
							.addGap(36)
							.addComponent(lblPublisher)
							.addGap(33)
							.addComponent(lblRegDate)
							.addGap(37)
							.addComponent(lblSubjectid)
							.addGap(95)
							.addComponent(rdbtnBooks))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(ano, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(cno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addComponent(isbn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addComponent(title, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(author, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(24)
							.addComponent(publisher, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(reg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnMagazines)
								.addComponent(rdbtnBeProjects)
								.addComponent(rdbtnDonated)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(separator_15, GroupLayout.PREFERRED_SIZE, 514, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblMagazines)
							.addGap(7)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(lblMagazineName))
								.addComponent(magname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(lblNewLabel_1))
								.addComponent(society, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(lblEdition))
								.addComponent(edition, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(lblCount))
								.addComponent(count, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(20)
							.addComponent(separator_16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblBeProjects)
							.addGap(1)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(lblProjectName))
								.addComponent(pname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(lblDomain))
								.addComponent(domain, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(lblMembers))
								.addComponent(members, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(separator_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblDonatedBooks)
							.addGap(8)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(lblTitle_1))
								.addComponent(dname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(lblSubject))
								.addComponent(dsub, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(lblCount_1))
								.addComponent(dcount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(rdbtnDelete)
							.addGap(22)))
					.addGap(32))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(519, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		internalFrame.getContentPane().setLayout(groupLayout);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(237)
					.addComponent(internalFrame, GroupLayout.PREFERRED_SIZE, 741, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(248, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(28)
					.addComponent(internalFrame, GroupLayout.PREFERRED_SIZE, 598, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(136, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		//JPanel panel_2 = new JPanel();
		ImagePanel panel_2 = new ImagePanel(System.getProperty("user.dir").replace("\\", "/")+"/src/icons/green-abstract-wallpaper7.jpg");
		panel_2.setBackground(SystemColor.control);
		tabbedPane.addTab("", new ImageIcon("C:\\Users\\pranay\\workspace1\\Library\\src\\search.png"), panel_2, null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JSeparator separator_12 = new JSeparator();
		
		JSeparator separator_13 = new JSeparator();
		
		JLabel lblSearchBy = new JLabel("Search By:");
		lblSearchBy.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		
		JSeparator separator_14 = new JSeparator();
		
		JRadioButton rdbtnBookname = new JRadioButton("Bookname:");
		
		JRadioButton rdbtnAuthor = new JRadioButton("Author:");
		
		JRadioButton rdbtnDateRange = new JRadioButton("Date Range:");
		rdbtnDateRange.setToolTipText("Get the books issued in the chosen date Range");
		
		textField_8 = new JFormattedTextField();
		textField_8.setEnabled(false);
		textField_8.setColumns(10);
		
		textField_12 = new JFormattedTextField(new RegexFormatter("[A-Za-z\\s\\,\\.]{1,}"));
		textField_12.setEnabled(false);
		textField_12.setColumns(10);
		
		JDatePanelImpl datePanel3 = new JDatePanelImpl(model3, p);
		JDatePickerImpl datePicker3 = new JDatePickerImpl(datePanel3, new DateLabelFormatter());
		datePicker3.getJFormattedTextField().setEnabled(false);
		
		JDatePanelImpl datePanel4 = new JDatePanelImpl(model4, p);
		JDatePickerImpl datePicker4 = new JDatePickerImpl(datePanel4, new DateLabelFormatter());
		datePicker4.getJFormattedTextField().setEnabled(false);
		panel_2.add(datePicker3);
		panel_2.add(datePicker4);
		
		table_1 = new JTable(){/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {                
            return false;               
    };};
		table_1.setCellSelectionEnabled(true);
		table_1.setShowVerticalLines(true);
		table_1.setShowHorizontalLines(true);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"S.No.", "A.No.", "Call No.", "Title", "Author", "Publisher", "Status", "Issue Date", "Issuer_Id", "Stock"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(42);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(77);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(218);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(122);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(144);
		table_1.getColumnModel().getColumn(6).setPreferredWidth(51);
		table_1.getColumnModel().getColumn(7).setPreferredWidth(71);
		table_1.getColumnModel().getColumn(9).setPreferredWidth(42);
		table_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		scrollPane.setViewportView(table_1);
		
		JRadioButton rdbtnStudentid = new JRadioButton("Student_id:");
		
		textField_13 = new JFormattedTextField(new RegexFormatter("^C2K\\d{8}"));
		textField_13.setToolTipText("Only the students who issued books can be seen");
		textField_13.setEnabled(false);
		textField_13.setColumns(10);
		
		JRadioButton rdbtnAno = new JRadioButton("A.NO:");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Call No:");
		
		textField_14 = new JFormattedTextField();
		textField_14.setToolTipText("Only info of Issued  books");
		textField_14.setEnabled(false);
		textField_14.setColumns(10);
		
		textField_15 = new JFormattedTextField();
		textField_15.setToolTipText("Only info of Issued  books");
		textField_15.setEnabled(false);
		textField_15.setColumns(10);
		
		JRadioButton rdbtnReturnStatus = new JRadioButton("Return Status");
		
		JRadioButton rdbtnMagzines = new JRadioButton("Magazines");
		
		JRadioButton rdbtnProjects = new JRadioButton("Projects");
		
		JRadioButton rdbtnNbaReport = new JRadioButton("NBA Report");
		rdbtnNbaReport.setToolTipText("Generates a NBA Report of total books per Subject");
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PDFgen.printJtable(data.path);
				String message = "Printing...";
				JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.PLAIN_MESSAGE);
				
				if (Desktop.isDesktopSupported()) {
				    try {
				        File myFile = new File(data.path+"jTable.pdf");
				        Desktop.getDesktop().open(myFile);
				    } catch (IOException ex) {
				        // no application registered for PDFs
				    }
				}
			}
		});
		
		JButton btnSearch = new JButton("Search");
		
		JRadioButton rdbtnYellowCard = new JRadioButton("Yellow Card:");
		
		txtCallno = new JFormattedTextField();
		txtCallno.setToolTipText("Enter the Call Number of the book");
		txtCallno.setEnabled(false);
		txtCallno.setText("Call.No.");
		txtCallno.setColumns(10);
		rdbtnBookname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnBookname.isSelected()==true)
				{
					rdbtnAuthor.setSelected(false);
					rdbtnDateRange.setSelected(false);
					rdbtnStudentid.setSelected(false);
					rdbtnAno.setSelected(false);
					rdbtnNewRadioButton.setSelected(false);
					rdbtnReturnStatus.setSelected(false);
					rdbtnMagzines.setSelected(false);
					rdbtnProjects.setSelected(false);
					rdbtnNbaReport.setSelected(false);
					rdbtnYellowCard.setSelected(false);
					textField_8.setEnabled(true);
					textField_8.requestFocus();
					textField_12.setEnabled(false);
					textField_13.setEnabled(false);
					textField_14.setEnabled(false);
					textField_15.setEnabled(false);
					txtCallno.setEnabled(false);
					textField_12.setText("");
					textField_13.setText("");
					textField_14.setText("");
					textField_15.setText("");
					txtCallno.setText("");
					datePicker3.getComponent(0).setEnabled(false);
					datePicker4.getComponent(0).setEnabled(false);
					
				}
				else
				{
					textField_8.setEnabled(false);
					textField_8.setText("");
				}
			}
		});
		rdbtnYellowCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(rdbtnYellowCard.isSelected()==true)
				{
					rdbtnAuthor.setSelected(false);
					rdbtnDateRange.setSelected(false);
					rdbtnStudentid.setSelected(false);
					rdbtnAno.setSelected(false);
					rdbtnNewRadioButton.setSelected(false);
					rdbtnReturnStatus.setSelected(false);
					rdbtnBookname.setSelected(false);
					rdbtnMagzines.setSelected(false);
					rdbtnNbaReport.setSelected(false);
					rdbtnProjects.setSelected(false);
					textField_8.setEnabled(false);
					textField_12.setEnabled(false);
					textField_13.setEnabled(false);
					textField_14.setEnabled(false);
					textField_15.setEnabled(false);
					txtCallno.setEnabled(true);
					txtCallno.setText("");
					textField_8.setText("");
					textField_12.setText("");
					textField_13.setText("");
					textField_14.setText("");
					textField_15.setText("");
					txtCallno.requestFocus();
					datePicker3.getComponent(0).setEnabled(false);
					datePicker4.getComponent(0).setEnabled(false);
				}
				else{
					txtCallno.setEnabled(false);
					txtCallno.setText("Call no.");
				}
				
			}
		});
		rdbtnNbaReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(rdbtnNbaReport.isSelected()==true)
				{
					rdbtnAuthor.setSelected(false);
					rdbtnDateRange.setSelected(false);
					rdbtnStudentid.setSelected(false);
					rdbtnAno.setSelected(false);
					rdbtnNewRadioButton.setSelected(false);
					rdbtnReturnStatus.setSelected(false);
					rdbtnBookname.setSelected(false);
					rdbtnMagzines.setSelected(false);
					rdbtnProjects.setSelected(false);
					rdbtnYellowCard.setSelected(false);
					textField_8.setEnabled(false);
					textField_12.setEnabled(false);
					textField_13.setEnabled(false);
					textField_14.setEnabled(false);
					textField_15.setEnabled(false);
					txtCallno.setEnabled(false);
					textField_8.setText("");
					textField_12.setText("");
					textField_13.setText("");
					textField_14.setText("");
					textField_15.setText("");
					txtCallno.setText("");
					datePicker3.getComponent(0).setEnabled(false);
					datePicker4.getComponent(0).setEnabled(false);
				}
			}
		});
		
		rdbtnAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnAuthor.isSelected()==true)
				{
					rdbtnBookname.setSelected(false);
					rdbtnDateRange.setSelected(false);
					rdbtnStudentid.setSelected(false);
					rdbtnAno.setSelected(false);
					rdbtnNewRadioButton.setSelected(false);
					rdbtnReturnStatus.setSelected(false);
					rdbtnMagzines.setSelected(false);
					rdbtnProjects.setSelected(false);
					rdbtnNbaReport.setSelected(false);
					rdbtnYellowCard.setSelected(false);
					textField_8.setEnabled(false);
					textField_12.setEnabled(true);
					textField_13.setEnabled(false);
					textField_14.setEnabled(false);
					textField_15.setEnabled(false);
					txtCallno.setEnabled(false);
					textField_8.setText("");
					textField_12.requestFocus();
					textField_13.setText("");
					textField_14.setText("");
					textField_15.setText("");
					txtCallno.setText("");
					datePicker3.getComponent(0).setEnabled(false);
					datePicker4.getComponent(0).setEnabled(false);
				}
				else{
					textField_12.setEnabled(false);
					textField_12.setText("");
				}
			}
		});
		rdbtnDateRange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnDateRange.isSelected()==true)
				{
					rdbtnAuthor.setSelected(false);
					rdbtnBookname.setSelected(false);
					rdbtnStudentid.setSelected(false);
					rdbtnAno.setSelected(false);
					rdbtnNewRadioButton.setSelected(false);
					rdbtnReturnStatus.setSelected(false);
					rdbtnMagzines.setSelected(false);
					rdbtnProjects.setSelected(false);
					rdbtnNbaReport.setSelected(false);
					rdbtnYellowCard.setSelected(false);
					textField_8.setEnabled(false);
					textField_12.setEnabled(false);
					textField_13.setEnabled(false);
					textField_14.setEnabled(false);
					textField_15.setEnabled(false);
					txtCallno.setEnabled(false);
					textField_8.setText("");
					textField_12.setText("");
					textField_13.setText("");
					textField_14.setText("");
					textField_15.setText("");
					txtCallno.setText("");
					datePicker3.getComponent(0).setEnabled(true);
					datePicker4.getComponent(0).setEnabled(true);
				}
				else{
					datePicker3.getComponent(0).setEnabled(false);
					datePicker4.getComponent(0).setEnabled(false);
				}
			}
		});
		rdbtnStudentid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(rdbtnStudentid.isSelected()==true)
				{
					rdbtnAuthor.setSelected(false);
					rdbtnDateRange.setSelected(false);
					rdbtnBookname.setSelected(false);
					rdbtnAno.setSelected(false);
					rdbtnNewRadioButton.setSelected(false);
					rdbtnReturnStatus.setSelected(false);
					rdbtnMagzines.setSelected(false);
					rdbtnProjects.setSelected(false);
					rdbtnNbaReport.setSelected(false);
					rdbtnYellowCard.setSelected(false);
					textField_8.setEnabled(false);
					textField_12.setEnabled(false);
					textField_13.setEnabled(true);
					textField_14.setEnabled(false);
					textField_15.setEnabled(false);
					txtCallno.setEnabled(false);
					textField_8.setText("");
					textField_12.setText("");
					textField_13.requestFocus();
					textField_14.setText("");
					textField_15.setText("");
					txtCallno.setText("");
					datePicker3.getComponent(0).setEnabled(false);
					datePicker4.getComponent(0).setEnabled(false);
				}
				else{
					textField_13.setEnabled(false);
					textField_13.setText("");
				}
			}
		});
		rdbtnAno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(rdbtnAno.isSelected()==true)
				{
					rdbtnAuthor.setSelected(false);
					rdbtnDateRange.setSelected(false);
					rdbtnStudentid.setSelected(false);
					rdbtnBookname.setSelected(false);
					rdbtnNewRadioButton.setSelected(false);
					rdbtnReturnStatus.setSelected(false);
					rdbtnMagzines.setSelected(false);
					rdbtnProjects.setSelected(false);
					rdbtnNbaReport.setSelected(false);
					rdbtnYellowCard.setSelected(false);
					textField_8.setEnabled(false);
					textField_12.setEnabled(false);
					textField_13.setEnabled(false);
					textField_14.setEnabled(true);
					textField_15.setEnabled(false);
					txtCallno.setEnabled(false);
					textField_8.setText("");
					textField_12.setText("");
					textField_13.setText("");
					textField_14.requestFocus();
					textField_15.setText("");
					txtCallno.setText("");
					datePicker3.getComponent(0).setEnabled(false);
					datePicker4.getComponent(0).setEnabled(false);
				}
				else{
					textField_14.setEnabled(false);
					textField_14.setText("");
				}
			}
		});
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(rdbtnNewRadioButton.isSelected()==true)
				{
					rdbtnAuthor.setSelected(false);
					rdbtnDateRange.setSelected(false);
					rdbtnStudentid.setSelected(false);
					rdbtnAno.setSelected(false);
					rdbtnBookname.setSelected(false);
					rdbtnReturnStatus.setSelected(false);
					rdbtnMagzines.setSelected(false);
					rdbtnProjects.setSelected(false);
					rdbtnNbaReport.setSelected(false);
					rdbtnYellowCard.setSelected(false);
					textField_8.setEnabled(false);
					textField_12.setEnabled(false);
					textField_13.setEnabled(false);
					textField_14.setEnabled(false);
					textField_15.setEnabled(true);
					txtCallno.setEnabled(false);
					textField_8.setText("");
					textField_12.setText("");
					textField_13.setText("");
					textField_14.setText("");
					textField_15.requestFocus();
					txtCallno.setText("");
					datePicker3.getComponent(0).setEnabled(false);
					datePicker4.getComponent(0).setEnabled(false);
				}
				else{
					textField_15.setEnabled(false);
					textField_15.setText("");
				}
				
			}
		});
		rdbtnReturnStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnReturnStatus.isSelected()==true)
				{
					rdbtnAuthor.setSelected(false);
					rdbtnDateRange.setSelected(false);
					rdbtnStudentid.setSelected(false);
					rdbtnAno.setSelected(false);
					rdbtnNewRadioButton.setSelected(false);
					rdbtnBookname.setSelected(false);
					rdbtnMagzines.setSelected(false);
					rdbtnProjects.setSelected(false);
					rdbtnNbaReport.setSelected(false);
					rdbtnYellowCard.setSelected(false);
					textField_8.setEnabled(false);
					textField_12.setEnabled(false);
					textField_13.setEnabled(false);
					textField_14.setEnabled(false);
					textField_15.setEnabled(false);
					txtCallno.setEnabled(false);
					textField_8.setText("");
					textField_12.setText("");
					textField_13.setText("");
					textField_14.setText("");
					textField_15.setText("");
					txtCallno.setText("");
					datePicker3.getComponent(0).setEnabled(false);
					datePicker4.getComponent(0).setEnabled(false);
				}
			}
		});
		rdbtnMagzines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMagzines.isSelected()==true)
				{
					rdbtnAuthor.setSelected(false);
					rdbtnDateRange.setSelected(false);
					rdbtnStudentid.setSelected(false);
					rdbtnAno.setSelected(false);
					rdbtnNewRadioButton.setSelected(false);
					rdbtnReturnStatus.setSelected(false);
					rdbtnBookname.setSelected(false);
					rdbtnProjects.setSelected(false);
					rdbtnNbaReport.setSelected(false);
					rdbtnYellowCard.setSelected(false);
					textField_8.setEnabled(false);
					textField_12.setEnabled(false);
					textField_13.setEnabled(false);
					textField_14.setEnabled(false);
					textField_15.setEnabled(false);
					txtCallno.setEnabled(false);
					textField_8.setText("");
					textField_12.setText("");
					textField_13.setText("");
					textField_14.setText("");
					textField_15.setText("");
					txtCallno.setText("");
					datePicker3.getComponent(0).setEnabled(false);
					datePicker4.getComponent(0).setEnabled(false);
				}
			}
		});
		rdbtnProjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(rdbtnProjects.isSelected()==true)
				{
					rdbtnAuthor.setSelected(false);
					rdbtnDateRange.setSelected(false);
					rdbtnStudentid.setSelected(false);
					rdbtnAno.setSelected(false);
					rdbtnNewRadioButton.setSelected(false);
					rdbtnReturnStatus.setSelected(false);
					rdbtnBookname.setSelected(false);
					rdbtnMagzines.setSelected(false);
					rdbtnNbaReport.setSelected(false);
					rdbtnYellowCard.setSelected(false);
					textField_8.setEnabled(false);
					textField_12.setEnabled(false);
					textField_13.setEnabled(false);
					textField_14.setEnabled(false);
					textField_15.setEnabled(false);
					txtCallno.setEnabled(false);
					textField_8.setText("");
					textField_12.setText("");
					textField_13.setText("");
					textField_14.setText("");
					textField_15.setText("");
					txtCallno.setText("");
					datePicker3.getComponent(0).setEnabled(false);
					datePicker4.getComponent(0).setEnabled(false);
				}
			}
		});
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnBookname.isSelected() & textField_8.getText().equals("")==false)
				{
					try {
						data.SearchByTitle(Login.getcon(), textField_8.getText());
					} catch (ClassNotFoundException | ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(rdbtnAuthor.isSelected() & textField_12.getText().equals("")==false)
				{
					try {
						data.SearchByAuthor(Login.getcon(), textField_12.getText());
					} catch (ClassNotFoundException | ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(rdbtnDateRange.isSelected())
				{
					try {
						data.SearchByDate(Login.getcon(), datePicker3.getJFormattedTextField().getText(), datePicker4.getJFormattedTextField().getText());
					} catch (ClassNotFoundException | ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(rdbtnStudentid.isSelected() &  textField_13.getText().equals("")==false)
				{
					try {
						data.SearchByStudId(Login.getcon(), textField_13.getText());
					} catch (ClassNotFoundException | ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(rdbtnAno.isSelected() &  textField_14.getText().equals("")==false)
				{
					try {
						data.SearchByA_no(Login.getcon(), textField_14.getText());
					} catch (ClassNotFoundException | ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(rdbtnNewRadioButton.isSelected() &  textField_15.getText().equals("")==false)
				{
					try {
						data.SearchByC_no(Login.getcon(), textField_15.getText());
					} catch (ClassNotFoundException | ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(rdbtnMagzines.isSelected())
				{
					try {
						data.SearchByMagazine(Login.getcon());
					} catch (ClassNotFoundException | ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(rdbtnProjects.isSelected())
				{
					try {
						data.SearchByBEProject(Login.getcon());
					} catch (ClassNotFoundException | ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(rdbtnNbaReport.isSelected())
				{
					try {
						data.genNBA(Login.getcon());
					} catch (ClassNotFoundException | ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(rdbtnYellowCard.isSelected() & txtCallno.getText().equals("")==false)
				{
					try {
						data.genYC(Login.getcon(),txtCallno.getText());
					} catch (ClassNotFoundException | ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(rdbtnReturnStatus.isSelected()){
					try {
						data.SearchByReturnStatus(Login.getcon());
					} catch (ClassNotFoundException | ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				{
					String message = "Oops!! Left Fields blank!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		
		JPopupMenu popupMenu_3 = new JPopupMenu();
		addPopup(panel_2, popupMenu_3);
		
		JMenuItem menuItem_4 = new JMenuItem("Copy");
		menuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_COPY, 0));
		popupMenu_3.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("Cut");
		menuItem_5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_CUT, 0));
		popupMenu_3.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("Paste");
		menuItem_6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PASTE, 0));
		popupMenu_3.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("Find");
		menuItem_7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_FIND, 0));
		popupMenu_3.add(menuItem_7);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(6)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1164, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(separator_14, GroupLayout.PREFERRED_SIZE, 536, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSearchBy)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(separator_13, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(rdbtnBookname)
							.addGap(12)
							.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
							.addGap(122)
							.addComponent(rdbtnStudentid)
							.addGap(12)
							.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(rdbtnReturnStatus)
							.addGap(18)
							.addComponent(rdbtnMagzines)
							.addGap(18)
							.addComponent(rdbtnProjects)
							.addGap(18)
							.addComponent(rdbtnNbaReport))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(rdbtnAuthor)
							.addGap(37)
							.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
							.addGap(122)
							.addComponent(rdbtnAno)
							.addGap(43)
							.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
							.addGap(75)
							.addComponent(rdbtnYellowCard)
							.addGap(18)
							.addComponent(txtCallno, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(rdbtnDateRange)
							.addGap(6)
							.addComponent(datePicker3, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(datePicker4, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addGap(120)
							.addComponent(rdbtnNewRadioButton)
							.addGap(30)
							.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
							.addGap(91)
							.addComponent(btnSearch)
							.addGap(121)
							.addComponent(btnPrint))
						.addComponent(separator_12, GroupLayout.PREFERRED_SIZE, 1170, GroupLayout.PREFERRED_SIZE))
					.addGap(20))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(56)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addComponent(separator_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSearchBy)))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(70)
							.addComponent(separator_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(36)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(5)
							.addComponent(rdbtnBookname))
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(5)
							.addComponent(rdbtnStudentid))
						.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(5)
							.addComponent(rdbtnReturnStatus))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(5)
							.addComponent(rdbtnMagzines))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(5)
							.addComponent(rdbtnProjects))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(5)
							.addComponent(rdbtnNbaReport)))
					.addGap(6)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(5)
							.addComponent(rdbtnAuthor))
						.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(6)
							.addComponent(rdbtnAno))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(1)
							.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(6)
							.addComponent(rdbtnYellowCard))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(1)
							.addComponent(txtCallno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(12)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(5)
							.addComponent(rdbtnDateRange))
						.addComponent(datePicker3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(datePicker4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(5)
							.addComponent(rdbtnNewRadioButton))
						.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch)
						.addComponent(btnPrint))
					.addGap(4)
					.addComponent(separator_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
					.addGap(154))
		);
		panel_2.setLayout(gl_panel_2);
		GroupLayout groupLayout_1 = new GroupLayout(frame.getContentPane());
		groupLayout_1.setHorizontalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addComponent(bar, GroupLayout.PREFERRED_SIZE, 1349, GroupLayout.PREFERRED_SIZE)
				.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 1349, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout_1.setVerticalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addComponent(bar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a="";
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Choose Folder");
				fileChooser.setApproveButtonText("Choose");
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		          a=fileChooser.getSelectedFile().getAbsolutePath();
		        }
				JavaDB.backupDB(a);
			}
		});
		button.setToolTipText("Backup Database");
		button.setIcon(new ImageIcon(Gui3.class.getResource("/icons/1469851473_BT_database_export.png")));
		bar.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a="";
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Choose Table File");
				fileChooser.setApproveButtonText("Choose");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		          a=fileChooser.getSelectedFile().getAbsolutePath();
		        }
				JavaDB.restoreDB(a);
			}
		});
		button_1.setToolTipText("Import Database");
		button_1.setIcon(new ImageIcon(Gui3.class.getResource("/icons/1469851482_BT_database_import.png")));
		bar.add(button_1);
		
		JSeparator separator_22 = new JSeparator();
		bar.add(separator_22);
		
		JSeparator separator_23 = new JSeparator();
		bar.add(separator_23);
		
		JSeparator separator_20 = new JSeparator();
		separator_20.setOrientation(SwingConstants.VERTICAL);
		bar.add(separator_20);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Choose Folder");
				fileChooser.setApproveButtonText("Choose");
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		          String a=fileChooser.getSelectedFile().getAbsolutePath();
		          data.setpath(a);
		        }
			}
		});
		button_2.setIcon(new ImageIcon(Gui3.class.getResource("/icons/1469850898_Toolbox.png")));
		button_2.setToolTipText("Set Path");
		bar.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Print_table frame1 = new Print_table();
				ArrayList<String> a=JavaDB.gettables(Login.getcon());
				for(int i=0;i<a.size();i++)
				{
				Print_table.comboBox.addItem(a.get(i));
				}
			}
		});
		button_3.setToolTipText("Print tables");
		button_3.setIcon(new ImageIcon(Gui3.class.getResource("/icons/1469850992_Report.png")));
		bar.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(Gui3.class.getResource("/icons/1469850841_Find.png")));
		button_4.setToolTipText("Search");
		bar.add(button_4);
		
		textField_2 = new JFormattedTextField();
		textField_2.setMaximumSize(new Dimension(150, 2147483647));
		textField_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				tabbedPane.setSelectedIndex(2);
				table_1.setBackground(null);
			}
		});
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField_2.getText().equals("")==false)
				{
					int i=0;
					String a=textField_2.getText();
					while(i<table_1.getRowCount())
					{
						for(int j=0;j<table_1.getColumnCount();j++)
						{
						if(a.equals(table_1.getValueAt(i, j)))
						{
							table_1.setBackground(Color.magenta);
						}
						}
						i++;
					}
				}
				
			}
		});
		textField_2.setToolTipText("Enter to search data in tables!");
		bar.add(textField_2);
		textField_2.setColumns(10);
		
		TableRowSorter<TableModel> rowSorter= new TableRowSorter<>(table_1.getModel());
		table_1.setRowSorter(rowSorter);
		textField_2.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = textField_2.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = textField_2.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
		
		JSeparator separator_21 = new JSeparator();
		separator_21.setOrientation(SwingConstants.VERTICAL);
		bar.add(separator_21);
		
		JButton button_5 = new JButton("");
		button_5.setIcon(new ImageIcon(Gui3.class.getResource("/icons/1469851069_Refresh.png")));
		button_5.setToolTipText("AutoSync");
		bar.add(button_5);
		
		JButton button_7 = new JButton("");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(Login.getcon().isClosed())
					{
						frame.dispose();
						Gui3 window=new Gui3();
						window.frame.setVisible(false);
						data=new JavaDB();
						ui=new Login(window,data);
						ui.setVisible(true);
					}
					else{
						String message = "Log out Please!";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_7.setIcon(new ImageIcon(Gui3.class.getResource("/icons/1469850726_User_group.png")));
		button_7.setToolTipText("Admin/User Login");
		bar.add(button_7);
		frame.getContentPane().setLayout(groupLayout_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 255, 0));
		menuBar.setOpaque(true);
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setIcon(null);
		menuBar.add(mnFile);
		
		JMenuItem mntmBackupDatabase = new JMenuItem("Backup Database");
		mntmBackupDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a="";
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Choose Folder");
				fileChooser.setApproveButtonText("Choose");
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		          a=fileChooser.getSelectedFile().getAbsolutePath();
		        }
				JavaDB.backupDB(a);
			}
		});
		mntmBackupDatabase.setIcon(new ImageIcon(Gui3.class.getResource("/icons/1469851473_BT_database_export.png")));
		mntmBackupDatabase.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		mnFile.add(mntmBackupDatabase);
		
		JMenuItem mntmExportDatabase = new JMenuItem("Import Database");
		mntmExportDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a="";
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Choose Table File");
				fileChooser.setApproveButtonText("Choose");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		          a=fileChooser.getSelectedFile().getAbsolutePath();
		        }
				JavaDB.restoreDB(a);
			}
		});
		mntmExportDatabase.setIcon(new ImageIcon(Gui3.class.getResource("/icons/1469851482_BT_database_import.png")));
		mntmExportDatabase.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
		mnFile.add(mntmExportDatabase);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmPrintTables = new JMenuItem("Print tables");
		mntmPrintTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Print_table frame1 = new Print_table();
				ArrayList<String> a=JavaDB.gettables(Login.getcon());
				for(int i=0;i<a.size();i++)
				{
				Print_table.comboBox.addItem(a.get(i));
				}
			}
		});
		mntmPrintTables.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mntmPrintTables.setIcon(new ImageIcon(Gui3.class.getResource("/icons/1469850992_Report.png")));
		mnFile.add(mntmPrintTables);
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		JSeparator separator_3 = new JSeparator();
		mnFile.add(separator_3);
		
		JMenuItem mntmClose = new JMenuItem("Close Application");
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		mntmClose.setIcon(new ImageIcon(Gui3.class.getResource("/icons/1469850738_Exit.png")));
		mntmClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mnFile.add(mntmClose);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmCut = new JMenuItem(new DefaultEditorKit.CutAction());
		mntmCut.setText("Cut");
		mntmCut.setIcon(new ImageIcon(Gui3.class.getResource("/icons/1469851025_Cut.png")));
		mntmCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mnEdit.add(mntmCut);
		
		JMenuItem mntmCopy = new JMenuItem(new DefaultEditorKit.CopyAction());
		mntmCopy.setText("Copy");
		mntmCopy.setIcon(new ImageIcon(Gui3.class.getResource("/icons/1469851855_line-15.png")));
		mntmCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem(new DefaultEditorKit.PasteAction());
		mntmPaste.setText("Paste");
		mntmPaste.setIcon(new ImageIcon(Gui3.class.getResource("/icons/1469851922_BT_duplicate_formatting.png")));
		mntmPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		mnEdit.add(mntmPaste);
		
		JSeparator separator_5 = new JSeparator();
		mnEdit.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		mnEdit.add(separator_6);
		
		JMenuItem mntmFindAndReplace = new JMenuItem("Find");
		mntmFindAndReplace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setText("");
				textField_2.requestFocus();
			}
		});
		mntmFindAndReplace.setIcon(new ImageIcon(Gui3.class.getResource("/icons/1469850841_Find.png")));
		mntmFindAndReplace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		mnEdit.add(mntmFindAndReplace);
		
		JMenu mnNewMenu = new JMenu("Sync");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAutosync = new JMenuItem("AutoSync");
		mntmAutosync.setIcon(new ImageIcon(Gui3.class.getResource("/icons/1469851069_Refresh.png")));
		mntmAutosync.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnNewMenu.add(mntmAutosync);
		
		JSeparator separator_7 = new JSeparator();
		mnNewMenu.add(separator_7);
		
		JMenuItem mntmSyncAndDownload = new JMenuItem("Sync and Download");
		mntmSyncAndDownload.setIcon(new ImageIcon(Gui3.class.getResource("/icons/1469850815_Download.png")));
		mntmSyncAndDownload.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnNewMenu.add(mntmSyncAndDownload);
		
		JMenuItem mntmSyncAndUpdate = new JMenuItem("Sync and Update");
		mntmSyncAndUpdate.setIcon(new ImageIcon(Gui3.class.getResource("/icons/1469852687_upload.png")));
		mntmSyncAndUpdate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnNewMenu.add(mntmSyncAndUpdate);
		
		JMenu mnUsers = new JMenu("Users");
		menuBar.add(mnUsers);
		
		JMenuItem mntmAdminLogin = new JMenuItem("Admin/User Login");
		mntmAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(Login.getcon().isClosed())
					{
						frame.dispose();
						Gui3 window=new Gui3();
						window.frame.setVisible(false);
						data=new JavaDB();
						ui=new Login(window,data);
						ui.setVisible(true);
					}
					else{
						String message = "Log out Please!";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmAdminLogin.setIcon(new ImageIcon(Gui3.class.getResource("/icons/1469850726_User_group.png")));
		mntmAdminLogin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnUsers.add(mntmAdminLogin);
		
		JMenuItem mntmSetOpPath = new JMenuItem("Set O/P path");
		mntmSetOpPath.setToolTipText("Choose the path for output of your printed format data");
		mntmSetOpPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Choose Folder");
				fileChooser.setApproveButtonText("Choose");
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		          String a=fileChooser.getSelectedFile().getAbsolutePath();
		          data.setpath(a);
		        }
			}
		});
		mntmSetOpPath.setIcon(new ImageIcon(Gui3.class.getResource("/icons/1469850898_Toolbox.png")));
		mnUsers.add(mntmSetOpPath);
		
		JSeparator separator_8 = new JSeparator();
		mnUsers.add(separator_8);
		
		JMenuItem mntmLogOut = new JMenuItem("Log out");
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Login.getcon().close();
					String message = "Logged Out!!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
					tabbedPane.setEnabled(false);
					Component[] c=panel.getComponents();
					for(int i=0;i<c.length;i++)
					{
						c[i].setEnabled(false);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmLogOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mnUsers.add(mntmLogOut);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHowTo = new JMenuItem("Help topics");
		mntmHowTo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
		mntmHowTo.setIcon(new ImageIcon(Gui3.class.getResource("/icons/1469851055_Help_symbol.png")));
		mnHelp.add(mntmHowTo);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				about a=new about();
				a.frmAboutUs.setVisible(true);		
			}
		});
		mntmAbout.setIcon(new ImageIcon(Gui3.class.getResource("/icons/1469850869_Info.png")));
		mnHelp.add(mntmAbout);
	}
	public class DateLabelFormatter extends AbstractFormatter {

	    private String datePattern = "dd-MM-yyyy";
	    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

	    @Override
	    public Object stringToValue(String text) throws ParseException {
	        return dateFormatter.parseObject(text);
	    }

	    @Override
	    public String valueToString(Object value) throws ParseException {
	        if (value != null) {
	            Calendar cal = (Calendar) value;
	            return dateFormatter.format(cal.getTime());
	        }

	        return "";
	    }

	}
	 protected static ImageIcon createImageIcon(String path) {
	        java.net.URL imgURL =Gui3.class.getResource(path);
	        if (imgURL != null) {
	            return new ImageIcon(imgURL);
	        } else {
	            System.err.println("Couldn't find file: " + path);
	            return null;
	        }
	    }
	 class PicPanel extends JPanel{

		 private BufferedImage image;
		 private int w,h;
		 public PicPanel(String fname){

		     //reads the image
		     try {
		         image = ImageIO.read(getClass().getResource(fname));
		         w = image.getWidth();
		         h = image.getHeight();

		     } catch (IOException ioe) {
		         System.out.println("Could not read in the pic");
		         //System.exit(0);
		     }

		 }

		 public Dimension getPreferredSize() {
		     return new Dimension(w,h);
		 }
		 //this will draw the image
		 public void paintComponent(Graphics g){
		     super.paintComponent(g);
		     g.drawImage(image,0,0,this);
		 }
	 }
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
