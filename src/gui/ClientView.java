package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import backend.*;

import javax.swing.JTextField;

import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;

public class ClientView extends JPanel {
	private static JTextPane txtpnClientData = new JTextPane();
	private Client myClient;
	

	/**
	 * Create the panel.
	 */
	public ClientView(Client c) {
		setLayout(null);
		//TODO add close btn on client to remove the -1 index of the tab pane
		JLabel lblClients = new JLabel("CLIENT VIEW");
		lblClients.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClients.setBounds(28, 10, 122, 37);
		add(lblClients);
		txtpnClientData.setEditable(false);
		
		txtpnClientData.setBounds(28, 70, 487, 409);
		add(txtpnClientData);
		
		DefaultListModel dlm = new DefaultListModel();
		
//		ScrollPane scrollPane = new ScrollPane();
//		scrollPane.setBounds(404, 165, 454, 309);
//		scrollPane.add(clientHeadings);
//		add(scrollPane);
		
		this.myClient = c;
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Available Edits", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(540, 70, 129, 184);
		add(panel);
		panel.setLayout(null);
		
		JButton btnEmail = new JButton("Email");
		btnEmail.setBounds(10, 23, 109, 21);
		panel.add(btnEmail);
		
		JButton btnHomePhone = new JButton("home phone");
		btnHomePhone.setBounds(10, 54, 109, 21);
		panel.add(btnHomePhone);
		
		JButton btnMobilePhone = new JButton("mobile phone");
		btnMobilePhone.setBounds(10, 85, 109, 21);
		panel.add(btnMobilePhone);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(540, 395, 181, 84);
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAddCase = new JButton("Add Case");
		panel_1.add(btnAddCase);
		
		JButton btnEditClient = new JButton("Edit Client");
		panel_1.add(btnEditClient);
		btnAddCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO add JFrame for new case and set the client and case lists again
			}
		});
		setTxtPane(c.toString2());
	}
	
	public static void setTxtPane(String text) {
		txtpnClientData.setText(text);
	}
}
