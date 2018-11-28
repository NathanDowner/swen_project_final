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
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;

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
		txtpnCaseData.setEditable(false);
		
		txtpnCaseData.setBounds(28, 70, 396, 307);
		add(txtpnCaseData);
		
		JList clientHeadings = new JList();
		clientHeadings.setBounds(540, 70, 122, 181);
		clientHeadings.setLayoutOrientation(JList.VERTICAL);
		add(clientHeadings);
		
		JPanel optionsPanel = new JPanel();
		optionsPanel.setBorder(new TitledBorder(null, "Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		optionsPanel.setBounds(464, 295, 227, 82);
		add(optionsPanel);
		optionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAddCase = new JButton("Add Case");
		optionsPanel.add(btnAddCase);
		
		JButton btnGenerateReport = new JButton("Generate report");
		btnGenerateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Jframe stmtFrame = new JFrame("Statement of Accounts for")
			}
		});
		optionsPanel.add(btnGenerateReport);
		
//		ScrollPane scrollPane = new ScrollPane();
//		scrollPane.setBounds(404, 165, 454, 309);
//		scrollPane.add(clientHeadings);
//		add(scrollPane);
	}
	
	public static void setTxtPane(String text) {
		txtpnCaseData.setText(text);
	}
}
