package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public static WebDriver driver;

	public static void init() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://techfios.com/billing/?ng=admin/");
	}
	
	
	public static void takeScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourseFile = ts.getScreenshotAs(OutputType.FILE);
		String currentDirectory = System.getProperty("user.dir");
		//SimpleDateFormat formatter = new SimpleDateFormat("MMddyy_HHmmss");
		SimpleDateFormat formatter = new SimpleDateFormat("HHmmss");
		Date date = new Date();
		String level = formatter.format(date);
		FileUtils.copyFile(sourseFile, new File(currentDirectory+"/screenshot/Screen_Shot"+level+ ".png"));
		
	}
	
	
	
	
	public void tearDown() {
		driver.quit();
	}
}
