package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import backend.*;

import javax.swing.JTextField;

import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.border.TitledBorder;

public class ClientsScreen extends JPanel {
	private ArrayList<Client> clients;
	private JTextField clientSearch;
	private static JList clientList;
	private String clientName;
	private String clientID;
	

	/**
	 * Create the panel.
	 */
	public ClientsScreen() {
		this.clients = Main.clientList;
		setLayout(null);
		
		JLabel lblClients = new JLabel("CLIENTS");
		lblClients.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClients.setBounds(28, 10, 122, 37);
		add(lblClients);
		
		clientList = new JList();
		clientList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
//				Main.setClientViewText(((Client)clientList.getSelectedValue()).toString2());
				Client cl = (Client)clientList.getSelectedValue();
				JFrame clientViewFrame = new JFrame(cl.getFullName());
				clientViewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				clientViewFrame.setPreferredSize(new Dimension(600,550));//TODO pass dimension from main
				clientViewFrame.getContentPane().add(new ClientView(cl));
				clientViewFrame.pack();
				clientViewFrame.setVisible(true);
			}
		});
		clientList.setBounds(0, 0, 100, 100);
		clientList.setLayoutOrientation(JList.VERTICAL);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(404, 165, 454, 309);
		scrollPane.add(clientList);
		add(scrollPane);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		searchPanel.setBounds(161, 25, 544, 86);
		add(searchPanel);
		
		JLabel lblEnterSearchKey = new JLabel("Enter Search Key:");
		searchPanel.add(lblEnterSearchKey);
		lblEnterSearchKey.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		clientSearch = new JTextField();
		searchPanel.add(clientSearch);
		clientSearch.setColumns(10);
		//clientList.setVisibleRowCount(4);
		
		JButton searchBtn = new JButton("Search by Client Name");
		searchPanel.add(searchBtn);
		
		JButton button = new JButton("Search by Client ID");
		searchPanel.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String txt = clientSearch.getText();
				if (txt.length() == 0) {
					loadClients(Main.clientList);
				} else {
					loadClients(searchByClientID(txt));
				}
			}
		});
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String txt = clientSearch.getText();
				if (txt.length() == 0) {
					loadClients(Main.clientList);
				} else {
					loadClients(searchByClientName(txt));
				}
			}
		});
		
		loadClients(Main.clientList);
	}


	public static void loadClients(ArrayList<Client> list) {
		DefaultListModel dlm = new DefaultListModel();
		for (Client c: list) {
			dlm.addElement(c);
		}
		clientList.setModel(dlm);
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
	
	public static ArrayList<Client> searchByClientID(String key){
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
			if (((cl.getFname()+ " "+cl.getLname()).toLowerCase()).contains(key.toLowerCase())) {
				searchResults.add(cl);
			}
		}
		
		return searchResults;	
	}
}
