package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import backend.Address;
import backend.Client;
import backend.FileManager;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddClientScreen extends JPanel {
	private JTextField lnameField;
	private JTextField fnameField;
	private JTextField mobileField;
	private JTextField homeField;
	private JTextField workField;
	private JTextField emailField;
	private JTextField adrTypeField;
	private JTextField adrLine1Field;
	private JTextField adrCountryField;
	private String lname;
	private String clientId;
	private String fname;
	private String homePhone;
	private String mobilePhone;
	private String workPhone;
	private String email;
	private String occupation;
	private ArrayList<Address> addresses;
	private JTextField occField;

	/**
	 * Create the panel.
	 */
	public AddClientScreen() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(26, 40, 207, 123);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name:");
		lblNewLabel.setBounds(10, 24, 66, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name:");
		lblNewLabel_1.setBounds(10, 55, 66, 13);
		panel.add(lblNewLabel_1);
		
		lnameField = new JTextField();
		lnameField.setBounds(86, 52, 96, 19);
		panel.add(lnameField);
		lnameField.setColumns(10);
		
		fnameField = new JTextField();
		fnameField.setBounds(86, 21, 96, 19);
		panel.add(fnameField);
		fnameField.setColumns(10);
		
		JLabel lblOccupation = new JLabel("Occupation:");
		lblOccupation.setBounds(10, 84, 66, 13);
		panel.add(lblOccupation);
		
		occField = new JTextField();
		occField.setColumns(10);
		occField.setBounds(86, 81, 96, 19);
		panel.add(occField);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Contact", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(389, 125, 192, 151);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Mobile:");
		lblNewLabel_4.setBounds(10, 28, 45, 13);
		panel_1.add(lblNewLabel_4);
		
		mobileField = new JTextField();
		mobileField.setBounds(86, 25, 96, 19);
		panel_1.add(mobileField);
		mobileField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Home:");
		lblNewLabel_5.setBounds(10, 57, 45, 13);
		panel_1.add(lblNewLabel_5);
		
		homeField = new JTextField();
		homeField.setBounds(86, 54, 96, 19);
		panel_1.add(homeField);
		homeField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Work");
		lblNewLabel_6.setBounds(10, 86, 45, 13);
		panel_1.add(lblNewLabel_6);
		
		workField = new JTextField();
		workField.setBounds(86, 83, 96, 19);
		panel_1.add(workField);
		workField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Email:");
		lblNewLabel_7.setBounds(10, 117, 45, 13);
		panel_1.add(lblNewLabel_7);
		
		emailField = new JTextField();
		emailField.setBounds(86, 117, 96, 19);
		panel_1.add(emailField);
		emailField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Addresses", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(26, 206, 207, 169);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Type:");
		lblNewLabel_8.setBounds(10, 28, 45, 13);
		panel_2.add(lblNewLabel_8);
		
		adrTypeField = new JTextField();
		adrTypeField.setBounds(75, 25, 96, 19);
		panel_2.add(adrTypeField);
		adrTypeField.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Line 1:");
		lblNewLabel_9.setBounds(10, 63, 45, 13);
		panel_2.add(lblNewLabel_9);
		
		adrLine1Field = new JTextField();
		adrLine1Field.setBounds(75, 60, 96, 19);
		panel_2.add(adrLine1Field);
		adrLine1Field.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Country:");
		lblNewLabel_10.setBounds(10, 91, 45, 13);
		panel_2.add(lblNewLabel_10);
		
		adrCountryField = new JTextField();
		adrCountryField.setBounds(75, 89, 96, 19);
		panel_2.add(adrCountryField);
		adrCountryField.setColumns(10);
		
		JButton btnAddAnother = new JButton("Add another");
		btnAddAnother.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		btnAddAnother.setBounds(75, 138, 103, 21);
		panel_2.add(btnAddAnother);
		
		JButton btnCreateClient = new JButton("Create Client");
		btnCreateClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (1 == 2 ) {
					
				}
				else {
					lname = lnameField.getText();
					fname=fnameField.getText();
					homePhone=homeField.getText();
					mobilePhone=mobileField.getText();
					workPhone=workField.getText();
					email=emailField.getText();
					occupation=occField.getText();
					Main.clientList.add(new Client(lname, fname, homePhone, mobilePhone, workPhone, email, occupation, addresses));
					FileManager.saveData(Main.caseList, Main.clientList); //TODO have this process done when the software is closed
					ClientsScreen.loadClients(Main.clientList);
				}
			}
		});
		btnCreateClient.setBounds(422, 334, 132, 37);
		add(btnCreateClient);
	}
	
	private boolean emptyFields() {
		
		return true;
	}
}
