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
		
		@Test(priority = 0, enabled = true)
		public void RFQ_TestCase_02() {

			step = 1;
			String report_msg;// String for the log in the Report
			report_msg = "CalcuQuote_RFQ: Allow new RFQ qty without resetting existing pricing";
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

			report_msg = "Step " + (step++) + ": Select one of the existing RFQ";
			LogClass.logExtent(report_msg);
			packageVerification = CalcuQuote_Login_Indexpage.select_rfq();
			
			/*
			report_msg = "Step " + (step++) + ": Import BOM";
			LogClass.logExtent(report_msg);
			
			CalcuQuote_BOM_Indexpage.filepath="Resources/35LineBOM.xlsx" ;
			bom_packageVerification = CalcuQuote_BOM_Indexpage.ImportBOM();
			
			if (bom_packageVerification.BOM_imported()) {
				LogClass.logExtent("-----> Verified BOM Imported Successfully <-----");
				//LogClass.AssertPass_Extent_Report();
				Assert.assertTrue(true);
			} else {
				LogClass.logExtent("-----> Verified BOM is not imported Successfully <-----");					
				LogClass.AssertFailed_Extent_Report();
				LogClass.makeScreenshot(driver, "BOM_import_fail");
				// softAssertion.assertTrue(false);
				Assert.assertTrue(false);
			}
			
			report_msg = "Step " + (step++) + ": Submit BOM";
			LogClass.logExtent(report_msg);
			bom_packageVerification = CalcuQuote_BOM_Indexpage.clicksubmitBOM();
			
			if (bom_packageVerification.BOM_submit()) {
				LogClass.logExtent("-----> Verified Submit BOM is in progress <-----");
				//LogClass.AssertPass_Extent_Report();
				Assert.assertTrue(true);
			} else {
				LogClass.logExtent("-----> Verified Submit BOM is in progress msg not displayed <-----");					
				LogClass.AssertFailed_Extent_Report();
				LogClass.makeScreenshot(driver, "BOM_submission_fail");
				// softAssertion.assertTrue(false);
				Assert.assertTrue(false);
			}
			
			*/
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
			
		   driver.navigate().refresh();
		   funcs.waitforseconds(5);
		   
	       report_msg = "Step " + (step++) + ": Navigate to Material Costing Page";
	       LogClass.logExtent(report_msg);
	       material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.materialcosting_activities_for_rfq();
						
		    //driver.navigate().refresh();
		    report_msg = "Step " + (step++) + ": Select Labor Activity/Activities";
			LogClass.logExtent(report_msg);
			labor_packageVerification = CalcuQuote_Labor_Indexpage.labor_activities();
			
			
			if (labor_packageVerification.laboractivity_added_verification()) {
				LogClass.logExtent("-----> Verified Labor Activity Added Successfully <-----");
				LogClass.AssertPassed();
				Assert.assertTrue(true);
			} else {
				LogClass.logExtent("-----> Verified Labor Activity is not Added Successfully <-----");
				LogClass.AssertFailed();
				LogClass.AssertFailed_Extent_Report();
				LogClass.makeScreenshot(driver, "Labor_activity_fail");
				// softAssertion.assertTrue(false);
				Assert.assertTrue(false);
			}
			
			report_msg = "Step " + (step++) + ": Submit Labor";
			LogClass.logExtent(report_msg);
			labor_packageVerification = CalcuQuote_Labor_Indexpage.clicksubmitLabor();
			
			if (labor_packageVerification.laboractivity_submit()) {
				LogClass.logExtent("-----> Verified Labor Costs added to the Quote <-----");
				LogClass.AssertPassed();
				Assert.assertTrue(true);
			} else {
				LogClass.logExtent("-----> Verified Labor Costs not added to the Quote <-----");
				LogClass.AssertFailed();
				LogClass.AssertFailed_Extent_Report();
				LogClass.makeScreenshot(driver, "Labor_submission_fail");
				// softAssertion.assertTrue(false);
				Assert.assertTrue(false);
			}
				
			report_msg = "Step " + (step++) + ": Test Case 27074: Verify received alert when we change RFQ qty after submit MC.";
			LogClass.logExtent(report_msg);
			rfq_packageVerification = CalcuQuote_RFQ_Indexpage.TestCase_27074();
			
			if (rfq_packageVerification.verify_27074()) {
				//LogClass.logExtent("-----> Verified RFQ Submitted Successfully <-----");						
				Assert.assertTrue(true);
			} else {
				//LogClass.logExtent("-----> Verified RFQ is not Submitted Successfully <-----");				
				LogClass.AssertFailed_Extent_Report();
				LogClass.makeScreenshot(driver, "27074_fail");
				// softAssertion.assertTrue(false);
				Assert.assertTrue(false);
			}
			
			report_msg = "Step " + (step++) + ":Test Case 27085: Verify if select the NO option from alert then no any change to material and labor cost";
			LogClass.logExtent(report_msg);
			rfq_packageVerification = CalcuQuote_RFQ_Indexpage.TestCase_27085();
			

			if (rfq_packageVerification.verify_27085()) {
				LogClass.VerificationPass_Extent_Report("-----> Pass All Verifications <-----");						
				Assert.assertTrue(true);
			} else {
				LogClass.VerificationFailed_Extent_Report("-----> Failed One or More Verification <-----");				
				LogClass.AssertFailed_Extent_Report();
				//LogClass.makeScreenshot(driver, "27085_fail");
				// softAssertion.assertTrue(false);
				Assert.assertTrue(false);
			}
			
			report_msg = "Step " + (step++) + ":Test Case 27084: 2.Verify if select the YES option from alert then change to material and labor cost";
			LogClass.logExtent(report_msg);
			rfq_packageVerification = CalcuQuote_RFQ_Indexpage.TestCase_27084();
			

			if (rfq_packageVerification.verify_27084()) {
				LogClass.VerificationPass_Extent_Report("-----> Pass All Verifications <-----");						
				Assert.assertTrue(true);
			} else {
				LogClass.VerificationFailed_Extent_Report("-----> Failed One or More Verification <-----");				
				LogClass.AssertFailed_Extent_Report();
				//LogClass.makeScreenshot(driver, "27085_fail");
				// softAssertion.assertTrue(false);
				Assert.assertTrue(false);
			}
						
			report_msg = "Step " + (step++) + ":Test Case 27094: Verify received alert or not after submit material costing then add new RFQ qty";
			LogClass.logExtent(report_msg);
			rfq_packageVerification = CalcuQuote_RFQ_Indexpage.TestCase_27094();
			

			if (rfq_packageVerification.verify_27094()) {
				LogClass.VerificationPass_Extent_Report("-----> Pass All Verifications <-----");						
				Assert.assertTrue(true);
			} else {
				LogClass.VerificationFailed_Extent_Report("-----> Failed One or More Verification <-----");				
				LogClass.AssertFailed_Extent_Report();
				//LogClass.makeScreenshot(driver, "27085_fail");
				// softAssertion.assertTrue(false);
				Assert.assertTrue(false);
			}
						
		}// End of RFQ_TestCase_02.

}
