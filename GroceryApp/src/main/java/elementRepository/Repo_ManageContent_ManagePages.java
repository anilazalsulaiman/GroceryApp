package elementRepository;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadUtils;
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
	
	@FindBy(xpath = "//input[@id='page']")
	WebElement addPage_Page;
	
	@FindBy(xpath = "//input[@name='main_img']")
	WebElement addPage_ImageFileUpload;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement addPage_SaveButton;

	

	public void newButton_Click() {
		newButton.click();
	}

	public void manageContent_ManagePages_AddNew_title() throws IOException {
		gu.sendKeyElements(addPage_Title, ExcelReadUtils.readStringData(1,1, "ManageContent_ManagePages", "TestDatas.xlsx"));
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

	public void manageContent_ManagePages_AddNew_pageField() {
		gu.sendKeyElements(addPage_Page,Double.toString(123+gu.random_Num_Generator()));
	}
	public void manageContent_ManagePages_AddNew_FileUpload() throws AWTException, InterruptedException {
		gu.pageScroll_Utility(driver, 0, 500);
		gu.medium_Delay();
		gu.file_Upload_Utility(driver, addPage_ImageFileUpload,"image2.jpg");
	}

	public void manageContent_ManagePages_AddNew_Click_SaveButton() {
		gu.element_Click(addPage_SaveButton);
	}

	public void manageContent_ManagePages_AddNew_clickSaveButton() throws AWTException, IOException, InterruptedException {
		newButton_Click();
		manageContent_ManagePages_AddNew_title();
		manageContent_ManagePages_AddNew_description();
		gu.keyboard_Event_Unselect_AllText(driver);
		manageContent_ManagePages_AddNew_pageField();
		manageContent_ManagePages_AddNew_FileUpload();
		manageContent_ManagePages_AddNew_Click_SaveButton();
	}
}
