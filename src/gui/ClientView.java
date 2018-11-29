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

public class ClientView extends JPanel {
	private JTextField clientSearch;
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
		
		clientSearch = new JTextField();
		clientSearch.setBounds(743, 280, 96, 19);
		add(clientSearch);
		clientSearch.setColumns(10);
		
		JLabel lblEnterData = new JLabel("Enter Data:");
		lblEnterData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterData.setBounds(602, 279, 82, 20);
		add(lblEnterData);
		txtpnClientData.setEditable(false);
		
		txtpnClientData.setBounds(28, 70, 487, 409);
		add(txtpnClientData);
		
		JList clientHeadings = new JList();
		clientHeadings.setBounds(540, 70, 122, 181);
		clientHeadings.setLayoutOrientation(JList.VERTICAL);
		
		DefaultListModel dlm = new DefaultListModel();
		//TODO add teh headings for the different client data to the list model to the list
		add(clientHeadings);
		
		JButton btnAddCase = new JButton("Add Case");
		btnAddCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO add JFrame for new case and set the client and case lists again
			}
		});
		btnAddCase.setBounds(540, 362, 85, 21);
		add(btnAddCase);
		
//		ScrollPane scrollPane = new ScrollPane();
//		scrollPane.setBounds(404, 165, 454, 309);
//		scrollPane.add(clientHeadings);
//		add(scrollPane);
		
		this.myClient = c;
		setTxtPane(c.toString2());
	}
	
	public static void setTxtPane(String text) {
		txtpnClientData.setText(text);
	}
}
