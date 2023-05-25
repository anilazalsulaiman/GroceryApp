package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
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
		lp.perform_LoginPage(ExcelReadUtils.readStringData(1, 0, "Sheet1","LoginCredentialsExcel.xlsx"),
				ExcelReadUtils.readStringData(1, 1, "Sheet1","LoginCredentialsExcel.xlsx"));
		sidebar_obj = new SideBarElements(driver);
		sidebar_obj.click_sidebar_manage_expense();
		sidebar_obj.sidebar_ME_SubManage_Expense();
		manage_exp_obj=new Repo_ME_Sub_ManageExpense(driver);
		boolean actualResult = manage_exp_obj.click_Sub_Manageexpense_ViewMore_button();
		boolean expectedResult = true;
		Assert.assertEquals(actualResult, expectedResult, Constants.assertion_Error_Message);
	}
	
	@Test
	public void verify_ME_NewButton_isClickable() throws IOException, InterruptedException {
		lp=new LoginPage(driver);
		lp.perform_LoginPage(ExcelReadUtils.readStringData(1, 0, "Sheet1","LoginCredentialsExcel.xlsx"),
				ExcelReadUtils.readStringData(1, 1, "Sheet1","LoginCredentialsExcel.xlsx"));
		sidebar_obj = new SideBarElements(driver);
		sidebar_obj.click_sidebar_manage_expense();
		sidebar_obj.sidebar_ME_SubManage_Expense();
		manage_exp_obj=new Repo_ME_Sub_ManageExpense(driver);
		String actualResult = manage_exp_obj.click_Sub_Manageexpense_New_Button();
		String expectedResult = "Add Expense";
		Assert.assertEquals(actualResult, expectedResult, Constants.assertion_Error_Message);
	}
	
	@Test
	public void verify_ManageExpense_AddNewExpense_dropdown_user() throws IOException {
		lp=new LoginPage(driver);
		lp.perform_LoginPage(ExcelReadUtils.readStringData(1, 0, "Sheet1","LoginCredentialsExcel.xlsx"),
				ExcelReadUtils.readStringData(1, 1, "Sheet1","LoginCredentialsExcel.xlsx"));
		sidebar_obj = new SideBarElements(driver);
		sidebar_obj.click_sidebar_manage_expense();
		sidebar_obj.sidebar_ME_SubManage_Expense();
		manage_exp_obj=new Repo_ME_Sub_ManageExpense(driver);
		String actualResult = manage_exp_obj.Sub_ManageExpense_Add_Expense_Ddluser();
		String expectedResult = Constants.ddl_expectedResult;
		Assert.assertEquals(actualResult, expectedResult, Constants.assertion_Error_Message);
	}
	@Test
	public void verify_ManageExpense_AddNewExpense() throws IOException, AWTException, InterruptedException {
		lp=new LoginPage(driver);
		lp.perform_LoginPage(ExcelReadUtils.readStringData(1, 0, "Sheet1","LoginCredentialsExcel.xlsx"),
				ExcelReadUtils.readStringData(1, 1, "Sheet1","LoginCredentialsExcel.xlsx"));
		sidebar_obj = new SideBarElements(driver);
		sidebar_obj.click_sidebar_manage_expense();
		sidebar_obj.sidebar_ME_SubManage_Expense();
		manage_exp_obj=new Repo_ME_Sub_ManageExpense(driver);
		String actualResult = manage_exp_obj.Sub_ManageExpense_AddNew_Expense();
		String expectedResult = Constants.alert_expectedResult;
		Assert.assertEquals(actualResult, expectedResult, Constants.error_Alert_message_failure);
	}
	@Test
	public void Verify_Sub_ManageExpense_NewlyAddedElement_isPresent() throws IOException {
		lp=new LoginPage(driver);
		lp.perform_LoginPage(ExcelReadUtils.readStringData(1, 0, "Sheet1","LoginCredentialsExcel.xlsx"),
				ExcelReadUtils.readStringData(1, 1, "Sheet1","LoginCredentialsExcel.xlsx"));
		sidebar_obj = new SideBarElements(driver);
		sidebar_obj.click_sidebar_manage_expense();
		sidebar_obj.sidebar_ME_SubManage_Expense();
		manage_exp_obj=new Repo_ME_Sub_ManageExpense(driver);
		String actualResult = manage_exp_obj.Sub_ManageExpense_NewlyAddedElement_isPresent();
		String expectedResult = Constants.ME_ddl_category_expectedResult;
		Assert.assertEquals(actualResult, expectedResult, Constants.assertion_Error_Message);
	}
}
