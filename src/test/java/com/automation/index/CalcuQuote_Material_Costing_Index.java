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
	public static String part_class_name;
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
				
				// Use this code if you want create the RFQ as per script need 
				//report_msg = "Step " + (step++) + ": RFQ with multiple quantities";
				//LogClass.logExtent(report_msg);
				//rfq_packageVerification = CalcuQuote_RFQ_Indexpage.RFQ();

				report_msg = "Step " + (step++) + ": Select one of the existing RFQ";
				LogClass.logExtent(report_msg);
				packageVerification = CalcuQuote_Login_Indexpage.select_rfq();
				
				report_msg = "Step " + (step++) + ": Import BOM";
				LogClass.logExtent(report_msg);
				
				CalcuQuote_BOM_Indexpage.filepath="Resources/35LineBOM.xlsx" ;
				bom_packageVerification = CalcuQuote_BOM_Indexpage.ImportBOM();
				
				if (bom_packageVerification.BOM_imported()) {
					LogClass.logExtent("-----> Verified BOM Imported Successfully <-----");
					LogClass.AssertPassed();
					Assert.assertTrue(true);
				} else {
					LogClass.logExtent("-----> Verified BOM is not imported Successfully <-----");
					LogClass.AssertFailed();
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
					LogClass.AssertPassed();
					Assert.assertTrue(true);
				} else {
					LogClass.logExtent("-----> Verified Submit BOM is in progress msg not displayed <-----");
					LogClass.AssertFailed();
					LogClass.AssertFailed_Extent_Report();
					LogClass.makeScreenshot(driver, "BOM_submission_fail");
					// softAssertion.assertTrue(false);
					Assert.assertTrue(false);
				}
				
			   driver.navigate().refresh();
			   funcs.waitforseconds(5);
			   
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
				
			@Test(priority = 0, enabled = true )
			public void Material_Costing_TestCase_02() {

				step = 1;
				String report_msg;// String for the log in the Report
				report_msg = "CalcuQuote_BOM::To verify [CQPS]Total Qty calculation with different combination of inputs ";
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
					LogClass.makeScreenshot(driver, "BOM_Login_fail");
					// softAssertion.assertTrue(false);
					Assert.assertTrue(false);
				}

				report_msg = "Step " + (step++) + ": Enter Valid Credentials";
				LogClass.logExtent(report_msg);
				packageVerification = CalcuQuote_Login_Indexpage.CalcuQuote_Valid_Credentials();
				
			    // Use this code if you want create the RFQ as per script need 
				//report_msg = "Step " + (step++) + ": RFQ with multiple quantities";
				//LogClass.logExtent(report_msg);
				//rfq_packageVerification = CalcuQuote_RFQ_Indexpage.RFQ();
				
				//Use this code if you want to use the existing RFQ as per script need 
				report_msg = "Step " + (step++) + ": Select one of the existing RFQ";
				LogClass.logExtent(report_msg);
				packageVerification = CalcuQuote_Login_Indexpage.select_rfq();
				
				report_msg = "Step " + (step++) + ": Import BOM";
				LogClass.logExtent(report_msg);
				
				CalcuQuote_BOM_Indexpage.filepath="Resources/Total_Qty_Calculation.xlsx" ;
				bom_packageVerification = CalcuQuote_BOM_Indexpage.ImportBOM();
				
				if (bom_packageVerification.BOM_imported()) {
					LogClass.logExtent("-----> Verified BOM Imported Successfully <-----");
					LogClass.AssertPassed();
					Assert.assertTrue(true);
				} else {
					LogClass.logExtent("-----> Verified BOM is not imported Successfully <-----");
					LogClass.AssertFailed();
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
					LogClass.AssertPassed();
					Assert.assertTrue(true);
				} else {
					LogClass.logExtent("-----> Verified Submit BOM is in progress msg not displayed <-----");
					LogClass.AssertFailed();
					LogClass.AssertFailed_Extent_Report();
					LogClass.makeScreenshot(driver, "BOM_submission_fail");
					// softAssertion.assertTrue(false);
					Assert.assertTrue(false);
				}
			
				report_msg = "Step " + (step++) + ": Navigate to Material Costing to check calculation for the Total Quantity.";
				LogClass.logExtent(report_msg);
				material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.materialcosting_totalQty();
				
				if (material_costing_packageVerification.total_qty_verification()) {
					LogClass.logExtent("-----> Verified Total Qty Calculations are correct <-----");
					LogClass.AssertPassed();
					Assert.assertTrue(true);
				} else {
					LogClass.logExtent("-----> Verified Total Qty Calculations are not correct <-----");
					LogClass.AssertFailed();
					LogClass.AssertFailed_Extent_Report();
					LogClass.makeScreenshot(driver, "Total_Qty_verification_fail");
					// softAssertion.assertTrue(false);
					Assert.assertTrue(false);
				}
					
			}// Material_Costing_TestCase_02
			
			@Test(priority = 0, enabled = true )
			public void Material_Costing_TestCase_03() {

				step = 1;
				String report_msg;// String for the log in the Report
				report_msg = "CalcuQuote_BOM::To verify [CQPS]Total Qty calculation with different Part Class[ex. SMT Active, SMT BGA, SMT Passive etc]";
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
					LogClass.makeScreenshot(driver, "BOM_Login_fail");
					// softAssertion.assertTrue(false);
					Assert.assertTrue(false);
				}

				report_msg = "Step " + (step++) + ": Enter Valid Credentials";
				LogClass.logExtent(report_msg);
				packageVerification = CalcuQuote_Login_Indexpage.CalcuQuote_Valid_Credentials();
				
			    // Use this code if you want create the RFQ as per script need 
				//report_msg = "Step " + (step++) + ": RFQ with multiple quantities";
				//LogClass.logExtent(report_msg);
				//rfq_packageVerification = CalcuQuote_RFQ_Indexpage.RFQ();
				
				//Use this code if you want to use the existing RFQ as per script need 
				report_msg = "Step " + (step++) + ": Select one of the existing RFQ";
				LogClass.logExtent(report_msg);
				packageVerification = CalcuQuote_Login_Indexpage.select_rfq();
				
				report_msg = "Step " + (step++) + ": Add Line Item Manually";
				LogClass.logExtent(report_msg);
				bom_packageVerification = CalcuQuote_BOM_Indexpage.addlineitemmanually();
				
				for(int i=0;i<=5;i++) {
					
				part_class_name = CalcuQuote_BOM_Indexpage.part_class[i];
				report_msg = "Step " + (step++) + ": Edit Part Class Manually";
				LogClass.logExtent(report_msg);
				bom_packageVerification = CalcuQuote_BOM_Indexpage.edit_part_class_manually();

				report_msg = "Step " + (step++) + ": Submit BOM";
				LogClass.logExtent(report_msg);
				bom_packageVerification = CalcuQuote_BOM_Indexpage.SMT_clicksubmitBOM_manual();
				
				if (bom_packageVerification.BOM_submit()) {
					LogClass.logExtent("-----> Verified Submit BOM is in progress <-----");
					LogClass.AssertPassed();
					Assert.assertTrue(true);
				} else {
					LogClass.logExtent("-----> Verified Submit BOM is in progress msg not displayed <-----");
					LogClass.AssertFailed();
					LogClass.AssertFailed_Extent_Report();
					LogClass.makeScreenshot(driver, "BOM_submission_fail");
					// softAssertion.assertTrue(false);
					Assert.assertTrue(false);
				}
			
				report_msg = "Step " + (step++) + ": Navigate to Material Costing to check calculation for the Total Quantity.";
				LogClass.logExtent(report_msg);
				material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.SMT_materialcosting_totalQty();
				
				if (material_costing_packageVerification.SMT_total_qty_verification()) {
					LogClass.logExtent("-----> Verified Total Qty Calculations are correct <-----");
					LogClass.AssertPassed();
					//Assert.assertTrue(true);
				} else {
					LogClass.logExtent("-----> Verified Total Qty Calculations are not correct <-----");
					LogClass.AssertFailed();
					LogClass.AssertFailed_Extent_Report();
					LogClass.makeScreenshot(driver, "Total_Qty_verification_fail");
					//Assert.assertTrue(false);
				}
					
				}//End of for loop		
				
			}// Material_Costing_TestCase_03
			
			
	
}
