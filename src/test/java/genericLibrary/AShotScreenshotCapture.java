package genericLibrary;

import java.io.File;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;

import commonLibrary.SystemConfiguration;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class AShotScreenshotCapture extends SystemConfiguration
{


	public static String captureFullPageScreenShotOnFailure(WebDriver driver, String screenShotName) throws Exception
	{
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		String dest = newResultDir + "/AShotScreenshots/" + screenShotName + ".png";
		ImageIO.write(screenshot.getImage(),"PNG",new File(dest));
		return dest;
	}
}
