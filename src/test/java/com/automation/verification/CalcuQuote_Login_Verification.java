package com.automation.verification;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.automation.index.CalcuQuote_Login_Index;
import com.automation.indexpage.CalcuQuote_Login_Indexpage;
import com.automation.init.CalcuQuote_AbstractPage;
import com.automation.init.CalcuQuote_SeleniumInit;
import com.automation.utility.LogClass;
import com.automation.utility.CalcuQuote_Common;
import com.automation.utility.funcs;
import com.relevantcodes.extentreports.LogStatus;


public class CalcuQuote_Login_Verification extends CalcuQuote_AbstractPage {
	int flag =0;
	public CalcuQuote_Login_Verification(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean homepageverify() {
		// TODO Auto-generated method stub		
		  String urlpass = "calcuquote.com";
		  System.out.println("Url Display on window"+driver.getCurrentUrl()); 
		  if(driver.getCurrentUrl().contains(urlpass)) 
			  return true; 
		  else
			  return false;		 	
	}

	public boolean CalcuQuote_login_verification() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(5);
		WebElement user_icon = driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-user']"));		
		funcs.waitforelementclickable(driver, user_icon);
		LogClass.log("---> Click on User Icon <---");
		LogClass.logExtent("---> Click on User Icon <---");
		
		funcs.waitforseconds(2);
		WebElement profile = driver.findElement(By.xpath("//a[@id='PrfileUpdate']"));
		funcs.waitforelementclickable(driver, profile);		
		LogClass.log("---> Click on User Profile <---");
		LogClass.logExtent("---> Click on Profile <---");
		
		funcs.waitforseconds(5);
		String profilename= CalcuQuote_SeleniumInit.userprofilename;
		System.out.println("User Profile Name:"+CalcuQuote_SeleniumInit.userprofilename);
		WebElement userprofilename = driver.findElement(By.xpath("//strong[text()='"+profilename+"']"));
		
		LogClass.log("---> Checked the User Login Details <---");
		LogClass.logExtent("---> Checked the user Login Details <---");
		
		if(userprofilename.isDisplayed())
			return true;
		else		
		    return false;
	}

	public static void blankusername_psw() {
		// TODO Auto-generated method stub
		WebElement email_id_required = driver.findElement(By.xpath("//span[text()='Email Id is required.']"));
		WebElement psw_required = driver.findElement(By.xpath("//span[text()='Password is required.']"));
		
		if(email_id_required.isDisplayed() && psw_required.isDisplayed()){		
			LogClass.log("---> Verified|Email Id and Password are required|msgs are display <---");
			LogClass.logExtent("---> Verified|Email Id and Password are required|msgs are display <---");
		}
		else {			
			LogClass.log("---> Verified |Email Id or Password is required | msg are NOT displayed <---");
			LogClass.logExtent("---> Verified |Email Id or Password is required | msg are NOT displayed <---");
		}
		
	}

	public static void invalidusername_psw() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(2);
		WebElement double_check_idorpsw = driver.findElement(By.xpath("//div[@id='divErrorMessage']"));
		String msg = double_check_idorpsw.getText();
		if(msg.equals("Please double check your email id and password.")) {			
			LogClass.log("---> Verified | Please double check your email id and password.|msg is displayed <---");
			LogClass.logExtent("---> Verified | Please double check your email id and password.|msg is displayed <---");
		}
		else {
			LogClass.log("---> Verified | Please double check your email id and password.|msg is displayed <---");
			LogClass.logExtent("---> Verified | Please double check your email id and password.|msg is displayed <---");
		}
		
	}

	public boolean CalcuQuote_NRE_calculation_verification() {
		// TODO Auto-generated method stub		
		try {
		WebElement calculation = driver.findElement(By.xpath("//div[text()=' 111.700000']"));
		if(calculation.isDisplayed())
			return true;
		else		
		    return false;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean rfqsubmitted() {
		// TODO Auto-generated method stub
		
		  WebElement rfq_smt_msg = driver.findElement(By.xpath("//div[text()='RFQ submitted successfully.']"));
		  System.out.println("RFQ Submitted Successfully");
		  
		  try {
			  if(rfq_smt_msg.isDisplayed()) 
				  return true; 
			  else 
				  return false;
		  }
		  catch(Exception e) {
			  System.out.println("RFQ Submitted Successfully message missed by the script");
			  return false;
		  }
	}

	public boolean BOM_imported() {
		// TODO Auto-generated method stub
		try {
			WebElement install = driver.findElement(By.xpath("//span[contains(text(),'Install')]"));
			WebElement purchase = driver.findElement(By.xpath("//span[contains(text(),'Purchase')]"));
			if (install.isDisplayed() && purchase.isDisplayed()) {
				return true;
			} else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean laboractivity_added_verification() {
		// TODO Auto-generated method stub
		try {
			List<WebElement> option = driver.findElements(By.xpath("//select[@id='bootstrap-duallistbox-selected-list_']//option"));
			if(option.size()>0)
				return true;
			else 
				return false;
		}
		catch(Exception e) {
			return false;
		}
		
	}
}
