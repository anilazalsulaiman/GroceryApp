package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

public class GeneralUtilities {
	//General reusable methods
	public String getElementText(WebElement element) {
		String text=element.getText();
		return text;
	}
	public String getElementAttributevalue(WebElement element) {
		String attribute_Value=element.getAttribute("value");
		return attribute_Value;
	}
	public void sendKeyElements(WebElement element,String sendValue) {
		element.sendKeys(sendValue);
	}
	public String getElementStyleProperties(WebElement element,String propertyType) {
		String BGcolor = element.getCssValue(propertyType);
		return BGcolor;
	}
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void random_Num_Generator() {
		Math.random();
	}
	public void explicit_wait_utility(WebDriver driver,String element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(element)));
	}
	
	@DataProvider(name = "data-provider")
	public Object[][] dpMethod(String element1,String element2,String element3,String element4){
		return new Object[][] {{element1, element2 }, {element3, element4 }}; 
	}
}
