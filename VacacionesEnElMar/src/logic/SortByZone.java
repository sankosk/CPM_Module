package logic;
import java.util.Comparator;

public class SortByZone implements Comparator<Cruiser> {
	
	@Override
	public int compare(Cruiser c1, Cruiser c2) 
	{
		return c1.getZone().compareTo(c2.getZone());
	}
}
