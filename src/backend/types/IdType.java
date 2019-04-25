package backend.types;
import java.io.Serializable;

public enum IdType implements Serializable{
	
	Passport("Passport"),
	National_ID("National Id"),
	Drivers_License("Drivers License");
	
	private String idType;
	
	private IdType(String type) {
		this.idType = type;
	}
	
	public String toString() {
		return this.idType;
	}
	
	public static IdType strToType(String s) {
		for (IdType it: IdType.values()) {
			if (s.toLowerCase() == it.toString().toLowerCase()) {
				return it;
			}
		} return IdType.Drivers_License; //default
	}

}
