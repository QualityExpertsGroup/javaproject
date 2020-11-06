package practisetest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementMethods {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://skryabin.com/webdriver/html/sample.html");
		
		//1.click
		//2. findelement
		driver.findElement(By.id("name")).click();
		
		//3.Sendkeys
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys("joekannan");
		
		driver.findElement(By.id("middleName")).sendKeys("Seetha");
		
		driver.findElement(By.id("lastName")).sendKeys("Mukil");
		
		driver.findElement(By.xpath(".//button[contains(.,'Save')]")).click();
	
		
		Select dropdown = new Select(driver.findElement(By.name("countryOfOrigin")));
		dropdown.selectByVisibleText("India");
		
		driver.findElement(By.id("address")).sendKeys("fdshgfjsdkjgdskgh");
		
		driver.findElement(By.name("username")).sendKeys("QExG");
		driver.findElement(By.name("password")).sendKeys("Test123");
		
		driver.findElement(By.name("phone")).sendKeys("78945612121");
		
		List<WebElement> genders = driver.findElements(By.name("gender"));
		
		System.out.println("Gender value" + genders.get(0).getAttribute("value"));
		System.out.println("Gender value" + genders.get(1).getAttribute("value"));
		genders.get(1).click();
		
		
		Select carMake = new Select(driver.findElement(By.name("carMake")));
		carMake.selectByValue("Ford");
		carMake.selectByIndex(3);
		
		
		String Text = driver.findElement(By.id("currentTime")).getText();
		System.out.println("Text is " + Text);
		
		Dimension sizeOfObj = driver.findElement(By.id("currentTime")).getSize();
	System.out.println(sizeOfObj);
	Point location = driver.findElement(By.id("currentTime")).getLocation();
	System.out.println(location);
	String tagName = driver.findElement(By.id("currentTime")).getTagName();
	System.out.println(tagName);
	
	boolean blnDisplayed = driver.findElement(By.name("phone")).isDisplayed();
	System.out.println(blnDisplayed);
	boolean blnEnabled = driver.findElement(By.name("phone")).isEnabled();
	System.out.println(blnEnabled);
	
	boolean blnSelected = driver.findElement(By.name("allowedToContact")).isSelected();
	System.out.println(blnSelected);
	}

}
