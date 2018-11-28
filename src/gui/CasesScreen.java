package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import backend.*;

public class CasesScreen extends JPanel {

	/**
	 * Create the panel.
	 */
	private ArrayList<Case> cases;
	private JTextField searchTxtField;
	private JList caseList;
	private String clientName;
	private String caseID;
	

	/**
	 * Create the panel.
	 */
	public CasesScreen() {
		this.cases = Main.caseList;
		setLayout(null);
		
		JLabel lblClients = new JLabel("CASES");
		lblClients.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClients.setBounds(28, 10, 122, 37);
		add(lblClients);
		
		caseList = new JList();
		caseList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
//				Main.setCaseViewText(((Case)caseList.getSelectedValue()).toString2());
				Case o = (Case)caseList.getSelectedValue();
				
				JFrame clientViewFrame = new JFrame(o.getCaseTitle());
				clientViewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				clientViewFrame.setPreferredSize(new Dimension(600,550));
				clientViewFrame.getContentPane().add(new CaseView(o));
				clientViewFrame.pack();
				clientViewFrame.setVisible(true);
				
				
				
				
				
				
//				Main.tabbedMain.addTab(o.getClient().getFullName(), new CaseView(o));
			}
		});
		caseList.setBounds(0, 0, 100, 100);
		caseList.setLayoutOrientation(JList.VERTICAL);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(404, 165, 454, 309);
		scrollPane.add(caseList);
		add(scrollPane);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		searchPanel.setBounds(161, 25, 544, 86);
		add(searchPanel);
		
		JLabel searchKey = new JLabel("Enter Search Key:");
		searchPanel.add(searchKey);
		searchKey.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		searchTxtField = new JTextField();
		searchPanel.add(searchTxtField);
		searchTxtField.setColumns(10);
		//clientList.setVisibleRowCount(4);
		
		JButton clientSearchBtn = new JButton("Search by CLIENT NAME");
		searchPanel.add(clientSearchBtn);
		
		JButton caseSearchBtn = new JButton("Search by CASE ID");
		searchPanel.add(caseSearchBtn);
		caseSearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		clientSearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadCases(searchByClientName(searchTxtField.getText()));
			}
		});
		
		loadCases(Main.caseList);
	}


	private void loadCases(ArrayList<Case> list) {
		DefaultListModel dlm = new DefaultListModel();
		for (Case c: list) {
			dlm.addElement(c);
		}
		this.caseList.setModel(dlm);
	}
	



	public String getClientName() {
		return clientName;
	}


	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	public String getCaseID() {
		return caseID;
	}


	public void setCaseID(String clientID) {
		this.caseID = clientID;
	}
	
	public static ArrayList<Case> searchForCaseByID(String key){
		ArrayList<Case> searchResults = new ArrayList<Case>();
		for (Case c: Main.caseList) {
			if (c.getCaseId().contains(key)) {
				searchResults.add(c);
			}
		}
		return searchResults;
	}
	
	public static ArrayList<Case> searchByClientName(String key){
		ArrayList<Case> searchResults = new ArrayList<Case>();
		for (Client cl: Main.clientList) {
			if ((cl.getFname()+ " "+cl.getLname()).contains(key)) {
				searchResults.addAll(cl.getCases());
			}
		}
		
		return searchResults;	
	}

}
