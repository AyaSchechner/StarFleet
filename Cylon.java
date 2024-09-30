package il.ac.tau.cs.sw1.ex9.starfleet;

public class Cylon extends myCrewMember{
	
	private int age;
	private int yearsInService;
	private String name;
	private int modelNumber;
	
	public Cylon(String name, int age, int yearsInService, int modelNumber) {
		super(age, yearsInService, name);
		this.modelNumber = modelNumber;
	}


	

}
