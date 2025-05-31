package com.Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment06_ISTQB {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://istqb.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		List<WebElement> menus=driver.findElements(By.xpath("//ul[@class=\"sp-megamenu-parent menu-animation-none d-none d-lg-block\"]/li/following-sibling::*"));
		List<WebElement> menus=driver.findElements(By.xpath("//nav[@class=\"sp-megamenu-wrapper d-flex\"]/ul/li"));
		System.out.println("total no of Menus:"+menus.size());
	    for(WebElement e: menus)
	    {
	    	System.out.print(e.getText()+" ");
	    }
	    WebElement link=driver.findElement(By.linkText("SPECIALIST"));
	    Actions a=new Actions(driver);
	    a.moveToElement(link).perform();
	    List<WebElement> links=driver.findElements(By.xpath("//ul[@class=\"sp-dropdown-items\"]/li"));
	    for(WebElement lik:links) {
	    	System.out.println(lik.getText());
	    }
	    		}

}
