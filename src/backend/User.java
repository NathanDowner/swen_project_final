package backend;
import java.io.Serializable;

import backend.types.UserType;

public class User implements Comparable<User>, Serializable{
	
	private static final long serialVersionUID = 1L;
	private String username, password, fname, lname;
	private UserType type;
	
	public User(String fname, String lname, String username, String password, UserType type) {
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.type = type;
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}
	
	public String getFname() {return this.fname;}
	
	public String getLname() {return this.lname;}
	
	public String toString() {
		return fname + " " + lname;
	}

	public int compareTo(User u) {
		if (this.username.equals(u.getUsername()) && this.password.equals(u.getPassword())) {
			return 0;
		} else if (this.username.equals(u.getUsername())) {
			return 1;
		} else {
			return -1;
		}
	}
		
	
}
