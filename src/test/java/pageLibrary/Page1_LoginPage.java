package pageLibrary;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import genericLibrary.HighlightWebElement;
import genericLibrary.TakesScreenshotCapture;

public class Page1_LoginPage extends BasePage
{
	public Page1_LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@class='sc-gwVKww ifTxEr']")
	private WebElement LoginPage_Logo;

	@FindBy(xpath="//span[contains(text(),'Connecting to Application')]")
	private WebElement ConnectingToApplicationText;

	@FindBy(xpath="//span[contains(text(),'Remember my username')]")
	private WebElement RememberMyUsernameText;

	@FindBy(xpath="//*[@id='rememberUsername']")
	private WebElement RememberMyUsernameCheckbox;

	@FindBy(xpath="//span[contains(text(),'Continue')]/ancestor::button")
	private WebElement ContinueButton;

	@FindBy(xpath="//span[contains(text(),'Instructions')]/ancestor::button[@type='button']")
	private WebElement InstructionsLink;

	@FindBy(xpath="//span[contains(text(),'Forgot Password')]/ancestor::button[@type='button']")
	private WebElement ForgotPasswordLink;

	@FindBy(xpath="//button[contains(text(),'Powered by OneLogin')]")
	private WebElement PoweredByOneLoginLink;

	@FindBy(xpath="//button[contains(text(),'Terms')]")
	private WebElement TermsLink;

	@FindBy(xpath="//button[contains(text(),'Privacy Policy')]")
	private WebElement PrivacyPolicyLink;

	@FindBy(xpath="//span[contains(text(),'User name (LANID or email address)')]")
	private WebElement UsernameFieldText;

	@FindBy(xpath="//input[@id='username']")
	private WebElement UsernameField;

	@FindBy(xpath="//input[@id='password']")
	private WebElement PasswordField;

	@FindBy(xpath="//span[(text()='Password')]")
	private WebElement PasswordFieldText;

	@FindBy(xpath="//div[@class='mat-menu-trigger user-thumbnail hover-background']")
	private WebElement AccountCircle;

	@FindBy(xpath="//*[text()='Invalid username or password' or @type='error']")
	private WebElement ErrorMessage;
	
	@FindBy(xpath="//*[@class='app-header' or @id='rememberUsername']")
	private WebElement LoginPageLoad;

	public void oneLogin(String un,String pw) 
	{
		String methodName = new Object() {} .getClass().getEnclosingMethod().getName();
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName+" Started Executing From PAGE Class", ExtentColor.GREY));
		extentTest.log(Status.INFO, MarkupHelper.createLabel("Scout Login Page Loaded into the Browser", ExtentColor.TRANSPARENT));
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(LoginPageLoad));
		
		String loginPageTitle = driver.getTitle();
		System.out.println("Title Is "+loginPageTitle);
		extentTest.log(Status.INFO, MarkupHelper.createLabel("The LoginPage Title is : "+loginPageTitle , ExtentColor.TRANSPARENT));
		if (loginPageTitle.equalsIgnoreCase("OneLogin"))
		{
			wait.until(ExpectedConditions.visibilityOf(ContinueButton));
			HighlightWebElement.highlightElement(UsernameField);
			UsernameField.sendKeys(un);
			extentTest.log(Status.INFO, MarkupHelper.createLabel(un + " UserName Entered in Username Field" , ExtentColor.TRANSPARENT));
			wait.until(ExpectedConditions.elementToBeClickable(ContinueButton));
			HighlightWebElement.highlightElement(ContinueButton);
			ContinueButton.click();
			extentTest.log(Status.INFO, MarkupHelper.createLabel("Clicked on Continue Button" , ExtentColor.TRANSPARENT));
			wait.until(ExpectedConditions.visibilityOf(PasswordFieldText));
			HighlightWebElement.highlightElement(PasswordField);
			PasswordField.sendKeys(pw);
			extentTest.log(Status.INFO, MarkupHelper.createLabel("*******" + " Password Entered in Password Field" , ExtentColor.TRANSPARENT));
			HighlightWebElement.highlightElement(ContinueButton);
			ContinueButton.click();
			extentTest.log(Status.INFO, MarkupHelper.createLabel("Clicked on Continue Button" , ExtentColor.TRANSPARENT));
		}
		else if (loginPageTitle.equalsIgnoreCase("Home - Scout Project Builder (qa)"))
		{
			extentTest.log(Status.INFO, MarkupHelper.createLabel("Login Successful in SCOUT Application" , ExtentColor.TRANSPARENT));
		}
		else
		{
			extentTest.log(Status.INFO, MarkupHelper.createLabel("Login Page Title Has Changed in SCOUT Application" , ExtentColor.TRANSPARENT));
		}
			
		extentTest.log(Status.PASS, MarkupHelper.createLabel(methodName+" Completed Executing From PAGE Class", ExtentColor.GREY));
		TakesScreenshotCapture.customSnapshot(methodName);
	}

	public void validLoginValidation()
	{
		String methodName = new Object() {} .getClass().getEnclosingMethod().getName();
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName+" Started Executing From PAGE Class", ExtentColor.GREY));
		wait.until(ExpectedConditions.visibilityOf(HomePageLoad));
		wait.until(ExpectedConditions.visibilityOf(AccountCircle));
		HighlightWebElement.highlightElement(AccountCircle);
		System.out.println("The Home Page Title Is : "+driver.getTitle());
		extentTest.log(Status.INFO, MarkupHelper.createLabel("The HomePage Title is : "+driver.getTitle() , ExtentColor.TRANSPARENT));
		Assert.assertEquals(driver.getTitle(), "Home - Scout Project Builder (qa)","Error Occured in HomePage");
		extentTest.log(Status.INFO, MarkupHelper.createLabel("Login Successfull in SCOUT!" , ExtentColor.TRANSPARENT));
		extentTest.log(Status.PASS, MarkupHelper.createLabel(methodName+" Completed Executing From PAGE Class", ExtentColor.GREY));
		TakesScreenshotCapture.customSnapshot(methodName);
	}

	public void invalidLoginValidation()
	{
		String methodName = new Object() {} .getClass().getEnclosingMethod().getName();
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName+" Started Executing From PAGE Class", ExtentColor.GREY));
		wait.until(ExpectedConditions.visibilityOf(ErrorMessage));
		boolean status = ErrorMessage.isDisplayed();
		HighlightWebElement.highlightElement(ErrorMessage);
		extentTest.log(Status.INFO, MarkupHelper.createLabel("Invalid Credentials Message Displayed" , ExtentColor.TRANSPARENT));
		Assert.assertEquals(status, true,"Error Occured");
		extentTest.log(Status.INFO, MarkupHelper.createLabel("Login Unsuccessfull in SCOUT!" , ExtentColor.TRANSPARENT));
		extentTest.log(Status.PASS, MarkupHelper.createLabel(methodName+" Completed Executing From PAGE Class", ExtentColor.GREY));
		TakesScreenshotCapture.customSnapshot(methodName);
		
	}

	public void refreshPage()
	{
		String methodName = new Object() {} .getClass().getEnclosingMethod().getName();
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName+" Started Executing From PAGE Class", ExtentColor.GREY));
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOf(ContinueButton));
		extentTest.log(Status.INFO, MarkupHelper.createLabel("Refresh the LoginPage of Helios Application" , ExtentColor.TRANSPARENT));
		extentTest.log(Status.PASS, MarkupHelper.createLabel(methodName+" Completed Executing From PAGE Class", ExtentColor.GREY));
		TakesScreenshotCapture.customSnapshot(methodName);
	}

//	public void loginToApplication()
//	{
//		String uName = null, pWord = null;
//		try 
//		{
//			uName = LoadProperties.loadObject(applicationFileDir+"Credentials.properties","ValidUsername");
//			pWord = LoadProperties.loadObject(applicationFileDir+"Credentials.properties","ValidPassword");
//		} 
//		catch (Exception e) 
//		{
//			System.out.println("Application Login Unsuccesful!" +e.getMessage());
//		}
//		wait.until(ExpectedConditions.visibilityOf(ContinueButton));
//		UsernameField.sendKeys(uName);	
//		wait.until(ExpectedConditions.elementToBeClickable(ContinueButton));
//		ContinueButton.click();
//		wait.until(ExpectedConditions.visibilityOf(PasswordFieldText));
//		PasswordField.sendKeys(pWord);
//		ContinueButton.click();
//		wait.until(ExpectedConditions.visibilityOf(HomePageLoad));
//		wait.until(ExpectedConditions.visibilityOf(AccountCircle));
//		wait.until(ExpectedConditions.visibilityOf(ApplicationNameText));
//		Assert.assertEquals(driver.getTitle(), "Harbor - QA","Error Occured in HomePage");
//	}
}
