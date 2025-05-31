package com.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment07_Login {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://asana.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		WebElement ele=driver.findElement(By.xpath("//*[@id=\"q-messenger-frame\"]"));
		Actions a=new Actions(driver);
//		a.moveToElement(ele).click().build().perform();
		driver.switchTo().frame(ele);
//		Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@data-backend-test-id=\"close-button\"]")).click();
        Thread.sleep(2000);
//        JavascriptExecutor js=(JavascriptExecutor)driver;
        try {
        	WebElement ele1=driver.findElement(By.linkText("Log In"));
        	ele1.click();
        }
        catch(Exception e)
        {
        	WebElement ele1=driver.findElement(By.linkText("Log In"));
        	ele1.click();
        
        }
        
//        js.executeScript("arguments[0].click();", ele1);
        
//        a.moveToElement(ele1).click().build().perform();
	}

}
