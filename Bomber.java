package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends myBattleship{

	private int annualMaintenanceCost;
	int numberOfTechnicians;
	
	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.numberOfTechnicians = numberOfTechnicians;
		this.annualMaintenanceCost = 5000; 
		int fireMaintenanceCost = 0;
		for(Weapon weapon : weapons) {
			fireMaintenanceCost += weapon.getAnnualMaintenanceCost();
		}
		fireMaintenanceCost -= (int)(0.1*this.numberOfTechnicians*fireMaintenanceCost);
		this.annualMaintenanceCost += fireMaintenanceCost;
	}

	public int getNumberOfTechnicians() {
		return this.numberOfTechnicians;
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		return this.annualMaintenanceCost;
	}

	public String toString() {
		return super.toString() + "\r\n" + "	NumberOfTechnicians=" + this.getNumberOfTechnicians();
	}
}
