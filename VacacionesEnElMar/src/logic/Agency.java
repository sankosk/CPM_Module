package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class Agency {
	
	//PATH FILES CONFIG
	private static final String CRUISERS_FILEPATH = "files/cruceros.dat";
	private static final String SHIPS_FILEPATH = "files/barcos.dat";
	private static final String EXTRAS_FILEPATH = "files/extras.dat";
	//
	private ArrayList<Cruiser> cruisers;
	private ArrayList<Ship> ships;
	private ArrayList<Extra> extras;
	
	public Agency(){
		cruisers = new ArrayList<Cruiser>();
		ships = new ArrayList<Ship>();
		extras = new ArrayList<Extra>();
		loadCruisers();
		loadShips();
		loadExtras();
		
	}
	
//	public static void main(String[] args){
//		Agency a = new Agency();
//		ArrayList<String> res = a.showMeCruisers();
//		//String[] res = a.showMeCruisers();
//		
//		for(int i=0; i<res.size(); i++){
//			System.out.println(res.get(i));
//		}
//	}
	
	private void loadCruisers(){
		String line = "";
		String[] data = new String[9];
		try{
			BufferedReader f = new BufferedReader(new FileReader(CRUISERS_FILEPATH));
			while(f.ready()){
				boolean aux = false;
				line = f.readLine();
				data = line.split(";");
				if(data[6].equals("S") || data[6].equals("s")){
					aux=true;
				}
				cruisers.add(new Cruiser(data[0], data[1], data[2], data[3], data[4].split("-"), data[5], aux, Integer.valueOf(data[7]), data[8].split("%"), data[9]));
			}
		}catch(FileNotFoundException e){
			System.err.println("No se ha encontrado el archivo");
		}catch(IOException ioe){
			new RuntimeException("Error E/S");
		}
	}
	
	private void loadShips(){
		String line = "";
		String[] data = new String[11];
		try{
			BufferedReader f = new BufferedReader(new FileReader(SHIPS_FILEPATH));
			while(f.ready()){
				line = f.readLine();
				data = line.split(";");
				ships.add(new Ship(data[0], data[1], data[2], Integer.valueOf(data[3]), Integer.valueOf(data[4]), Integer.valueOf(data[5]), Integer.valueOf(data[6]), Integer.valueOf(data[7]), Integer.valueOf(data[8]), Integer.valueOf(data[9]), Integer.valueOf(data[10])));
			}
		}catch(FileNotFoundException e){
			System.err.println("No se ha encontrado el archivo");
		}catch(IOException ioe){
			new RuntimeException("Error E/S");
		}
	}
	
	private void loadExtras(){
		String line = "";
		String[] data = new String[4];
		try{
			BufferedReader f = new BufferedReader(new FileReader(EXTRAS_FILEPATH));
			while(f.ready()){
				line = f.readLine();
				data = line.split(";");
				extras.add(new Extra(data[0], data[1], Integer.valueOf(data[2])));
			
			}
		}catch(FileNotFoundException e){
			System.err.println("No se ha encontrado el archivo");
		}catch(IOException ioe){
			new RuntimeException("Error E/S");
		}
	}
	
	public ArrayList<String> showMeCruisers(){
		ArrayList<String> result = new ArrayList<String>();
		for(int i=0; i<cruisers.size(); i++){
			result.add(cruisers.get(i).toString());
		}
		return result;
	}
	
	public ArrayList<Cruiser> getCruisers() {
		return cruisers;
	}

	public void setCruisers(ArrayList<Cruiser> cruisers) {
		this.cruisers = cruisers;
	}

	public ArrayList<Ship> getShips() {
		return ships;
	}

	public void setShips(ArrayList<Ship> ships) {
		this.ships = ships;
	}

	public ArrayList<Extra> getExtras() {
		return extras;
	}

	public void setExtras(ArrayList<Extra> extras) {
		this.extras = extras;
	}

	public ArrayList<String> showMeShips(){
		ArrayList<String> result = new ArrayList<String>();
		for(int i=0; i<ships.size(); i++){
			result.add(ships.get(i).toString());
		}
		return result;
	}
	
	public ArrayList<String> showMeExtras(){
		ArrayList<String> result = new ArrayList<String>();
		for(int i=0; i<extras.size(); i++){
			result.add(extras.get(i).toString());
		}
		return result;
	}
	
	public Ship searchShip(String shipCode){
		for(Ship ship: ships){
			if(shipCode.equals(ship.getShipCode()))
				return ship;
		}
		return null;
	}
	
	private String getCabinsData(ArrayList<Cabin> cabins){
		String res = "";
		for(int i=0; i<cabins.size(); i++){
			res += cabins.get(i);
		}
		return res;
	}
	
	
	public int[] randomItsOnSale(){
		Random r = new Random();
		int onSale[] = {r.nextInt(cruisers.size()),r.nextInt(cruisers.size())};
		return onSale;
	}
	
	
	public int getNumOfDoubleIntCabins(ArrayList<Cabin> cabins){
		int counter = 0;
		for(int i=0; i<cabins.size(); i++){
			if(!cabins.get(i).isCabinType() && cabins.get(i).isLocation()){// doble=false, interior=true
				counter++;
			}
				
		}
		return counter;
	}
	
	public int getNumOfDoubleExtCabins(ArrayList<Cabin> cabins){
		int counter = 0;
		for(int i=0; i<cabins.size(); i++){
			if(!cabins.get(i).isCabinType() && !cabins.get(i).isLocation()){// doble=false, exterior=false
				counter++;
			}
				
		}
		return counter;
	}
	
	public int getNumOfFamiliarExtCabins(ArrayList<Cabin> cabins){
		int counter = 0;
		for(int i=0; i<cabins.size(); i++){
			if(cabins.get(i).isCabinType() && !cabins.get(i).isLocation()){// familiar=true, exterior=false
				counter++;
			}
				
		}
		return counter;
	}
	
	public int getNumOfFamiliarIntCabins(ArrayList<Cabin> cabins){
		int counter = 0;
		for(int i=0; i<cabins.size(); i++){
			if(cabins.get(i).isCabinType() && cabins.get(i).isLocation()){// doble=false, interior=false
				counter++;
			}
				
		}
		return counter;
	}
	
	public int getPriceOfCabins(ArrayList<Cabin> cabins, Cruiser cruiser){
		//precio camarotes = dias * personas * precio por camarote
		int di = getNumOfDoubleIntCabins(cabins) * 2 * cruiser.getDuration() * searchShip(cruiser.getIdShip()).getPriceOfInternDoubleCabin();
		int de = getNumOfDoubleExtCabins(cabins) * 2 * cruiser.getDuration() * searchShip(cruiser.getIdShip()).getPriceOfExternDoubleCabin();
		int fe = getNumOfFamiliarExtCabins(cabins) * 4 * cruiser.getDuration() * searchShip(cruiser.getIdShip()).getPriceOfExternFamiliarCabin();
		int fi = getNumOfFamiliarIntCabins(cabins) *4 * cruiser.getDuration() * searchShip(cruiser.getIdShip()).getPriceOfInternFamiliarCabin();
		
		int total = di+de+fe+fi;
		return total;
	}
	
	public int getTotalExtrasPrice(ArrayList<Cabin> cabins, Cruiser cruiser){
		int total=0;
		for(Cabin cabin: cabins){
			total += cabin.getPriceOfExtras(cruiser);
		}
		
		return total;
	}
	
	public int getTotalNumOfPersons(ArrayList<Cabin> cabins){
		int counter=0;
		for(Cabin cabin: cabins){
			counter += cabin.getNumOfPersons();
		}
		return counter;
	}
	
	public int cheapestCabin(Cruiser cruiser){
		Ship ship = searchShip(cruiser.getIdShip());
		int toCompare[] = {ship.getPriceOfExternDoubleCabin(), ship.getPriceOfExternFamiliarCabin(), ship.getPriceOfInternDoubleCabin(),ship.getPriceOfInternFamiliarCabin()};
		int res=toCompare[0];
		for(int i=0; i<toCompare.length; i++){
			if(toCompare[i]<res){
				res = toCompare[i];
			}
		}		
		return res;
	}
	
	public double discount(int total){
		total -= total * 0.15;
		return total;
	}
	
	
	private String getSystemDate(){
		String date = "";
		Calendar currentDate = new GregorianCalendar();
		int year = currentDate.get(Calendar.YEAR);
		int month = currentDate.get(Calendar.MONTH);
		int day = currentDate.get(Calendar.DAY_OF_MONTH);
		int hour = currentDate.get(Calendar.HOUR_OF_DAY);
		int min = currentDate.get(Calendar.MINUTE);
		int sec = currentDate.get(Calendar.SECOND);
		
		date += "FECHA ACTUAL: " + day + "/" + (month+1) + "/" + year + "\t";
		date += "HORA ACTUAL: " + hour + ":" + min + ":" + sec;
		
		return date;
	}
	
	public String getBill(Bill reserverData, Cruiser cruiser, Ship ship, ArrayList<Cabin> cabins){
		String bill = "";
		bill += "JUSTIFICANTE RESERVA - TEBO'S CRUISERS - " + getSystemDate() + "\n";
		bill += "-------------------------------------------------------------------------------\n";
		bill += reserverData;
		bill += "**Datos del crucero**\n";
		bill += "Crucero: " + cruiser.getDenomination() + "\n";
		bill += "Barco:" + ship.getDenomination() + "\n";
		bill += "Fecha de Salida: " + reserverData.getDate() + "\n";
		bill += "Puerto de Salida:" + cruiser.getOutputPort()+ "\n";
		bill += "Nº Pasajeros: " + getTotalNumOfPersons(cabins) +"\n";
		
		bill += "Camarotes:" + "\n";
		bill += "----------------------\n";
		bill += getCabinsData(cabins);
		
		
		bill += "\n**Pagado Reserva**" + "\n";
		bill += "Camarotes: " + getPriceOfCabins(cabins, cruiser) +"€\n";
		bill += "Extras: " + getTotalExtrasPrice(cabins, cruiser) + "€\n";
		if(cruiser.isOnSale())
			bill += "Importe total: " + discount((getPriceOfCabins(cabins, cruiser) + getTotalExtrasPrice(cabins, cruiser))) + " € (-15% aplicado)";
		else	
			bill += "Importe total: " + (getPriceOfCabins(cabins, cruiser) + getTotalExtrasPrice(cabins, cruiser)) + " €";
		
		return bill;
	}
	
	public void generateBill(Bill bill, Cruiser cruiser,Ship ship, ArrayList<Cabin> cabins){
		FileWriter file = null;
		PrintWriter pw = null;
		
		try{
			file = new FileWriter("reservas/"+bill.getNif()+".dat");
			pw = new PrintWriter(file);
			String toWrite = getBill(bill, cruiser, ship, cabins); 
			for(int i=0; i<toWrite.split("\n").length; i++){
				pw.println(toWrite.split("\n")[i]);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(file != null)	file.close();
			}catch(Exception er){
				er.printStackTrace();
			}
		}
	}
	
}
