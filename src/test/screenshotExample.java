package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class screenshotExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		// Create object of TakesScreenshot method
		TakesScreenshot tsobj = (TakesScreenshot) driver;
		
		// / Create object of file and calling the get screenshot method, screenshot get saved into file object
		File fileobj = tsobj.getScreenshotAs(OutputType.FILE);
		
		// Declare another file object to set the destination on where the file to get saved
		File Screenshotobj = new File("Image.png");
		
		// The Screenshot saved on file object 'fileobj' copied to the destination file object 'Screenshotobj'
		FileUtils.copyFile(fileobj, Screenshotobj); 
		
		driver.close();
		
	}

}
