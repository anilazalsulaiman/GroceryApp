package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralDynamicTable {
	public int get_Dynamic_Table_Elements(WebDriver driver, String columnValue, String compareName) {
		List<WebElement> element_List = driver.findElements(By.xpath(columnValue));
		int locator = 0;
		for (int i = 0; i < element_List.size(); i++) {
			if (element_List.get(i).getText().equals(compareName)) {
				locator = i + 1;
				break;
			}
		}
		return locator;
	}
	
	public boolean find_Compare_DynamicTable_Element(WebElement element,String attribute,String Comparevalue) {
		boolean value = false;
		if (element.getAttribute(attribute).contains(Comparevalue)) {
			value = true;
		} else {
			value = false;
		}
		return value;
	}
}
