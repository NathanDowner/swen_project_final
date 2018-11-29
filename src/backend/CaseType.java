package backend;

import java.io.Serializable;

public enum CaseType implements Serializable{
    Conveyancing("Conveyancing",50_000.00),
    Misc("Misc",25_000.00),
    AdministrationAndEstate("Admin and Estate",60_000.00),
    Commercial("Commercial",120_000.00),
    Divorce("Divorce",65_000.00);
    
    private Cost baseFee;
    private String caseType;
	
	CaseType(String caseType,double baseFee) {
		this.caseType = caseType;
		this.baseFee = new Cost("Base Fee",baseFee);
	}
	
	public String getCaseType() {
		return this.caseType;
	}
	
	public Cost getBaseFee() {
		return this.baseFee;
	}
	
	public static CaseType strToType(String t) {
		for (CaseType ct: CaseType.values()) {
			if (t.equals(ct.getCaseType())) {
				return ct;
			}
		} return CaseType.Misc;
	}
	
	public String toString() {
		return getCaseType();
	}
}