package tests;

import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Extent_report_demo {
	
	  ExtentHtmlReporter htmlReporter;
	  ExtentReports extent ;
	
	@BeforeSuite
	public void reportSetup()
	{
		 htmlReporter = new ExtentHtmlReporter("extent.html");
	    
        // create ExtentReports and attach reporter(s)
         extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

	}
	
		
	@AfterSuite
	public void reportTeardown()
	{
		// calling flush writes everything to the log file
		extent.flush();
	}

}
