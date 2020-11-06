package testNGPrograms;

import org.testng.annotations.DataProvider;

public class Dp {

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
