package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends myBattleship{
	
	protected int annualMaintenanceCost;
	
	public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.annualMaintenanceCost = 2500 + (int)(1000*this.maximalSpeed); ////round down? 
		for(Weapon weapon : weapons) {
			this.annualMaintenanceCost += weapon.getAnnualMaintenanceCost();
		}	
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return this.annualMaintenanceCost;
	}	
	
//	public String toString() {
//		return super.toString() ;
//	}
				
}
