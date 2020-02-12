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

public class CalcuQuote_BOM_Index extends CalcuQuote_SeleniumInit{

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

	//BOM Module TestCases , dependsOnMethods="BOM_TestCase_02"
		@Test(priority = 0, enabled = true)
		public void BOM_TestCase_01() {

			step = 1;
			String report_msg;// String for the log in the Report
			
			
			report_msg = "CalcuQuote_BOM::To verify that user is able to Import BOM and Submit.";
			LogClass.logExtent(report_msg);
			
			report_msg = "Step " + (step++) + ":Open : https://qa.calcuquote.com/Staging2/";
			LogClass.logExtent(report_msg);
			
			if (packageVerification.homepageverify()) {
				LogClass.VerificationPass_Extent_Report("-----> Verified CalcuQuote home page is open <-----");			
				Assert.assertTrue(true);
			} else {
				LogClass.VerificationFailed_Extent_Report("-----> Verified CalcuQuote home page is not open <-----");				
				LogClass.AssertFailed_Extent_Report();
				LogClass.makeScreenshot(driver, "BOM_Login_fail");
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
			bom_packageVerification = CalcuQuote_BOM_Indexpage.ImportBOMorg();
			
			if (bom_packageVerification.BOM_imported()) {				
				LogClass.VerificationPass_Extent_Report("-----> Verified BOM Imported Successfully <-----");			
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
			bom_packageVerification = CalcuQuote_BOM_Indexpage.clicksubmitBOM_manual();
			
			if (bom_packageVerification.BOM_submit()) {				
				LogClass.VerificationPass_Extent_Report("-----> Verified Submit BOM is in progress <-----");
				Assert.assertTrue(true);
			} else {			
				LogClass.VerificationFailed_Extent_Report("-----> Verified Submit BOM is in progress msg not displayed <-----");
				LogClass.AssertFailed_Extent_Report();
				LogClass.makeScreenshot(driver, "BOM_submission_fail");
				// softAssertion.assertTrue(false);
				Assert.assertTrue(false);
			}

				
		}// End of BOM_TestCase_01
		
		@Test(priority = 0, enabled = true)
		public void BOM_TestCase_02() {
			step = 1;
			String report_msg;// String for the log in the Report
		
			report_msg = "CalcuQuote_BOM::To verify that user is able to Add Manual line Item";
			LogClass.logExtent(report_msg);
		
			report_msg = "Step " + (step++) + ":Open : https://qa.calcuquote.com/Staging2/";
			LogClass.logExtent(report_msg);
			
			if (packageVerification.homepageverify()) {
				LogClass.logExtent("-----> Verified CalcuQuote home page is open <-----");				
				Assert.assertTrue(true);
			} else {
				LogClass.logExtent("-----> Verified CalcuQuote home page is not open <-----");				
				LogClass.AssertFailed_Extent_Report();
				LogClass.makeScreenshot(driver, "BOM_manual_line_item_Login_fail");
				// softAssertion.assertTrue(false);
				Assert.assertTrue(false);
			}

			report_msg = "Step " + (step++) + ": Enter Valid Credentials";
			LogClass.logExtent(report_msg);
			packageVerification = CalcuQuote_Login_Indexpage.CalcuQuote_Valid_Credentials();
			
			report_msg = "Step " + (step++) + ": Select one of the existing RFQ";
			LogClass.logExtent(report_msg);
			packageVerification = CalcuQuote_Login_Indexpage.select_rfq();
			
			report_msg = "Step " + (step++) + ": Add Line Item Manually";
			LogClass.logExtent(report_msg);
			bom_packageVerification = CalcuQuote_BOM_Indexpage.addlineitemmanually();
			
			report_msg = "Step " + (step++) + ": Submit BOM";
			LogClass.logExtent(report_msg);
			bom_packageVerification = CalcuQuote_BOM_Indexpage.clicksubmitBOM();
			
			if (bom_packageVerification.BOM_submit()) {				
				LogClass.VerificationPass_Extent_Report("-----> Verified Submit BOM is in progress <-----");
				Assert.assertTrue(true);
			} else {			
				LogClass.VerificationFailed_Extent_Report("-----> Verified Submit BOM is in progress msg not displayed <-----");
				LogClass.AssertFailed_Extent_Report();
				LogClass.makeScreenshot(driver, "BOM_submission_fail");
				// softAssertion.assertTrue(false);
				Assert.assertTrue(false);
			}
			funcs.waitforseconds(5);
		}// End of BOM_TestCase_02 		
}
