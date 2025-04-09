package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.HomePage;
import pages.LoginPage;

public class HomeTest extends Base {
	HomePage homepage;
	LoginPage loginpage;

	@Test
	public void validateWhetherImageIsDisplayed() {
		homepage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		Assert.assertTrue(homepage.isImageDisplayed());

	}
	
	@Test
	public void verifyTitleName()
	{
	
		homepage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		String actualResult=homepage.getTitleName();
		String expectedResult="7rmart supermarket";
		Assert.assertEquals(actualResult, expectedResult);
	}
}
