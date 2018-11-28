package backend;

import java.util.*;

/**
 * 
 */
public class Client {
	private static int clientNo = 0;
    private String lname;
    private String clientId;
    private String fname;
    private String mname;
    private String alias;
    private String motherMaiden;
    private String dob;
    private String birthPlace;
    private String nationality;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String email;
    private String occupation;
    private String natureOfBus;
    private String nameOfBus;
    private String busPhone;
    private String busFax;
    private Enum idType;
    private String idNum;
    private String idExp;
    private String sourceOfFunds;
    private String trn;
    private String publicFunctionMem;
    private ArrayList<Address> addresses;
    private ArrayList<Case> cases = new ArrayList<Case>();

    public Client(String lname, String fname, String mname, String alias, String motherMaiden, String dob, String birthPlace, String nationality, String homePhone, String mobilePhone, String workPhone, String email, String occupation, String natureOfBus, String nameOfBus, String busPhone, String busFax, Enum idType, String idNum, String idExp, String sourceOfFunds, String trn, String publicFunctionMem, ArrayList<Address> addresses) {
        this.lname = lname;
        this.clientId = getNextClientID();
        this.fname = fname;
        this.mname = mname;
        this.alias = alias;
        this.motherMaiden = motherMaiden;
        this.dob = dob;
        this.birthPlace = birthPlace;
        this.nationality = nationality;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
        this.email = email;
        this.occupation = occupation;
        this.natureOfBus = natureOfBus;
        this.nameOfBus = nameOfBus;
        this.busPhone = busPhone;
        this.busFax = busFax;
        this.idType = idType;
        this.idNum = idNum;
        this.idExp = idExp;
        this.sourceOfFunds = sourceOfFunds;
        this.trn = trn;
        this.publicFunctionMem = publicFunctionMem;
        this.addresses = addresses;
    }
    
    public Client(String lname, String fname, String homePhone, String mobilePhone, String workPhone, String email, String occupation, ArrayList<Address> addresses) {
        this.lname = lname;
        this.clientId = getNextClientID();
        this.fname = fname;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
        this.email = email;
        this.occupation = occupation;
        this.addresses = addresses;
    }
    
    public Client() {
    }
    
    public Client (String fname, String lname, CaseType ct) {
    	this.clientId = getNextClientID();
    	this.fname = fname;
    	this.lname = lname;
    	addCase(new Case(this,ct));
    }
    
    public Client(String fname, String lname) {
    	this.clientId = getNextClientID();
    	this.fname = fname;
    	this.lname = lname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    
    private static String getNextClientID() {
    	return String.format("%05d", ++clientNo);
    }
    
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getMotherMaiden() {
        return motherMaiden;
    }

    public void setMotherMaiden(String motherMaiden) {
        this.motherMaiden = motherMaiden;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getNatureOfBus() {
        return natureOfBus;
    }

    public void setNatureOfBus(String natureOfBus) {
        this.natureOfBus = natureOfBus;
    }

    public String getNameOfBus() {
        return nameOfBus;
    }

    public void setNameOfBus(String nameOfBus) {
        this.nameOfBus = nameOfBus;
    }

    public String getBusPhone() {
        return busPhone;
    }

    public void setBusPhone(String busPhone) {
        this.busPhone = busPhone;
    }

    public String getBusFax() {
        return busFax;
    }

    public void setBusFax(String busFax) {
        this.busFax = busFax;
    }

    public Enum getIdType() {
        return idType;
    }

    public void setIdType(Enum idType) {
        this.idType = idType;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getIdExp() {
        return idExp;
    }

    public void setIdExp(String idExp) {
        this.idExp = idExp;
    }

    public String getSourceOfFunds() {
        return sourceOfFunds;
    }

    public void setSourceOfFunds(String sourceOfFunds) {
        this.sourceOfFunds = sourceOfFunds;
    }

    public String getTrn() {
        return trn;
    }

    public void setTrn(String trn) {
        this.trn = trn;
    }

    public String getPublicFunctionMem() {
        return publicFunctionMem;
    }

    public void setPublicFunctionMem(String publicFunctionMem) {
        this.publicFunctionMem = publicFunctionMem;
    }

    public ArrayList<Address> getAddress() {
        return addresses;
    }
    
    public ArrayList<Case> getCases() {
    	return this.cases;
    }

    public void setAddress(ArrayList<Address> address) {
        this.addresses = address;
    }

    public String getFullName() {
    	String ans = this.lname + ", " + this.fname;
    	return ans;
    }
    
    public void addCase(Case c) {
        cases.add(c);
    }

    @Override
    public String toString() {
        return getFullName();
    }

    public String toString2() {
    	String text = "";
    	
        text = "Name:          " + fname + " " + lname + "\n" +
                "ID:           " + clientId + "\n" +
                //String.format("Address:      %s\n", addresses.get(0).toString()) +
                "Homephone:    " + homePhone + "\n" +
                "Mobilephone:  " + mobilePhone + "\n" +
                "Workphone:    " + workPhone + "\n" +
                "Email:        " + email + "\n" +
                "Occupation:   " + occupation + "\n" +
                "Cases:        ";
        for (Case c: cases){
        	text += c.getCaseId() + " ";
        }
        return text;
    }
}
