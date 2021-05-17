package genericLibrary;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import commonLibrary.SystemConfiguration;

public class ExtentManager extends SystemConfiguration
{
	//Create an extent report instance
	public static ExtentReports instanceExtentReport()
	{
		if (extentReport == null)
		{
			extentHtmlReporter = new ExtentHtmlReporter(newResultDir+"/ExecutionArtifacts/ExtentReport/ExtentReportv4.0.html");
			extentHtmlReporter.config().setReportName("Automation Suite Report");
			extentHtmlReporter.config().setDocumentTitle("Automation Report"); 
			extentHtmlReporter.config().setTheme(Theme.DARK);
			extentHtmlReporter.config().setEncoding("UTF-8");
			extentHtmlReporter.config().setProtocol(Protocol.HTTPS);
			extentHtmlReporter.config().enableTimeline(true);

			extentReport = new ExtentReports();
			extentReport.attachReporter(extentHtmlReporter);

			//			extentReport.setAnalysisStrategy(AnalysisStrategy.TEST);
			//			ExtentTest parent = extentReport.createTest("Parent");
			//			ExtentTest child = parent.createNode("Child");
			//			extentReport.setAnalysisStrategy(AnalysisStrategy.CLASS);
			//			extentReport.setAnalysisStrategy(AnalysisStrategy.SUITE);
			//			ExtentTest suite = extentReport.createTest("Suite");
			//			ExtentTest clazz = suite.createNode("Class");
			//			clazz.createNode("Regression").pass("pass");
			//			clazz.createNode("Unit").fail("fail");
			//			clazz.createNode("Integration").pass("pass");

			GetOSSystemAndBrowserDetail details = new GetOSSystemAndBrowserDetail();
			extentReport.setSystemInfo("Platform", details.platform());
			extentReport.setSystemInfo("Operating System", details.osVersion());
			//			extentReport.setSystemInfo("Browser", details.browserDetails());
			//			extentReport.setSystemInfo("Browser Version", details.browserVersion());

			extentReport.setSystemInfo("Browsers Runs", "Mozilla Firefox & Google Chrome");
			extentReport.setSystemInfo("Browser Versions", "Firefox 72.0.1 & Chrome 80.0.3987");

			extentReport.setSystemInfo("Host name", "localhost");
			extentReport.setSystemInfo("Environemnt", "QA");
			extentReport.setSystemInfo("User","Soumen");

		}

		return extentReport;
	}

}
