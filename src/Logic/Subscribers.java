package Logic;

import java.util.ArrayList;

public class Subscribers {

	private ArrayList<String> subList = new ArrayList<String>();
	
	public Subscribers(){
		/* Lägg till namn från lista eller databas */
		subList.add("STAMSITE");
	}
	public void AddChanel(String name){
		
		/* Kolla om namnet finns */
		/* Lägg till namnet i arrayen */
	}
	public void RemoveChanel(String name){
		/* Ta bort sub från subscribing */
	}
	public ArrayList<String> GetSubList(){
		return subList;
	}
	
}
