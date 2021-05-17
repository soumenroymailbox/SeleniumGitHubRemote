package genericLibrary;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import commonLibrary.SystemConfiguration;

public class GetOSSystemAndBrowserDetail extends SystemConfiguration
{
	@SuppressWarnings("unused")
	public GetOSSystemAndBrowserDetail()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/projectResources/browserDriversLibrary/chromedriver.exe");
		driver = new ChromeDriver();
		String browserName = browserDetails();
		String browserVersion = browserVersion();
		String platform = platform();
		String osVersion = osVersion();
		driver.quit();
	}

	public String browserDetails() 
	{
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		String bName = caps.getBrowserName().toUpperCase();
		return bName;
	}

	public String browserVersion() 
	{
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		String bVersion = caps.getVersion().toUpperCase();
		return bVersion;
	}

	public String osVersion() 
	{
		((RemoteWebDriver) driver).getCapabilities();
		String osVer = System.getProperty("os.name").toUpperCase();
		return osVer;
	}

	public String platform() 
	{
		((RemoteWebDriver) driver).getCapabilities();
		String osVer = System.getProperty("os.name").toUpperCase();
		String plat = OSDetector(osVer);
		return plat;
	}

	public static String OSDetector (String operatingSystem) 
	{
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("win")) 
		{
			return "Microsoft Windows";
		} 
		else if (os.contains("nux") || os.contains("nix"))
		{
			return "Linux";
		}
		else if (os.contains("mac")) 
		{
			return "Apple Macintosh";
		}
		else if (os.contains("sunos")) 
		{
			return "Solaris";
		}
		else
		{
			return "Unknown";
		}
	}
}
