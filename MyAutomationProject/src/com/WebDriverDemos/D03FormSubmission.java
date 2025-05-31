package com.WebDriverDemos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class D03FormSubmission {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		WebElement ele = driver.findElement(By.cssSelector("select[name^=\"DOB_Day\"]"));
		Select day = new Select(ele);
		day.selectByVisibleText("01");
		WebElement ele1 = driver.findElement(By.cssSelector("select[name^=\"DOB_Month\"]"));
		Select month = new Select(ele1);
		month.selectByVisibleText("JAN");
		WebElement ele2 = driver.findElement(By.cssSelector("select[name^=\"DOB_Year\"]"));
		Select year = new Select(ele2);
		year.selectByVisibleText("2000");
		List<WebElement> options = month.getOptions();
		System.out.println("month:" + month.getFirstSelectedOption().getText());
		for (WebElement a : options) {
			if (a.getText().contains("Month")) {

			} else {
				System.out.print(a.getText() + " ");
			}
		}
		System.out.println(options.size());
	}
}
