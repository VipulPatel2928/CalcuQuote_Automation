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

public class CalcuQuote_Login_Index extends CalcuQuote_SeleniumInit {

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
	@Test(priority = 0, enabled = true)
	public void Signin_TestCase_01() {

		step = 1;
		String report_msg;// String for the log in the Report
		LogClass.logcase(" ");
		report_msg = "CalcuQuote_Login::To verify that user is able to login with valid credentials";
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
			LogClass.makeScreenshot(driver, "Login_fail");
			// softAssertion.assertTrue(false);
			Assert.assertTrue(false);
		}

		report_msg = "Step " + (step++) + ": Enter Valid Credentials";
		LogClass.logExtent(report_msg);
		packageVerification = CalcuQuote_Login_Indexpage.CalcuQuote_Valid_Credentials();

		report_msg = "Step " + (step++) + ": Verification Start for the Test Case";
		LogClass.logExtent(report_msg);
		if (packageVerification.CalcuQuote_login_verification()) {
			LogClass.VerificationPass_Extent_Report("-----> Verified User has Logged in Successfully <-----");
			LogClass.AssertPass_Extent_Report();
			Assert.assertTrue(true);
		} else {
			LogClass.VerificationFailed_Extent_Report("-----> Verified User has Not Logged in Successfully <-----");			
			LogClass.AssertFailed_Extent_Report();
			LogClass.makeScreenshot(driver, "Login_fail");
			// softAssertion.assertTrue(false);
			Assert.assertTrue(false);
		}

	}// End of Signin_TestCase_01.

	@Test(priority = 0, enabled = true)
	public void Signin_TestCase_02() {
		step = 1;
		String report_msg;// String for the log in the Report
		report_msg = "CalcuQuote_Login::To verify that User gets validation messages for the invalid credentials";
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
			LogClass.makeScreenshot(driver, "Login_fail");
			// softAssertion.assertTrue(false);
			Assert.assertTrue(false);
		}

		report_msg = "Step " + (step++) + ": Enter inValid Credentials";
		LogClass.logExtent(report_msg);
		packageVerification = CalcuQuote_Login_Indexpage.CalcuQuote_inValid_Credentials();

	}// End of Signin_TestCase_02.
	
}// End of Class
