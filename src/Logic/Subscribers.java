package Logic;

import java.util.ArrayList;

public class Subscribers {

	private ArrayList<String> subList = new ArrayList<String>();
	
	public Subscribers(){
		/* L�gg till namn fr�n lista eller databas */
		subList.add("STAMSITE");
	}
	public void AddChanel(String name){
		
		/* Kolla om namnet finns */
		/* L�gg till namnet i arrayen */
	}
	public void RemoveChanel(String name){
		/* Ta bort sub fr�n subscribing */
	}
	public ArrayList<String> GetSubList(){
		return subList;
	}
	
}
