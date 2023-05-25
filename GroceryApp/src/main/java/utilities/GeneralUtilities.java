package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

public class GeneralUtilities {
	// General reusable methods
	public void medium_Delay() throws InterruptedException {
		Thread.sleep(2000);
	}

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public String getElementAttributevalue(WebElement element, String attributeName) {
		String attribute_Value = element.getAttribute(attributeName);
		return attribute_Value;
	}

	public void sendKeyElements(WebElement element, String sendValue) {
		element.sendKeys(sendValue);
	}

	public String getElementStyleProperties(WebElement element, String propertyType) {
		String BGcolor = element.getCssValue(propertyType);
		return BGcolor;
	}

	public String dropdown_selectByIndex(WebElement element, int position) {
		Select drp = new Select(element);
		drp.selectByIndex(position);
		WebElement drpSelectedValue = drp.getFirstSelectedOption();
		String webelementstore = drpSelectedValue.getText();
		return webelementstore;
	}

	public String dropdown_selectByVisibleText(WebElement element, String visibletext) {
		Select drp = new Select(element);
		drp.selectByVisibleText(visibletext);
		WebElement drpSelectedValue = drp.getFirstSelectedOption();
		String webelementstore = drpSelectedValue.getText();
		return webelementstore;
	}

	public String dropdown_selectByValue(WebElement element, String selectbyValue) {
		Select drp = new Select(element);
		drp.selectByValue(selectbyValue);
		WebElement drpSelectedValue = drp.getFirstSelectedOption();
		String webelementstore = drpSelectedValue.getText();
		return webelementstore;
	}

	public String getAlertText(WebDriver driver) {
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void keyboard_Event_Tab(WebDriver driver) { // used in "Repo_ME_Sub_ManageExpense"
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).perform();
	}

	public void keyboard_Event_SelectAllText(WebDriver driver) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		robot.keyRelease(KeyEvent.VK_A);
	}
	public void keyboard_Event_Unselect_AllText(WebDriver driver) throws AWTException {
		Robot robot = new Robot();
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_A);
	}

	public void random_Num_Generator() {
		Math.random();
	}

	public void pageScroll_Utility(WebDriver driver, int horizontal, int vertical) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + horizontal + "," + vertical + ")", "");
	}

	public void file_Upload_Utility(WebDriver driver, WebElement element) throws AWTException {
		Robot robot = new Robot();
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		StringSelection ss = new StringSelection(
				System.getProperty("user.dir") + "\\src\\main\\resources\\FileUploads\\image1.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(250);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void explicit_wait_utility(WebDriver driver, String element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(element)));
	}

}
