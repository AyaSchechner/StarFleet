package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public abstract class myBattleship extends mySpaceship{


	protected List<Weapon> weapons;
	protected int firePower;
	
	public myBattleship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.weapons = weapons;
		this.firePower = 10;
		for(Weapon weapon : weapons) {
			this.firePower += weapon.getFirePower();			
		}
	}
	
	public String toString() {
		return super.toString() + "\r\n" + "	WeaponArray=" + this.getWeapon().toString();
	}

	
	public List<Weapon> getWeapon(){
		return this.weapons;
	}
	
	@Override
	public int getFirePower() {
		return this.firePower;
	}

}
