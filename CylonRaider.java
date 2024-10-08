package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends Fighter {

	
	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.annualMaintenanceCost = (int) (3500 + 500*this.crewMembers.size() + 1200*this.maximalSpeed);
		for(Weapon weapon : weapons) {
			this.annualMaintenanceCost += weapon.getAnnualMaintenanceCost();
		}
	}

}
