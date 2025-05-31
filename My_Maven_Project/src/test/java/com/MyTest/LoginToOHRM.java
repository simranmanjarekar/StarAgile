package com.MyTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class LoginToOHRM {
	ExtentSparkReporter reporter;
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	File scrFile;
  @Test(priority=0)
  public void LoginToOHRM_Pass() {
	  test=report.createTest("Login to OHRM:Pass", "Testing login functionality");
	  driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("dash"));
  }
  @Test(priority=1)
  public void LoginToOHRM_Fail() {
	  test=report.createTest("Login to OHRM:Fail");
	  driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Simran");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("simran123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("dash"));
  }
  @Test(priority=2)
  public void LoginToOHRM_Skip() {
	  test=report.createTest("Login to OHRM:Skip");
	  throw new SkipException("skip this test case for reporting");
  }
  @AfterMethod
  public void afterMethod(ITestResult result) throws IOException {
	  if(result.getStatus()==ITestResult.SUCCESS) {
		  test.log(Status.PASS,MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
//		  test.log(Status.INFO,"Test Passed");
	  }else if(result.getStatus()==ITestResult.FAILURE) {
		  test.log(Status.FAIL,MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		  test.fail(result.getThrowable());
		  scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  File destFile=new File("./Photo/Failed login.png");
		  FileHandler.copy(scrFile, destFile);
          //test.addScreenCaptureFromPath("./Photo/Failed login.png", "Failed login SS");
          test.addScreenCaptureFromPath(scrFile.getAbsolutePath(),"Failed Login SS");
	  }else if(result.getStatus()==ITestResult.SKIP) {
		  test.log(Status.SKIP,MarkupHelper.createLabel(result.getName(), ExtentColor.BLUE));
		  test.skip(result.getThrowable());
	  }
	  
  }

  @BeforeTest
  public void beforeTest() {
	  reporter=new ExtentSparkReporter("LoginOHRM.html");
	   report=new ExtentReports();
	   report.attachReporter(reporter);
	   report.setSystemInfo("Company", "StarAgile");
       report.setSystemInfo("Project Name", "LoginToOHRM");
       report.setSystemInfo("user","simran");
       report.setSystemInfo("browser","Chrome");
       report.setSystemInfo("machine", "DELL");
       report.setSystemInfo("OS","windows 11");
       reporter.config().setDocumentTitle("Login to OHRM");
       reporter.config().setReportName("OHRM");
       reporter.config().setTheme(Theme.STANDARD);;
       reporter.config().setTimeStampFormat("MM-dd-yyyy");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
	  report.flush();
  }

}
