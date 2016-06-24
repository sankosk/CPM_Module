package logic;

import java.util.Comparator;

public class SortByPriceLessToMore implements Comparator<Cruiser>{
	private Agency agency = new Agency();
	
	@Override
	public int compare(Cruiser c1, Cruiser c2){
		return ((Integer) agency.cheapestCabin(c1)).compareTo(agency.cheapestCabin(c2));
	}
}
