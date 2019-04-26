package finalGui.eventListeners;

import java.util.EventObject;

import backend.types.UserType;

public class AddUserEvent extends EventObject {

	private static final long serialVersionUID = 1L;
	String fname, lname, username, password;
	UserType type;
	
	public AddUserEvent(Object source, String fname, String lname, String username,
			String password, UserType userType) {
		super(source);
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
		this.type = userType;
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

	public UserType getCaseType() {
		return type;
	}
}
