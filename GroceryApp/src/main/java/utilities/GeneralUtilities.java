package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
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
	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public String getElementAttributevalue(WebElement element) {
		String attribute_Value = element.getAttribute("value");
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

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void keyboard_Event_Tab(WebDriver driver) { //used in "Repo_ME_Sub_ManageExpense"
		Actions action=new Actions(driver);
		action.sendKeys(Keys.TAB).perform();
	}

	public void random_Num_Generator() {
		Math.random();
	}

	public void explicit_wait_utility(WebDriver driver, String element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(element)));
	}

}
