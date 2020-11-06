package testNGPrograms;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class Grouping {
	
	@BeforeGroups
	public void login() {	
		System.out.println("Login Successful.");
	}
	
	@Test(groups= {"sanity", "regression"}, priority = -1)
	public void search() {	
		System.out.println("Search Value Entered.");
	}
	
	@Test(groups= {"sanity"}, priority = 0)
	public void searchFromDropdown() {	
		System.out.println("Search from dropdown chosen successfully.");
	}
	
	@Test(groups= {"regression"}, priority = 1)
	public void courseSelect() {	
		System.out.println("Specific Course Selected.");
	}
	
	@Test(groups= {"sanity"}, priority = 10, enabled = false)
	public void contentUpdate() {	
		System.out.println("Content is updated");
	}
	
	@AfterGroups
	public void logout() {	
		System.out.println("Logged out successfully.");
	}

}
