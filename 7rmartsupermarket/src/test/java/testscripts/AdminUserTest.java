package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import dataproviders.DataProviders;
import listeners.RetryAnalyzer;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;

import utilities.GeneralUtility;

public class AdminUserTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	AdminUserPage adminuserpage;

	@Test(groups = "smoke")
	public void verifyWhetherAbleToCreateNewUser() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		String userName = GeneralUtility.getRandomName();
		adminuserpage = homepage.navigateToAdminUsers();
		adminuserpage.addNewUser(userName, "12345", "Staff");

	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void verifyNewButtonColor() {
		adminuserpage = new AdminUserPage(driver);
		homepage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage.navigateToAdminUsers();
		String expectedButtonColor = "rgba(220, 53, 69, 1)";
		String actualButtonColor = adminuserpage.buttonColor();
		System.out.println(actualButtonColor);
		Assert.assertEquals(actualButtonColor, expectedButtonColor);
	}

	@Test(dataProvider = "userData", dataProviderClass = DataProviders.class)
	public void verifyWhetherAdminisAbletoAddUsers(String userName, String password, String userType) {
		adminuserpage = new AdminUserPage(driver);
		homepage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage.navigateToAdminUsers();
		adminuserpage.clickNewButton();
		adminuserpage.enterUserName(userName);
		adminuserpage.enterPassword(password);
		adminuserpage.selectUserType(userType);
		adminuserpage.clickNewButton();

	}

	@Test
	public void verifyActiveButtonIsDisplayed() {
		adminuserpage = new AdminUserPage(driver);
		homepage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage.navigateToAdminUsers();
		Assert.assertTrue(adminuserpage.displayActiveStatus());

	}

	@Test
	public void verifyWhetherAbleToSearchUsers() {
		adminuserpage = new AdminUserPage(driver);
		homepage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage.navigateToAdminUsers();
		String userName1 = GeneralUtility.getRandomName();
		adminuserpage.searchButtonClick(userName1, "Admin");
	}

}
