package basePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	
	public static WebDriver driver;
	//public static ExtentHtmlReporter reporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	/*
	@BeforeTest
	public void extentreport()
	{
		driver = new ChromeDriver();
		
		reporter = new ExtentHtmlReporter("./Report/ExtentReport.html");
		
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
	
	*/
	
	@Parameters({"browser"})
	@BeforeTest
	public void setup(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		
		driver.get("https://tutorialsninja.com/demo");
		
	}
}
