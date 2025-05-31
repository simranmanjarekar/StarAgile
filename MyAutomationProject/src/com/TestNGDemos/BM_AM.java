package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BM_AM {
	public static WebDriver driver;
	
	@BeforeTest
	public void LaunchBrowser()
	{
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Before Test");
	}
	
	@BeforeMethod
	public void beforemethod()
	{
		System.out.println("Before Method");
	}
	
	
  @Test(priority=0)
  public void TestHM() {
		driver.get("https://www2.hm.com/en_in/index.html?srsltid=AfmBOoo-hM31maRvNrPBuhea16FfCaTv6J_QRMmz-NJOLusn5xjV13P6");
  }
  
  @Test(priority=2)
  public void TestMyntra() {
		driver.get("https://www.myntra.com/");
  }
  
  @Test(priority=1)
  public void TestAmazon() {
		driver.get("https://www.amazon.in/");
  }
  
  @Test(priority=3)
  public void TestUrbanic() {
		driver.get("https://in.urbanic.com/");
  }
  
  @AfterMethod
	public void aftermethod()
	{
	  System.out.println("Title:"+driver.getTitle());
		System.out.println("After Method");
	}
  
  @AfterTest
  public void closeBrowser()
  {
		driver.close();
		System.out.println("After Test");
  }
}
