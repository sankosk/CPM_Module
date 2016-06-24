package logic;

public class Ship {
	private String shipCode;
	private String denomination;
	private String description;
	private int numOfInternDoubleCabin; //nº camarotes dobles interiores
	private int numOfExternDoubleCabin; // nº camarotes dobles exteriores
	private int numOfInternFamiliarCabin; // nº camarotes familiares interiores
	private int numOfExternFamiliarCabin; // nº camarotes familiares exteriores
	private int priceOfInternDoubleCabin;
	private int priceOfExternDoubleCabin;
	private int priceOfInternFamiliarCabin;
	private int priceOfExternFamiliarCabin;
	
	public Ship(String shipCode, String denomination, String description, int numOfInternDoubleCabin, int numOfExternDoubleCabin, int numOfInternFamiliarCabin, int numOfExternFamiliarCabin, int priceOfInternDoubleCabin, int priceOfExternDoubleCabin, int priceOfInternFamiliarCabin, int priceOfExternFamiliarCabin){
		setShipCode(shipCode);
		setDenomination(denomination);
		setDescription(description);
		setNumOfInternDoubleCabin(numOfInternDoubleCabin);
		setNumOfExternDoubleCabin(numOfExternDoubleCabin);
		setNumOfInternFamiliarCabin(numOfInternFamiliarCabin);
		setNumOfExternFamiliarCabin(numOfExternFamiliarCabin);
		setPriceOfInternDoubleCabin(priceOfInternDoubleCabin);
		setPriceOfExternDoubleCabin(priceOfExternDoubleCabin);
		setPriceOfInternFamiliarCabin(priceOfInternFamiliarCabin);
		setPriceOfExternFamiliarCabin(priceOfExternFamiliarCabin);
	}
	// GETTERS AND SETTERS {GENERATED}
	public String getShipCode() {
		return shipCode;
	}
	public void setShipCode(String shipCode) {
		this.shipCode = shipCode;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNumOfInternDoubleCabin() {
		return numOfInternDoubleCabin;
	}
	public void setNumOfInternDoubleCabin(int numOfInternDoubleCabin) {
		this.numOfInternDoubleCabin = numOfInternDoubleCabin;
	}
	public int getNumOfExternDoubleCabin() {
		return numOfExternDoubleCabin;
	}
	public void setNumOfExternDoubleCabin(int numOfExternDoubleCabin) {
		this.numOfExternDoubleCabin = numOfExternDoubleCabin;
	}
	public int getNumOfInternFamiliarCabin() {
		return numOfInternFamiliarCabin;
	}
	public void setNumOfInternFamiliarCabin(int numOfInternFamiliarCabin) {
		this.numOfInternFamiliarCabin = numOfInternFamiliarCabin;
	}
	public int getNumOfExternFamiliarCabin() {
		return numOfExternFamiliarCabin;
	}
	public void setNumOfExternFamiliarCabin(int numOfExternFamiliarCabin) {
		this.numOfExternFamiliarCabin = numOfExternFamiliarCabin;
	}
	public int getPriceOfInternDoubleCabin() {
		return priceOfInternDoubleCabin;
	}
	public void setPriceOfInternDoubleCabin(int priceOfInternDoubleCabin) {
		this.priceOfInternDoubleCabin = priceOfInternDoubleCabin;
	}
	public int getPriceOfExternDoubleCabin() {
		return priceOfExternDoubleCabin;
	}
	public void setPriceOfExternDoubleCabin(int priceOfExternDoubleCabin) {
		this.priceOfExternDoubleCabin = priceOfExternDoubleCabin;
	}
	public int getPriceOfInternFamiliarCabin() {
		return priceOfInternFamiliarCabin;
	}
	public void setPriceOfInternFamiliarCabin(int priceOfInternFamiliarCabin) {
		this.priceOfInternFamiliarCabin = priceOfInternFamiliarCabin;
	}
	public int getPriceOfExternFamiliarCabin() {
		return priceOfExternFamiliarCabin;
	}
	public void setPriceOfExternFamiliarCabin(int priceOfExternFamiliarCabin) {
		this.priceOfExternFamiliarCabin = priceOfExternFamiliarCabin;
	}
	
	@Override
	public String toString(){
		String res = "";
		res += "" + shipCode + "\n";
		res += "" + denomination + "\n";
		res += "" + description + "\n";
		res += "" + numOfInternDoubleCabin + "\n";
		res += "" + numOfExternDoubleCabin + "\n";
		res += "" + numOfInternFamiliarCabin + "\n";
		res += "" + numOfExternFamiliarCabin + "\n";
		res += "" + priceOfInternDoubleCabin + "\n";		
		res += "" + priceOfExternDoubleCabin + "\n";
		res += "" + priceOfInternFamiliarCabin + "\n";
		res += "" + priceOfExternFamiliarCabin + "\n";

		return res;
	}
	
}
