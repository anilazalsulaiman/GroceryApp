package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenshotUtils;

public class BaseClass {
	WebDriver driver;
	ScreenshotUtils scUT;

	public static Properties prop;

	public static void testBasic() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//resources//Properties//Config.properties");
		prop.load(ip);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		testBasic();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);

		driver.get(prop.getProperty("BaseURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}

//	@BeforeMethod(alwaysRun = true)
//	@Parameters("browser")
//	public void beforeMethod(String checkBrowser) throws IOException {
//		testBasic();
//		if (checkBrowser.equals("chrome")) {
//			ChromeOptions ops = new ChromeOptions();
//			ops.addArguments("--remote-allow-origins=*");
//			driver = new ChromeDriver(ops);
//		} else if (checkBrowser.equals("edge")) {
//			EdgeOptions ops = new EdgeOptions();
//			ops.addArguments("--remote-allow-origins=*");
//			driver = new EdgeDriver(ops);
//		}
//
//		driver.get(prop.getProperty("BaseURL"));
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
//	}

//	@AfterMethod
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult itestResult) throws IOException {
		if (itestResult.getStatus() == ITestResult.FAILURE) { // for capturing failed screenshots
			scUT = new ScreenshotUtils();
			scUT.capture_Screenshot_failures(driver, itestResult.getName());
		}
		driver.close();
	}
}
