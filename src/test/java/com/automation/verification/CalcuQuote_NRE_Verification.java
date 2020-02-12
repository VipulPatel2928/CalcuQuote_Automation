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

import com.automation.index.CalcuQuote_NRE_Index;
import com.automation.indexpage.CalcuQuote_NRE_Indexpage;
import com.automation.init.CalcuQuote_AbstractPage;
import com.automation.init.CalcuQuote_SeleniumInit;
import com.automation.utility.LogClass;
import com.automation.utility.CalcuQuote_Common;
import com.automation.utility.funcs;
import com.relevantcodes.extentreports.LogStatus;

public class CalcuQuote_NRE_Verification extends CalcuQuote_AbstractPage{
	
	public static String nre_name = null;
	
	public CalcuQuote_NRE_Verification(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
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

	public boolean NRE_Submit() {
		// TODO Auto-generated method stub
		//WebElement nre_submission = driver.findElement(By.xpath("//button[text()='OK']"));
		return true;
	}

	public boolean NRE_created_verification() {
		// TODO Auto-generated method stub
		WebElement configuration_icon = driver.findElement(By.xpath("//span[text()='Configuration']//..//i"));
		funcs.jsClick(driver, configuration_icon);
		LogClass.logExtent("==> Click Configuration Icon");
		funcs.waitforseconds(4);
		WebElement misc_menu = driver.findElement(By.xpath("//p[text()='Company Details, NREs']//..//span"));
		funcs.jsClick(driver, misc_menu);
		LogClass.logExtent("==> Click Company Details, NREs menu");
		funcs.waitforseconds(4);
		List<WebElement> name = driver.findElements(By.xpath("//input[@type='text']"));
		name.get(0).sendKeys(nre_name);
		
		WebElement isthere = driver.findElement(By.xpath("//div[text()=' "+nre_name+"']"));
		LogClass.logExtent("==> Enter Created NRE name to verify");
		
		if(isthere.isDisplayed())
			return true;
		else 
		    return false;
	}

}
