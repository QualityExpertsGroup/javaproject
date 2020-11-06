package testNGPrograms;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {
	@Test
	  public void test1() {
		  System.out.println("Inside test 1 method");
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("Inside beforeMethod");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("Inside afterMethod");
	  }

	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("Inside beforeClass");
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("Inside afterClass");
	  }

	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("Inside beforeTest");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("Inside afterTest");
	  }

	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("Inside beforeSuite");
	  }

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("Inside afterSuite");
	  }

}
