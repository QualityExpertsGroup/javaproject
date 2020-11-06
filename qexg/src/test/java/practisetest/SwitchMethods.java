package practisetest;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchMethods {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		handleWindows(driver);
		
		driver.get("https://demoqa.com/alerts");
		//Simple alert
		driver.findElement(By.id("alertButton")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
System.out.println("Simple alert accepted");

	//confirmation alert
	driver.findElement(By.id("confirmButton")).click();
	driver.switchTo().alert().accept();
	System.out.println(driver.findElement(By.id("confirmResult")).getText());
	driver.findElement(By.id("confirmButton")).click();
	driver.switchTo().alert().dismiss();
	System.out.println(driver.findElement(By.id("confirmResult")).getText());
	
	//prompt alert
	driver.findElement(By.id("promtButton")).click();
	driver.switchTo().alert().sendKeys("fafdsgd");
	driver.switchTo().alert().accept();
	driver.close();
	driver.quit();
	}

	public static void handleWindows(WebDriver driver) {
		driver.get("http://skryabin.com/webdriver/html/sample.html");
		
		String parentWindow = driver.getWindowHandle();
		
		driver.findElement(By.xpath(".//button[contains(.,'Related')]")).click();
		
		Set<String> allWindows = driver.getWindowHandles();
		
		for(String windowHanle : allWindows) {
			driver.switchTo().window(windowHanle);
		}
		
		String title = driver.getTitle();
		System.out.println("Title is " + title);
		
		driver.switchTo().window(parentWindow);
		System.out.println("Title is " + driver.getTitle());
	}
	
}
