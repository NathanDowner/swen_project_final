package finalGui.eventListeners;

import java.util.EventObject;

import backend.Client;
import backend.types.CaseType;

public class AddCaseEvent extends EventObject {
	private Client client;
	private CaseType caseType;

	public AddCaseEvent(Object source, Client c, CaseType caseType) {
		super(source);
		this.client = c;
		this.caseType = caseType;
	}
	
	public Client getClient() {
		return client;
	}
	
	public CaseType getCaseType() {
		return caseType;
	}
}
