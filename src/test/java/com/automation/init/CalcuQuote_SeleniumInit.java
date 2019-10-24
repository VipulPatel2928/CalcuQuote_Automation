package com.automation.init;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.internal.Utils;

import com.automation.indexpage.CalcuQuote_Login_Indexpage;
import com.automation.indexpage.CalcuQuote_RFQ_Indexpage;
import com.automation.indexpage.CalcuQuote_BOM_Indexpage;
import com.automation.indexpage.CalcuQuote_Labor_Indexpage;
import com.automation.indexpage.CalcuQuote_Material_Costing_Indexpage;
import com.automation.indexpage.CalcuQuote_NRE_Indexpage;
import com.automation.indexpage.CalcuQuote_Summary_Indexpage;
import com.automation.indexpage.CalcuQuote_BidCQ_Indexpage;
import com.automation.indexpage.CalcuQuote_ShopCQ_Indexpage;
import com.automation.indexpage.CalcuQuote_SearchCQ_Indexpage;

import com.automation.verification.CalcuQuote_Login_Verification;
import com.automation.verification.CalcuQuote_RFQ_Verification;
import com.automation.verification.CalcuQuote_BOM_Verification;
import com.automation.verification.CalcuQuote_Labor_Verification;
import com.automation.verification.CalcuQuote_MaterialCosting_Verification;
import com.automation.verification.CalcuQuote_NRE_Verification;
import com.automation.verification.CalcuQuote_Summary_Verification;
import com.automation.verification.CalcuQuote_BidCQ_Verification;
import com.automation.verification.CalcuQuote_ShopCQ_Verification;
import com.automation.verification.CalcuQuote_SearchCQ_Verification;

//import com.automation.indexpage.PackageIndexpage_demo;
//import com.automation.indexpage.PackageIndexpage_mobile;
import com.automation.utility.CalcuQuote_Common;
import com.automation.utility.CalcuQuote_CustomReporterBuildSummary;
import com.automation.utility.CalcuQuote_CustomReporterforEmail;
import com.automation.utility.CalcuQuote_TestData;
import com.automation.utility.LogClass;
import com.aventstack.extentreports.ExtentReports;
import com.automation.utility.CalcuQuote_ExtentManager;
public class CalcuQuote_SeleniumInit extends CalcuQuote_ExtentManager {

	String testUrl;
	String seleniumHub;
	String seleniumHubPort;
	public String targetBrowser;
	public String suiteName = "";
	public String testName = "";
	
	public static String username =null;
	public static String password=null;
	public static String userprofilename=null;
	
	public static String q1=null;
	public static String q2=null;
	public static String q3=null;
	public static String q4=null;

	public static WebDriver driver;
	public WebDriver driver1; // Mobile IMPL
			
	protected static String test_data_folder_path = null;
	protected static String screenshot_folder_path = null;
	public static String currentTest;

	public static String browserName = "Default Chrome";
	public static String osName = "";
	public static String browserVersion = "";
	public static String TestCaseName = "";
	public static String TestName = "";
	
	public static CalcuQuote_Login_Indexpage packageIndexpage;
	public static CalcuQuote_Login_Verification packageVerification;
	
	public static CalcuQuote_RFQ_Indexpage rfq_packageIndexpage;
	public static CalcuQuote_RFQ_Verification rfq_packageVerification;
	
	public static CalcuQuote_BOM_Indexpage bom_packageIndexpage;
	public static CalcuQuote_BOM_Verification bom_packageVerification;
	
	public static CalcuQuote_Labor_Indexpage labor_packageIndexpage;
	public static CalcuQuote_Labor_Verification labor_packageVerification;
	
	public static CalcuQuote_Material_Costing_Indexpage material_costing_packageIndexpage;
	public static CalcuQuote_MaterialCosting_Verification material_costing_packageVerification;
	
	public static CalcuQuote_NRE_Indexpage nre_packageIndexpage;
	public static CalcuQuote_NRE_Verification nre_packageVerification;
	
	public static CalcuQuote_Summary_Indexpage summary_packageIndexpage;
	public static CalcuQuote_Summary_Verification summary_packageVerification;
	
	public static CalcuQuote_BidCQ_Indexpage bidcq_packageIndexpage;
	public static CalcuQuote_BidCQ_Verification bidcq_packageVerification;
	
	public static CalcuQuote_ShopCQ_Indexpage shopcq_packageIndexpage;
	public static CalcuQuote_ShopCQ_Verification shopcq_packageVerification;
	
	public static CalcuQuote_SearchCQ_Indexpage searchcq_packageIndexpage;
	public static CalcuQuote_SearchCQ_Verification searchcq_packageVerification;
	
	
	
	//For Extent Report
	
	private static ExtentReports extent;
    private static ThreadLocal parentTest = new ThreadLocal();
    private static ThreadLocal test = new ThreadLocal();
	////For Extent Report End
		
	public static final String URL1 = "https://www.youtube.com/";
	
	@BeforeSuite()
	public void sheetupdate() {
		System.out.println("Excel Sheet Updated for the Latest Result.........");
		//RentCount_TestData.getnumberofrow();  this function has inside function to update the Excel Sheet
	}
	
	@BeforeTest(alwaysRun = true)
	public void fetchSuiteConfiguration(ITestContext testContext) {
     	
		TestName = testContext.getName();
		testUrl = CalcuQuote_TestData.getURL(TestName);// to get URL 1) you can use the excel sheet or 2) just set the variable with the URL want to use.
		System.out.println("Test Name :" +TestName);	
		seleniumHub = testContext.getCurrentXmlTest().getParameter("selenium.host");
		seleniumHubPort = testContext.getCurrentXmlTest().getParameter("selenium.port");
		targetBrowser = testContext.getCurrentXmlTest().getParameter("selenium.browser");
		browserName = testContext.getCurrentXmlTest().getParameter("selenium.browser");
		CalcuQuote_CustomReporterBuildSummary.browsername=browserName;
		CalcuQuote_CustomReporterforEmail.browsername=browserName;
		CalcuQuote_ExtentManager.browsername=browserName;
		System.out.println("Browser Name:"+browserName);
		System.out.println(" Before Test ");
	}

	@BeforeMethod(alwaysRun = true)
	
	public void setUp(Method method, ITestContext testContext) throws Exception {
		
		System.out.println("Set up Start =====");
		String path = "";
		File theDir = new File(path);
        if (!theDir.exists()) {
			System.out.println("creating directory: ");
			boolean result = false;
				
			try {
				theDir.mkdir();
				result = true;
			} catch (SecurityException se) {
				// handle it
			}
			if (result) {
				System.out.println("DIR created");
			}
		}

		URL remote_grid = new URL("http://" + seleniumHub + ":" + seleniumHubPort + "/wd/hub");
		String SCREENSHOT_FOLDER_NAME = "screenshots";
		String TESTDATA_FOLDER_NAME = "test_data";

		test_data_folder_path = new File(TESTDATA_FOLDER_NAME).getAbsolutePath();
		screenshot_folder_path = new File(SCREENSHOT_FOLDER_NAME).getAbsolutePath();
		currentTest = method.getName(); // get Name of current test.

		DesiredCapabilities capability = null;
		if (targetBrowser == null || targetBrowser.contains("firefox")) {
			
			
			FirefoxProfile profile = new FirefoxProfile();
			System.setProperty("webdriver.gecko.driver", "Resources/geckodriver_0_22_64BIT.exe");
			
			final FirefoxOptions options = new FirefoxOptions();
		//	options.addArguments("-profile", "./firefoxprofile"); // Added for CSRF Issue
			
			profile.setPreference("geo.enabled", false);
			profile.setPreference("geo.provider.use_corelocation", false);
			profile.setPreference("geo.prompt.testing", false);
			profile.setPreference("geo.prompt.testing.allow", false);
		//	profile.setPreference("csrf_protection", false);

			capability = DesiredCapabilities.firefox();
			capability.setCapability(FirefoxDriver.PROFILE, profile);	
			capability.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
			capability.setCapability("marionette", true);

			capability.setBrowserName("firefox");
			capability.setJavascriptEnabled(true);
			browserName = capability.getVersion();
			osName = capability.getPlatform().name();
			browserVersion = capability.getVersion();
		
			System.out.println("=========" + "firefox Driver " + "==========");
			driver = new FirefoxDriver(capability);
			   
		} else if (targetBrowser.contains("chrome")) {
			File file = new File("Resources/chromedriver_2_41.exe");

			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

			final ChromeOptions options = new ChromeOptions();
			String downloadFilepath = new File("Downloads").getAbsolutePath();
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilepath);
			System.err.println("File Path ==================" + file.getAbsolutePath());
			options.setExperimentalOption("prefs", chromePrefs);
			capability = DesiredCapabilities.chrome();
			capability.setCapability(ChromeOptions.CAPABILITY, options);

			options.addArguments("no-sandbox");

			options.addArguments("--start-maximized");
			if (CalcuQuote_TestData.getHeadless().contains("Yes")) {
				options.addArguments("headless");
				options.addArguments("--window-size=1920x1080");
			}
			capability.setBrowserName("chrome");
			capability.setJavascriptEnabled(true);
			browserName = capability.getVersion();
			osName = capability.getPlatform().name();
			browserVersion = capability.getVersion();
			// driver = new RemoteWebDriver(new
			// URL("http://172.16.150.12:4444/wd/hub"), capability);
			driver = new ChromeDriver(capability);
			/* driver.manage().window().setSize(new Dimension(1920,1080)); */
			driver.manage().window().maximize();
			System.out.println("=========" + "Chorme Driver " + "==========");
			// driver.setFileDetector(new LocalFileDetector());
		}

		else if (targetBrowser.contains("ie11")) {
			
			capability = DesiredCapabilities.internetExplorer();
			System.setProperty("webdriver.ie.driver", "Resources/IEDriverServer_2_53_1.exe");
			capability.setBrowserName("internet explorer");
			capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			//capability.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			capability.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			capability.setJavascriptEnabled(true);
			//capability.setCapability(CapabilityType.BROWSER_NAME, "IE");
			browserName = capability.getVersion();
			osName = Platform.getCurrent().name();
			browserVersion = capability.getVersion();
			//driver = new RemoteWebDriver(remote_grid, capability);
			driver = new InternetExplorerDriver(capability);
			driver.manage().deleteAllCookies();

		}
			
else if (targetBrowser.contains("browserstack")) {
			
	DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("browser", "Chrome");
	  caps.setCapability("browser_version", "70.0");
	  caps.setCapability("os", "Windows");
	  caps.setCapability("os_version", "10");
	  caps.setCapability("resolution", "1024x768");
	  caps.setCapability("browserstack.selenium_version", "2.53.1");
	//  caps.setCapability("browserstack.local", "true");
	  		
	  driver = new RemoteWebDriver(new URL(URL1), caps);
	  driver.get(testUrl);
	  		
		}

		else if (targetBrowser.contains("m-headless")) {

			FirefoxProfile profile = new FirefoxProfile();
			   profile.setPreference("geo.enabled", false);
			   profile.setPreference("geo.provider.use_corelocation", false);
			   profile.setPreference("geo.prompt.testing", false);
			   profile.setPreference("geo.prompt.testing.allow", false);
			 
			   File file = new File("Resources/geckodriver_0_22.exe");
   
			   FirefoxBinary binary=new FirefoxBinary();
			   binary.addCommandLineOptions("--headless");
   
			   System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
	   
			   FirefoxOptions options=new FirefoxOptions();
			   options.setBinary(binary);
			   options.setCapability(FirefoxDriver.PROFILE, profile);
			   options.addArguments("--window-size=1920x1080");
			   driver=new FirefoxDriver(options);
			  
			   System.out.println("=========" + "Firefox Headless Driver " + "==========");
			  }

		else if (targetBrowser.contains("Android_Chrome")) {
			
			DesiredCapabilities cap= new DesiredCapabilities();
			URL remote_grid1 = null ;
			try {
			remote_grid1 = new URL("http://" + "localhost" + ":" + "4723" + "/wd/hub");
			} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			cap=new DesiredCapabilities();
			//File apkFile = new File("app/Notepad.apk");
			//File apkFile = new File("app/Facebook.apk");
		    //File apkFile = new File("app/redBus Online Bus Ticket Booking Hotel Booking_v6.6.5_apkpure.com.apk");
		    //cap.setCapability("app",apkFile.getAbsolutePath());
			cap.setCapability("platformVersion", "6.0");
			cap.setCapability("platformName", "Android");
			cap.setCapability("deviceName", "HKE6GZ7D");
			cap.setCapability("browserName", "Chrome");
			//cap.setCapability("chromedriverExecutableDir", "C:\\Users\\admin\\eclipse-workspace\\3DBroadCastSales_v1.0\\Resources\\chromedriver.exe");
			/*cap.setCapability("appPackage", "com.app.workpulse.task");
			cap.setCapability("appActivity", "com.workpulse.task.SplashActivity");*/
			cap.setCapability("autoGrantPermissions", true);
			cap.setCapability("noReset", false);//change by vipul
			cap.setCapability("newCommandTimeout", 600);
			cap.setCapability("unicodeKeyboard", true);
			cap.setCapability("resetKeyboard", true);
			cap.setCapability("chromedriverUseSystemExecutable", true);
			//androidDriver = Factory.createAndroidDriver(remote_grid, cap);
		    //driver = new AndroidDriver<MobileElement>(remote_grid1, cap);
			driver = new RemoteWebDriver(remote_grid1, cap);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		}	

		suiteName = testContext.getSuite().getName();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().window().maximize(); //--> Firefox
		testUrl = CalcuQuote_TestData.getURL(TestName);
		driver.get(testUrl);
		packageIndexpage = new CalcuQuote_Login_Indexpage(driver);
		packageVerification = new CalcuQuote_Login_Verification(driver);
		
		rfq_packageIndexpage = new CalcuQuote_RFQ_Indexpage(driver);
		rfq_packageVerification = new CalcuQuote_RFQ_Verification(driver);
		
		bom_packageIndexpage = new CalcuQuote_BOM_Indexpage(driver);
		bom_packageVerification = new CalcuQuote_BOM_Verification(driver);
		
		labor_packageIndexpage = new CalcuQuote_Labor_Indexpage(driver);
		labor_packageVerification = new CalcuQuote_Labor_Verification(driver);
		
		material_costing_packageIndexpage = new CalcuQuote_Material_Costing_Indexpage(driver);
		material_costing_packageVerification = new CalcuQuote_MaterialCosting_Verification(driver);
			
		nre_packageIndexpage = new CalcuQuote_NRE_Indexpage(driver);
		nre_packageVerification = new CalcuQuote_NRE_Verification(driver);
		
		summary_packageIndexpage = new CalcuQuote_Summary_Indexpage(driver);
		summary_packageVerification = new CalcuQuote_Summary_Verification(driver);
		
		bidcq_packageIndexpage = new CalcuQuote_BidCQ_Indexpage(driver);
		bidcq_packageVerification = new CalcuQuote_BidCQ_Verification(driver);
		
		shopcq_packageIndexpage = new CalcuQuote_ShopCQ_Indexpage(driver);
		shopcq_packageVerification = new CalcuQuote_ShopCQ_Verification(driver);
		
		searchcq_packageIndexpage = new CalcuQuote_SearchCQ_Indexpage(driver);
		searchcq_packageVerification = new CalcuQuote_SearchCQ_Verification(driver);
		
		
		
		
		
		
			
	}

	/**
	 * Log For Failure Test Exception.
	 * 
	 * @param tests
	 */
	private void getShortException(IResultMap tests) {

		for (ITestResult result : tests.getAllResults()) {

			Throwable exception = result.getThrowable();
			List<String> msgs = Reporter.getOutput(result);
			boolean hasReporterOutput = msgs.size() > 0;
			boolean hasThrowable = exception != null;
			if (hasThrowable) {
				boolean wantsMinimalOutput = result.getStatus() == ITestResult.SUCCESS;
				if (hasReporterOutput) {
					log("<h3>" + (wantsMinimalOutput ? "Expected Exception" : "Failure Reason:") + "</h3>");
				}

				// Getting first line of the stack trace
				String str = Utils.stackTrace(exception, true)[0];
				Scanner scanner = new Scanner(str);
				String firstLine = scanner.nextLine();
				log(firstLine);
				scanner.close();
			}
		}
	}

	/**
	 * After Method
	 * 
	 * @param testResult
	 */
			
	@AfterMethod(alwaysRun = true)
	
	public void tearDown(ITestResult testResult) {

		ITestContext ex = testResult.getTestContext();

		try {
			testName = testResult.getName();
			System.err.println("----------->         " + testResult.getTestName());
			if (!testResult.isSuccess()) {

				/* Print test result to Jenkins Console */
				System.out.println();
				System.out.println("======================++++   >>  ");
				System.out.println("TEST FAILED - " + testName);
				System.out.println();
				System.out.println("ERROR MESSAGE: " + testResult.getThrowable());
				System.out.println("\n");
				Reporter.setCurrentTestResult(testResult);

				/* Make a screenshot for test that failed */
				String screenshotName = CalcuQuote_Common.getCurrentTimeStampString() + testName;
				//Reporter.log("<br> <b>Please look to the screenshot - </b>");
				LogClass.makeScreenshot(driver, screenshotName);
				// Reporter.log(testResult.getThrowable().getMessage());
				getShortException(ex.getFailedTests());
				//LogClass.logStatus("Fail");
				driver.close();
				driver.quit();

			} else {
				try {
					CalcuQuote_Common.pause(5);
					CalcuQuote_Common.pause(5);
				} catch (Exception e) {
					log("<br></br> Not able to perform logout");
				}

				System.out.println("TEST PASSED - " + testName + "\n");

				System.out.println("here is test status--------------------" + testResult.getStatus());

				driver.close();
				driver.quit();
			}

		} catch (Throwable throwable) {
			System.out.println("message from tear down" + throwable.getMessage());
		}
		
	}
	
	
	
	@AfterSuite()
	public void zipfileupdate() throws IOException {
		System.out.println("Calling ZipFile for the Extent Report.........");
		//for the Extent Report Zip 
		String dataFilePath = "test-output/screenshots/Extent_Report_new.html";
		File datafile = new File(dataFilePath);
		String INPUT_FILE = datafile.getAbsolutePath();
		//String dataFilePath1 = "test-output/screenshots/Extent_Report_new.zip"; //original zip file statement
		String dataFilePath1 = "test-output/Extent_Report_new.zip";
		File datafile1 = new File(dataFilePath1);
		String OUTPUT_FILE = datafile1.getAbsolutePath();
	    CalcuQuote_Common.zipFile(new File(INPUT_FILE), OUTPUT_FILE); //This function Zip the single file
	    //End for the Extent Report Zip use 
	    //C:\Users\User\eclipse-workspace\RentCount_UK\Resources\[3DBroadCastSales]-Script_Result.xlsx
	    
	    
	    /*String dataFilePath_xlsx = "Resources/[3DBroadCastSales]-Script_Result.xlsx";
		File datafile_xlsx = new File(dataFilePath_xlsx);
		String INPUT_FILE_xlsx = datafile_xlsx.getAbsolutePath();
		String dataFilePath_xlsx1 = "RentCount_UK/[3DBroadCastSales]-Script_Result.zip";
		File datafile_xlsx1 = new File(dataFilePath_xlsx1);
		String OUTPUT_FILE_xlsx = datafile_xlsx1.getAbsolutePath();
	    RentCount_Common.zipFile(new File(INPUT_FILE_xlsx), OUTPUT_FILE_xlsx); //This function Zip the single file
*/	    
	    CalcuQuote_Common.zipdirectory();//This function Zip the Directory/Folder
	}

	/**
	 * Log given message to Reporter output.
	 * 
	 * @param msg
	 *            Message/Log to be reported.
	 */
	public static void log(String msg) {
		System.out.println(msg);
		Reporter.log("<br></br>" + msg);
	}
	
	public void android_implement() {
		// TODO Auto-generated method stub
		DesiredCapabilities cap= new DesiredCapabilities();
		URL remote_grid1 = null ;
		try {
		remote_grid1 = new URL("http://" + "localhost" + ":" + "4723" + "/wd/hub");
		} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		cap=new DesiredCapabilities();
	//	File apkFile = new File("app/redBus Online Bus Ticket Booking Hotel Booking_v6.6.5_apkpure.com.apk");

	//	cap.setCapability("app",apkFile.getAbsolutePath());
		cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome"); // Impl AndroidDriver
		cap.setCapability("platformVersion", "6.0");
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "TA09407DYT");
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("noReset", false);//change by vipul
		cap.setCapability("newCommandTimeout", 600);
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
		cap.setCapability("forceMjsonwp", true);

		driver1 = new RemoteWebDriver(remote_grid1, cap);
	//	packageIndexpage_mobile = new PackageIndexpage_mobile(driver1);
	//	packageVerification_mobile = new PackageVerification_mobile(driver1);
		driver1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
	}

	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
	
}


