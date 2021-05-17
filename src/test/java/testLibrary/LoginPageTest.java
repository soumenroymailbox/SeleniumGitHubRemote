package testLibrary;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import genericLibrary.ApachePOIExcelLibrary;
import genericLibrary.LoadProperties;
import pageLibrary.Page1_LoginPage;

public class LoginPageTest extends BaseTest
{

	@Test(priority=1, enabled = true, invocationCount = 1, description = "Invalid Login Test", groups = {"Regression"})
	public void inValidLoginTest()
	{
		String methodName = new Object() {} .getClass().getEnclosingMethod().getName();
		extentTest = extentReport.createTest(methodName);
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName +" Execution Started From Test Class", ExtentColor.WHITE));
		
		String username = null, password =null;
		String excelPath = ApachePOIExcelLibrary.testDataPath +"LoginPageData.xlsx";
		Page1_LoginPage objLoginPage = new Page1_LoginPage(driver);
		ApachePOIExcelLibrary objExcel = new ApachePOIExcelLibrary(excelPath, 0);
		int rowCount = objExcel.getRowCount();
		for(int i=0;i<rowCount;i++)
		{
			username = objExcel.getCellData(i, 0);
			password = objExcel.getCellData(i, 1);
			objLoginPage.oneLogin(username, password);
			objLoginPage.invalidLoginValidation();
			objLoginPage.refreshPage();
		}
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName +" Execution Completed From Test Class", ExtentColor.WHITE));
	}
	
	@Test(priority=2, enabled = true, invocationCount = 1, description = "Valid Login Test", groups = {"Smoke"})
	public void validLoginTest()
	{
		String methodName = new Object() {} .getClass().getEnclosingMethod().getName();
		extentTest = extentReport.createTest(methodName);
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName +" Execution Started From Test Class ", ExtentColor.WHITE));
		Page1_LoginPage objLoginPage = new Page1_LoginPage(driver);
		try 
		{				
			//	Encapsulation
			objLoginPage.oneLogin(LoadProperties.loadObject(applicationFileDir+"Credentials.properties","ValidUsername"), LoadProperties.loadObject(applicationFileDir+"Credentials.properties","ValidPassword"));
			objLoginPage.validLoginValidation();
		} 
		catch (Exception e)
		{
			System.out.println("Application Login Unsuccesful!" +e.getMessage());
		}

		extentTest.log(Status.PASS, MarkupHelper.createLabel(methodName +" Execution Completed From Test Class", ExtentColor.WHITE));
	}
	
}
