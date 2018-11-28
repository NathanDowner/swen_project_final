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
    private ArrayList<String> status;
    private double baseFee;
    private ArrayList<Cost> caseCosts=new ArrayList<Cost>();
    private String clientName;
    private CaseType caseType;
    private ArrayList<Contact> contact=new ArrayList<Contact>();
    private ArrayList<String> subTypes= new ArrayList<String>();
    private ArrayList<File> caseFiles=new ArrayList<File>();
    private LocalDateTime endDate;
    private boolean inProgress;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
//    LocalDateTime time; 

    public Case(Client c, CaseType type) {
    	this.caseId = getNextCaseId();
    	this.startDate = LocalDateTime.now();
    	this.caseType = type;
//    	this.caseTitle = type.getCaseType() +"-"+ client.getFullName();
    	this.caseTitle = type.getCaseType()+"-"+getCaseId();
    }
    
    public Case() {
    	this.caseId = getNextCaseId();
    	this.startDate = LocalDateTime.now();
    }
    
    private static String getNextCaseId() {
    	return String.format("%05d", ++lastId);
    }
    
    public String getStartDateStr() {
    	return dtf.format(startDate);
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


    public ArrayList<String> getStatus() {
        return status;
    }

    public void setStatus(ArrayList<String> status) {
        this.status = status;
    }

    public double getBaseFee() {
        return baseFee;
    }

    public void setBaseFee(double baseFee) {
        this.baseFee = baseFee;
    }

    public ArrayList<Cost> getCaseCosts() {
        return caseCosts;
    }

    public void setCaseCosts(ArrayList<Cost> caseCosts) {
        this.caseCosts = caseCosts;
    }
    
    public double getCostToDate(){
        double total = 0.0;
        for (Cost c: caseCosts) {
        	total += c.getCost();
        }
        return total;
    }
    
    public void setContacts(ArrayList<Contact> contact){
        this.contact=contact;
    }
    
    public ArrayList<Contact> getContact(){
        return contact;
    }
    

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public CaseType getCaseType() {
        return caseType;
    }

    public void setCaseType(CaseType caseType) {
        this.caseType = caseType;
    }

    public ArrayList<String> getSubTypes() {
        return subTypes;
    }

    public void setSubTypes(ArrayList<String> subTypes) {
        this.subTypes = subTypes;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
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
    	//TODO type out the things in this view
    	return "Case Id:   " + getCaseId() + "\n"
    	+ "Case Title: " + getCaseTitle() + "\n"
    	+ "Start Date: " + getStartDateStr() + "\n"
    	+ "Case Type:  "+ getCaseTypeStr()+"\n";
    }
    




}