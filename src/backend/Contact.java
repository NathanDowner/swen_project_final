
import java.util.*;

/**
 * Contacts are persons, other than the client, who are involved in the case  either directly, like another law firm, or indirectly like a friend at title's offie who helps speed things along
 */
public class Contact {

    private String name;
    private String number;
    private String email;
    private ArrayList<Address> address;

    public Contact(String name, String number, String email, ArrayList<Address> address) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.address = address;
    }

    public Contact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Address> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<Address> address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}