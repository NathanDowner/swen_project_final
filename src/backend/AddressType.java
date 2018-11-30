package backend;

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
    
    public String getStr() {
    	return this.addrType;
    }
    
    public static AddressType strToType(String s) {
    	System.out.println("Got to addr");
    	for(AddressType at: AddressType.values()) {
    		if (s.toLowerCase() == at.getStr().toLowerCase()) {
    			return at;
    		}
    	} return AddressType.Home;
    }
}