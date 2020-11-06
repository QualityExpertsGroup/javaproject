package testNGPrograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTestNGProgram {
  @Test
  public void loginLogoutAndVerify() {
	  
	  	WebDriver driver;
	  	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		WebDriver driver1;
	  	WebDriverManager.chromedriver().setup();
		driver1 = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php?");
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("email")).sendKeys("sampletest@test.com");
		driver.findElement(By.id("passwd")).sendKeys("Test123");
		driver.findElement(By.id("SubmitLogin")).click();
		driver.findElement(By.linkText("Sign out")).click();
		String text = driver.findElement(By.className("page-heading")).getText();
		Assert.assertEquals(text,"AUTHENTICATION");
		driver.close();
		driver.quit();
  }

  
}
