package com.WebDriverDemos;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://money.rediff.com/index.html");
		
//		TakesScreenshot ts =(TakesScreenshot)driver;
//		File ram=ts.getScreenshotAs(OutputType.FILE);
		File ram=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("./photo/Rediff"+System.currentTimeMillis()+".jpg");
		FileHandler.copy(ram,dest);
        System.out.println("Screenshot captured successfully");
        if(dest.exists())
        {
        	System.out.println("File created");
        }
        else {
        	System.out.println("File not created");
        }
	}

}
