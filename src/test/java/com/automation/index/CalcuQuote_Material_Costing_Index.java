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

public class CalcuQuote_Material_Costing_Index extends CalcuQuote_SeleniumInit{

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
	// Material Costing Module TestCases , dependsOnMethods="BOM_TestCase_01"
			@Test(priority = 0, enabled = true)
			public void Material_Costing_TestCase_01() {
				step = 1;
				String report_msg;// String for the log in the Report
			
				report_msg = "CalcuQuote_Material_Costing::To verify that user is able to Update Pricing and Assign the price using CQPS";
				LogClass.logExtent(report_msg);

				report_msg = "Step " + (step++) + ":Open : https://qa.calcuquote.com/Staging2/";
				LogClass.logExtent(report_msg);
				
				if (packageVerification.homepageverify()) {
					LogClass.logExtent("-----> Verified CalcuQuote home page is open <-----");
					LogClass.AssertPassed();
					Assert.assertTrue(true);
				} else {
					LogClass.logExtent("-----> Verified CalcuQuote home page is not open <-----");
					LogClass.AssertFailed();
					LogClass.AssertFailed_Extent_Report();
					LogClass.makeScreenshot(driver, "Material_Costing_Login_fail");
					// softAssertion.assertTrue(false);
					Assert.assertTrue(false);
				}

				report_msg = "Step " + (step++) + ": Enter Valid Credentials";
				LogClass.logExtent(report_msg);
				packageVerification = CalcuQuote_Login_Indexpage.CalcuQuote_Valid_Credentials();

				report_msg = "Step " + (step++) + ": Select one of the existing RFQ";
				LogClass.logExtent(report_msg);
				packageVerification = CalcuQuote_Login_Indexpage.select_rfq();
				
				report_msg = "Step " + (step++) + ": Navigate to Material Costing Page";
				LogClass.logExtent(report_msg);
				material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.materialcosting_activities();
				
			
			  if (material_costing_packageVerification.price_update_and_auto_selected_verification()) 
			  {
			  LogClass.logExtent("-----> Verified prices assigned Successfully <-----"); 
			  LogClass.AssertPassed(); Assert.assertTrue(true);
			  } 
			  else { 
				  LogClass.logExtent("-----> Verified All prices are not assigned Successfully <-----"); 
				  LogClass.AssertFailed(); 
				  LogClass.AssertFailed_Extent_Report();
			      LogClass.makeScreenshot(driver, "Price_update_auto_select_fail");
			      //softAssertion.assertTrue(false); 
			      Assert.assertTrue(false); 
			      }
			  
			  report_msg = "Step " + (step++) + ": Submit Material Costing";
			  LogClass.logExtent(report_msg);
			  material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.clicksubmitmaterialcosting();
			  

			  if (material_costing_packageVerification.MC_submission())
			  {
			  LogClass.logExtent("-----> Verified Material Cost added to the Quote <-----"); 
			  LogClass.AssertPassed(); Assert.assertTrue(true);
			  } 
			  else { 
				  LogClass.logExtent("-----> Verified Material Cost not added to the Quote <-----"); 
				  LogClass.AssertFailed(); 
				  LogClass.AssertFailed_Extent_Report();
			      LogClass.makeScreenshot(driver, "MC_submission_fail");
			      //softAssertion.assertTrue(false); 
			      Assert.assertTrue(false); 
			      }
			  
			 
			}//End of Material_Costing_TestCase_01
				

	
}
