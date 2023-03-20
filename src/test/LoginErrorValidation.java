package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginErrorValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// step-1 : Launch chrome browser and open simplilearn website

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");

		// step-2: Maximize the browser

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		// step-3: click on the Login link on top right corner

		System.out.println(" The page title is " + driver.getTitle());

		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		String location = LoginLink.getAttribute("href");
		System.out.println("Now we navigates to " + location);
		LoginLink.click();

		// step-4: Enter the user name
		WebElement username = driver.findElement(By.name("user_login"));
		username.sendKeys("sreejaskurup2010@gmail.com");

		// step-5: Enter the password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("1Anna@2013");

		// step-6 : Click on Remember me check box
		WebElement rememberCheckbox = driver.findElement(By.className("rememberMe"));
		rememberCheckbox.click();

		// step-7 : Click on the Login button
		WebElement LoginClick = driver.findElement(By.name("btn_login"));
		LoginClick.click();

		// step-8 : Validate the login was unsuccessful and error message is as expected
		WebElement unSuccessValidate = driver.findElement(By.id("msg_box"));
		String ValidationError = unSuccessValidate.getText();
		String ExpValidationError = "The email or password you have entered is invalid.";
		if (unSuccessValidate.isDisplayed() && ValidationError.equals(ExpValidationError)) {
			System.out.println("The Testcase passed : ");
		} else {
			System.out.println("The Testcase Failed : ");
		}

		List<WebElement> AllLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total no of Links " + AllLinks.size());
		for (WebElement link : AllLinks) {

			System.out.println(link.getAttribute("href"));
		}

		// step-9: Close the browser
		driver.close();
	}

}
