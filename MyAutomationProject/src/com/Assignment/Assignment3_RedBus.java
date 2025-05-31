package com.Assignment;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3_RedBus {
	static WebElement ele;
	static By by;
	
	
	public static void main(String args[]) throws InterruptedException {
	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		//Source
		driver.findElement(By.xpath("//input[@type=\"text\"][@id=\"src\"]")).sendKeys("Kolh");
		//Thread.sleep(1000);
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//ul[@class=\"sc-dnqmqq dZhbJF\"]//li)[1]")));
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(10))
		.ignoring(NoSuchElementException.class).pollingEvery(Duration.ofMillis(1)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//ul[@class=\"sc-dnqmqq dZhbJF\"]//li)[1]")));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("(//ul[@class=\"sc-dnqmqq dZhbJF\"]//li)[1]")).click();
        
		//Target
		driver.findElement(By.xpath("//input[@type=\"text\"][@id=\"dest\"]")).sendKeys("Ban");
		//Thread.sleep(1000);
		wait.withTimeout(Duration.ofSeconds(10))
		.ignoring(NoSuchElementException.class).pollingEvery(Duration.ofMillis(1)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//ul[@class=\"sc-dnqmqq dZhbJF\"]//li)[1]")));
		driver.findElement(By.xpath("(//ul[@class=\"sc-dnqmqq dZhbJF\"]//li)[1]")).click();
		driver.findElement(By.xpath("//div[@class=\"labelCalendarContainer\"]")).click();
		WebElement month=driver.findElement(By.xpath("//div[@class=\"sc-jzJRlG hrJoeL\"]/div/div/div/div[2]"));
		while(!month.getText().contains("May"))
		{	
			driver.findElement(By.xpath("//div[@class=\"DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr\"]/div[3]")).click();
		}
		driver.findElement(By.xpath("//span[contains(text(),'26')]")).click();
		//driver.findElement(By.xpath("//span[@class='DayTiles__CalendarDaysSpan-sc-1xum02u-1 fgdqFw']")).click();
		
		
//		driver.findElement(By.id("search_button")).click();
//		Thread.sleep(3000);
//		String travel=driver.findElement(By.xpath("//div[@class=\"travels lh-24 f-bold d-color\"]")).getText();
//		System.out.println(travel);
	}

}
