package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		List<Spaceship> ordered = new ArrayList<>();
		for(Spaceship ship : fleet) {
			ordered.add(ship);
		}
		Collections.sort(ordered, new mySpaceshipComparator());
		List<String> ret = new ArrayList<>();
		for(Spaceship ship : ordered) {
			ret.add(ship.toString());
		}
		return ret;
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String, Integer> map = new HashMap<>();
		for(Spaceship ship : fleet) {
			String className = ship.getClass().getSimpleName();
			if(map.containsKey(className)) {
				map.put(className, map.get(className)+1);
			}
			else {
				map.put(className, 1);
			}		}
		return map;

	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int total = 0;
		for(Spaceship ship : fleet) {
			total += ship.getAnnualMaintenanceCost();
		}
		return total;
	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> ret = new HashSet<>();
		for(Spaceship ship : fleet) {
			if(!ship.getClass().getSimpleName().equals("TransportShip")) {
				myBattleship battleShip = (myBattleship) (ship);
				List<Weapon> weaponList = battleShip.getWeapon();
				for(Weapon weapon : weaponList) {
					String name = weapon.getName();
					if(!ret.contains(name)) {
						ret.add(name);
					}	}	}
		}
		return ret;

	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int total = 0;
		for(Spaceship ship : fleet) {
			total += ship.getCrewMembers().size();
		}
		return total;
	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		int sum = 0;
		int numOfficers = 0;
		for(Spaceship ship : fleet) {
			for(CrewMember member : ship.getCrewMembers()) {
				if(member.getClass().getSimpleName().equals("Officer")) {
					sum += member.getAge();
					numOfficers++;
				}	}	}
		return sum/numOfficers;
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		Map<Officer, Spaceship> map = new HashMap<>();
		for(Spaceship ship : fleet) {
			List<Officer> lst = new ArrayList<>();
			for(CrewMember member : ship.getCrewMembers()) {
				if(member instanceof Officer) {
					lst.add((Officer)(member));
				}
			}
			if(lst.size() > 0) {
			Collections.sort(lst, new myOfficerComparator());
			map.put(lst.get(0), ship);
			}
		}
		return map;

	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		List<Map.Entry<OfficerRank, Integer>> lst = new ArrayList<>();
		Map<OfficerRank, Integer> map = new HashMap<>();
		for(Spaceship ship : fleet) {
			for(CrewMember member : ship.getCrewMembers()) {
				if(member instanceof Officer) {
					Officer officer = (Officer)(member);
					OfficerRank rank = officer.getRank();
					if(map.containsKey(rank)) {
						map.put(rank, map.get(rank)+1);
					}
					else {
						map.put(rank, 1);
					}	}	}	
			}
		for(Map.Entry<OfficerRank, Integer> entry : map.entrySet()) {
			lst.add(entry);
		}
		Collections.sort(lst, new myRankComparator());
		return lst;
	}
}









