package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class D01Test {

		@Test
		public void TestHM() {
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www2.hm.com/en_in/index.html?srsltid=AfmBOoo-hM31maRvNrPBuhea16FfCaTv6J_QRMmz-NJOLusn5xjV13P6");
			System.out.println("Title:"+driver.getTitle());	
			driver.close();
			
	  }
		@Test
		public void TestMyntra() {
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.myntra.com/");
			System.out.println("Title:"+driver.getTitle());
			driver.close();
	  }
		@Test
		public void TestAmazon() {
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.amazon.in/");
			System.out.println("Title:"+driver.getTitle());
			driver.close();
	  }
		@Test
		public void TestUrbanic() {
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://in.urbanic.com/");
			System.out.println("Title:"+driver.getTitle());
			driver.close();
	  }
  }

