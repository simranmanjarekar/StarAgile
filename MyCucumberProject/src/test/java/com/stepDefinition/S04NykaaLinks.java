package com.stepDefinition;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class S04NykaaLinks {
	
	WebDriver driver;
	JavascriptExecutor js;
	Set<String> windows;
	String win1, win2;
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
	
	@Given("Launch Nykaa {string}")
	public void launch_nykaa(String url) {
	    driver.get(url);
	}

	@When("Click on Skin link")
	public void click_on_skin_link() {
	    driver.findElement(By.linkText("Skin")).click();
	    windows=driver.getWindowHandles();
	    Iterator<String> itr=windows.iterator();
	    win1=itr.next();
	    win2=itr.next();
	    driver.switchTo().window(win2);
	}

	@Then("Skin page should display")
	public void skin_page_should_display() {
	   Assert.assertTrue(driver.getCurrentUrl().contains("skin"));
	}

	@When("Click mom and baby link")
	public void click_mom_and_baby_link() {
		driver.findElement(By.linkText("Mom & Baby")).click();
		windows=driver.getWindowHandles();
	    Iterator<String> itr=windows.iterator();
	    win1=itr.next();
	    win2=itr.next();
	    driver.switchTo().window(win2);
	}

	@Then("Mom and baby page should display")
	public void mom_and_baby_page_should_display() {
		Assert.assertTrue(driver.getCurrentUrl().contains("mom-and-baby"));
	}

	@When("Click on Men link")
	public void click_on_men_link() {
		driver.findElement(By.linkText("Men")).click();
		windows=driver.getWindowHandles();
	    Iterator<String> itr=windows.iterator();
	    win1=itr.next();
	    win2=itr.next();
	    driver.switchTo().window(win2);
	}

	@Then("Men page should display")
	public void men_page_should_display() {
		Assert.assertTrue(driver.getCurrentUrl().contains("men"));
	}

}
