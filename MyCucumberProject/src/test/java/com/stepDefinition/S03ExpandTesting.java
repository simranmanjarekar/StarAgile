package com.stepDefinition;

import java.sql.Driver;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class S03ExpandTesting {
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
	driver.close();	
	}

	@Given("Launch expand testing url {string}")
	public void launch_expand_testing_url(String url) {
	    driver.get(url);
	}
	
	@When("Enter valid username {string}")
	public void enter_valid_username(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}

	@When("Enter valid password {string}")
	public void enter_valid_password(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("Click on Login")
	public void click_on_login() {
		js.executeScript("window.scrollBy(0,800);", "");
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[text()=\"Login\"]")));
	}

	@Then("login should Pass and home page should display")
	public void login_should_pass_and_home_page_should_display() {
		Assert.assertTrue(driver.getCurrentUrl().contains("secure"));
        System.out.println(driver.findElement(By.xpath("//div[@id=\"flash\"]/b")).getText());
	}

	@When("Enter invalid username {string}")
	public void enter_invalid_username(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}

	@When("Enter invalid password {string}")
	public void enter_invalid_password(String password) {
		driver.findElement(By.id("password")).sendKeys(password); 
	}

	@When("Click on Login button")
	public void click_on_login_button() {
		js.executeScript("window.scrollBy(0,800);", "");
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[text()=\"Login\"]")));
	}

	@Then("login should fail")
	public void login_should_fail() {
		Assert.assertTrue(driver.getCurrentUrl().contains("secure"));
	}
}
