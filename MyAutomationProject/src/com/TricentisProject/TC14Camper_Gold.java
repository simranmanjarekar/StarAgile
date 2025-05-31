package com.TricentisProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC14Camper_Gold {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://sampleapp.tricentis.com/101/index.php");
	    
	    driver.findElement(By.linkText("Camper")).click();
	    
	    //Enter Vehicle data
	    new Select(driver.findElement(By.id("make"))).selectByVisibleText("Audi");
	    driver.findElement(By.id("engineperformance")).sendKeys("1000");
	    driver.findElement(By.id("dateofmanufacture")).sendKeys("02/01/2025");
	    new Select(driver.findElement(By.id("numberofseats"))).selectByVisibleText("2");
	    new Select(driver.findElement(By.id("fuel"))).selectByVisibleText("Petrol");
	    driver.findElement(By.id("payload")).sendKeys("10");
	    driver.findElement(By.id("totalweight")).sendKeys("100");
	    driver.findElement(By.id("listprice")).sendKeys("10000");
	    driver.findElement(By.id("licenseplatenumber")).sendKeys("MH09GF1246");
	    driver.findElement(By.id("annualmileage")).sendKeys("1000");
	    driver.findElement(By.id("nextenterinsurantdata")).click();
	    
	    //Enter Insurant data
	    driver.findElement(By.id("firstname")).sendKeys("Simran");
	    driver.findElement(By.id("lastname")).sendKeys("Simran");
	    driver.findElement(By.id("birthdate")).sendKeys("09/05/1997");
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();",driver.findElement(By.id("genderfemale")));
//	    driver.findElement(By.id("genderfemale")).click();
	    driver.findElement(By.id("streetaddress")).sendKeys("Khar east");
	    new Select(driver.findElement(By.id("country"))).selectByVisibleText("India");
	    driver.findElement(By.id("zipcode")).sendKeys("400051");
	    new Select(driver.findElement(By.id("occupation"))).selectByVisibleText("Employee");
	    js.executeScript("arguments[0].click();",driver.findElement(By.id("speeding")));
	    //driver.findElement(By.id("speeding")).click();
	    driver.findElement(By.id("nextenterproductdata")).click();
	    
	    //Enter product data
	    driver.findElement(By.id("startdate")).sendKeys("03/16/2025");
	    new Select(driver.findElement(By.id("insurancesum"))).selectByVisibleText(" 3.000.000,00");
	    //new Select(driver.findElement(By.id("meritrating"))).selectByVisibleText("Super Bonus");
	    new Select(driver.findElement(By.id("damageinsurance"))).selectByVisibleText("No Coverage");
	   // js.executeScript("arguments[0].click();",driver.findElement(By.id("EuroProtection")));
	    js.executeScript("document.getElementById('EuroProtection').click();");
	    //driver.findElement(By.id("EuroProtection")).click();
	    //new Select(driver.findElement(By.id("courtesycar"))).selectByVisibleText(" No");
	    driver.findElement(By.id("nextselectpriceoption")).click();
	    
	    //Send Quote
	    String expPrice="733.00",expClaim="Submit",expDisc="2",expCover="Limited",actPrice,actClaim,actDisc,actCover;
	    actPrice=driver.findElement(By.xpath("//section[@id=\"pricePlans\"]/div/table/tbody/tr[1]/td[3]/span")).getText();
	    actClaim=driver.findElement(By.xpath("//section[@id=\"pricePlans\"]/div/table/tbody/tr[2]/td[3]")).getText();
	    actDisc=driver.findElement(By.xpath("//section[@id=\"pricePlans\"]/div/table/tbody/tr[3]/td[3]")).getText();
	    actCover=driver.findElement(By.xpath("//section[@id=\"pricePlans\"]/div/table/tbody/tr[4]/td[3]")).getText();
	  
	    System.out.println("Checking camper-gold values");
	    if(actPrice.equals(expPrice))
	    {
	    	System.out.println("Price matching");
	    }
	    else
	    {
	    	System.out.println("Price not matching");
	    }
	    
	    if(actClaim.equals(expClaim))
	    {
	    	System.out.println("Online claim matching");
	    }
	    else
	    {
	    	System.out.println("Online claim not matching");
	    }
	    
	    if(actDisc.equals(expDisc))
	    {
	    	System.out.println("Discount matching");
	    }
	    else
	    {
	    	System.out.println("Discount not matching");
	    }
	    if(actCover.equals(expCover))
	    {
	    	System.out.println("Cover matching");
	    }
	    else
	    {
	    	System.out.println("Cover not matching");
	    }
	    js.executeScript("document.getElementById('selectgold').click();");
	   // driver.findElement(By.id("selectsilver")).click();
	    driver.findElement(By.id("nextsendquote")).click();
	    
	    //Send Quote
	    driver.findElement(By.id("email")).sendKeys("simran@gmail.com");
	    driver.findElement(By.id("username")).sendKeys("simranm");
	    driver.findElement(By.id("password")).sendKeys("Simran@123");
	    driver.findElement(By.id("confirmpassword")).sendKeys("Simran@123");
	    driver.findElement(By.id("sendemail")).click();
	    System.out.println("Form submitted: "+driver.findElement(By.xpath("//div[@class=\"sweet-alert showSweetAlert visible\"]/h2")).getText());
	    driver.findElement(By.xpath("//button[text()=\"OK\"]")).click();
	    driver.findElement(By.id("backmain")).click();

	}

}
