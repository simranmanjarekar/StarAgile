package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;

import io.netty.buffer.ByteBufConvertible;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class StarAgile {


		    public static void main(String[] args)throws InterruptedException {
		        // TODO Auto-generated method stub
		        WebDriver driver = new ChromeDriver();
		        driver.manage().window().maximize();
		        driver.get("https://staragile.melimu.com");
		        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("vinodsharma31999@gmail.com");
		        driver.findElement(By.xpath("//*[@id=\'password']")).sendKeys("Dmansion@03011999");
		        Thread.sleep(4000);
		     String URL = driver.getTitle();
		          String PageSource = driver.getPageSource();
		     System.out.println("The current PageSource is: " + PageSource);
		        // System.out.println("The URL is: " + URL);
		        driver.findElement(By.xpath("//*[@id='loginbtn']")).click();
		        Thread.sleep(2000);
		        String currentURL = driver.getCurrentUrl();
		        System.out.println("The current URL is: " + currentURL);
		        Thread.sleep(2000);
		        driver.findElement(By.xpath("//*[@id=\"region-main\"]/div[2]/div[2]/ul/li[2]/a\r\n")).click();
		        Thread.sleep(2000);
		        driver.findElement(By.xpath("//*[@Class = 'm3-course-card-img']")).click();
		        Thread.sleep(2000);
		        ////*[@tittle = "Phase 1 - Automation SA2411063"]/a/h2/div/div
		        driver.findElement(By.xpath("(//*[@class ='d-flex m3-course-card-body'])[1]/div[2]/div")).click();
		        Thread.sleep(2000);
		        driver.findElement(By.xpath("//*[@id='heading5']")).click();
		        Thread.sleep(2000);
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("window.scrollBy(0,250)", "");
		        driver.findElement(By.xpath("(//*[@id='collapse5'])/div/ul/li[2]/a/div[1]/img")).click();
		        Thread.sleep(2000);
		        ////*[@Automation SA2411063 | Training Zoom Link]
		        // driver.findElement(By.linkText("Dashboard")).click();
		        Thread.sleep(1000);

		    }

		

	

}
