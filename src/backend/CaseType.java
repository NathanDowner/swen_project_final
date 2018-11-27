package backend;

public enum CaseType {
    Conveyancing ("Conveyancing",50_000.00),
    Miscellaneous("Misc.",25_000.00),
    AdministrationAndEstate("Admin and Estate",60_000.00),
    Commercial("Commercial",120_000.00),
    Divorce("Divorce",65_000.00);
    
    private final double baseFee;
    private final String caseType;
	
	CaseType(String caseType,double baseFee) {
		this.caseType = caseType;
		this.baseFee = baseFee;
	}
	
	public String getCaseType() {
		return this.caseType;
	}
	
	public double getBaseFee() {
		return this.baseFee;
	}
}