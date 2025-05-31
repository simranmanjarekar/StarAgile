package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class POM_utilityClass {
    WebDriver driver;
    File file;
    FileInputStream fis;
    Properties prop;
	JavascriptExecutor js;
	
	 POM_utilityClass(WebDriver d) throws IOException{
		 driver=d;
		 file=new File("./src/com/TestNGDemos/xpath.properties");
		 fis=new FileInputStream(file);
		 prop=new Properties();
		 prop.load(fis);
		 js=(JavascriptExecutor)driver;
		 PageFactory.initElements(driver, this);
	 }
	  @FindBy (id="username") WebElement userName;
	public void enterUsername(String username)
	 
	{
		
		
//		driver.findElement(By.id(prop.getProperty("username"))).sendKeys(username);
		userName.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(By.id(prop.getProperty("password"))).sendKeys(password);
	}
	public void login()
	{
		
		js.executeScript("window.scrollBy(0,800);", "");
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(prop.getProperty("loginbtn"))));
	}
	public String getErrorMsg() throws InterruptedException
	{
		Thread.sleep(2000);
		if(driver.getCurrentUrl().contains("secure")) 
		return (driver.findElement(By.xpath("//div[@id=\"flash\"]/b")).getText());
		else
			return "invalid data";

	}
    public void logout() throws InterruptedException
    {
    	if(driver.getCurrentUrl().contains("secure")) {
    		Thread.sleep(2000);
    		js.executeScript("window.scrollBy(0,800);", "");
    		js.executeScript("arguments[0].click();", driver.findElement(By.linkText(prop.getProperty("Logoutbtn"))));
    	}
    	else {
    		System.out.println("invalid username/password");
    	}
    }

}
