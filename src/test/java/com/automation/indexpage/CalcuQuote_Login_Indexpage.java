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

		LogClass.log("---> Enter Username <---");
		LogClass.logExtent("---> Enter Username <---");
		funcs.senddata(driver, calcuquote_password, CalcuQuote_SeleniumInit.password);

		LogClass.log("---> Enter Password <---");
		LogClass.logExtent("---> Enter Password <---");
		funcs.clickon_element(driver, calcuquote_login_btn);

		LogClass.log("---> Click on Login Button <---");
		LogClass.logExtent("---> Click on Login Button <---");
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

		LogClass.log("---> Blank Email id and Blank Password <---");
		LogClass.logExtent("---> Blank Email id and Blank Password <---");
		funcs.clickon_element(driver, login_btn_validation);
		CalcuQuote_Login_Verification.blankusername_psw();

		funcs.waitforseconds(1);
		LogClass.log("---> Invalid Email id or Password <---");
		LogClass.logExtent("---> Invalid Email id or Password <---");

		funcs.senddata(driver, calcuquote_username_validation, "Test@mailinator.com");
		LogClass.log("---> Enter Username <---");
		LogClass.logExtent("---> Enter Username <---");

		funcs.senddata(driver, calcuquote_password_validation, "Invalidpassword");
		LogClass.log("---> Enter Password <---");
		LogClass.logExtent("---> Enter Password <---");
		funcs.clickon_element(driver, login_btn_validation);

		LogClass.log("---> Enter Enter Click on Login Button <---");
		LogClass.logExtent("---> Enter Click on Login Button <---");
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
		LogClass.log("---> Click on RFQ List icon <---");
		LogClass.logExtent("---> Click on RFQ List icon <---");
		
		String fileName = "lib/Assembly_number";
		ArrayList<String> line = funcs.ReadTextFile(fileName, 1);
		System.out.println("Assembly no read from the text file:"+line.get(0));
		funcs.waitforseconds(10);
		//funcs.senddata(driver, assembly_no.get(3), "3009_BidCQ");
		assembly_no.get(3).clear();
		assembly_no.get(3).sendKeys(line.get(0));
		//funcs.senddata(driver, assembly_no.get(3), line.get(0));		
		LogClass.log("---> Enter Assembly No. <---");
		LogClass.logExtent("---> Enter Assembly No. <---");

		funcs.waitforseconds(2);
		funcs.clickon_element(driver, assembly_id);
		LogClass.log("---> Click on Assembly Id. <---");
		LogClass.logExtent("---> Click on Assembly Id. <---");
		
		funcs.waitforseconds(2);//increase or decrease the wait as per requirements
		/*
		 * funcs.waitforseconds(12); funcs.clickon_element(driver, NRE);
		 * LogClass.log("---> Click on NRE Tab. <---");
		 * LogClass.logExtent("---> Click on NRE Tab. <---");
		 */
		return new CalcuQuote_Login_Verification(driver);
	}

	
	
	@FindBy(xpath = "//a[text()='NRE']")
	private static WebElement NRE;
	@FindBy(xpath = "//button[@title='Create NRE']")
	private static WebElement create_NRE;
	@FindBy(xpath = "//input[@id='name']")
	private static WebElement NRE_name;
	@FindBy(xpath = "//select[@id='chargeType']")
	private static WebElement charge_type;
	@FindBy(xpath = "//input[@title='Default Dollar Value']")
	private static WebElement default_value;
	@FindBy(xpath = "//button[@name='brnSave']")
	private static WebElement save_btn;
	@FindBy(xpath = "//button[@title='Add Standard NRE']")
	private static WebElement add_standard;
	@FindBy(xpath = "//div[contains(@title,'Error:')]")
	private static List<WebElement> first_click;
	@FindBy(xpath = "//select[@name='nreAssembly']")
	private static WebElement NRE_value;
	@FindBy(xpath = "//input[@type='number']")
	private static WebElement enter_value_4_NRE;
	@FindBy(xpath = "//div[contains(text(),'$')]")
	private static List<WebElement> dollar_value;
	@FindBy(xpath = "//div[@class='ui-grid-cell-contents ng-binding ng-scope ui-grid-cell-focus']")
	private static WebElement dollar_double_click;

//	@FindBy(xpath="//div[@class=\"ui-grid-cell-contents ng-binding ng-scope invalid ui-grid-cell-focus\"]")private static WebElement second_click;
	public static CalcuQuote_Login_Verification create_NRE() {
		// TODO Auto-generated method stub
		
		
		funcs.waitforseconds(8);
		funcs.clickon_element(driver, NRE);
		LogClass.log("---> Click on NRE Tab. <---");
		LogClass.logExtent("---> Click on NRE Tab. <---");
		
		
		funcs.waitforseconds(6);

		// Don't call this function if don't want to create the NRE.
		create_nre();

		funcs.waitforseconds(4);
		funcs.clickon_element(driver, add_standard);
		LogClass.log("---> Click Add Standard Tab. <---");
		LogClass.logExtent("---> Click Add Standard Tab. <---");
		funcs.waitforseconds(3);

		funcs.clickon_element(driver, first_click.get(0));
		System.out.println("---> Click 1<---");
		funcs.waitforseconds(4);

		Select value = new Select(NRE_value);
		value.selectByIndex(1);

		funcs.waitforseconds(3);

		try {

			if (first_click.get(0).isDisplayed()) {
				System.out.println("Value is not assigned to NRE");
				funcs.clickon_element(driver, first_click.get(0));
				funcs.waitforseconds(1);
				Actions act = new Actions(driver);
				act.doubleClick(first_click.get(0)).build().perform();
				System.out.println("---> Click for the value<---");
				enter_value_4_NRE.sendKeys("10.20");
				System.out.println("---> Enter Value of NRE <---");
				LogClass.log("---> Enter Value of NRE <---");
				LogClass.logExtent("---> Enter Value of NRE <---");
			}
		} catch (Exception e) {

			System.out.println("NRE has the assigned value and lets change the value");
			funcs.clickon_element(driver, dollar_value.get(0));
			Actions act = new Actions(driver);
			act.doubleClick(dollar_double_click).build().perform();
			enter_value_4_NRE.sendKeys("10.20");
			LogClass.log("---> Enter Value of NRE <---");
			LogClass.logExtent("---> Enter Value of NRE <---");

		}

		funcs.waitforseconds(7);
		funcs.clickon_element(driver, add_standard);
		LogClass.log("---> Click Add Standard Tab. <---");
		LogClass.logExtent("---> Click Add Standard Tab. <---");

		funcs.waitforseconds(3);
		funcs.clickon_element(driver, first_click.get(0));
		System.out.println("---> Click 1<---");

		funcs.waitforseconds(4);
		Select value1 = new Select(NRE_value);
		value1.selectByIndex(1);
		funcs.waitforseconds(6);

		try {
			if (first_click.get(0).isDisplayed()) {
				System.out.println("Value is not assigned to NRE");
				funcs.clickon_element(driver, first_click.get(0));
				funcs.waitforseconds(1);
				Actions act = new Actions(driver);
				act.doubleClick(first_click.get(0)).build().perform();
				System.out.println("---> Click for the value<---");
				enter_value_4_NRE.sendKeys("100.25");
				LogClass.log("---> Enter Value of NRE <---");
				LogClass.logExtent("---> Enter Value of NRE <---");
			}
		} catch (Exception e) {

			System.out.println("NRE has the assigned value and lets change the value");
			funcs.clickon_element(driver, dollar_value.get(1));
			Actions act = new Actions(driver);
			act.doubleClick(dollar_double_click).build().perform();
			enter_value_4_NRE.sendKeys("100.25");
			LogClass.log("---> Enter Value of NRE <---");
			LogClass.logExtent("---> Enter Value of NRE <---");

		}

		funcs.waitforseconds(7);
		funcs.clickon_element(driver, add_standard);
		LogClass.log("---> Click Add Standard Tab. <---");
		LogClass.logExtent("---> Click Add Standard Tab. <---");

		funcs.waitforseconds(3);
		funcs.clickon_element(driver, first_click.get(0));
		System.out.println("---> Click 1<---");

		funcs.waitforseconds(4);
		Select value2 = new Select(NRE_value);
		value2.selectByIndex(1);
		funcs.waitforseconds(6);

		try {
			if (first_click.get(0).isDisplayed()) {
				System.out.println("Value is not assigned to NRE");
				funcs.clickon_element(driver, first_click.get(0));
				funcs.waitforseconds(1);
				Actions act = new Actions(driver);
				act.doubleClick(first_click.get(0)).build().perform();
				System.out.println("---> Click for the value<---");
				enter_value_4_NRE.sendKeys("1.25");
				LogClass.log("---> Enter Value of NRE <---");
				LogClass.logExtent("---> Enter Value of NRE <---");
			}
		} catch (Exception e) {

			System.out.println("NRE has the assigned value and lets change the value");
			funcs.clickon_element(driver, dollar_value.get(2));

			Actions act = new Actions(driver);
			act.doubleClick(dollar_double_click).build().perform();
			enter_value_4_NRE.sendKeys("1.25");
			LogClass.log("---> Enter Value of NRE <---");
			LogClass.logExtent("---> Enter Value of NRE <---");

		}

		funcs.waitforseconds(10);
		return new CalcuQuote_Login_Verification(driver);
	}

	public static void create_nre() {
		// Entire code is to create the NRE

		funcs.clickon_element(driver, create_NRE);
		LogClass.log("---> Click create NRE Tab. <---");
		LogClass.logExtent("---> Click create NRE Tab. <---");

		String NRE_name_value = "Automation_" + CalcuQuote_TestData.randomAlpha(4);

		funcs.waitforseconds(4);
		funcs.senddata(driver, NRE_name, NRE_name_value);
		LogClass.log("---> Enter NRE Name <---");
		LogClass.logExtent("---> Enter NRE Name <---");

		funcs.waitforseconds(2);
		Select charge = new Select(charge_type);
		charge.selectByIndex(1);
		LogClass.log("---> Select the Charge type :Standard <---");
		LogClass.logExtent("---> Select the Charge type :Standard <---");

		funcs.waitforseconds(2);
		funcs.senddata(driver, default_value, "10");
		LogClass.log("---> Enter Default Value <---");
		LogClass.logExtent("---> Enter Default Value <---");

		funcs.waitforseconds(2);
		funcs.clickon_element(driver, save_btn);
		LogClass.log("---> Click SAVE button <---");
		LogClass.logExtent("---> Click SAVE button <---");
		funcs.waitforseconds(5);

	}

	@FindBy(xpath = "//a[@ng-click='AddReqForm()']")
	private static WebElement new_rfq_btn;
	@FindBy(xpath = "//select[@id='UserCompanyDetailID']")
	private static WebElement company_name;
	@FindBy(xpath = "//select[@id='JobType_Id']")
	private static WebElement job_type;
	@FindBy(xpath = "//select[@id='OrderTypeId']")
	private static WebElement order_type;
	@FindBy(xpath = "//input[@id='CustomerId']")
	private static WebElement customer_name;
	@FindBy(xpath = "//a[@title='Tata']")
	private static WebElement select_customer;
	@FindBy(xpath = "//button[@type='submit']")
	private static WebElement submit_btn;
	@FindBy(xpath = "//a[@ng-click='AddAssembly()']")
	private static WebElement add_assembly;
	@FindBy(xpath = "//input[@name='assemblyNumber']")
	private static WebElement assemblynumber;

	@FindBy(xpath = "//input[@id='quantity_0_0']")
	private static WebElement quantity_0;
	@FindBy(xpath = "//button[@title='Add Quantity']")
	private static List<WebElement> add_quantity;
	@FindBy(xpath = "//input[@id='quantity_0_1']")
	private static WebElement quantity_1;
	@FindBy(xpath = "//input[@id='quantity_0_2']")
	private static WebElement quantity_2;
	@FindBy(xpath = "//input[@id='quantity_0_3']")
	private static WebElement quantity_3;
	@FindBy(xpath = "//input[@id='quantity_0_4']")
	private static WebElement quantity_4;
	@FindBy(xpath = "//input[@id='quantity_0_5']")
	private static WebElement quantity_5;
	@FindBy(xpath = "//input[@id='quantity_0_6']")
	private static WebElement quantity_6;
	@FindBy(xpath = "//input[@id='quantity_0_7']")
	private static WebElement quantity_7;
	@FindBy(xpath = "//input[@id='quantity_0_8']")
	private static WebElement quantity_8;
	@FindBy(xpath = "//input[@id='quantity_0_9']")
	private static WebElement quantity_9;
	@FindBy(xpath = "//input[@id='quantity_0_10']")
	private static WebElement quantity_10;
	@FindBy(xpath = "//input[@id='quantity_0_11']")
	private static WebElement quantity_11;
	@FindBy(xpath = "//input[@id='quantity_0_12']")
	private static WebElement quantity_12;
	@FindBy(xpath = "//input[@id='quantity_0_13']")
	private static WebElement quantity_13;
	@FindBy(xpath = "//input[@id='quantity_0_14']")
	private static WebElement quantity_14;
	@FindBy(xpath = "//input[@id='quantity_0_15']")
	private static WebElement quantity_15;
	@FindBy(xpath = "//input[@id='quantity_0_16']")
	private static WebElement quantity_16;
	@FindBy(xpath = "//input[@id='quantity_0_17']")
	private static WebElement quantity_17;
	@FindBy(xpath = "//input[@id='quantity_0_18']")
	private static WebElement quantity_18;
	@FindBy(xpath = "//input[@id='quantity_0_19']")
	private static WebElement quantity_19;
	@FindBy(xpath = "//input[@id='quantity_0_20']")
	private static WebElement quantity_20;

	public static CalcuQuote_Login_Verification RFQ() {
		// TODO Auto-generated method stub

		funcs.waitforseconds(8);
		funcs.clickon_element(driver, rfq_list);
		LogClass.log("---> Click on RFQ List icon <---");
		LogClass.logExtent("---> Click on RFQ List icon <---");

		funcs.waitforseconds(5);
		funcs.clickon_element(driver, new_rfq_btn);
		LogClass.log("---> Click on new RFQ button <---");
		LogClass.logExtent("---> Click on new RFQ button <---");

		funcs.waitforseconds(3);
		funcs.selectFromComboByIndex(company_name, 1);
		LogClass.log("---> Company name selected <---");
		LogClass.logExtent("---> Company name selected <---");

		funcs.waitforseconds(1);
		funcs.selectFromCombo(job_type, "6");
		LogClass.log("---> Job type selected <---");
		LogClass.logExtent("---> Job type selected <---");

		funcs.waitforseconds(1);
		funcs.selectFromCombo(order_type, "7");
		LogClass.log("---> Order type selected <---");
		LogClass.logExtent("---> Order type selected <---");

		
		
		funcs.waitforseconds(1);
		String customername = CalcuQuote_TestData.numberofquantity(29);
		System.out.println("Customer Name from the Excelfile :"+customername);
		funcs.senddata(driver, customer_name, customername);
		LogClass.log("---> Enter Customer name <---");
		LogClass.logExtent("---> Enter Customer name <---");

		funcs.waitforseconds(1);
		funcs.clickon_element(driver, select_customer);
		LogClass.log("---> Click On Customer name <---");
		LogClass.logExtent("---> Click On Customer name <---");

		funcs.waitforseconds(1);
		Actions act = new Actions(driver);
		act.moveToElement(submit_btn).build().perform();

		funcs.waitforseconds(1);
		String assemblyno = "Automation_" + CalcuQuote_TestData.randomAlphaNumeric(3);

		funcs.senddata(driver, assemblynumber, assemblyno);
		LogClass.log("---> Enter Assembly Number <---");
		LogClass.logExtent("---> Enter Assembly Number <---");

		String totalQuantity = CalcuQuote_TestData.numberofquantity(7);
		int totalQ = Integer.parseInt(totalQuantity);
		String q1 = CalcuQuote_TestData.numberofquantity(8);
		String q2 = CalcuQuote_TestData.numberofquantity(9);
		String q3 = CalcuQuote_TestData.numberofquantity(10);
		String q4 = CalcuQuote_TestData.numberofquantity(11);
		String q5 = CalcuQuote_TestData.numberofquantity(12);
		String q6 = CalcuQuote_TestData.numberofquantity(13);
		String q7 = CalcuQuote_TestData.numberofquantity(14);
		String q8 = CalcuQuote_TestData.numberofquantity(15);
		String q9 = CalcuQuote_TestData.numberofquantity(16);
		String q10 = CalcuQuote_TestData.numberofquantity(17);
		String q11 = CalcuQuote_TestData.numberofquantity(18);
		String q12 = CalcuQuote_TestData.numberofquantity(19);
		String q13 = CalcuQuote_TestData.numberofquantity(20);
		String q14 = CalcuQuote_TestData.numberofquantity(21);
		String q15 = CalcuQuote_TestData.numberofquantity(22);
		String q16 = CalcuQuote_TestData.numberofquantity(23);
		String q17 = CalcuQuote_TestData.numberofquantity(24);
		String q18 = CalcuQuote_TestData.numberofquantity(25);
		String q19 = CalcuQuote_TestData.numberofquantity(26);
		String q20 = CalcuQuote_TestData.numberofquantity(27);

		if (totalQ >= 1) {
			funcs.waitforseconds(3);
			funcs.senddata(driver, quantity_0, q1);
			LogClass.log("---> Enter 1st Quantity <---");
			LogClass.logExtent("---> Enter 1st Quantity <---");

		}

		if (totalQ >= 2) {
			funcs.waitforseconds(1);
			funcs.clickon_element(driver, add_quantity.get(0));
			LogClass.log("---> Click On Add Quantity Icon <---");
			LogClass.logExtent("---> Click On Add Quantity Icon <---");
			funcs.waitforseconds(1);
			funcs.senddata(driver, quantity_1, q2);
			LogClass.log("---> Enter 2nd Quantity <---");
			LogClass.logExtent("---> Enter 2nd Quantity <---");

		}

		if (totalQ >= 3) {
			funcs.waitforseconds(1);
			funcs.clickon_element(driver, add_quantity.get(1));
			LogClass.log("---> Click On Add Quantity Icon <---");
			LogClass.logExtent("---> Click On Add Quantity Icon <---");
			funcs.waitforseconds(1);
			funcs.senddata(driver, quantity_2, q3);
			LogClass.log("---> Enter 3rd Quantity <---");
			LogClass.logExtent("---> Enter 3rd Quantity <---");

		}

		if (totalQ >= 4) {
			funcs.waitforseconds(1);
			funcs.clickon_element(driver, add_quantity.get(2));
			LogClass.log("---> Click On Add Quantity Icon <---");
			LogClass.logExtent("---> Click On Add Quantity Icon <---");
			funcs.waitforseconds(1);
			funcs.senddata(driver, quantity_3, q4);
			LogClass.log("---> Enter 4th Quantity <---");
			LogClass.logExtent("---> Enter 4th Quantity <---");
		}

		if (totalQ >= 5) {
			funcs.waitforseconds(1);
			funcs.clickon_element(driver, add_quantity.get(3));
			LogClass.log("---> Click On Add Quantity Icon <---");
			LogClass.logExtent("---> Click On Add Quantity Icon <---");
			funcs.waitforseconds(1);
			funcs.senddata(driver, quantity_4, q5);
			LogClass.log("---> Enter 5th Quantity <---");
			LogClass.logExtent("---> Enter 5th Quantity <---");
		}

		if (totalQ >= 6) {
			funcs.waitforseconds(1);
			funcs.clickon_element(driver, add_quantity.get(4));
			LogClass.log("---> Click On Add Quantity Icon <---");
			LogClass.logExtent("---> Click On Add Quantity Icon <---");
			funcs.waitforseconds(1);
			funcs.senddata(driver, quantity_5, q6);
			LogClass.log("---> Enter 6th Quantity <---");
			LogClass.logExtent("---> Enter 6th Quantity <---");
		}

		if (totalQ >= 7) {
			funcs.waitforseconds(1);
			funcs.clickon_element(driver, add_quantity.get(5));
			LogClass.log("---> Click On Add Quantity Icon <---");
			LogClass.logExtent("---> Click On Add Quantity Icon <---");
			funcs.waitforseconds(1);
			funcs.senddata(driver, quantity_6, q7);
			LogClass.log("---> Enter 7th Quantity <---");
			LogClass.logExtent("---> Enter 7th Quantity <---");
		}

		if (totalQ >= 8) {
			funcs.waitforseconds(1);
			funcs.clickon_element(driver, add_quantity.get(6));
			LogClass.log("---> Click On Add Quantity Icon <---");
			LogClass.logExtent("---> Click On Add Quantity Icon <---");
			funcs.waitforseconds(1);
			funcs.senddata(driver, quantity_7, q8);
			LogClass.log("---> Enter 8th Quantity <---");
			LogClass.logExtent("---> Enter 8th Quantity <---");
		}

		if (totalQ >= 9) {
			funcs.waitforseconds(1);
			funcs.clickon_element(driver, add_quantity.get(7));
			LogClass.log("---> Click On Add Quantity Icon <---");
			LogClass.logExtent("---> Click On Add Quantity Icon <---");
			funcs.waitforseconds(1);
			funcs.senddata(driver, quantity_8, q9);
			LogClass.log("---> Enter 9th Quantity <---");
			LogClass.logExtent("---> Enter 9th Quantity <---");
		}

		if (totalQ >= 10) {
			funcs.waitforseconds(1);
			funcs.clickon_element(driver, add_quantity.get(8));
			LogClass.log("---> Click On Add Quantity Icon <---");
			LogClass.logExtent("---> Click On Add Quantity Icon <---");
			funcs.waitforseconds(1);
			funcs.senddata(driver, quantity_9, q10);
			LogClass.log("---> Enter 10th Quantity <---");
			LogClass.logExtent("---> Enter 10th Quantity <---");
		}

		if (totalQ >= 11) {
			funcs.waitforseconds(1);
			funcs.clickon_element(driver, add_quantity.get(9));
			LogClass.log("---> Click On Add Quantity Icon <---");
			LogClass.logExtent("---> Click On Add Quantity Icon <---");
			funcs.waitforseconds(1);
			funcs.senddata(driver, quantity_10, q11);
			LogClass.log("---> Enter 11th Quantity <---");
			LogClass.logExtent("---> Enter 11th Quantity <---");
		}

		if (totalQ >= 12) {
			funcs.waitforseconds(1);
			funcs.clickon_element(driver, add_quantity.get(10));
			LogClass.log("---> Click On Add Quantity Icon <---");
			LogClass.logExtent("---> Click On Add Quantity Icon <---");
			funcs.waitforseconds(1);
			funcs.senddata(driver, quantity_11, q12);
			LogClass.log("---> Enter 12th Quantity <---");
			LogClass.logExtent("---> Enter 12th Quantity <---");
		}

		if (totalQ >= 13) {
			funcs.waitforseconds(1);
			funcs.clickon_element(driver, add_quantity.get(11));
			LogClass.log("---> Click On Add Quantity Icon <---");
			LogClass.logExtent("---> Click On Add Quantity Icon <---");
			funcs.waitforseconds(1);
			funcs.senddata(driver, quantity_12, q13);
			LogClass.log("---> Enter 13th Quantity <---");
			LogClass.logExtent("---> Enter 13th Quantity <---");
		}

		if (totalQ >= 14) {
			funcs.waitforseconds(1);
			funcs.clickon_element(driver, add_quantity.get(12));
			LogClass.log("---> Click On Add Quantity Icon <---");
			LogClass.logExtent("---> Click On Add Quantity Icon <---");
			funcs.waitforseconds(1);
			funcs.senddata(driver, quantity_13, q14);
			LogClass.log("---> Enter 14th Quantity <---");
			LogClass.logExtent("---> Enter 14th Quantity <---");
		}

		if (totalQ >= 15) {
			funcs.waitforseconds(1);
			funcs.clickon_element(driver, add_quantity.get(13));
			LogClass.log("---> Click On Add Quantity Icon <---");
			LogClass.logExtent("---> Click On Add Quantity Icon <---");
			funcs.waitforseconds(1);
			funcs.senddata(driver, quantity_14, q15);
			LogClass.log("---> Enter 15th Quantity <---");
			LogClass.logExtent("---> Enter 15th Quantity <---");
		}

		if (totalQ >= 16) {
			funcs.waitforseconds(1);
			funcs.clickon_element(driver, add_quantity.get(14));
			LogClass.log("---> Click On Add Quantity Icon <---");
			LogClass.logExtent("---> Click On Add Quantity Icon <---");
			funcs.waitforseconds(1);
			funcs.senddata(driver, quantity_15, q16);
			LogClass.log("---> Enter 16th Quantity <---");
			LogClass.logExtent("---> Enter 16th Quantity <---");
		}

		if (totalQ >= 17) {
			funcs.waitforseconds(1);
			funcs.clickon_element(driver, add_quantity.get(15));
			LogClass.log("---> Click On Add Quantity Icon <---");
			LogClass.logExtent("---> Click On Add Quantity Icon <---");
			funcs.waitforseconds(1);
			funcs.senddata(driver, quantity_16, q17);
			LogClass.log("---> Enter 17th Quantity <---");
			LogClass.logExtent("---> Enter 17th Quantity <---");
		}

		if (totalQ >= 18) {
			funcs.waitforseconds(1);
			funcs.clickon_element(driver, add_quantity.get(16));
			LogClass.log("---> Click On Add Quantity Icon <---");
			LogClass.logExtent("---> Click On Add Quantity Icon <---");
			funcs.waitforseconds(1);
			funcs.senddata(driver, quantity_17, q18);
			LogClass.log("---> Enter 18th Quantity <---");
			LogClass.logExtent("---> Enter 18th Quantity <---");
		}

		if (totalQ >= 19) {
			funcs.waitforseconds(1);
			funcs.clickon_element(driver, add_quantity.get(17));
			LogClass.log("---> Click On Add Quantity Icon <---");
			LogClass.logExtent("---> Click On Add Quantity Icon <---");
			funcs.waitforseconds(1);
			funcs.senddata(driver, quantity_18, q19);
			LogClass.log("---> Enter 19th Quantity <---");
			LogClass.logExtent("---> Enter 19th Quantity <---");
		}

		if (totalQ >= 20) {
			funcs.waitforseconds(1);
			funcs.clickon_element(driver, add_quantity.get(18));
			LogClass.log("---> Click On Add Quantity Icon <---");
			LogClass.logExtent("---> Click On Add Quantity Icon <---");
			funcs.waitforseconds(1);
			funcs.senddata(driver, quantity_19, q20);
			LogClass.log("---> Enter 20th Quantity <---");
			LogClass.logExtent("---> Enter 20th Quantity <---");
		}

		act.moveToElement(submit_btn).build().perform();
		funcs.waitforseconds(2);
		submit_btn.click();
		funcs.waitforseconds(2);

		String fileName = "lib/Assembly_number";
		String[] data = { assemblyno };
		funcs.writedataintoTextFile(fileName, data);
		
		ArrayList<String> line = funcs.ReadTextFile(fileName, 1);
		System.out.println("Assembly no read from the text file:"+line.get(0));

		return new CalcuQuote_Login_Verification(driver);
	}

	
	@FindBy(xpath="//span[contains(text(),'Or, if you prefer...')]//..//i[2]")private static WebElement import_bom;
	@FindBy(xpath="//input[@id='upfile']")private static WebElement choose_file;
	@FindBy(xpath="//button[contains(text(),'Import')]")private static WebElement import_bom_after_choose_file;
	
	public static CalcuQuote_Login_Verification ImportBOM() {
		// TODO Auto-generated method stub
		
		funcs.waitforseconds(5);
		funcs.clickon_element(driver, import_bom);
		LogClass.log("---> Click On Import BOM Icon <---");
		LogClass.logExtent("---> Click On Import BOM Icon <---");
		
		funcs.waitforseconds(4);
		String filepath="Resources/35LineBOM.xlsx";
		funcs.uploadthefile(driver, choose_file, 5, filepath);
		funcs.waitforseconds(2);
		LogClass.log("---> File Selected for Import <---");
		LogClass.logExtent("---> File Selected for Import <---");
		
		funcs.waitforseconds(3);
		funcs.clickon_element(driver, import_bom_after_choose_file);
		LogClass.log("---> BOM imported <---");
		LogClass.logExtent("---> BOM imported <---");
		funcs.waitforseconds(10);
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

	
	@FindBy(xpath="//a[@ng-class='AssemblyStatus.Labour']")private static WebElement labor_tab;
	@FindBy(xpath="//select[@id='sourcelabourdriver']")private static WebElement select_labor_activities;
	@FindBy(xpath="//select[@id='sourcelabourdriver']//option")private static List<WebElement> labor_activities_options;
	@FindBy(xpath="//button[@class='btn move btn-default']")private static WebElement arrow_labor_select;
	@FindBy(xpath="//button[@ng-click='next()']")private static WebElement click_next_labor;
	
	public static CalcuQuote_Login_Verification labor_activities() {
		// TODO Auto-generated method stub
		
		funcs.waitforseconds(5);
		funcs.clickon_element(driver, labor_tab);
		LogClass.log("---> Click on Labor Tab <---");
		LogClass.logExtent("---> Click on Labor Tab <---");
		
		funcs.waitforseconds(4);		
		Select options = new Select(select_labor_activities);
		int i = labor_activities_options.size();
		for(int j=0;j<=i;j++) {
			
			if(j>4) break;
			options.selectByIndex(j);			
			LogClass.log("---> Labor Activity Selected <---");
			LogClass.logExtent("---> Labor Activity Selected <---");
			
			funcs.waitforseconds(1);			
			funcs.clickon_element(driver, arrow_labor_select);
			LogClass.log("---> Labor Activity added for the RFQ <---::"+(j+1));
			LogClass.logExtent("---> Labor Activity added for the RFQ <---::"+(j+1));
			
			funcs.waitforseconds(1);
			funcs.clickon_element(driver, click_next_labor);
			LogClass.log("---> Click on Next Button <---");
			LogClass.logExtent("---> Click on Next Button <---");
			
			options.deselectByIndex(j);	
		    funcs.waitforseconds(1);	
		}
		return new CalcuQuote_Login_Verification(driver);
	}

	@FindBy(xpath="//button[@class='btn']")private static WebElement labor_submit_btn;
	public static CalcuQuote_Login_Verification clicksubmitLabor() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(3);
		funcs.clickon_element(driver, labor_submit_btn);
		LogClass.log("---> Click on Labor Submit Button <---");
		LogClass.logExtent("---> Click on Labor Submit Button <---");
		return new CalcuQuote_Login_Verification(driver);
	}

	@FindBy(xpath="//ul//li[4]//a[contains(text(),' Material Costing')]")private static WebElement material_costing_tab;
	@FindBy(xpath="//button[@id='btnUpdatePricing']")private static WebElement update_pricing;
	@FindBy(xpath="//button[text()='Submit']")private static WebElement MC_POPup_submit_btn;
	@FindBy(xpath="//button[@ng-click='stopAutoPricing()']")private static WebElement stopautopricing;
	@FindBy(xpath="//button[@id='btnAutoSelect']")private static WebElement auto_select_btn;
	
	@FindBy(xpath="//a[@uib-tooltip='Pricing Available  ']")private static List<WebElement> pricing_available;
	@FindBy(xpath="//div[@class='ui-grid-cell-contents ng-binding']")private static List<WebElement> select_line;
	@FindBy(xpath="//span[@ng-if='IsMoreThanOneQuantity']")private static WebElement apply_to_all_quantity;
	@FindBy(xpath="//span[@class='fa fa-times close']")private static WebElement close_CQPS;
	@FindBy(xpath="//button[text()='Ok']")private static WebElement ok_btn;
	
	public static CalcuQuote_Login_Verification materialcosting_activities() {
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
		
		if(pricing_available.size()==8) {
			LogClass.log("---> Pricing Available for All line and All Quantity <---");
			LogClass.logExtent("---> Pricing Available for All line and All Quantity <---");
		}
		
		
		LogClass.log("---> Pricing Selection for each line item start <---");
		LogClass.logExtent("---> Pricing Selection for each line item start <---");
		System.out.println("pricing available="+pricing_available.size());
		for(int i=0;i<=pricing_available.size()-2;i=i+2) {
			System.out.println("i="+i);
			funcs.clickon_element(driver,pricing_available.get(i) );
			funcs.waitforseconds(3);
			funcs.clickon_element(driver,select_line.get(1) );
			funcs.clickon_element(driver,apply_to_all_quantity );
			funcs.waitforseconds(8);
			funcs.clickon_element(driver,close_CQPS );
			funcs.waitforseconds(1);
			funcs.clickon_element(driver,ok_btn );
		}
		LogClass.log("---> Pricing Selection for each line item finished <---");
		LogClass.logExtent("---> Pricing Selection for each line item finished <---");
		
		funcs.waitforseconds(10);
		return new CalcuQuote_Login_Verification(driver);
	}
}
