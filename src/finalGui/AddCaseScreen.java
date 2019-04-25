package finalGui;

import javax.swing.JPanel;

import backend.Case;
import backend.types.CaseType;
import backend.Client;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;

import finalGui.eventListeners.AddCaseListener;
import finalGui.eventListeners.AddCaseEvent;

public class AddCaseScreen extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<Client> clientList = new JList<Client>();
	private JList<CaseType> caseTypeLst = new JList<CaseType>();
	private DefaultListModel<Client> clientListModel = new DefaultListModel<Client>();
	private DefaultListModel<CaseType> caseTypeModel = new DefaultListModel<CaseType>();
	
	private AddCaseListener listener;

	public AddCaseScreen(ArrayList<Client> clients) {
		setLayout(null);
		
		for (Client c: clients) {
			clientListModel.addElement(c);
		}
		clientList.setModel(clientListModel);
		
		for(CaseType ct: CaseType.values()) {
			caseTypeModel.addElement(ct);
		}
		caseTypeLst.setModel(caseTypeModel);
		
		JButton btnAddCase = new JButton("Add Case");
		btnAddCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Client cl = (Client)clientList.getSelectedValue();
				CaseType type = (CaseType)caseTypeLst.getSelectedValue();
				
				AddCaseEvent ace = new AddCaseEvent(this, cl, type);
				if (listener != null) {
					listener.addCaseRequested(ace);
				}
				
				//TODO set the model for the case type and clients 
			}
		});
		btnAddCase.setBounds(55, 268, 112, 45);
		add(btnAddCase);
		
		caseTypeLst.setBounds(55, 83, 93, 139);
		add(caseTypeLst);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(243, 85, 144, 139);
		add(scrollPane);
		
		clientList.setBounds(265, 83, 93, 139);
//		clientList.setModel(clientListModel);
		scrollPane.add(clientList);
		
		JLabel lblSelectACase = new JLabel("Select a case Type:");
		lblSelectACase.setBounds(55, 52, 112, 13);
		add(lblSelectACase);
		
		JLabel lblSelectAClient = new JLabel("Select A Client:");
		lblSelectAClient.setBounds(265, 52, 93, 13);
		add(lblSelectAClient);
		
		JLabel lblAddCase = new JLabel("Add Case");
		lblAddCase.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddCase.setBounds(30, 22, 99, 22);
		add(lblAddCase);

	}
	
	public void setClientListModel(ArrayList<Client> cases) {
		this.clientListModel.removeAllElements();
		for (Client c: cases) {
			this.clientListModel.addElement(c);
		}
	}
	
	public void setAddCaseListener(AddCaseListener listener) {
		this.listener = listener;
	}
}
