package pfPack.tests.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pfPack.util.Constants;
import pfPack.util.ExtentManager;

public class BaseTest {

	public ExtentReports eReport = ExtentManager.getInstance();
	public ExtentTest eTest = null;
	public WebDriver driver = null;

	public void openBrowser(String browserType) {

		if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_EXE);
			driver = new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_EXE);
			driver = new FirefoxDriver();
		} else if (browserType.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", Constants.GECKO_DRIVER_EXE);
			driver = new EdgeDriver();
		}

		eTest.log(LogStatus.INFO, "Successfully opened " + browserType + " browser");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	public void reportPass(String message) {
		eTest.log(LogStatus.PASS, message);

	}

	public void reportFail(String message) {
		eTest.log(LogStatus.FAIL, message);
		// screenshots
		takeScreenshot();
		// fail in testNG
		Assert.fail("The test is failed");
	}
	
	public void takeScreenshot() {
		
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("screenshots//"+screenshotFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eTest.log(LogStatus.INFO,"Screenshot-> "+eTest.addScreenCapture(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
		
	}
}
