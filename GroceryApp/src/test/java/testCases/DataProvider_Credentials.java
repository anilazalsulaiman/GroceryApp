package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Credentials {
	
  @DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { 
			{ "invalid","adminUsername1", "adminUsername2" },
			{ "valid","admin", "admin" } 
			};
	}
}
