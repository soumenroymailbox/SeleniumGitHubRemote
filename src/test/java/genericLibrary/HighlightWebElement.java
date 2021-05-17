package genericLibrary;

import org.openqa.selenium.WebElement;

import commonLibrary.SystemConfiguration;

public class HighlightWebElement extends SystemConfiguration
{
	public static void highlightElement(WebElement element)
	{
		try 
		{
			jExecutor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: blueviolet; border: 2px solid green;");
			Thread.sleep(200);
			//js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		}
		catch(Exception e)
		{
			System.out.println("Exception Occurs During Highlight The WebElement "+e.getMessage());
		} 	
	}
}
