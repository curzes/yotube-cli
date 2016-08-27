package GUI;

import java.io.File;

import Logic.Settings;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Popup {
	
	public static void alert(String message, AlertType type){
		Alert alert = new Alert(type);
		if(type.equals(AlertType.INFORMATION)){
			alert.setTitle("Information");
		}else if(type.equals(AlertType.CONFIRMATION)){
			alert.setTitle("Confirmation");
		}else if(type.equals(AlertType.ERROR)){
			alert.setTitle("Error");
		}else if(type.equals(AlertType.WARNING)){
			alert.setTitle("Warning");
		}else{
			alert.setTitle("None");
		}
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
	
	public static File saveFile(String title, String filename, ExtensionFilter extension){
		FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle( title );
        fileChooser.setInitialDirectory( Settings.defaultDownloadPath );
        fileChooser.setInitialFileName( filename.replaceAll("[^a-zA-Z0-9.-]", "_") );
        FileChooser.ExtensionFilter extFilter = extension;
        fileChooser.getExtensionFilters().add(extFilter);
		File file = fileChooser.showSaveDialog(new Stage());
		return file;
	}

}
