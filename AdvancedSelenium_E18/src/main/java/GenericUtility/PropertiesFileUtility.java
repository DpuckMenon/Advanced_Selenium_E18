package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtility {
	
	public String readingDataFromPropFile(String Key) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Nishanth\\git\\E18_Batch\\AdvancedSelenium_E18\\src\\test\\resources\\Common.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String data = prop.getProperty(Key);
		return data;
		
		
		
	}

}
