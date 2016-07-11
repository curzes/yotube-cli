package Logic;
import java.util.Date;

public class Video {
	
	private String title;
	private String link;
	private Date published;
	private Date updated;
	private String thumbnail;
	private String description;
	private int likes;
	private double rate;
	private int views;
	
	public Video(String title, String link, Date published, Date updated, String thumbnail, String description, int likes, double rate, int views){
		this.title = title;
		this.link = link;
		this.published = published;
		this.updated = updated;
		this.thumbnail = thumbnail;
		this.description = description;
		this.likes = likes;
		this.rate = rate;
		this.views = views;
	}
	public String GetTitle(){
		return title;
	}
	public String GetLink(){
		return link;
	}
	public Date GetPublished(){
		return published;
	}
	public Date GetUpdated(){
		return updated;
	}
	public String GetThumbnail(){
		return thumbnail;
	}
	public String GetDescription(){
		return description;
	}
	public int GetLikes(){
		return likes;
	}
	public double GetRate(){
		return rate;
	}
	public int GetViews(){
		return views;
	}
}
