package backend.types;

import java.io.Serializable;

public enum CaseStatus implements Serializable {
	Open("Open"),
	Closed("Closed");
	
	private String status;
	
	private CaseStatus(String stat) {
		this.status = stat;
	}
	
	public String toString() {
		return this.status;
	}
}
