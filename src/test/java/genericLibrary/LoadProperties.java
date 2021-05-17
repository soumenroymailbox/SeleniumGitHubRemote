package genericLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import commonLibrary.SystemConfiguration;

public class LoadProperties extends SystemConfiguration
{
	public static String loadObject(String filePath,String content) throws Exception
	{
			File src = new File(filePath);
			FileInputStream fis = new FileInputStream(src);
			Properties objProprties = new Properties();
			objProprties.load(fis);
			String returnCredential = objProprties.getProperty(content);			
			return returnCredential;
	}
}
