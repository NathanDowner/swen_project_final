package backend;

import backend.types.AddressType;
import java.io.Serializable;

/**
 *
 */
public class Address implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Default constructor
     */
    private AddressType type;
    private String line1;
    private String line2;
    private String country;
    
    public Address(String type, String line1, String line2, String country) {
    	this.type = AddressType.strToType(type);
    	this.line1 = line1;
    	this.line2 = line2;
    	this.country = country;
    }
    
    public Address(AddressType type, String line1, String line2, String country) {
    	this.type = type;
    	this.line1 = line1;
    	this.line2 = line2;
    	this.country = country;
    }

    public Address() {
    }

	public Address(AddressType adrT, String line1, String country) {
		this.type = adrT;
		this.line1= line1;
		this.country = country;
	}

	public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public AddressType getAddressType() {
        // TODO implement here
        return null;
    }

    @Override
    public String toString() {
    	String op = "";
        op += "Type: " + type + "\n" + 
        		"Line 1: "+ this.line1 + "\n";
        if (line2 != null) {
        	op += "Line 2: " + this.line2 + "\n";
        }
        op += "Country: " + this.country;
        return op;
    }

}