package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {

	public String getPropertyValue(String key) throws IOException
	{
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\propertyFile.properties");
		
		Properties prop= new Properties();
		
		prop.load(fis);
		
		String keyvalue = prop.getProperty(key);
		
		return keyvalue;		
	}
}
