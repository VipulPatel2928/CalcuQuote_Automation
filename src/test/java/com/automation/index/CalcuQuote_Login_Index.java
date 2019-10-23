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

//Login Module Test Cases
	@Test(priority = 0, enabled = true, dependsOnMethods = { "Signin_TestCase_02" })
	public void Signin_TestCase_01() {

		step = 1;
		String report_msg;// String for the log in the Report
		LogClass.logcase(" ");
		report_msg = "CalcuQuote_Login::To verify that user is able to login with valid credentials";
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
			LogClass.makeScreenshot(driver, "Login_fail");
			// softAssertion.assertTrue(false);
			Assert.assertTrue(false);
		}

		report_msg = "Step " + (step++) + ": Enter Valid Credentials";
		LogClass.logstep(report_msg);
		LogClass.logExtent(report_msg);
		packageVerification = CalcuQuote_Login_Indexpage.CalcuQuote_Valid_Credentials();

		report_msg = "Step " + (step++) + ": Verification Start for the Test Case";
		LogClass.logstep(report_msg);
		LogClass.logExtent(report_msg);
		if (packageVerification.CalcuQuote_login_verification()) {
			LogClass.logveri("-----> Verified User has Logged in Successfully <-----");
			LogClass.logExtent("-----> Verified User has Logged in Successfully <-----");
			LogClass.AssertPassed();
			Assert.assertTrue(true);
		} else {
			LogClass.logveri("-----> Verified User has Not Logged in Successfully <-----");
			LogClass.logExtent("-----> Verified User has Not Logged in Successfully <-----");
			LogClass.AssertFailed();
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
		LogClass.logcase(" ");
		report_msg = "CalcuQuote_Login::To verify that User gets validation messages for the invalid credentials";
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
			LogClass.makeScreenshot(driver, "Login_fail");
			// softAssertion.assertTrue(false);
			Assert.assertTrue(false);
		}

		report_msg = "Step " + (step++) + ": Enter inValid Credentials";
		LogClass.logstep(report_msg);
		LogClass.logExtent(report_msg);
		packageVerification = CalcuQuote_Login_Indexpage.CalcuQuote_inValid_Credentials();

	}// End of Signin_TestCase_02.

//NRE Module Test Cases	
	@Test(priority = 0, enabled = true, dependsOnMethods = { "Signin_TestCase_01", "RFQ_TestCase_01" ,"BOM_TestCase_01"})
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
		packageVerification = CalcuQuote_Login_Indexpage.create_NRE();

		report_msg = "Step " + (step++) + ": Verification Start for the Test Case";
		LogClass.logstep(report_msg);
		LogClass.logExtent(report_msg);

		if (packageVerification.CalcuQuote_NRE_calculation_verification()) {
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
		packageVerification = CalcuQuote_Login_Indexpage.clicksubmitnre();
		 
		
	}// End of NRE_TestCase_01().

//RFQ Module Test Cases	
	@Test(priority = 0, enabled = true, dependsOnMethods = "Signin_TestCase_01")
	public void RFQ_TestCase_01() {

		step = 1;
		String report_msg;// String for the log in the Report
		LogClass.logcase(" ");
		report_msg = "CalcuQuote_RFQ:To verify that user is able to create RFQ with multiple Quantities";
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
			LogClass.makeScreenshot(driver, "RFQ_Login_fail");
			// softAssertion.assertTrue(false);
			Assert.assertTrue(false);
		}

		report_msg = "Step " + (step++) + ": Enter Valid Credentials";
		LogClass.logstep(report_msg);
		LogClass.logExtent(report_msg);
		packageVerification = CalcuQuote_Login_Indexpage.CalcuQuote_Valid_Credentials();

		report_msg = "Step " + (step++) + ": RFQ with multiple quantities";
		LogClass.logstep(report_msg);
		LogClass.logExtent(report_msg);
		packageVerification = CalcuQuote_Login_Indexpage.RFQ();

		if (packageVerification.rfqsubmitted()) {
			LogClass.logveri("-----> Verified RFQ Submitted Successfully <-----");
			LogClass.logExtent("-----> Verified RFQ Submitted Successfully <-----");
			LogClass.AssertPassed();
			Assert.assertTrue(true);
		} else {
			LogClass.logveri("-----> Verified RFQ is not Submitted Successfully <-----");
			LogClass.logExtent("-----> Verified RFQ is not Submitted Successfully <-----");
			LogClass.AssertFailed();
			LogClass.AssertFailed_Extent_Report();
			LogClass.makeScreenshot(driver, "RFQ_Submission_fail");
			// softAssertion.assertTrue(false);
			Assert.assertTrue(false);
		}

	}// End of RFQ_TestCase_01.
	
//BOM Module TestCases 
	@Test(priority = 0, enabled = true, dependsOnMethods="RFQ_TestCase_01")
	public void BOM_TestCase_01() {

		step = 1;
		String report_msg;// String for the log in the Report
		LogClass.logcase(" ");
		report_msg = "CalcuQuote_BOM::To verify that user is able to Import BOM and Submit.";
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
			LogClass.makeScreenshot(driver, "BOM_Login_fail");
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
		
		report_msg = "Step " + (step++) + ": Import BOM";
		LogClass.logstep(report_msg);
		LogClass.logExtent(report_msg);
		packageVerification = CalcuQuote_Login_Indexpage.ImportBOM();
		
		if (packageVerification.BOM_imported()) {
			LogClass.logveri("-----> Verified BOM Imported Successfully <-----");
			LogClass.logExtent("-----> Verified BOM Imported Successfully <-----");
			LogClass.AssertPassed();
			Assert.assertTrue(true);
		} else {
			LogClass.logveri("-----> Verified BOM is not imported Successfully <-----");
			LogClass.logExtent("-----> Verified BOM is not imported Successfully <-----");
			LogClass.AssertFailed();
			LogClass.AssertFailed_Extent_Report();
			LogClass.makeScreenshot(driver, "BOM_import_fail");
			// softAssertion.assertTrue(false);
			Assert.assertTrue(false);
		}

		report_msg = "Step " + (step++) + ": Submit BOM";
		LogClass.logstep(report_msg);
		LogClass.logExtent(report_msg);
		packageVerification = CalcuQuote_Login_Indexpage.clicksubmitBOM();
			
	}// End of BOM_TestCase_01
	
	// Labor Module TestCases
	@Test(priority = 0, enabled = true, dependsOnMethods="BOM_TestCase_01")
	public void Labor_TestCase_01() {
		step = 1;
		String report_msg;// String for the log in the Report
		LogClass.logcase(" ");
		report_msg = "CalcuQuote_Labor::To verify that user is able to enter the labor activities in RFQ";
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
			LogClass.makeScreenshot(driver, "Labor_Login_fail");
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
		
		report_msg = "Step " + (step++) + ": Select Labor Activity/Activities";
		LogClass.logstep(report_msg);
		LogClass.logExtent(report_msg);
		packageVerification = CalcuQuote_Login_Indexpage.labor_activities();
		
		
		if (packageVerification.laboractivity_added_verification()) {
			LogClass.logveri("-----> Verified Labor Activity Added Successfully <-----");
			LogClass.logExtent("-----> Verified Labor Activity Added Successfully <-----");
			LogClass.AssertPassed();
			Assert.assertTrue(true);
		} else {
			LogClass.logveri("-----> Verified Labor Activity is not Added Successfully <-----");
			LogClass.logExtent("-----> Verified Labor Activity is not Added Successfully <-----");
			LogClass.AssertFailed();
			LogClass.AssertFailed_Extent_Report();
			LogClass.makeScreenshot(driver, "Labor_activity_fail");
			// softAssertion.assertTrue(false);
			Assert.assertTrue(false);
		}
		
		report_msg = "Step " + (step++) + ": Submit Labor";
		LogClass.logstep(report_msg);
		LogClass.logExtent(report_msg);
		packageVerification = CalcuQuote_Login_Indexpage.clicksubmitLabor();
		
	}//End of Labor_TestCase_01 
	
	// Material Costing Module TestCases
		@Test(priority = 0, enabled = true, dependsOnMethods="BOM_TestCase_01")
		public void Material_Costing_TestCase_01() {
			step = 1;
			String report_msg;// String for the log in the Report
			LogClass.logcase(" ");
			report_msg = "CalcuQuote_Material_Costing::To verify that user is able to Update Pricing and Auto Select";
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
				LogClass.makeScreenshot(driver, "Material_Costing_Login_fail");
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
			
			report_msg = "Step " + (step++) + ": Navigate to Material Costing Page";
			LogClass.logstep(report_msg);
			LogClass.logExtent(report_msg);
			packageVerification = CalcuQuote_Login_Indexpage.materialcosting_activities();
			
		
		  if (packageVerification.price_update_and_auto_selected_verification()) {
		  LogClass.logveri("-----> Verified prices assigned Successfully <-----"); 
		  LogClass.logExtent("-----> Verified prices assigned Successfully <-----"); 
		  LogClass.AssertPassed(); Assert.assertTrue(true);
		  } 
		  else { 
			  LogClass.logveri("-----> Verified All prices are not assigned Successfully <-----"); 
			  LogClass.logExtent("-----> Verified All prices are not assigned Successfully <-----"); 
			  LogClass.AssertFailed(); 
			  LogClass.AssertFailed_Extent_Report();
		      LogClass.makeScreenshot(driver, "Price_update_auto_select_fail");
		      //softAssertion.assertTrue(false); 
		      Assert.assertTrue(false); 
		      }
		  
		  report_msg = "Step " + (step++) + ": Submit Material Costing";
		  LogClass.logstep(report_msg); LogClass.logExtent(report_msg);
		  packageVerification = CalcuQuote_Login_Indexpage.clicksubmitmaterialcosting();
		 
		}//End of Labor_TestCase_01 
			
		

}// End of Class
