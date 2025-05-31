package com.Utilities;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentreporter {
	
	public static ExtentSparkReporter reporter;
	public static ExtentReports report;
	
     public static ExtentReports getReport() {
    	 if(report == null) {
    	 Date d=new Date();
    	 String date=d.toString().replace(":", "-").replace(" ","_");
    	 String reportFolderPath=System.getProperty("user.dir")+"//Output//Reports//"+"OrangeHRM_"+date+"_Report.html";
    	 reporter=new ExtentSparkReporter(reportFolderPath);
    	 report=new ExtentReports();
    	 report.attachReporter(reporter);
    	 report.setSystemInfo("Company", "StartAgile");
    	 report.setSystemInfo("Project", "Orange HRM");
    	 report.setSystemInfo("OS", "Windows");
    	 report.setSystemInfo("Browser", "Chrome");
    	 report.setSystemInfo("Machine", "Dell");
    	 reporter.config().setReportName("Orange HRM extent report");
    	 reporter.config().setDocumentTitle("Orange HRM report");
    	 reporter.config().setTheme(Theme.STANDARD);
    	 reporter.config().setTimeStampFormat("EEEE dd-MMMM-YYYY hh:mm a '('zzz')'");
    	 }
    	 return report;
    	 }
     }
