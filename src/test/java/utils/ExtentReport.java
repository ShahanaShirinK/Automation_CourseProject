package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReport {

WebDriver driver;
	
	ExtentSparkReporter reporter;
	ExtentReports reports;
	ExtentTest test;
	
	
	@BeforeTest
	public void setUp()
	{
		driver = new ChromeDriver();
		
		reporter = new ExtentSparkReporter("./Report/PReport.html");
		
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Functional Report");
		reporter.config().setTheme(Theme.STANDARD);
		
		
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		
		reports.setSystemInfo("Host Name", "Local Host");
		reports.setSystemInfo("Operating System", "Windows11");
		reports.setSystemInfo("Tester Name", "Shahana Shirin K");
		reports.setSystemInfo("Browser Name", "Chrome");	
		
	}
	
	
	
	@BeforeMethod
	public void beforemethod()
	{
		driver.get("https://www.facebook.com");
		
	}
	
	
	@Test
	public void FBtitleverification()
	{
		test = reports.createTest("FBtitleverification");
		
		String actualtitle = driver.getTitle();
		String expectedtitle = "Facebook";
		
		Assert.assertEquals(actualtitle, expectedtitle);
	}
	
	
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException
	{
		if(result.getStatus()== ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "Name of the Test failed is "+ result.getName() );
			test.log(Status.FAIL, "Test failed because"+ result.getThrowable());
			
			
			String ssstoredpath= ExtendReport.screenshotMethod(driver, result.getName());
			test.addScreenCaptureFromPath(ssstoredpath);
			
			
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			test.log(Status.SKIP, "Name of the test skipped is"+ result.getName());
		}
		else if(result.getStatus()== ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Name of the test passed is"+ result.getName());
		}
	}
	
	public static String screenshotMethod(WebDriver driver,String Screenshotname) throws IOException
	{
		File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination = "./Screenshots/"+Screenshotname+".jpeg";
		FileHandler.copy(screenshot, new File(destination));
		return destination;
	}
	
	
	@AfterTest
	public void teardown()
	{
		reports.flush();
	}
}
