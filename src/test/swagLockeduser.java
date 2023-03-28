package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class swagLockeduser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement LoginBtn = driver.findElement(By.xpath("//input[@id='login-button']"));
		
		
		username.sendKeys("locked_out_user");
		password.sendKeys("secret_sauce");
		LoginBtn.click();
		
		WebElement unSuccessValidate = driver.findElement(By.xpath("//h3[@data-test = 'error']"));
		String ValidationError = unSuccessValidate.getText();
		String ExpValidationError = "Epic sadface: Sorry, this user has been locked out.";
		if (unSuccessValidate.isDisplayed() && ValidationError.equals(ExpValidationError)) {
			System.out.println("The Testcase passed : ");
		} else {
			System.out.println("The Testcase Failed : ");
		}

		
		System.out.println("locked_out_user login is unsuccessfull");
		
		driver.close();
	}

}
