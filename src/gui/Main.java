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
	
	private JFrame mainFrame; 
//	private Container mainPane;
	private JPanel window;
	
	public Main () {
		init();
		mainFrame = new JFrame("Johnson & Downer Client and Case Management System");
		mainFrame.setPreferredSize((new Dimension(800, 500)));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		creating the tabbed pane
		JTabbedPane tabbedMain = new JTabbedPane();
		tabbedMain.addTab("Clients",new searchScreen());
		tabbedMain.addTab("Cases", new CasesScreen());
		tabbedMain.addTab("Client View", clientViewTab);
		//tabbedMain.addTab("Cases",new caseGui();
		
//		window = new searchScreen(clientList);
//		mainFrame.getContentPane().add(window);
		mainFrame.getContentPane().add(tabbedMain);
		
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	private void init() {
		clientList.add(new Client("Nathan", "Downer"));
		clientList.add(new Client("Kayon-Marie", "Douglas"));
		clientList.add(new Client("Nathaniel", "Chirstie"));
		clientList.add(new Client("Hugh", "Billings"));
		clientList.add(new Client("Rajheem","O'Connor"));
		clientList.add(new Client("Akili", "Sterling"));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
	}
	
	public static void setClientViewText(String text) {
		clientViewTab.setTxtPane(text);
	}

}
