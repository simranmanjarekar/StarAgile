package com.stepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class S06ExpandTestingMultiple {
	WebDriver driver;
	JavascriptExecutor js;
//	@Before
//    public void launch_expand_testing() {
//	    driver=new ChromeDriver();
//	    driver.manage().window().maximize();
//	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	    js=(JavascriptExecutor) driver;
//	}
	
	@After
	public void closeBrowser() {
	driver.quit();	
	}
	@Given("Expand testing UI should be opened {string}")
	public void expand_testing_ui_should_be_opened(String url) {
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  js=(JavascriptExecutor) driver;
	  driver.get(url);
	}

	@When("Enter username as {string} and password as {string}")
	public void enter_username_as_and_password_as(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		
	}

	@Then("Login should pass")
	public void login_should_pass() throws InterruptedException {
		js.executeScript("window.scrollBy(0,800);", "");
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[text()=\"Login\"]")));
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("secure"));
		System.out.println(driver.findElement(By.xpath("//div[@id=\"flash\"]/b")).getText());
	}

}
