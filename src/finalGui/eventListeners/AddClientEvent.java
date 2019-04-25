package finalGui.eventListeners;

import java.util.ArrayList;
import java.util.EventObject;

import backend.Address;
import backend.Phone;

public class AddClientEvent extends EventObject{
	
	private static final long serialVersionUID = 1L;
	private String fname, lname, email, occupation, caseType;

	private ArrayList<Address> addresses;
	private ArrayList<Phone> phones;

	public AddClientEvent(Object source, String fname, String lname,
			String email, String occupation, ArrayList<Address> addresses,
			ArrayList<Phone> phones, String caseType) {
		super(source);
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.occupation = occupation;
		this.addresses = addresses;
		this.phones = phones;
		this.caseType = caseType;
	}
	
	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getEmail() {
		return email;
	}

	public String getOccupation() {
		return occupation;
	}

	public ArrayList<Address> getAddresses() {
		return addresses;
	}

	public ArrayList<Phone> getPhones() {
		return phones;
	}
	
	public String getCaseType() {
		return caseType;
	}

}
