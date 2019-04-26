package finalGui;

import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import backend.User;

import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.Dimension;

import finalGui.eventListeners.LoginListener;
import finalGui.eventListeners.LoginEvent;


public class LoginScreen extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel loginInstructions;
	private JPasswordField passwordField;
	private JTextField usernameField;
	private JPanel headerPanel;
	private JPanel photoPanel;
	private LoginListener loginListener;

	
	public LoginScreen() {
		setPreferredSize(new Dimension(900, 600));
		initialize(); 
	}
	
	public void setMessage(String text) {
		loginInstructions.setText(text);
	}
	
	public void setLoginListener (LoginListener listener) {
		this.loginListener = listener;
	}	

	private void initialize() {
		this.setLayout(null);
		this.setBounds(100, 100, 1200, 800);
		
		JLabel usernameLabel = new JLabel("Enter Username:");
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(699, 369, 168, 72);
		this.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Enter Password:");
		passwordLabel.setToolTipText("");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(715, 509, 152, 33);
		this.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(924, 507, 187, 28);

		this.add(passwordField);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		usernameField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameField.setBounds(924, 387, 187, 28);
		add(usernameField);
		
		loginInstructions = new JLabel("Kindly enter your login details below,");
		loginInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		loginInstructions.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		loginInstructions.setBounds(729, 257, 496, 89);
		add(loginInstructions);
		
		headerPanel = new JPanel();
		headerPanel.setBackground(new Color(255, 228, 196));
		headerPanel.setBounds(0, 0, 1200, 180);
		add(headerPanel);
		headerPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to the Johnson and Downer Client and Case System");
		lblNewLabel.setBounds(291, 78, 617, 26);
		headerPanel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Sitka Small", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		photoPanel = new JPanel();
		photoPanel.setBackground(new Color(255, 255, 255));
		photoPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, new Color(245, 245, 220)));
		photoPanel.setBounds(0, 179, 705, 622);
		add(photoPanel);
		photoPanel.setLayout(null);
		
		JButton loginButton = new JButton("Login");
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());
				
				LoginEvent login = new LoginEvent(this, username, password);
				if (loginListener != null) {
					loginListener.loginSubmitted(login);
				}
				usernameField.setText("");
				passwordField.setText("");
				
			}
		});
		loginButton.setBounds(924, 602, 110, 33);
		add(loginButton);
	}

}