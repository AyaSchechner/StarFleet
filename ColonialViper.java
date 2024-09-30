package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends Fighter {
	
	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.annualMaintenanceCost = (int) (4000 + 500*(this.crewMembers.size()) + 500*maximalSpeed);
		for(Weapon weapon : this.weapons) {
			this.annualMaintenanceCost += weapon.getAnnualMaintenanceCost();
		}
	}
	
}
