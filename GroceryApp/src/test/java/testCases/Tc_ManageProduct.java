package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import elementRepository.LoginPage;
import elementRepository.Repo_ME_Sub_ManageExpense;
import elementRepository.Repo_ManageProduct;
import elementRepository.SideBarElements;
import utilities.ExcelReadUtils;

public class Tc_ManageProduct extends BaseClass {
	LoginPage lp;
	Repo_ManageProduct manage_Product;
	SideBarElements sidebar_obj;

	@Test
	public void verify_ManageProduct_AddNewProduct_Check_FieldValidation() throws IOException, InterruptedException {
		lp = new LoginPage(driver);
		lp.perform_LoginPage(ExcelReadUtils.readStringData(1, 0, "Sheet1", "LoginCredentialsExcel.xlsx"),
				ExcelReadUtils.readStringData(1, 1, "Sheet1", "LoginCredentialsExcel.xlsx"));
		sidebar_obj = new SideBarElements(driver);
		sidebar_obj.sidebar_ManageProduct();
		manage_Product = new Repo_ManageProduct(driver);
		String actualResult = manage_Product.manageProduct_AddNewProduct_Check_FieldValidation();
		String expectedResult = Constants.alertText_expectedResult;
		Assert.assertEquals(actualResult, expectedResult, Constants.assertion_Error_Message);
	}

}
