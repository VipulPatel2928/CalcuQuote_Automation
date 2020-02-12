package com.automation.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Reporter;

import com.automation.index.CalcuQuote_Login_Index;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.LogStatus;

public class LogClass {

	// Function for the Test Case
	public static void logcase(String msg) {
		System.out.println(msg);
		Reporter.log("<strong><h1 style=\"color:DarkViolet;font-size:13px;\"> " + msg + "</h1> </strong>");
	}

	// Function for the Steps in the Script
	public static void logstep(String msg) {
		System.out.println(msg);
		Reporter.log("<br><strong><font color=\"blue\">" + msg + "</font></strong></br>");
	}

	// Function for the Verification Steps in the Script
	public static void logveri(String msg) {
		System.out.println(msg);
		Reporter.log("<strong><h1 style=\"color:saddlebrown;font-size:11px;\"> " + msg + "</h1> </strong>");
	}

	// Function for the Successful verification
	public static void AssertPassed() {
		System.out.println();
		Reporter.log("<strong> <h3 style=\"color:DarkGreen\">  &#10004; <i>  SUCCESSFUL </i></h3> </strong> ");
	}

	// Function for the UnSuccessful verification
	public static void AssertFailed() {
		System.out.println();
		Reporter.log("<strong> <h3 style=\"color:DarkRed\"> &#10008; <i> UNSUCCESSFUL </i></h3> </strong>");
	}
    // Function for the log status
	public static void logStatus(String Status) {
        System.out.println(Status);
		if (Status.equalsIgnoreCase("Pass")) {
			log("<hr size='15px' noshade color='green'>");
		} else if (Status.equalsIgnoreCase("Fail")) {
			log("<hr size='15px' noshade color='red'>");
		}
	}
	
	// Function to take a ScreenShot
	public static void makeScreenshot(WebDriver driver, String screenshotName) {
		WebDriver augmentedDriver = new Augmenter().augment(driver);
		/* Take a screenshot */
		File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		String nameWithExtention = screenshotName + ".png";
		/* Copy screenshot to specific folder */
		try {

			//String reportFolder = "C:/Users/User/eclipse-workspace/RentCount_UK/test-output" + File.separator;
			String reportFolder = "C:\\Users\\admin\\eclipse-workspace\\CalcuQuote\\test-output" + File.separator;
			
			
			String screenshotsFolder = "screenshots";
			File screenshotFolder = new File(reportFolder + screenshotsFolder);
			if (!screenshotFolder.getAbsoluteFile().exists()) {
				screenshotFolder.mkdir();
			}
			FileUtils.copyFile(screenshot,
					new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile());
		} catch (IOException e) {
			log("Failed to capture screenshot: " + e.getMessage());//normal reports
			CalcuQuote_Login_Index.extent_report_log.log(LogStatus.FAIL, "Failed to capture screenshot: " + e.getMessage());//for Extent Report
			
		}
		
		Reporter.log("<br><b>Please look to the screenshot - </b>");
		log(getScreenshotLink(nameWithExtention, nameWithExtention)); // add screenshot link to the report
		
		CalcuQuote_Login_Index.extent_report_log.log(LogStatus.FAIL,"<b>Please look to the screenshot - </b>");
		CalcuQuote_Login_Index.extent_report_log.log(LogStatus.FAIL,getScreenshotLink_extent(nameWithExtention, nameWithExtention));//for Extent Report
	}
	// Function to Log given message to Reporter output. @param msg Message/Log to
	// be reported.

	public static void log(String msg) {
		System.out.println(msg);
		Reporter.log("</br>&nbsp;&nbsp;&nbsp;&nbsp;" + msg + "</br>");
	}

	// Function to Generates link for TestNG report.@param screenshot_name
	// Screenshot name.@param link_text@return Formatted link for TestNG report.
	public static String getScreenshotLink(String screenshot_name, String link_text) {
		log("<br><Strong><font color=#FF0000>--Failed</font></strong>");
		return "<a href='screenshots/" + screenshot_name + "' target='_new'>" + link_text + "</a>";
	}
	//screenshot link for the extent report.
	public static String getScreenshotLink_extent(String screenshot_name, String link_text) {
		//log("<br><Strong><font color=#FF0000>--Failed</font></strong>");
		return "<a href='" + screenshot_name + "' target='_new'>" + link_text + "</a>";
	}
	//function to put log in the extent report
	
	public static void logExtent(String msg) {
		System.out.println(msg);
	CalcuQuote_Login_Index.extent_report_log.log(LogStatus.INFO, msg);
	}
	
	
	
	// Function for the UnSuccessful verification
		public static void AssertFailed_Extent_Report() {
			//System.out.println();
			//Reporter.log("<strong> <h3 style=\"color:DarkRed\"> &#10008; <i> UNSUCCESSFUL </i></h3> </strong>");
			CalcuQuote_Login_Index.extent_report_log.log(LogStatus.FAIL, "<strong> <p style=\"color:DarkRed\"> &#10008; <b><i> UNSUCCESSFUL </i><b></p> </strong>");
		}
		
		public static void VerificationFailed_Extent_Report(String msg) {
			//System.out.println();
			//Reporter.log("<strong> <h3 style=\"color:DarkRed\"> &#10008; <i> UNSUCCESSFUL </i></h3> </strong>");
			CalcuQuote_Login_Index.extent_report_log.log(LogStatus.INFO, "<strong> <p style=\"color:DarkRed\"> &#10008; <b><i>" +msg+ "</i><b></p> </strong>");
		}
		
		public static void AssertPass_Extent_Report() {
			//System.out.println();
			//Reporter.log("<strong> <h3 style=\"color:DarkRed\"> &#10008; <i> UNSUCCESSFUL </i></h3> </strong>");
			CalcuQuote_Login_Index.extent_report_log.log(LogStatus.PASS, "<strong> <p style=\"color:DarkGreen\"> &#10004; <b><i> SUCCESSFUL </i><b></p> </strong>");
			//<strong> <h3 style=\"color:DarkGreen\">  &#10004; <i>  SUCCESSFUL </i></h3> </strong> 
		}
		
		public static void VerificationPass_Extent_Report(String msg) {
			//System.out.println();
			//Reporter.log("<strong> <h3 style=\"color:DarkRed\"> &#10008; <i> UNSUCCESSFUL </i></h3> </strong>");
			CalcuQuote_Login_Index.extent_report_log.log(LogStatus.INFO, "<strong> <p style=\"color:DarkGreen\"> &#10004; <b><i> " +msg+ " </i><b></p> </strong>");
			//<strong> <h3 style=\"color:DarkGreen\">  &#10004; <i>  SUCCESSFUL </i></h3> </strong> 
		}
	
}
