package genericLibrary;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import commonLibrary.SystemConfiguration;

import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class ScreenRecorderManager extends ScreenRecorder
{
	public static Date date = new Date();
	public static ScreenRecorder screenRecorder;
	public String name;
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH.mm.ss");
	public static String formattedDate = dateFormat.format(date);
	public static String passToExtent = "Suite Execution-"+formattedDate+".avi";
	public static String recordingDir = SystemConfiguration.newResultDir;

	public ScreenRecorderManager(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat,
			Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name)
					throws IOException, AWTException 
	{		
		super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
		this.name = name;
	}

	public static void startRecording(String methodName) throws Exception 
	{
		File file = new File(recordingDir);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		Rectangle captureSize = new Rectangle(0, 0, width, height);
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().
				getDefaultScreenDevice()
				.getDefaultConfiguration();

		screenRecorder = new ScreenRecorderManager(gc, captureSize,
				new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
						CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
						Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
				null, file, methodName);
		screenRecorder.start();	
		
	}

	public static void stopRecording() 
	{
		try 
		{
			screenRecorder.stop();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	protected File createMovieFile(Format fileFormat) 
	{

		if (!movieFolder.exists()) 
		{
			movieFolder.mkdirs();
		}
		else if (!movieFolder.isDirectory()) 
		{
			try 
			{
				throw new IOException("\"" + movieFolder + "\" is not a directory.");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		return new File(movieFolder,name + "-" + formattedDate + "." + Registry.getInstance().getExtension(fileFormat));
	}

}
