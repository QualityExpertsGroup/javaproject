package practisetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationMethods {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		//Open the AUT
		driver.navigate().to("http://automationpractice.com/index.php");
		System.out.println("Navigation to URL is done successfully");
		
		//
		driver.findElement(By.linkText("Sign in")).click();
		String title = driver.getTitle();
		System.out.println(title + "This is the title after i click Sign in");
		if(title.equalsIgnoreCase("Login - My Store")) {
			System.out.println("Title is correct");
		}
		else {
			System.out.println("Title is incorrect");
		}
		
		//back method
		driver.navigate().back();
		String title1 = driver.getTitle();
		System.out.println(title1 + "This is the title after i click back");
		
		//forward
		driver.navigate().forward();
		String title2 = driver.getTitle();
		System.out.println(title2 + "This is the title after i click forward");
		
		//refresh
		driver.navigate().refresh();
		System.out.println("My page is refreshed");
		

	}

}
