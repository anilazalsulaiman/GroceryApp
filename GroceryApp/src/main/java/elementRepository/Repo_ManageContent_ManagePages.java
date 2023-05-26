package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralDynamicTable;
import utilities.GeneralUtilities;

public class Repo_ManageContent_ManagePages {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	GeneralDynamicTable gdtable = new GeneralDynamicTable();
	SideBarElements sidebar_obj;

	public Repo_ManageContent_ManagePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(xpath = "//input[@id='title']")
	WebElement addPage_Title;

	@FindBy(xpath = "//div[@class='note-editable card-block']//p")
	WebElement addPage_description;

	@FindBy(xpath = "//button[@data-original-title='Bold (CTRL+B)']")
	WebElement addPage_DescriptionStyle_Bold;

	public void newButton_Click() {
		newButton.click();
	}

	public void manageContent_ManagePages_AddNew_title() {
		gu.sendKeyElements(addPage_Title, "Sample title");
	}

	public void manageContent_ManagePages_AddNew_description() throws AWTException {
		gu.sendKeyElements(addPage_description, "Sample des");
		gu.keyboard_Event_SelectAllText(driver);
	}

	public void manageContent_ManagePages_AddNew_descriptionStyle_BoldButton()
			throws AWTException, InterruptedException {
		addPage_DescriptionStyle_Bold.click();
		gu.keyboard_Event_Unselect_AllText(driver);
	}

	public boolean manageContent_ManagePages_DescriptionField_Check_Styleproperties()
			throws AWTException, InterruptedException {
		newButton_Click();
		manageContent_ManagePages_AddNew_description();
		manageContent_ManagePages_AddNew_descriptionStyle_BoldButton();
		return gdtable.find_Compare_DynamicTable_Element(addPage_DescriptionStyle_Bold, "class", "active");
	}

	public void manageContent_ManagePages_AddNew_clickSaveButton() throws AWTException {
		newButton_Click();
		manageContent_ManagePages_AddNew_title();
		manageContent_ManagePages_AddNew_description();
	}
}
