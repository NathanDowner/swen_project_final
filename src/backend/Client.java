package backend;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Client implements Serializable{
	private static int clientNo = 0;
    private String lname;
    private String clientId;
    private String fname;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String email;
    private String occupation;
    private ArrayList<Address> addresses;
    private ArrayList<Case> cases = new ArrayList<Case>();

    public Client(String lname, String fname, String mname, String alias, String motherMaiden, String dob, String birthPlace, String nationality, String homePhone, String mobilePhone, String workPhone, String email, String occupation, String natureOfBus, String nameOfBus, String busPhone, String busFax, Enum idType, String idNum, String idExp, String sourceOfFunds, String trn, String publicFunctionMem, ArrayList<Address> addresses) {
        this.lname = lname;
        this.clientId = getNextClientID();
        this.fname = fname;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
        this.email = email;
        this.occupation = occupation;
        this.addresses = addresses;
    }
    
    public Client(String lname, String fname, String homePhone, String mobilePhone, String workPhone, String email, String occupation, ArrayList<Address> addresses) {
        this.lname = lname;
        this.clientId = getNextClientID();
        this.fname = fname;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
        this.email = email;
        this.occupation = occupation;
        this.addresses = addresses;
    }
    
    public Client() {
    	this.clientId = getNextClientID();
    }
    
    public Client (String fname, String lname, CaseType ct) {
    	this.clientId = getNextClientID();
    	this.fname = fname;
    	this.lname = lname;
    	addCase(new Case(this,ct));
    }
    
    public Client(String fname, String lname, String email) {
    	this.clientId = getNextClientID();
    	this.fname = fname;
    	this.lname = lname;
    	this.email = email;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    
    private static String getNextClientID() {
    	return String.format("%05d", ++clientNo);
    }
    
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }


    public ArrayList<Address> getAddress() {
        return addresses;
    }
    
    public ArrayList<Case> getCases() {
    	return this.cases;
    }

    public void setAddress(ArrayList<Address> address) {
        this.addresses = address;
    }

    public String getFullName() {
    	String ans = this.lname + ", " + this.fname;
    	return ans;
    }
    
    public void addCase(Case c) {
        cases.add(c);
    }
    
    public void addAddress(Address a) {
    	this.addresses.add(a);
    }

    @Override
    public String toString() {
        return getFullName();
    }

    public String toString2() {
    	String text = "";
    	
        text = "Name:          " + fname + " " + lname + "\n" +
                "ID:           " + clientId + "\n" +
                //String.format("Address:      %s\n", addresses.get(0).toString()) +
                "Homephone:    " + homePhone + "\n" +
                "Mobilephone:  " + mobilePhone + "\n" +
                "Email:        " + email + "\n" +
                "Occupation:   " + occupation + "\n";
        if (addresses != null) {
             text += "Addresses:\n________________________________________________________________\n";
            for (Address a: addresses) {
            	text += a.toString() + "\n";
            }
        }
         
        text += "\nCases:\n________________________________________________________________\n";
        for (Case c: cases){
        	text += c.getCaseId()+"/ "+c.getCaseTypeStr()+"\n";
       }
        return text;
    }
}
