package logic;

import java.util.Date;

public class Cruiser {
	private String cruiserCode;
	private String zone;
	private String denomination;
	private String outputPort;
	private String[] itinerary;
	private String description;
	private int duration;
	private String[] departureDates; //considerar el uso de Date() aunque solo complique mas las cosas
	private String idShip;
	private boolean aptoMenores;
	private boolean onsale;
	
	public Cruiser(String cruiserCode, String zone, String denomination, String outputPort, String[] itinerary, String description, boolean aptoMenores, int duration, String[] departureDates, String idShip){
		setCruiserCode(cruiserCode);
		setZone(zone);
		setDenomination(denomination);
		setOutputPort(outputPort);
		setItinerary(itinerary);
		setDescription(description);
		setDuration(duration);
		setDepartureDates(departureDates);
		setIdShip(idShip);
		setAptoMenores(aptoMenores);
	}
	
	private void setAptoMenores(boolean aptoMenores){
		this.aptoMenores = aptoMenores;
	}
	
	public String getAptoMenores(){
		if(aptoMenores)
			return "Si";
		else
			return "No";
	}
	
	public boolean isAptoMenores(){
		return aptoMenores;
	}
	
	public boolean isOnSale(){
		return onsale;
	}
	public void putOnSale(){
		if(!onsale){
			onsale = true;
		}		
	}
	
	// GETTERS AND SETTERS { GENERATED }
	public String getCruiserCode() {
		return cruiserCode;
	}
	private void setCruiserCode(String cruiserCode) {
		this.cruiserCode = cruiserCode;
	}
	public String getZone() {
		return zone;
	}
	private void setZone(String zone) {
		this.zone = zone;
	}
	public String getDenomination() {
		return denomination;
	}
	private void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public String getOutputPort() {
		return outputPort;
	}
	private void setOutputPort(String outputPort) {
		this.outputPort = outputPort;
	}
	public String[] getItinerary() {
		return itinerary;
	}
	private void setItinerary(String[] itinerary) {
		this.itinerary = itinerary;
	}
	public String getDescription() {
		return description;
	}
	private void setDescription(String description) {
		this.description = description;
	}
	public int getDuration() {
		return duration;
	}
	private void setDuration(int duration) {
		this.duration = duration;
	}
	public String[] getDepartureDates() {
		return departureDates;
	}
	private void setDepartureDates(String[] departureDates) {
		this.departureDates = departureDates;
	}
	public String getIdShip() {
		return idShip;
	}
	private void setIdShip(String idShip) {
		this.idShip = idShip;
	}
	
	@Override
	public String toString(){
		String it = "";
		for(int i=0; i<itinerary.length; i++){
			it += itinerary[i] + "-";
		}
		
		String dates = "";
		for(int i=0; i<departureDates.length; i++){
			dates += departureDates[i] + "%";
		}	
//		return "" + cruiserCode + ";" + zone + ";" + denomination + ";" + outputPort + ";"+ it+ ";" + description + ";" + aptoMenores + ";" + duration + ";" + dates + ";" + idShip;
		String a = "";
		a += ""+cruiserCode+"\n";
		a += ""+zone+"\n";
		a += ""+denomination+"\n";
		a += ""+outputPort+"\n";
		a += ""+it+"\n";
		a += ""+description+"\n";
		a += ""+aptoMenores+"\n";
		a += ""+duration+"\n";
		a += ""+dates+"\n";
		a += ""+idShip+"\n";

		return a;





	}
	
}
