package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignupTC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement signupbtn = driver.findElement(By.xpath("//form/div[5]/a[@role='button']"));
		signupbtn.click();
		
		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
		firstname.sendKeys("Test");
		
		WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
		lastname.sendKeys("User");
		
		WebElement emailtxt = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		emailtxt.sendKeys("Testing4306@gmail.com");
		
		WebElement emailconfirmationtxt = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
		emailconfirmationtxt.sendKeys("Testing4306@gmail.com");
		
		WebElement passwordtxt = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		passwordtxt.sendKeys("Testing@123");
		
		WebElement Selectedday = driver.findElement(By.xpath("//select[@title='Day']/option[@selected='1']"));
		System.out.println("The selected Day is "+ Selectedday.getText());
		
				
		List<WebElement> Allmonths = driver.findElements(By.xpath("//select[@name='birthday_month']/option"));
		System.out.println("Total no of months " + Allmonths.size());
		for (WebElement months : Allmonths) {

			System.out.println(months.getText());
		}
		
		
		WebElement day = driver.findElement(By.xpath("//select[1][@name='birthday_day']"));
		Select ddday = new Select(day);
		ddday.selectByValue("10");
		
		WebElement month = driver.findElement(By.xpath("//select[2][@name='birthday_month']"));
		Select ddmonth = new Select(month);
		//ddmonth.selectByVisibleText("Mar");
		ddmonth.selectByValue("9");
		
		WebElement year = driver.findElement(By.xpath("//select[3][@name='birthday_year']"));
		Select ddyear =new Select(year);
		ddyear.selectByValue("1950");
		
		
		String gender = "Female";
		// case :1
		//String genderXpath = "//label[text()='Placeholder']";
		//String newXpath = genderXpath.replace("Placeholder", gender);
		
		//Case :2
		String newXpath = "//label[text()='" + gender + "']";
		
		//Case : 3
		//WebElement genderSelect = driver.findElement(By.xpath("//label[text() = 'Male']"));	
		

		WebElement genderSelect = driver.findElement(By.xpath(newXpath));
		genderSelect.click();
		
		WebElement Signup = driver.findElement(By.xpath("//button[@name='websubmit']"));
		Signup.click();
		
		
	}

}
