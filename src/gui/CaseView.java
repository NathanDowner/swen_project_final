package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import backend.*;

import javax.swing.JTextField;

import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class CaseView extends JPanel {
	private JTextField caseSearch;
	private static JTextPane txtpnCaseData = new JTextPane();
	

	/**
	 * Create the panel.
	 */
	public CaseView() {
		setLayout(null);
		
		JLabel lblClients = new JLabel("CASE VIEW");
		lblClients.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClients.setBounds(28, 10, 122, 37);
		add(lblClients);
		
		caseSearch = new JTextField();
		caseSearch.setBounds(743, 280, 96, 19);
		add(caseSearch);
		caseSearch.setColumns(10);
		
		JLabel lblEnterData = new JLabel("Enter Data:");
		lblEnterData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterData.setBounds(602, 279, 82, 20);
		add(lblEnterData);
		txtpnCaseData.setEditable(false);
		
		txtpnCaseData.setBounds(28, 70, 487, 409);
		add(txtpnCaseData);
		
		JList clientHeadings = new JList();
		clientHeadings.setBounds(540, 70, 122, 181);
		clientHeadings.setLayoutOrientation(JList.VERTICAL);
		add(clientHeadings);
		
		JButton btnAddCase = new JButton("Add Case");
		btnAddCase.setBounds(540, 362, 85, 21);
		add(btnAddCase);
		
//		ScrollPane scrollPane = new ScrollPane();
//		scrollPane.setBounds(404, 165, 454, 309);
//		scrollPane.add(clientHeadings);
//		add(scrollPane);
	}
	
	public static void setTxtPane(String text) {
		txtpnCaseData.setText(text);
	}
}
