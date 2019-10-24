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

public class CalcuQuote_BidCQ_Indexpage extends CalcuQuote_AbstractPage {
	public CalcuQuote_BidCQ_Indexpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
}
