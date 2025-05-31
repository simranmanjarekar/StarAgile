package com.WebDriverDemos;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TricentisFileselection {

	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://sampleapp.tricentis.com/101/app.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[@id=\"enterinsurantdata\"]")).click();
		//driver.findElement(By.className("ideal-file-upload")).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.id("gendermale")));
//	    driver.findElement(By.id("gendermale")).click();
//		Robot r=new Robot();
//		for(int i=0;i<=7;i++) {
//			Thread.sleep(500);
//			r.keyPress(KeyEvent.VK_TAB);
//		}
//		for(int i=0;i<=2;i++) {
//			Thread.sleep(500);
//			r.keyPress(KeyEvent.VK_DOWN);
//		}
//		Thread.sleep(500);
//		r.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(500);
//		r.keyPress(KeyEvent.VK_TAB);
//		for(int i=0;i<=10;i++) {
//			Thread.sleep(500);
//			r.keyPress(KeyEvent.VK_DOWN);
//		}
//		Thread.sleep(500);
//		r.keyPress(KeyEvent.VK_ENTER);
	}

}
