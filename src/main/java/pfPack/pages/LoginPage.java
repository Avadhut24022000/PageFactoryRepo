package pfPack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pfPack.base.BasePage;
import pfPack.util.Constants;

public class LoginPage extends BasePage{

	// WebElements on Login page

	@FindBy(id = "login_id")
	public WebElement Email;

	@FindBy(id = "nextbtn")
	public WebElement NextButton;

	@FindBy(id = "password")
	public WebElement Password;

	@FindBy(id = "nextbtn")
	public WebElement SignInButton;

	// we can add many more web elements

	public LoginPage(WebDriver driver, ExtentTest eTest) {
		this.driver = driver;
		this.eTest = eTest;
	}

	// reusable method of Login page

	public boolean doLogin() {

		Email.sendKeys(Constants.USERNAME);
		eTest.log(LogStatus.INFO, "Email Id Entered Successfully");
		
		NextButton.click();
		eTest.log(LogStatus.INFO, "Next Button got Clicked Successfully");
		
		Password.sendKeys(Constants.PASSWORD);
		eTest.log(LogStatus.INFO, "Password Entered Successfully");
		
		SignInButton.click();
		eTest.log(LogStatus.INFO, "Sign In Button Clicked Successfully");

		HomePage homePage = new HomePage(driver, eTest);
		PageFactory.initElements(driver, homePage);
		
		boolean loginStatus=homePage.verifyDisplayOfHomePage();
		
		return loginStatus;

//		boolean loginStatus = homePage.verifyDisplayOfHomePage();

//		return loginStatus;

	}

	// we can create many more reusable methods

}
