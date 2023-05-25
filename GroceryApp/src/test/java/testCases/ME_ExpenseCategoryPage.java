package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import elementRepository.LoginPage;
import elementRepository.ME_ExpenseCategoryClass;
import elementRepository.SideBarElements;
import utilities.ExcelReadUtils;

public class ME_ExpenseCategoryPage extends BaseClass {
	LoginPage lp;
	ME_ExpenseCategoryClass expense_cat_obj;
	SideBarElements sdElem;

	@Test(groups = "Critical")
	public void verify_ManageExpense_Expensecategory_NewButton_Text() throws IOException {
		lp = new LoginPage(driver);
		lp.perform_LoginPage(ExcelReadUtils.readStringData(1, 0, "Sheet1", "LoginCredentialsExcel.xlsx"),
				ExcelReadUtils.readStringData(1, 1, "Sheet1", "LoginCredentialsExcel.xlsx"));

		expense_cat_obj = new ME_ExpenseCategoryClass(driver);
		expense_cat_obj.click_ExpenseCategory_NewButton();
		String actualresult = expense_cat_obj.get_ExpenseCategory_NewButton_Text();
		String exepectedResult = "New";
		Assert.assertEquals(actualresult, exepectedResult, "Result not matching");
	}

	@Test
	public void verify_ManageExpense_Expensecategory_NewButton_isClickable() throws IOException {
		lp = new LoginPage(driver);
		lp.perform_LoginPage(ExcelReadUtils.readStringData(1, 0, "Sheet1", "LoginCredentialsExcel.xlsx"),
				ExcelReadUtils.readStringData(1, 1, "Sheet1", "LoginCredentialsExcel.xlsx"));
		expense_cat_obj = new ME_ExpenseCategoryClass(driver);
		String actualResult = expense_cat_obj.click_ExpenseCategory_NewButton();
		String expectedResult = "Expense Category Informations";
		Assert.assertEquals(actualResult, expectedResult, "Result not matching");
	}

	@Test(priority = 3)
	public void verify_ManageExpense_Expensecategory_Add_NewTitle() throws IOException {
		lp = new LoginPage(driver);
		lp.perform_LoginPage(ExcelReadUtils.readStringData(1, 0, "Sheet1", "LoginCredentialsExcel.xlsx"),
				ExcelReadUtils.readStringData(1, 1, "Sheet1", "LoginCredentialsExcel.xlsx"));

		expense_cat_obj = new ME_ExpenseCategoryClass(driver);
		expense_cat_obj.click_ExpenseCategory_NewButton();
		expense_cat_obj.ExpenseCategory_Add_title();
		String actualResult = expense_cat_obj.verify_alert_isPresent();
//		String expectedResult="Expense Category Created Successfully";
		String expectedResult = "Alert!";
		Assert.assertEquals(actualResult, expectedResult, "Result not matching");
	}

	@Test(priority = 4)
	public void verify_ManageExpense_Expensecategory_NewTitle_isAdded() throws IOException {
		lp = new LoginPage(driver);
		lp.perform_LoginPage(ExcelReadUtils.readStringData(1, 0, "Sheet1", "LoginCredentialsExcel.xlsx"),
				ExcelReadUtils.readStringData(1, 1, "Sheet1", "LoginCredentialsExcel.xlsx"));

		expense_cat_obj = new ME_ExpenseCategoryClass(driver);
		expense_cat_obj.click_ExpenseCategory_NewButton();
		Boolean actualresult = expense_cat_obj.get_ExpenseCategory_NewlyAdded_element();
		Boolean exepectedResult = true;
		Assert.assertEquals(actualresult, exepectedResult, "Result not matching");
	}

	@Test(priority = 5)
	public void verify_ManageExpense_Expensecategory_updateIcon_isclickable() throws IOException {
		lp = new LoginPage(driver);
		lp.perform_LoginPage(ExcelReadUtils.readStringData(1, 0, "Sheet1", "LoginCredentialsExcel.xlsx"),
				ExcelReadUtils.readStringData(1, 1, "Sheet1", "LoginCredentialsExcel.xlsx"));
		expense_cat_obj = new ME_ExpenseCategoryClass(driver);
		sdElem = new SideBarElements(driver);
		sdElem.click_sidebar_manage_expense();
		sdElem.sidebar_ME_Expense_Category();
		String actualresult = expense_cat_obj.click_ExpenseCategory_update_icon();
		String expectedResult = "Added Sample Test Title";
		Assert.assertEquals(actualresult, expectedResult, "Result not matching");
	}

	@Test(priority = 6)
	public void verify_ManageExpense_Expensecategory_isUpdatable() throws IOException {
		lp = new LoginPage(driver);
		lp.perform_LoginPage(ExcelReadUtils.readStringData(1, 0, "Sheet1", "LoginCredentialsExcel.xlsx"),
				ExcelReadUtils.readStringData(1, 1, "Sheet1", "LoginCredentialsExcel.xlsx"));
		expense_cat_obj = new ME_ExpenseCategoryClass(driver);
		sdElem = new SideBarElements(driver);
		sdElem.click_sidebar_manage_expense();
		sdElem.sidebar_ME_Expense_Category();
		expense_cat_obj.update_ExpenseCategory_Element();
		String actualresult = expense_cat_obj.verify_alert_isPresent();
		String expectedResult = "Alert!";
		Assert.assertEquals(actualresult, expectedResult, "Result not matching");
	}

	@Test(priority = 7)
	public void verify_ManageExpense_Expensecategory_AddedElement_isDeletable() throws IOException {
		lp = new LoginPage(driver);
		lp.perform_LoginPage(ExcelReadUtils.readStringData(1, 0, "Sheet1", "LoginCredentialsExcel.xlsx"),
				ExcelReadUtils.readStringData(1, 1, "Sheet1", "LoginCredentialsExcel.xlsx"));
		expense_cat_obj = new ME_ExpenseCategoryClass(driver);
		sdElem = new SideBarElements(driver);
		sdElem.click_sidebar_manage_expense();
		sdElem.sidebar_ME_Expense_Category();
		expense_cat_obj.delete_ExpenseCategory_Added_element();
		expense_cat_obj.ExpenseCategory_accept_alert();
		String actualResult = expense_cat_obj.verify_alert_isPresent();
		String expectedResult = Constants.alert_expectedResult;
		Assert.assertEquals(actualResult, expectedResult, Constants.error_Alert_message);
	}

}
