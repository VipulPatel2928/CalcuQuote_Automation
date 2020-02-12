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


public class CalcuQuote_Login_Indexpage extends CalcuQuote_AbstractPage {

	public CalcuQuote_Login_Indexpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@name='username']")
	private static WebElement calcuquote_username;
	@FindBy(xpath = "//input[@id='password']")
	private static WebElement calcuquote_password;
	@FindBy(xpath = "//button[@id='btnlogin']")
	private static WebElement calcuquote_login_btn;

	public static CalcuQuote_Login_Verification CalcuQuote_Valid_Credentials() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(1);
		funcs.senddata(driver, calcuquote_username, CalcuQuote_SeleniumInit.username);

		LogClass.logExtent("==> Enter Username ");
		funcs.senddata(driver, calcuquote_password, CalcuQuote_SeleniumInit.password);

		LogClass.logExtent("==> Enter Password ");
		funcs.clickon_element(driver, calcuquote_login_btn);

		LogClass.logExtent("==> Click on Login Button");
		funcs.waitforseconds(1);
		return new CalcuQuote_Login_Verification(driver);
	}

	@FindBy(xpath = "//input[@name='username']")
	private static WebElement calcuquote_username_validation;
	@FindBy(xpath = "//input[@id='password']")
	private static WebElement calcuquote_password_validation;
	@FindBy(xpath = "//button[@id='btnlogin']")
	private static WebElement login_btn_validation;

	public static CalcuQuote_Login_Verification CalcuQuote_inValid_Credentials() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(5);

		LogClass.logExtent("==> Blank Email id and Blank Password");
		funcs.clickon_element(driver, login_btn_validation);
		CalcuQuote_Login_Verification.blankusername_psw();

		funcs.waitforseconds(1);
		
		LogClass.logExtent("==> Invalid Email id or Password");
		
		funcs.senddata(driver, calcuquote_username_validation, "Test@mailinator.com");		
		LogClass.logExtent("==> Enter Username");
		
		funcs.senddata(driver, calcuquote_password_validation, "Invalidpassword");		
		LogClass.logExtent("==> Enter Password");
		
		funcs.clickon_element(driver, login_btn_validation);
		LogClass.logExtent("==> Enter Click on Login Button");
		CalcuQuote_Login_Verification.invalidusername_psw();

		return new CalcuQuote_Login_Verification(driver);
	}

	@FindBy(xpath = "//a[@title='RFQ List']//i")
	private static WebElement rfq_list;
	@FindBy(xpath = "//input[@class='ui-grid-filter-input ui-grid-filter-input-0']")
	private static List<WebElement> assembly_no;
	@FindBy(xpath = "//a[@id='lnkAssemblyId_0']")
	private static WebElement assembly_id;
	/*
	 * @FindBy(xpath = "//a[text()='NRE']") private static WebElement NRE;
	 */

	public static CalcuQuote_Login_Verification select_rfq() {
		// TODO Auto-generated method stub

		funcs.waitforseconds(2);
		funcs.clickon_element(driver, rfq_list);
		LogClass.logExtent("==> Click on RFQ List icon");
		
		String fileName = "lib/Assembly_number";
		ArrayList<String> line = funcs.ReadTextFile(fileName, 1);
		System.out.println("Assembly no read from the text file:"+line.get(0));
		funcs.waitforseconds(6);		
		assembly_no.get(3).clear();
		assembly_no.get(3).sendKeys(line.get(0));
		//funcs.senddata(driver, assembly_no.get(3), line.get(0));		
		LogClass.logExtent("==> Enter Assembly No.");
		funcs.waitforseconds(3);  //wait change from 6 to 3
		funcs.clickon_element(driver, assembly_id);
		LogClass.logExtent("==> Click on Assembly Id.");		
		//funcs.waitforseconds(2);//increase or decrease the wait as per requirements
		return new CalcuQuote_Login_Verification(driver);
	}

	@FindBy(xpath="//button[@id='btnSubmit']")private static WebElement bom_submit_btn;
	public static CalcuQuote_Login_Verification clicksubmitBOM() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(3);
		funcs.clickon_element(driver, bom_submit_btn);
		LogClass.log("---> Click on BOM Submit Button <---");
		LogClass.logExtent("---> Click on BOM Submit Button <---");
		return new CalcuQuote_Login_Verification(driver);
	}
	
}
