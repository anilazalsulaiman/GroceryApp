package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.GeneralUtilities;

public class LoginPage {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // page factory
	}

	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signIn;

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alert_isPresent;

	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	WebElement check_homepage_element;

	public String signInText() {
		return gu.getElementText(signIn);
	}

	public String signin_button_BG_color() {
		return gu.getElementStyleProperties(signIn, "background-color");
	}

	public void enter_username(String read_username) {
		username.sendKeys(read_username);
	}

	public void enter_password(String read_password) {
		password.sendKeys(read_password);
	}

	public void click_SignInButton() {
		signIn.click();
	}

	public void perform_LoginPage(String username_Excel, String password_Excel) {
		enter_username(username_Excel);
		enter_password(password_Excel);
		click_SignInButton();
	}

	public String verify_Login_invalidCredentials_Using_Dataprovider() {
		return gu.getElementText(alert_isPresent);
	}

	public String verify_Login_validCredentials_Using_Dataprovider() {
		return gu.getElementText(check_homepage_element);
	}

}
