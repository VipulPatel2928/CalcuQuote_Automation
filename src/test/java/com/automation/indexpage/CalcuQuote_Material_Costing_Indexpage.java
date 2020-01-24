package com.automation.indexpage;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.init.CalcuQuote_AbstractPage;
import com.automation.init.CalcuQuote_SeleniumInit;
import com.automation.utility.CalcuQuote_TestData;
//import com.automation.utility.Common;
import com.automation.utility.LogClass;
import com.automation.utility.funcs;
import com.sun.corba.se.spi.orbutil.fsm.Action;

import com.automation.verification.CalcuQuote_Login_Verification;
import com.automation.verification.CalcuQuote_RFQ_Verification;
import com.automation.verification.CalcuQuote_BOM_Verification;
import com.automation.verification.CalcuQuote_Labor_Verification;
import com.automation.verification.CalcuQuote_MaterialCosting_Verification;
import com.automation.verification.CalcuQuote_NRE_Verification;
import com.automation.verification.CalcuQuote_Summary_Verification;
import com.automation.verification.CalcuQuote_BidCQ_Verification;
import com.automation.verification.CalcuQuote_ShopCQ_Verification;
import com.automation.verification.CalcuQuote_SearchCQ_Verification;


public class CalcuQuote_Material_Costing_Indexpage extends CalcuQuote_AbstractPage {
	public CalcuQuote_Material_Costing_Indexpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public static String[] Total_Qty_per_line = new String[8];
	public static Actions act = new Actions(driver);
	public static String unit_price_var = null;
	
	@FindBy(xpath="//ul//li[4]//a[contains(text(),' Material Costing')]")private static WebElement material_costing_tab;
	@FindBy(xpath="//button[@id='btnUpdatePricing']")private static WebElement update_pricing;
	@FindBy(xpath="//button[text()='Submit']")private static WebElement MC_POPup_submit_btn;
	@FindBy(xpath="//button[@ng-click='stopAutoPricing()']")private static WebElement stopautopricing;
	@FindBy(xpath="//button[@id='btnAutoSelect']")private static WebElement auto_select_btn;
	
	@FindBy(xpath="//a[@uib-tooltip='Pricing Available  ']")private static List<WebElement> pricing_available;
	@FindBy(xpath="//div[@class='ui-grid-cell-contents ng-binding']")private static List<WebElement> select_line;
	@FindBy(xpath="//span[@ng-if='IsMoreThanOneQuantity']")private static WebElement apply_to_all_quantity;
	
	@FindBy(xpath="//span[@ng-click='Next()']")private static WebElement cqps_next_btn;
	@FindBy(xpath="//span[@class='fa fa-times close']")private static WebElement close_CQPS;
	@FindBy(xpath="//button[text()='Ok']")private static WebElement ok_btn;
	
	public static CalcuQuote_MaterialCosting_Verification materialcosting_activities() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(5);
		funcs.clickon_element(driver,material_costing_tab );
		LogClass.logExtent("---> Click on Material Costing Tab <---");
		
		funcs.waitforseconds(5);
		funcs.clickon_element(driver,update_pricing );
		LogClass.logExtent("---> Click on Update Pricing Tab <---");
		
		funcs.waitforseconds(3);
		funcs.clickon_element(driver,digikey_uncheck );
		LogClass.logExtent("---> Click on Digikey Uncheck <---");
		
		funcs.waitforseconds(1);
		funcs.clickon_element(driver,MC_POPup_submit_btn );
		LogClass.logExtent("---> Click on Submit Button for Update Pricing <---");
		
		new WebDriverWait(driver,300).until(ExpectedConditions.visibilityOf( update_pricing));
		///WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(element));
		
		/*
		 * funcs.waitforseconds(3); funcs.clickon_element(driver,auto_select_btn );
		 * LogClass.log("---> Click on Auto Select Button <---");
		 * LogClass.logExtent("---> Click on Auto Select Button <---");
		 */
		funcs.waitforseconds(5);
		
		String totalQuantity = CalcuQuote_TestData.numberofquantity(7);
		int totalQ = Integer.parseInt(totalQuantity);
		int prices = totalQ*4;
		if(pricing_available.size()==prices) {
			LogClass.logExtent("---> Pricing Available for All line and All Quantity <---");
		}
		
		
		LogClass.logExtent("---> Pricing Selection for each line item start <---");
		
		System.out.println("pricing available="+pricing_available.size());
		funcs.clickon_element(driver,pricing_available.get(0) );
		
		for(int i=0;i<=3;i++) {
			//System.out.println("i="+i);
			//funcs.clickon_element(driver,pricing_available.get(i) ); 
			funcs.waitforseconds(3);
			funcs.clickon_element(driver,select_line.get(1) );
			//funcs.clickon_element(driver,apply_to_all_quantity );
			funcs.waitforseconds(1);
			funcs.clickon_element(driver,cqps_next_btn );
		}
		
		funcs.waitforseconds(4);
		funcs.clickon_element(driver,close_CQPS );
		//funcs.waitforseconds(1);
		//funcs.clickon_element(driver,ok_btn );
		
		LogClass.logExtent("---> Pricing Selection for each line item finished <---");
		
		funcs.waitforseconds(1);
		return new CalcuQuote_MaterialCosting_Verification(driver);
	}

	@FindBy(xpath="//button[@id='btnPurchaseSubmit']")private static WebElement material_costing_submit_btn;
	@FindBy(xpath="//button[text()='Ok']")private static WebElement material_submit_ok_btn;
	public static CalcuQuote_MaterialCosting_Verification clicksubmitmaterialcosting() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(5);
		funcs.clickon_element(driver,material_costing_submit_btn );
		LogClass.logExtent("---> Click on Material Costing Submit button <---");
		
		funcs.waitforseconds(2);
		funcs.clickon_element(driver,material_submit_ok_btn );
		LogClass.logExtent("---> Click on OK button <---");
		funcs.waitforseconds(1);
		return new CalcuQuote_MaterialCosting_Verification(driver);
	}
	
	
	@FindBy(xpath="//a[@uib-tooltip='Pricing Data Unavailable  ']")private static List<WebElement> pricing_data_unavailable;
	@FindBy(xpath="//input[@ng-model='currentTotalQty']")private static WebElement total_qty;
	
	public static CalcuQuote_MaterialCosting_Verification materialcosting_totalQty() {
		// TODO Auto-generated method stub
		driver.navigate().refresh();
		funcs.waitforseconds(5);
		funcs.clickon_element(driver,material_costing_tab );
		LogClass.logExtent("---> Click on Material Costing Tab <---");
		
		funcs.waitforseconds(4);
		funcs.clickon_element(driver,pricing_data_unavailable.get(0) );
		LogClass.logExtent("---> Click on pricing data unavailable <---");
		
		funcs.waitforseconds(4);
		for(int i=0;i<=7;i++) {
			funcs.waitforseconds(2);
			Total_Qty_per_line[i] = total_qty.getAttribute("value");
		    System.out.println("Total Qty:" + Total_Qty_per_line[i]);
			funcs.clickon_element(driver, cqps_next_btn);
			funcs.waitforseconds(2);
		}
		
		//funcs.waitforseconds(5);
		return new CalcuQuote_MaterialCosting_Verification(driver);	
	}

	@FindBy(xpath="//input[@id=\"DigiKey\"]//..//i")private static WebElement digikey_uncheck;
	
	public static CalcuQuote_MaterialCosting_Verification SMT_materialcosting_totalQty() {
		// TODO Auto-generated method stub
		/*
		driver.navigate().refresh();
		funcs.waitforseconds(5);
		funcs.clickon_element(driver,material_costing_tab );
		LogClass.logExtent("---> Click on Material Costing Tab <---");
		
		*/
		/*
		funcs.waitforseconds(4);
		funcs.clickon_element(driver,pricing_data_unavailable.get(0) );
		LogClass.logExtent("---> Click on pricing data unavailable <---");
		*/
		funcs.waitforseconds(5);
		funcs.clickon_element(driver,update_pricing );
		LogClass.logExtent("---> Click on Update Pricing Tab <---");
		
		funcs.waitforseconds(3);
		funcs.clickon_element(driver,digikey_uncheck );
		LogClass.logExtent("---> Click on Digikey Uncheck <---");
		
		funcs.waitforseconds(1);
		funcs.clickon_element(driver,MC_POPup_submit_btn );
		LogClass.logExtent("---> Click on Submit Button for Update Pricing <---");
		
		new WebDriverWait(driver,300).until(ExpectedConditions.visibilityOf( update_pricing));
		
		funcs.clickon_element(driver,pricing_available.get(0) );
		LogClass.logExtent("---> Click on pricing available <---");
		
		funcs.waitforseconds(10);					
		Total_Qty_per_line[0] = total_qty.getAttribute("value");
		System.out.println("Total Qty:" + Total_Qty_per_line[0]);
		//funcs.clickon_element(driver, cqps_next_btn);
		/*
		//funcs.waitforseconds(5);
		funcs.waitforseconds(5);
		funcs.clickon_element(driver,material_costing_tab );
		LogClass.logExtent("---> Click on Material Costing Tab <---");
		*/
		return new CalcuQuote_MaterialCosting_Verification(driver);	
	}

	public static CalcuQuote_MaterialCosting_Verification navigatematerial_costing() {
		// TODO Auto-generated method stub
		driver.navigate().refresh();
		funcs.waitforseconds(5);
		funcs.clickon_element(driver,material_costing_tab );
		LogClass.logExtent("---> Click on Material Costing Tab <---");
		return new CalcuQuote_MaterialCosting_Verification(driver);	
	}


	public static CalcuQuote_MaterialCosting_Verification SMT_materialcosting_totalQty_1() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(5);
		
		funcs.clickon_element(driver,pricing_available.get(0) );
		LogClass.logExtent("---> Click on pricing available <---");
		
		funcs.waitforseconds(8);					
		Total_Qty_per_line[0] = total_qty.getAttribute("value");
		System.out.println("Total Qty:" + Total_Qty_per_line[0]);
		
		return new CalcuQuote_MaterialCosting_Verification(driver);	
	}

	@FindBy(xpath="//i[@id='inlineEditPopup']")private static WebElement add_manual_price_icon;
	public static CalcuQuote_MaterialCosting_Verification click_add_manual_price_CQPS() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(3);
		funcs.clickon_element(driver,add_manual_price_icon );
		LogClass.logExtent("---> Click on add manual price icon <---");
		return new CalcuQuote_MaterialCosting_Verification(driver);
	}

	@FindBy(xpath="//a[text()='Quick Add Price']")private static WebElement quick_add_price;
	public static CalcuQuote_MaterialCosting_Verification right_click_pricing_data_unavailable() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(6);
		//funcs.clickon_element(driver,pricing_data_unavailable.get(0) );
		//LogClass.logExtent("---> Click on pricing data unavailable <---");
		//Actions act = new Actions(driver);
		act.moveToElement(pricing_data_unavailable.get(0)).build().perform();
		funcs.waitforseconds(1);
		act.contextClick(pricing_data_unavailable.get(0)).build().perform();;
		funcs.waitforseconds(4);
		funcs.clickon_element(driver,quick_add_price );
		return new CalcuQuote_MaterialCosting_Verification(driver);	
	}
	
	@FindBy(xpath="//button[@id='brnSave']")private static WebElement save_btn;
	@FindBy(xpath="//div[text()='Valid supplier name is required.']")private static WebElement supplier_vlaidation;
	@FindBy(xpath="//input[@name='CustomerId']")private static WebElement supplier_name;
	@FindBy(xpath="//a[@title='TTI']")private static WebElement select_supplier;
	@FindBy(xpath="//button[text()='Cancel']//..//button[text()='OK']")private static WebElement btn_OK;
	@FindBy(xpath="//div[text()='Unit Price is required and it should be greater than ']")private static WebElement unit_price_valid_msg;
	
	public static CalcuQuote_MaterialCosting_Verification generate_msg_Enter_price_srn() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(3);
		funcs.clickon_element_wid(driver,save_btn );		
		System.out.println("supplier validation message:==>"+supplier_vlaidation.getText());
		
		if(supplier_vlaidation.isDisplayed())
			LogClass.VerificationPass_Extent_Report("Verified Validation msg:==>" +supplier_vlaidation.getText());
		funcs.clickon_element(driver,btn_OK );
		
		//funcs.senddata(driver, supplier_name, "TTI");
		supplier_name.sendKeys("TTI");
		funcs.waitforseconds(3);
		funcs.jsClick(driver,select_supplier );
		
		funcs.clickon_element_wid(driver,save_btn );		
		System.out.println("unit price validation message:"+unit_price_valid_msg.getText());
		if(unit_price_valid_msg.isDisplayed())
			LogClass.VerificationPass_Extent_Report("Verified Validation msg:==>" +unit_price_valid_msg.getText());
		funcs.clickon_element(driver,btn_OK );
		
		return new CalcuQuote_MaterialCosting_Verification(driver);
	}

	@FindBy(xpath="//span[text()='------ See More ------']")private static WebElement see_more;
	@FindBy(xpath="//label[text()='Quote #']")private static WebElement quote_label;
	@FindBy(xpath="//label[text()='Package']")private static WebElement package_label;
	@FindBy(xpath="//label[text()='Product URL']")private static WebElement product_URL_label;
	@FindBy(xpath="//label[text()='UOM ']")private static WebElement UOM_Label;
	@FindBy(xpath="//label[text()='Custom Reeling  ']")private static WebElement custom_reeling_label;
	@FindBy(xpath="//label[text()='On Order ETA']")private static WebElement on_order_ETA;
	@FindBy(xpath="//label[text()='On Order Quantity']")private static WebElement on_order_quantity_label;
	@FindBy(xpath="//label[text()='RoHS']")private static WebElement RoHS_label;
	@FindBy(xpath="//label[text()='NCNR']")private static WebElement NCNR;
	@FindBy(xpath="//label[text()='Notes']")private static WebElement Notes;
	@FindBy(xpath="//em[text()=' Indicates required field.']")private static WebElement mandatory_field;
	@FindBy(xpath="//span[text()='------ See Less ------']")private static WebElement see_less;
	
	
	public static CalcuQuote_MaterialCosting_Verification see_more() {
		// TODO Auto-generated method stub
	
		funcs.waitforseconds(2);
		funcs.clickon_element_wid(driver, see_more);
		funcs.waitforseconds(1);
		//funcs.scrollBy_vertical(driver, 5000);
		act.moveToElement(save_btn).build().perform();
		if(quote_label.isDisplayed()&&package_label.isDisplayed()&&product_URL_label.isDisplayed()&&UOM_Label.isDisplayed()&&custom_reeling_label.isDisplayed()&&on_order_quantity_label.isDisplayed()&&on_order_ETA.isDisplayed()&&RoHS_label.isDisplayed()&&NCNR.isDisplayed()&&Notes.isDisplayed()&&mandatory_field.isDisplayed())
			LogClass.VerificationPass_Extent_Report("Verified All Labels in See More section are displayed");
		funcs.waitforseconds(2);
		funcs.clickon_element_wid(driver, see_less);
		if(see_more.isDisplayed())
			LogClass.VerificationPass_Extent_Report("Verified See Less button functionality");
		act.moveToElement(supplier_name).build().perform();
		return new CalcuQuote_MaterialCosting_Verification(driver);
	}

	@FindBy(xpath="//input[@id='price']")private static WebElement unit_price;
	@FindBy(xpath="//div[text()='Pricing saved successfully.']")private static WebElement successfully_msg;
	public static CalcuQuote_MaterialCosting_Verification Enter_Price() throws InterruptedException {
		// TODO Auto-generated method stub
		unit_price.sendKeys(unit_price_var);
		funcs.clickon_element_wid(driver,save_btn );
		long startTime = System.currentTimeMillis();
		System.out.println("Start Time :"+startTime);
		Thread.sleep(500);
		if(successfully_msg.isDisplayed()) {
			LogClass.VerificationPass_Extent_Report("Message appear on the Screen :: "+successfully_msg.getText());
			long endTime = System.currentTimeMillis();
			System.out.println("End Time :"+endTime);
			Double timeElapsed = (double) (endTime - startTime);
			timeElapsed = timeElapsed/1000;
			System.out.println("TimeElapsed :"+timeElapsed);
			if(timeElapsed>1.000000) 
				{LogClass.VerificationFailed_Extent_Report("Fail --> Longer then expected time (time in seconds) : "+(timeElapsed));
				LogClass.AssertFailed_Extent_Report();}
			else
				{LogClass.VerificationPass_Extent_Report("Pass --> As per expected time (time in seconds) : "+(timeElapsed));
				LogClass.AssertPass_Extent_Report();}
		}
		return new CalcuQuote_MaterialCosting_Verification(driver);
	}

	public static CalcuQuote_MaterialCosting_Verification select_supplier() {
		// TODO Auto-generated method stub		
		funcs.waitforseconds(3);
		supplier_name.sendKeys("TTI");
		funcs.jsClick(driver,select_supplier );
		return new CalcuQuote_MaterialCosting_Verification(driver);
	}

	@FindBy(xpath="//select[@id='currency']")private static WebElement currency_quick_price;
	//@FindBy(xpath="")private static WebElement gbp;
	public static CalcuQuote_MaterialCosting_Verification choose_currency() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(1);
		Select sel = new Select(currency_quick_price);
		sel.selectByValue("string:GBP");		
		return new CalcuQuote_MaterialCosting_Verification(driver);
	}

	public static CalcuQuote_MaterialCosting_Verification savebtn_quick_price() {
		// TODO Auto-generated method stub
		funcs.clickon_element(driver,save_btn );
		return new CalcuQuote_MaterialCosting_Verification(driver);
	}

	public static CalcuQuote_MaterialCosting_Verification Enter_Price_in_GBP() {
		// TODO Auto-generated method stub
		unit_price.sendKeys("0.888888");
		return new CalcuQuote_MaterialCosting_Verification(driver);
	}
	
	@FindBy(xpath="//button[@ng-click='PurchaseReview()']")private static WebElement review_tab;

	public static CalcuQuote_MaterialCosting_Verification click_review_tab() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(1);
		funcs.clickon_element(driver,review_tab );
		return new CalcuQuote_MaterialCosting_Verification(driver);
	}

	@FindBy(xpath="//a[contains(text(),'Leading Cost Drivers')] ")private static WebElement leading_cost_drivers;
	
	public static CalcuQuote_MaterialCosting_Verification click_leading_cost_tab() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(2);
		funcs.clickon_element(driver,leading_cost_drivers);	
		return new CalcuQuote_MaterialCosting_Verification(driver);
	}

@FindBy(xpath="//span[contains(@uib-tooltip,'Pricing Selected')]")private static List<WebElement> Quick_add_price_leading_cost_screen;
	public static CalcuQuote_MaterialCosting_Verification navigate_to_add_price_screen() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(3);
		act.contextClick(Quick_add_price_leading_cost_screen.get(0)).build().perform();;
		funcs.waitforseconds(2);
		funcs.clickon_element(driver,quick_add_price );
		return new  CalcuQuote_MaterialCosting_Verification(driver);
	}

	public static CalcuQuote_MaterialCosting_Verification measure_time() throws InterruptedException {
		// TODO Auto-generated method stub
		funcs.waitforseconds(3);
		long startTime = System.currentTimeMillis();
		System.out.println("Start Time :"+startTime);
		act.contextClick(pricing_data_unavailable.get(0)).build().perform();
		Thread.sleep(500);
		funcs.clickon_element_wid(driver,quick_add_price );		
		funcs.waitforseconds(2);
		supplier_name.sendKeys("TTI");		
		funcs.jsClick(driver,select_supplier );
		unit_price.sendKeys(unit_price_var);
		funcs.clickon_element_wid(driver,save_btn );
		//Double timeElapsed = (double) (endTime - startTime);
		//timeElapsed = timeElapsed/1000;
		//System.out.println("TimeElapsed :"+timeElapsed);
		Thread.sleep(500);
		if(successfully_msg.isDisplayed()) {
			LogClass.VerificationPass_Extent_Report("Message appear on the Screen :: "+successfully_msg.getText());
			long endTime = System.currentTimeMillis();
			System.out.println("End Time :"+endTime);
			Double timeElapsed = (double) (endTime - startTime);
			timeElapsed = timeElapsed/1000;
			CalcuQuote_MaterialCosting_Verification.quick_add_time =timeElapsed-3.000000;
			System.out.println("TimeElapsed :"+timeElapsed);			
		}
		return new CalcuQuote_MaterialCosting_Verification(driver);
	}

}
