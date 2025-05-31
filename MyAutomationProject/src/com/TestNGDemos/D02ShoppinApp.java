package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class D02ShoppinApp {
	public static WebDriver driver;
	
	@BeforeTest(alwaysRun=true)
	public void LaunchBrowser()
	{
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
  @Test(priority=0)
  public void TestHM() {
		driver.get("https://www2.hm.com/en_in/index.html?srsltid=AfmBOoo-hM31maRvNrPBuhea16FfCaTv6J_QRMmz-NJOLusn5xjV13P6");
		System.out.println("Title:"+driver.getTitle());
  }
  
  @Test(priority=2)
  public void TestMyntra() {
		driver.get("https://www.myntra.com/");
		System.out.println("Title:"+driver.getTitle());
  }
  
  @Test(priority=1)
  public void TestAmazon() {
		driver.get("https://www.amazon.in/");
		System.out.println("Title:"+driver.getTitle());
  }
  
  @Test(priority=3)
  public void TestUrbanic() {
		driver.get("https://in.urbanic.com/");
		System.out.println("Title:"+driver.getTitle());
  }
  
  @AfterTest(alwaysRun=true)
  public void closeBrowser()
  {
		driver.close();
  }
}
