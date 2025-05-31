package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Assignment01 {
	WebDriver driver;
	@Test(priority=1)
	public void ClickOnSell() {
		driver.findElement(By.linkText("Sell")).click();
	}
	@Test(priority=2)
	public void ClickOnMobiles() {
		driver.findElement(By.linkText("Mobiles")).click();
	}
	@Test(priority=3)
	public void ClickOnBestSellers() {
		driver.findElement(By.linkText("Best Sellers")).click();
	}
	@Test(priority=4)
	public void ClickOnElectronics() {
		driver.findElement(By.xpath("//a[contains(text(),\"Electronics\")]")).click();
	}
	@BeforeMethod
	public void LaunchAmazon() {
		driver.get("https://www.amazon.in/");
		System.out.println("Title:"+driver.getTitle());
		System.out.println("Before Method");
	}

	@AfterMethod
	public void GetTitle() {
		System.out.println("Title:"+driver.getTitle());
		System.out.println("After Method");
	}

	@BeforeTest
	public void LaunchBrowser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Before Test");
	}

	@AfterTest
	public void CloseBrowser() {
		driver.close();
		System.out.println("After Test");
	}

}
