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

public class CalcuQuote_BOM_Indexpage extends CalcuQuote_AbstractPage {
	public CalcuQuote_BOM_Indexpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//span[contains(text(),'Or, if you prefer...')]//..//i[2]")private static WebElement import_bom;
	@FindBy(xpath="//input[@id='upfile']")private static WebElement choose_file;
	@FindBy(xpath="//button[contains(text(),'Import')]")private static WebElement import_bom_after_choose_file;
	public static CalcuQuote_BOM_Verification ImportBOM() {
		// TODO Auto-generated method stub
		
		funcs.waitforseconds(5);
		funcs.clickon_element(driver, import_bom);
		LogClass.logExtent("---> Click On Import BOM Icon <---");
		
		funcs.waitforseconds(4);
		String filepath="Resources/35LineBOM.xlsx";
		funcs.uploadthefile(driver, choose_file, 5, filepath);
		funcs.waitforseconds(2);
		LogClass.logExtent("---> File Selected for Import <---");
		
		funcs.waitforseconds(3);
		funcs.clickon_element(driver, import_bom_after_choose_file);
		LogClass.logExtent("---> BOM imported <---");
		funcs.waitforseconds(10);
		return new CalcuQuote_BOM_Verification(driver);
	}
	
	@FindBy(xpath="//button[@id='btnSubmit']")private static WebElement bom_submit_btn;
	public static CalcuQuote_BOM_Verification clicksubmitBOM() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(3);
		funcs.clickon_element(driver, bom_submit_btn);
		LogClass.logExtent("---> Click on BOM Submit Button <---");
		return new CalcuQuote_BOM_Verification(driver);
	}
	
	@FindBy(xpath="//span[text()='Or, if you prefer...']//..//i[1]")private static WebElement plus_icon_manual_add;
	@FindBy(xpath="//div[@class='height-grid ui-grid-cell-contents ng-binding ng-scope invalid ui-grid-cell-focus']")private static WebElement line_no;
	@FindBy(xpath="//div[@id='dvQty_0']")private static WebElement qty_on_brd;
	@FindBy(xpath="//div[@id='dvPartClass_0']") private static WebElement part_class;
	@FindBy(xpath="//div[@id='dvMPN_0']")private static WebElement mpn;
	
	
	public static CalcuQuote_BOM_Verification addlineitemmanually() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(5);
		funcs.clickon_element(driver, plus_icon_manual_add);
		LogClass.logExtent("---> Click On + Icon <---");
		
		funcs.waitforseconds(1);
		line_no.sendKeys("1");
		//funcs.senddata(driver, line_no, "1");
		LogClass.logExtent("---> Enter Line No <---");
		
		funcs.waitforseconds(1);
		//funcs.senddata(driver, qty_on_brd, "10");
		qty_on_brd.sendKeys("10");
		LogClass.logExtent("---> Enter Quantity on Board <---");	
		
		funcs.waitforseconds(1);
		funcs.clickon_element(driver, part_class);
		LogClass.logExtent("---> Click On Part Class <---");
		
		funcs.waitforseconds(1);
		//funcs.senddata(driver, line_no, "5014_Automation");
		mpn.sendKeys("5014_Automation");
		LogClass.logExtent("---> Enter MPN <---");
		
		funcs.waitforseconds(10);
		
		return new CalcuQuote_BOM_Verification(driver);
	}
}
