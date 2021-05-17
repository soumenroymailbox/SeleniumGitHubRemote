package genericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

import commonLibrary.SystemConfiguration;

public class Listener extends SystemConfiguration implements ITestListener
{
	@Override
	public synchronized void onStart(ITestContext context)
	{
		System.err.println("!*!*!*!*!*!*!*!*! Listener : Job Execution Started !*!*!*!*!*!*!*!*!");
		Reporter.log("!*!*!*!*!*!*!*!*! Listener : Job Execution Started !*!*!*!*!*!*!*!*!");
		
		extentHtmlReporter = new ExtentHtmlReporter(executionResultDir+"ExtentReport.html");
		extentHtmlReporter.config().setReportName("Automation Suite Report");
		extentHtmlReporter.config().setDocumentTitle("Automation Report"); 
		extentHtmlReporter.config().setTheme(Theme.DARK);
		extentHtmlReporter.config().setEncoding("UTF-8");
		extentHtmlReporter.config().setProtocol(Protocol.HTTPS);
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(extentHtmlReporter);

		extentReport.setSystemInfo("Host name", "localhost");
		extentReport.setSystemInfo("Environemnt", "QA");
		extentReport.setSystemInfo("User", "Soumen");
		
	}

	@Override
	public synchronized void onFinish(ITestContext context) 
	{
		System.err.println("!*!*!*!*!*!*!*!*! Listener : Job Execution Finished !*!*!*!*!*!*!*!*!");
		Reporter.log("!*!*!*!*!*!*!*!*! Listener : Job Execution Finished !*!*!*!*!*!*!*!*!");	
		extentReport.flush();
	}

	@Override
	public synchronized void onTestStart(ITestResult result) 
	{
		System.err.println("!*!*!*!*!*!*!*!*! Listener : "+result.getName()+ " Test Execution Started !*!*!*!*!*!*!*!*!");
		Reporter.log("!*!*!*!*!*!*!*!*! Listener : "+result.getName()+ " Test Execution Started !*!*!*!*!*!*!*!*!");
		extentTest = extentReport.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
	}

	@Override
	public synchronized void onTestSuccess(ITestResult result)
	{
		System.err.println("!*!*!*!*!*!*!*!*! Listener : "+result.getName()+ " Test Execution Passed !*!*!*!*!*!*!*!*!");
		Reporter.log("!*!*!*!*!*!*!*!*! Listener : "+result.getName()+ " Test Execution Passed !*!*!*!*!*!*!*!*!");

		extentTest = extentReport.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
		extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Started", ExtentColor.GREEN));
		extentTest.log(Status.PASS, "===== Test Case Execution Started =====");
		extentTest.log(Status.PASS, "===== Test Case Execution Completed =====");
		extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Passed", ExtentColor.GREEN));
		
		String screenShotFolderPath = executionResultDir + "/PassedScreenshot/"+result.getName()+"_"+cdt.getLocalDateTime()+".png"; 
		String screenShotPathforExtentReport = TakesScreenshotCapture.captureScreenShotForResult(driver, screenShotFolderPath);
		try
		{
			TakesScreenshotCapture.captureScreenShotForResult(driver, screenShotFolderPath);
			extentTest.pass("Please Refer Snapshot Below : " + extentTest.addScreenCaptureFromPath(screenShotPathforExtentReport));
		}
		catch (Exception e)
		{
			System.out.println("Exception Occurs " + e.getMessage());
		}
		
	}

	@Override
	public synchronized void onTestFailure(ITestResult result)
	{
		System.err.println("!*!*!*!*!*!*!*!*! Listener : "+result.getName()+ " Test Execution Failed !*!*!*!*!*!*!*!*!");
		Reporter.log("!*!*!*!*!*!*!*!*! Listener : "+result.getName()+ " Test Execution Failed !*!*!*!*!*!*!*!*!");

		extentTest = extentReport.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
		extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test Started", ExtentColor.RED));
		extentTest.log(Status.FAIL, "===== Test Case Execution Started =====");
		extentTest.log(Status.FAIL, "===== Test Case Execution Failed =====");
		extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test Failed", ExtentColor.RED));
		extentTest.fail(result.getThrowable());
						
		String screenShotFolderPath = executionResultDir +"/FailedScreenshot/"+result.getName()+"_"+cdt.getLocalDateTime()+".png";
		
		String screenShotPathforExtentReport = TakesScreenshotCapture.captureScreenShotForResult(driver, screenShotFolderPath);
		try
		{
			TakesScreenshotCapture.captureScreenShotForResult(driver, screenShotFolderPath);
			extentTest.fail("Please Refer Snapshot Below : " + extentTest.addScreenCaptureFromPath(screenShotPathforExtentReport));
		}
		catch (Exception e)
		{
			System.out.println("Exception Occurs " + e.getMessage());
		}
	}

	@Override
	public synchronized void onTestSkipped(ITestResult result) 
	{
		System.err.println("!*!*!*!*!*!*!*!*! Listener : "+result.getName()+ " Test Execution Skipped !*!*!*!*!*!*!*!*!");
		Reporter.log("!*!*!*!*!*!*!*!*! Listener : "+result.getName()+ " Test Execution Skipped !*!*!*!*!*!*!*!*!");

		extentTest = extentReport.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
		extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Skipped", ExtentColor.BLUE));
		extentTest.log(Status.SKIP, "===== Test Case Execution Started =====");
		extentTest.log(Status.SKIP, "===== Test Case Execution Skipped =====");
		extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Skipped", ExtentColor.BLUE));
		extentTest.skip(result.getThrowable());
		
		String screenShotFolderPath = executionResultDir +"/SkippedScreenshot/"+result.getName()+"_"+cdt.getLocalDateTime()+".png"; 
		String screenShotPathforExtentReport = TakesScreenshotCapture.captureScreenShotForResult(driver, screenShotFolderPath);
		try
		{
			TakesScreenshotCapture.captureScreenShotForResult(driver, screenShotFolderPath);
			extentTest.skip("Please Refer Snapshot Below : " + extentTest.addScreenCaptureFromPath(screenShotPathforExtentReport));
		}
		catch (Exception e)
		{
			System.out.println("Exception Occurs " + e.getMessage());
		}
	}

	@Override
	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		Reporter.log(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
	}

}