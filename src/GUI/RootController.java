package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import javax.imageio.ImageIO;

import com.sun.corba.se.impl.util.PackagePrefixChecker;

import Logic.*;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class RootController{
	
	// SUBSCRIPTION WINDOW
	/// Table
	@FXML private TableView<Video> subscriptionTable;
	@FXML private TableColumn<Video, ImageView> tableThumbnail;
	@FXML private TableColumn<Video, String> tableTitle;
	/// Sidebar
	@FXML private ImageView sidebarThumbnail;
	@FXML private Label sidebarTitle;
	@FXML private Label sidebarChanel;
	@FXML private Label sidebarDate;
	@FXML private Label sidebarUpdated;
	@FXML private Hyperlink sidebarLink;
	@FXML private Label sidebarDescription;
	@FXML private Label sidebarLikes;
	@FXML private Label sidebarRate;
	@FXML private Label sidebarViews;
	
	private ArrayList<Video> videos = new Parser().getVideos();
	

	public void initialize(){
		populateTable();
		subscriptionTable.getSelectionModel().select(0);
		tableSelect();
		System.out.println("Antal videor: " + videos.size());
	}
	
	private void populateTable(){
		tableThumbnail.setCellValueFactory(new PropertyValueFactory<Video, ImageView>("thumbnail"));
		tableTitle.setCellValueFactory(new PropertyValueFactory<Video, String>("title"));
		subscriptionTable.setItems( FXCollections.observableArrayList( videos ));
	}
	public void tableSelect(){
		Video v = subscriptionTable.getSelectionModel().getSelectedItem();
	    if(v != null){
	    	sidebarThumbnail.setImage( v.getThumbnailImage() );
	    	sidebarTitle.setText( v.getTitle() );
	    	sidebarChanel.setText( v.getChanelName() );
	    	sidebarDate.setText( v.getPublished() );
	    	sidebarUpdated.setText( v.getUpdated() );
	    	sidebarLink.setText( v.getLink() );
	    	sidebarLikes.setText( "Likes: " + Integer.toString(v.getLikes()) );
	    	sidebarRate.setText( "Rate: " + Double.toString(v.getRate()) );
	    	sidebarViews.setText( "Views: " + Integer.toString(v.getViews()) );
	    	sidebarDescription.setText( v.getDescription() );
	    }
	}
	// Open video in browser
	public void openInBrowser(){
		Video selectedVideo = subscriptionTable.getSelectionModel().getSelectedItem();
		new Brows().openInBrowser( selectedVideo.getLink() );
	}
	// Ladda ner Mp3
	public void downloadMp3(){
		Video selectedVideo = subscriptionTable.getSelectionModel().getSelectedItem();
	    if(selectedVideo != null){
	    	Download.downloadMp3( selectedVideo );
	    }
	}
	// Ladda ner Mp4
	public void downloadMp4(){
		Video selectedVideo = subscriptionTable.getSelectionModel().getSelectedItem();
	    if(selectedVideo != null){
	    	Download.downloadMp4( selectedVideo );
	    }
	}
	// Ladda ner en videos json info
	public void downloadJson(){
		Video selectedVideo = subscriptionTable.getSelectionModel().getSelectedItem();
	    if(selectedVideo != null){
	    	Download.downloadJson(selectedVideo);
	    }
	}
	// Spela vido
	public void playVideo(){
		Video selectedVideo = subscriptionTable.getSelectionModel().getSelectedItem();
	    if(selectedVideo != null){
	    	new Play().playVideo( selectedVideo.getLink() );
	    }
	}

}
