package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import backend.*;

public class Main{
	public static ArrayList<Client> clientList = new ArrayList<Client>();
	public static ArrayList<Case> caseList = new ArrayList<Case>(); 
	private static ClientView clientViewTab = new ClientView();
	private static CaseView caseViewTab = new CaseView();
	
	private JFrame mainFrame; 
//	private Container mainPane;
	private JPanel window;
	JTabbedPane tabbedMain;
	
	public Main () {
		init();
		mainFrame = new JFrame("Johnson & Downer Client and Case Management System");
		mainFrame.setPreferredSize((new Dimension(800, 500)));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		 creating the tabbed pane
		tabbedMain = new JTabbedPane();
		tabbedMain.addTab("Clients",new ClientsScreen());
		tabbedMain.addTab("Cases", new CasesScreen());
		tabbedMain.addTab("Case View", caseViewTab);
		tabbedMain.addTab("Client View", clientViewTab);
		tabbedMain.addTab("Add Client", new AddClientScreen());
		tabbedMain.addTab("Add Case", new AddCaseScreen());
		//tabbedMain.addTab("Cases",new caseGui();
		
//		window = new searchScreen(clientList);
//		mainFrame.getContentPane().add(window);
		mainFrame.getContentPane().add(tabbedMain);
		
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	private void init() {
		ArrayList<String[]> tData = new ArrayList<String[]>();
		tData.add(new String[] {"Nathan", "Downer", "Conveyancing"});
		tData.add(new String[] {"Kayon-Marie", "Douglas", "Divorce"});
		tData.add(new String[] {"Nathaniel", "Chirstie", "Admin and Estate"});
		tData.add(new String[] {"Hugh", "Billings", "Conveyancing"});
		tData.add(new String[] {"Rajheem","O'Connor", "Misc"});
		tData.add(new String[] {"Akili", "Sterling", "Misc"});
		
		
//		clientList.add(new Client("Nathan", "Downer",CaseType.Conveyancing));
//		clientList.add(new Client("Kayon-Marie", "Douglas", CaseType.Divorce));
//		clientList.add(new Client("Nathaniel", "Chirstie", CaseType.AdministrationAndEstate));
//		clientList.add(new Client("Hugh", "Billings", CaseType.Conveyancing));
//		clientList.add(new Client("Rajheem","O'Connor", CaseType.Misc));
//		clientList.add(new Client("Akili", "Sterling", CaseType.Misc));
		
		Client c;
		String[] cl;
		Case cse;
		for (int i=0; i<tData.size(); i++) {
			cl = tData.get(i);
			c = new Client(cl[0],cl[1]);
			cse = new Case(c, CaseType.strToType(cl[2]));
			caseList.add(cse);
			c.addCase(cse);
			clientList.add(c);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
	}
	
	public static void setClientViewText(String text) {
		clientViewTab.setTxtPane(text);
	}
	
	public static void setCaseViewText(String text) {
		caseViewTab.setTxtPane(text);
	}
	
//	public static void setTextView(String view, String text) {
//		switch(view) {
//		case "client":
//			clientViewTab.setTxtPane(text);
//			break;
//		case "case":
//			caseViewTab.setTxtPane(text);
//			break;
//		}
//	}

}
