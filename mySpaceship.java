package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;
import java.util.Set;

public abstract class mySpaceship implements Spaceship{
	
	protected String name;
	protected int commissionYear;
	protected float maximalSpeed;
	protected Set<? extends CrewMember> crewMembers;

	public mySpaceship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers) {
		this.name = name;
		this.commissionYear = commissionYear;
		this.maximalSpeed = maximalSpeed;
		this.crewMembers = crewMembers; 
	}

	public String getName() {
		return this.name;	
	}
	
	public int getCommissionYear() {
		return this.commissionYear;
	}
	
	public float getMaximalSpeed() {
		return this.maximalSpeed;
	}

	
	public Set<? extends CrewMember> getCrewMembers(){
		return this.crewMembers;
	}
	
	public String toString() {
		return getClass().getSimpleName() + "\r\n" + "	Name=" + this.getName() + "\r\n" + "	CommissionYear=" + this.getCommissionYear()
		+ "\r\n" + "	MaximalSpeed=" + this.getMaximalSpeed() + "\r\n" + "	FirePower=" + this.getFirePower()
		+ "\r\n" + "	CrewMembers=" + this.getCrewMembers().size() + "\r\n" + "	AnnualMaintenanceCost=" + this.getAnnualMaintenanceCost();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		mySpaceship other = (mySpaceship) obj;
		return Objects.equals(name, other.name);
	}



	public abstract int getAnnualMaintenanceCost();

	public abstract int getFirePower();
	

}
