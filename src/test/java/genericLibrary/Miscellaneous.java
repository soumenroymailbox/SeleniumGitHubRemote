package genericLibrary;

import commonLibrary.SystemConfiguration;

public class Miscellaneous extends SystemConfiguration
{

	public String firstWord(String sentence)
	{
		for(int i = 0; i < sentence.length(); i++)
		{
			if(sentence.charAt(i) == ' ')
			{
				return sentence.substring(0, i);
			}
		}
		return sentence; 
	}   


	public int stringToNumber(String sentence)
	{
		int number = Integer.parseInt(sentence);
		return number;
	}



	public String basicProductsAttributeLabels(int index)
	{

		String options = null;
		switch (index)
		{
			case 1: options = "Product Name";
			break;
			case 2: options = "Manufacturer Name";
			break;
			case 3: options = "Price";
			break;
			
		}
		return options;
	}


	public void scrollExperience()
	{

		/**
		//Scroll up to an element (using scrollintoView)
		jExecutor.executeScript("arguments[0].scrollIntoView(true);",ViewMoreProductLink);

		//Scroll until the bottom of the pages (using scrollHeight)
		jExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight, args)");


		//Scroll dynamically for loading pages (loop)

		long initialHeight = (long)(jExecutor.executeScript("document.body.scrollHeight"));
		while(true)
		{
			long currentHeight = (long)jExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			if(initialHeight==currentHeight)
			{
				break;
			}
			initialHeight=currentHeight;
		}

		 **/



		/**		

		loadMoreProducts: 
			for(;;)
			{
				int initialSearchIndex = getCountProductManufacturerPrice.size();
				System.out.println("Intitial "+initialSearchIndex);

				action.moveToElement(LastElement).perform();
				wait.until(ExpectedConditions.visibilityOf(LastElement));

//				jExecutor.executeScript("window.scrollBy(0,2000)");
				jExecutor.executeScript("arguments[0].scrollIntoView(true);",PlaceHolderAfterLastElement);
				int currentSearchIndex = getCountProductManufacturerPrice.size();
				System.out.println("Current "+currentSearchIndex);

//				fluentWait.until(ExpectedConditions.attributeToBe(LastElement, "class", "hm-product-thumb ng-star-inserted"));
//				Thread.sleep(3000);
//				wait.until(ExpectedConditions.visibilityOf(ViewMoreProductLink));	
//				
//				
//				
				if(ViewMoreProductLink.isDisplayed())
				{
					System.out.println("Hello");
					boolean status = ViewMoreProductLink.isDisplayed();
					System.out.println("Status is "+status);
					continue loadMoreProducts;
				}	
				else
				{
					System.out.println("Hi");
					boolean status = ViewMoreProductLink.isDisplayed();
					System.out.println("Status is "+status);



				}
//				wait.until(ExpectedConditions.visibilityOf(PlaceHolderAfterLastElement));	
//				wait.until(ExpectedConditions.visibilityOf(LastElement));	
//				wait.until(ExpectedConditions.visibilityOf(ViewMoreProductLink));		
				jExecutor.executeScript("arguments[0].scrollIntoView(true);",PlaceHolderAfterLastElement);
				System.out.println("Hey");



//				boolean pStatus = AfterLastProduct.isDisplayed();
//				if (pStatus==false)
//				{
//					System.out.println(pStatus);
//					break;
//				}
			}




		//				else 
		//				{	
		//					wait.until(ExpectedConditions.attributeToBe(LastElement, "class", "hm-product-thumb ng-star-inserted"));
		//				wait.until(ExpectedConditions.attributeToBe(By.id("my-element-id"), "atrributeNameString", "attributeValueString"));
		//				wait.until(ExpectedConditions.invisibilityOf(ViewMoreProductLink));
		//					break;               
		//				}



}	


		 */	

	}

}
