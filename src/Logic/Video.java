package Logic;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Video implements Comparable<Video>{
	
	private String videoId;
	private String chanelName;
	private String chanelLink;
	private String title;
	private String link;
	private Date published;
	private Date updated;
	private String thumbnail;
	private String description;
	private int likes;
	private double rate;
	private int views;
	
	
	public Video(String videoId, String chanelName, String chanelLink, String title, String link, Date published, Date updated, String thumbnail, String description, int likes, double rate, int views){
		this.videoId = videoId;
		this.chanelName = chanelName;
		this.chanelLink = chanelLink;
		this.title = title;
		this.link = link;
		this.published = published;
		this.updated = updated;
		this.thumbnail = thumbnail.replace("hqdefault", "mqdefault");
		this.description = description;
		this.likes = likes;
		this.rate = rate;
		this.views = views;
	}
	public String getChanelName(){
		return chanelName;
	}
	public String getChanelLink(){
		return chanelLink;
	}
	public String getVideoId(){
		return videoId;
	}
	public String getTitle(){
		return title;
	}
	public String getLink(){
		return link;
	}
	public String getPublished(){
		return new SimpleDateFormat("EEEE d MMM Y HH:mm:ss").format(published);
	}
	public String getUpdated(){
		return new SimpleDateFormat("EEEE d MMM Y HH:mm:ss").format(updated);
	}
	public Date getCompareDate(){
		return published;
	}
	public ImageView getThumbnail(){
		ImageView img = new ImageView();
		img.setFitHeight(66);
		img.setFitWidth(117);
		img.setImage(new Image(thumbnail));
		return img;
	}
	public Image getThumbnailImage(){
		Image img = new Image(thumbnail);
		return img;
	}
	public String getDescription(){
		return description;
	}
	public int getLikes(){
		return likes;
	}
	public double getRate(){
		return rate;
	}
	public int getViews(){
		return views;
	}
	@Override
	public int compareTo(Video o) {
		return published.compareTo(o.getCompareDate());
	}
}
