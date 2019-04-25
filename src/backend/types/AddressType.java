package backend.types;

import java.io.Serializable;

/**
 * 
 */
public enum AddressType implements Serializable{
    Home ("Home"),
    Work ("Work");
	
	private String addrType;
    
    private AddressType (String type) {
    	this.addrType = type;
    }
    
    public String toString() {
    	return this.addrType;
    }
    
    public static AddressType strToType(String s) {
    	System.out.println("Got to addr");
    	for(AddressType at: AddressType.values()) {
    		if (s.toLowerCase() == at.toString().toLowerCase()) {
    			return at;
    		}
    	} return AddressType.Home;
    }
}