package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D01LaunchingChrome {

	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
  WebDriver driver=new ChromeDriver();
  driver.get("https://www.facebook.com/");
  //driver.navigate().to("https://mail.google.com/");
  System.out.println(driver.getTitle());
  driver.manage().window().maximize();
//  String page=driver.getPageSource();
//  System.out.println(page);
//  driver.close();
  driver.findElement(By.name("email")).sendKeys("simranmanjarekar.sm.5997@gmail.com");
  driver.findElement(By.name("pass")).sendKeys("Aaibaba$5997");
  driver.findElement(By.name("login")).click();
	}

}
