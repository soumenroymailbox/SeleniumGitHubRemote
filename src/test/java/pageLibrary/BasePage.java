package pageLibrary;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonLibrary.SystemConfiguration;


public class BasePage extends SystemConfiguration
{
	public BasePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebDriverWait wait=new WebDriverWait(driver, 80);
	
	public Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(20))
			.pollingEvery(Duration.ofSeconds(2))
			.withMessage("This is Custom Message")
			.ignoring(NoSuchElementException.class);
	
	public static Actions action = new Actions(driver);
	
	public String HomePage = "https://scout-qa.atlasdigitalsuite.com/Home";
	public String ProductsPage = "https://scout-qa.atlasdigitalsuite.com/Products";
	public String PlanningIdeasPage = "https://scout-qa.atlasdigitalsuite.com/PlanningIdeas";
	public String ProjectsPage = "https://scout-qa.atlasdigitalsuite.com/ProjectManager";
	public String BoardsPage = "https://scout-qa.atlasdigitalsuite.com/BoardManager";
	public String SupportPage = "https://scout-qa.atlasdigitalsuite.com/Support";
	public String ChatPage = "https://scout-qa.atlasdigitalsuite.com/chat.html";
	
	
	@FindBy(xpath="html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[1]/button[1]")
	public WebElement logoutButton;
	
	@FindBy(xpath="//*[@class='hm-home-projects']//div[3]")
	public WebElement HomePageLoad;
	
	@FindBy(xpath="//*[@class='hm-total-results ng-star-inserted']//ancestor::div[@class='hm-main-content']//*[@class='products']")
	public WebElement ProductsPageLoad;
	
	@FindBy(xpath="")
	public WebElement PlanningIdeasPageLoad;
	
	@FindBy(xpath="")
	public WebElement ProjectsPageLoad;
	
	@FindBy(xpath="")
	public WebElement BoardsPageLoad;
	
	@FindBy(xpath="")
	public WebElement SupportPageLoad;
	
	@FindBy(xpath="")
	public WebElement ChatPageLoad;
	
	public WebElement getElementByXpathContainsText(String text)
	{
		return driver.findElement(By.xpath(text));
	}
	
	public void logout()
	{
		logoutButton.click();
	}
	
	public void scrollToElement(WebElement element) 
	{ 
        jExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
	
	public void windowReSize(int widthPixel,int heightPixel )
	{
		Dimension dimen = new Dimension(widthPixel,heightPixel);
        //Resize the current window to the given dimension
        driver.manage().window().setSize(dimen);
        System.out.println(driver.manage().window().getSize());
        driver.manage().timeouts().implicitlyWait(130, TimeUnit.SECONDS);
	}
}
