package test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		// CLick on New Window button

		WebElement newtabBtn = driver.findElement(By.xpath("//button[@id='tabButton']"));
		String Parentwindow = driver.getWindowHandle();
		System.out.println("The Parent window id is : " + Parentwindow);

		newtabBtn.click();
		Set<String> allwindow = driver.getWindowHandles();
		String childwindow = "";

		for (String window : allwindow) {

			System.out.println("The window id is : " + window);
			if (!window.equals(Parentwindow)) {
				childwindow = window;

			}
		}
		System.out.println("The child window is : " + childwindow);

		driver.switchTo().window(childwindow);
		WebElement childheader = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println("The Header in Child window is " + childheader.getText());
		driver.close();
		
		driver.switchTo().window(Parentwindow);

		// CLick on New Window button
		WebElement newWindowBtn = driver.findElement(By.xpath("//button[@id='windowButton']"));
		newWindowBtn.click();
		
		Set<String> newwindow = driver.getWindowHandles();
		String childnewwindow = "";

		for (String window1 : newwindow) {

			System.out.println("The window id is : " + window1);
			if (!window1.equals(Parentwindow)) {
				childnewwindow = window1;

			}
		}
		System.out.println("The child New window is : " + childnewwindow);
		
		driver.switchTo().window(childnewwindow);
		WebElement newchildheader = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println("The heading on New window popup is : " +newchildheader.getText());
		driver.close();
		driver.switchTo().window(Parentwindow);
		
		// CLick on New Window Message
		/*WebElement  newwinMsg = driver.findElement(By.xpath("//button[@id='messageWindowButton']"));
		newwinMsg.click();
		
		Set<String> newmsgwindow = driver.getWindowHandles();
		String childnewmsgwindow = "";
		
		for (String window3 : newmsgwindow) {

			System.out.println("The window id is : " + window3);
			if (!window3.equals(Parentwindow)) {
				childnewmsgwindow = window3;
			}}
		System.out.println("The  New child Message window is : " + childnewmsgwindow);
		driver.switchTo().window(childnewmsgwindow);
		WebElement newmsgwin = driver.findElement(By.xpath("//body[text()='Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.']"));
		System.out.println("The Message on New window popup is : " + newmsgwin.getText());
		*/
		
		
	}
}
