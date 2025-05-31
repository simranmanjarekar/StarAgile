package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class propertiesXpathRead {
	File file;
	FileInputStream fis;
	Properties prop;
	WebDriver driver;
  @Test
  public void Test() throws InterruptedException {
	  driver.findElement(By.xpath(prop.getProperty("name"))).sendKeys("simran manjarekar");
	  driver.findElement(By.xpath(prop.getProperty("rediffid"))).sendKeys("simranman");
	  driver.findElement(By.xpath(prop.getProperty("availabilityBtn"))).click();
	  Thread.sleep(2000);
	  System.out.println(driver.findElement(By.xpath(prop.getProperty("availabilityTxt"))).getText());
  }
  @BeforeTest
  public void beforeTest() throws IOException {
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 file=new File("./src/com/TestNGDemos/xpath.properties");
	 fis=new FileInputStream(file);
	 prop=new Properties();
	 prop.load(fis);
	 driver.get(prop.getProperty("URL"));
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
