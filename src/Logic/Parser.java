package Logic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import jdk.nashorn.internal.parser.JSONParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Parser {
	
	private Subscribers subscribers = new Subscribers();
	private ArrayList<Video> videos;
	
	public Parser(){
		videos = Load.LoadJsonFile("src/Data/Videos.json");
		addingChanels();
	}
	public ArrayList<Video> getVideos(){
		return videos;
	}
	/* Parsing xml from sublist. Get chanel name videos */
	private void addingChanels(){
		for( String name : subscribers.getSubList() ){
			try{
				Document doc = Jsoup.connect("https://www.youtube.com/feeds/videos.xml?user=" + name).get();
				String chanelName = doc.select("title").first().text();
				String chanelLink = doc.select("uri").first().text();
				for(Element video : doc.select("entry")){
					String videoId = video.select("yt|videoid").text();
					if(exists(videoId)){
						break;
					}
					String title = video.select("title").text();
					String link = video.select("link").attr("href");
					Date published = calkDate(video.select("published").text());
					Date updated = calkDate(video.select("updated").text());
					String thumbnail = video.select("media|thumbnail").attr("url");
					String description = video.select("media|description").text();
					int likes = Integer.parseInt(video.select("media|starrating").attr("count"));
					double rate = Double.parseDouble(video.select("media|starrating").attr("average"));
					int views = Integer.parseInt(video.select("media|statistics").attr("views"));
					
					videos.add(new Video(videoId, chanelName, chanelLink, title, link, published, updated, thumbnail, description, likes, rate, views));
				}
				
			}catch(Exception ex){
				System.out.print(ex);
			}
		}
	}
	/*
	 * Kollar om videon redan finns i arrayLisatan videos
	 */
	private boolean exists(String id){
		for(Video v : videos){
			if(v.getVideoId().equals(id)){
				return true;
			}
		}
		return false;
	}
	
	/* 
	 * Konverterar string datum till Date
	 */
	private Date calkDate(String date){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
		try {
			Date dateTime = format.parse(date);
			return dateTime;
		} catch (ParseException ex) {
			System.out.println(ex);
		}
		return null;
	}
}
