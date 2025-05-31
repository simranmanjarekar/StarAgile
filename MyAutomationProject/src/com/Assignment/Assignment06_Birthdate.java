package com.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Assignment06_Birthdate {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement date=driver.findElement(By.id("dateOfBirthInput"));
	JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", date);
//		WebElement year=driver.findElement(By.xpath("//select[@class=\"react-datepicker__year-select\"]"));
//		Select s=new Select(year);
//        s.selectByVisibleText("1997");
//        WebElement month=driver.findElement(By.xpath("//select[@class=\"react-datepicker__month-select\"]"));
//		Select m=new Select(month);
//        m.selectByVisibleText("September");
//        driver.findElement(By.xpath("//div[@class=\"react-datepicker__day react-datepicker__day--005\"]")).click();
		Actions a=new Actions(driver);
		date.sendKeys(Keys.CONTROL+"A");
        driver.findElement(By.id("dateOfBirthInput")).sendKeys("05 Sept 1997");
//        System.out.println("Birthdate selected successfully");
//		js.executeScript("window.scrollBy(0,500)","");
//      driver.findElement(By.xpath("//input[@id=\"uploadPicture\"]")).sendKeys("D:\\AppraisalSimra.txt");
//        s.deselectAll();
//        m.deselectAll();
	}

}
