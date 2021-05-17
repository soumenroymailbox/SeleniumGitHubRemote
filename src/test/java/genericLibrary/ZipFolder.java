package genericLibrary;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import commonLibrary.SystemConfiguration;

public class ZipFolder extends SystemConfiguration
{
	public static String folderToZip = newResultDir+"/ExecutionArtifacts";
	public static String zipName = newResultDir+"/ExecutionArtifacts.zip";

	public static void createZip() 
	{
		try 
		{
			ZipFolder zip = new ZipFolder();
			zip.zipFolder(Paths.get(folderToZip), Paths.get(zipName));
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	// Uses java.util.zip to create zip file
	private void zipFolder(Path sourceFolderPath, Path zipPath) throws Exception 
	{
		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath.toFile()));
		Files.walkFileTree(sourceFolderPath, new SimpleFileVisitor<Path>() 
		{
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException 
			{
				zos.putNextEntry(new ZipEntry(sourceFolderPath.relativize(file).toString()));
				Files.copy(file, zos);
				zos.closeEntry();
				return FileVisitResult.CONTINUE;
			}
		});
		zos.close();
	}
}
