package logic;

import java.util.Comparator;

public class SortByOutputPort implements Comparator<Cruiser>{
	
	@Override
	public int compare(Cruiser c1, Cruiser c2){
		return c1.getOutputPort().compareTo(c2.getOutputPort());
	}
}
