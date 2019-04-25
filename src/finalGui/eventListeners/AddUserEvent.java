package gui;

import java.util.EventObject;

public class AddUserEvent extends EventObject {
	
	String fname, lname, username, password, caseType;
	
	public AddUserEvent(Object source, String fname, String lname, String username,
			String password, String caseType) {
		super(source);
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getCaseType() {
		return caseType;
	}
}
