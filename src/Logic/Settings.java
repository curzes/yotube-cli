package Logic;

import java.io.File;

public class Settings {
	public String defaultPlayer = "VLC";
	public String defaultBrowser = "Firefox";
	public int nrOfVideosToShow = 15;
	public static final File defaultDownloadPath = new File( System.getProperty("user.home") + "/Downloads" );
}
