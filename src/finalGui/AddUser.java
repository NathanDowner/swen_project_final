package finalGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import backend.Address;
import backend.Phone;
import backend.types.UserType;
import finalGui.eventListeners.AddUserEvent;
import finalGui.eventListeners.AddUserListener;

public class AddUser extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Address> addresses = new ArrayList<>();
	private ArrayList<Phone> phones = new ArrayList<>();
	private JTextField fnameField;
	private JTextField lnameField;
	private JTextField usernameField;
	private JTextField passwordField;

	private AddUserListener listener;
	
	public AddUser() {
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
		
		JLabel lblAddClient = DefaultComponentFactory.getInstance().createTitle("Add User");
		lblAddClient.setFont(new Font("Tahoma", Font.BOLD, 20));
		titlePanel.add(lblAddClient);
				
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(192, 187, 514, 215);
		add(panel);
		panel.setLayout(null);
		
		fnameField = new JTextField();
		fnameField.setBounds(231, 21, 142, 27);
		panel.add(fnameField);
		fnameField.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(131, 27, 90, 19);
		panel.add(lblFirstName);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(131, 66, 90, 19);
		panel.add(lblLastName);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lnameField = new JTextField();
		lnameField.setBounds(231, 59, 142, 27);
		panel.add(lnameField);
		lnameField.setColumns(10);
		
		usernameField = new JTextField();
		usernameField.setBounds(231, 97, 142, 27);
		panel.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(131, 104, 90, 19);
		panel.add(lblUsername);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		passwordField = new JTextField();
		passwordField.setBounds(231, 134, 142, 27);
		panel.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(131, 141, 90, 19);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblUserType = new JLabel("User Type:");
		lblUserType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUserType.setBounds(131, 178, 90, 19);
		panel.add(lblUserType);
		
		JComboBox<UserType> userTypeCombo = new JComboBox<>();
		userTypeCombo.setBounds(231, 171, 142, 29);
		panel.add(userTypeCombo);
		
		DefaultComboBoxModel<UserType> userTypeModel = new DefaultComboBoxModel<>();
//		userTypeModel.addElement("Regular Employee");
//		userTypeModel.addElement("Lawyer");
//		userTypeModel.addElement("Admin");
		for (UserType ut: UserType.values()) {
			userTypeModel.addElement(ut);
		}
		
		userTypeCombo.setModel(userTypeModel);
		userTypeCombo.setSelectedIndex(0);

		JButton btnAddClient = new JButton("Create User");
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname = fnameField.getText();
				String lname = lnameField.getText();
				String username = usernameField.getText();
				String password = passwordField.getText();
				UserType userType = (UserType)userTypeCombo.getSelectedItem();
				
				AddUserEvent aue= new AddUserEvent(this, fname, lname, username, password, userType);
				
				if (listener != null) {
					listener.addUserRequested(aue);
				}
				
				fnameField.setText("");
				lnameField.setText("");
				usernameField.setText("");
				passwordField.setText("");
				JOptionPane.showMessageDialog(AddUser.this, "Successfully created new user!");
			}
		});
		btnAddClient.setBounds(377, 412, 154, 34);
		add(btnAddClient);
		
	}

	public void setAddUserListener(AddUserListener addUserListener) {
		this.listener = addUserListener;
	}
}
