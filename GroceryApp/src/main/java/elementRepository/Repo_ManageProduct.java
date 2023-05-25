package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadUtils;
import utilities.GeneralDynamicTable;
import utilities.GeneralUtilities;

public class Repo_ManageProduct {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	SideBarElements sidebar_obj;

	public Repo_ManageProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//input[@id='title']")
	WebElement add_Title;
	@FindBy(xpath = "//button[@name='create']")
	WebElement saveButton;

	public void newButton_Click() {
		newButton.click();
	}

	public void saveButton_Click() {
		saveButton.click();
	}

	public String manageProduct_AddNewProduct_Check_FieldValidation() throws InterruptedException {
		newButton_Click();
		gu.pageScroll_Utility(driver, 0, 2000);
		gu.medium_Delay();
		saveButton_Click();
		String alertText = gu.getAlertText(driver);
		gu.dismissAlert(driver);
		return alertText;
	}

}
