package backend;


import java.io.File;
import java.util.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 

public class Case {
	private static int lastId = 0;
	private String caseTitle;
    private String caseId;
    private Client client;
    private LocalDateTime startDate;
    private String status;
    private ArrayList<Cost> caseCosts=new ArrayList<Cost>();
    private CaseType caseType;
    private ArrayList<Contact> contact=new ArrayList<Contact>();
    private LocalDateTime endDate;
    private boolean inProgress;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
//    LocalDateTime time; 

    public Case(Client c, CaseType type) {
    	this.client = c;
    	this.caseId = getNextCaseId();
    	this.startDate = LocalDateTime.now();
    	this.caseType = type;
    	this.caseCosts.add(type.getBaseFee());
    	this.caseTitle = type.getCaseType() +" - "+ client.getFullName();
    	this.status = "Case file opened";
    	this.inProgress = true;
//    	this.caseTitle = type.getCaseType()+"-"+getCaseId();
    }
    
    public Case() {
    	this.caseId = getNextCaseId();
    	this.startDate = LocalDateTime.now();
    }
    
    public Client getClient() {
    	return this.client;
    }
    
    private static String getNextCaseId() {
    	return String.format("%05d", ++lastId);
    }
    
    public String getDateStr(LocalDateTime date) {
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


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
    	if (inProgress == false) {
    		this.endDate = LocalDateTime.now();
    	}
        this.inProgress = inProgress;
    }
    
    public String getCaseTitle() {
    	return this.caseTitle;
    }
    
    public String getCaseTypeStr() {
    	return this.caseType.getCaseType();
    }
    
    public String toString() {
    	return this.caseTitle;
    }
    
    public String toString2() {
    	//TODO find out how to format the string so each line is equally tabbed
    	String resp;
    	resp = "Case Id:   " + getCaseId() + "\n"
    	+ "Case Title: " + getCaseTitle() + "\n"
    	+ "Current Status:" + getStatus() + "\n"
    	+ "In Progress:" + isInProgress() + "\n"
    	+ "Start Date: " + getDateStr(getStartDate()) + "\n"
    	+ "Case Type:  "+ getCaseTypeStr()+"\n";
    	if (getEndDate() != null) {
    		resp += "End Date: " + getDateStr(getEndDate()) + "\n";
    	}
    	return resp;
    }
    




}