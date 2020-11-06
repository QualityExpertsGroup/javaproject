package practisetest;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitMethods {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		pageLoadTimeOut(driver);
//		implicitTimeOut(driver);
//		threadSleep(driver);
//		explicitTimeOut(driver);
		fluentWaitTimeOut(driver);
		driver.close();
		driver.quit();
	}

	public static void pageLoadTimeOut(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://testproject.io/");
		driver.findElement(By.linkText("Login")).click();
		System.out.println("Page Load time out is applied");
	}
	
	public static void implicitTimeOut(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://testproject.io/");
		driver.findElement(By.linkText("Login")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for(String window : allWindows) {
			driver.switchTo().window(window);
		}
		
		driver.findElement(By.id("username")).sendKeys("info@qexg.co.nz");	
		System.out.println("User name entered successfully");
	}
	
	
	public static void threadSleep(WebDriver driver) throws InterruptedException {
		driver.get("https://testproject.io/");
		driver.findElement(By.linkText("Login")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for(String window : allWindows) {
			driver.switchTo().window(window);
		}
		Thread.sleep(20000);
		driver.findElement(By.id("username")).sendKeys("info@qexg.co.nz");	
		System.out.println("User name entered successfully");
	}
	
	public static void explicitTimeOut(WebDriver driver) {
		driver.get("https://testproject.io/");
		driver.findElement(By.linkText("Login")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for(String window : allWindows) {
			driver.switchTo().window(window);
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
		
		
		driver.findElement(By.id("username")).sendKeys("info@qexg.co.nz");	
		System.out.println("User name entered successfully");
	}
	
	
	public static void fluentWaitTimeOut(WebDriver driver) {
		driver.get("https://testproject.io/");
		driver.findElement(By.linkText("Login")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for(String window : allWindows) {
			driver.switchTo().window(window);
		}
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(20))
			       .pollingEvery(Duration.ofSeconds(5))
			       .ignoring(NoSuchElementException.class);
		WebElement username = wait.until(new Function<WebDriver, WebElement>() 
		{
		    public WebElement apply(WebDriver driver) {
		    	return driver.findElement(By.id("username"));
		}
		});
				
		username.sendKeys("info@qexg.co.nz");	
		System.out.println("User name entered successfully");
	}
}
