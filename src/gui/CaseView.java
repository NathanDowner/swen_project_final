package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import backend.*;

import javax.swing.JTextField;

import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import Email.TLSEmail;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class CaseView extends JPanel {
	private JTextField caseSearch;
	private static JTextPane txtpnCaseData = new JTextPane();//TODO remove static
	JPanel editsPanel;
	private Case myCase;
	

	/**
	 * Create the panel.
	 */
//	public CaseView(Case c) {
//		CaseView();
//		this.myCase = c;
//	}
	public CaseView(Case c) {
		this.setPreferredSize(Main.dim);
		setLayout(null);
		//TODO add close btn on case to remove the -1 index of the tab pane
		JLabel lblClients = new JLabel("CASE VIEW");
		lblClients.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClients.setBounds(28, 10, 122, 37);
		add(lblClients);
		
		caseSearch = new JTextField();
		caseSearch.setBounds(743, 280, 96, 19);
		add(caseSearch);
		caseSearch.setColumns(10);
		txtpnCaseData.setEditable(false);
		
		txtpnCaseData.setBounds(28, 70, 396, 307);
		add(txtpnCaseData);
		
		JPanel optionsPanel = new JPanel();
		optionsPanel.setBorder(new TitledBorder(null, "Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		optionsPanel.setBounds(464, 295, 134, 82);
		add(optionsPanel);
		optionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnGenerateReport = new JButton("Generate report");
		btnGenerateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame stmtFrame = new JFrame("Statement of Accounts for "+ myCase.getClient().getFullName());
				stmtFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				stmtFrame.setPreferredSize(new Dimension(600,550));
				stmtFrame.getContentPane().add(new StatOfAccScreen(myCase.getCaseCostsStr(),myCase.getCostToDate()));
				stmtFrame.pack();
				stmtFrame.setVisible(true);
			}
		});
		optionsPanel.add(btnGenerateReport);
		
		JButton btnEditCase = new JButton("Edit Case");
		btnEditCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editsPanel.setVisible(true);
			}
		});
		optionsPanel.add(btnEditCase);
		
//		ScrollPane scrollPane = new ScrollPane();
//		scrollPane.setBounds(404, 165, 454, 309);
//		scrollPane.add(clientHeadings);
//		add(scrollPane);
		this.myCase = c;
		
		editsPanel = new JPanel();
		editsPanel.setVisible(false);
		editsPanel.setBorder(new TitledBorder(null, "Available Edits", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		editsPanel.setBounds(464, 70, 134, 215);
		add(editsPanel);
		editsPanel.setLayout(null);
		
		JButton btnInProgress = new JButton("In Progress");
		btnInProgress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String newProg = promptUser("Has the case been closed? Yes or no.");
				//TODO get nathaniel or Akili to do a try catch for when the user clicks cancel
				switch (newProg.toLowerCase()) {
					case "yes":
						myCase.setInProgress(false);
						break;
					case "no":
						myCase.setInProgress(true);
						break;
					default:
						myCase.setInProgress(myCase.isInProgress());
				}
				refresh("Progress successfully updated.");
			}
		});
		btnInProgress.setBounds(6, 26, 122, 21);
		editsPanel.add(btnInProgress);
		
		JButton btnUpdateStatus = new JButton("Update Status");
		
		btnUpdateStatus.setBounds(6, 57, 122, 21);
		editsPanel.add(btnUpdateStatus);
		btnUpdateStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String newStat = promptUser("Enter the new case status.");
				//TODO fix exception when user cancels pop up instead of providing a response
				String body = String.format("Dear %s,\n\t\tThere has been an update in the status of your case. It is as follows:\n", myCase.getClient().getFullName());
				body += String.format("Previous status: %s\n", myCase.getStatus());
				myCase.setStatus(newStat);
				refresh("Status successfully updated.");
				body += String.format("Current status: %s\n", myCase.getStatus());
				new TLSEmail(myCase.getClient().getEmail(), "Case Status Update", body);
				
			}
		});
		
		JButton btnAddContact = new JButton("Add Contact");
		btnAddContact.setBounds(6, 88, 122, 21);
		editsPanel.add(btnAddContact);
		//TODO add popup for collecting contact info
		JButton btnAddCost = new JButton("Add Cost");
		btnAddCost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel costPrompt = new JPanel();
				costPrompt.setLayout(new GridLayout(2,2));
				
				JLabel l1 = new JLabel("Cost Name:");
				JTextField cName = new JTextField();
				JLabel l2 = new JLabel("Cost Amount:");
				JTextField cCost = new JTextField();
				
				costPrompt.add(l1);
				costPrompt.add(cName);
				costPrompt.add(l2);
				costPrompt.add(cCost);
				int result = JOptionPane.showConfirmDialog(null,costPrompt, 
						"Enter the cost data to be added.", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					myCase.addCost(new Cost(cName.getText(),Double.parseDouble(cCost.getText())));
					refresh("Cost Successfully added");
				}
//			
			}
		});
		btnAddCost.setBounds(6, 119, 122, 21);
		editsPanel.add(btnAddCost);
		
		JButton btnAddFile = new JButton("Add File");
		btnAddFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnAddFile.setBounds(6, 150, 122, 21);
		editsPanel.add(btnAddFile);
		setTxtPane(c.toString2());
		
	}
	
	private void refresh(String popUpTxt) {
		setTxtPane(myCase.toString2());
		editsPanel.setVisible(false);
		Main.updateFile();
		JOptionPane.showMessageDialog(this, popUpTxt);
	}
	
	private String promptUser(String question) {
		return JOptionPane.showInputDialog(question);
	}
	
	
	public static void setTxtPane(String text) {
		txtpnCaseData.setText(text);
	}
}
