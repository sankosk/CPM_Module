package logic;

public class Bill {	
	private String name;
	private String telephone;
	private String date;
	private String nif;
	
	
	public Bill(String name, String telephone, String date, String nif){
		setName(name);
		setTelephone(telephone);
		setDate(date);
		setNif(nif);
	}
	
	public String getNif() {
		return nif;
	}
	private void setNif(String nif) {
		this.nif = nif;
	}
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	private void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getDate() {
		return date;
	}
	private void setDate(String date) {
		this.date = date;
	}
	
	
	@Override
	public String toString(){
		String res = "";
		res += "NOMBRE: " + getName() + "  NIF: " + getNif() + " TELÉFONO: " + getTelephone() + "\n";
		return res;
	}
	
}
