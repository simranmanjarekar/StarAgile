package com.WebDriverDemos;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js=(JavascriptExecutor)driver;
//		driver.findElement(By.id("alertButton")).click();
//		js.executeScript("arguments[0].click()",driver.findElement(By.id("alertButton")));
//		Alert a=driver.switchTo().alert();
//		System.out.println(a.getText());
//		a.accept();
//		js.executeScript("arguments[0].click()",driver.findElement(By.id("timerAlertButton")));
//		Thread.sleep(5000);
//		a=driver.switchTo().alert();
//		System.out.println(a.getText());
//		a.accept();
//		js.executeScript("arguments[0].click()",driver.findElement(By.id("confirmButton")));
//		a=driver.switchTo().alert();
//		System.out.println(a.getText());
//		a.accept();
//		js.executeScript("arguments[0].click()",driver.findElement(By.id("promtButton")));
		js.executeScript("window.scrollBy(0,500)", "");
		js.executeScript("arguments[0].click()",driver.findElement(By.id("promtButton")));
		Alert a=driver.switchTo().alert();
		System.out.println(a.getText());
		a.sendKeys("Simran");
		Thread.sleep(200);
		a.accept();

	}

}
