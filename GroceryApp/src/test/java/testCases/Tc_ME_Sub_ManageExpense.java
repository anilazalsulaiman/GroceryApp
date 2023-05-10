package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.Repo_ME_Sub_ManageExpense;
import elementRepository.SideBarElements;
import utilities.ExcelReadUtils;

public class Tc_ME_Sub_ManageExpense extends BaseClass {
	LoginPage lp;
	Repo_ME_Sub_ManageExpense manage_exp_obj;
	SideBarElements sidebar_obj;

	@Test
	public void verify_ME_ViewMoreButton_isClickable() throws IOException {
		lp = new LoginPage(driver);
		lp.perform_LoginPage(ExcelReadUtils.readStringData(1, 0, "Sheet1"),
				ExcelReadUtils.readStringData(1, 1, "Sheet1"));
		sidebar_obj = new SideBarElements(driver);
		sidebar_obj.click_sidebar_manage_expense();
		sidebar_obj.sidebar_ME_SubManage_Expense();
		manage_exp_obj=new Repo_ME_Sub_ManageExpense(driver);
		boolean actualresult = manage_exp_obj.click_Sub_Manageexpense_ViewMore_button();
		boolean exepectedResult = true;
		Assert.assertEquals(actualresult, exepectedResult, "Result not matching");
	}
}
