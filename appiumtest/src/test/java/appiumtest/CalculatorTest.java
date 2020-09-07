package appiumtest;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CalculatorTest {
	
	static AppiumDriver<MobileElement> driver; // initialize driver
	//AdroidDriver driver;  
	//WebDriver driver;

	public static void main(String[] args)
	{
		try {
			openCalculator();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void openCalculator() throws Exception	
	{
		DesiredCapabilities cap = new DesiredCapabilities();  // initialize DesiredCapabilities
		
		cap.setCapability("deviceName", "OP5T");
		cap.setCapability("udid", "192.168.1.101:5555");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");
		cap.setCapability("appPackage", "com.oneplus.calculator");  
		cap.setCapability("appActivity", "com.oneplus.calculator.Calculator");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AppiumDriver<MobileElement>(url,cap); // pass DesiredCapabilities to driver
		
		System.out.println("Application started");
		
		// perform operations on calculator
		
	    MobileElement valX =  driver.findElement(By.id("com.oneplus.calculator:id/digit_9"));
	    valX.click();
	    
	    MobileElement add = driver.findElement(By.id("com.oneplus.calculator:id/op_add"));
	    add.click();
	    
	    MobileElement valY = driver.findElement(By.id("com.oneplus.calculator:id/digit_3"));
	    valY.click();
	    
	    MobileElement equalsTo = driver.findElement(By.id("com.oneplus.calculator:id/eq"));
	    equalsTo.click();
	    
	    
	    MobileElement output = driver.findElement(By.id("com.oneplus.calculator:id/result"));
	    String finalOutput = output.getText();
	    
	    System.out.println(finalOutput);
		   
	    //Verify output is correct
	    
	    if(finalOutput == "12")
	    { 
	    	System.out.println("Test passed");
	    	
	    }
	    
	   	    
	}
}
