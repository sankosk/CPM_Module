package logic;

public class Extra {
	private String extraCode;
	private String denomination;
	private int priceOfExtra;
	
	
	public Extra(String extraCode, String denomination, int priceOfExtra){
		setExtraCode(extraCode);
		setDenomination(denomination);
		setPriceOfExtra(priceOfExtra);
	}
	//GETTERS AND SETTERS {GENERATED}
	public String getExtraCode() {
		return extraCode;
	}
	public void setExtraCode(String extraCode) {
		this.extraCode = extraCode;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public int getPriceOfExtra() {
		return priceOfExtra;
	}
	public void setPriceOfExtra(int priceOfExtra) {
		this.priceOfExtra = priceOfExtra;
	}
	
	@Override
	public String toString(){
		String res = "";
		res += "" + extraCode + "\n";
		res += "" + denomination + "\n";
		res += "" + priceOfExtra + "\n";
		return res;
	}
}
