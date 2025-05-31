package com.TestSuite;

import org.testng.annotations.Test;

import com.pages.HomePage;

import org.testng.annotations.Test;

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
		HomePage hPage;
	 
	  @BeforeClass(alwaysRun=true)
	  public void tearUp() throws IOException {
		  setFramework();
		  this.lPage = new CommonFunctions(driver);
		  this.hPage=new HomePage(driver);
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


