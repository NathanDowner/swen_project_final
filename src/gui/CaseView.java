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
import javax.swing.JFrame;

import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import java.awt.Dimension;
import java.awt.FlowLayout;

public class CaseView extends JPanel {
	private JTextField caseSearch;
	private static JTextPane txtpnCaseData = new JTextPane();
	private Case myCase;
	

	/**
	 * Create the panel.
	 */
//	public CaseView(Case c) {
//		CaseView();
//		this.myCase = c;
//	}
	public CaseView(Case c) {
		
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
		
		JList clientHeadings = new JList();
		clientHeadings.setBounds(540, 70, 122, 181);
		clientHeadings.setLayoutOrientation(JList.VERTICAL);
		add(clientHeadings);
		
		JPanel optionsPanel = new JPanel();
		optionsPanel.setBorder(new TitledBorder(null, "Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		optionsPanel.setBounds(464, 295, 227, 82);
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
		optionsPanel.add(btnEditCase);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.tabbedMain.remove(Main.tabbedMain.getTabCount() -1);
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		optionsPanel.add(btnClose);
		
//		ScrollPane scrollPane = new ScrollPane();
//		scrollPane.setBounds(404, 165, 454, 309);
//		scrollPane.add(clientHeadings);
//		add(scrollPane);
		this.myCase = c;
		setTxtPane(c.toString2());
	}
	
	
	
	public static void setTxtPane(String text) {
		txtpnCaseData.setText(text);
	}
}
