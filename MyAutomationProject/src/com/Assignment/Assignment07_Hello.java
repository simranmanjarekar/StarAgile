package com.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment07_Hello {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.nimblework.com/resources/?tx_post_tag=case-studies");
		
		driver.findElement(By.xpath("//*[@id=\"kairon-client-container\"]/div")).getShadowRoot().findElement(By.className("buttonInternal")).click();
		driver.findElement(By.xpath("//*[@id=\"kairon-client-container\"]/div")).getShadowRoot().findElement(By.className("msgInput-0-3-60 msgInput-d1-0-3-81")).sendKeys("Hello");


	}

}
