package finalGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import backend.Address;
import backend.Phone;
import backend.types.PhoneNumType;
import finalGui.eventListeners.AddClientEvent;
import finalGui.eventListeners.AddClientListener;
import javax.swing.SwingConstants;

public class AddClient extends JPanel {
	private ArrayList<Address> addresses = new ArrayList<>();
	private ArrayList<Phone> phones = new ArrayList<>();
	private JTextField fnameField;
	private JTextField lnameField;
	private JTextField emailField;
	private JTextField occupationField;
	private JTextField phoneNumberField;
	private JTextField line1Field;
	private JTextField line2Field;
	private JTextField countryField;
	
	private ButtonGroup phoneGroup = new ButtonGroup();
	private JComboBox<String> addressTypeCombo;

	private AddClientListener listener;
	
	public AddClient() {
		System.out.println("Loaded Add Client Screen");
		setPreferredSize(new Dimension(900, 600));
		setLayout(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 0, 900, 51);
		titlePanel.setBorder(new EmptyBorder(8, 8, 8, 8));
		FlowLayout flowLayout = (FlowLayout) titlePanel.getLayout();
		flowLayout.setHgap(30);
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(titlePanel);
		
		JLabel lblAddClient = DefaultComponentFactory.getInstance().createTitle("Add Client");
		lblAddClient.setFont(new Font("Tahoma", Font.BOLD, 20));
		titlePanel.add(lblAddClient);
		
		JPanel phoneDetailsPanel = new JPanel();
		phoneDetailsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		phoneDetailsPanel.setBounds(106, 279, 269, 213);
		add(phoneDetailsPanel);
		phoneDetailsPanel.setLayout(null);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number(s)");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPhoneNumber.setBounds(10, 10, 179, 32);
		phoneDetailsPanel.add(lblPhoneNumber);
		
		JLabel lblNumber = new JLabel("Number:");
		lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumber.setBounds(28, 117, 90, 19);
		phoneDetailsPanel.add(lblNumber);
		
		phoneNumberField = new JTextField();
		phoneNumberField.setColumns(10);
		phoneNumberField.setBounds(115, 109, 142, 27);
		phoneDetailsPanel.add(phoneNumberField);
		
		
		JRadioButton rdbtnCell = new JRadioButton("Cell");
		rdbtnCell.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnCell.setBounds(26, 63, 57, 21);
		rdbtnCell.setSelected(true);
		rdbtnCell.setActionCommand("Cell");
		phoneDetailsPanel.add(rdbtnCell);
		
		JRadioButton rdbtnWork = new JRadioButton("Work");
		rdbtnWork.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnWork.setBounds(99, 63, 81, 21);
		rdbtnWork.setActionCommand("work");
		phoneDetailsPanel.add(rdbtnWork);
		
		JRadioButton rdbtnHome = new JRadioButton("Home");
		rdbtnHome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnHome.setBounds(182, 63, 81, 21);
		rdbtnHome.setActionCommand("home");
		phoneDetailsPanel.add(rdbtnHome);
		
		
		phoneGroup.add(rdbtnCell);
		phoneGroup.add(rdbtnWork);
		phoneGroup.add(rdbtnHome);
		
		JButton btnAddAnother = new JButton("Add");
		btnAddAnother.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPhoneNumber();
//				rdbtnCell.setSelected(true);
			
				
			}
		});
		btnAddAnother.setBounds(154, 171, 103, 32);
		phoneDetailsPanel.add(btnAddAnother);
		
		JCheckBox phoneCheckBox = new JCheckBox("Add Multiple");
		phoneCheckBox.setBounds(28, 182, 93, 21);
		phoneDetailsPanel.add(phoneCheckBox);
		
		JLabel label_1 = new JLabel("Click add after each address");
		label_1.setBounds(38, 148, 185, 13);
		phoneDetailsPanel.add(label_1);
		
		JPanel addressDetailsPanel = new JPanel();
		addressDetailsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		addressDetailsPanel.setBounds(449, 61, 296, 313);
		add(addressDetailsPanel);
		addressDetailsPanel.setLayout(null);
		
		JLabel lblAddresss = new JLabel("Address(s)");
		lblAddresss.setBounds(10, 10, 99, 22);
		lblAddresss.setFont(new Font("Tahoma", Font.BOLD, 18));
		addressDetailsPanel.add(lblAddresss);
		
		line1Field = new JTextField();
		line1Field.setColumns(10);
		line1Field.setBounds(131, 59, 142, 27);
		addressDetailsPanel.add(line1Field);
		
		JLabel lblLine = new JLabel("Line 1:");
		lblLine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLine.setBounds(31, 65, 90, 19);
		addressDetailsPanel.add(lblLine);
		
		line2Field = new JTextField();
		line2Field.setColumns(10);
		line2Field.setBounds(131, 104, 142, 27);
		addressDetailsPanel.add(line2Field);
		
		JLabel lblLine_1 = new JLabel("Line 2:");
		lblLine_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLine_1.setBounds(31, 110, 90, 19);
		addressDetailsPanel.add(lblLine_1);
		
		countryField = new JTextField();
		countryField.setColumns(10);
		countryField.setBounds(131, 152, 142, 27);
		addressDetailsPanel.add(countryField);
		
		JLabel lblCountry = new JLabel("Country:");
		lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCountry.setBounds(31, 158, 90, 19);
		addressDetailsPanel.add(lblCountry);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblType.setBounds(31, 203, 90, 19);
		addressDetailsPanel.add(lblType);
		
		addressTypeCombo = new JComboBox<String>();
		addressTypeCombo.setBounds(131, 201, 142, 27);
		addressDetailsPanel.add(addressTypeCombo);
		
		DefaultComboBoxModel<String> addressModel = new DefaultComboBoxModel<String>();
		addressModel.addElement("Home");
		addressModel.addElement("Work");
		addressTypeCombo.setModel(addressModel);
		addressTypeCombo.setSelectedIndex(0);
		
		JCheckBox addressCheckBox = new JCheckBox("Add Multiple");
		addressCheckBox.setBounds(28, 269, 93, 21);
		addressDetailsPanel.add(addressCheckBox);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAddress();
				//reset the fields
				line1Field.setText("");
				line2Field.setText("");
				countryField.setText("");
			}
		});
		btnAdd.setBounds(131, 268, 128, 22);
		addressDetailsPanel.add(btnAdd);
		
		JLabel lblClickAddAfter = new JLabel("Click add after each address");
		lblClickAddAfter.setBounds(44, 244, 185, 13);
		addressDetailsPanel.add(lblClickAddAfter);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(106, 61, 269, 186);
		add(panel);
		panel.setLayout(null);
		
		fnameField = new JTextField();
		fnameField.setBounds(110, 10, 142, 27);
		panel.add(fnameField);
		fnameField.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(10, 16, 90, 19);
		panel.add(lblFirstName);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(10, 55, 90, 19);
		panel.add(lblLastName);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lnameField = new JTextField();
		lnameField.setBounds(110, 48, 142, 27);
		panel.add(lnameField);
		lnameField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(110, 86, 142, 27);
		panel.add(emailField);
		emailField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 93, 90, 19);
		panel.add(lblEmail);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		occupationField = new JTextField();
		occupationField.setBounds(110, 123, 142, 27);
		panel.add(occupationField);
		occupationField.setColumns(10);
		
		JLabel lblOccupation = new JLabel("Occupation:");
		lblOccupation.setBounds(10, 130, 90, 19);
		panel.add(lblOccupation);
		lblOccupation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(449, 384, 296, 51);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Case Type:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(10, 19, 90, 19);
		panel_1.add(label);
		
		JComboBox caseTypeCombo = new JComboBox();
		caseTypeCombo.setBounds(110, 10, 142, 27);
		panel_1.add(caseTypeCombo);
		
		DefaultComboBoxModel<String> caseTypeModel = new DefaultComboBoxModel<>();
		caseTypeModel.addElement("Conveyancing");
		caseTypeModel.addElement("Admin and Estate");
		caseTypeModel.addElement("Commercial");
		caseTypeModel.addElement("Divorce");
		caseTypeModel.addElement("Misc");
		
		caseTypeCombo.setModel(caseTypeModel);
		caseTypeCombo.setSelectedIndex(0);

		
		
		JButton btnAddClient = new JButton("Add Client");
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname = fnameField.getText();
				String lname = lnameField.getText();
				String email = emailField.getText();
				String occupation = occupationField.getText();
				String caseType = (String)caseTypeCombo.getSelectedItem();
				
				//check if there is text in teh address field 
				String address = line1Field.getText();
				if (address != null && address.length() > 1) {
					addAddress();
				}
				//Check if there is still text in the phone field
				String phone = phoneNumberField.getText();
				if(phone != null && phone.length() > 1)
					addPhoneNumber();
				
				fnameField.setText(null);
				lnameField.setText(null);
				emailField.setText(null);
				occupationField.setText(null);
				line1Field.setText("");
				line2Field.setText("");
				countryField.setText("");
				phoneNumberField.setText("");
				
				phones.clear();
				addresses.clear();

				//TODO add a combobox for id
				
				AddClientEvent ace= new AddClientEvent(this, fname, lname, email, occupation, addresses, phones, caseType);
				
				if (listener != null) {
					listener.addClientRequested(ace);
				}
			}
		});
		btnAddClient.setBounds(449, 458, 154, 34);
		add(btnAddClient);
		
		JButton btnClearAll = new JButton("Clear All");
		btnClearAll.setBackground(Color.RED);
		btnClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//clear the arrayLists
				phones.clear();
				addresses.clear();
				
				//clear the fields
				fnameField.setText(null);
				lnameField.setText(null);
				emailField.setText(null);
				occupationField.setText(null);
				
				line1Field.setText("");
				line2Field.setText("");
				countryField.setText("");
				phoneNumberField.setText("");
			}
		});
		btnClearAll.setBounds(607, 458, 138, 34);
		add(btnClearAll);
		
		
		
		
	}
	
	private void addPhoneNumber() {
		String number = phoneNumberField.getText();
		String typeStr  = phoneGroup.getSelection().getActionCommand();
		
		PhoneNumType type = PhoneNumType.strToType(typeStr) ;
		phones.add(new Phone(type, number));
		
		phoneNumberField.setText("");
//		rdbtnCell.setSelected(true);
	}
	
	private void addAddress() {
		String line1 = line1Field.getText(); 
		String line2 = line2Field.getText();
		String country = countryField.getText();
		String type = (String) addressTypeCombo.getSelectedItem();
		addresses.add(new Address(type,line1, line2, country));
		
		line1Field.setText("");
		line2Field.setText("");
		countryField.setText("");
	}

	public void setAddClientListener(AddClientListener listener) {
		this.listener = listener;
	}
}
