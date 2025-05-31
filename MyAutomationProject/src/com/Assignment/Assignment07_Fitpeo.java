package com.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment07_Fitpeo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.fitpeo.com/revenue-calculator");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
		WebElement slider=driver.findElement(By.xpath("//input[@type=\"range\"]"));
		Thread.sleep(1000);
		for(int i=1;i<=600;i++)
		{
			driver.findElement(By.xpath("//input[@type=\"range\"]")).sendKeys(Keys.ARROW_RIGHT);
		}
//		Actions a=new Actions(driver);
//		Thread.sleep(2000);
//	    Point p=slider.getLocation();
//	    int x=p.getX();
//	    int y=p.getY();
//	    System.out.println("X "+x+"Y "+y);
//	    Actions builder = new Actions(driver);   
//		builder.clickAndHold(slider).moveByOffset(40,0).release().build().perform(); 
//		a.dragAndDropBy(slider, slider.getLocation().x, slider.getLocation().y).perform();
//		WebElement input=driver.findElement(By.xpath("//input[@type=\"number\"]"));
//		js.executeScript("document.getElementById(':r0:').value='600';");
//		String value=driver.findElement(By.xpath("//input[@type=\"number\"]")).getAttribute("value");
//        System.out.println(value);
	}

}
