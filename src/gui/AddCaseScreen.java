package gui;

import javax.swing.JPanel;

import backend.CaseType;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class AddCaseScreen extends JPanel {

	/**
	 * Create the panel.
	 */
	public AddCaseScreen() {
		setLayout(null);
		
		JButton btnAddCase = new JButton("Add Case");
		btnAddCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddCase.setBounds(93, 263, 85, 21);
		add(btnAddCase);
		
		JList caseTypeLst = new JList();
		caseTypeLst.setBounds(52, 46, 112, 147);
		add(caseTypeLst);
		
		DefaultListModel dlm = new DefaultListModel();
		for(CaseType ct: CaseType.values()) {
			dlm.addElement(ct.getCaseType());
		}
		caseTypeLst.setModel(dlm);

	}

}
