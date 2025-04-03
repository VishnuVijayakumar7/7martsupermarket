package pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver;
	Properties properties = new Properties();
	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordfield;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	private WebElement signinbutton;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterUsernameOnUsernameField(String userName) {
		usernamefield.sendKeys(userName);
	}

	public void enterPasswordOnPasswordField(String password) {
		passwordfield.sendKeys(password);
	}

	public void clickOnSigninButton() {
		WaitUtility waitutility = new WaitUtility(driver);
		waitutility.waitForClickable(signinbutton, 20);
		signinbutton.click();
	}

	public HomePage login(String userName, String password) {
		enterUsernameOnUsernameField(userName);
		enterPasswordOnPasswordField(password);
		clickOnSigninButton();
		return new HomePage(driver);
	}

	public HomePage login() {
		String userName = properties.getProperty("userName");
		String password = properties.getProperty("password");
		enterUsernameOnUsernameField(userName);
		enterPasswordOnPasswordField(password);
		clickOnSigninButton();
		return new HomePage(driver);
	}
}
