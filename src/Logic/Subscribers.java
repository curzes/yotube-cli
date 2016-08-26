package Logic;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Subscribers {

	private ArrayList<String> subList = new ArrayList<String>();
	
	public Subscribers(){
		/* Lägg till namn från lista eller databas */
		subList.add("STAMSITE");
		subList.add("figgwhipp");
		Stats.setNrOfSubscriptions( subList.size() );
	}
	public void addChanel(String name){
		
		/* Kolla om namnet finns */
		/* Lägg till namnet i arrayen */
	}
	public void removeChanel(String name){
		/* Ta bort sub från subscribing */
	}
	public ArrayList<String> getSubList(){
		return subList;
	}
	public boolean chanelExists(String chanel){
		
		return false;
	}
}
