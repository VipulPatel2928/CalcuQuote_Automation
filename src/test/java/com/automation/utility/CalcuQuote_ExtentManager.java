package com.automation.utility;

import com.relevantcodes.extentreports.ExtentReports;

public class CalcuQuote_ExtentManager {
	private static ExtentReports extent;
	public static String browsername; 
    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/screenshots/Extent_Report_new.html", true);
            extent.addSystemInfo("Host Name", "Vipul");
            extent.addSystemInfo("Browser Name", browsername);
            extent.addSystemInfo("Prepared For:", "CalcuQuote");
            extent.addSystemInfo("Prepared By:", "Triveni Global Software Services LLP");
        }
        return extent;
    }
	
}
