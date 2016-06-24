package logic;

import java.util.ArrayList;
import java.util.Comparator;

public class Sorter {
	private ArrayList<Cruiser> cruisers;
	private Comparator<Cruiser> comparator;
	
	
	public Sorter(Comparator<Cruiser> comparator, ArrayList<Cruiser> cruisers){
		this.comparator = comparator;
		this.cruisers = cruisers;
	}
	
	private int searchInsertPosition(Cruiser cruiser, ArrayList<Cruiser> sortedCruisers){
		for(int i=0; i<sortedCruisers.size(); i++){
			Cruiser sortedCruiser = sortedCruisers.get(i);
			if(comparator.compare(cruiser, sortedCruiser) < 0)
				return i;
		}
		
		return sortedCruisers.size();
	}
	
	public ArrayList<Cruiser> sortCruisers(){
		ArrayList<Cruiser> sortedCruisers = new ArrayList<Cruiser>();
		for(int i=0; i<cruisers.size(); i++){
			Cruiser cruiser = cruisers.get(i);
			int index = searchInsertPosition(cruiser, sortedCruisers);
			sortedCruisers.add(index, cruiser);		
		}
		
		return sortedCruisers;
	}
}
