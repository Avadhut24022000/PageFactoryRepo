package pfPack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import net.jodah.failsafe.internal.util.Assert;
import pfPack.base.BasePage;

public class HomePage extends BasePage{
	
	// WebElements on home page
	
	@FindBy(xpath="//div[text()=\"CRM\"]")
	public WebElement CRM;
	
	@FindBy(xpath="//div[text()=\"books\"]")
	public WebElement books;
	
	@FindBy(xpath="//div[text()=\"Motivator\"]")
	public WebElement Motivator;
	
	// we can add many more web elements 
	
	public HomePage(WebDriver driver, ExtentTest eTest) {
		this.driver=driver;
		this.eTest=eTest;
	}
	
		// reusable method of home page
		
   	public boolean verifyDisplayOfHomePage() {
			boolean displayStatus=isElementPresent(CRM);  // may create bug here
		   if(displayStatus) {
			   return true;
		   }else {
			   return false;
		   }
		}
   	
   	// reusable method to get title of web page
   	
   	public String getTitle1() {
   		String title0=driver.getTitle();
   		return title0;
   	}
		
		// we can create many more reusable methods

}
