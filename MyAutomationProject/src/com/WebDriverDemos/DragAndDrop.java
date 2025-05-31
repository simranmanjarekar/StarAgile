package com.WebDriverDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/");
		
		Actions act=new Actions(driver);
//		driver.findElement(By.xpath("//a[text()=\"Droppable\"]")).click();
//		driver.switchTo().frame(0);
//		WebElement source=driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
//		WebElement target=driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
//				
//		act.dragAndDrop(source, target).perform();
		driver.findElement(By.xpath("//a[text()=\"Slider\"]")).click();
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement slider=driver.findElement(By.xpath("//span[@class=\"ui-slider-handle ui-corner-all ui-state-default\"]"));
		act.dragAndDropBy(slider, slider.getLocation().x+100, slider.getLocation().y).perform();

	}

}
