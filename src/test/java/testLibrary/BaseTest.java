package testLibrary;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.Status;
import commonLibrary.SystemConfiguration;
import genericLibrary.CopyFolderAndFiles;
import genericLibrary.ExtentManager;
import genericLibrary.LoadProperties;
import genericLibrary.ScreenRecorderManager;
import genericLibrary.SendMailWithExecutionReport;
import genericLibrary.TakesScreenshotCapture;
import genericLibrary.ZipFolder;

@SuppressWarnings("unused")
public class BaseTest extends SystemConfiguration
{			
	@BeforeSuite(description = "Before Suite Execution Started",alwaysRun = true)
	public void executeBeforeSuite()
	{	
		System.out.println("=== Suite Execution Started ===");
		ExtentManager.instanceExtentReport();
		try
		{
			ScreenRecorderManager.startRecording(videoName);
		} 
		catch (Exception e) 
		{
			System.out.println("Exception Occurs : "+e.getMessage());
		}
	}

	@AfterSuite(description="Suite Execution Completed", alwaysRun = true)
	public void executeAfterSuite() 
	{
		CopyFolderAndFiles copy = new CopyFolderAndFiles();
		
		extentReport.flush();
		copy.copyFile(extentCopysourceFile, extentPastedestFile);
		driver.quit();
		ZipFolder.createZip();
		try
		{
			ScreenRecorderManager.stopRecording();;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
//		SendMailWithExecutionReport.sendReportThroughMail("me");
//		SendMailWithExecutionReport.sendReportThroughMail("all");
		
		System.out.println("=== Suite Execution Stopped ===");
	}

	@BeforeClass(description="Class Execution Started", alwaysRun = true)
	public void executeBeforeClass()
	{	
		System.out.println("=== Class Execution Started ===");
//		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass(description="Class Execution Completed", alwaysRun = true)
	public void executeAfterClass()
	{
		System.out.println("=== Class Execution Stopped ===");	
	}

	@Parameters({"browser"})
	@BeforeTest(description="Before Test Execution Started", alwaysRun = true)
	public void executeBeforeTest(@Optional("chrome") String browserName)
	{
		System.out.println("=== Before Test Execution Started ===");
//		System.out.println("Browser is : " + browserName);

		if (browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",browserDriversDir+"chromedriver.exe");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			System.setProperty("webdriver.chrome.args", "--disable-logging");
			Logger.getLogger("org.openqa.selenium.remote").setLevel(Level.OFF);
			System.setProperty("webdriver.chrome.silentOutput", "true");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			driver = new ChromeDriver(options);	
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",browserDriversDir+"geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"false");
			FirefoxOptions options = new FirefoxOptions();
			//			options.addArguments("--headless");
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
		}
		else if (browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver",browserDriversDir+"MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		else
		{
			System.out.println("Please Enter the Supported Driver");
		}
		try 
		{
			jExecutor = (JavascriptExecutor) driver; 
			driver.get(LoadProperties.loadObject(applicationFileDir+"Credentials.properties","QAURL"));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} 
		catch (Exception e)
		{
			System.out.println("Applicarion URL Loading Unsuccesful!" +e.getMessage());
		}
	}

	@AfterTest(description="After Test Execution Started", alwaysRun = true)
	public void executeAfterTest()
	{
		System.out.println("=== After Test Execution Stopped ===");
		//BrowserFactory.closeBrowser(driver);
		driver.close();
	}

	@BeforeMethod(description="Method Execution Started", alwaysRun = true)
	public void executeBeforeMethod()
	{
		System.out.println("=== Method Execution Started ===");
	}

	@AfterMethod(description="Method Execution Completed", alwaysRun = true)
	public void executeAfterMethod(ITestResult result)
	{
		System.out.println("=== Method Execution Stopped ===");
		try
		{
			if (result.getStatus() == ITestResult.SUCCESS)
			{
				TakesScreenshotCapture.passedSnapshot(result);	
			}
			else if (result.getStatus() == ITestResult.FAILURE) 
			{
				TakesScreenshotCapture.failedSnapshot(result);
			} 
			else if (result.getStatus() == ITestResult.SKIP) 
			{
				TakesScreenshotCapture.skippedSnapshot(result);
			}	
		}
		catch(Exception e)
		{
			System.out.println("Error Occured"+e.getMessage());
		}
		finally
		{
			extentTest.log(Status.INFO,videoLinkInExtentReport);
		}	
	}
}
