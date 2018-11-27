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
	private ArrayList<Client> clients;
	private JTextField clientSearch;
	private String clientName;
	private String clientID;
	private static JTextPane txtpnClientData = new JTextPane();
	

	/**
	 * Create the panel.
	 */
	public ClientView() {
		setLayout(null);
		
		JLabel lblClients = new JLabel("CLIENT VIEW");
		lblClients.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClients.setBounds(28, 10, 122, 37);
		add(lblClients);
		
		clientSearch = new JTextField();
		clientSearch.setBounds(665, 171, 96, 19);
		add(clientSearch);
		clientSearch.setColumns(10);
		
		JLabel lblEnterData = new JLabel("Enter Data:");
		lblEnterData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterData.setBounds(539, 168, 82, 20);
		add(lblEnterData);
		//clientList.setVisibleRowCount(4);
		
		JButton searchBtn = new JButton("Search by CLIENT NAME");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		searchBtn.setBounds(693, 292, 143, 21);
		add(searchBtn);
		
		JButton button = new JButton("Search by CASE ID");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(552, 292, 119, 21);
		add(button);
		txtpnClientData.setEditable(false);
		
		txtpnClientData.setBounds(28, 70, 487, 409);
		add(txtpnClientData);
	}


	public String getClientName() {
		return clientName;
	}


	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	public String getClientID() {
		return clientID;
	}


	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	
	public static ArrayList<Client> searchForClientByID(String key){
		ArrayList<Client> searchResults = new ArrayList<Client>();
		for (Client cl: Main.clientList) {
			if (cl.getClientId().contains(key)) {
				searchResults.add(cl);
			}
		}
		return searchResults;
	}
		
	public static ArrayList<Client> searchByClientName(String key){
		ArrayList<Client> searchResults = new ArrayList<Client>();
		for (Client cl: Main.clientList) {
			if ((cl.getFname()+ " "+cl.getLname()).contains(key)) {
				searchResults.add(cl);
			}
		}
		
		return searchResults;	
	}
	
	public static void setTxtPane(String text) {
		txtpnClientData.setText(text);
	}
}
