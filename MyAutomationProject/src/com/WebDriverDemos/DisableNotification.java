package com.WebDriverDemos;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisableNotification {

	public static void main(String[] args) {
		ChromeOptions op=new ChromeOptions();
		//op.addArguments("--disable-notifications");
		//op.addArguments("--headless");
		op.addArguments("start-maximized");
		WebDriver driver=new ChromeDriver(op);
		driver.get("https://www.redbus.in/");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

}
