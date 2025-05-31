package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assertion {
	WebDriver driver;
    String expUrl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",actUrl;
	@BeforeTest
	public void LaunchBrowser()
	{
		System.out.println("Before Test");
	    driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterTest
	public void CloseBrowser()
	{
		System.out.println("After Test");
		driver.close();
	}

	@DataProvider
	public Object[][] data(){
		return new Object[][] {
			{"Admin","admin123"},
			 {"Vinod","vinod123"},
			 {"Admin","admin123"},
			 {"Simran","simran123"}
		};
		
	}

	@Test(dataProvider="data")
	public void LoginOHRM2(String name, String pass) {
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		actUrl=driver.getCurrentUrl();
		Assert.assertEquals(actUrl, expUrl, "Invalid username/password");
	}
	
	@AfterMethod
	public void Logout() throws InterruptedException
	{
		System.out.println("After method");
		if(driver.getCurrentUrl().contains("dashboard")) {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//i[contains(@class,\"oxd-userdropdown-icon\")]")).click();
        driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();
        System.out.println("Test case Pass");
	}
		else
		{
			System.out.println("After method");
			System.out.println("Test case fail");
			
		}		}

}
