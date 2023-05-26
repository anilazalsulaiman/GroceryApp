package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadUtils;
import utilities.GeneralUtilities;

public class Repo_PushNotifications {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	SideBarElements sidebar_obj;

	@FindBy(xpath = "//input[@id='title']")
	WebElement title;

	@FindBy(xpath = "//input[@id='description']")
	WebElement description;

	@FindBy(xpath = "//button[@name='create']")
	WebElement send_button;

	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alert_present;

	public Repo_PushNotifications(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void pushNotification_title() throws IOException {
		gu.sendKeyElements(title, ExcelReadUtils.readStringData(1, 1, "Push_notifications", "TestDatas.xlsx"));
	}

	public void pushNotification_description() throws IOException {
		gu.sendKeyElements(description, ExcelReadUtils.readStringData(2, 1, "Push_notifications", "TestDatas.xlsx"));
	}

	public void pushNotification_Send_Button() {
		send_button.click();
	}

	public String get_pushNotification_value() throws IOException {
		pushNotification_title();
		pushNotification_description();
		pushNotification_Send_Button();
		return gu.getElementText(alert_present);
	}

}
