package com.stepDefinition;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class F01ExpaMultipleUser {
	WebDriver driver;
	JavascriptExecutor js;
	@Before
  public void launch_expand_testing() {
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    js=(JavascriptExecutor) driver;
	}
	@After
	public void closeBrowser() {
	driver.quit();	
	}
	@Given("Expand testing UI should be opened {string}")
	public void expand_testing_ui_should_be_opened(String url) {
		driver.get(url);
	}
	@When("Enter username as {string} and password as {string}")
	public void enter_username_as_and_password_as(String username, String password) {
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username);
		System.out.println(username);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		//js.executeScript("window.scrollBy(0,800);", "");
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[text()=\"Login\"]")));
	}


//	@When("Enter username and password as follows")
//	public void enter_username_and_password_as_follows(io.cucumber.datatable.DataTable dataTable) {
//	    List<List<String>> data=dataTable.asLists();
//	    for(List<String> d:data) {
////	    	for(String d1:d) {
//		System.out.println(d.get(0));
//		driver.findElement(By.id("username")).clear();
//		driver.findElement(By.id("username")).sendKeys(d.get(0));
//		System.out.println(d.get(1));
//		driver.findElement(By.id("password")).clear();
//		driver.findElement(By.id("password")).sendKeys(d.get(1));
//		//js.executeScript("window.scrollBy(0,800);", "");
//		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[text()=\"Login\"]")));	
//	    	}
//	}

	@Then("Home page should display")
	public void home_page_should_display() throws InterruptedException {
		
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("secure"));
		System.out.println(driver.findElement(By.xpath("//div[@id=\"flash\"]/b")).getText());
	}


}
