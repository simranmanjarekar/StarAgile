package com.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment04_DashBling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://dash.bling-center.com/platform/signIn.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@class=\"forget-password-btn\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"email1\"]")).sendKeys("simranmanjarekar.sm.5997@gmail.com");
		driver.findElement(By.xpath("//button[@class=\"reset-pwd signIn-btn\"]")).click();
		Thread.sleep(2000);
		String errormsg=driver.findElement(By.id("resetsuccess")).getText();
		System.out.println(errormsg);
		//driver.close();
	}

}
