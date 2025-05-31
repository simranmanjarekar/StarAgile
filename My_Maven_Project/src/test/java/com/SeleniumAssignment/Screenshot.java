package com.SeleniumAssignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;

public class Screenshot {
	WebDriver driver;
	TakesScreenshot ts;
	File src;
	File dest;

	@Test
	public void takeScreenshot() throws IOException {
		ts=(TakesScreenshot)driver;
		src=ts.getScreenshotAs(OutputType.FILE);
		dest=new File("Photo/HomePage.jpg");
		FileHandler.copy(src, dest);
	}

	@BeforeTest
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://omayo.blogspot.com/");		
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
