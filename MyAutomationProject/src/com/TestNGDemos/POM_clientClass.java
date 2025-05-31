package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class POM_clientClass {
	WebDriver driver;
	POM_utilityClass p;

	 @Test(dataProvider="dp")
	  public void loginlogout(String un, String ps) throws InterruptedException {
		 p.enterUsername(un);
		 p.enterPassword(ps);
		 p.login();
		 System.out.println(p.getErrorMsg());
		 p.logout();
		 
	  }


	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { "practice","SuperSecretPassword!" },
	      new Object[] { "minal", "b" },
	    };
	  }
	  @BeforeTest
	  public void beforeTest() throws IOException {
		    driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://practice.expandtesting.com/login");
			p=new POM_utilityClass(driver);
	  }

	  @AfterTest
	  public void afterTest() {
		  driver.close();
	  } 

}
