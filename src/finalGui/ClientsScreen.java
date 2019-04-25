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
import finalGui.eventListeners.AddCaseListener;
import finalGui.eventListeners.AddCaseEvent;

import backend.*;

public class ClientsScreen extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JTextField searchTxtField;
	private static JList<Client> clientList = new JList<Client>();
	private DefaultListModel<Client> clientListModel = new DefaultListModel<Client>();
	
	private SearchListener listener;
	private AddCaseListener addClientListener;
	

	public ClientsScreen(ArrayList<Client> clients) {
		setLayout(null);
		
		for (Client c: clients) {
			clientListModel.addElement(c);
		}
		clientList.setModel(clientListModel);
		
		JLabel lblClients = new JLabel("Clients");
		lblClients.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClients.setBounds(28, 10, 122, 37);
		add(lblClients);
		
		clientList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
//				Main.setCaseViewText(((Case)caseList.getSelectedValue()).toString2());
//				Main.tabbedMain.addTab(o.getClient().getFullName(), new CaseView(o));
			}
		});
		clientList.setBounds(0, 0, 100, 100);
		clientList.setLayoutOrientation(JList.VERTICAL);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(404, 165, 454, 350);
		scrollPane.add(clientList);
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
		
		JButton btnGoToCase = new JButton("Go to Client");
		btnGoToCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Client cl = (Client)clientList.getSelectedValue();
				JFrame clientViewFrame = new JFrame(cl.getFullName());
				clientViewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				clientViewFrame.setPreferredSize(GuiController.popupDim);//TODO pass dimension from main
				ClientView cv = new ClientView(cl);
				cv.setAddCaseListener(new AddCaseListener() {
					public void addCaseRequested(AddCaseEvent e) {
						if (addClientListener != null)
							addClientListener.addCaseRequested(e);
					}
				});
				clientViewFrame.getContentPane().add(cv);
				clientViewFrame.pack();
				clientViewFrame.setVisible(true);
			}
		});
		btnGoToCase.setBounds(228, 165, 122, 42);
		add(btnGoToCase);
	}
	
	public void setListModel(ArrayList<Client> cases) {
		//TODO check if it works
		this.clientListModel.removeAllElements();
		for (Client c: cases) {
			this.clientListModel.addElement(c);
		}
	}
	
	public void setAddCasetListener(AddCaseListener listener) {
		this.addClientListener = listener;
	}
	
	public void setSearchListener(SearchListener listener) {
		this.listener = listener;
	}

}
