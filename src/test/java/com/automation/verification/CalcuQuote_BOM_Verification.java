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

import com.automation.index.CalcuQuote_BOM_Index;
import com.automation.indexpage.CalcuQuote_BOM_Indexpage;
import com.automation.init.CalcuQuote_AbstractPage;
import com.automation.init.CalcuQuote_SeleniumInit;
import com.automation.utility.LogClass;
import com.automation.utility.CalcuQuote_Common;
import com.automation.utility.funcs;
import com.relevantcodes.extentreports.LogStatus;

public class CalcuQuote_BOM_Verification extends CalcuQuote_AbstractPage {
	public CalcuQuote_BOM_Verification(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
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

	public boolean BOM_submit() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(4);
		WebElement bom_submit_msg = driver.findElement(By.xpath("//div[contains(text(),'Submit BOM is in progress. Please do not change anything until we notify you \"BOM is Submitted successfully\".')]"));
		if (bom_submit_msg.isDisplayed()) {		
			WebElement ok_btn = driver.findElement(By.xpath("//button[text()='OK']"));
			funcs.jsClick(driver, ok_btn);
			return true;
		}
		else
		return false;
	}
}
