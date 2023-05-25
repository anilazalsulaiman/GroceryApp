package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import elementRepository.LoginPage;
import elementRepository.Repo_ManageContent_ManagePages;
import elementRepository.Repo_ManageProduct;
import elementRepository.SideBarElements;
import utilities.ExcelReadUtils;

public class Tc_ManageContent_ManagePages extends BaseClass{
	LoginPage lp;
	Repo_ManageContent_ManagePages manage_Pages;
	SideBarElements sidebar_obj;
	
  @Test
  public void verify_manageContent_ManagePages_DescriptionField_Styleproperties() throws IOException, AWTException, InterruptedException {
	  lp = new LoginPage(driver);
		lp.perform_LoginPage(ExcelReadUtils.readStringData(1, 0, "Sheet1", "LoginCredentialsExcel.xlsx"),
				ExcelReadUtils.readStringData(1, 1, "Sheet1", "LoginCredentialsExcel.xlsx"));
		sidebar_obj = new SideBarElements(driver);
		sidebar_obj.sidebar_manage_Content();
		sidebar_obj.sidebar_manage_Pages();
		manage_Pages=new Repo_ManageContent_ManagePages(driver);
		boolean actualResult = manage_Pages.manageContent_ManagePages_DescriptionField_Check_Styleproperties();
		boolean expectedResult = Constants.expected_result_true;
		Assert.assertEquals(actualResult, expectedResult, Constants.expense_category_message);
		
  }
  
  
}
