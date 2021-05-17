package testLibrary;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import pageLibrary.Page2_HomePage;

public class HomePageTest extends BaseTest
{
	
	@Test(priority=1, enabled = true, invocationCount = 1, description = "Common Header UI Verification", groups = {"Smoke","Regression"})
	public void commonHeaderVerificationTest()
	{
		String methodName = new Object() {} .getClass().getEnclosingMethod().getName();
		extentTest = extentReport.createTest(methodName);
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName +" Execution Started From Test Class ", ExtentColor.WHITE));
		Page2_HomePage objHomePage = new Page2_HomePage(driver);
		objHomePage.verifyApplicationHeaderComponents();
		extentTest.log(Status.PASS, MarkupHelper.createLabel(methodName +" Execution Completed From Test Class", ExtentColor.WHITE));
	}

	@Test(priority=2, enabled = true, invocationCount = 1, description = " Browse By Category UI Verification", groups = {"Regression"})
	public void browseByCategoryTest()
	{
		String methodName = new Object() {} .getClass().getEnclosingMethod().getName();
		extentTest = extentReport.createTest(methodName);
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName +" Execution Started From Test Class ", ExtentColor.WHITE));
		Page2_HomePage objHomePage = new Page2_HomePage(driver);
		objHomePage.verifyBrowseByCategoryComponents();
		extentTest.log(Status.PASS, MarkupHelper.createLabel(methodName +" Execution Completed From Test Class", ExtentColor.WHITE));
	}
	
	@Test(priority=3, enabled = true, invocationCount = 1, description = " Browse By Brands UI Verification", groups = {"Regression"})
	public void browseByBrandsTest()
	{
		String methodName = new Object() {} .getClass().getEnclosingMethod().getName();
		extentTest = extentReport.createTest(methodName);
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName +" Execution Started From Test Class ", ExtentColor.WHITE));
		Page2_HomePage objHomePage = new Page2_HomePage(driver);
		objHomePage.verifyBrowseByBrandsComponents();
		extentTest.log(Status.PASS, MarkupHelper.createLabel(methodName +" Execution Completed From Test Class", ExtentColor.WHITE));
	}
	
	@Test(priority=4, enabled = true, invocationCount = 1, description = "Recent Projects UI Verification", groups = {"Regression"})
	public void recentProjectsTest()
	{
		String methodName = new Object() {} .getClass().getEnclosingMethod().getName();
		extentTest = extentReport.createTest(methodName);
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName +" Execution Started From Test Class ", ExtentColor.WHITE));
		Page2_HomePage objHomePage = new Page2_HomePage(driver);
		objHomePage.verifyRecentProjectsComponents();
		extentTest.log(Status.PASS, MarkupHelper.createLabel(methodName +" Execution Completed From Test Class", ExtentColor.WHITE));
	}
	
	@Test(priority=5, enabled = true, invocationCount = 1, description = "Recent Boards UI Verification", groups = {"Regression"})
	public void recentBoardsTest()
	{
		String methodName = new Object() {} .getClass().getEnclosingMethod().getName();
		extentTest = extentReport.createTest(methodName);
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName +" Execution Started From Test Class ", ExtentColor.WHITE));
		Page2_HomePage objHomePage = new Page2_HomePage(driver);
		objHomePage.verifyRecentBoardsComponents();
		extentTest.log(Status.PASS, MarkupHelper.createLabel(methodName +" Execution Completed From Test Class", ExtentColor.WHITE));
	}
	
	@Test(priority=6, enabled = true, invocationCount = 1, description = "Product Search Verification", groups = {"Regression"})
	public void productsSearchTest()
	{
		String methodName = new Object() {} .getClass().getEnclosingMethod().getName();
		extentTest = extentReport.createTest(methodName);
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName +" Execution Started From Test Class ", ExtentColor.WHITE));
		Page2_HomePage objHomePage = new Page2_HomePage(driver);
		objHomePage.verifySearchFunctionality("Products", 2);
		extentTest.log(Status.PASS, MarkupHelper.createLabel(methodName +" Execution Completed From Test Class", ExtentColor.WHITE));
	}
	
	@Test(priority=7, enabled = true, invocationCount = 1, description = "PlanningIdeas Search Verification", groups = {"Regression"})
	public void planningIdeaSearchTest()
	{
		String methodName = new Object() {} .getClass().getEnclosingMethod().getName();
		extentTest = extentReport.createTest(methodName);
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName +" Execution Started From Test Class ", ExtentColor.WHITE));
		Page2_HomePage objHomePage = new Page2_HomePage(driver);
		objHomePage.verifySearchFunctionality("Planning Ideas", 3);
		extentTest.log(Status.PASS, MarkupHelper.createLabel(methodName +" Execution Completed From Test Class", ExtentColor.WHITE));
	}
	
	@Test(priority=8, enabled = true, invocationCount = 1, description = "View All Products List Verification", groups = {"Smoke"})
	public void viewAllProductsListTest()
	{
		String methodName = new Object() {} .getClass().getEnclosingMethod().getName();
		extentTest = extentReport.createTest(methodName);
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName +" Execution Started From Test Class ", ExtentColor.WHITE));
		Page2_HomePage objHomePage = new Page2_HomePage(driver);
		objHomePage.viewAllProducts();
		extentTest.log(Status.PASS, MarkupHelper.createLabel(methodName +" Execution Completed From Test Class", ExtentColor.WHITE));
	}

}
