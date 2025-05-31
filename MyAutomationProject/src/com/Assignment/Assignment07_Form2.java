package com.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment07_Form2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jotform.com/form-templates/exam-registration-form");
		driver.findElement(By.id("userName")).sendKeys("simranmanjarekar");
		driver.findElement(By.id("fullName")).sendKeys("Simran Manjarekar");
		driver.findElement(By.id("usrPwd")).sendKeys("Simran123");
		driver.findElement(By.id("cnfUsrPwd")).sendKeys("Simran123");
		driver.findElement(By.id("email")).sendKeys("simranmanjarekar@yahoo.in");
		driver.findElement(By.xpath("//input[@id=\"mobile\"]")).sendKeys("6389109100");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[text()=\"Submit\"]")).submit();
		System.out.println("Form submitted successfully");

	}

}
