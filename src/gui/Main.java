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
//	private static ClientView clientViewTab = new ClientView();
//	private CaseView caseViewTab = new CaseView();
	public static JTabbedPane tabbedMain = new JTabbedPane(JTabbedPane.LEFT);
//	private CasesScreen caseScreenTab = new CasesScreen();
	
	
	private JFrame mainFrame; 
//	private Container mainPane;
	private JPanel window;
	private static FileManager fManage = new FileManager();
	
	public Main () {
		
		if(!fManage.loadData())
			init();
		else {
			caseList = fManage.getCases();
			clientList = fManage.getClients();
		}
		mainFrame = new JFrame("Johnson & Downer Client and Case Management System");
		mainFrame.setPreferredSize((new Dimension(800, 500)));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		 creating the tabbed pane
//		tabbedMain = new JTabbedPane(JTabbedPane.LEFT);
		tabbedMain.addTab("Clients",new ClientsScreen());
		tabbedMain.addTab("Cases", new CasesScreen());
//		tabbedMain.addTab("Case View", caseViewTab);
//		tabbedMain.addTab("Client View", clientViewTab);
		tabbedMain.addTab("Add Client", new AddClientScreen());
		tabbedMain.addTab("Add Case", new AddCaseScreen());
		
//		window = new searchScreen(clientList);
//		mainFrame.getContentPane().add(window);
		mainFrame.getContentPane().add(tabbedMain);
		
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	public static void updateFile() {
		FileManager.saveData(caseList, clientList); //TODO have this process done when the software is closed
	}
	
	private void init() {
		ArrayList<String[]> tData = new ArrayList<String[]>();
		//                       cl0       ,cl1      ,cl2             ,cl3           ,cl4               ,cl5
		tData.add(new String[] {"Nathan", "Downer", "Conveyancing","Surveyer's Fee", "15000.00", "sterlingakili@gmail.com"});
		tData.add(new String[] {"Kayon-Marie", "Douglas", "Divorce","Process Server's Fee", "13500.00", "sterlingakili@gmail.com"});
		tData.add(new String[] {"Nathaniel", "Chirstie", "Admin and Estate","Will Probation", "7500.00", "sterlingakili@gmail.com"});
		tData.add(new String[] {"Hugh", "Billings", "Conveyancing","Lost Title Application", "9500", "sterlingakili@gmail.com"});
		tData.add(new String[] {"Rajheem","O'Connor", "Misc", "Deedpoll Submission Fee (Rush)", "9000", "sterlingakili@gmail.com"});
		tData.add(new String[] {"Akili", "Sterling", "Misc", "Consultancy Charge", "5500", "sterlingakili@gmail.com"});
		
		
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
			c = new Client(cl[0],cl[1], cl[5]);
			cse = new Case(c, CaseType.strToType(cl[2]));
			cse.addCost(new Cost(cl[3],Double.parseDouble(cl[4])));
			caseList.add(cse);
			c.addCase(cse);
			clientList.add(c);
			//TODO add 3 costs to each case
		}
		
	}
	
//	public static void addTab(String type,String tabTitle, Object o ) {
//		switch (type) {
//		case "case":
//			tabbedMain.addTab(tabTitle, new CaseView((Case)o));
//		}
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
	}
	
//	public static void setClientViewText(String text) {
//		clientViewTab.setTxtPane(text);
//	}
	
//	public static void setCaseViewText(String text) {
//		caseViewTab.setTxtPane(text);
//	}
	

}
