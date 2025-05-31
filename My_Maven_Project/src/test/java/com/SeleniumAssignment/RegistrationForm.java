package com.SeleniumAssignment;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;

public class RegistrationForm {
	WebDriver driver;
	JavascriptExecutor js;
	TakesScreenshot ts;
	File src;
	File dest;
	
  @Test(dataProvider="data")
  public void submitDetails(String FN,String LN, String Email, String Gender,String mob, String DOB, String Hobby, String Address) throws IOException {
	  driver.findElement(By.id("firstName")).sendKeys(FN);
  	driver.findElement(By.id("lastName")).sendKeys(LN);
  	driver.findElement(By.id("userEmail")).sendKeys(Email);
  	if(Gender.equals("Male")) {
  		js.executeScript("arguments[0].click();", driver.findElement(By.id("gender-radio-1")));
  	}else if(Gender.equals("Female"))
  	{
  		js.executeScript("arguments[0].click();",driver.findElement(By.id("gender-radio-2")));
  	}else if(Gender.equals("Other"))
  	{
  		driver.findElement(By.id("gender-radio-3")).click();
  	}
  	driver.findElement(By.id("userNumber")).sendKeys(mob);
  	WebElement date=driver.findElement(By.id("dateOfBirthInput"));
		date.sendKeys(Keys.CONTROL+"A");        	
  	date.sendKeys(DOB);
  	date.sendKeys(Keys.ENTER);
  	js.executeScript("window.scrollBy(0,500);", "");
  	if(Hobby.equals("Sports")) {
  		js.executeScript("arguments[0].click();",driver.findElement(By.id("hobbies-checkbox-1")));
  	}else if(Hobby.equals("Reading"))
  	{
  		js.executeScript("arguments[0].click();",driver.findElement(By.id("hobbies-checkbox-2")));
  	}else if(Hobby.equals("Music"))
  	{
  		js.executeScript("arguments[0].click();",driver.findElement(By.id("hobbies-checkbox-3")));
  	}
  	driver.findElement(By.id("currentAddress")).sendKeys(Address);
  	driver.findElement(By.xpath("//button[@id=\"submit\"]")).click(); 
  	ts=(TakesScreenshot)driver;
	src=ts.getScreenshotAs(OutputType.FILE);
	dest=new File("Photo/RegistrationSuccess.jpg");
	FileHandler.copy(src, dest);
  }
  
  @DataProvider
  public Object[][] data(){
	  
	  return new Object[][] {
		  {"Simran","Manjarekar","simran@gmail.com", "Female","2893299103","05 Sep 1997","Reading","Khar east"}
	  };
  }
  
  @AfterMethod
  public void validateRegistration() {
	  WebElement successMessage = driver.findElement(By.className("modal-body"));
      Assert.assertTrue(successMessage.isDisplayed());
  }

  @BeforeTest
  public void luanchBrowser() {
	  driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://web.archive.org/web/20220126121054/https://demoqa.com/automation-practice-form/");
	    js=(JavascriptExecutor) driver;
  }

  @AfterTest
  public void tearDown() {
	  driver.close();
  }

}
