package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class alertExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		WebElement Click1Btn = driver.findElement(By.xpath("//button[@id='alertButton']"));
		Click1Btn.click();
		
		Alert obj = driver.switchTo().alert();
		Thread.sleep(2000);
		obj.accept();
		
		WebElement Click2Btn = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
		Click2Btn.click();
		
		obj = driver.switchTo().alert();
		Thread.sleep(6000);
		obj.accept();
		
		WebElement Click3Btn = driver.findElement(By.xpath("//button[@id='confirmButton']"));
		Click3Btn.click();
		obj = driver.switchTo().alert();
		Thread.sleep(3000);
		obj.dismiss();
		
	}

}
