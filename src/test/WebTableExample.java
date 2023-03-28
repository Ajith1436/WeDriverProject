package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		// Finding id by CSS selector
		List<WebElement> rows = driver.findElements(By.cssSelector("table#customers>tbody>tr"));
		System.out.println("Total no of Rows " + rows.size());
	
		// Finding id by xpath
		List<WebElement> rows1 = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		System.out.println("Total no of Rows " + rows1.size());
		
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));
		System.out.println("Total no of Columns " + columns.size());

		WebElement data = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[4]/td[1]"));
		System.out.println("The data in 3rd Row & 1st Column is " + data.getText());
		
		for(int i =2;i<=rows.size(); i++){
			//for(int j=0;j<=columns.size();j++ ) {
				List<WebElement> columndata = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr["+i +"]/td"));
				System.out.println(columndata.get(0).getText() + " " + columndata.get(1).getText() + " " + columndata.get(2).getText()) ;

			
		}
		
		driver.close();
		
	}

}
