package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class myRankComparator implements Comparator<Map.Entry<OfficerRank, Integer>> {

	@Override
	public int compare(Entry<OfficerRank, Integer> o1, Entry<OfficerRank, Integer> o2) {
		int a = Integer.compare(o1.getValue(), o2.getValue());
		if(a != 0) {
			return a;
		}
		return o1.getKey().compareTo(o2.getKey());
	}

}
