package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import elementRepository.LoginPage;
import elementRepository.Repo_ManageProduct;
import elementRepository.Repo_PushNotifications;
import elementRepository.SideBarElements;
import utilities.ExcelReadUtils;

public class Tc_PushNotifications extends BaseClass {
	LoginPage lp;
	Repo_PushNotifications push_Notification;
	SideBarElements sidebar_obj;

	@Test
	public void verify_pushNotification_isSending() throws IOException {
		lp = new LoginPage(driver);
		lp.perform_LoginPage(ExcelReadUtils.readStringData(1, 0, "Sheet1", "LoginCredentialsExcel.xlsx"),
				ExcelReadUtils.readStringData(1, 1, "Sheet1", "LoginCredentialsExcel.xlsx"));
		sidebar_obj = new SideBarElements(driver);
		sidebar_obj.sidebar_PushNotifications();
		push_Notification = new Repo_PushNotifications(driver);
		String actualResult = push_Notification.get_pushNotification_value();
		String expectedResult = Constants.alert_expectedResult;
		Assert.assertEquals(actualResult, expectedResult, Constants.assertion_Error_Message);
	}
}
