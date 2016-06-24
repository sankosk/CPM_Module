package logic;

import java.util.ArrayList;

public class Cabin {
	
	private boolean cabinType; // FAMILIAR=True , DOBLE=False
	private boolean location; // INTERIOR=True , EXTERIOR=False
	private int numOfPersons;
	private int[] agesOfPersons;
	private ArrayList<Extra> extras;
	
	public Cabin(boolean cabinType, boolean location, int numOfPersons, int[] agesOfPersons, ArrayList<Extra> extras){
		setCabinType(cabinType);
		setLocation(location);
		setNumOfPersons(numOfPersons);
		setAgesOfPersons(agesOfPersons);
		setExtras(extras);
	}
	
	// SETTERS AND GETTERS { GENERATED }
	public boolean isCabinType() {
		return cabinType;
	}
	
	public String getCabinType(){
		if(cabinType)
			return "Familiar";
		else
			return "Doble";
	}
	
	private void setCabinType(boolean cabinType) {
		this.cabinType = cabinType;
	}
	public boolean isLocation() {
		return location;
	}
	
	public String getLocation(){
		if(location)
			return "Interior";
		else
			return "Exterior";
	}
	private void setLocation(boolean location) {
		this.location = location;
	}
	public int getNumOfPersons() {
		return numOfPersons;
	}
	private void setNumOfPersons(int numOfPersons) {
		this.numOfPersons = numOfPersons;
	}
	public int[] getAgesOfPersons() {
		return agesOfPersons;
	}
	
	public String getAges(){
		String aux="";
		for(int i=0; i<agesOfPersons.length; i++){
			if(i==agesOfPersons.length-1)
				aux += agesOfPersons[i];
			else
				aux += agesOfPersons[i] + ", ";
		}
		
		return aux;
	}
	
	private void setAgesOfPersons(int[] agesOfPersons) {
		this.agesOfPersons = agesOfPersons;
	}
	public ArrayList<Extra> getExtras() {
		return extras;
	}
	
	public String getStringExtras(){
		String aux = "";
		for(int i=0; i<extras.size(); i++){
			if(i == extras.size()-1)
				aux += extras.get(i).getDenomination();
				//aux += extras.get(i).getDenomination()+"("+extras.get(i).getPriceOfExtra()+"€)";
			else
				aux += extras.get(i).getDenomination()+ ", ";
				//aux += extras.get(i).getDenomination()+"("+extras.get(i).getPriceOfExtra()+"€), ";
		}
		
		return aux;
	}
	
	private void setExtras(ArrayList<Extra> extras) {
		this.extras = extras;
	}
	
	public int getPriceOfExtras(Cruiser cruiser){
		int counter = 0;
		for(Extra extra: extras){
			if(extra.getDenomination().equals("Cama supletoria"))
				counter += extra.getPriceOfExtra()*cruiser.getDuration();
			else
				counter += extra.getPriceOfExtra() * cruiser.getDuration() * getNumOfPersons();
		}
		return counter;
	}
	
	@Override
	public String toString(){
//		String result="";
//		result += getCabinType() + "\n";
//		result += getLocation() + "\n";
//		result += getNumOfPersons() + "\n";
//		result += getAges() + "\n";
//		result += getStringExtras();
//		return result;
		String result="";
		result += "\nCamarote " + getCabinType()  +" " + getLocation() + " / " + getStringExtras();
		return result;
	}
	
	
}
