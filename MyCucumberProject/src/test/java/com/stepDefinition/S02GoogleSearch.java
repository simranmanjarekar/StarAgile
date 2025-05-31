package com.stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class S02GoogleSearch {
	WebDriver driver;
	
	@Given("I will Launch Google")
	public void i_will_launch_google() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.co.in/");
	}

	@When("Enter text into search box")
	public void enter_text_into_search_box() {
	    driver.findElement(By.name("q")).sendKeys("Chhava movie");
	}

	@When("Hit enter")
	public void hit_enter() {
	    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("Expected search result should display")
	public void expected_search_result_should_display() {
	    System.out.println(driver.getTitle());
	}

}
