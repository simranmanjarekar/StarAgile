package com.WebDriverDemos;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Getwindowhandles {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.online.citibank.co.in/");
		driver.findElement(By.xpath("//a[@class=\"newclose\"]")).click();
		driver.findElement(By.xpath("//a[@class=\"newclose2\"]")).click();
		driver.findElement(By.xpath("//span[@style=\"display:table-cell\"]")).click();
		Set<String> win=driver.getWindowHandles();
		Iterator<String> itr=win.iterator();
		String win1=itr.next();
		String win2=itr.next();
		driver.switchTo().window(win2);
		System.out.println(driver.getTitle());
		driver.switchTo().window(win1);
		System.out.println(driver.getTitle());
        driver.quit();
	}

}
