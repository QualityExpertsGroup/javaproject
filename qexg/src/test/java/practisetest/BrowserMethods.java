package practisetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserMethods {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriver driver1 = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		//Open the application 
		driver.get("http://automationpractice.com/index.php");
		System.out.println("Application opened successfully");
		
		//get title
		String title = driver.getTitle();
		System.out.println("My application title is " + title);
		System.out.println("Title " + driver.getTitle());
		
		//get current url
		String url = driver.getCurrentUrl();
		System.out.println("Current URL is - " + url);
		
		//Page source
		String pageSource = driver.getPageSource();
		System.out.println("My Page source is - " + pageSource);
		
		//Close the application
		driver.close();
		System.out.println("Application closed successfully");
		
		//quit driver
		driver.quit();
		System.out.println("Quitting the driver");
	}

}
