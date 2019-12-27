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

public class CalcuQuote_RFQ_Index extends CalcuQuote_SeleniumInit{
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
	
	//RFQ Module Test Cases	, dependsOnMethods = "Signin_TestCase_01"
		@Test(priority = 0, enabled = true)
		public void RFQ_TestCase_01() {

			step = 1;
			String report_msg;// String for the log in the Report
			report_msg = "CalcuQuote_RFQ:To verify that user is able to create RFQ with multiple Quantities";
			LogClass.logExtent(report_msg);

			report_msg = "Step " + (step++) + ":Open : https://qa.calcuquote.com/Staging2/";
			LogClass.logExtent(report_msg);
			if (packageVerification.homepageverify()) {
				LogClass.VerificationPass_Extent_Report("-----> Verified CalcuQuote home page is open <-----");				
				Assert.assertTrue(true);
			} else {
				LogClass.VerificationFailed_Extent_Report("-----> Verified CalcuQuote home page is not open <-----");				
				LogClass.AssertFailed_Extent_Report();
				LogClass.makeScreenshot(driver, "RFQ_Login_fail");
				// softAssertion.assertTrue(false);
				Assert.assertTrue(false);
			}

			report_msg = "Step " + (step++) + ": Enter Valid Credentials";
			LogClass.logExtent(report_msg);
			packageVerification = CalcuQuote_Login_Indexpage.CalcuQuote_Valid_Credentials();

			report_msg = "Step " + (step++) + ": RFQ with multiple quantities";
			LogClass.logExtent(report_msg);
			rfq_packageVerification = CalcuQuote_RFQ_Indexpage.RFQ();

			if (rfq_packageVerification.rfqsubmitted()) {
				//LogClass.logExtent("-----> Verified RFQ Submitted Successfully <-----");
				LogClass.VerificationPass_Extent_Report("-----> Verified RFQ Submitted Successfully <-----");			
				Assert.assertTrue(true);
			} else {
				//LogClass.logExtent("-----> Verified RFQ is not Submitted Successfully <-----");
				LogClass.VerificationFailed_Extent_Report("-----> Verified RFQ is not Submitted Successfully <-----");		
				LogClass.AssertFailed_Extent_Report();
				LogClass.makeScreenshot(driver, "RFQ_Submission_fail");
				// softAssertion.assertTrue(false);
				Assert.assertTrue(false);
			}

		}// End of RFQ_TestCase_01.

}
