package Udemy_Selenium.Udemy_Selenium;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo
{
	ExtentReports extent;


	@BeforeTest
	public void config()
	{
		//need two classes 1.ExtentReports 2.ExtentSparkReporter
		String path =System.getProperty("user.dir")+"\\reports\\index.html";		
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ashutosh Gupta");
		}
	@Test
	public void ExtentRepo()
	{
	ExtentTest test	=extent.createTest("ExtentRepo");
	System.setProperty("webdriver.chromedriver.silentoutput", "true")	;
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.facebook.com");
	System.out.println(driver.getTitle());
	driver.close();
	//test.fail("Result do not match");
	extent.flush();
	}
}