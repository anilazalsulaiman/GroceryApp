package testCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constants;
import elementRepository.LoginPage;
import utilities.GeneralUtilities;

public class LoginTestCases extends BaseClass { // inheritance
	LoginPage lp;

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void verify_LoginButton_text() {
		lp = new LoginPage(driver);
		String exepectedResult = "Sign In";
		String actualResult = lp.signInText();
		Assert.assertEquals(actualResult, exepectedResult, "Not matching");
	}

	@Test
	public void verify_login_button_bG_color() {
		lp = new LoginPage(driver);
		String exepectedResult = Constants.loginButton_Background_color;
		String actualResult = lp.signin_button_BG_color();
		Assert.assertEquals(actualResult, exepectedResult, Constants.error_message);
	}

	@Test(dataProvider = "data-provider", dataProviderClass = DataProvider_Credentials.class)
	public void verify_login_Credentials(String type, String a, String b) throws InterruptedException {
		lp = new LoginPage(driver);
		lp.enter_username(a);
		lp.enter_password(b);
		lp.click_SignInButton();
		if (type.equals("valid")) {
			String actual = lp.verify_Login_validCredentials_Using_Dataprovider();
			String expected = "7rmart supermarket";
			Assert.assertEquals(actual, expected, "not matching");
		} else if (type.equals("invalid")) {
			String actual = lp.verify_Login_invalidCredentials_Using_Dataprovider();
			String expected = "Alert!";
			Assert.assertEquals(actual, expected, "not matching");
		}

	}

}
