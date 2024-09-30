package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Comparator;

public class mySpaceshipComparator implements Comparator<Spaceship>{

	@Override
	public int compare(Spaceship o1, Spaceship o2) {
		int fire = Integer.compare(o2.getFirePower(), o1.getFirePower());
		if (fire != 0) {
			return fire;
		}
		int commisionYear = Integer.compare(o2.getCommissionYear(), o1.getCommissionYear());
		if (commisionYear != 0) {
			return commisionYear;	
		}
		return o1.getName().compareTo(o2.getName());
	}

}
