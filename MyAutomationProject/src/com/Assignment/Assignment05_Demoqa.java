package com.Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment05_Demoqa {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/webtables");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> ele=driver.findElements(By.xpath("//div[@class=\"rt-resizable-header-content\"]"));
		for(WebElement e:ele) {
			System.out.print(e.getText());
		}
        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.xpath("//input[@id=\"firstName\"]")).sendKeys("Simran");
        driver.findElement(By.xpath("//input[@id=\"lastName\"]")).sendKeys("Manjarekar");
        driver.findElement(By.xpath("//input[@id=\"userEmail\"]")).sendKeys("simran@gmail.com");
        driver.findElement(By.xpath("//input[@id=\"age\"]")).sendKeys("27");
        driver.findElement(By.xpath("//input[@id=\"salary\"]")).sendKeys("10000");
        driver.findElement(By.xpath("//input[@id=\"department\"]")).sendKeys("Testing");
        driver.findElement(By.xpath("//button[@id=\"submit\"]")).click();
       List<WebElement> ele1=driver.findElements(By.xpath("//div[@class=\"ReactTable -striped -highlight\"]/div/div[2]/div/div"));
        int counter=0;
           for(int i=1; i<=ele1.size();i++) {
           WebElement n=driver.findElement(By.xpath("(//div[@class=\"ReactTable -striped -highlight\"]/div/div[2]/div/div)["+i+"]/div"));

        		String name=n.getText();
    	    	System.out.println(name);
        	if(!name.isEmpty()) {
//	    	System.out.println(e.getAttribute("class"));
	    	counter=counter+1;
	    	
	    	if(name.contains("Simran"))
	    	{
	    		JavascriptExecutor js=(JavascriptExecutor)driver;
	    		
	    		js.executeScript("arguments[0].click()",driver.findElement(By.xpath("//span[@id=\"delete-record-"+counter+"\"]")));
	    		break;
	    	}
	    }
        }
	}
	
	

}
