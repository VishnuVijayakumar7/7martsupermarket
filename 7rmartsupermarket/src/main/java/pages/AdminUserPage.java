package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUserPage {
	public WebDriver driver;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newbutton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password1;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement usertype;
	@FindBy(xpath = "//i[@class='fa fa-save']")
	private WebElement save;
	@FindBy(xpath = "(//span[@class='badge bg-success'])[1]")
	private WebElement active;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement search;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement searchusername;
	@FindBy(xpath = "//select[@id='ut']")
	private WebElement searchusertype;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchbutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement popup;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement popupdanger;
	@FindBy(xpath="//center[text()='.........RESULT NOT FOUND.......']")
	private WebElement searchResult;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickNewButton() {
		newbutton.click();
	}

	public void enterUserName(String userName) {
		username.sendKeys(userName);
	}

	public void enterPassword(String password) {
		password1.sendKeys(password);
	}

	public void selectUserType(String userType) {
		PageUtility pageutility = new PageUtility(driver);
		pageutility.selectByVisibleText(usertype, userType);

	}

	public void clickSaveButton() {
		save.click();
	}

	public AdminUserPage addNewUser(String userName, String password, String userType) {
		
		clickNewButton();
		enterUserName(userName);
		enterPassword(password);
		selectUserType(userType);
		clickSaveButton();
		return this;
		

	}

	public boolean displayActiveStatus() {
		return active.isDisplayed();
	}

	public String buttonColor() {
		return newbutton.getCssValue("background-color");
	}

	public void clickSearchButton() {
		search.click();
	}

	public void userNameSearch(String userName1) {
		searchusername.sendKeys(userName1);
	}

	public void selectUserTypeSearch(String userType1) {
		PageUtility pageutility = new PageUtility(driver);
		pageutility.selectByVisibleText(searchusertype, userType1);
	}

	public void searchButtonClick(String userName1, String userType1) {

		clickSearchButton();
		userNameSearch(userName1);
		selectUserTypeSearch(userType1);
		searchbutton.click();
	}

	public boolean isPopUpMessageDisplayed() {
		return popup.isDisplayed();
	}
	
	public String isDangerPopUpMessageIsDisplayed()
	{
		return popupdanger.getText();
	}
	public String showSearchResult()
	{
		WaitUtility waitutility = new WaitUtility(driver);
    	waitutility.waitForClickable(searchbutton, 20);
		return searchResult.getText();
	}

}
