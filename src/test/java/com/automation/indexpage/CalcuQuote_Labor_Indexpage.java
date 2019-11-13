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


public class CalcuQuote_Labor_Indexpage extends CalcuQuote_AbstractPage {
	public CalcuQuote_Labor_Indexpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//a[@ng-class='AssemblyStatus.Labour']")private static WebElement labor_tab;
	@FindBy(xpath="//select[@id='sourcelabourdriver']")private static WebElement select_labor_activities;
	@FindBy(xpath="//select[@id='sourcelabourdriver']//option")private static List<WebElement> labor_activities_options;
	@FindBy(xpath="//button[@class='btn move btn-default']")private static WebElement arrow_labor_select;
	@FindBy(xpath="//button[@ng-click='next()']")private static WebElement click_next_labor;
	
	public static CalcuQuote_Labor_Verification labor_activities() {
		// TODO Auto-generated method stub
		
		funcs.waitforseconds(5);
		funcs.clickon_element(driver, labor_tab);
		LogClass.logExtent("---> Click on Labor Tab <---");
		
		funcs.waitforseconds(6);		
		Select options = new Select(select_labor_activities);
		int i = labor_activities_options.size();
		for(int j=0;j<=i;j++) {
			
			if(j>4) break;
			options.selectByIndex(j);			
			LogClass.logExtent("---> Labor Activity Selected <---");
			
			funcs.waitforseconds(1);			
			funcs.clickon_element(driver, arrow_labor_select);
			LogClass.logExtent("---> Labor Activity added for the RFQ <---::"+(j+1));
			
			funcs.waitforseconds(1);
			funcs.clickon_element(driver, click_next_labor);
			LogClass.logExtent("---> Click on Next Button <---");
			
			options.deselectByIndex(j);	
		    funcs.waitforseconds(1);	
		}
		return new CalcuQuote_Labor_Verification(driver);
	}

	@FindBy(xpath="//button[@class='btn']")private static WebElement labor_submit_btn;
	@FindBy(xpath="//button[text()='Yes']")private static WebElement labor_submit_yes_btn;
	public static CalcuQuote_Labor_Verification clicksubmitLabor() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(3);
		funcs.clickon_element(driver, labor_submit_btn);
		LogClass.logExtent("---> Click on Labor Submit Button <---");
		
		//funcs.waitforseconds(5);
		//funcs.clickon_element(driver, labor_submit_yes_btn);
		//LogClass.log("---> Click on Yes Button <---");
		//LogClass.logExtent("---> Click on Yes Button <---");
		
		funcs.waitforseconds(3);
		
		return new CalcuQuote_Labor_Verification(driver);
	}

	
}
