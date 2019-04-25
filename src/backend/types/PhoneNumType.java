package backend.types;
import java.io.Serializable;

public enum PhoneNumType implements Serializable {
	Mobile("Mobile"),
	Home("Home"),
	Work("Work");
	
	private String type;
	
	private PhoneNumType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return this.type;
	}
	
	public static PhoneNumType strToType(String s) {
		for (PhoneNumType pnt: PhoneNumType.values()) {
			if (s.toLowerCase() == pnt.toString().toLowerCase()) {
				return pnt;
			}
		} return PhoneNumType.Mobile; //default
	}
}
