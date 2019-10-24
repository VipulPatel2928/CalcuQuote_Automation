package com.automation.indexpage;
import java.util.ArrayList;
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



public class CalcuQuote_RFQ_Indexpage extends CalcuQuote_AbstractPage {

	public CalcuQuote_RFQ_Indexpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath = "//a[@title='RFQ List']//i")
	private static WebElement rfq_list;
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

	public static CalcuQuote_RFQ_Verification RFQ() {
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

		return new CalcuQuote_RFQ_Verification(driver);
	}

	
}
