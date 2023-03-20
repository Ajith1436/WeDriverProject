package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestcase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// step-1 : Launch chrome browser and open simplilearn website

		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		
		// step-2: Maximize the browser

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		
		// step-3: click  on the Login link on top right corner

		System.out.println(" The page title is "+ driver.getTitle());
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		String location = LoginLink.getAttribute("href");
		System.out.println("Now we navigates to "+location);
		LoginLink.click();
		
		//step-4: Enter the user name
		WebElement username = driver.findElement(By.name("user_login"));
		username.sendKeys("sreejaskurup2010@gmail.com");
		

		// step-5: Enter the password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Anna@2013");
		
		//step-6 : Click  on Remember me check box
		WebElement rememberCheckbox =driver.findElement(By.className("rememberMe"));
		rememberCheckbox.click();
		
		// step-7 : Click on the Login button
		WebElement LoginClick = driver.findElement(By.name("btn_login"));
		LoginClick.click();
		 Thread.sleep(3000);
		
		// step-8 : Validate the login was Successful as expected
		WebElement loginSuccess = driver.findElement(By.className("program-detail__course custom-program-detail__course-theme"));
		String loginSuccessMsg = loginSuccess.getText();
		String ExploginSuccessMsg = "Automation Testing Masters Program";
		if (loginSuccessMsg.equals(ExploginSuccessMsg))		{
			System.out.println("The Login is successful");
		}
		else {
			System.out.println("The Login is unsuccessful");
		}
		driver.close();
	}

}
