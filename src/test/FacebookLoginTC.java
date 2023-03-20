package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLoginTC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// step-1 : Launch chrome browser and open simplilearn website

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

		// step-2: Maximize the browser

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement username =driver.findElement(By.id("email"));
		username.sendKeys("Testing4304@gmail.com");
		
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys("9747362120");
		
		WebElement LoginBtn = driver.findElement(By.name("login"));
		LoginBtn.click();
		
		driver.close();

	}

}
