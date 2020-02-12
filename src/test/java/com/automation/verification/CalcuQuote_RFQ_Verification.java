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

import com.automation.index.CalcuQuote_RFQ_Index;
import com.automation.indexpage.CalcuQuote_Labor_Indexpage;
import com.automation.indexpage.CalcuQuote_RFQ_Indexpage;
import com.automation.init.CalcuQuote_AbstractPage;
import com.automation.init.CalcuQuote_SeleniumInit;
import com.automation.utility.LogClass;
import com.automation.utility.CalcuQuote_Common;
import com.automation.utility.funcs;
import com.relevantcodes.extentreports.LogStatus;

public class CalcuQuote_RFQ_Verification extends CalcuQuote_AbstractPage {
	public CalcuQuote_RFQ_Verification(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
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

	public boolean verify_27074() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(2);
		WebElement msg = driver.findElement(By.xpath("//div[text()='Changing the Quantity will clear the material pricing. Are you sure you want to proceed?']"));
		if(msg.isDisplayed()) {
			LogClass.VerificationPass_Extent_Report("Pass : Pop up for :"+msg.getText());
			return true;
		}
		else
		    return false;
	}

	public boolean verify_27085() {
		// TODO Auto-generated method stub
		int flag = 0;
		
		WebElement first_qty = driver.findElement(By.xpath("//input[@id='quantity_0_0']"));
		
		if(first_qty.getAttribute("value").equalsIgnoreCase(CalcuQuote_RFQ_Indexpage.previous_req_qty)) {
			LogClass.logExtent("Previous Quantity value :"+CalcuQuote_RFQ_Indexpage.previous_req_qty);
			LogClass.VerificationPass_Extent_Report("Pass : Request Quantity Reset to Previous value :"+first_qty.getAttribute("value"));
		}
		else {
			LogClass.logExtent("Previous Quantity value :"+CalcuQuote_RFQ_Indexpage.previous_req_qty);
			LogClass.VerificationFailed_Extent_Report("Fail : Request Quantity Reset to Previous value :"+first_qty.getAttribute("value"));
			flag++;
		}
		
		driver.navigate().back();
		funcs.waitforseconds(2);
		driver.switchTo().alert();
		driver.switchTo().alert().accept();
		funcs.waitforseconds(5);
		List<WebElement> qtys = driver.findElements(By.xpath("//tbody//th"));
		
		int check = 1;
		for(WebElement ele : qtys) {
         System.out.println("Request Qty :"+ele.getText());    
         if(ele.getText().contains(CalcuQuote_RFQ_Indexpage.previous_req_qty)) {
        	 LogClass.VerificationPass_Extent_Report("Pass : Request Quantity is not change on labor screen");
        	 check =0;
         }            
		}
		if(check==1)
			LogClass.VerificationFailed_Extent_Report("Fail : Request Quantity is changed on labor screen");
		
		driver.navigate().back();
		funcs.waitforseconds(5);
		List<WebElement> pricing_available = driver.findElements(By.xpath("//a[contains(@uib-tooltip,'Pricing Available')]"));
		
		if((CalcuQuote_Labor_Indexpage.number_qty*4)==pricing_available.size()){
			LogClass.VerificationPass_Extent_Report("Pass : Prices are not reset on Material Costing Screen");
		}
		else {
			LogClass.VerificationFailed_Extent_Report("Fail : Some of the Prices are reset on Material Costing Screen");
			flag++;
		}
		
		
		if(flag>0)
			return false;
		else
		    return true;
	}

	public boolean verify_27094() {
		// TODO Auto-generated method stub
		int flag = 0;
		WebElement msg = driver.findElement(By.xpath("//div[text()='RFQ submitted successfully.']"));
		
		if(msg.isDisplayed())
			LogClass.VerificationPass_Extent_Report("Pass :"+msg.getText());
		else
			{LogClass.VerificationFailed_Extent_Report("Fail : message is not dispalyed");
			flag++;}
		
		driver.navigate().back();
		funcs.waitforseconds(1);
		driver.navigate().back();
		funcs.waitforseconds(7);
		
		//funcs.scrollBy_horizontal(driver, 5500);
		
		WebElement req_qty = driver.findElement(By.xpath("//span[text()='"+CalcuQuote_RFQ_Indexpage.current_req_qty+"']"));
		
		if(req_qty.isDisplayed()) 
			LogClass.VerificationPass_Extent_Report("Pass : Quantity is displayed on Material Costing Screen");
		else
		{
			LogClass.VerificationFailed_Extent_Report("Fail : Quantity is not displayed on Material Costing Screen");
			flag++;
		}

		List<WebElement> data_unavailable = driver.findElements(By.xpath("//a[contains(@uib-tooltip,'Pricing Data Unavailable')]"));
		if(data_unavailable.size()==8) {
			LogClass.VerificationPass_Extent_Report("Pass : Pricing Data Unavailable :"+data_unavailable.size());
		}
		else
			{LogClass.VerificationFailed_Extent_Report("Fail : Pricing Data Unavailable"+data_unavailable.size());
		flag++;}
		
		
        if(flag>0)
        	return false;
        else
        	return true;
		
	}

	public boolean verify_27084() {
		// TODO Auto-generated method stub
		int flag = 0;
        WebElement msg = driver.findElement(By.xpath("//div[text()='RFQ submitted successfully.']"));
		
		if(msg.isDisplayed())
			LogClass.VerificationPass_Extent_Report("Pass :"+msg.getText());
		else
			{LogClass.VerificationFailed_Extent_Report("Fail : message is not dispalyed");
			flag++;}
		
		driver.navigate().back();		
		funcs.waitforseconds(1);
		driver.navigate().back();
		funcs.waitforseconds(7);
		
		//funcs.scrollBy_horizontal(driver, 5500);
		
        WebElement req_qty = driver.findElement(By.xpath("//span[text()='"+CalcuQuote_RFQ_Indexpage.current_req_qty+"']"));
		
		if(req_qty.isDisplayed()) 
			LogClass.VerificationPass_Extent_Report("Pass : Quantity is displayed on Material Costing Screen");
		else
		{
			LogClass.VerificationFailed_Extent_Report("Fail : Quantity is not displayed on Material Costing Screen");
			flag++;
		}

		List<WebElement> data_unavailable = driver.findElements(By.xpath("//a[contains(@uib-tooltip,'Pricing Data Unavailable')]"));
		if(data_unavailable.size()==4) {
			LogClass.VerificationPass_Extent_Report("Pass : Pricing Data Unavailable :"+data_unavailable.size());
		}
		else
			{LogClass.VerificationFailed_Extent_Report("Fail : Pricing Data Unavailable"+data_unavailable.size());
		flag++;}
		
		if(flag>0)
			return false;
		else
			return true;
		
	}
}//End of class
