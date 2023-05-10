package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constant.Constants;
import elementRepository.LoginPage;

public class LoginTestCases extends BaseClass{ //inheritance
	LoginPage lp;
	
	@Test
	public void verify_LoginButton_text() {
		lp=new LoginPage(driver);
		String exepectedResult="Sign In";
		String actualResult=lp.signInText();
		Assert.assertEquals(actualResult, exepectedResult, "Not matching");
	}
	@Test(enabled = false)
	public void verify_login_button_bG_color() {
		lp=new LoginPage(driver);
		String exepectedResult=Constants.loginButton_Background_color;
		String actualResult=lp.signin_button_BG_color();
		Assert.assertEquals(actualResult, exepectedResult,Constants.error_message);
	}
}
