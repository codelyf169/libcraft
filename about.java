import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Canvas;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Label;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class about {

	JFrame frmAboutUs;

	public about() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAboutUs = new JFrame();
		frmAboutUs.setIconImage(Toolkit.getDefaultToolkit().getImage(about.class.getResource("/icons/1469850869_Info.png")));
		frmAboutUs.setTitle("About US");
		frmAboutUs.getContentPane().setBackground(SystemColor.controlHighlight);
		frmAboutUs.setBounds(100, 100, 560, 451);
		frmAboutUs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextPane txtpnThisProjectIs = new JTextPane();
		txtpnThisProjectIs.setDisabledTextColor(new Color(0, 0, 0));
		txtpnThisProjectIs.setForeground(SystemColor.textText);
		txtpnThisProjectIs.setEnabled(false);
		txtpnThisProjectIs.setEditable(false);
		txtpnThisProjectIs.setBackground(SystemColor.controlHighlight);
		txtpnThisProjectIs.setText("Software\u00A92016 by PICT,Pune. The Software is meant for Computer Department Library of Pune Instititute of Computer Technology,Pune.The Software was developed to replace the manual work and paperless maintenance of book database. In accordance with requirements of Library and ESDL project work, the software developed to ease current needs and learn in the process. The tools used in the Project are open source and is not intended for commercial use.\r\n\r\nDeveloped and Supported by: Pranay Kundu,Neelam Pawar, Shraddha Patil,Shivani Rupnawar");
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAboutUs.dispose();
			}
		});
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(about.class.getResource("/icons/book library.png")));
		GroupLayout groupLayout = new GroupLayout(frmAboutUs.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(label)
					.addGap(25)
					.addComponent(txtpnThisProjectIs, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(233)
							.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(242, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(txtpnThisProjectIs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addComponent(btnOk)
					.addGap(53))
		);
		frmAboutUs.getContentPane().setLayout(groupLayout);
	}
}
