package genericLibrary;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import commonLibrary.SystemConfiguration;

public class CopyFolderAndFiles extends SystemConfiguration
{
	public void copyDirectory(String from, String to) 
	{
		File fromDir = new File(from);
		File toDir = new File(to);
		try 
		{
			FileUtils.copyDirectory(fromDir, toDir);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void copyFile (String source, String dest)
	{
        File sourceFile = new File(source);
        String name = sourceFile.getName();
        File targetFile = new File(dest+name);
        try 
        {
			FileUtils.copyFile(sourceFile, targetFile);
		} 
        catch (IOException e)
        {
			e.printStackTrace();
		}
    }

}