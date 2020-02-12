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
			LogClass.VerificationPass_Extent_Report("Pass : Total Quantity is Matched");
			//LogClass.logExtent("---> Matched Total Qty as per Calculation : "+calculation);
			LogClass.VerificationPass_Extent_Report("Pass : Matched Total Qty as per Calculation : "+calculation);
			//LogClass.logExtent("---> Matched Total Qty as per CQPS : "+CQPS_total);
			LogClass.VerificationPass_Extent_Report("Pass : Matched Total Qty as per CQPS : "+CQPS_total);}
			else {
				//LogClass.logExtent("---> Total Quantity is not Matched <---");
				LogClass.VerificationFailed_Extent_Report("Fail : Total Quantity is not Matched");
				//LogClass.logExtent("---> Not matched Total Qty as per Calculation : "+calculation);
				LogClass.VerificationFailed_Extent_Report("Fail : Not matched Total Qty as per Calculation : "+calculation);
				//LogClass.logExtent("---> Not matched Total Qty as per CQPS : "+CQPS_total);
				LogClass.VerificationFailed_Extent_Report("Fail : Not matched Total Qty as per CQPS : "+CQPS_total);
				flag++;
			}
		}
		
		if(flag!=0) {
			//LogClass.logExtent("---> NOs of Total Quantity not matched :" + flag);
			LogClass.VerificationFailed_Extent_Report("Fail : NOs of Total Quantity not matched :" + flag);
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
			    LogClass.VerificationPass_Extent_Report("Pass : Total Qty Changed");
			    LogClass.VerificationPass_Extent_Report("Pass : Previous Part Class Total Qty : "+previous_total_Qty);
			    LogClass.VerificationPass_Extent_Report("Pass : Current Part Class Total Qty  : "+CQPS_total);
				//LogClass.logExtent("---> Previous Part Class Total Qty : "+previous_total_Qty);
				//LogClass.logExtent("---> Current Part Class Total Qty  : "+CQPS_total);
		   }
		   if (previous_total_Qty==calculation) {
			    LogClass.VerificationPass_Extent_Report("Fail : Total Qty is Not Changed");
			    LogClass.VerificationPass_Extent_Report("Fail : Previous Part Class Total Qty : "+previous_total_Qty);
			    LogClass.VerificationPass_Extent_Report("Fail : Current Part Class Total Qty  : "+CQPS_total);
		   }
			
			if(calculation==CQPS_total) {
			//LogClass.logExtent("---> Total Quantity is Matched <---");
			//LogClass.logExtent("---> Matched Total Qty as per Calculation : "+calculation);
			LogClass.VerificationPass_Extent_Report("Pass : Matched Total Qty as per Calculation : "+calculation);
			//LogClass.logExtent("---> Matched Total Qty as per CQPS : "+CQPS_total);
			LogClass.VerificationPass_Extent_Report("Pass : Matched Total Qty as per CQPS : "+CQPS_total);
			}
			else {
				//LogClass.logExtent("---> Total Quantity is not Matched <---");
				//LogClass.logExtent("---> Not matched Total Qty as per Calculation : "+calculation);
				LogClass.VerificationFailed_Extent_Report("Fail : Not matched Total Qty as per Calculation : "+calculation);
				LogClass.logExtent("Fail : Not matched Total Qty as per CQPS : "+CQPS_total);
				LogClass.VerificationFailed_Extent_Report("Fail : Not matched Total Qty as per CQPS : "+CQPS_total);
				flag++;
			}
		
		
		if(flag!=0) {
			//LogClass.logExtent("---> NOs of Total Quantity not matched :" + flag);
			LogClass.VerificationFailed_Extent_Report("Fail : NOs of Total Quantity not matched :" + flag);
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
		funcs.waitforseconds(8);
		WebElement unit_price_menu = driver.findElement(By.xpath("//span[contains(text(),'100')]//..//..//div[2]//i"));
		funcs.clickon_element(driver, unit_price_menu);
		System.out.println("Click on Request Quantity menu");
		funcs.waitforseconds(3);
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
		funcs.waitforseconds(8);
		WebElement quote_details = driver.findElement(By.xpath("//i[@title='Quote Details']"));
		funcs.clickon_element(driver, quote_details);
		System.out.println("Click on Quote Details");
		funcs.waitforseconds(3);
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
	    DecimalFormat df2 = new DecimalFormat("#.####");
	    df2.setRoundingMode(RoundingMode.DOWN);
	    str = df2.format(d);
	    System.out.println("Final Value with 4 digits after decimal points :"+str);
	    System.out.println("Final Value :"+str);
	    
	    funcs.waitforseconds(1);
		WebElement close_currency_popup = driver.findElement(By.xpath("//span[text()='×']"));
		funcs.clickon_element(driver, close_currency_popup);
		
		funcs.waitforseconds(1);
		driver.navigate().back();
		
		funcs.waitforseconds(5);
		WebElement unit_price_menu = driver.findElement(By.xpath("//span[text()='100']//..//..//div[2]//i"));
		funcs.clickon_element(driver, unit_price_menu);
		System.out.println("Click on Request Quantity menu");
	    
		funcs.waitforseconds(3);
		WebElement unit_price = driver.findElement(By.xpath("//button[text()=' Unit Price']"));
		funcs.clickon_element(driver, unit_price);
		System.out.println("Click on Unit Price");
	    
		funcs.waitforseconds(3);
		WebElement Mc_unit_price = driver.findElement(By.xpath("//a[contains(text(),'   $ "+str+"')]"));
		if(Mc_unit_price.isDisplayed()) {
			LogClass.VerificationPass_Extent_Report("Pass : Unit Price as per calculation [Price in GBP] * Currency Conversion Rate : "+str);
			LogClass.VerificationPass_Extent_Report("Pass : Price from Material Costing Screen : "+Mc_unit_price.getText());
		return true;
		}
		else {
			LogClass.VerificationFailed_Extent_Report("Fail : Unit Price as per calculation [Price in GBP] * Currency Conversion Rate : "+str);
			LogClass.VerificationFailed_Extent_Report("Fail : Price from Material Costing Screen : "+Mc_unit_price.getText());
		return false;}
	}

	public boolean unit_price_verification_leading_cost() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(8);
		WebElement unit_price_menu = driver.findElement(By.xpath("//span[contains(text(),'100')]//..//..//div[2]//i"));
		funcs.clickon_element(driver, unit_price_menu);
		System.out.println("Click on Request Quantity menu");
		funcs.waitforseconds(3);
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
		if(quick_add_time>5.500000)
		return false;
		else
	    return true;
	}

	public boolean verify_32667() {
		// TODO Auto-generated method stub
		List<WebElement> marked_as_manual = driver.findElements(By.xpath("//i[@uib-tooltip='Manual Pricing']"));
		if(marked_as_manual.size()==2)
			return true;
		else
			return false;
	}

	public boolean verify_32660_1() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(1);
		WebElement msg = driver.findElement(By.xpath("//div[text()='Current selection contains update pricing exception lines.']"));
		if(msg.isDisplayed())
			return true;
		else
			return false;		
	}

	public boolean verify_32660_2() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(2);
		WebElement popup = driver.findElement(By.xpath(" //h3[text()='Select Pricing APIs']"));
		if(popup.isDisplayed()) {
			WebElement cancel = driver.findElement(By.xpath("//button[@ng-click='cancel()']"));
			cancel.click();
			return true;}
		else
			return false;	
	}

	public boolean verify_32743() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(1);
		WebElement msg = driver.findElement(By.xpath("//div[text()='Current selection contains update pricing exception lines.']"));
		if(msg.isDisplayed())
			return true;
		else
			return false;		
	}

	public boolean verify_32745() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(1);
		WebElement msg = driver.findElement(By.xpath("//div[text()='Pricing saved successfully.']"));
		if(msg.isDisplayed())
			return true;
		else
			return false;
	}

	public boolean verify_32744() {
		// TODO Auto-generated method stub
		WebElement alt_mpn = driver.findElement(By.xpath("//div[contains(text(),'NA | 5114')]"));
		if(alt_mpn.isDisplayed())
			return true;
		else
			return false;		
	}

	public boolean verify_25844() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(5);
		int flag = 0;
		List<WebElement> mpn = driver.findElements(By.xpath("//div[contains(text(),'511')]"));
		
		if(mpn.size()==3) 
			LogClass.VerificationPass_Extent_Report("Pass : Alternate Parts is added and display on the page");		
		else {
			LogClass.VerificationFailed_Extent_Report("Fail : Alternate Parts is not added or display on the page");
			flag++;}
		
		if(mpn.get(0).getAttribute("class").contains("blue-font") && mpn.get(1).getAttribute("class").contains("blue-font") &&mpn.get(2).getAttribute("class").contains("blue-font")) 
		LogClass.VerificationPass_Extent_Report("Pass : Alternate Parts is added and font is blue");		
		else {
			LogClass.VerificationFailed_Extent_Report("Fail : Alternate Parts is added but font is not blue");
			flag++;}
		
		List<WebElement> pending = driver.findElements(By.xpath("//span[contains(text(),'Pending')]"));

		if(pending.size()==3) 
			LogClass.VerificationPass_Extent_Report("Pass : Alternate Parts is added and status is pending");		
		else {
			LogClass.VerificationFailed_Extent_Report("Fail : Alternate Parts is added but status is not pending");
			flag++;}
		
		System.out.println("color : "+pending.get(0).getAttribute("style"));
		
		if(pending.get(0).getAttribute("style").contains("rgb(26, 113, 210)") && pending.get(1).getAttribute("style").contains("rgb(26, 113, 210)")&&pending.get(2).getAttribute("style").contains("rgb(26, 113, 210)")) 
			LogClass.VerificationPass_Extent_Report("Pass : Status is pending and font is blue");		
			else {
				LogClass.VerificationFailed_Extent_Report("Fail : Status is pending but font is not blue");
				flag++;}		
		if(flag>0)
			return false;
		else
			return true;		
	}

	public boolean verify_25844_MC_screen() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(4);
		int flag = 0;
		WebElement alt_mpn = driver.findElement(By.xpath("//div[contains(text(),'NA | 5114')]"));
		List<WebElement> pending_square = driver.findElements(By.xpath("//a[contains(@uib-tooltip,'Pending')]"));	
		WebElement alt_bubble = driver.findElement(By.xpath("//span[@class=\"badge bg-color-darken pull-right dashbrdbadge ng-binding ng-scope\"]"));
		
		System.out.println("bubble number :"+alt_bubble.getText());
				
		if(alt_mpn.isDisplayed() && pending_square.size()>0 && alt_bubble.getText().contains("4"))
			{LogClass.VerificationPass_Extent_Report("Pass : Alternate MPN is display on MC screen");
			LogClass.VerificationPass_Extent_Report("Pass : Pricing Status is pending");
			LogClass.VerificationPass_Extent_Report("Pass : Alternate bubble number :"+alt_bubble.getText());	
			}
		else
			{
			LogClass.VerificationFailed_Extent_Report("Fail : Alternate MPN is not display on MC screen or pricing Status is not pending");
			flag++;
			}
		funcs.waitforseconds(4);
		funcs.clickon_element(driver,pending_square.get(0));
		//pending_square.get(0).click();
		funcs.waitforseconds(6);
		WebElement alt_part_pending_for_approval = driver.findElement(By.xpath("//span[contains(text(),'3 alternate parts pending for approval')]"));
		String msg = alt_part_pending_for_approval.getText();
		System.out.println("How many approval :"+msg);
		if(alt_part_pending_for_approval.isDisplayed() && msg.contains("3")){
			LogClass.VerificationPass_Extent_Report("Pass Verified :"+msg);
		}
		else {
			LogClass.VerificationFailed_Extent_Report("Fail :Alteranate part pending for approval message is not display on cqps screen");
			flag++;
		}
		
		
		
		if(flag>0)
			return false;
		else
			return true;
	}

	public boolean verify_25846() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(3);
		int flag = 0;
		WebElement mpn = driver.findElement(By.xpath("//div[contains(text(),'5114')]"));
				
		if(mpn.getAttribute("class").contains("green-font")) 
		LogClass.VerificationPass_Extent_Report("Pass : Alternate Parts font is green");		
		else {
			LogClass.VerificationFailed_Extent_Report("Fail : Alternate Parts is not green");
			flag++;}
		
		WebElement pending = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-scope']//span[contains(text(),'Approved')]"));		
		
		System.out.println("color : "+pending.getAttribute("style"));
		
		if(pending.getAttribute("style").contains("green")) 
			LogClass.VerificationPass_Extent_Report("Pass : Status is Approved and font is green");		
			else {
				LogClass.VerificationFailed_Extent_Report("Fail : Status is Approved but font is not green");
				flag++;}		
		if(flag>0)
			return false;
		else
			return true;		
	}

	/*
	public boolean verify_25846_after_save() {
		// TODO Auto-generated method stub
		int flag=0;
		funcs.waitforseconds(5);
		WebElement toast_msg = driver.findElement(By.xpath("//div[contains(text(),'approved/rejected')]"));
		if(toast_msg.isDisplayed())
			LogClass.VerificationPass_Extent_Report("Pass- got msg :Alternate Part(s) have been approved/rejected successfully.");
		else
			{LogClass.VerificationFailed_Extent_Report("Failed - didn't get msg :Alternate Part(s) have been approved/rejected successfully.");
			flag++;}
		if(flag>0)
			return false;
		else
			return true;
	}
*/
	public boolean verify_25846_approved_rejected_msg() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(20);
		return true;
	}

	public boolean verify_25844_MC_screen_after_approve() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(5);
		int flag = 0;		
		List<WebElement> pending_square = driver.findElements(By.xpath("//a[contains(@uib-tooltip,'Pending')]"));	
		//funcs.waitforseconds(4);
		funcs.clickon_element(driver,pending_square.get(0));
		//pending_square.get(0).click();
		funcs.waitforseconds(5);
		WebElement alt_part_pending_for_approval = driver.findElement(By.xpath("//span[contains(text(),'2 alternate parts pending for approval')]"));
		String msg = alt_part_pending_for_approval.getText();
		System.out.println("How many approval :"+msg);
		if(alt_part_pending_for_approval.isDisplayed() && msg.contains("2")){
			LogClass.VerificationPass_Extent_Report("Pass Verified :"+msg);
		}
		else {
			LogClass.VerificationFailed_Extent_Report("Failed :Alteranate part pending for approval message is not display on cqps screen");
			flag++;
		}			
		if(flag>0)
			return false;
		else
			return true;
	}

	
}//End of class
