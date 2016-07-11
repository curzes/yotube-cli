package Logic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Parser {
	
	private Subscribers subscribers = new Subscribers();
	private ArrayList<Chanel> chanels = new ArrayList<Chanel>();
	
	public Parser(){
		AddingChanels();
	}
	/* Parsing xml from sublist. Get chanel name videos */
	public void AddingChanels(){
		for( String name : subscribers.GetSubList() ){
			try{
				
				Document doc = Jsoup.connect("https://www.youtube.com/feeds/videos.xml?user=" + name).get();
				String chanelName = doc.select("title").first().text();
				String chanelUrl = doc.select("uri").first().text();
				ArrayList<Video> videos = new ArrayList<Video>();
				for(Element video : doc.select("entry")){
					String title = video.select("title").text();
					String link = video.select("link").attr("href");
					Date published = CalkDate(video.select("published").text());
					Date updated = CalkDate(video.select("updated").text());
					String thumbnail = video.select("media|thumbnail").attr("url");
					String description = video.select("media|description").text();
					int likes = Integer.parseInt(video.select("media|starrating").attr("count"));
					double rate = Double.parseDouble(video.select("media|starrating").attr("average"));
					int views = Integer.parseInt(video.select("media|statistics").attr("views"));
					
					Video currentVideo = new Video(title, link, published, updated, thumbnail, description, likes, rate, views);
					videos.add(currentVideo);
				}
				chanels.add(new Chanel(chanelName, chanelUrl, videos));
				
			}catch(Exception ex){
				System.out.print(ex);
			}
		}
	}
	
	/* Converting Date string to date */
	public Date CalkDate(String date){
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
