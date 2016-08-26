package Logic;

import java.io.File;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Download {
	
	private static File defaultDownloadPath = new File( System.getProperty("user.home") + "/Downloads" );
	
	public static void downloadMp3(Video video){
		System.out.println("Download Mp3 " + video.getLink() );
		FileChooser fileChooser = setupPath(video);
		fileChooser.setInitialFileName( (video.getTitle() + "_" + video.getVideoId()).toLowerCase().replace(" ", "_") + ".mp3" );
		File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
        	System.out.println( file.getAbsolutePath() );
        }
	}
	public static void downloadMp4(Video video){
		System.out.println("Download Mp4 " + video.getLink() );
		FileChooser fileChooser = setupPath(video);
		fileChooser.setInitialFileName( (video.getTitle() + "_" + video.getVideoId()).toLowerCase().replace(" ", "_") + ".mp4" );
		File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
        	System.out.println( file.getAbsolutePath() );
        }
	}
	private static FileChooser setupPath(Video video){
		FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save");
        fileChooser.setInitialDirectory( defaultDownloadPath );
        return fileChooser;
	}
	public static void downloadJson(Video video){
		System.out.println( "Download JSON info for: " + video.getLink() );
	}
}
