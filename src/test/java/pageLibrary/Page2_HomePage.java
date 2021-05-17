package pageLibrary;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import genericLibrary.ApachePOIExcelLibrary;
import genericLibrary.HighlightWebElement;
import genericLibrary.TakesScreenshotCapture;

public class Page2_HomePage extends BasePage
{
	public Page2_HomePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	String excelPath = ApachePOIExcelLibrary.testDataPath +"WelcomePageData.xlsx";

	@FindBy(xpath="//img[@alt='Dealer Logo']")  
	private WebElement HermanMillerLogo;

	/* *******************************************************************************/
	
	@FindBy(xpath="//*[@class='search-bar']")
	private WebElement SearchContainer;

	@FindBy(xpath="//*[@role='listbox']")
	private WebElement SearchContainerListbox;

	@FindBy(xpath="//*[@name='header-search']")
	private WebElement SearchContainerInputField;

	@FindBy(xpath="//*[@role='option']//span")
	private List<WebElement> SearchContainerListboxAllOptions;
	
	@FindBy(xpath="//hm-search-bar//mat-icon[@role= 'img' and text()='search']")
	private WebElement SearchButton;

	@FindBy(xpath="//*[@class='hm-breadcrumb ng-star-inserted'][contains(normalize-space(), 'Results for')]")
	private WebElement EnteredSearchCriteria;
	
	@FindBy(xpath="//*[@class='hm-breadcrumb ng-star-inserted'][contains(normalize-space(), 'Results for')]//span")
	private WebElement EnteredSearchCriteriaData;
		
	@FindBy(xpath="//*[@class='products' or @class='planning-ideas']")
	private WebElement SearchResultLoad;
	
	@FindBy(xpath="//*[@class='hm-product-thumb ng-star-inserted' or @class='planning-idea-search-result ng-star-inserted']")
	private List<WebElement> SearchResultList;
	
	
	@FindBy(xpath="//*[@class='hm-product-name' or @class='planning-idea-option-name']")
	private List<WebElement> SearchResultNameList;
	
	@FindBy(xpath="//*[@class='products' or @class='results']")
	private WebElement AfterSearchLoad;
	
	@FindBy(xpath="//*[@role='img' and text()='cancel']")
	private WebElement SearchCancelButton;
	
	public WebElement getSearchDropDownXpath(String text)
	{
		String xPathData = "//*[@role='option']//span[text()='"+text+"']";
		return driver.findElement(By.xpath(xPathData));
	}
	
	/* *******************************************************************************/
	
	@FindBy(xpath="//*[@id='header-navigation']")
	private WebElement HeaderNavigation;

	@FindBy(xpath="//*[@id='header-products-nav' and normalize-space()='Products']")
	private WebElement HeaderNavigation_Products;

	@FindBy(xpath="//*[@id='header-planning-ideas-nav' and normalize-space()='Planning Ideas']")
	private WebElement HeaderNavigation_PlanningIdeas;

	@FindBy(xpath="//*[@id='header-projects-nav' and normalize-space()='Projects']")
	private WebElement HeaderNavigation_Projects;

	@FindBy(xpath="//*[@id='header-baords-nav' and normalize-space()='Boards']")
	private WebElement HeaderNavigation_Boards;

	@FindBy(xpath="//*[@id='header-navigation']//div")
	private List<WebElement> HeaderNavigationAllItems;

	@FindBy(xpath="//div[@class='mat-menu-trigger user-thumbnail hover-background']")
	private WebElement UserThumbnail;

	@FindBy(xpath="//div[@id='mat-menu-panel-1']")
	private WebElement UserThumbnailcontainer;

	@FindBy(xpath="//div[@id='mat-menu-panel-1']//button//span")
	private List<WebElement> UserThumbnailButtons;

	@FindBy(xpath="//*[@alt='Support Chat']")
	private WebElement SupportChatIcon;

	@FindBy(xpath="//button[@mattooltip='Support']")
	private WebElement SupportIcon;

	@FindBy(xpath="//*[@id='header-announcements']")
	private WebElement WhatsNewIcon;

	@FindBy(xpath="//*[contains(text(),'Browse by Category')]")
	private WebElement BrowseByCategoryLabel;

	@FindBy(xpath="//*[@id='header-announcements']")
	private WebElement BrowseByCategoryLabelOption;

	@FindBy(xpath="//*[@class='hm-home-categories']//div[@class='hm-home-category ng-star-inserted']//div[@class='hm-home-category-name']")
	private List<WebElement> BrowseByCategoryLabelOptions;

	@FindBy(xpath="//*[@class='hm-home-category-name'and normalize-space()='Systems Furniture']")
	private WebElement BrowseByCategoryLabelLastOption;

	@FindBy(xpath="//*[@class='hm-home-categories']//ancestor::div[@class='ps-content'][1]//following-sibling::div[@class='ps__rail-y']//div")
	private WebElement BrowseByCategoryVerticalScrollBar;

	//@FindBy(xpath="//*[@class='hm-home-categories']//ancestor::div[@class='ps-content'][1]//following-sibling::div[@class='ps__rail-x']//div")
	//private WebElement BrowseByCategoryHorizontalScrollBar;

	@FindBy(xpath="//*[@class='hm-home-content']//div[text()='Browse by Category']/following-sibling::div[@class='hm-home-scrollbox']//perfect-scrollbar/div//div[@class='ps__thumb-x']")
	private WebElement BrowseByCategoryHorizontalScrollBar;
	
	@FindBy(xpath="//*[contains(text(),'View All Products')]")
	private WebElement BrowseByCategoryViewAllProductsLink;

	@FindBy(xpath="//*[contains(text(),'Browse by Brand')]")
	private WebElement BrowseByBrandLabel;

	@FindBy(xpath="//*[contains(text(),'View All Brands')]")
	private WebElement BrowseByBrandsViewAllBrandsLink;

	@FindBy(xpath="//*[@label='Tier 1 Brands']")
	private WebElement BrowseByBrandsTier1BrandsLabel;

	@FindBy(xpath="//*[@label='Tier 2 Brands']")
	private WebElement BrowseByBrandsTier2BrandsLabel;

	@FindBy(xpath="//*[@label='Tier 3 Brands']")
	private WebElement BrowseByBrandsTier3BrandsLabel;

	@FindBy(xpath="//*[@class='hm-thumb-groups-list']//*[@class='hm-thumb-group-label']")
	private List<WebElement> BrowseByBrandsTiersList;

	@FindBy(xpath="//*[@label='Tier 1 Brands']//hm-manufacturer-thumb[1]//img")
	private WebElement BrowseByBrandsLoads;

	public WebElement getBrowseByCategoryOptionXpath(String text)
	{
		String specificBrowseByCategoryOption = "//*[@class='hm-home-category-name'and normalize-space()='"+text+"']";
		return driver.findElement(By.xpath(specificBrowseByCategoryOption));
	}

	@FindBy(xpath="//*[@label='Tier 1 Brands']//div[@class='hm-thumb-label']")
	private List<WebElement> BrowseByBrandsTiers1List;

	@FindBy(xpath="//*[@label='Tier 2 Brands']//div[@class='hm-thumb-label']")
	private List<WebElement> BrowseByBrandsTiers2List;

	@FindBy(xpath="//*[@label='Tier 3 Brands']//div[@class='hm-thumb-label']")
	private List<WebElement> BrowseByBrandsTiers3List;

	public WebElement getBrowseByBrandsTiersXpath(String text)
	{
		String xPathData = "//*[@label='"+text+"']//div[@class='hm-thumb-label']";
		return driver.findElement(By.xpath(xPathData));
	}
	
	@FindBy(xpath="//*[contains(text(),'Recent Projects')]")
	private WebElement RecentProjectsLabel;
	
	@FindBy(xpath="//*[contains(text(),'Recent Boards')]")
	private WebElement RecentBoardsLabel;
	
	@FindBy(xpath="//*[contains(text(),'View All Projects')]")
	private WebElement RecentProjectsViewProjectsLink;
	
	@FindBy(xpath="//*[normalize-space()='Create a new project']")
	private WebElement RecentProjectsCreateNewProjectLink;
	
	@FindBy(xpath="//*[contains(text(),'View All Boards')]")
	private WebElement RecentBoardsViewBoardsLink;

	@FindBy(xpath="//*[normalize-space()='Create a new board']")
	private WebElement RecentBoardsCreateNewBoardLink;
	
	@FindBy(xpath="//*[@class='hm-home-categories']//*[@class='hm-home-category ng-star-inserted']")
	private List<WebElement> BrowseByCategoryList;
	
//	public WebElement getBrowseByCategoryOptionXpath(int index)
//	{
//		String xPathData = "//*[@label='"+text+"']//div[@class='hm-thumb-label']";
//		return driver.findElement(By.xpath(xPathData));
//	}
	
	public void verifyApplicationHeaderComponents() 
	{
		String methodName = new Object() {} .getClass().getEnclosingMethod().getName();
		wait.until(ExpectedConditions.visibilityOf(HomePageLoad));
		wait.until(ExpectedConditions.visibilityOf(UserThumbnail));
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName+" Started Executing From PAGE Class", ExtentColor.GREY));

		Assert.assertEquals(HermanMillerLogo.isDisplayed(), true,"Herman Miller Logo is Not Displayed");
		HighlightWebElement.highlightElement(HermanMillerLogo);
		extentTest.log(Status.PASS, MarkupHelper.createLabel("Herman Miller Logo Displayed" , ExtentColor.TRANSPARENT));
		
		
		Assert.assertEquals(SearchContainer.isDisplayed(), true,"Search Container is Not Displayed");
		Assert.assertEquals(SearchContainerInputField.isEnabled(), true, "Search Input Field Disabled");
		Assert.assertEquals(SearchContainerListbox.isEnabled(), true, "Search Listbox Dropdown Disabled");
		HighlightWebElement.highlightElement(SearchContainer);
		extentTest.log(Status.PASS, MarkupHelper.createLabel("Search Container is Displayed" , ExtentColor.TRANSPARENT));
		SearchContainerListbox.click();
		extentTest.log(Status.INFO, MarkupHelper.createLabel(SearchContainerListboxAllOptions.size() +" No of Search are getting Displayed" , ExtentColor.TRANSPARENT));
		for (int i=0; i<SearchContainerListboxAllOptions.size();i++)
		{
			extentTest.log(Status.INFO, MarkupHelper.createLabel("Search Option "+(i+1)+" is : "+SearchContainerListboxAllOptions.get(i).getText() , ExtentColor.TRANSPARENT));
			HighlightWebElement.highlightElement(SearchContainerListboxAllOptions.get(i));
		}
		SearchContainerListbox.sendKeys(Keys.ESCAPE);
		extentTest.log(Status.PASS, MarkupHelper.createLabel("Search Container Listbox Items and Input Field is Displayed" , ExtentColor.TRANSPARENT));

		Assert.assertEquals(HeaderNavigation.isDisplayed(), true,"Header Navigation Section is Not Displayed");
		HighlightWebElement.highlightElement(HeaderNavigation);
		extentTest.log(Status.INFO, MarkupHelper.createLabel(HeaderNavigationAllItems.size() +" No of Items are getting Displayed" , ExtentColor.TRANSPARENT));
		for (int i=0; i<HeaderNavigationAllItems.size();i++)
		{
			extentTest.log(Status.INFO, MarkupHelper.createLabel("Header Option "+(i+1)+" is : "+HeaderNavigationAllItems.get(i).getText() , ExtentColor.TRANSPARENT));
			HighlightWebElement.highlightElement(HeaderNavigationAllItems.get(i));
		}
		extentTest.log(Status.PASS, MarkupHelper.createLabel("Different Tabs Items are Displayed" , ExtentColor.TRANSPARENT));
		
		wait.until(ExpectedConditions.visibilityOf(UserThumbnail));
		Assert.assertEquals(UserThumbnail.isDisplayed(), true,"User Thumbnail is Not Displayed");
		HighlightWebElement.highlightElement(UserThumbnail);
		@SuppressWarnings("unused")
		String UserName = UserThumbnail.getText();
//		Assert.assertEquals(UserName, "SR","Logged In a Different User");
		UserThumbnail.click();

		Assert.assertEquals(UserThumbnailcontainer.isDisplayed(), true,"User Thumbnail is Not Displayed");
		extentTest.log(Status.INFO, MarkupHelper.createLabel(UserThumbnailButtons.size() +" No of Buttons are getting Displayed" , ExtentColor.TRANSPARENT));
		for (int i=0; i<UserThumbnailButtons.size();i++)
		{
			extentTest.log(Status.INFO, MarkupHelper.createLabel("Button Option "+(i+1)+" is : "+UserThumbnailButtons.get(i).getText() , ExtentColor.TRANSPARENT));
			HighlightWebElement.highlightElement(UserThumbnailButtons.get(i));
		}
		jExecutor.executeScript("arguments[0].click()", UserThumbnail);
		extentTest.log(Status.PASS, MarkupHelper.createLabel("Different Buttons are Displayed Under Account Icon" , ExtentColor.TRANSPARENT));

		wait.until(ExpectedConditions.visibilityOf(SupportChatIcon));
		action.moveToElement(SupportChatIcon).perform();
		String SupportChatToolTipText = SupportChatIcon.getAttribute("mattooltip");
		HighlightWebElement.highlightElement(SupportChatIcon);
		Assert.assertEquals(SupportChatToolTipText, "Support Chat","Support Chat Tool-tip Text is Not Matching");
		extentTest.log(Status.PASS, MarkupHelper.createLabel("Support Chat Icon is Displayed with Tooltip-Text" , ExtentColor.TRANSPARENT));

		action.moveToElement(SupportIcon).perform();
		String SupportToolTipText = SupportIcon.getAttribute("aria-label");
		HighlightWebElement.highlightElement(SupportChatIcon);
		Assert.assertEquals(SupportToolTipText, "Support","Support Tool-tip Text is Not Matching");
		extentTest.log(Status.PASS, MarkupHelper.createLabel("Support Icon is Displayed with Tooltip-Text" , ExtentColor.TRANSPARENT));

		action.moveToElement(WhatsNewIcon).perform();
		String WhatsNewIconToolTipText = WhatsNewIcon.getAttribute("aria-label");
		HighlightWebElement.highlightElement(WhatsNewIcon);
		Assert.assertEquals(WhatsNewIconToolTipText, "What's New","What's New Tool-tip Text is Not Matching");
		extentTest.log(Status.PASS, MarkupHelper.createLabel("What's New Icon is Displayed with Tooltip-Text" , ExtentColor.TRANSPARENT));

		extentTest.log(Status.PASS, MarkupHelper.createLabel(methodName+" Completed Executing From PAGE Class", ExtentColor.GREY));
		TakesScreenshotCapture.customSnapshot(methodName);
	}

	public void verifyBrowseByCategoryComponents()
	{
		String methodName = new Object() {} .getClass().getEnclosingMethod().getName();
		wait.until(ExpectedConditions.visibilityOf(BrowseByCategoryLabel));
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName+" Started Executing From PAGE Class", ExtentColor.GREY));
		ApachePOIExcelLibrary objExcel = new ApachePOIExcelLibrary(excelPath, 0);

		jExecutor.executeScript("arguments[0].scrollIntoView();", BrowseByCategoryViewAllProductsLink);
		Assert.assertEquals(BrowseByCategoryLabel.isDisplayed(), true,"Browse By Category Label is Not Displayed");
		HighlightWebElement.highlightElement(BrowseByCategoryLabel);
		extentTest.log(Status.PASS, MarkupHelper.createLabel("Browse By Category Label Displayed" , ExtentColor.TRANSPARENT));

		Assert.assertEquals(BrowseByCategoryViewAllProductsLink.isDisplayed(), true,"View All Products Link is Not Displayed");
		Assert.assertEquals(BrowseByCategoryViewAllProductsLink.isEnabled(), true,"View All Products Link is Not Clickable");
		HighlightWebElement.highlightElement(BrowseByCategoryViewAllProductsLink);
		extentTest.log(Status.PASS, MarkupHelper.createLabel("View All Products Link Displayed & Clickable" , ExtentColor.TRANSPARENT));

		BrowseByCategoryHorizontalScrollBar.click();
		wait.until(ExpectedConditions.visibilityOf(BrowseByCategoryHorizontalScrollBar));
		action.clickAndHold(BrowseByCategoryHorizontalScrollBar).moveByOffset(1, 0).release().perform();
		Assert.assertEquals(BrowseByCategoryHorizontalScrollBar.isDisplayed(), true,"Browse By Category Horizontal ScrollBar is Not Displayed");
		HighlightWebElement.highlightElement(BrowseByCategoryHorizontalScrollBar);
		extentTest.log(Status.PASS, MarkupHelper.createLabel("Browse By Category Horizontal ScrollBar is Displayed" , ExtentColor.TRANSPARENT));

		extentTest.log(Status.INFO, MarkupHelper.createLabel(BrowseByCategoryLabelOptions.size() +" No of Browse By Category are getting Displayed" , ExtentColor.TRANSPARENT));
		Assert.assertEquals(BrowseByCategoryLabelOptions.size(), objExcel.getRowCount(), "Number of Categories is Not Matching With Excel");
		for (int i=0; i<BrowseByCategoryLabelOptions.size();i++)
		{
			String BrowseByCategoryOptionTextFromExcel = objExcel.getCellData(i, 0);
			WebElement BrowseByCategoryOptionElement = getBrowseByCategoryOptionXpath(BrowseByCategoryOptionTextFromExcel);
			String BrowseByCategoryOptionTextFromApplication = BrowseByCategoryLabelOptions.get(i).getText();
			extentTest.log(Status.INFO, MarkupHelper.createLabel("Browse By Category Option "+(i+1)+" is : "+BrowseByCategoryOptionTextFromApplication , ExtentColor.TRANSPARENT));
			action.clickAndHold(BrowseByCategoryHorizontalScrollBar).moveByOffset(4, 0).moveToElement(BrowseByCategoryOptionElement).release().perform();
			wait.until(ExpectedConditions.visibilityOf(BrowseByCategoryOptionElement));
			Assert.assertEquals(BrowseByCategoryOptionTextFromApplication, BrowseByCategoryOptionTextFromExcel, BrowseByCategoryOptionTextFromApplication+ " is Not Matching With Excel");	
			HighlightWebElement.highlightElement(BrowseByCategoryLabelOptions.get(i));
		}
		
		extentTest.log(Status.PASS, MarkupHelper.createLabel(methodName+" Completed Executing From PAGE Class", ExtentColor.GREY));
		TakesScreenshotCapture.customSnapshot(methodName);
	}
	
	public void verifyBrowseByBrandsComponents() 
	{
		String methodName = new Object() {} .getClass().getEnclosingMethod().getName();
		wait.until(ExpectedConditions.visibilityOf(BrowseByBrandsLoads));
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName+" Started Executing From PAGE Class", ExtentColor.GREY));
		ApachePOIExcelLibrary objExcel = new ApachePOIExcelLibrary(excelPath, 1);

		jExecutor.executeScript("arguments[0].scrollIntoView();", BrowseByBrandsViewAllBrandsLink);
		Assert.assertEquals(BrowseByBrandLabel.isDisplayed(), true,"Browse By Brands Label is Not Displayed");
		HighlightWebElement.highlightElement(BrowseByBrandLabel);
		extentTest.log(Status.PASS, MarkupHelper.createLabel("Browse By Brands Label Displayed" , ExtentColor.TRANSPARENT));

		Assert.assertEquals(BrowseByBrandsViewAllBrandsLink.isDisplayed(), true,"View All Brands Link is Not Displayed");
		Assert.assertEquals(BrowseByBrandsViewAllBrandsLink.isEnabled(), true,"View All Brands Link is Not Clickable");
		HighlightWebElement.highlightElement(BrowseByBrandsViewAllBrandsLink);
		extentTest.log(Status.PASS, MarkupHelper.createLabel("View All Brands Link Displayed & Clickable" , ExtentColor.TRANSPARENT));

		extentTest.log(Status.INFO, MarkupHelper.createLabel(BrowseByBrandsTiersList.size() +" No of Browse By Brands are getting Displayed" , ExtentColor.TRANSPARENT));
		Assert.assertEquals(BrowseByBrandsTiersList.size(), objExcel.getRowCount(), "Number of Brands is Not Matching With Excel");
		for (int i=0; i<BrowseByBrandsTiersList.size();i++)
		{
			String BrowseByBrandsTextFromExcel = objExcel.getCellData(i, 0);
			WebElement BrowseByBrandsOptionElement = getBrowseByBrandsTiersXpath(BrowseByBrandsTextFromExcel);
			String BrowseByBrandsTextFromApplication = BrowseByBrandsTiersList.get(i).getText();
			extentTest.log(Status.INFO, MarkupHelper.createLabel("Browse By Brands List "+(i+1)+" is : "+BrowseByBrandsTextFromApplication , ExtentColor.TRANSPARENT));

			wait.until(ExpectedConditions.visibilityOf(BrowseByBrandsOptionElement));
			Assert.assertEquals(BrowseByBrandsTextFromApplication, BrowseByBrandsTextFromExcel, BrowseByBrandsTextFromApplication+ " is Not Matching With Excel");	
			HighlightWebElement.highlightElement(BrowseByBrandsTiersList.get(i));

			List<WebElement> tiersBrands =  driver.findElements(By.xpath("//*[@label='"+BrowseByBrandsTextFromApplication+"']//div[@class='hm-thumb-label']"));
			Iterator<WebElement> iterator = tiersBrands.iterator();
			while(iterator.hasNext()) 
			{
				WebElement tempWebElement = iterator.next();
				HighlightWebElement.highlightElement(tempWebElement);
				String  tiersBrandsName = tempWebElement.getText();
				extentTest.log(Status.INFO, MarkupHelper.createLabel(BrowseByBrandsTextFromApplication+" : Label Name is : "+tiersBrandsName , ExtentColor.TRANSPARENT));
			}
		}
		
		extentTest.log(Status.PASS, MarkupHelper.createLabel(methodName+" Completed Executing From PAGE Class", ExtentColor.GREY));
		TakesScreenshotCapture.customSnapshot(methodName);
	}

	public void verifyRecentProjectsComponents()
	{
		String methodName = new Object() {} .getClass().getEnclosingMethod().getName();
		wait.until(ExpectedConditions.visibilityOf(BrowseByBrandsLoads));
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName+" Started Executing From PAGE Class", ExtentColor.GREY));
		
		jExecutor.executeScript("arguments[0].scrollIntoView();", RecentProjectsCreateNewProjectLink);
		Assert.assertEquals(RecentProjectsLabel.isDisplayed(), true,"Recent Projects Label is Not Displayed");
		HighlightWebElement.highlightElement(RecentProjectsLabel);
		extentTest.log(Status.PASS, MarkupHelper.createLabel("Recent Projects Label Displayed" , ExtentColor.TRANSPARENT));
		
		Assert.assertEquals(RecentProjectsViewProjectsLink.isDisplayed(), true,"View All Projects Link is Not Displayed");
		Assert.assertEquals(RecentProjectsViewProjectsLink.isEnabled(), true,"View All Projects Link is Not Clickable");
		HighlightWebElement.highlightElement(RecentProjectsViewProjectsLink);
		extentTest.log(Status.PASS, MarkupHelper.createLabel("View All Projects Link Displayed & Clickable" , ExtentColor.TRANSPARENT));
		
		Assert.assertEquals(RecentProjectsCreateNewProjectLink.isDisplayed(), true,"Create New Project Link is Not Displayed");
		Assert.assertEquals(RecentProjectsCreateNewProjectLink.isEnabled(), true,"Create New Project Link is Not Clickable");
		HighlightWebElement.highlightElement(RecentProjectsCreateNewProjectLink);
		extentTest.log(Status.PASS, MarkupHelper.createLabel("Create New Project Link Displayed & Clickable" , ExtentColor.TRANSPARENT));
		
		TakesScreenshotCapture.customSnapshot(methodName);
	}
	
	public void verifyRecentBoardsComponents()
	{
		String methodName = new Object() {} .getClass().getEnclosingMethod().getName();
		wait.until(ExpectedConditions.visibilityOf(BrowseByBrandsLoads));
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName+" Started Executing From PAGE Class", ExtentColor.GREY));
		
		jExecutor.executeScript("arguments[0].scrollIntoView();", RecentBoardsCreateNewBoardLink);
		Assert.assertEquals(RecentBoardsLabel.isDisplayed(), true,"Recent Projects Label is Not Displayed");
		HighlightWebElement.highlightElement(RecentBoardsLabel);
		extentTest.log(Status.PASS, MarkupHelper.createLabel("Recent Projects Label Displayed" , ExtentColor.TRANSPARENT));
		
		Assert.assertEquals(RecentBoardsViewBoardsLink.isDisplayed(), true,"View All Boards Link is Not Displayed");
		Assert.assertEquals(RecentBoardsViewBoardsLink.isEnabled(), true,"View All Boards Link is Not Clickable");
		HighlightWebElement.highlightElement(RecentBoardsViewBoardsLink);
		extentTest.log(Status.PASS, MarkupHelper.createLabel("View All Boards Link Displayed & Clickable" , ExtentColor.TRANSPARENT));
		
		Assert.assertEquals(RecentBoardsCreateNewBoardLink.isDisplayed(), true,"Create New Board Link is Not Displayed");
		Assert.assertEquals(RecentBoardsCreateNewBoardLink.isEnabled(), true,"Create New Board Link is Not Clickable");
		HighlightWebElement.highlightElement(RecentBoardsCreateNewBoardLink);
		extentTest.log(Status.PASS, MarkupHelper.createLabel("Create New Board Link Displayed & Clickable" , ExtentColor.TRANSPARENT));
		
		extentTest.log(Status.PASS, MarkupHelper.createLabel(methodName+" Completed Executing From PAGE Class", ExtentColor.GREY));
		TakesScreenshotCapture.customSnapshot(methodName);
	}
	
	public void verifySearchFunctionality(String searchOption, int sheetIndex)
	{
		String methodName = new Object() {} .getClass().getEnclosingMethod().getName();
		wait.until(ExpectedConditions.visibilityOf(BrowseByBrandsLoads));
		wait.until(ExpectedConditions.visibilityOf(HomePageLoad));
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName+" Started Executing From PAGE Class", ExtentColor.GREY));
		ApachePOIExcelLibrary objExcel = new ApachePOIExcelLibrary(excelPath, sheetIndex);
		int rowCount = objExcel.getRowCount();
		
		HighlightWebElement.highlightElement(SearchContainerListbox);
		SearchContainerListbox.click();
		extentTest.log(Status.INFO, MarkupHelper.createLabel("Clicked on the Search Option Dropdown List" , ExtentColor.TRANSPARENT));
		WebElement searchDropdownData = getSearchDropDownXpath(searchOption);
		searchDropdownData.click();
		extentTest.log(Status.INFO, MarkupHelper.createLabel(searchOption+" Selected From Dropdown List", ExtentColor.TRANSPARENT));
		wait.until(ExpectedConditions.visibilityOf(BrowseByBrandsLoads));
		for(int i=0;i<rowCount;i++)
		{
			String SearchCriteriaFromExcel = objExcel.getCellData(i, 0);
			SearchContainerInputField.sendKeys(SearchCriteriaFromExcel);
			extentTest.log(Status.INFO, MarkupHelper.createLabel(SearchCriteriaFromExcel + "  is Entered in Search Field" , ExtentColor.TRANSPARENT));
			wait.until(ExpectedConditions.elementToBeClickable(SearchButton));
			HighlightWebElement.highlightElement(SearchContainerInputField);
			action.doubleClick(SearchButton).perform();
			HighlightWebElement.highlightElement(SearchButton);
			extentTest.log(Status.INFO, MarkupHelper.createLabel("Clicked on Search Button" , ExtentColor.TRANSPARENT));
			
			wait.until(ExpectedConditions.visibilityOf(AfterSearchLoad));
			Assert.assertEquals(EnteredSearchCriteria.isDisplayed(),true,"Search Result is not Displayed");
			HighlightWebElement.highlightElement(EnteredSearchCriteriaData);
			extentTest.log(Status.PASS, MarkupHelper.createLabel("Search Result is Displayed" , ExtentColor.TRANSPARENT));
			HighlightWebElement.highlightElement(EnteredSearchCriteria);
			extentTest.log(Status.PASS, MarkupHelper.createLabel("Search Result Number is Displayed" , ExtentColor.TRANSPARENT));
			
			@SuppressWarnings("unused")
			String resultLabel = "\"" + EnteredSearchCriteriaData.getText() + "\"";

			extentTest.log(Status.INFO, MarkupHelper.createLabel(SearchResultList.size() +" No of Search Results are getting Displayed" , ExtentColor.TRANSPARENT));
			for (int j=0; j<SearchResultList.size();j++)
			{
				String searchResultOption = SearchResultNameList.get(j).getText();
				HighlightWebElement.highlightElement(SearchResultNameList.get(j));
				extentTest.log(Status.INFO, MarkupHelper.createLabel("Search List "+(j+1)+" is : "+searchResultOption , ExtentColor.TRANSPARENT));
			}
			Assert.assertEquals(SearchCancelButton.isDisplayed(),true,"Search Cancel Button is not Displayed");
			
			HighlightWebElement.highlightElement(SearchCancelButton);
			SearchCancelButton.click();
			wait.until(ExpectedConditions.elementToBeClickable(SearchContainerListbox));
			extentTest.log(Status.INFO, MarkupHelper.createLabel("Clicked on Search Cancel Button" , ExtentColor.TRANSPARENT));
			TakesScreenshotCapture.customSnapshot(methodName);
			
		}
		extentTest.log(Status.PASS, MarkupHelper.createLabel(methodName+" Completed Executing From PAGE Class", ExtentColor.GREY));
		TakesScreenshotCapture.customSnapshot(methodName);
		//HermanMillerLogo.click();
		driver.navigate().to(HomePage);
	}
	
	public void viewAllProducts() 
	{
		String methodName = new Object() {} .getClass().getEnclosingMethod().getName();
		wait.until(ExpectedConditions.visibilityOf(HomePageLoad));
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName+" Started Executing From PAGE Class", ExtentColor.GREY));
		Page3_ProductsPage objProductsPage = new Page3_ProductsPage(driver);
		
		jExecutor.executeScript("arguments[0].scrollIntoView();", BrowseByCategoryViewAllProductsLink);
		Assert.assertEquals(BrowseByCategoryViewAllProductsLink.isDisplayed(), true,"View All Products Link is Not Displayed");
		Assert.assertEquals(BrowseByCategoryViewAllProductsLink.isEnabled(), true,"View All Products Link is Not Clickable");
		HighlightWebElement.highlightElement(BrowseByCategoryViewAllProductsLink);
		extentTest.log(Status.PASS, MarkupHelper.createLabel("View All Products Link Displayed & Clickable" , ExtentColor.TRANSPARENT));
		BrowseByCategoryViewAllProductsLink.click();
		extentTest.log(Status.INFO, MarkupHelper.createLabel("Clicked on View All Products Link" , ExtentColor.TRANSPARENT));
		wait.until(ExpectedConditions.visibilityOf(ProductsPageLoad));
		objProductsPage.verifyAllProductResults();
		
		driver.navigate().to(HomePage);
		wait.until(ExpectedConditions.visibilityOf(HomePageLoad));
		extentTest.log(Status.PASS, MarkupHelper.createLabel(methodName+" Completed Executing From PAGE Class", ExtentColor.GREY));
		TakesScreenshotCapture.customSnapshot(methodName);
	}
	
	public void sampleMethod() 
	{
		String methodName = new Object() {} .getClass().getEnclosingMethod().getName();
		wait.until(ExpectedConditions.visibilityOf(BrowseByBrandsLoads));
		extentTest.log(Status.INFO, MarkupHelper.createLabel(methodName+" Started Executing From PAGE Class", ExtentColor.GREY));
		
		extentTest.log(Status.PASS, MarkupHelper.createLabel(methodName+" Completed Executing From PAGE Class", ExtentColor.GREY));
	}
}
