package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	@FindBy(xpath = "//a[@class='d-block']")
	private WebElement profileName;
	@FindBy(xpath = "//p[text()='Admin Users']//following::a[@href=\"https://groceryapp.uniqassosiates.com/admin/list-admin\"]")
	private WebElement adminUserLink;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[4]")
	private WebElement subCategoriesLink;
	@FindBy(xpath = "//img[@class='img-circle elevation-2']")
	private WebElement image;
	@FindBy(xpath="//span[@class='brand-text font-weight-light']")
	private WebElement title;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProfileName() {
		return profileName.getText();
	}

	public AdminUserPage navigateToAdminUsers() {
		adminUserLink.click();
		return new AdminUserPage(driver);
	}

	public void navigateToSubCategoriesPage() {
		subCategoriesLink.click();
	}
	
	public boolean isImageDisplayed()
	{
		return image.isDisplayed();
	}
	public String getTitleName()
	{
		return title.getText();
	}

}
