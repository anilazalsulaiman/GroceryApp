package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.idealized.Network.UserAgent;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtils {
	public void capture_Screenshot_failures(WebDriver driver, String failed_imageName) throws IOException {
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		// date time capture using java
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
		// screenshot will store in temporary path
		File system_destination = new File(
				System.getProperty("user.dir") + "\\ScreenshotImages\\" + failed_imageName + "" + timeStamp + ".png");
		FileHandler.copy(screenShot, system_destination);
	}
}
