package com.automation.verification;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
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
import com.automation.indexpage.CalcuQuote_BOM_Indexpage;
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
	
	public static String qty_brd  =null;
	public static String lead_qty=null;
	public static String attr_rate=null;
	public static String supplier_validation;
	public static String unit_price_validation;
	public static double quick_add_time = 0.0;
	
	public static double previous_total_Qty = 0;
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
		double temp_calculation=0;
		String req_Qty = CalcuQuote_TestData.numberofquantity(8);
		int Req_Qty= Integer.parseInt(req_Qty);
		System.out.println("Req_Qty :"+Req_Qty);
		
		double Qty_Brd_Var =0;
		int Lead_Qty_Var=0;
		double Attr_Rate_Var=0;
		
		for(int i=1;i<=11;i++) {
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
			
			DecimalFormat df = new DecimalFormat("#.######");
			df.setRoundingMode(RoundingMode.DOWN);
			String calculation_str=df.format(calculation);
			calculation=Double.parseDouble(calculation_str);
			double CQPS_total=0;
			//LogClass.logExtent("---> Total Qty as per Calculation : "+calculation);
			if(i<7) {
			CQPS_total =Double.parseDouble( CalcuQuote_Material_Costing_Indexpage.Total_Qty_per_line[i-1]);
			}
			if(i==7) {
				temp_calculation = calculation;
				System.out.println("Temp calculation ===> Consolidate Line 7 ===>::"+temp_calculation);
				continue;
			}
			
			if(i==9 || i==10) {
			
					temp_calculation = temp_calculation + calculation;
					System.out.println("Temp calculation ===> Consolidate Line 9 and 10 ===>::"+temp_calculation);
					continue;	
			}
			System.out.println("i ="+i);
			
			if(i==8) {
				calculation = temp_calculation + calculation;
				temp_calculation = 0;
				CQPS_total =Double.parseDouble( CalcuQuote_Material_Costing_Indexpage.Total_Qty_per_line[6]);
				System.out.println("calculation ===> Consolidate Line 7 and 8 :"+calculation);
				System.out.println("CQPS total ===> Consolidate Line 7 and 8 :"+CQPS_total);
			}
	
			if(i==11) {
				calculation = temp_calculation + calculation;
				temp_calculation = 0;
				CQPS_total =Double.parseDouble( CalcuQuote_Material_Costing_Indexpage.Total_Qty_per_line[7]);
				System.out.println("calculation ===> Consolidate Line 9 ,10 and 11 :"+calculation);
				System.out.println("CQPS total ===> Consolidate Line 9 ,10 and 11 :"+CQPS_total);
			}
			
			if(calculation==CQPS_total) {
			//LogClass.logExtent("---> Total Quantity is Matched <---");
			LogClass.VerificationPass_Extent_Report("---> Total Quantity is Matched <---");
			//LogClass.logExtent("---> Matched Total Qty as per Calculation : "+calculation);
			LogClass.VerificationPass_Extent_Report("---> Matched Total Qty as per Calculation : "+calculation);
			//LogClass.logExtent("---> Matched Total Qty as per CQPS : "+CQPS_total);
			LogClass.VerificationPass_Extent_Report("---> Matched Total Qty as per CQPS : "+CQPS_total);}
			else {
				//LogClass.logExtent("---> Total Quantity is not Matched <---");
				LogClass.VerificationFailed_Extent_Report("---> Total Quantity is not Matched <---");
				//LogClass.logExtent("---> Not matched Total Qty as per Calculation : "+calculation);
				LogClass.VerificationFailed_Extent_Report("---> Not matched Total Qty as per Calculation : "+calculation);
				//LogClass.logExtent("---> Not matched Total Qty as per CQPS : "+CQPS_total);
				LogClass.VerificationFailed_Extent_Report("---> Not matched Total Qty as per CQPS : "+CQPS_total);
				flag++;
			}
		}
		
		if(flag!=0) {
			//LogClass.logExtent("---> NOs of Total Quantity not matched :" + flag);
			LogClass.VerificationFailed_Extent_Report("---> NOs of Total Quantity not matched :" + flag);
			return false;			
		}
		else
		return true;
	}

	public boolean SMT_total_qty_verification() {
		// TODO Auto-generated method stub
		int flag =0;
		double temp_calculation=0;
		String req_Qty = CalcuQuote_TestData.numberofquantity(8);
		int Req_Qty= Integer.parseInt(req_Qty);
		System.out.println("Req_Qty :"+Req_Qty);
		//double d = Double.parseDouble("25.000");
		
		double Qty_Brd_Var =0;
		int Lead_Qty_Var=0;
		double Attr_Rate_Var=0;
		
				//String lead_qty = CalcuQuote_TestData._totalqty(i, j);
				//String qty_brd = CalcuQuote_TestData._totalqty(1, 3);
				Qty_Brd_Var=Double.parseDouble(qty_brd);
				System.out.println("Qty_Brd_Var :"+Qty_Brd_Var);
				//String lead_qty = CalcuQuote_TestData._totalqty(1, 6);
				Lead_Qty_Var = Integer.parseInt(lead_qty);
				System.out.println("Lead Qty :"+Lead_Qty_Var);
				//String attr_rate = CalcuQuote_TestData._totalqty(1, 8);
				Attr_Rate_Var=Double.parseDouble(attr_rate);
				System.out.println("Attr_Rate_Var :"+Attr_Rate_Var);	
			double calculation= (Req_Qty*Qty_Brd_Var*((Attr_Rate_Var/100)+1)) +Lead_Qty_Var;
			
			DecimalFormat df = new DecimalFormat("#.######");
			df.setRoundingMode(RoundingMode.DOWN);
			String calculation_str=df.format(calculation);
			calculation=Double.parseDouble(calculation_str);
			double CQPS_total=0;
			//LogClass.logExtent("---> Total Qty as per Calculation : "+calculation);
			
			CQPS_total =Double.parseDouble( CalcuQuote_Material_Costing_Indexpage.Total_Qty_per_line[0]);
			
		   if (previous_total_Qty > 0 && previous_total_Qty!=calculation) {			  
			    LogClass.VerificationPass_Extent_Report("---> Total Qty Changed <---");
			    LogClass.VerificationPass_Extent_Report("---> Previous Part Class Total Qty : "+previous_total_Qty);
			    LogClass.VerificationPass_Extent_Report("---> Current Part Class Total Qty  : "+CQPS_total);
				//LogClass.logExtent("---> Previous Part Class Total Qty : "+previous_total_Qty);
				//LogClass.logExtent("---> Current Part Class Total Qty  : "+CQPS_total);
		   }
		   if (previous_total_Qty==calculation) {
			    LogClass.VerificationPass_Extent_Report("---> Total Qty is Not Changed <---");
			    LogClass.VerificationPass_Extent_Report("---> Previous Part Class Total Qty : "+previous_total_Qty);
			    LogClass.VerificationPass_Extent_Report("---> Current Part Class Total Qty  : "+CQPS_total);
		   }
			
			if(calculation==CQPS_total) {
			//LogClass.logExtent("---> Total Quantity is Matched <---");
			//LogClass.logExtent("---> Matched Total Qty as per Calculation : "+calculation);
			LogClass.VerificationPass_Extent_Report("---> Matched Total Qty as per Calculation : "+calculation);
			//LogClass.logExtent("---> Matched Total Qty as per CQPS : "+CQPS_total);
			LogClass.VerificationPass_Extent_Report("---> Matched Total Qty as per CQPS : "+CQPS_total);
			}
			else {
				//LogClass.logExtent("---> Total Quantity is not Matched <---");
				//LogClass.logExtent("---> Not matched Total Qty as per Calculation : "+calculation);
				LogClass.VerificationFailed_Extent_Report("---> Not matched Total Qty as per Calculation : "+calculation);
				LogClass.logExtent("---> Not matched Total Qty as per CQPS : "+CQPS_total);
				LogClass.VerificationFailed_Extent_Report("---> Not matched Total Qty as per CQPS : "+CQPS_total);
				flag++;
			}
		
		
		if(flag!=0) {
			//LogClass.logExtent("---> NOs of Total Quantity not matched :" + flag);
			LogClass.VerificationFailed_Extent_Report("---> NOs of Total Quantity not matched :" + flag);
			return false;			
		}
		else
		return true;
	}

	public boolean price_clear_Verification() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(6);
		WebElement pricing_Unavailable = driver.findElement(By.xpath("//a[@uib-tooltip='Pricing Data Unavailable  ']"));
		if(pricing_Unavailable.isDisplayed())
			return true;
		else 
			return false;
	}

	public boolean price_available_Verification() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(6);
		WebElement pricing_available = driver.findElement(By.xpath("//a[@uib-tooltip='Pricing Available  ']"));
		if(pricing_available.isDisplayed())
			return true;
		else 
			return false;
	}

	public boolean unit_price_verification() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(5);
		WebElement unit_price_menu = driver.findElement(By.xpath("//span[contains(text(),'100')]//..//..//div[2]//i"));
		funcs.clickon_element(driver, unit_price_menu);
		System.out.println("Click on Request Quantity menu");
		funcs.waitforseconds(2);
		WebElement unit_price = driver.findElement(By.xpath("//button[text()=' Unit Price']"));
		funcs.clickon_element(driver, unit_price);
		System.out.println("Click on Unit Price");
		funcs.waitforseconds(3);
		WebElement Mc_unit_price = driver.findElement(By.xpath("//a[contains(text(),'"+CalcuQuote_Material_Costing_Indexpage.unit_price_var+"')]"));
		System.out.println(Mc_unit_price.getText());
		if(Mc_unit_price.getText().equalsIgnoreCase("$ "+CalcuQuote_Material_Costing_Indexpage.unit_price_var))
		return true;
		else
		return false;
	}

	public boolean gbp_unit_price_verification() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(5);
		WebElement quote_details = driver.findElement(By.xpath("//i[@title='Quote Details']"));
		funcs.clickon_element(driver, quote_details);
		System.out.println("Click on Quote Details");
		funcs.waitforseconds(2);
		WebElement Goto_RFQ_btn = driver.findElement(By.xpath("//button[@title='Goto RFQ']"));
		funcs.clickon_element(driver, Goto_RFQ_btn);
		System.out.println("Click on Go to RFQ button");
		funcs.waitforseconds(4);
		WebElement currency = driver.findElement(By.xpath("//span[@ng-click='openCurrencyConversionRatesPopup()']"));
		funcs.clickon_element(driver, currency);
		List<WebElement> header = driver.findElements(By.xpath("//thead//tr//th"));
		int i =0;
		for(WebElement e : header) {
			if(e.getText().equalsIgnoreCase("GBP"))
				break;
			i++;
		}
		
		List<WebElement> currency_value = driver.findElements(By.xpath("//tbody//tr//td//label"));
		System.out.println("GBP to USD Conversion"+currency_value.get(i-1).getText());
		//System.out.println("Original Value 0.765571");
		
		String str = currency_value.get(i-1).getText();
		Double d = Double.parseDouble(str);
		d=1/d;
		d= d*0.888888;
		System.out.println("Price after calculation :"+d);
		DecimalFormat df = new DecimalFormat("#.######");
		DecimalFormat df1 = new DecimalFormat("#.#######");
		df.setRoundingMode(RoundingMode.DOWN);
		df1.setRoundingMode(RoundingMode.DOWN);
	    str = df.format(d);
	    String str1 = df1.format(d);
	    char c = str1.charAt(str1.length()-1);
	    int sthdigit = Integer.parseInt(String.valueOf(c));
	    System.out.println("Character at 7 places after decimal point: "+c);
	    d = Double.parseDouble(str);
	    System.out.println("Price after rounding calculation :"+d);
	    double t = 0.0000001;
	    if(sthdigit>=5) {
	    	d =  d + t;
	    	d = d + 0.000001;
	    System.out.println("Price after rounding calculation and adding 0.000001 if 7th digit greater then or equal 5 :"+d);
	    } 
	    str = df.format(d);
	    
	    System.out.println("Final Value :"+str);
	    
	    funcs.waitforseconds(1);
		WebElement close_currency_popup = driver.findElement(By.xpath("//span[text()='×']"));
		funcs.clickon_element(driver, close_currency_popup);
		
		funcs.waitforseconds(1);
		driver.navigate().back();
		
		WebElement unit_price_menu = driver.findElement(By.xpath("//span[text()='100']//..//..//div[2]//i"));
		funcs.clickon_element(driver, unit_price_menu);
		System.out.println("Click on Request Quantity menu");
	    
		funcs.waitforseconds(2);
		WebElement unit_price = driver.findElement(By.xpath("//button[text()=' Unit Price']"));
		funcs.clickon_element(driver, unit_price);
		System.out.println("Click on Unit Price");
	    
		funcs.waitforseconds(3);
		WebElement Mc_unit_price = driver.findElement(By.xpath("//a[contains(text(),'   $ "+str+"')]"));
		if(Mc_unit_price.isDisplayed()) {
			LogClass.VerificationPass_Extent_Report("Unit Price as per calculation [Price in GBP] * Currency Conversion Rate : "+str);
			LogClass.VerificationPass_Extent_Report("Price from Material Costing Screen : "+Mc_unit_price.getText());
		return true;
		}
		else {
			LogClass.VerificationFailed_Extent_Report("Unit Price as per calculation [Price in GBP] * Currency Conversion Rate : "+str);
			LogClass.VerificationFailed_Extent_Report("Price from Material Costing Screen : "+Mc_unit_price.getText());
		return false;}
	}

	public boolean unit_price_verification_leading_cost() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(5);
		WebElement unit_price_menu = driver.findElement(By.xpath("//span[contains(text(),'100')]//..//..//div[2]//i"));
		funcs.clickon_element(driver, unit_price_menu);
		System.out.println("Click on Request Quantity menu");
		funcs.waitforseconds(2);
		WebElement unit_price = driver.findElement(By.xpath("//button[text()=' Unit Price']"));
		funcs.clickon_element(driver, unit_price);
		System.out.println("Click on Unit Price");
		funcs.waitforseconds(3);
		List<WebElement> Mc_unit_price = driver.findElements(By.xpath("//span[contains(@uib-tooltip,\"Pricing Selected\")]//a//span"));
		System.out.println(Mc_unit_price.get(0).getText());
		if(Mc_unit_price.get(0).getText().equalsIgnoreCase("$ "+CalcuQuote_Material_Costing_Indexpage.unit_price_var))
		return true;
		else
		return false;
	}

	public boolean time_verification() {
		// TODO Auto-generated method stub
		if(quick_add_time>5.000000)
		return false;
		else
	    return true;
	}

	
}
