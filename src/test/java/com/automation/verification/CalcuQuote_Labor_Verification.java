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

import com.automation.index.CalcuQuote_Labor_Index;
import com.automation.indexpage.CalcuQuote_Labor_Indexpage;
import com.automation.init.CalcuQuote_AbstractPage;
import com.automation.init.CalcuQuote_SeleniumInit;
import com.automation.utility.LogClass;
import com.automation.utility.CalcuQuote_Common;
import com.automation.utility.funcs;
import com.relevantcodes.extentreports.LogStatus;

public class CalcuQuote_Labor_Verification extends CalcuQuote_AbstractPage{
	public CalcuQuote_Labor_Verification(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
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
