package backend;
import java.io.Serializable;

import backend.types.IdType;

public class Id implements Serializable {
	private String number;
	private IdType type;
	
	public Id (String number, IdType type) {
		this.number = number;
		this.type = type;
	}
	
	public String toString() {
		return this.type + " " + this.number;
	}
}
