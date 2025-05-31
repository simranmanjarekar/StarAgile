package com.stepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class S01GoogleTitle {
	WebDriver driver;
	String title;
	
	@Given("Launch Google")
	public void launch_google() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.co.in/");
	}

	@When("Read the title")
	public void read_the_title() {
	    title=driver.getTitle();
	}

	@Then("Title should be Google")
	public void title_should_be_google() {
		System.out.println("Title:" +title);
	    Assert.assertEquals(title,"Google");
	}


}
