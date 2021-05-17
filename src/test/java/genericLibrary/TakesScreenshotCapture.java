package genericLibrary;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import commonLibrary.SystemConfiguration;

public class TakesScreenshotCapture extends SystemConfiguration 
{	
	public static void screenShotFullPage(WebDriver driver,String name)
	{
		// Take screenshot and store as a file format             
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);           
		try 
		{
			// now copy the  screenshot to desired location using copyFile method  
			String dirpath = "file:///"+newResultDir +"/ExecutionArtifacts/projectResources/screenshotsLibrary/TakesScreenShotPage/"+name+"_"+System.currentTimeMillis()+".png";			
			FileUtils.copyFile(source, new File(dirpath));   
		} 
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}

	public static String captureScreenShotForResult(WebDriver driver, String dirPath)
	{		

		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);    
		String screenShotPath = dirPath;
		try 
		{
			FileUtils.copyFile(source, new File(screenShotPath));   
		} 
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		return screenShotPath;

	}

	public static void screenShotWebElement(WebDriver driver, WebElement element)
	{          	           
		try 
		{
			File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			BufferedImage fullimg = ImageIO.read(source);
			Point elementpoint = element.getLocation();
			int elementWidth = element.getSize().getWidth();
			int elementHeight = element.getSize().getHeight();
			BufferedImage elementScreenshot = fullimg.getSubimage(elementpoint.getX(), elementpoint.getY(), elementWidth, elementHeight);
			ImageIO.write(elementScreenshot, "png", source);

			// now copy the  screenshot to desired location using copyFile method
			FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"/projectResources/screenshotsLibrary/TakesScreenShotWebElement/"+System.currentTimeMillis()+".png"));   
		} 
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}

	public static void customSnapshot(String method) 
	{
		String screenShotFolderPath = newResultDir +"/ExecutionArtifacts/Screenshots/customScreenshots/"+method+"_"+cdt.getLocalDateTime()+".png";
		try 
		{
			extentTest.log(Status.INFO, MarkupHelper.createLabel("<<< Refer Below Snapshot for "+"\""+method+"\""+" Execution Pass >>> " + extentTest.addScreenCaptureFromPath(TakesScreenshotCapture.captureScreenShotForResult(driver, screenShotFolderPath)), ExtentColor.TEAL));		
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public static void passedSnapshot(ITestResult testResult) 
	{
		extentTest.log(Status.PASS, MarkupHelper.createLabel("Test is Passed and Test Case Name is : " + testResult.getName(), ExtentColor.GREEN));
		String screenShotFolderPath = newResultDir +"/ExecutionArtifacts/Screenshots/PassedScreenshot/"+testResult.getName()+"_"+cdt.getLocalDateTime()+".png"; 
		String screenShotPathforExtentReport = TakesScreenshotCapture.captureScreenShotForResult(driver, screenShotFolderPath);
		try
		{
			TakesScreenshotCapture.captureScreenShotForResult(driver, screenShotFolderPath);
			extentTest.log(Status.PASS, MarkupHelper.createLabel("Please Refer Snapshot Below : " + extentTest.addScreenCaptureFromPath(screenShotPathforExtentReport), ExtentColor.INDIGO));
		}
		catch (Exception e)
		{
			System.out.println("Exception Occurs " + e.getMessage());
		}
		finally 
		{
			//			driver.close();
		}
	}

	public static void failedSnapshot(ITestResult testResult) 
	{
		extentTest.log(Status.FAIL, MarkupHelper.createLabel("Test is Failed and Test Case Name is : " + testResult.getName(), ExtentColor.RED));
		extentTest.log(Status.FAIL, MarkupHelper.createLabel("Please Refer the Exception for more Details :-   "+ testResult.getThrowable(), ExtentColor.WHITE));
		String screenShotFolderPath = newResultDir +"/ExecutionArtifacts/Screenshots/FailedScreenshot/"+testResult.getName()+"_"+cdt.getLocalDateTime()+".png";
		String screenShotPathforExtentReport = TakesScreenshotCapture.captureScreenShotForResult(driver, screenShotFolderPath);
		try
		{
			TakesScreenshotCapture.captureScreenShotForResult(driver, screenShotFolderPath);
			extentTest.log(Status.FAIL, MarkupHelper.createLabel("Please Refer Snapshot Below : " + extentTest.addScreenCaptureFromPath(screenShotPathforExtentReport), ExtentColor.INDIGO));
		}
		catch (Exception e)
		{
			System.out.println("Exception Occurs " + e.getMessage());
		}
		finally 
		{
			//			driver.close();
		}
	}

	public static void skippedSnapshot(ITestResult testResult) 
	{
		extentTest.log(Status.SKIP, MarkupHelper.createLabel("Test is Skipped and Test Case Name is : " + testResult.getName(), ExtentColor.BLUE));
		String screenShotFolderPath = newResultDir +"/ExecutionArtifacts/Screenshots/SkippedScreenshot/"+testResult.getName()+"_"+cdt.getLocalDateTime()+".png"; 
		String screenShotPathforExtentReport = TakesScreenshotCapture.captureScreenShotForResult(driver, screenShotFolderPath);
		try
		{
			TakesScreenshotCapture.captureScreenShotForResult(driver, screenShotFolderPath);
			extentTest.log(Status.SKIP, MarkupHelper.createLabel("Please Refer Snapshot Below : " + extentTest.addScreenCaptureFromPath(screenShotPathforExtentReport), ExtentColor.INDIGO));
		}
		catch (Exception e)
		{
			System.out.println("Exception Occurs " + e.getMessage());
		}
		finally 
		{
			//			driver.close();
		}
	}

}
