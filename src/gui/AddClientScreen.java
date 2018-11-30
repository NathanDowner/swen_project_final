package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.regex.*;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import backend.Address;
import backend.AddressType;
import backend.Client;
import backend.FileManager;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class AddClientScreen extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField lnameField;
	private JTextField fnameField;
	private JTextField mobileField;
	private JTextField homeField;
	private JTextField workField;
	private JTextField emailField;
	private JTextField adrTypeField;
	private JTextField adrLine1Field;
	private JTextField adrCountryField;
	private boolean valid = true;
	private String lname;
	private String fname;
	private String homePhone;
	private String mobilePhone;
	private String workPhone;
	private String email;
	private String occupation;
//	private ArrayList<Address> addresses;
	private Address address;
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
		lnameField.addKeyListener(new Validate() {
			public void keyPressed(KeyEvent e) {
				isText(lnameField);
			}
		});
		panel.add(lnameField);
		lnameField.setColumns(10);
		
		fnameField = new JTextField();
		fnameField.setBounds(86, 21, 96, 19);
		fnameField.addKeyListener(new Validate() {
			public void keyPressed(KeyEvent e) {
				isText(fnameField);
			}
		});
		panel.add(fnameField);
		fnameField.setColumns(10);
		
		JLabel lblOccupation = new JLabel("Occupation:");
		lblOccupation.setBounds(10, 84, 66, 13);
		panel.add(lblOccupation);
		
		occField = new JTextField();
		occField.setColumns(10);
		occField.setBounds(86, 81, 96, 19);
		occField.addKeyListener(new Validate() {
			public void keyPressed(KeyEvent e) {
				isText(occField);
			}
		});
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
		mobileField.addKeyListener(new Validate() {
			public void keyPressed(KeyEvent e) {
				isNum(mobileField);
			}
		});
		panel_1.add(mobileField);
		mobileField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Home:");
		lblNewLabel_5.setBounds(10, 57, 45, 13);
		panel_1.add(lblNewLabel_5);
		
		homeField = new JTextField();
		homeField.setBounds(86, 54, 96, 19);
		homeField.addKeyListener(new Validate() {
			public void keyPressed(KeyEvent e) {
				isNum(homeField);
			}
		});
		panel_1.add(homeField);
		homeField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Work");
		lblNewLabel_6.setBounds(10, 86, 45, 13);
		panel_1.add(lblNewLabel_6);
		
		workField = new JTextField();
		workField.setBounds(86, 83, 96, 19);
		workField.addKeyListener(new Validate() {
			public void keyPressed(KeyEvent e) {
				isNum(workField);
			}
		});
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
		adrTypeField.addKeyListener(new Validate() {
			public void keyPressed(KeyEvent e) {
				isText(adrTypeField);
			}
		});
		panel_2.add(adrTypeField);
		adrTypeField.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Line 1:");
		lblNewLabel_9.setBounds(10, 63, 45, 13);
		panel_2.add(lblNewLabel_9);
		
		adrLine1Field = new JTextField();
		adrLine1Field.setBounds(75, 60, 96, 19);
		adrLine1Field.addKeyListener(new Validate() {
			public void keyPressed(KeyEvent e) {
				isText(adrLine1Field);
			}
		});
		panel_2.add(adrLine1Field);
		adrLine1Field.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Country:");
		lblNewLabel_10.setBounds(10, 91, 55, 13);
		panel_2.add(lblNewLabel_10);
		
		adrCountryField = new JTextField();
		adrCountryField.setBounds(75, 89, 96, 19);
		adrCountryField.addKeyListener(new Validate() {
			public void keyPressed(KeyEvent e) {
				isText(adrCountryField);
			}
		});
		panel_2.add(adrCountryField);
		adrCountryField.setColumns(10);
		
		JButton btnCreateClient = new JButton("Create Client");
		btnCreateClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (!valid) {
					JOptionPane.showMessageDialog(null, "Ensure the data was entered correctly.");
				}
				else {
					lname = lnameField.getText();
					fname=fnameField.getText();
					homePhone=homeField.getText();
					mobilePhone=mobileField.getText();
					workPhone=workField.getText();
					email=emailField.getText();
					occupation=occField.getText();
					
					AddressType adrT = AddressType.strToType(adrTypeField.getText());
					String line1 = adrLine1Field.getText();
					String country = adrCountryField.getText();
					
					address = new Address(adrT,line1,country);
					ArrayList<Address> addresses = new ArrayList<Address>();
					addresses.add(address);
					
					Main.clientList.add(new Client(lname, fname, homePhone, mobilePhone, workPhone, email, occupation, addresses));
					JOptionPane.showMessageDialog(null, "Client successfully created.");
					clearFields();
					Main.updateFile();
					ClientsScreen.loadClients(Main.clientList);
					AddCaseScreen.resetClientList();
				}
			}
		});
		btnCreateClient.setBounds(422, 334, 132, 37);
		add(btnCreateClient);
	}
	
	private void clearFields() {
		lnameField.setText("");
		fnameField.setText("");
		homeField.setText("");
		mobileField.setText("");
		workField.setText("");
		emailField.setText("");
		occField.setText("");
	}
	
	public class Validate implements KeyListener{
		protected void isText(JTextField tf) {
			String l_text = tf.getText().trim();
			String[] input = l_text.split("");
			String r = "t";
			for(String n: input) {
				if(!Pattern.matches("[a-zA-Z]\\s", n)) {
					tf.setBorder(new LineBorder(Color.red,1));
					valid = false;
					r = n;
				}
				if(Pattern.matches("[a-zA-Z]", r)){
					tf.setBorder(new LineBorder(Color.green,1));
					valid = true;
				}
			}
		}
		
		protected void isNum(JTextField nf) {
			String n_text = nf.getText().trim();
			String[] input = n_text.split("");
			String r = "t";
			for(String n: input) {
				if(Pattern.matches("[0-9]", n)) {
					nf.setBorder(new LineBorder(Color.green,1));
					valid = true;
					r = n;
				}
				if(!Pattern.matches("[0-9]", r)){
					nf.setBorder(new LineBorder(Color.red,1));
					valid = false;
				}
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
