package logic;

import java.util.Comparator;

public class SortByDuration implements Comparator<Cruiser>{

	@Override
	public int compare(Cruiser c1, Cruiser c2){
		return (((Integer) c1.getDuration()).compareTo(c2.getDuration()));
	}
}
