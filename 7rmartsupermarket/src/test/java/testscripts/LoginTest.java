package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends Base {
	LoginPage loginpage;
	HomePage homepage;

	@Test(groups = "smoke")
	public void verifyWhetherUserIsAbleToLoginUsingValidCredentials() {

		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login("admin", "admin");
		String expectedProfileName = "Admin";
		String actualProfileName = homepage.getProfileName();
		Assert.assertEquals(actualProfileName, expectedProfileName);

	}

}
