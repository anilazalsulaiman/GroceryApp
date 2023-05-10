package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralDynamicTable;
import utilities.GeneralUtilities;

public class ME_ExpenseCategoryClass {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	GeneralDynamicTable gdtable = new GeneralDynamicTable();
	SideBarElements sidebar_obj;

	public ME_ExpenseCategoryClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement expense_Category_NewButton;

	@FindBy(xpath = "//input[@id='name']")
	WebElement add_title;

	@FindBy(xpath = "//button[@name='Create']")
	WebElement save_new_title;

	@FindBy(xpath = "//h3[text()='Expense Category Informations']")
	WebElement exp_category_information_title;

	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement verify_Expense_category_alert_present;
//	@FindBy(xpath = "(//div[@class='alert alert-success alert-dismissible']//text()[3])")
//	WebElement verify_Expense_category_alert_present;

	@FindBy(xpath = "//i[@class='fas fa-edit']")
	WebElement update_icon;

	@FindBy(xpath = "//input[@id='name']")
	WebElement update_InputField_Textbox;

	@FindBy(xpath = "//button[@name='Update']")
	WebElement update_button;

	public String click_ExpenseCategory_NewButton() {
		sidebar_obj = new SideBarElements(driver);
		sidebar_obj.click_sidebar_manage_expense();
		sidebar_obj.sidebar_ME_Expense_Category();
		expense_Category_NewButton.click();
		return gu.getElementText(exp_category_information_title);
	}

	public String get_ExpenseCategory_NewButton_Text() {
		return gu.getElementText(expense_Category_NewButton);
	}

	public void ExpenseCategory_Add_title() {
		// use random string/number generator "+Math.random()+"
		add_title.sendKeys("Added Sample Test Title");
		save_new_title.click();
	}

	public String verify_alert_isPresent() {
		return gu.getElementText(verify_Expense_category_alert_present);
	}

	public WebElement get_updateIcon_ExpenseCategory_element() {
		int rowValue = gdtable.get_Dynamic_Table_Elements(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]",
				"Added Sample Test Title");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + rowValue
				+ "]//td[2]//a[1]";
		WebElement Findelement = driver.findElement(By.xpath(locator));
		return Findelement;
	}

	public String click_ExpenseCategory_update_icon() {
		get_updateIcon_ExpenseCategory_element().click();
		update_InputField_Textbox.getAttribute("value");
		return gu.getElementAttributevalue(update_InputField_Textbox);
	}

	public void update_ExpenseCategory_Element() {
		get_updateIcon_ExpenseCategory_element().click();
		gu.sendKeyElements(update_InputField_Textbox, " updated");
		update_button.click();
	}

	public boolean get_ExpenseCategory_NewlyAdded_element() {
		List<WebElement> locate_all_column_values = driver.findElements(
				By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]"));
		boolean check = false;
		for (WebElement checkEachValue : locate_all_column_values) {
			if (checkEachValue.getText().contains("Added Sample Test Title")) {
				check = true;
				break;
			}
		}
		return check;
	}

	public void delete_ExpenseCategory_Added_element() {
		int rowValue = gdtable.get_Dynamic_Table_Elements(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]",
				"Added Sample Test Title updated");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + rowValue
				+ "]//td[2]//a[2]";
		WebElement Findelement = driver.findElement(By.xpath(locator));
		Findelement.click();
	}

	public void ExpenseCategory_accept_alert() {
		gu.acceptAlert(driver);
	}

}
