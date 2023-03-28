package test;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDropExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement From = driver.findElement(By.xpath("//a[text()=' BANK ']"));
		WebElement To = driver.findElement(By.xpath("//ol[@id='bank']/li[@class='placeholder']"));
		
		Actions obj = new Actions(driver);
		
		// To Hover on an element
		obj.moveToElement(From).build().perform();
		Thread.sleep(3000);
		
		
		
		//obj.sendKeys(Keys.PAGE_DOWN);
		obj.dragAndDrop(From, To).build().perform();
		//obj.sendKeys(Keys.PAGE_DOWN) .dragAndDrop(From, To) .build() .perform();
		
		
	}

}
