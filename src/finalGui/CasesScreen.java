package finalGui;

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

import finalGui.eventListeners.SearchListener;

import backend.*;

public class CasesScreen extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	private JTextField searchTxtField;
	private static JList<Case> caseList = new JList<Case>();
	private DefaultListModel<Case> caseListModel = new DefaultListModel<Case>();
	
	private SearchListener listener;
	

	/**
	 * Create the panel.
	 */
	public CasesScreen(ArrayList<Case> cases) {
		setLayout(null);
		
		for (Case c: cases) {
			caseListModel.addElement(c);
		}
		caseList.setModel(caseListModel);
		
		JLabel lblClients = new JLabel("CASES");
		lblClients.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClients.setBounds(28, 10, 122, 37);
		add(lblClients);
		
//		caseList.addListSelectionListener(new ListSelectionListener() {
//			public void valueChanged(ListSelectionEvent arg0) {
////				Main.setCaseViewText(((Case)caseList.getSelectedValue()).toString2());
////				Main.tabbedMain.addTab(o.getClient().getFullName(), new CaseView(o));
//			}
//		});
		caseList.setBounds(0, 0, 100, 100);
		caseList.setLayoutOrientation(JList.VERTICAL);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(404, 165, 454, 350);
		scrollPane.add(caseList);
		add(scrollPane);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		searchPanel.setBounds(161, 25, 544, 86);
		add(searchPanel);
		searchPanel.setLayout(null);
		
		JLabel searchKey = new JLabel("Enter Search Key:");
		searchKey.setBounds(123, 32, 127, 20);
		searchPanel.add(searchKey);
		searchKey.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		searchTxtField = new JTextField();
		searchTxtField.setBounds(255, 33, 96, 19);
		searchPanel.add(searchTxtField);
		searchTxtField.setColumns(10);
		//clientList.setVisibleRowCount(4);
		
		JButton searchBtn = new JButton("Search");
		searchBtn.setBounds(356, 32, 65, 21);
		searchPanel.add(searchBtn);
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton)e.getSource();
				listener.searchTermEmitted(searchTxtField.getText());
			}
			
		});
		
		JButton btnGoToCase = new JButton("Go to Case");
		btnGoToCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Case o = (Case)caseList.getSelectedValue();
				//TODO figure out why its opening two slides;
				JFrame caseViewFrame = new JFrame(o.getCaseTitle());
				caseViewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				caseViewFrame.setPreferredSize(GuiController.popupDim);
				caseViewFrame.getContentPane().add(new CaseView(o));
				caseViewFrame.pack();
				caseViewFrame.setVisible(true);
			}
		});
		btnGoToCase.setBounds(228, 165, 122, 42);
		add(btnGoToCase);
	}
	
	public void setListModel(ArrayList<Case> cases) {
		//TODO check if it works
		this.caseListModel.removeAllElements();
		for (Case c: cases) {
			this.caseListModel.addElement(c);
		}
	}
	
	public void setSearchListener(SearchListener listener) {
		this.listener = listener;
	}

}
