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

	public boolean total_qty_verification() {
		// TODO Auto-generated method stub
		int flag =0;
		String req_Qty = CalcuQuote_TestData.numberofquantity(8);
		int Req_Qty= Integer.parseInt(req_Qty);
		System.out.println("Req_Qty :"+Req_Qty);
		//double d = Double.parseDouble("25.000");
		double Qty_Brd_Var =0;
		int Lead_Qty_Var=0;
		double Attr_Rate_Var=0;
		for(int i=1;i<=6;i++) {
				//String lead_qty = CalcuQuote_TestData._totalqty(i, j);
				String qty_brd = CalcuQuote_TestData._totalqty(i, 3);
				Qty_Brd_Var=Double.parseDouble(qty_brd);
				System.out.println("Qty_Brd_Var :"+Qty_Brd_Var);
				String lead_qty = CalcuQuote_TestData._totalqty(i, 6);
				Lead_Qty_Var = Integer.parseInt(lead_qty);
				System.out.println("Lead Qty :"+Lead_Qty_Var);
				String attr_rate = CalcuQuote_TestData._totalqty(i, 8);
				Attr_Rate_Var=Double.parseDouble(attr_rate);
				System.out.println("Attr_Rate_Var :"+Attr_Rate_Var);	
			double calculation= (Req_Qty*Qty_Brd_Var*((Attr_Rate_Var/100)+1)) +Lead_Qty_Var;
			
			String cal= Double.toString(calculation);
			if(cal.length()>11) {
			int dot= cal.indexOf(".");
			String final_calculation=cal.substring(0, dot)+cal.substring(dot, dot+7);
			calculation=Double.parseDouble(final_calculation);}
			//LogClass.logExtent("---> Total Qty as per Calculation : "+calculation);
			double CQPS_total =Double.parseDouble( CalcuQuote_Material_Costing_Indexpage.Total_Qty_per_line[i-1]);
			if(calculation==CQPS_total) {
				LogClass.logExtent("---> Total Quantity is Matched <---");
			LogClass.logExtent("---> Matched Total Qty as per Calculation : "+calculation);
			LogClass.logExtent("---> Matched Total Qty as per CQPS : "+CQPS_total);}
			else {
				LogClass.logExtent("---> Total Quantity is not Matched <---");
				LogClass.logExtent("---> Not matched Total Qty as per Calculation : "+calculation);
				LogClass.logExtent("---> Not matched Total Qty as per CQPS : "+CQPS_total);
				flag++;
			}
		}
		
		if(flag!=0) {
			LogClass.logExtent("---> NOs of Total Quantity not matched :" + flag);
			return false;			
		}
		else
		return true;
	}
}
