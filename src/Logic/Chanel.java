package Logic;

import java.util.ArrayList;

public class Chanel {
	
	private String name;
	private String link;
	private ArrayList<Video> videos = new ArrayList<Video>();
	
	public Chanel(String name, String link, ArrayList<Video> videos){
		this.name = name;
		this.link = link;
		this.videos = videos;
	}
	public String GetName(){
		return name;
	}
	public String GetLink(){
		return link;
	}
	public ArrayList<Video> GetVideos(){
		return videos;
	}
}
