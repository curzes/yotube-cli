package Files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Save {
	
	public static void writeFile(File file, String content) throws IOException{
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(content);
        fileWriter.close();
	}
	
}
