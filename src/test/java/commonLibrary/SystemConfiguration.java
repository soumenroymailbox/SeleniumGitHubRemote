package commonLibrary;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import genericLibrary.CurrentDateTime;
import genericLibrary.ScreenRecorderManager;

public class SystemConfiguration  
{
	public static WebDriver driver;
	public static JavascriptExecutor jExecutor = (JavascriptExecutor)driver;
	public static CurrentDateTime cdt = new CurrentDateTime();
	public static SoftAssert sa = new SoftAssert();
	
		
	public static ExtentHtmlReporter extentHtmlReporter;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
//	public Log4j log = new Log4j();
		
	public static String cookieDir = System.getProperty("user.dir")+"/projectResources/projectResources/cookieLibrary/";
	public static String applicationFileDir = System.getProperty("user.dir")+"/projectResources/applicationFilesLibrary/";
	public static String testDataPath = System.getProperty("user.dir")+"/projectResources/testDataLibrary/";
	
	public static String browserDriversDir = System.getProperty("user.dir")+"/projectResources/browserDriversLibrary/";
		
	//Add Video For Adding in Extent Report
	public String recordedVideoName = ScreenRecorderManager.passToExtent;
	public String videoPath = "file:///"+newResultDir+"/"+recordedVideoName;
	public String videoLinkInExtentReport = "<a href = '"+videoPath+"'><span class = 'label info'>Please Click To Download The Execution Video</span></a>";
	public static String videoName = "Suite Execution";
	
	//Used to Create Folder
	public static String executionResultDir = System.getProperty("user.dir")+"/projectResources/executionResultLibrary/";
	public static String newResultDir = genericLibrary.CreateDirectory.CreateFolder();
	
	public static String extentPastedestFile = System.getProperty("user.dir")+"/projectResources/executionResultLibrary/";
	public static String extentCopysourceFile = newResultDir+"/ExecutionArtifacts/ExtentReport/ExtentReportv4.0.html";
	
	
}
