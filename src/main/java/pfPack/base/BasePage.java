package pfPack.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

public class BasePage {
	public WebDriver driver;
	public ExtentTest eTest;
	
	public boolean isElementPresent(WebElement element) {
		if(element.isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	
}
