package backend;
import java.io.File;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import backend.types.CaseType; 
import backend.types.CaseStatus;

public class Case implements Serializable{
	private static int lastId = 0;
	private String caseTitle, caseId, lastAction;
    private CaseType caseType;
    private CaseStatus status;
    private Client client;
    private LocalDateTime startDate;
    private ArrayList<Cost> caseCosts=new ArrayList<Cost>();
    private ArrayList<Contact> contact=new ArrayList<Contact>();
    private ArrayList<File> caseFiles = new ArrayList<File>();
    private LocalDateTime endDate;
    private static String dtfString = "dd/MM/yyyy HH:mm:ss";
//    LocalDateTime time; 

    public Case(Client c, CaseType type) {
    	this.client = c;
    	this.caseId = getNextCaseId();
    	this.startDate = LocalDateTime.now();
    	this.caseType = type;
    	this.caseCosts.add(type.getBaseFee());
    	this.caseTitle = type.toString() +" - "+ client.getFullName();
    	this.lastAction = "Case opened";
    	this.status = CaseStatus.Open;
    }
    
    public Case() {
    	this.caseId = getNextCaseId();
    	this.startDate = LocalDateTime.now();
    }
    
    public String getLastAction() {
		return lastAction;
	}

	public void setLastAction(String lastAction) {
		this.lastAction = lastAction;
	}

	public Client getClient() {
    	return this.client;
    }
    
    public void addFile(File f) {
    	this.caseFiles.add(f);
    }
    
    private static String getNextCaseId() {
    	return String.format("%05d", ++lastId);
    }
    
    public String getDateStr(LocalDateTime date) {
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dtfString);
    	return dtf.format(date);
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseID) {
        this.caseId = caseID;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }


    public CaseStatus getStatus() {
        return status;
    }

    public void setStatus(CaseStatus status) {
        this.status = status;
        if (status == CaseStatus.Closed)
        	this.endDate = LocalDateTime.now();
    }

    public ArrayList<Cost> getCaseCosts() {
        return caseCosts;
    }
    
    public void addCost(Cost c) {
    	this.caseCosts.add(c);
    }
    
    public String getCaseCostsStr() {
    	String str = "";
    	for (Cost c: caseCosts) {
    		str += c.toString() + "\n";
    	}
    	return str;
    }

    public void setCaseCosts(ArrayList<Cost> caseCosts) {
        this.caseCosts = caseCosts;
    }
    
    public double getCostToDate(){
        double total = 0.0d;
        for (Cost c: caseCosts) {
        	total += c.getCost();
        }
        return total;
    }
    
    public void addContact(Contact c) {
    	this.contact.add(c);
    }
    
    public ArrayList<Contact> getContact(){
        return contact;
    }

    public CaseType getCaseType() {
        return caseType;
    }

    public void setCaseType(CaseType caseType) {
        this.caseType = caseType;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }
    
    public String getCaseTitle() {
    	return this.caseTitle;
    }
    
    public String toString() {
    	return this.caseTitle;
    }
    
    public String toString2() {
    	//TODO find out how to format the string so each line is equally tabbed
    	String resp;
    	resp = "Case Id:   " + getCaseId() + "\n"
    	+ "Case Title: " + getCaseTitle() + "\n"
    	+ "Case Type:  "+ getCaseType()+"\n"
    	+ "Start Date: " + getDateStr(getStartDate()) + "\n"
    	+ "Status:" + getStatus() + "\n"
    	+ "Last Action:" + getLastAction() + "\n";
    	if (status == CaseStatus.Closed) {
    		resp += "End Date: " + getDateStr(getEndDate()) + "\n";
    	}
    	resp += "Files:\n____________________________________________________________\n";
    	for (File f: caseFiles) {
    		resp += f.getName() +"\n";
    	}
    	//TODO add out contacts
    	return resp;
    }
    




}