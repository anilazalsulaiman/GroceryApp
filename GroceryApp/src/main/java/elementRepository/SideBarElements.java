package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideBarElements {
	WebDriver driver;

	public SideBarElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // page factory
	}
	//Drawer elements
		@FindBy(xpath = "//i[@class='nav-icon fas fa-money-bill-alt']")
		WebElement sidebar_manage_expense;
		
		@FindBy(xpath = "//p[text()='Expense Category']")
		WebElement sidebar_ME_Expense_Category;
		
		@FindBy(xpath = "//p[text()='Manage Expense']")
		WebElement sidebar_ME_SubManage_Expense_element;
		
		public void click_sidebar_manage_expense() {
			sidebar_manage_expense.click();
		}
		public void sidebar_ME_Expense_Category() {
			sidebar_ME_Expense_Category.click();
		}
		public void sidebar_ME_SubManage_Expense() {
			sidebar_ME_SubManage_Expense_element.click();
		}
}
