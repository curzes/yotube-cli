package Files;

import org.json.JSONException;
import org.json.JSONObject;

import Logic.Video;

public class Create {
	
	protected String videoToJson(Video v) throws JSONException{
		JSONObject chanel = new JSONObject();
		JSONObject video = new JSONObject();
		JSONObject thumbnail = new JSONObject();
		JSONObject main = new JSONObject();
		
		chanel.put("Name", v.getChanelName());
		chanel.put("ID", "None");
		chanel.put("URL", v.getChanelLink());

		thumbnail.put("URL", "None");
		thumbnail.put("Base 64", "None");

		video.put("ID", v.getVideoId());
		video.put("Title", v.getTitle());
		video.put("URL", v.getLink());
		video.put("Published", v.getPublished());
		video.put("Updated", v.getUpdated());
		video.put("Description", v.getDescription());
		video.put("Likes", v.getLikes());
		video.put("Rate", v.getRate());
		video.put("Views", v.getViews());

		video.put("Thumbnail", thumbnail);
		main.put("Chanel", chanel);
		main.put("Video", video);
		
		return main.toString();
	}
	
}
