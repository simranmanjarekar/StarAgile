package com.WebDriverDemos;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Rightclick {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions a=new Actions(driver);
        WebElement rightclick=driver.findElement(By.xpath("//*[@id=\"authentication\"]/span"));
        a.contextClick(rightclick).perform();
        System.out.println(rightclick.getText());
        List<WebElement> rightlist=driver.findElements(By.xpath("//*[@id=\"authentication\"]/ul/li"));
        for(WebElement list:rightlist)
        {
        	System.out.println(list.getText());
        }
        Thread.sleep(2000);
        a.sendKeys(Keys.ESCAPE).perform();
        WebElement doubleclick=driver.findElement(By.xpath("//*[@id=\"authentication\"]/button"));
        a.doubleClick(doubleclick).perform();
        Thread.sleep(2000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        System.out.println(doubleclick.getText());
        
//        driver.switchTo().alert().accept();
	}

}
