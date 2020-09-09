package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Tests extends BaseClass {
	
	@Test 
	public void testtwo()
	{
		
		 // creates a toggle for the given test, adds all log events under it    
        ExtentTest test = extent.createTest("MySecondTest");
        
        test.log(Status.PASS, "test two started");
        
		driver.get("https://google.com");
		
	    test.log(Status.PASS, "Navigated to website");
		 
		driver.findElement(By.name("q")).sendKeys("Automation");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
	    test.log(Status.PASS, "Search completed");
		
		System.out.println("Test two completed...");
		
		test.log(Status.INFO, "Test two completed");
	}

}
