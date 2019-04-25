package practise;

import java.util.EventObject;

public class FormEvent extends EventObject{

	private String name, occupation, empCategory;
	private AgeCategory ageCategory;
	
	public FormEvent(Object source) { //source will be the FormPanel
		super(source);
	}
	
	public FormEvent(Object source, String name, String occupation, AgeCategory ageCat, String empCat ) {
		super(source);
		this.name = name;
		this.occupation = occupation;
		this.ageCategory = ageCat;
		this.empCategory = empCat;
	}

	public String getOccupation() {
		return occupation;
	}

	public String getName() {
		return name;
	}

	public AgeCategory getAgeCategory() {
		return ageCategory;
	}
	
	public String getEmpCategory() {return empCategory;}
}
