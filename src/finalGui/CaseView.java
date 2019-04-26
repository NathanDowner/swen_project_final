package finalGui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import backend.*;
import backend.types.CaseStatus;

import javax.swing.JTextField;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import Email.TLSEmail;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class CaseView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextPane txtpnCaseData = new JTextPane();//TODO remove static
	JPanel editsPanel;
	private Case myCase;
	public String path = ".\\src\\Files\\"; 
	//TODO make path varaible to pass to docPane for folders for each case
	
	private User user;
	

	/**
	 * Create the panel.
	 */

	public CaseView(Case c) {
		this.myCase = c;
		
		System.out.println("using the real case view");
		this.setPreferredSize(GuiController.dim);
		setLayout(null);
		//TODO add close btn on case to remove the -1 index of the tab pane
		JLabel lblClients = new JLabel("CASE VIEW");
		lblClients.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClients.setBounds(28, 10, 122, 37);
		add(lblClients);
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
				if (editsPanel.isVisible()) {
					editsPanel.setVisible(false);					
				} else {
					editsPanel.setVisible(true);
				}
			}
		});
		optionsPanel.add(btnEditCase);
		
//		ScrollPane scrollPane = new ScrollPane();
//		scrollPane.setBounds(404, 165, 454, 309);
//		scrollPane.add(clientHeadings);
//		add(scrollPane);
		
		
		editsPanel = new JPanel();
		editsPanel.setVisible(false);
		editsPanel.setBorder(new TitledBorder(null, "Available Edits", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		editsPanel.setBounds(464, 70, 134, 215);
		add(editsPanel);
		editsPanel.setLayout(null);
		
		JButton btnCaseStatus = new JButton("Case Status");
		btnCaseStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String newProg = promptUser("Has the case been closed? Yes or no.");
				//TODO get nathaniel or Akili to do a try catch for when the user clicks cancel
				switch (newProg.toLowerCase()) {
					case "yes":
						myCase.setStatus(CaseStatus.Closed);
						break;
					case "no":
						myCase.setStatus(CaseStatus.Open);
						break;
					default:
						myCase.setStatus(CaseStatus.Open);
				}
				refresh("Status successfully updated.");
			}
		});
		btnCaseStatus.setBounds(6, 26, 122, 21);
		editsPanel.add(btnCaseStatus);
		
		JButton btnAddAction = new JButton("Add Action"); //replaces the old status
		
		btnAddAction.setBounds(6, 57, 122, 21);
		editsPanel.add(btnAddAction);
		btnAddAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String newAction = promptUser("Enter the Action completed on the case.");
				//TODO change this option to update the change the last action
				//TODO fix exception when user cancels pop up instead of providing a response
				if (newAction != null && newAction.length() > 1) {
//					String body = String.format("Dear %s,\ n\n\t\tThere has been an update in the status of your case. It is as follows:\n", myCase.getClient().getFullName());
//					body += String.format("Previous action carried out: %s\n", myCase.getLastAction());
//					myCase.setLastAction(newAction);
//					refresh("Action successfully added.");
//					body += String.format("Action just carried out: %s\n", myCase.getLastAction());
//					new TLSEmail(myCase.getClient().getEmail(), "Case Status Update", body);
					String lastAction = myCase.getLastAction();
					myCase.setLastAction(newAction);
					new TLSEmail().sendUpdateEmail(myCase.getClient(), lastAction, newAction);
				}
				
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
				String dName = JOptionPane.showInputDialog("Enter the name of the file");
				DocPane dp = new DocPane(dName);
				JFrame docFrame = new JFrame("New Document "+ dName);
				File f = new File(path+dName+".txt");
				docFrame.setPreferredSize(GuiController.popupDim);
				docFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				System.out.println("before adding");
				docFrame.getContentPane().add(dp);
				System.out.println("after adding");
				docFrame.pack();
				docFrame.setVisible(true);
				myCase.addFile(f);
				refresh("");
				
//				while()
//				while(true) {
//					System.out.println("in the loop");
//					if (dp.isFileCreated()) {
//						System.out.println("in the if");
//						myCase.addFile(DocPane.fileName);
//						System.out.println("file created");
//						break;
//					} else {
//						System.out.println("in the else");
//					}
//				}
//				refresh("File Successfully Added to Client");
					
//				myCase.addFile(f);
			}
		});
		btnAddFile.setBounds(6, 150, 122, 21);
		editsPanel.add(btnAddFile);
		setTxtPane(c.toString2());
	}
	
	private void refresh(String popUpTxt) {
		editsPanel.setVisible(false);
//		Main.updateFile();
		setTxtPane(myCase.toString2());
		if (popUpTxt.length() != 0) {
			JOptionPane.showMessageDialog(this, popUpTxt);
		}
	}
	
	public void setUser(User u) {
		this.user = u;
	}
	
	private String promptUser(String question) {
		return JOptionPane.showInputDialog(question);
	}
	
	public void setTxtPane(String text) {
		txtpnCaseData.setText(text);
	}
}
