package com.TestSuite;

import static CoreFunctions.ObjectLaunched.test;

import java.io.IOException;

import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Utilities.ExcelRead;

import CoreFunctions.CommonFunctions;
import CoreFunctions.ObjectLaunched;


public class Login extends MyHooks {
	
	
	WebDriver driver;
	MyHooks hooks;
	String expUrl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",actUrl;
	  ExcelRead excel = new ExcelRead();
	  boolean passed,failed;
	  String statusText ;
	
	public void Login(MyHooks hook) {
		this.hooks = hook;
		this.driver = hooks.getDriver();
	}
	
	@BeforeMethod
	public void startTest(ITestResult result) {
	    test = report.createTest(result.getMethod().getMethodName());
	}
	
  @Test(dataProvider="readExcel",dataProviderClass=com.Utilities.ExcelRead.class)
  public void LoginToOrangeHRMAppWithValidData(String username, String Password) {
	  lPage.type("UN", username, "xpath");
	  lPage.type("PW", Password, "xpath");
	  lPage.click("loginBtn", "xpath");
	  actUrl=lPage.getCurrentUrl();
	  Assert.assertEquals(actUrl, expUrl, "Invalid username/password");	 
  }


  @AfterMethod
	public void Logout(ITestResult result) throws InterruptedException, IOException
	{
		if(lPage.getCurrentUrl().contains("dashboard")) {
		Thread.sleep(1000);
		lPage.click("UserDropDown", "xpath");
		lPage.click("logoutBtn", "xpath");
		
		passed = result.getStatus() == ITestResult.SUCCESS;
        statusText = passed ? "Pass" : "Fail";

       
        // Write result to Excel
        excel.writeToExcel(statusText, passed);
		}
		else {
			failed = result.getStatus() == ITestResult.SUCCESS;
	        statusText = !failed ? "Fail" : "Pass";
			excel.writeToExcel(statusText, failed);
		}
		
	}
}