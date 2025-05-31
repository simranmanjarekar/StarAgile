package com.stepDefinition;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class S05DemoQA {
     public static WebDriver driver;
	JavascriptExecutor js;
	
	@Before
	public void launch_Browser()
	{
		if(driver==null) {
		this.driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	}
	
	@After
	public void tearDown()
	{
		if(driver!=null) {
		driver.quit();
		driver=null;
		}
	}
	
	@Given("Launch DemoQA {string}")	
	public void launch_demo_qa(String url) {
		
	    driver.get(url);
	    js=(JavascriptExecutor) driver;
	}

	@When("Fill out the form with valid data as follows")
	public void fill_out_the_form_with_valid_data_as_follows(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String,String>> data=dataTable.asMaps();
        for(Map<String,String> d:data) {
        	driver.findElement(By.id("firstName")).sendKeys(d.get("First Name"));
        	driver.findElement(By.id("lastName")).sendKeys(d.get("Last Name"));
        	driver.findElement(By.id("userEmail")).sendKeys(d.get("Email"));
        	if(d.get("Gender").equals("Male")) {
        		js.executeScript("arguments[0].click();", driver.findElement(By.id("gender-radio-1")));
        	}else if(d.get("Gender").equals("Female"))
        	{
        		js.executeScript("arguments[0].click();",driver.findElement(By.id("gender-radio-2")));
        	}else if(d.get("Gender").equals("Other"))
        	{
        		driver.findElement(By.id("gender-radio-3")).click();
        	}
        	driver.findElement(By.id("userNumber")).sendKeys(d.get("Mob No"));
        	WebElement date=driver.findElement(By.id("dateOfBirthInput"));
    		date.sendKeys(Keys.CONTROL+"A");        	
        	date.sendKeys(d.get("DOB"));
        	date.sendKeys(Keys.ENTER);
        	js.executeScript("window.scrollBy(0,500);", "");
        	if(d.get("Hobbies").equals("Sports")) {
        		js.executeScript("arguments[0].click();",driver.findElement(By.id("hobbies-checkbox-1")));
        	}else if(d.get("Hobbies").equals("Reading"))
        	{
        		js.executeScript("arguments[0].click();",driver.findElement(By.id("hobbies-checkbox-2")));
        	}else if(d.get("Hobbies").equals("Music"))
        	{
        		js.executeScript("arguments[0].click();",driver.findElement(By.id("hobbies-checkbox-3")));
        	}
        	driver.findElement(By.id("currentAddress")).sendKeys(d.get("Address"));
        }
	}

	@When("Click on Submit")
	public void click_on_submit() {
		driver.findElement(By.xpath("//button[@id=\"submit\"]")).click();
	}

	@Then("Registration success")
	public void registration_success() {
		WebElement successMessage = driver.findElement(By.className("modal-body"));
        Assert.assertTrue(successMessage.isDisplayed());
        driver.quit();
	}
	
}
