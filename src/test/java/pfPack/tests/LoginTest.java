package pfPack.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pfPack.pages.LaunchPage;
import pfPack.tests.base.BaseTest;
import pfPack.util.Constants;
import pfPack.util.ExtentManager;

public class LoginTest extends BaseTest {
	@Test
	public void testLogin() {
		
		
		eTest=eReport.startTest("testLogin");    // may be return type righting fault come
		
		eTest.log(LogStatus.INFO, "Starting Login Test");
		
		openBrowser(Constants.BROWSER_TYPE);
		
		// to pass driver and eTest to LaunchPage class create object of LaunchPage class with arguments with arguments(driver,eTest)
		LaunchPage launchPage=new LaunchPage(driver, eTest);
		
		// to initialize elements on launchPage using PageFactory class in selenium API
		PageFactory.initElements(driver, launchPage);
		
		// call goToLoginPage method using object of LaunchPage class
		boolean loginStatus=launchPage.goToLoginPage();
		
		if(loginStatus) {
			reportPass("The test is passed");
		}else {
			// Fail in extent report
			reportFail("The test is failed");
			
		}
	}
	@AfterMethod
	public void testClosure() {
		if(eReport!=null) {
			// end test
		eReport.endTest(eTest);
	// pass all recorded logs in report
		eReport.flush();
		}
		if(driver!=null) {
			// close all browser windows
		driver.quit();
		}
	}

}
