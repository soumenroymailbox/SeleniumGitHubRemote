package genericLibrary;

import java.io.File;
import commonLibrary.SystemConfiguration;

public class CreateDirectory extends SystemConfiguration
{
	public static String folderNameGeneration()
	{
		String fName = cdt.getLocalDateTime();	
		System.out.println("Folder Name"+fName);
		return fName;
	}

	@SuppressWarnings("unused")
	public static String CreateFolder()
	{
		String folder = executionResultDir+cdt.getLocalDateTime();
		File newFolder = new File(folder);
		boolean createStatus =  newFolder.mkdirs();
		return folder;
	}
}
