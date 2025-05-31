package com.WebDriverDemos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class D02GoogleSearch {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in/");
//		WebElement search=driver.findElement(By.className("gLFyf"));
//		search.sendKeys("jpmorgan banker bonus");
//		search.sendKeys(Keys.ENTER);
//		search.sendKeys(Keys.RETURN);
//		Actions action=new Actions(driver);
//	    action.sendKeys(search,"jpmorgan banker bonus").sendKeys(Keys.ENTER).perform();
//		driver.findElement(By.linkText("About")).click();
//		driver.findElement(By.partialLinkText("Abo")).click();
//		driver.findElement(By.xpath("//span[@class=\"QCzoEc z1asCe MZy1Rb\"]")).click();
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		}

}
