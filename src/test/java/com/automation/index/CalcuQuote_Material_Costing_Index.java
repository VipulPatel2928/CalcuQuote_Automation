package com.automation.index;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.automation.utility.LogClass;
import com.automation.utility.funcs;
import com.automation.verification.CalcuQuote_MaterialCosting_Verification;
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
	//SoftAssert softAssertion = new SoftAssert();

	// System.out.println("softAssert Method Was Started");
	// softAssertion.assertTrue(false);
	// System.out.println("softAssert Method Was Executed");
	// Below method bring the object for the log in the report
	public static void getTest(ExtentTest test) {
		// TODO Auto-generated method stub		
		extent_report_log = test;
		System.out.println("GetTest Method called");
	}
	// Material Costing Module TestCases , dependsOnMethods="BOM_TestCase_01"
			@Test(priority = 0, enabled = true)
			public void Material_Costing_TestCase_01() {
				step = 1;
				String report_msg;// String for the log in the Report
			
				report_msg = "CQ_Material_Costing::To verify that user is able to Update Pricing and Assign the price using CQPS";
				LogClass.logExtent(report_msg);

				report_msg = "Step " + (step++) + ":Open : https://qa.calcuquote.com/Staging2/";
				LogClass.logExtent(report_msg);
				
				if (packageVerification.homepageverify()) {
					LogClass.logExtent("-----> Verified CalcuQuote home page is open <-----");
					//LogClass.AssertPass_Extent_Report();
					Assert.assertTrue(true);
				} else {
					LogClass.logExtent("-----> Verified CalcuQuote home page is not open <-----");					
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
				
			   driver.navigate().refresh();
			   funcs.waitforseconds(5);
			   
		       report_msg = "Step " + (step++) + ": Navigate to Material Costing Page";
		       LogClass.logExtent(report_msg);
		       material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.materialcosting_activities();
			
			  if (material_costing_packageVerification.price_update_and_auto_selected_verification()) 
			  {
			  LogClass.logExtent("-----> Verified prices assigned Successfully <-----"); 
			  //LogClass.AssertPass_Extent_Report();
			  Assert.assertTrue(true);
			  } 
			  else { 
				  LogClass.logExtent("-----> Verified All prices are not assigned Successfully <-----"); 			
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
			  //LogClass.AssertPass_Extent_Report();
			  Assert.assertTrue(true);
			  } 
			  else { 
				  LogClass.logExtent("-----> Verified Material Cost not added to the Quote <-----"); 			
				  LogClass.AssertFailed_Extent_Report();
			      LogClass.makeScreenshot(driver, "MC_submission_fail");
			      //softAssertion.assertTrue(false); 
			      Assert.assertTrue(false); 
			      }
			  
			 
			}//End of Material_Costing_TestCase_01
				
			@Test(priority = 1, enabled = true )
			public void Material_Costing_TestCase_02() {

				step = 1;
				String report_msg;// String for the log in the Report
				report_msg = "CQ_Material_Costing::To verify [CQPS]Total Qty calculation with different combination of inputs ";
				LogClass.logExtent(report_msg);

				report_msg = "Step " + (step++) + ":Open : https://qa.calcuquote.com/Staging2/";
				LogClass.logExtent(report_msg);
				
				if (packageVerification.homepageverify()) {
					LogClass.logExtent("-----> Verified CalcuQuote home page is open <-----");
					//LogClass.AssertPass_Extent_Report();
					Assert.assertTrue(true);
				} else {
					LogClass.logExtent("-----> Verified CalcuQuote home page is not open <-----");				
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
			
				report_msg = "Step " + (step++) + ": Navigate to Material Costing to check calculation for the Total Quantity.";
				LogClass.logExtent(report_msg);
				material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.materialcosting_totalQty();
				
				if (material_costing_packageVerification.total_qty_verification()) {
					LogClass.logExtent("-----> Verified Total Qty Calculations are correct <-----");
					//LogClass.AssertPass_Extent_Report();
					Assert.assertTrue(true);
				} else {
					LogClass.logExtent("-----> Verified Total Qty Calculations are not correct <-----");			
					LogClass.AssertFailed_Extent_Report();
					LogClass.makeScreenshot(driver, "Total_Qty_verification_fail");
					// softAssertion.assertTrue(false);
					Assert.assertTrue(false);
				}
					
			}// Material_Costing_TestCase_02
			
			@Test(priority = 0, enabled = true )
			public void Material_Costing_TestCase_03() {
                int assersion_flag=0; 
				step = 1;
				String report_msg;// String for the log in the Report
				report_msg = "CQ_Material_Costing::To verify user get clear pricing message and prices get clear while changing Part Class affect the Lead Qty and Attr Rate";
				LogClass.logExtent(report_msg);

				report_msg = "Step " + (step++) + ":Open : https://qa.calcuquote.com/Staging2/";
				LogClass.logExtent(report_msg);
				
				if (packageVerification.homepageverify()) {
					LogClass.logExtent("-----> Verified CalcuQuote home page is open <-----");
					//LogClass.AssertPass_Extent_Report();
					Assert.assertTrue(true);
				} else {
					LogClass.logExtent("-----> Verified CalcuQuote home page is not open <-----");				
					LogClass.AssertFailed_Extent_Report();
					LogClass.makeScreenshot(driver, "Login_fail");
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
				
				report_msg = "Step " + (step++) + ": Submit BOM";
				LogClass.logExtent(report_msg);
				bom_packageVerification = CalcuQuote_BOM_Indexpage.SMT_clicksubmitBOM_manual();
				
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
				
				report_msg = "Step " + (step++) + ": Navigate to Material Costing";
				LogClass.logExtent(report_msg);
				material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.navigatematerial_costing();
				
				report_msg = "Step " + (step++) + ": Update Pricing and Reading Total Quantity from CQPS.";
				LogClass.logExtent(report_msg);
				material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.SMT_materialcosting_totalQty();
				
				CalcuQuote_MaterialCosting_Verification.previous_total_Qty=Double.parseDouble( CalcuQuote_Material_Costing_Indexpage.Total_Qty_per_line[0]);
				//for(int i=0;i<=1;i++) {
				
				part_class_name = CalcuQuote_BOM_Indexpage.part_class[1];
				report_msg = "Step " + (step++) + ": Edit Part Class Manually";
				LogClass.logExtent(report_msg);
				bom_packageVerification = CalcuQuote_BOM_Indexpage.edit_part_class_manually();

				report_msg = "Step " + (step++) + ": Submit BOM";
				LogClass.logExtent(report_msg);
				bom_packageVerification = CalcuQuote_BOM_Indexpage.SMT_clicksubmitBOM_manual();
				
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
				
				report_msg = "Step " + (step++) + ": Navigate to Material Costing";
				LogClass.logExtent(report_msg);
				material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.navigatematerial_costing();
				
			
				if (material_costing_packageVerification.price_clear_Verification()) {
					//LogClass.logExtent("-----> Verified Prices are cleared <-----");
			        LogClass.VerificationPass_Extent_Report("-----> Verified Prices are cleared <-----");
					//LogClass.AssertPass_Extent_Report();
					Assert.assertTrue(true);
				} else {
					//LogClass.logExtent("-----> Verified Prices are not cleared <-----");		
					LogClass.VerificationFailed_Extent_Report("-----> Verified Prices are not cleared <-----");
					LogClass.AssertFailed_Extent_Report();
					LogClass.makeScreenshot(driver, "price_clear_verification_fail");
					//Assert.assertTrue(false);
				}
				
				report_msg = "Step " + (step++) + ": Update Pricing and Reading Total Quantity from CQPS.";
				LogClass.logExtent(report_msg);
				material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.SMT_materialcosting_totalQty();
				
				if (material_costing_packageVerification.SMT_total_qty_verification()) {
					//LogClass.logExtent("-----> Verified Total Qty Calculations are correct <-----");
					LogClass.VerificationPass_Extent_Report("-----> Verified Total Qty Calculations is correct <-----");
					//LogClass.AssertPass_Extent_Report();
					Assert.assertTrue(true);
				} else {
					//LogClass.logExtent("-----> Verified Total Qty Calculations are not correct <-----");					
					LogClass.VerificationFailed_Extent_Report("-----> Verified Total Qty Calculations is not correct <-----");
					LogClass.AssertFailed_Extent_Report();
					//LogClass.makeScreenshot(driver, "Total_Qty_verification_fail");
					//Assert.assertTrue(false);
				}
					
				CalcuQuote_MaterialCosting_Verification.previous_total_Qty=Double.parseDouble( CalcuQuote_Material_Costing_Indexpage.Total_Qty_per_line[0]);
				
				part_class_name = CalcuQuote_BOM_Indexpage.part_class[2];
				report_msg = "Step " + (step++) + ": Edit Part Class Manually";
				LogClass.logExtent(report_msg);
				bom_packageVerification = CalcuQuote_BOM_Indexpage.edit_part_class_manually_1();
				
				report_msg = "Step " + (step++) + ": Submit BOM";
				LogClass.logExtent(report_msg);
				bom_packageVerification = CalcuQuote_BOM_Indexpage.SMT_clicksubmitBOM_manual();
				
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
				
				report_msg = "Step " + (step++) + ": Navigate to Material Costing";
				LogClass.logExtent(report_msg);
				material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.navigatematerial_costing();
				
			
				if (material_costing_packageVerification.price_available_Verification()) {
					//LogClass.logExtent("-----> Verified Prices are available <-----");
					LogClass.VerificationPass_Extent_Report("-----> Verified Prices are available <-----");
					//LogClass.AssertPass_Extent_Report();
					Assert.assertTrue(true);
				} else {
					//LogClass.logExtent("-----> Verified Prices are not available <-----");
					LogClass.VerificationFailed_Extent_Report("-----> Verified Prices are not available <-----");
					LogClass.AssertFailed_Extent_Report();
					LogClass.makeScreenshot(driver, "price_available_verification_fail");
					Assert.assertTrue(false);
				}
				
				report_msg = "Step " + (step++) + ": Update Pricing and Reading Total Quantity from CQPS.";
				LogClass.logExtent(report_msg);
				material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.SMT_materialcosting_totalQty_1();
			
				if (material_costing_packageVerification.SMT_total_qty_verification()) {
					//LogClass.logExtent("-----> Verified Total Qty Calculations are correct <-----");
					LogClass.VerificationPass_Extent_Report("-----> Verified Total Qty Calculations is correct <-----");
					//LogClass.AssertPass_Extent_Report();
					Assert.assertTrue(true);
				} else {
					//LogClass.logExtent("-----> Verified Total Qty Calculations are not correct <-----");
					LogClass.VerificationFailed_Extent_Report("-----> Verified Total Qty Calculations is not correct <-----");
					LogClass.AssertFailed_Extent_Report();
					//LogClass.makeScreenshot(driver, "Total_Qty_verification_fail");
					Assert.assertTrue(false);
				}
									
			}// Material_Costing_TestCase_03
			
	@Test(priority = 0, enabled = true)
	public void Material_Costing_TestCase_04() throws InterruptedException {
		step = 1;
		String report_msg;// String for the log in the Report

		report_msg = "CQ_Material_Costing::Automation Script for MC: Quick Add Unit Cost.";
		LogClass.logExtent(report_msg);

		report_msg = "Step " + (step++) + ":Open : https://qa.calcuquote.com/Staging2/";
		LogClass.logExtent(report_msg);

		if (packageVerification.homepageverify()) {
			LogClass.logExtent("-----> Verified CalcuQuote home page is open <-----");
			// LogClass.AssertPass_Extent_Report();
			Assert.assertTrue(true);
		} else {
			LogClass.logExtent("-----> Verified CalcuQuote home page is not open <-----");
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

		CalcuQuote_BOM_Indexpage.filepath = "Resources/35LineBOM.xlsx";
		bom_packageVerification = CalcuQuote_BOM_Indexpage.ImportBOM();

		if (bom_packageVerification.BOM_imported()) {
			LogClass.logExtent("-----> Verified BOM Imported Successfully <-----");
			// LogClass.AssertPass_Extent_Report();
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
			// LogClass.AssertPass_Extent_Report();
			Assert.assertTrue(true);
		} else {
			LogClass.logExtent("-----> Verified Submit BOM is in progress msg not displayed <-----");
			LogClass.AssertFailed_Extent_Report();
			LogClass.makeScreenshot(driver, "BOM_submission_fail");
			// softAssertion.assertTrue(false);
			Assert.assertTrue(false);
		}

		driver.navigate().refresh();
		funcs.waitforseconds(5);

		report_msg = "Step " + (step++) + ": Navigate to Material Costing Page";
		LogClass.logExtent(report_msg);
		material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.navigatematerial_costing();

		report_msg = "Step " + (step++) + ": Click Pricing Data Unavailable";
		LogClass.logExtent(report_msg);
		material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.right_click_pricing_data_unavailable();

		report_msg = "Step " + (step++)
				+ ": Checking Validation message for the mandatory fields on Enter Price Screen";
		LogClass.logExtent(report_msg);
		material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.generate_msg_Enter_price_srn();

		report_msg = "Step " + (step++) + ": Checking See More functionality";
		LogClass.logExtent(report_msg);
		material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.see_more();

        CalcuQuote_Material_Costing_Indexpage.unit_price_var ="0.292929";
		report_msg = "Step " + (step++) + ": Enter all mandatory fields of Quick Price and save ";
		LogClass.logExtent(report_msg);
		material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.Enter_Price();

		report_msg = "Step " + (step++)+ ": Dispaly Unit price on Material Costing Screen and Verify with entered Unit price.";
		LogClass.logExtent(report_msg);
		
		if (material_costing_packageVerification.unit_price_verification()) {
			// LogClass.logExtent("-----> Verified Total Qty Calculations are correct
			// <-----");
			LogClass.VerificationPass_Extent_Report("-----> Unit price is assigned to line item <-----");
			// LogClass.AssertPass_Extent_Report();
			Assert.assertTrue(true);
		} else {
			// LogClass.logExtent("-----> Verified Total Qty Calculations are not correct
			// <-----");
			LogClass.VerificationFailed_Extent_Report("-----> Unit price is not assigned to line item <-----");
			LogClass.AssertFailed_Extent_Report();
			// LogClass.makeScreenshot(driver, "Total_Qty_verification_fail");
			Assert.assertTrue(false);
		}

		 CalcuQuote_Material_Costing_Indexpage.unit_price_var ="0.111111";
		report_msg = "Step " + (step++)+ ": Measuring Process Time from Quick Add Price to Save ";
		LogClass.logExtent(report_msg);
		material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.measure_time();
		
		if (material_costing_packageVerification.time_verification()) {
			// LogClass.logExtent("-----> Verified Total Qty Calculations are correct
			// <-----");
			LogClass.VerificationPass_Extent_Report("-----> Open Quick Add Price screen to Save price process is finished in expected benchmark time <-----"+CalcuQuote_MaterialCosting_Verification.quick_add_time);
			// LogClass.AssertPass_Extent_Report();
			Assert.assertTrue(true);
		} else {
			// LogClass.logExtent("-----> Verified Total Qty Calculations are not correct
			// <-----");
			LogClass.VerificationFailed_Extent_Report("-----> Open Quick Add Price screen to Save price process is not finished in expected benchmark time <-----"+CalcuQuote_MaterialCosting_Verification.quick_add_time);
			LogClass.AssertFailed_Extent_Report();
			// LogClass.makeScreenshot(driver, "Total_Qty_verification_fail");
			//Assert.assertTrue(false);
		}
		
		if (material_costing_packageVerification.unit_price_verification()) {
			// LogClass.logExtent("-----> Verified Total Qty Calculations are correct
			// <-----");
			LogClass.VerificationPass_Extent_Report("-----> Unit price is assigned to line item <-----");
			// LogClass.AssertPass_Extent_Report();
			Assert.assertTrue(true);
		} else {
			// LogClass.logExtent("-----> Verified Total Qty Calculations are not correct
			// <-----");
			LogClass.VerificationFailed_Extent_Report("-----> Unit price is not assigned to line item <-----");
			LogClass.AssertFailed_Extent_Report();
			// LogClass.makeScreenshot(driver, "Total_Qty_verification_fail");
			Assert.assertTrue(false);
		}
		
		
		report_msg = "Step " + (step++) + ": Click Pricing Data Unavailable";
		LogClass.logExtent(report_msg);
		material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage
				.right_click_pricing_data_unavailable();

		report_msg = "Step " + (step++) + ": Select Supplier ";
		LogClass.logExtent(report_msg);
		material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.select_supplier();

		report_msg = "Step " + (step++) + ": Enter all mandatory fields of Quick Price and save ";
		LogClass.logExtent(report_msg);
		material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.Enter_Price_in_GBP();

		report_msg = "Step " + (step++) + ": Choose GBP as Currency ";
		LogClass.logExtent(report_msg);
		material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.choose_currency();

		report_msg = "Step " + (step++) + ": Click Save btn ";
		LogClass.logExtent(report_msg);
		material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.savebtn_quick_price();

		if (material_costing_packageVerification.gbp_unit_price_verification()) {
			// LogClass.logExtent("-----> Verified Total Qty Calculations are correct
			// <-----");
			LogClass.VerificationPass_Extent_Report("-----> Unit price is assigned to line item <-----");
			// LogClass.AssertPass_Extent_Report();
			Assert.assertTrue(true);
		} else {
			// LogClass.logExtent("-----> Verified Total Qty Calculations are not correct
			// <-----");
			LogClass.VerificationFailed_Extent_Report("-----> Unit price is not assigned to line item <-----");
			LogClass.AssertFailed_Extent_Report();
			// LogClass.makeScreenshot(driver, "Total_Qty_verification_fail");
			Assert.assertTrue(false);
		}

		report_msg = "Step " + (step++) + ": Click Review Tab ";
		LogClass.logExtent(report_msg);
		material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.click_review_tab();
		
		report_msg = "Step " + (step++) + ": Click Leading Cost Drivers ";
		LogClass.logExtent(report_msg);
		material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.click_leading_cost_tab();
		
		report_msg = "Step " + (step++) + ": Navigate to Quick Add Price Screen. ";
		LogClass.logExtent(report_msg);
		material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.navigate_to_add_price_screen();

		report_msg = "Step " + (step++) + ": Select Supplier ";
		LogClass.logExtent(report_msg);
		material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.select_supplier();
		
		CalcuQuote_Material_Costing_Indexpage.unit_price_var ="0.999999";
		report_msg = "Step " + (step++) + ": Enter all mandatory fields of Quick Price and save ";
		LogClass.logExtent(report_msg);
		material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.Enter_Price();
		
		report_msg = "Step " + (step++)+ ": Dispaly Unit price on Material Costing Review Screen and Verify with entered Unit price.";
		LogClass.logExtent(report_msg);
		
		if (material_costing_packageVerification.unit_price_verification_leading_cost()) {
			// LogClass.logExtent("-----> Verified Total Qty Calculations are correct
			// <-----");
			LogClass.VerificationPass_Extent_Report("-----> Unit price is assigned to line item <-----");
			// LogClass.AssertPass_Extent_Report();
			Assert.assertTrue(true);
		} else {
			// LogClass.logExtent("-----> Verified Total Qty Calculations are not correct
			// <-----");
			LogClass.VerificationFailed_Extent_Report("-----> Unit price is not assigned to line item <-----");
			LogClass.AssertFailed_Extent_Report();
			// LogClass.makeScreenshot(driver, "Total_Qty_verification_fail");
			Assert.assertTrue(false);
		}
		
	}// End of Material_Costing_TestCase_04
	
	@Test(priority = 0, enabled = true)
	public void Material_Costing_TestCase_05() {
		step = 1;
		String report_msg;// String for the log in the Report
	
		report_msg = "CQ_Material_Costing::MC: Block API for Multiple Lines";
		LogClass.logExtent(report_msg);

		report_msg = "Step " + (step++) + ":Open : https://qa.calcuquote.com/Staging2/";
		LogClass.logExtent(report_msg);
		
		if (packageVerification.homepageverify()) {
			LogClass.logExtent("-----> Verified CalcuQuote home page is open <-----");
			//LogClass.AssertPass_Extent_Report();
			Assert.assertTrue(true);
		} else {
			LogClass.logExtent("-----> Verified CalcuQuote home page is not open <-----");					
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
		
	   driver.navigate().refresh();
	   funcs.waitforseconds(5);
	   
       report_msg = "Step " + (step++) + ": Navigate to Material Costing Page";
       LogClass.logExtent(report_msg);
       material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.navigatematerial_costing();
       
       report_msg = "Step " + (step++) + ":Test Case 32667: Verify block api in Material review screen.";
       LogClass.logExtent(report_msg);
       material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.testcase_32667();
       
       if (material_costing_packageVerification.verify_32667()) {			
			LogClass.VerificationPass_Extent_Report("-----> Pass - Line items Marked As Manual Pricing <-----");			
			Assert.assertTrue(true);
		} else {			
			LogClass.VerificationFailed_Extent_Report("-----> Fail - Line items Marked As Manual Pricing <-----");
			LogClass.AssertFailed_Extent_Report();
			LogClass.makeScreenshot(driver, "32667_fail");
			Assert.assertTrue(false);
		}
       	 
       report_msg = "Step " + (step++) + ":Test Case 32660: Verify Block API when do Mark as exception and remove mark as exception on Material costing screen.";
       LogClass.logExtent(report_msg);
       material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.testcase_32660_1();
       
       if (material_costing_packageVerification.verify_32660_1()) {			
			LogClass.VerificationPass_Extent_Report("-----> Pass - got msg : Current selection contains update pricing exception lines <-----");			
			Assert.assertTrue(true);
		} else {			
			LogClass.VerificationFailed_Extent_Report("-----> Fail - didn't get msg : Current selection contains update pricing exception lines <-----");
			LogClass.AssertFailed_Extent_Report();
			LogClass.makeScreenshot(driver, "32660_1_fail");
			Assert.assertTrue(false);
		}
       
       material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.testcase_32660_2();
       
       if (material_costing_packageVerification.verify_32660_2()) {			
			LogClass.VerificationPass_Extent_Report("-----> Pass - Select Pricing APIs' Pop Up opened <-----");			
			Assert.assertTrue(true);
		} else {			
			LogClass.VerificationFailed_Extent_Report("-----> Fail - Select Pricing APIs' Pop Up didn't open <-----");
			LogClass.AssertFailed_Extent_Report();
			LogClass.makeScreenshot(driver, "32660_2_fail");
			Assert.assertTrue(false);
		}
       
       report_msg = "Step " + (step++) + ":Test Case 32743: Verify with updating price for block api line item.";
       LogClass.logExtent(report_msg);
       material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.testcase_32743();
       
       if (material_costing_packageVerification.verify_32743()) {			
			LogClass.VerificationPass_Extent_Report("-----> Pass - got msg : Current selection contains update pricing exception lines <-----");			
			Assert.assertTrue(true);
		} else {			
			LogClass.VerificationFailed_Extent_Report("-----> Fail - didn't get msg : Current selection contains update pricing exception lines <-----");
			LogClass.AssertFailed_Extent_Report();
			LogClass.makeScreenshot(driver, "32743_fail");
			Assert.assertTrue(false);
		}
      
       report_msg = "Step " + (step++) + ":Test Case 32745: Verify to add manual price for block api line item.";
       LogClass.logExtent(report_msg);
       material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.testcase_32745();
       
       if (material_costing_packageVerification.verify_32745()) {			
			LogClass.VerificationPass_Extent_Report("-----> Pass - got msg : Pricing saved successfully. <-----");			
			Assert.assertTrue(true);
		} else {			
			LogClass.VerificationFailed_Extent_Report("-----> Fail - didn't get msg : Pricing saved successfully. <-----");
			LogClass.AssertFailed_Extent_Report();
			LogClass.makeScreenshot(driver, "32745_fail");
			Assert.assertTrue(false);
		}
       CalcuQuote_Material_Costing_Indexpage.click_close_cqps_screen();
              
       report_msg = "Step " + (step++) + ":Test Case 32744: Verify with adding alternate parts for block api line item.";
       LogClass.logExtent(report_msg);
       material_costing_packageVerification = CalcuQuote_Material_Costing_Indexpage.testcase_32744();
       
       if (material_costing_packageVerification.verify_32744()) {			
			LogClass.VerificationPass_Extent_Report("-----> Pass - Verified alternate MPN addded to Material Costing screen <-----");			
			Assert.assertTrue(true);
		} else {			
			LogClass.VerificationFailed_Extent_Report("-----> Fail - didn't Verified alternate MPN addded to Material Costing screen <-----");
			LogClass.AssertFailed_Extent_Report();
			LogClass.makeScreenshot(driver, "32744_fail");
			Assert.assertTrue(false);
		}
              
	}//End of Material_Costing_TestCase_05
	
				
}
