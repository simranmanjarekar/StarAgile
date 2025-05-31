package com.MyTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyExtentReports {

	public static void main(String[] args) {
		ExtentSparkReporter reporter=new ExtentSparkReporter("MyExtentReport.html");
        ExtentReports report=new ExtentReports();
        report.attachReporter(reporter);
        ExtentTest test;
        
        //add environment details into report
        report.setSystemInfo("Company", "StarAgile");
        report.setSystemInfo("Project Name", "Extent report");
        report.setSystemInfo("user","simran");
        report.setSystemInfo("browser","Chrome");
        report.setSystemInfo("machine", "DELL");
        report.setSystemInfo("OS","windows 11");
        
        //configuration of report about look and feel
        reporter.config().setDocumentTitle("My simple extent report");
        reporter.config().setReportName("Extent Report");
        reporter.config().setTheme(Theme.STANDARD);
        reporter.config().setTimeStampFormat("EEEE MM-dd-yyyy hh:mm a'('zzz')'");
        
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println(driver.getTitle());
        driver.close();
        
        test=report.createTest("OHRM get Title");
        test.log(Status.PASS, MarkupHelper.createLabel("OHRM Title:Pass", ExtentColor.GREEN));
        report.flush();
	}


}
