package practisetest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchMethodFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
//		handleFrames(driver);
		
		nestedFrames(driver);
		
		driver.close();
		driver.quit();
	}
	
	public static void handleFrames(WebDriver driver) {
		driver.get("https://demoqa.com/frames");
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		//webelments
		driver.switchTo().frame(driver.findElement(By.id("frame1")));
		System.out.println("Frame 1 text is "+driver.findElement(By.id("sampleHeading")).getText());
		driver.switchTo().defaultContent();
		
		//index
		driver.switchTo().frame(1);
		System.out.println("Frame 2 text is "+driver.findElement(By.id("sampleHeading")).getText());
		driver.switchTo().defaultContent();
	}
	
	public static void nestedFrames(WebDriver driver) {
		driver.get("https://demoqa.com/nestedframes");
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		//String
		driver.switchTo().frame("frame1");
		System.out.println("Parent Frame  text is "+driver.findElement(By.tagName("body")).getText());
		driver.switchTo().frame(0);
		System.out.println("Child frame text is - " +driver.findElement(By.tagName("P")).getText());
		driver.switchTo().parentFrame();
		System.out.println("Parent Frame  text is "+driver.findElement(By.tagName("body")).getText());
		driver.switchTo().defaultContent();
	}
}
