package com.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment04_OrangeHRM {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(("Admin"));
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(("akdmin123"));
        WebElement ele1=driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        ele1.click();
//        WebElement ele=driver.findElement(By.xpath("//i[contains(@class,\"oxd-userdropdown-icon\")]"));
        if(driver.findElement(By.xpath("//i[contains(@class,\"oxd-userdropdown-icon\")]")).isDisplayed()) {
        	System.out.println("Login is successful");
        driver.findElement(By.xpath("//i[contains(@class,\"oxd-userdropdown-icon\")]")).click();
        driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();
        }
        if(ele1.isDisplayed()){
        	System.out.println("Login is not successful");
        }
        }

}
