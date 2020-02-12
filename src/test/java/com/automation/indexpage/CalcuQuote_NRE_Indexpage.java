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


public class CalcuQuote_NRE_Indexpage extends CalcuQuote_AbstractPage{
	public CalcuQuote_NRE_Indexpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
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
	public static CalcuQuote_NRE_Verification add_NRE() {
		// TODO Auto-generated method stub		
		
		funcs.waitforseconds(8);
		funcs.clickon_element(driver, NRE);
		LogClass.logExtent("==> Click on NRE Tab.");		
		
		funcs.waitforseconds(4);
		funcs.clickon_element(driver, add_standard);
		LogClass.logExtent("==> Click Add Standard Tab.");
		funcs.waitforseconds(3);

		funcs.clickon_element(driver, first_click.get(0));
		System.out.println("==> Click 1");
		funcs.waitforseconds(4);

		Select value = new Select(NRE_value);
		value.selectByIndex(1);

		funcs.waitforseconds(5);

		try {

			if (first_click.get(0).isDisplayed()) {
				System.out.println("Value is not assigned to NRE");
				funcs.clickon_element(driver, first_click.get(0));
				funcs.waitforseconds(1);
				Actions act = new Actions(driver);
				act.doubleClick(first_click.get(0)).build().perform();
				System.out.println("==> Click for the value");
				enter_value_4_NRE.sendKeys("10.20");
				System.out.println("==> Enter Value of NRE");
				LogClass.logExtent("==> Enter Value of NRE");
			}
		} catch (Exception e) {

			System.out.println("NRE has the assigned value and lets change the value");
			funcs.clickon_element(driver, dollar_value.get(0));
			Actions act = new Actions(driver);
			act.doubleClick(dollar_double_click).build().perform();
			enter_value_4_NRE.sendKeys("10.20");
			LogClass.logExtent("==> Enter Value of NRE");

		}

		funcs.waitforseconds(7);
		funcs.clickon_element(driver, add_standard);
		LogClass.logExtent("==> Click Add Standard Tab.");

		funcs.waitforseconds(3);
		funcs.clickon_element(driver, first_click.get(0));
		System.out.println("==> Click 1");

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
				System.out.println("==> Click for the value");
				enter_value_4_NRE.sendKeys("100.25");
				LogClass.logExtent("==> Enter Value of NRE");
			}
		} catch (Exception e) {

			System.out.println("NRE has the assigned value and lets change the value");
			funcs.clickon_element(driver, dollar_value.get(1));
			Actions act = new Actions(driver);
			act.doubleClick(dollar_double_click).build().perform();
			enter_value_4_NRE.sendKeys("100.25");
			LogClass.logExtent("==> Enter Value of NRE");

		}

		funcs.waitforseconds(7);
		funcs.clickon_element(driver, add_standard);
		LogClass.logExtent("==> Click Add Standard Tab.");

		funcs.waitforseconds(3);
		funcs.clickon_element(driver, first_click.get(0));
		System.out.println("==> Click 1");

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
				LogClass.logExtent("==> Enter Value of NRE");
			}
		} catch (Exception e) {

			System.out.println("NRE has the assigned value and lets change the value");
			funcs.clickon_element(driver, dollar_value.get(2));

			Actions act = new Actions(driver);
			act.doubleClick(dollar_double_click).build().perform();
			enter_value_4_NRE.sendKeys("1.25");
			LogClass.logExtent("==> Enter Value of NRE");

		}

		funcs.waitforseconds(1);
		return new CalcuQuote_NRE_Verification(driver);
	}

	
	
	@FindBy(xpath="//button[@title='Submit']")private static WebElement nre_submit_btn;
	public static CalcuQuote_NRE_Verification clicksubmitnre() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(5);
		funcs.clickon_element(driver,nre_submit_btn );
		LogClass.logExtent("==> Click on NRE Submit button");
		funcs.waitforseconds(3);
		return new CalcuQuote_NRE_Verification(driver);
	}

	public static CalcuQuote_NRE_Verification create_NRE() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(6);
		funcs.clickon_element(driver, NRE);
		LogClass.logExtent("==> Click on NRE Tab.");
		
		funcs.clickon_element(driver, create_NRE);
		LogClass.logExtent("==> Click create NRE Tab.");

		String NRE_name_value = "Automation_" + CalcuQuote_TestData.randomAlpha(4);
		CalcuQuote_NRE_Verification.nre_name =NRE_name_value;

		funcs.waitforseconds(4);
		funcs.senddata(driver, NRE_name, NRE_name_value);
		LogClass.logExtent("==> Enter NRE Name");

		//funcs.waitforseconds(2);
		Select charge = new Select(charge_type);
		charge.selectByIndex(1);
		LogClass.logExtent("==> Select the Charge type :Standard");

		//funcs.waitforseconds(2);
		funcs.senddata(driver, default_value, "10");
		LogClass.logExtent("==> Enter Default Value");

		//funcs.waitforseconds(2);
		funcs.clickon_element(driver, save_btn);
		LogClass.logExtent("==> Click SAVE button");
		
		funcs.waitforseconds(1);

		return new CalcuQuote_NRE_Verification(driver);
	}
}
