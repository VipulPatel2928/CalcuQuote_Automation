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
		LogClass.log("---> Click on Material Costing Tab <---");
		LogClass.logExtent("---> Click on Material Costing Tab <---");
		
		funcs.waitforseconds(5);
		funcs.clickon_element(driver,update_pricing );
		LogClass.log("---> Click on Update Pricing Tab <---");
		LogClass.logExtent("---> Click on Update Pricing Tab <---");
		
		funcs.waitforseconds(3);
		funcs.clickon_element(driver,MC_POPup_submit_btn );
		LogClass.log("---> Click on Submit Button for Update Pricing <---");
		LogClass.logExtent("---> Click on Submit Button for Update Pricing <---");
		
		new WebDriverWait(driver,300).until(ExpectedConditions.visibilityOf( update_pricing));
		///WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(element));
		
		/*
		 * funcs.waitforseconds(3); funcs.clickon_element(driver,auto_select_btn );
		 * LogClass.log("---> Click on Auto Select Button <---");
		 * LogClass.logExtent("---> Click on Auto Select Button <---");
		 */
		
		String totalQuantity = CalcuQuote_TestData.numberofquantity(7);
		int totalQ = Integer.parseInt(totalQuantity);
		int prices = totalQ*4;
		if(pricing_available.size()==prices) {
			LogClass.log("---> Pricing Available for All line and All Quantity <---");
			LogClass.logExtent("---> Pricing Available for All line and All Quantity <---");
		}
		
		
		LogClass.log("---> Pricing Selection for each line item start <---");
		LogClass.logExtent("---> Pricing Selection for each line item start <---");
		
		System.out.println("pricing available="+pricing_available.size());
		funcs.clickon_element(driver,pricing_available.get(0) );
		
		for(int i=0;i<=3;i++) {
			//System.out.println("i="+i);
			//funcs.clickon_element(driver,pricing_available.get(i) );
			funcs.waitforseconds(3);
			funcs.clickon_element(driver,select_line.get(1) );
			funcs.clickon_element(driver,apply_to_all_quantity );
			funcs.waitforseconds(4);
			funcs.clickon_element(driver,cqps_next_btn );
			funcs.waitforseconds(8);			
		}
		
		funcs.waitforseconds(4);
		funcs.clickon_element(driver,close_CQPS );
		//funcs.waitforseconds(1);
		//funcs.clickon_element(driver,ok_btn );
		
		LogClass.log("---> Pricing Selection for each line item finished <---");
		LogClass.logExtent("---> Pricing Selection for each line item finished <---");
		
		funcs.waitforseconds(10);
		return new CalcuQuote_MaterialCosting_Verification(driver);
	}

	@FindBy(xpath="//button[@id='btnPurchaseSubmit']")private static WebElement material_costing_submit_btn;
	@FindBy(xpath="//button[text()='Ok']")private static WebElement material_submit_ok_btn;
	public static CalcuQuote_MaterialCosting_Verification clicksubmitmaterialcosting() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(5);
		funcs.clickon_element(driver,material_costing_submit_btn );
		LogClass.log("---> Click on Material Costing Submit button <---");
		LogClass.logExtent("---> Click on Material Costing Submit button <---");
		
		funcs.waitforseconds(5);
		funcs.clickon_element(driver,material_submit_ok_btn );
		LogClass.log("---> Click on OK button <---");
		LogClass.logExtent("---> Click on OK button <---");
		return new CalcuQuote_MaterialCosting_Verification(driver);
	}

}