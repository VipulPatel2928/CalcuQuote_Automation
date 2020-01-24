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

import com.automation.index.CalcuQuote_Material_Costing_Index;
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
	public static int SMT_flag=1;
	//public static int total_qty_reset_flag=0;
	public static String filepath =null;
	public static String[] part_class = {"number:303","number:301","number:299"};
	//,"number:299","number:328","number:329","number:330"};
	@FindBy(xpath="//span[contains(text(),'Or, if you prefer...')]//..//i[2]")private static WebElement import_bom;
	@FindBy(xpath="//a[@title='Import BOM']")private static WebElement act_import_bom;
	@FindBy(xpath="//input[@id='upfile']")private static WebElement choose_file;
	@FindBy(xpath="//button[contains(text(),'Import')]")private static WebElement import_bom_after_choose_file;
	@FindBy(xpath="//span[contains(text(),'Install')]")private static WebElement install_element;
	
	public static CalcuQuote_BOM_Verification ImportBOM() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(5);
		//Remove the comment of all lines if you want the script to delete the BOM before 
		funcs.clickon_element(driver,actions_menu); 
		LogClass.logExtent("---> Click On Action Menu <---");
		funcs.clickon_element(driver, delete_bom);	
		LogClass.logExtent("---> Click On Delete BOM <---");
		funcs.clickon_element(driver, delete_btn);
		LogClass.logExtent("---> Click On Delete button<---");
		funcs.waitforseconds(2);
		driver.navigate().refresh();
		
		funcs.waitforseconds(5);
		funcs.clickon_element(driver, import_bom);
		funcs.waitforseconds(4);
		//String filepath="Resources/35LineBOM.xlsx";
		funcs.uploadthefile(driver, choose_file, 5, filepath);
		funcs.waitforseconds(2);
		LogClass.logExtent("---> File Selected for Import <---");
		
		funcs.waitforseconds(3);
		funcs.clickon_element(driver, import_bom_after_choose_file);
		LogClass.logExtent("---> BOM imported <---");
		funcs.waitforseconds(6);
		return new CalcuQuote_BOM_Verification(driver);
	}
	
	public static CalcuQuote_BOM_Verification ImportBOMorg() {
		// TODO Auto-generated method stub
		
		//Remove the comment of all lines if you want the script to delete the BOM before 
		/*funcs.clickon_element(driver,actions_menu); 
		LogClass.logExtent("---> Click On Action Menu <---");
		funcs.clickon_element(driver, delete_bom);	
		LogClass.logExtent("---> Click On Delete BOM <---");
		funcs.clickon_element(driver, delete_btn);
		LogClass.logExtent("---> Click On Delete button<---");
		funcs.waitforseconds(2);
		driver.navigate().refresh();*/
		
		funcs.waitforseconds(5);
		funcs.clickon_element(driver, import_bom);
		funcs.waitforseconds(4);
		//String filepath="Resources/35LineBOM.xlsx";
		funcs.uploadthefile(driver, choose_file, 5, filepath);
		funcs.waitforseconds(2);
		LogClass.logExtent("---> File Selected for Import <---");
		
		funcs.waitforseconds(3);
		funcs.clickon_element(driver, import_bom_after_choose_file);
		LogClass.logExtent("---> BOM imported <---");
		funcs.waitforseconds(6);
		return new CalcuQuote_BOM_Verification(driver);
	}
	
	
	@FindBy(xpath="//button[@id='btnSubmit']")private static WebElement bom_submit_btn;
	@FindBy(xpath="//button[text()='Submit']//i")private static WebElement restart_submit;
	public static CalcuQuote_BOM_Verification clicksubmitBOM() {
		// TODO Auto-generated method stub
		int flag=0;
		funcs.waitforseconds(4);
		funcs.clickon_element(driver, bom_submit_btn);
		LogClass.logExtent("---> Click on BOM Submit Button <---");
		funcs.waitforseconds(2);
		
		//Remove the comment if you want to use the existing BOM. 
		funcs.waitforseconds(4);
		funcs.clickon_element(driver, restart_submit);
		LogClass.logExtent("---> Click on BOM Submit Button <---");
		
		return new CalcuQuote_BOM_Verification(driver);
	}
	
	@FindBy(xpath="//span[@class='caret']")private static WebElement actions_menu; 
	@FindBy(xpath="//a[@ng-click='deleteBom();']")private static WebElement delete_bom;
	@FindBy(xpath="//button[text()='Delete']")private static WebElement delete_btn;
	
	@FindBy(xpath="//span[text()='Or, if you prefer...']//..//i[1]")private static WebElement plus_icon_manual_add;
	
	@FindBy(xpath="//div[@class='height-grid ui-grid-cell-contents ng-binding ng-scope invalid ui-grid-cell-focus']")private static WebElement click_line_no;
	@FindBy(xpath="//input[@id='txtRowNumber_0']")private static WebElement enter_line_no;
	
	@FindBy(xpath="//div[@id='dvQty_0']")private static WebElement click_qty_on_brd;
	@FindBy(xpath="//input[@id='txtQty_0']")private static WebElement enter_qty_on_brd;
	
	@FindBy(xpath="//div[@id='dvPartClass_0']") private static WebElement click_part_class;
	@FindBy(xpath="//select[@id='ddlPartClass_0']")private static WebElement select_part_class;
	
	@FindBy(xpath="//input[@type='number']")private static List<WebElement> lead_qty;
	
	@FindBy(xpath="//div[@id='dvMPN_0']")private static WebElement click_mpn;
	@FindBy(xpath="//button[text()='OK']")private static List<WebElement> ok_btn;
	@FindBy(xpath="//form[@name='inputForm']//input")private static WebElement enter_mpn;
	
	@FindBy(xpath="//i[@ng-click='closeMpnDetail()']")private static WebElement close_mpn_deatils;
	
	
	public static CalcuQuote_BOM_Verification addlineitemmanually() {
		funcs.waitforseconds(5);
		funcs.clickon_element(driver,actions_menu); 
		LogClass.logExtent("---> Click On Action Menu <---");
		funcs.clickon_element(driver, delete_bom);	
		LogClass.logExtent("---> Click On Delete BOM <---");
		funcs.clickon_element(driver, delete_btn);
		LogClass.logExtent("---> Click On Delete button<---");
		funcs.waitforseconds(2);
		driver.navigate().refresh();
		
		// TODO Auto-generated method stub
		funcs.waitforseconds(6);
		funcs.clickon_element(driver, plus_icon_manual_add);
		LogClass.logExtent("---> Click On + Icon <---");
		
		
		//funcs.clickon_element(driver, click_line_no);
		//LogClass.logExtent("---> Click on Line No Text Field <---");
		funcs.waitforseconds(2);
		funcs.senddata(driver, enter_line_no, "1");
		LogClass.logExtent("---> Enter Line No <---");
		
		
		funcs.waitforseconds(1);
		funcs.clickon_element(driver, click_qty_on_brd);
		LogClass.logExtent("---> Click on Qty on Brd Text Field <---");
		funcs.waitforseconds(1);
		funcs.senddata(driver, enter_qty_on_brd, "10");
		CalcuQuote_MaterialCosting_Verification.qty_brd="10";
		LogClass.logExtent("---> Enter Qty/Brd <---");
		
	/*
		funcs.waitforseconds(1);
		//funcs.clickon_element(driver, click_part_class);
		funcs.jsClick(driver, click_part_class);
		LogClass.logExtent("---> Click On Part Class Field <---");
		funcs.waitforseconds(1);
		Select part_class = new Select(select_part_class);
		part_class.selectByIndex(4);
		LogClass.logExtent("---> Select Part Class <---");
	*/	
		
		funcs.waitforseconds(1);
		funcs.clickon_element(driver, click_mpn);
		LogClass.logExtent("---> Click On MPN Field <---");
		funcs.waitforseconds(1);
		//funcs.jsClick(driver, ok_btn);
		//funcs.clickon_element(driver, ok_btn.get(1));
		funcs.waitforseconds(1);
		//Actions act = new Actions(driver);
		//act.doubleClick(click_mpn).build().perform();
		//funcs.clickon_element(driver, click_mpn);
		funcs.senddata(driver, enter_mpn, "5014");
		LogClass.logExtent("---> Enter MPN <---");
		
		funcs.waitforseconds(1);
		//funcs.clickon_element(driver, click_part_class);
		funcs.jsClick(driver, click_part_class);
		LogClass.logExtent("---> Click On Part Class Field <---");
		funcs.waitforseconds(1);
		Select part_class = new Select(select_part_class);
		//part_class.selectByIndex(4);
		part_class.selectByValue("number:303");
		LogClass.logExtent("---> Select Part Class <---");
		
		
	/*	
		funcs.waitforseconds(1);
		funcs.clickon_element(driver, close_mpn_deatils);
		LogClass.logExtent("---> Close MPN Detail <---");
	*/	
		funcs.waitforseconds(1);
		
		return new CalcuQuote_BOM_Verification(driver);
	}


	public static CalcuQuote_BOM_Verification clicksubmitBOM_manual() {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			funcs.waitforseconds(2);
			funcs.clickon_element(driver, bom_submit_btn);
			LogClass.logExtent("---> Click on BOM Submit Button <---");
			return new CalcuQuote_BOM_Verification(driver);	
	}


	public static CalcuQuote_BOM_Verification SMT_clicksubmitBOM_manual() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(2);
		funcs.clickon_element(driver, bom_submit_btn);
		LogClass.logExtent("---> Click on BOM Submit Button <---");
		if(SMT_flag>0) {
		funcs.waitforseconds(1);
		funcs.clickon_element(driver, restart_submit);
		LogClass.logExtent("---> Click on BOM Submit Button <---");
		SMT_flag++;
		}
		return new CalcuQuote_BOM_Verification(driver);	
	}

	
@FindBy(xpath="//a[@ui-sref='Assembly.Bom']")private static WebElement bom_tab;
@FindBy(xpath="//span[text()='Assembly Number :']")private static WebElement assembly_no;
@FindBy(xpath="//div[@role='gridcell']//..//div")private static List<WebElement> lead_qty_nd_attr_rate_data;
//@FindBy(xpath="//div[contains(text(),'Changing the Lead, Attrition or Minimum Purchase ')]")private static WebElement clear_prices_diff_total_Qty_flag;
@FindBy(xpath="//button[text()=' Yes, update the values']")private static WebElement yes_update_btn;

	public static CalcuQuote_BOM_Verification edit_part_class_manually() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(5);
		//total_qty_reset_flag=0;
		funcs.clickon_element(driver, bom_tab);
		LogClass.logExtent("---> Click On BOM tab <---");
			
		funcs.waitforseconds(6);
		//funcs.clickon_element(driver, click_part_class);
		funcs.jsClick(driver, click_part_class);
		LogClass.logExtent("---> Click On Part Class Field <---");
		//LogClass.logExtent("---> Select Part Class <---"+click_part_class.getText());
		
		////div[contains(text(),'SMT')]
		
		funcs.waitforseconds(1);
		Select part_class = new Select(select_part_class);
		
		//part_class.selectByIndex(5);
		part_class.selectByValue(CalcuQuote_Material_Costing_Index.part_class_name);
		
		funcs.waitforseconds(1);
		funcs.jsClick(driver, click_part_class);
		//LogClass.logExtent("---> Click On Part Class Field <---");
		LogClass.logExtent("---> Part Class Changed <---");
		
		funcs.waitforseconds(1);		
		funcs.clickon_element(driver, click_qty_on_brd);
		LogClass.logExtent("---> Click on Qty on Brd Text Field <---");
		
		funcs.waitforseconds(2);
		
		
	    funcs.clickon_element(driver, yes_update_btn);
		LogClass.logExtent("---> Click On Yes,update the values <---");
				//total_qty_reset_flag=1;
		
		funcs.waitforseconds(2);
		CalcuQuote_MaterialCosting_Verification.lead_qty=lead_qty_nd_attr_rate_data.get(18).getText();
		System.out.println("Lead Qty:"+lead_qty_nd_attr_rate_data.get(18).getText());
		//System.out.println("Lead Qty:"+lead_qty_nd_attr_rate_data.get(19).getText());	
		CalcuQuote_MaterialCosting_Verification.attr_rate=lead_qty_nd_attr_rate_data.get(20).getText();
		System.out.println("Attr Rate:"+lead_qty_nd_attr_rate_data.get(20).getText());
		//System.out.println("Attr Rate:"+lead_qty_nd_attr_rate_data.get(21).getText());	
		
		return new CalcuQuote_BOM_Verification(driver);
	}


	public static CalcuQuote_BOM_Verification edit_part_class_manually_1() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(5);
		//total_qty_reset_flag=0;
		funcs.clickon_element(driver, bom_tab);
		LogClass.logExtent("---> Click On BOM tab <---");
			
		funcs.waitforseconds(6);
		//funcs.clickon_element(driver, click_part_class);
		funcs.jsClick(driver, click_part_class);
		LogClass.logExtent("---> Click On Part Class Field <---");
		//LogClass.logExtent("---> Select Part Class <---"+click_part_class.getText());
		
		////div[contains(text(),'SMT')]
		
		funcs.waitforseconds(1);
		Select part_class = new Select(select_part_class);
		
		//part_class.selectByIndex(5);
		part_class.selectByValue(CalcuQuote_Material_Costing_Index.part_class_name);
		
		funcs.waitforseconds(1);
		funcs.jsClick(driver, click_part_class);
		//LogClass.logExtent("---> Click On Part Class Field <---");
		LogClass.logExtent("---> Part Class Changed <---");
		
		funcs.waitforseconds(1);		
		funcs.clickon_element(driver, click_qty_on_brd);
		LogClass.logExtent("---> Click on Qty on Brd Text Field <---");
		
		funcs.waitforseconds(2);
		
		
	   // funcs.clickon_element(driver, yes_update_btn);
	   //LogClass.logExtent("---> Click On Yes,update the values <---");
			
		
		funcs.waitforseconds(2);
		CalcuQuote_MaterialCosting_Verification.lead_qty=lead_qty_nd_attr_rate_data.get(18).getText();
		System.out.println("Lead Qty:"+lead_qty_nd_attr_rate_data.get(18).getText());
		//System.out.println("Lead Qty:"+lead_qty_nd_attr_rate_data.get(19).getText());	
		CalcuQuote_MaterialCosting_Verification.attr_rate=lead_qty_nd_attr_rate_data.get(20).getText();
		System.out.println("Attr Rate:"+lead_qty_nd_attr_rate_data.get(20).getText());
		//System.out.println("Attr Rate:"+lead_qty_nd_attr_rate_data.get(21).getText());	
		
		return new CalcuQuote_BOM_Verification(driver);
	}

	
	@FindBy(xpath="//span[contains(@title,'BOM')]")private static WebElement importbom_check;
	public static CalcuQuote_BOM_Verification already_ImportBOM() {
		// TODO Auto-generated method stub
		String status = importbom_check.getAttribute("title");
		System.out.println("Bom is imported or not:"+status);
		return new CalcuQuote_BOM_Verification(driver);
	}
}
