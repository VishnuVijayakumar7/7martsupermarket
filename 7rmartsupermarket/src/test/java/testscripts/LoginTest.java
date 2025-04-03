package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.GeneralUtility;
import utilities.ScreenshotCapture;

public class LoginTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
@Test(groups="smoke")
	public void verifyWhetherUserIsAbleToLoginUsingValidCredentials()
	{
	
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.login("admin", "admin");
		String expectedProfileName="Admin";
		String actualProfileName=homepage.getProfileName();
		Assert.assertEquals(actualProfileName, expectedProfileName);
		String s=GeneralUtility.getRandomName();
		System.out.println(s);
	}


}
