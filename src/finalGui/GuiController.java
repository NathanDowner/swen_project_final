package finalGui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import backend.Address;
import backend.Case;
import backend.Client;
import backend.Cost;
import backend.DocumentGenerator;
import backend.FileManager;
import backend.Logger;
import backend.Phone;
import backend.User;
import backend.types.CaseType;
import backend.types.UserType;

import finalGui.eventListeners.SearchListener;
import finalGui.eventListeners.AddCaseListener;
import finalGui.eventListeners.AddCaseEvent;
import finalGui.eventListeners.AddClientEvent;
import finalGui.eventListeners.AddClientListener;
import finalGui.eventListeners.AddUserEvent;
import finalGui.eventListeners.AddUserListener;
import finalGui.eventListeners.LoginListener;
import finalGui.eventListeners.LogoutListener;
import finalGui.eventListeners.LoginEvent;
import java.io.IOException;
import java.util.logging.Level;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class GuiController extends JFrame {

	private static final long serialVersionUID = 1L;
	private ArrayList<Client> clientList = new ArrayList<Client>();
	private ArrayList<Case> caseList = new ArrayList<Case>(); 
	private ArrayList<User> userList = new ArrayList<>();
	private User currentUser;
	private Container contentPane= getContentPane();
	
	public static Dimension dim = new Dimension(900, 600);
	public static Dimension popupDim = new Dimension(800, 600);
	
	///// Screens /////
	private LoginScreen loginScreen;
	private UserOptions userOptionsScreen;
	private JTabbedPane tabbedScreen;
	private JPanel clientsScreen, addCaseScreen, casesScreen;
	private JPanel addClientScreen, addUserScreen;
	
	public GuiController() {
		super("Johnson & Downer Client and Case Manager");
		
		init();
	
		loginScreen = new LoginScreen();
		loginScreen.setLoginListener(new LoginListener() {
			public void loginSubmitted(LoginEvent e) {
				User temp = new User(e.getUsername(), e.getPassword());
				boolean found = findUser(temp);
				if (found) {
					System.out.println("logged in");
					openMainPanel();
				} else {
					loginScreen.setMessage("Incorrect Username or Password");					
				}
			}
			
		});
		
		contentPane.add(loginScreen);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent event) {
	        	updateFile();
	            dispose();
	            System.exit(0);
	        }
	    });
		setLocationRelativeTo(null);
		this.setBounds(100, 100, 1200, 800);
		setVisible(true);
	}
	
	public void updateFile() {
		FileManager.saveData(caseList, clientList); //TODO have this process done when the software is closed
		System.out.println("exiting");
	}
	
	public void logout() {
		contentPane.remove(tabbedScreen);
		this.setVisible(false);
		contentPane.add(loginScreen);
		this.validate();
		this.pack();
		this.setVisible(true);
	}
	
	public void openMainPanel() {
		contentPane.remove(loginScreen);
		this.setVisible(false);
		
		Logger lg = Logger.getInstance();
		
		addCaseScreen = new AddCaseScreen(this.clientList);
		((AddCaseScreen)addCaseScreen).setAddCaseListener(new AddCaseListener() {
			public void addCaseRequested(AddCaseEvent e) {
				Client c = e.getClient();
				CaseType ct = e.getCaseType();
				Case cse = createCase(c, ct);
				c.addCase(cse);
				caseList.add(cse);
				
				lg.recordActivity(getCurrentUser(), String.format("Case %s was added to Client %s ", cse.getCaseId(), c.getClientId()));
				((CasesScreen)casesScreen).setListModel(caseList);
				JOptionPane.showMessageDialog(null, "Case Successfully Added");
			}
		});
		
		clientsScreen = new ClientsScreen(this.clientList);
		((ClientsScreen)clientsScreen).setSearchListener(new SearchListener() {
			public void searchTermEmitted(String text) {
				((ClientsScreen)clientsScreen).setListModel(searchForClients(text));
			}
		});
		
		addClientScreen = new AddClient();
		((AddClient)addClientScreen).setAddClientListener(new AddClientListener() {
			public void addClientRequested(AddClientEvent e) {
				String fname = e.getFname();
				String lname = e.getLname();
				String email = e.getEmail();
				String occupation = e.getOccupation();
				ArrayList<Address> addresses = e.getAddresses();
				ArrayList<Phone> phones = e.getPhones();
				String caseType = e.getCaseType();
				
				Client c = createClient(fname, lname, email, occupation, addresses, phones);
				Case cse = createCase(c, CaseType.strToType(caseType));
				c.addCase(cse);
				clientList.add(c);
				caseList.add(cse);
				
				lg.recordActivity(getCurrentUser(), String.format("Created client %s and attached case %s", c.getClientId(), cse.getCaseId()));
				
				((ClientsScreen)clientsScreen).setListModel(clientList);
				((CasesScreen)casesScreen).setListModel(caseList);
				((AddCaseScreen)addCaseScreen).setClientListModel(clientList);
				JOptionPane.showMessageDialog(addClientScreen, "Client successfully added");
			}
			
		});
		
		//Catches the event from the case view popup
		//TODO create a new pane for the case view so the add case listener doesn't have to go through the clients screen
		((ClientsScreen)clientsScreen).setAddCasetListener(new AddCaseListener() {
			public void addCaseRequested(AddCaseEvent e) {
				Client c = e.getClient();
				CaseType type = e.getCaseType();
				Case cse = createCase(c, type);
				c.addCase(cse);
				caseList.add(cse);
				lg.recordActivity(getCurrentUser(), String.format("Case %s was added to Client %s ", cse.getCaseId(), c.getClientId()));
				((CasesScreen)casesScreen).setListModel(caseList);
			}
		});
		
		userOptionsScreen = new UserOptions();
		userOptionsScreen.setLogoutListener(new LogoutListener() {
			public void logoutRequested() {
				logout();
			}
			
		});
		
		casesScreen = new CasesScreen(this.caseList);
		((CasesScreen)casesScreen).setSearchListener(new SearchListener() {
			public void searchTermEmitted(String text) {
				((CasesScreen)casesScreen).setListModel(searchForCases(text));
			}
		});
		
		tabbedScreen = new JTabbedPane(JTabbedPane.TOP);
		tabbedScreen.addTab("View Cases", casesScreen);
		tabbedScreen.addTab("View Clients", clientsScreen);
		tabbedScreen.addTab("Add Client", addClientScreen);
		tabbedScreen.addTab("Add Case", addCaseScreen);
		
		
		if (this.currentUser.getType() == UserType.Admin) {
			addUserScreen = new AddUser();
			((AddUser)addUserScreen).setAddUserListener(new AddUserListener() {
				public void addUserRequested(AddUserEvent e) {
					String fname = e.getFname();
					String lname = e.getLname();
					String username = e.getUsername();
					String password = e.getPassword();
					UserType type = e.getCaseType();
					
					User u = createUser(fname, lname, username, password, type);
					userList.add(u);
					lg.recordActivity(getCurrentUser(), String.format("User %s was created", u.getUsername()));
				}
				
			});
			
			tabbedScreen.addTab("Add User", addUserScreen);
		}
		tabbedScreen.addTab("User Options", userOptionsScreen);
		contentPane.add(tabbedScreen);
		this.pack();
		this.setVisible(true);
	}
	
	public ArrayList<Case> searchForCases(String key) {
		ArrayList<Case> results = new ArrayList<>();
		if (key == "" || key == null)
			return caseList;
		for (Case cs: caseList) {
			if (cs.getCaseId().toLowerCase().contains(key.toLowerCase()) || cs.getClient().getNameForSearch().toLowerCase().contains(key.toLowerCase())) {
				results.add(cs);
			}
		}
		return results;		
	}
	
	public ArrayList<Client> searchForClients(String key) {
		ArrayList<Client> results = new ArrayList<>();
		if (key == "" || key == null)
			return clientList;
		for (Client c: clientList) {
			if (c.getNameForSearch().toLowerCase().contains(key) || c.getClientId().contains(key)) {
				results.add(c);
			}
		}
		return results;
	}
	
	public Case createCase(Client client, CaseType type) {
		return new Case(client, type);
	}
	
	public Client createClient(String fname, String lname,
			String email, String occupation, ArrayList<Address> addresses,
			ArrayList<Phone> phones) {
		return new Client(fname, lname, email, occupation, addresses, phones);
	}
	
	public User createUser(String fname, String lname, String username, String password, UserType type) {
		return new User(fname, lname, username, password, type);
	}
	
	public boolean findUser(User temp) {
		for (User u: userList) {
			if (temp.compareTo(u) == 0) {
				currentUser = u;
				setTitle("Johnson & Downer Client and Case Manager - " + currentUser);
				return true;
			}
		}
		return false;
	}
	
	public User getCurrentUser() {
		return this.currentUser;
	}
	
	private void init() {
		
		userList.add(new User("Nathan", "Downer", "admin", "0000", UserType.Admin));
		userList.add(new User("Stephanie", "Downer", "stephanie", "0000", UserType.Lawyer));
		ArrayList<String[]> tData = new ArrayList<String[]>();
		//                       cl0       ,cl1      ,cl2             ,cl3           ,cl4               ,cl5
		tData.add(new String[] {"Nathan", "Downer", "Conveyancing","Surveyer's Fee", "15000.00", "sterlingakili@gmail.com"});
		tData.add(new String[] {"Kayon-Marie", "Douglas", "Divorce","Process Server's Fee", "13500.00", "sterlingakili@gmail.com"});
		tData.add(new String[] {"Nathaniel", "Chirstie", "Admin and Estate","Will Probation", "7500.00", "sterlingakili@gmail.com"});
		tData.add(new String[] {"Hugh", "Billings", "Conveyancing","Lost Title Application", "9500", "sterlingakili@gmail.com"});
		tData.add(new String[] {"Rajheem","O'Connor", "Misc", "Deedpoll Submission Fee (Rush)", "9000", "sterlingakili@gmail.com"});
		tData.add(new String[] {"Akili", "Sterling", "Misc", "Consultancy Charge", "5500", "sterlingakili@gmail.com"});
		
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
                        if (i == 2){
                            try {
                                DocumentGenerator.generateDoc(c);
                            } catch (IOException ex) {
                                java.util.logging.Logger.getLogger(GuiController.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (InvalidFormatException ex) {
                                java.util.logging.Logger.getLogger(GuiController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
		}
		
	}

}
