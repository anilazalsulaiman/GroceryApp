package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralDynamicTable;
import utilities.GeneralUtilities;

public class Repo_ME_Sub_ManageExpense {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	GeneralDynamicTable gdtable = new GeneralDynamicTable();
	SideBarElements sidebar_obj;

	public Repo_ME_Sub_ManageExpense(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fa fa-angle-double-down']")
	WebElement listExp_ViewMore;

	@FindBy(xpath = "//tr[@class='detail-row open']")
	WebElement detail_row_open;

	public WebElement get_ViewMore_element() {
		int rowValue = gdtable.get_Dynamic_Table_Elements(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]",
				"Fruits436335261 (Dwd-DB)");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + rowValue
				+ "]//td//div//a[1]";
		WebElement Findelement = driver.findElement(By.xpath(locator));
		return Findelement;
	}

	public boolean click_Sub_Manageexpense_ViewMore_button() {
		get_ViewMore_element().click();
		boolean value = false;
		if (detail_row_open.getAttribute("class").contains("detail-row open")) {
			value = true;
		} else {
			value = false;
		}
		return value;
	}

}
