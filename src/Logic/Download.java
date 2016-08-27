package Logic;

import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import GUI.Popup;
import Files.Create;
import Files.Save;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

public class Download extends Create{
	
	
	public void downloadMp3(Video video){
		System.out.println("Download Mp3 " + video.getLink() );
//		FileChooser fileChooser = setupPath();
//		fileChooser.setInitialFileName( (video.getTitle() + "_" + video.getVideoId()).toLowerCase().replace(" ", "_") + ".mp3" );
//		File file = fileChooser.showSaveDialog(new Stage());
//        if (file != null) {
//        	System.out.println( file.getAbsolutePath() );
//        }
	}
	public void downloadMp4(Video video){
		System.out.println("Download Mp4 " + video.getLink() );
		
		File file = Popup.saveFile("Save .mp4", video.getTitle() + video.getVideoId(), new FileChooser.ExtensionFilter("JSON File (*.json)", "*.json"));
//		
//        if (file != null) {
//        	System.out.println( file.getAbsolutePath() );
//        }
	}

	public void downloadJson(Video video){
		String title = "Save .json";
		String fileName = video.getTitle() + video.getVideoId();
		FileChooser.ExtensionFilter extension = new FileChooser.ExtensionFilter("JSON File (*.json)", "*.json");
		
		File file = Popup.saveFile(title, fileName, extension);
		
        if (file != null) {
        	try {
        		String content = videoToJson(video);
				try {
					Save.writeFile(file, content);
					Popup.alert("The file has been saved saved.", AlertType.INFORMATION);
				} catch (IOException e) {
					// Det gick inte att spara filen
					e.printStackTrace();
				}
			} catch (JSONException e1) {
				// Gick inte att skapa JSON filen.
				e1.printStackTrace();
			}

        }
	}

}
