package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
