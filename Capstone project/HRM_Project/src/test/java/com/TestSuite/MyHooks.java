package com.TestSuite;

import org.testng.annotations.Test;

import com.pages.AdminPage;
import com.pages.LoginPage;

import CoreFunctions.CommonFunctions;
import CoreFunctions.ObjectLaunched;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static CoreFunctions.ObjectLaunched.prop;
import static CoreFunctions.ObjectLaunched.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class MyHooks extends ObjectLaunched{
	CommonFunctions lPage;
	LoginPage page;
	AdminPage aPage;
 
  @BeforeClass(alwaysRun=true)
  public void tearUp() throws IOException {
	  setFramework();
	  this.lPage = new CommonFunctions(driver);
	  this.page = new LoginPage(driver);
	  this.aPage=new AdminPage(driver);
	  lPage.navigateURL();
  }

  @AfterClass(alwaysRun=true)
  public void tearDown() throws IOException {
	  StopSelenium();
  }

	public WebDriver getDriver() {
		return driver;
	}
}
