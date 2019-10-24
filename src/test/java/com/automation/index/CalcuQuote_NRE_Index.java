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

public class CalcuQuote_NRE_Index extends CalcuQuote_SeleniumInit{
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
	
	//NRE Module Test Cases	, dependsOnMethods = { "Signin_TestCase_01", "RFQ_TestCase_01" ,"BOM_TestCase_01"}
		@Test(priority = 0, enabled = true)
		public void NRE_TestCase_01() {
			step = 1;
			String report_msg;// String for the log in the Report
			LogClass.logcase(" ");
			report_msg = "CalcuQuote_NRE::To verify that user is able to create NRE and Update the NRE values";
			LogClass.logcase(report_msg);
			LogClass.logExtent(report_msg);

			report_msg = "Step " + (step++) + ":Open : https://qa.calcuquote.com/Staging2/";
			LogClass.logstep(report_msg);
			LogClass.logExtent(report_msg);
			if (packageVerification.homepageverify()) {
				LogClass.logveri("-----> Verified CalcuQuote home page is open <-----");
				LogClass.logExtent("-----> Verified CalcuQuote home page is open <-----");
				LogClass.AssertPassed();
				Assert.assertTrue(true);
			} else {
				LogClass.logveri("-----> Verified CalcuQuote home page is not open <-----");
				LogClass.logExtent("-----> Verified CalcuQuote home page is not open <-----");
				LogClass.AssertFailed();
				LogClass.AssertFailed_Extent_Report();
				LogClass.makeScreenshot(driver, "NRE_Login_fail");
				// softAssertion.assertTrue(false);
				Assert.assertTrue(false);
			}

			report_msg = "Step " + (step++) + ": Enter Valid Credentials";
			LogClass.logstep(report_msg);
			LogClass.logExtent(report_msg);
			packageVerification = CalcuQuote_Login_Indexpage.CalcuQuote_Valid_Credentials();

			report_msg = "Step " + (step++) + ": Select one of the existing RFQ";
			LogClass.logstep(report_msg);
			LogClass.logExtent(report_msg);
			packageVerification = CalcuQuote_Login_Indexpage.select_rfq();

			report_msg = "Step " + (step++) + ": Create NRE Standard and optional";
			LogClass.logstep(report_msg);
			LogClass.logExtent(report_msg);
			nre_packageVerification = CalcuQuote_NRE_Indexpage.create_NRE();

			report_msg = "Step " + (step++) + ": Verification Start for the Test Case";
			LogClass.logstep(report_msg);
			LogClass.logExtent(report_msg);

			if (nre_packageVerification.CalcuQuote_NRE_calculation_verification()) {
				LogClass.logveri("-----> Verified NRE Calculation Successfully <-----");
				LogClass.logExtent("-----> Verified NRE Calculation Successfully <-----");
				LogClass.AssertPassed();
				Assert.assertTrue(true);
			} else {
				LogClass.logveri("-----> NOT Verified NRE Calculation Successfully <-----");
				LogClass.logExtent("-----> NOT Verified NRE Calculation Successfully <-----");
				LogClass.AssertFailed();
				LogClass.AssertFailed_Extent_Report();
				LogClass.makeScreenshot(driver, "NRE_Creation_fail");
				// softAssertion.assertTrue(false); Assert.assertTrue(false);
			}

			report_msg = "Step " + (step++) + ": Submit NRE";
			LogClass.logstep(report_msg);
			LogClass.logExtent(report_msg);
			nre_packageVerification = CalcuQuote_NRE_Indexpage.clicksubmitnre();
			 
			
		}// End of NRE_TestCase_01().

}