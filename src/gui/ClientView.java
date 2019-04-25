package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.GridLayout;

import backend.*;
import backend.types.AddressType;
import backend.types.CaseType;

import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;

public class ClientView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextPane txtpnClientData = new JTextPane();
	private Client myClient;
	private JPanel editsPanel;
	

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
		
		this.myClient = c;
		
		editsPanel = new JPanel();
		editsPanel.setVisible(false);
		editsPanel.setBorder(new TitledBorder(null, "Available Edits", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		editsPanel.setBounds(540, 70, 129, 207);
		add(editsPanel);
		editsPanel.setLayout(null);
		
		JButton btnEmail = new JButton("Email");
		btnEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myClient.setEmail(promptUser("Enter updated email address"));
				refresh("Email Successfully Updated");
			}
		});
		btnEmail.setBounds(10, 23, 109, 21);
		editsPanel.add(btnEmail);
		
		JButton btnHomePhone = new JButton("Home Phone");
		btnHomePhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myClient.setHomePhone(promptUser("Enter updated home phone number."));
				refresh("Home phone number successfully updated");
			}
		});
		btnHomePhone.setBounds(10, 54, 109, 21);
		editsPanel.add(btnHomePhone);
		
		JButton btnMobilePhone = new JButton("Mobile Phone");
		btnMobilePhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO update this so they can select the number to edit
				myClient.setMobilePhone(promptUser("Enter updated mobile phone number."));
				refresh("Mobile  Phone Number successfully updated");
			}
		});
		btnMobilePhone.setBounds(10, 85, 109, 21);
		editsPanel.add(btnMobilePhone);
		
		JButton btnOccupation = new JButton("Occupation");
		btnOccupation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myClient.setOccupation(promptUser("Enter updated occupation."));
				refresh("Occupation successfully updated");
			}
		});
		btnOccupation.setBounds(10, 116, 109, 21);
		editsPanel.add(btnOccupation);
		
		JButton btnAddCase = new JButton("Add Case");
		btnAddCase.setBounds(10, 147, 109, 21);
		editsPanel.add(btnAddCase);
		
		JButton btnAddAddress = new JButton("Add Address");
		btnAddAddress.setBounds(10, 178, 109, 21);
		editsPanel.add(btnAddAddress);
		btnAddAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel addrPrompt = new JPanel();
				addrPrompt.setLayout(new GridLayout(3,3));
				
				JLabel l1 = new JLabel("Address Type:");
				JTextField addrType = new JTextField();
				JLabel l2 = new JLabel("Line 1:");
				JTextField line1 = new JTextField();
				JLabel l3 = new JLabel("Country:");
				JTextField country = new JTextField();
				
				
				addrPrompt.add(l1);
				addrPrompt.add(addrType);
				addrPrompt.add(l2);
				addrPrompt.add(line1);
				addrPrompt.add(l3);
				addrPrompt.add(country);
				int result = JOptionPane.showConfirmDialog(null,addrPrompt, 
						"Enter address info.", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					System.out.println("1\n");
					System.out.println(line1.getText()+"\n");
					System.out.println("2");
					AddressType a = AddressType.strToType(addrType.getText());
					String b = line1.getText();
					String c = country.getText();
					myClient.addAddress(new Address(a,b,c));
					System.out.println("Got here");
					refresh("Address Successfully added");
				}
			}
		});
		
		btnAddCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO add JFrame for new case and set the client and case lists again
				JPanel casePanel = new JPanel();
				casePanel.setLayout(new GridLayout(2,1));
				JLabel l1 = new JLabel("Select a case Type");
				
				JList<CaseType> caseTypeLst = new JList<CaseType>();
				caseTypeLst.setBounds(55, 75, 112, 147);
				DefaultListModel<CaseType> dlm = new DefaultListModel<CaseType>();
				for(CaseType ct: CaseType.values()) {
					dlm.addElement(ct);
				}
				caseTypeLst.setModel(dlm);
				casePanel.add(l1);
				casePanel.add(caseTypeLst);
				int result = JOptionPane.showConfirmDialog(null, casePanel,
						"Select a case type.", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					Case c = new Case(myClient,(CaseType)caseTypeLst.getSelectedValue());
					myClient.addCase(c);
					Main.caseList.add(c);
					CasesScreen.loadCases(Main.caseList);
					refresh("Case was successfully added");
				}
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(540, 395, 181, 84);
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnEditClient = new JButton("Edit Client");
		btnEditClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editsPanel.setVisible(!editsPanel.isVisible());
			}
		});
		panel_1.add(btnEditClient);
		setTxtPane(c.toString2());
	}
	
	private void refresh(String popUpTxt) {
		setTxtPane(myClient.toString2());
		editsPanel.setVisible(false);
		Main.updateFile();
		JOptionPane.showMessageDialog(this, popUpTxt);
	}
	
	private String promptUser(String question) {
		return JOptionPane.showInputDialog(question);
	}
	
	public static void setTxtPane(String text) {
		txtpnClientData.setText(text);
	}
}
