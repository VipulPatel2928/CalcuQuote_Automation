package com.automation.index;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.automation.utility.LogClass;
import com.automation.utility.funcs;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.automation.init.CalcuQuote_SeleniumInit;

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

public class CalcuQuote_Labor_Index extends CalcuQuote_SeleniumInit{
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
	
	// Labor Module TestCases , dependsOnMethods="BOM_TestCase_01"
	@Test(priority = 0, enabled = true)
	public void Labor_TestCase_01() {
		step = 1;
		String report_msg;// String for the log in the Report
		
		report_msg = "CalcuQuote_Labor::To verify that user is able to enter the labor activities in RFQ";
		LogClass.logExtent(report_msg);

		report_msg = "Step " + (step++) + ":Open : https://qa.calcuquote.com/Staging2/";
		LogClass.logExtent(report_msg);
		
		if (packageVerification.homepageverify()) {
			LogClass.VerificationPass_Extent_Report("-----> Verified CalcuQuote home page is open <-----");
			LogClass.AssertPass_Extent_Report();
			Assert.assertTrue(true);
		} else {
			LogClass.VerificationFailed_Extent_Report("-----> Verified CalcuQuote home page is not open <-----");			
			LogClass.AssertFailed_Extent_Report();
			LogClass.makeScreenshot(driver, "Labor_Login_fail");
			// softAssertion.assertTrue(false);
			Assert.assertTrue(false);
		}

		report_msg = "Step " + (step++) + ": Enter Valid Credentials";
		LogClass.logExtent(report_msg);
		packageVerification = CalcuQuote_Login_Indexpage.CalcuQuote_Valid_Credentials();

		report_msg = "Step " + (step++) + ": Select one of the existing RFQ";
		LogClass.logExtent(report_msg);
		packageVerification = CalcuQuote_Login_Indexpage.select_rfq();
		
		
		report_msg = "Step " + (step++) + ": Import BOM";
		LogClass.logExtent(report_msg);
		
		CalcuQuote_BOM_Indexpage.filepath="Resources/35LineBOM.xlsx" ;
		bom_packageVerification = CalcuQuote_BOM_Indexpage.ImportBOM();
		
		if (bom_packageVerification.BOM_imported()) {
			LogClass.VerificationPass_Extent_Report("-----> Verified BOM Imported Successfully <-----");
			//LogClass.AssertPass_Extent_Report();
			Assert.assertTrue(true);
		} else {
			LogClass.VerificationFailed_Extent_Report("-----> Verified BOM is not imported Successfully <-----");					
			LogClass.AssertFailed_Extent_Report();
			LogClass.makeScreenshot(driver, "BOM_import_fail");
			// softAssertion.assertTrue(false);
			Assert.assertTrue(false);
		}
		
		report_msg = "Step " + (step++) + ": Submit BOM";
		LogClass.logExtent(report_msg);
		bom_packageVerification = CalcuQuote_BOM_Indexpage.clicksubmitBOM();
		
		if (bom_packageVerification.BOM_submit()) {
			LogClass.VerificationPass_Extent_Report("-----> Verified Submit BOM is in progress <-----");
			//LogClass.AssertPass_Extent_Report();
			Assert.assertTrue(true);
		} else {
			LogClass.VerificationFailed_Extent_Report("-----> Verified Submit BOM is in progress msg not displayed <-----");					
			LogClass.AssertFailed_Extent_Report();
			LogClass.makeScreenshot(driver, "BOM_submission_fail");
			// softAssertion.assertTrue(false);
			Assert.assertTrue(false);
		}
		
	   driver.navigate().refresh();
	   funcs.waitforseconds(5);
				
		report_msg = "Step " + (step++) + ": Select Labor Activity/Activities";
		LogClass.logExtent(report_msg);
		labor_packageVerification = CalcuQuote_Labor_Indexpage.labor_activities();
		
		
		if (labor_packageVerification.laboractivity_added_verification()) {
			LogClass.VerificationPass_Extent_Report("-----> Verified Labor Activity Added Successfully <-----");
			LogClass.AssertPass_Extent_Report();
			Assert.assertTrue(true);
		} else {
			LogClass.VerificationFailed_Extent_Report("-----> Verified Labor Activity is not Added Successfully <-----");		
			LogClass.AssertFailed_Extent_Report();
			LogClass.makeScreenshot(driver, "Labor_activity_fail");
			// softAssertion.assertTrue(false);
			Assert.assertTrue(false);
		}
		
		report_msg = "Step " + (step++) + ": Submit Labor";
		LogClass.logExtent(report_msg);
		labor_packageVerification = CalcuQuote_Labor_Indexpage.clicksubmitLabor();
		
		if (labor_packageVerification.laboractivity_submit()) {
			LogClass.VerificationPass_Extent_Report("-----> Verified Labor Costs added to the Quote <-----");
			LogClass.AssertPass_Extent_Report();
			Assert.assertTrue(true);
		} else {
			LogClass.VerificationFailed_Extent_Report("-----> Verified Labor Costs not added to the Quote <-----");		
			LogClass.AssertFailed_Extent_Report();
			LogClass.makeScreenshot(driver, "Labor_submission_fail");
			// softAssertion.assertTrue(false);
			Assert.assertTrue(false);
		}
		
	}//End of Labor_TestCase_01 
}
