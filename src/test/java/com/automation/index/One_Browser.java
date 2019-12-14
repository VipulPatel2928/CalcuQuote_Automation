package com.automation.index;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.utility.CalcuQuote_ExtentManager;
import com.automation.utility.LogClass;
import com.relevantcodes.extentreports.ExtentTest;



public class One_Browser extends CalcuQuote_ExtentManager{
	public static WebDriver driver;
	
	public static int step, numberOfFailure = 1;
	SoftAssert softassertion = new SoftAssert();// For the soft Assertion
	public static com.aventstack.extentreports.ExtentTest logger;// for the log in extent report
	public static ExtentTest test_package;// for the log in extent report
	public static ExtentTest extent_report_log;// for the log in extent report
	// soft assertion
	SoftAssert softAssertion = new SoftAssert();

	// System.out.println("softAssert Method Was Started");
	// softAssertion.assertTrue(false);
	// System.out.println("softAssert Method Was Executed");
	// Below method bring the object for the log in the report
	public static void getTest(ExtentTest test) {
		// TODO Auto-generated method stub
		// test_package = test;
		extent_report_log = test;
		System.out.println("GetTest Method called");
	}

//Login Module Test Cases , dependsOnMethods = { "Signin_TestCase_02" }
	
		

	
	
	@BeforeClass
    public static void beforeMethod() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\eclipse-workspace\\CalcuQuote\\Resources\\chromedriver_2_41.exe");
        driver = new ChromeDriver();
    }
    @AfterClass
    public static void afterMethod() {
    	driver.close();
    	driver.quit();
    }

    @Test
    public void main1() throws InterruptedException {
    	
    	 driver.get("https://www.google.com/");
    	 driver.manage().window().maximize();
    	 driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Hello, Enter the key word you want to search");
    	step = 1;
 		String report_msg;// String for the log in the Report
 		LogClass.logcase(" ");
 		report_msg = "Main()1";
 		LogClass.logExtent(report_msg);
 		
 		if (true) {
			LogClass.logExtent("-----> Main()1 Pass <-----");
			LogClass.AssertPassed();
			Assert.assertTrue(true);
		} 
 		else {
			LogClass.logExtent("-----> Main()1 Fail <-----");
			LogClass.AssertFailed();
			LogClass.AssertFailed_Extent_Report();
			LogClass.makeScreenshot(driver, "Login_fail");
			Assert.assertTrue(false);
		}
 		
    	Thread.sleep(5000);
    }
    @Test
    public void main2() throws InterruptedException {
  
    	driver.get("https://www.mailinator.com/");
    	driver.findElement(By.xpath("//input[@id='inboxfield']")).sendKeys("mailinator");
    	step = 1;
 		String report_msg;// String for the log in the Report
 		LogClass.logcase(" ");
 		report_msg = "Main()2";
 		LogClass.logExtent(report_msg);
 		
 		if (false) {
			LogClass.logExtent("-----> Main()2 Pass <-----");
			LogClass.AssertPassed();
			Assert.assertTrue(true);
		} 
 		else {
			LogClass.logExtent("-----> Main()2 Fail <-----");
			LogClass.AssertFailed();
			LogClass.AssertFailed_Extent_Report();
			LogClass.makeScreenshot(driver, "Login_fail");
			Assert.assertTrue(false);
		}
    	
   	    Thread.sleep(5000);
    	
    }
    @Test
    public void main3() throws InterruptedException {
    	driver.get("http://www.yopmail.com/en/");
    	driver.findElement(By.xpath("//input[@id='login']")).sendKeys("yopmail");
    	step = 1;
 		String report_msg;// String for the log in the Report
 		LogClass.logcase(" ");
 		report_msg = "Main()2";
 		LogClass.logExtent(report_msg);
   	    Thread.sleep(5000);
    }
	
}
