package com.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://echotrak.com/Login.aspx?ReturnUrl=%2f");
		driver.findElement(By.name("txtCustomerID")).sendKeys("simran");
		driver.findElement(By.name("txtPassword")).sendKeys("simran_123");
		driver.findElement(By.name("Butsub")).click();
	}
}
