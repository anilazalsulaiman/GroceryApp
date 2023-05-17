package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement NewButton;

	@FindBy(xpath = "//h1[text()='Add Expense']")
	WebElement verify_Addexpense_Title;

	@FindBy(xpath = "//select[@id='user_id']")
	WebElement addexpense_ddl_User;

	@FindBy(xpath = "//input[@id='ex_date']")
	WebElement addexpense_date;

	@FindBy(xpath = "//select[@id='ex_cat']")
	WebElement addexpense_ddlcategory;

	@FindBy(xpath = "//select[@id='order_id']")
	WebElement addexpense_ddl_orderId;

	@FindBy(xpath = "//select[@id='purchase_id']")
	WebElement addexpense_ddl_PurchaseId;

	@FindBy(xpath = "//select[@id='ex_type']")
	WebElement addexpense_ddl_ExpenseType;

	@FindBy(xpath = "//input[@id='amount']")
	WebElement addexpense_Amount;

	@FindBy(xpath = "//textarea[@id='content']")
	WebElement addexpense_Remarks;

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
		gu.explicit_wait_utility(driver, "//tr[@class='detail-row open']");
		boolean value = false;
		if (detail_row_open.getAttribute("class").contains("detail-row open")) {
			value = true;
		} else {
			value = false;
		}
		return value;
	}

	public String click_Sub_Manageexpense_New_Button() {
		NewButton.click();
		return gu.getElementText(verify_Addexpense_Title);

	}

	public String Sub_ManageExpense_Add_Expense_Ddluser() {
		NewButton.click();
		return gu.dropdown_selectByIndex(addexpense_ddl_User, 1);
	}

	public void Sub_ManageExpense_AddExpense_Date_Datepicker() {
		gu.sendKeyElements(addexpense_date, "10-02-1995");
	}

	public String Sub_ManageExpense_Add_Expense_Ddlcategory() {
		return gu.dropdown_selectByIndex(addexpense_ddlcategory, 1);
	}

	public String Sub_ManageExpense_Add_Expense_Ddl_orderId() {
		return gu.dropdown_selectByIndex(addexpense_ddl_orderId, 1);
	}

	public String Sub_ManageExpense_Add_Expense_Ddl_PurchaseId() {
		return gu.dropdown_selectByIndex(addexpense_ddl_PurchaseId, 1);
	}

	public String Sub_ManageExpense_Add_Expense_Ddl_ExpenseType() {
		return gu.dropdown_selectByIndex(addexpense_ddl_ExpenseType, 1);
	}

	public void Sub_ManageExpense_Add_Expense_Amount() {
		gu.sendKeyElements(addexpense_Amount, Integer.toString(100));
	}
	public void Sub_ManageExpense_Add_Remark() {
		gu.sendKeyElements(addexpense_Remarks, "Sample Remark Added");
	}

	public void Sub_ManageExpense_AddNew_Expense() {
		Sub_ManageExpense_Add_Expense_Ddluser();
		gu.keyboard_Event_Tab(driver);
		Sub_ManageExpense_AddExpense_Date_Datepicker();
		gu.keyboard_Event_Tab(driver);
		Sub_ManageExpense_Add_Expense_Ddlcategory();
		gu.keyboard_Event_Tab(driver);
		Sub_ManageExpense_Add_Expense_Ddl_orderId();
		gu.keyboard_Event_Tab(driver);
		Sub_ManageExpense_Add_Expense_Ddl_PurchaseId();
		gu.keyboard_Event_Tab(driver);
		Sub_ManageExpense_Add_Expense_Ddl_ExpenseType();
		gu.keyboard_Event_Tab(driver);
		Sub_ManageExpense_Add_Expense_Amount();
		gu.keyboard_Event_Tab(driver);
		Sub_ManageExpense_Add_Remark();
		gu.keyboard_Event_Tab(driver);
		
	}

}
