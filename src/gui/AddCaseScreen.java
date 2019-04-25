package gui;

import javax.swing.JPanel;

import backend.Case;
import backend.types.CaseType;
import backend.Client;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

public class AddCaseScreen extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JList<Client> clientList = new JList<Client>();
	JList<CaseType> caseTypeLst = new JList<CaseType>();
	/**
	 * Create the panel.
	 */
	public AddCaseScreen() {
		setLayout(null);
		
		JButton btnAddCase = new JButton("Add Case");
		btnAddCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Client cl = (Client)clientList.getSelectedValue();
				Case c = new Case(cl, (CaseType)caseTypeLst.getSelectedValue());
				cl.addCase(c);
				Main.caseList.add(c);
				Main.updateFile();
				CasesScreen.loadCases(Main.caseList);
				JOptionPane.showMessageDialog(null, "Case Successfully Added");
			}
		});
		btnAddCase.setBounds(55, 268, 112, 45);
		add(btnAddCase);
		
		caseTypeLst.setBounds(55, 75, 112, 147);
		add(caseTypeLst);
		
		DefaultListModel<CaseType> dlm = new DefaultListModel<CaseType>();
		for(CaseType ct: CaseType.values()) {
			dlm.addElement(ct);
		}
		caseTypeLst.setModel(dlm);
		
		clientList.setBounds(265, 75, 93, 147);
		add(clientList);
		
		DefaultListModel<Client> deflm  = new DefaultListModel<Client>();
		for (Client c: Main.clientList) {
			deflm.addElement(c);
		}
		clientList.setModel(deflm);
		
		JLabel lblSelectACase = new JLabel("Select a case Type:");
		lblSelectACase.setBounds(55, 52, 112, 13);
		add(lblSelectACase);
		
		JLabel lblSelectAClient = new JLabel("Select A Client:");
		lblSelectAClient.setBounds(265, 52, 93, 13);
		add(lblSelectAClient);

	}
	
	public static void resetClientList() {
		DefaultListModel<Client> deflm  = new DefaultListModel<Client>();
		for (Client c: Main.clientList) {
			deflm.addElement(c);
		}
		clientList.setModel(deflm);
	}

}
