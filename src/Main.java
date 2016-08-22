import java.io.IOException;

import Logic.Parser;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) throws IOException {
    	launch(args);
    }
    
    public void start(Stage stage) {
    	
    	try{
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/Root.fxml"));
    		Parent parent = (Parent)fxmlLoader.load();
    		Scene scene = new Scene(parent);
    		scene.getStylesheets().add(getClass().getResource("css/style.css").toExternalForm());
    		stage.setTitle("Yotube");
    		stage.setScene(scene);
    		stage.getIcons().addAll(
    			    new Image("file:src/img/icon_yotube_64x64.png"),
    			    new Image("file:src/img/icon_yotube_32x32.png"),
    			    new Image("file:src/img/icon_yotube_16x16.png")
    			);
    		stage.show();
    	}
    	catch(Exception ex){
    		System.out.print(ex);
    	}    	
    }

}
