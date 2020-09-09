package tests;

import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass extends Extent_report_demo {

	// static AppiumDriver<MobileElement> driver; // initialize driver

	WebDriver driver;

	@BeforeTest
	public void setup() {
		try {

			DesiredCapabilities cap = new DesiredCapabilities(); // initialize DesiredCapabilities

			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "OP5T");
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
			cap.setCapability(MobileCapabilityType.UDID, "375d34e3");
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
			cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("w3c", false);
			cap.merge(chromeOptions);

			// cap.setCapability("appPackage", "com.directferries.ferryapp");
			// cap.setCapability("appActivity", "com.oneplus.calculator.Calculator");

			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new RemoteWebDriver(url, cap);

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(e.getMessage()); 
		}

	}

	@Test
	public void testone() {
		// creates a toggle for the given test, adds all log events under it
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");

		test.log(Status.PASS, "test one started");

		System.out.println("APP STARTED");

	}

	@AfterSuite
	public void teardown() {
		// driver.close();
		// driver.close();
	}

}
