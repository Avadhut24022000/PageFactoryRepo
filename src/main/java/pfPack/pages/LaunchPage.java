package pfPack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pfPack.base.BasePage;
import pfPack.util.Constants;

public class LaunchPage extends BasePage{
	
	// WebElements on Launch Page
	
	@FindBy(className="zh-customers")
	public WebElement Customers;
	
	@FindBy(className="zh-support")
	public WebElement Support;
	
	@FindBy(className="zh-contact")
	public WebElement ContactSales;
	
	@FindBy(className="zh-login")
	public WebElement SignIn;
	
	// we can add many more web elements 
	
	
	// to pass driver and eTest of BaseTest.java in LaunchPage
	public LaunchPage(WebDriver driver, ExtentTest eTest) {
		this.driver=driver;
		this.eTest=eTest;
	}
	
	// reusable method of launch page
	public boolean goToLoginPage() {
		driver.get(Constants.APP_URL);
		eTest.log(LogStatus.INFO,"Application URL "+Constants.APP_URL+" got opened");
		
		SignIn.click();
		eTest.log(LogStatus.INFO, "Login Option clicked");
		
		// to pass driver and eTest to LoginPage class create object of LoginPage class with arguments(driver,eTest)
		LoginPage loginPage=new LoginPage(driver, eTest);
		// initialize WebElements of loginPage 
		PageFactory.initElements(driver, loginPage);
		
		
		boolean loginStatus= loginPage.doLogin();
		
		return loginStatus;
	}

	// we can create many more reusable methods
}
