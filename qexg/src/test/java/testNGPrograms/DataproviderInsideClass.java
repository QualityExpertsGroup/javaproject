package testNGPrograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataproviderInsideClass {
public WebDriver driver;
	
	@BeforeMethod(description="This test is to set up the browser")
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php?");
	}
	
	@Test(description = "This test is to login",  priority = 15, dataProvider="loginData")
	public void verifyLoginAndLogout(String usernmae, String password) {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("email")).sendKeys(usernmae);
		driver.findElement(By.id("passwd")).sendKeys(password);
		driver.findElement(By.id("SubmitLogin")).click();
		if(driver.findElement(By.className("account")).isDisplayed()) {
			String name = driver.findElement(By.xpath(".//a[@class='account']/span")).getText();
			Assert.assertEquals(name, "sample test");
		}
		if(driver.findElement(By.linkText("Sign out")).isDisplayed()) {
			driver.findElement(By.linkText("Sign out")).click();
			String text = driver.findElement(By.className("page-heading")).getText();
			Assert.assertEquals(text,"AUTHENTICATION");
		}
	}
	
	
	@AfterMethod(description = "This test is to tidy up the driver")
	public void tearDown() {
		driver.close();
		driver.quit();
	}	
	
	
	@DataProvider(name="loginData")
    public Object[][] getDataFromDataprovider(){
	    Object [] [] loginCredentials =  
	    	{
	            { "sampletest@test.com", "Test123" },
	            { "sampletest774@test.com", "Test123" },
	            { "sampletest934@test.com", "Test123" }
	        };
	    return loginCredentials;

    }
}
