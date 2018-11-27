

/**
 *
 */
public class Address {

    /**
     * Default constructor
     */
    private AddressType type;
    private String line1;
    private String line2;
    private String country;
    private String zip;

    public Address(AddressType type, String line1, String line2, String country, String zip) {

        this.type = type;
        this.line1 = line1;
        this.line2 = line2;
        this.country = country;
        this.zip = zip;
    }

    public Address() {
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public AddressType getAddressType() {
        // TODO implement here
        return null;
    }

    @Override
    public String toString() {
        return "Address{" +
                "type=" + type +
                ", line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", country='" + country + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }

}