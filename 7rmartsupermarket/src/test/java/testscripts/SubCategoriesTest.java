package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoriesPage;
import utilities.GeneralUtility;

public class SubCategoriesTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	SubCategoriesPage subcategoriespage;

	@Test
	public void verifyWhetherAbleToAddNewSubCategory() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		subcategoriespage=new SubCategoriesPage(driver);
		loginpage.login();
		homepage.navigateToSubCategoriesPage();
		String subCategoryName = GeneralUtility.getRandomName();
		subcategoriespage.addNewSubCategory("Vegetables",subCategoryName , Constants.IMAGE);
		String actualResult=subcategoriespage.isAlertMessageVisible();
		String expectedResult="Sub Category Created Successfully";
		Assert.assertTrue(actualResult.contains(expectedResult));
		
	}
}
