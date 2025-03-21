package readPropertyData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FLib {
	
	public String readDataFromPropertyFile( String path , String key) throws IOException {
		
		// To specify the location of file
		FileInputStream fis = new FileInputStream(path);
		
		// To make the file ready to read
	    Properties prop = new Properties();
	    prop.load(fis);
	    
	   String data = prop.getProperty(key);
	    
	    return data;
	    
		
		
	}

}
