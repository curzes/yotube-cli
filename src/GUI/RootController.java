package GUI;

import java.net.URL;
import java.util.*;

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
	    	sidebarTitle.setText(v.getTitle());
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
	public void datePress(){
		System.out.println("Hello");
	}
	// Open video in browser
	public void openInBrowser(){
		Video v = subscriptionTable.getSelectionModel().getSelectedItem();
		new Brows().openInBrowser( v.getLink() );
	}
	// Ladda ner Mp3
	public void downloadMp3(){
		Video v = subscriptionTable.getSelectionModel().getSelectedItem();
	    if(v != null){
	    	Download.downloadMp3( v );
	    }
	}
	// Ladda ner Mp4
	public void downloadMp4(){
		Video v = subscriptionTable.getSelectionModel().getSelectedItem();
	    if(v != null){
	    	Download.downloadMp4( v );
	    }
	}
	// Spela vido
	public void playVideo(){
		Video v = subscriptionTable.getSelectionModel().getSelectedItem();
	    if(v != null){
	    	new Play().playVideo( v.getLink() );
	    }
	}

}
