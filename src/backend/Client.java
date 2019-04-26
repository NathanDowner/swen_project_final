package backend;

import java.io.Serializable;
import java.util.*;
import backend.types.AddressType;
import backend.types.CaseType;
import backend.types.PhoneNumType;


public class Client implements Serializable{
	private static int clientNo = 0;
    private String lname;
    private String clientId;
    private String fname;
    private ArrayList<Phone> phones = new ArrayList<>();
    private Id id;
    private String email;
    private String occupation;
    private ArrayList<Address> addresses = new ArrayList<>();
    private ArrayList<Case> cases = new ArrayList<Case>();

    
    public Client(String fname, String lname, String email, String occupation, ArrayList<Address> addresses, ArrayList<Phone> phones) {
    	this.clientId = getNextClientID();
    	this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.occupation = occupation;
        this.phones = phones;
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
    
    public void addPhone(Phone p) {
    	this.phones.add(p);
    }

    public ArrayList<Phone> getPhones() {
		return phones;
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
    
    public void setId(Id id) {
    	this.id = id;
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
    
    public void setHomePhone(String num) {
    	if (phones.size() != 0) {
    		for (Phone p: phones) {
    			if (p.getType() == PhoneNumType.Home) {
    				p.setNumber(num);    			
    			}
    		}
    	} else {
    		phones.add(new Phone(PhoneNumType.Home, num));
    	}
    }
    
    public void setMobilePhone(String num) {
    	if (phones.size() != 0) {
    		for (Phone p: phones) {
    			if (p.getType() == PhoneNumType.Mobile)
    				p.setNumber(num);
    		}
    	} else {
    		phones.add(new Phone(PhoneNumType.Mobile, num));
    	}
    }
    
    public String getNameForSearch() {
    	return this.fname + " " + this.lname;
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
                "Id:           " + clientId + "\n";
        if (phones != null) {
        	for (Phone p : phones)
        		text += p.getType() + "    " + p.getNumber() + "\n";        	
        }
            
        text += "Email:        " + email + "\n" +
                "Occupation:   " + occupation + "\n";
        if (addresses != null) {
             text += "\nAddresses:\n---------------------------------------------------------------\n";
            for (Address a: addresses)
            	text += a.toString() + "\n\n";
        }
        text += "\nCases:\n----------------------------------------------------------------\n";
        for (Case c: cases){
        	text += c.getCaseId()+"/ "+c.getCaseType()+"\n";
       }
        return text;
    }
}
