package com.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("Pass123");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		WebElement loginError=driver.findElement(By.xpath("//div[@class=\"_9ay7\"]"));
		String loginFailed=driver.findElement(By.xpath("//div[@class=\"_9ay7\"]")).getText();
		if(loginError.isDisplayed()) {
		if(loginFailed.contains("incorrect"))
		{
			System.out.println("Login failed"+loginFailed);
		}
		}				
	}

}
