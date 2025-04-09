package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;


public class SubCategoriesPage {
	public WebDriver driver;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newButton;
	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement category;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement subCategory;
	@FindBy(xpath = "//input[@type='file']")
	private WebElement fileUpload;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;

	public SubCategoriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickNewButton() {
		newButton.click();
	}

	public void selectCategory(String category1) {
		PageUtility pageutility = new PageUtility(driver);
		pageutility.selectByVisibleText(category, category1);

	}

	public void enterSubCategory(String subCategory1) {
		subCategory.sendKeys(subCategory1);
	}

	public void insertFile(String path) {
		PageUtility pageutility = new PageUtility(driver);
		pageutility.sendKeysForUpload(fileUpload, path);
	}

	public void clickSave() {
		PageUtility pageutility=new PageUtility(driver);
				pageutility.scrollIntoView(saveButton);
		pageutility.jsClick(saveButton);
	}

	public void addNewSubCategory(String category1, String subCategory1, String path) {
		clickNewButton();
		selectCategory(category1);
		enterSubCategory(subCategory1);
		insertFile(path);
		clickSave();
	}
	public String isAlertMessageVisible()
	{
		return alert.getText();
	}

}
