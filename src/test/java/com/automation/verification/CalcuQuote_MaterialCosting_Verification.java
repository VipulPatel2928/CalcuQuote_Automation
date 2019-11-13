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

import com.automation.index.CalcuQuote_Material_Costing_Index;
import com.automation.indexpage.CalcuQuote_Material_Costing_Indexpage;
import com.automation.indexpage.CalcuQuote_RFQ_Indexpage;
import com.automation.init.CalcuQuote_AbstractPage;
import com.automation.init.CalcuQuote_SeleniumInit;
import com.automation.utility.LogClass;
import com.automation.utility.CalcuQuote_Common;
import com.automation.utility.CalcuQuote_TestData;
import com.automation.utility.funcs;
import com.relevantcodes.extentreports.LogStatus;
public class CalcuQuote_MaterialCosting_Verification extends CalcuQuote_AbstractPage {
	public CalcuQuote_MaterialCosting_Verification(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean price_update_and_auto_selected_verification() {
		// TODO Auto-generated method stub
		
		WebElement percentage = driver.findElement(By.xpath("//span[text()='100.00 %']"));
		Actions act = new Actions(driver);
		act.moveToElement(percentage).build().perform();		
		 try {
			if(percentage.isDisplayed())
				return true;
			else 
				return false;
		 }
		catch(Exception e){
			return false;
		}
		 
		//List<WebElement> noofprices = driver.findElements(By.xpath("//a[contains(text(),'$')]"));
		//String totalQuantity = CalcuQuote_TestData.numberofquantity(7);
		//int totalQ = Integer.parseInt(totalQuantity);
		//int prices = totalQ*4;
		//if(noofprices.size()==prices) 
		//return true;
		//else
		//return false;
		
		
	}

	public boolean MC_submission() {
		//WebElement MC_submission_msg = driver.findElement(By.xpath("//button[text()='OK']"));
			return true;
		// TODO Auto-generated method stub
	}
}
