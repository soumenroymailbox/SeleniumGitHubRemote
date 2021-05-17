package pageLibrary;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import genericLibrary.HighlightWebElement;
import genericLibrary.Miscellaneous;
import genericLibrary.TakesScreenshotCapture;

public class Page3_ProductsPage extends BasePage
{
	public Page3_ProductsPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public Miscellaneous objMis = new Miscellaneous();
	
	@FindBy(xpath="//*[@class='hm-total-results ng-star-inserted']")
	private WebElement NumberOfResults;

	@FindBy(xpath="//*[@class='products']//hm-search-product-thumb")
	private List<WebElement> productsList;

	@FindBy(xpath="//mrl-products[1]/div[2]/div[1]/div[3]/div[1]")
	private WebElement ProductListVerticalScrollBar;

	public WebElement getProductList(int index)
	{
		String xPathData = "//*[@class='products']//hm-search-product-thumb["+index+"]";
		return driver.findElement(By.xpath(xPathData));
	}
	
	public WebElement getProductImage(int index)
	{
		String xPathData = "//*[@class='products']//hm-search-product-thumb["+index+"]//img";
		return driver.findElement(By.xpath(xPathData));
	}

	public WebElement getProductName(int index)
	{
		String xPathData = "//*[@class='products']//hm-search-product-thumb["+index+"]//*[@class='hm-product-name']";
		return driver.findElement(By.xpath(xPathData));
	}

	public WebElement getManufactureName(int index)
	{
		String xPathData = "//*[@class='products']//hm-search-product-thumb["+index+"]//*[@class='hm-manufacturer-name']";
		return driver.findElement(By.xpath(xPathData));
	}

	public WebElement getprice(int index)
	{
		String xPathData = "//*[@class='products']//hm-search-product-thumb["+index+"]//*[@class='hm-price ng-star-inserted']";
		return driver.findElement(By.xpath(xPathData));
	}

	public WebElement getWarrenty(int index)
	{
		String xPathData = "//*[@class='products']//hm-search-product-thumb["+index+"]//*[@mattooltip='Warranty']";
		return driver.findElement(By.xpath(xPathData));
	}

	public WebElement getLeadTime(int index)
	{
		String xPathData = "//*[@class='products']//hm-search-product-thumb["+index+"]//*[@mattooltip='Lead Time']";
		return driver.findElement(By.xpath(xPathData));
	}
	
	@FindBy(xpath="//*[@class='products']//hm-search-product-thumb")
	private List<WebElement> getCountProductManufacturerPrice;

	@FindBy(xpath="//*[@class='products']//hm-search-product-thumb//following-sibling::hm-search-product-thumb[last()]")
	private WebElement LastElement;

	@FindBy(xpath="//*[@class='products']//hm-search-product-thumb//following-sibling::hm-search-product-thumb[last()+1]")
	private WebElement AfterLastProduct;
	
	@FindBy(xpath="//*[@class='products']//hm-search-product-thumb//following-sibling::hm-search-product-thumb[last()]/following-sibling::div[@class='hm-product-thumb hm-placeholder'][1]")
	private WebElement PlaceHolderAfterLastElement;

	@FindBy(xpath="//button/span[text()='View More Products']")
	private WebElement ViewMoreProductLink;

	@FindBy(xpath="//div[@class='load-more-btn ng-star-inserted']/button")
	private WebElement ViewMoreButton;

	public WebElement getBrowseByProductCategoryOptionXpath(String text)
	{
		String specificBrowseByCategoryProductOption ="//*[contains(text(),'"+text+"')]";
		return driver.findElement(By.xpath(specificBrowseByCategoryProductOption));
	}
	
	public WebElement getBrowseByProductCategoryTopOptionXpath(String text)
	{
		String specificBrowseByCategoryProductOption ="//div[@fxshow='false']//div[normalize-space()='"+text+"']"; 
		return driver.findElement(By.xpath(specificBrowseByCategoryProductOption));
	}
	
	public void loadProductResults() 
	{
		String methodName = new Object() {} .getClass().getEnclosingMethod().getName();
		wait.until(ExpectedConditions.visibilityOf(ProductsPageLoad));
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName+" Started Executing From PAGE Class", ExtentColor.GREY));

		String productListResultsInString = objMis.firstWord(NumberOfResults.getText());
		int productListResultsInNumber = objMis.stringToNumber(productListResultsInString);
		extentTest.log(Status.INFO, MarkupHelper.createLabel(productListResultsInNumber+" Number of Results are Displayed" , ExtentColor.TRANSPARENT));
		
//		for (int i= 1; i<=productListResultsInNumber; i++)
		for (int i= 1; i<=5; i++)
		{
			action.moveToElement(getProductList(i)).perform();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			
			HighlightWebElement.highlightElement(getProductList(i));
			
			extentTest.log(Status.INFO, MarkupHelper.createLabel(i+" : Product Grid is :: "+getProductImage(i).getAttribute("alt") , ExtentColor.TRANSPARENT));
			
			List<WebElement> productBasicAttribute =  driver.findElements(By.xpath("//*[@class='products']//hm-search-product-thumb["+i+"]//*[@class='hm-product-search-thumb']/div[@class!='hm-warranty-leadtime ng-star-inserted']"));
			Iterator<WebElement> basicIterator = productBasicAttribute.iterator();
			while(basicIterator.hasNext()) 
			{
			
				WebElement tempBasicWebElement = basicIterator.next();
				String  productBasicAttributeLabel = tempBasicWebElement.getText();
				extentTest.log(Status.INFO, MarkupHelper.createLabel("Attrribute Option is : "+productBasicAttributeLabel , ExtentColor.TRANSPARENT));
			}
			
			List<WebElement> productAdditionalAttribute =  driver.findElements(By.xpath("//*[@class='products']//hm-search-product-thumb["+i+"]//*[@class='hm-product-search-thumb']/div[@class='hm-warranty-leadtime ng-star-inserted']//div"));
			Iterator<WebElement> additionalIterator = productAdditionalAttribute.iterator();
			while(additionalIterator.hasNext()) 
			{
				WebElement tempAdditionalWebElement = additionalIterator.next();
				String  productAdditionalAttributeLabel = tempAdditionalWebElement.getText();
				extentTest.log(Status.INFO, MarkupHelper.createLabel("Attrribute Option is : "+productAdditionalAttributeLabel , ExtentColor.TRANSPARENT));
			}
		}

		extentTest.log(Status.PASS, MarkupHelper.createLabel(methodName+" Completed Executing From PAGE Class", ExtentColor.GREY));
		TakesScreenshotCapture.customSnapshot(methodName);
	}

	
	public void loadBrowseByCategoryProductResults(String ProductCategory) 
	{
		String methodName = new Object() {} .getClass().getEnclosingMethod().getName();
		wait.until(ExpectedConditions.visibilityOf(ProductsPageLoad));
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName+" Started Executing From PAGE Class", ExtentColor.GREY));
		
		String productListResultsInString = objMis.firstWord(NumberOfResults.getText());
		int productListResultsInNumber = objMis.stringToNumber(productListResultsInString);
		extentTest.log(Status.INFO, MarkupHelper.createLabel(productListResultsInNumber+" Number of Results are Displayed" , ExtentColor.TRANSPARENT));
		
		extentTest.log(Status.PASS, MarkupHelper.createLabel(methodName+" Completed Executing From PAGE Class", ExtentColor.GREY));
		TakesScreenshotCapture.customSnapshot(methodName);
	}

	public void verifyAllProductResults() 
	{
		String methodName = new Object() {} .getClass().getEnclosingMethod().getName();
		wait.until(ExpectedConditions.visibilityOf(ProductsPageLoad));
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName+" Started Executing From PAGE Class", ExtentColor.GREY));
		
		loadProductResults();

		extentTest.log(Status.PASS, MarkupHelper.createLabel(methodName+" Completed Executing From PAGE Class", ExtentColor.GREY));
		TakesScreenshotCapture.customSnapshot(methodName);
	}


}
