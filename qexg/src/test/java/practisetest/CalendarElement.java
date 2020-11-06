package practisetest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarElement {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://skryabin.com/webdriver/html/sample.html");
		
		
		//Calendar 
		driver.findElement(By.id("dateOfBirth")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='ui-datepicker-calendar']//td[@data-handler='selectDay']")));
		
		Select month = new Select(driver.findElement(By.className("ui-datepicker-month")));
		month.selectByVisibleText("Jun");
		
		Select year = new Select(driver.findElement(By.className("ui-datepicker-year")));
		year.selectByVisibleText("1989");
		
		List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td[@data-handler='selectDay']"));
		int noOfDays = days.size();
		System.out.println("No of days - " + noOfDays);
		for(WebElement day : days) {
			String txtDay = day.getText();
			if(txtDay.equalsIgnoreCase("5")) {
				day.click();
				break;
			}
			
			
			System.out.println("Selected date is - " + day.getText());
			
		}
		
		driver.close();
		driver.quit();
	}

}
