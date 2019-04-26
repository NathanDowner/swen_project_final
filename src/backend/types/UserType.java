package backend.types;
import java.io.Serializable;

public enum UserType implements Serializable {
	Lawyer("Lawyer"),
	RegularEmployee("Regular Employee"),
	Admin("Admin");
	
	private String type;
	
	private UserType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return this.type;
	}
	
	public static UserType strToType(String s) {
		for (UserType ut: UserType.values()) {
			if (s.toLowerCase().equals(ut.toString().toLowerCase())) {
				return ut;
			}
		} return UserType.RegularEmployee; //default
	}
        
        public static void main(String[] args){
            System.out.println(UserType.strToType(null));
            //System.out.print(UserType.Lawyer.toString().equals("Lawyer"));
        }
}
