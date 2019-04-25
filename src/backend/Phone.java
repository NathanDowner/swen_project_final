package backend;

import java.io.Serializable;

import backend.types.PhoneNumType;

public class Phone implements Serializable {
	private String number;

	private PhoneNumType type;
	
	public Phone (PhoneNumType type, String number) {
		this.type = type;
		this.number = number;
	}
		
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public PhoneNumType getType() {
		return type;
	}

}
