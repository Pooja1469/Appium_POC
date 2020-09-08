package tests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	static AppiumDriver<MobileElement> driver; // initialize driver
	
	@BeforeSuite
	public void setup()  
	{
		try {
			
        DesiredCapabilities cap = new DesiredCapabilities();  // initialize DesiredCapabilities
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "OP5T");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		cap.setCapability(MobileCapabilityType.UDID, "375d34e3");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"60");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("w3c", false);
		cap.merge(chromeOptions);
		
		//cap.setCapability("appPackage", "com.directferries.ferryapp");  
		//cap.setCapability("appActivity", "com.oneplus.calculator.Calculator");  
		
		
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url,cap);
			
	
			
		} catch (Exception e) {
		
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	public void testone()
	{
		System.out.println("APP STARTED");
				
	}
	
		
	@AfterSuite	
	public void teardown() {
		driver.close();
		driver.close();
	}

}
