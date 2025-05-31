package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class PracticeAutomation {
	WebDriver driver;
  @Parameters({"username","password"})
  @Test
  public void login(String un, String ps) {
	  driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(un);
	  driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(ps);
	  driver.findElement(By.id("submit")).click();
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver.get("https://practicetestautomation.com/practice-test-login/");
		System.out.println("Title:"+driver.getTitle());
  }

  @AfterMethod
  public void afterMethod() {
	  //String logout=driver.findElement(By.xpath("//*[@id=\"main-container\"]//h1")).getText();
	  Assert.assertTrue(driver.getCurrentUrl().contains("logged-in-successfully"),"Logged in successfully");
		Assert.assertFalse(!driver.getCurrentUrl().contains("logged-in-successfully"),"Login is unsuccessful");
		 driver.findElement(By.linkText("Log out")).click();
  }

  @BeforeTest
  public void beforeTest() {
	  driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Before Test");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }
  

}
