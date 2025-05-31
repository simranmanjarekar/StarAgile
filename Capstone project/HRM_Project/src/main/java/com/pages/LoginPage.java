package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	  WebDriver driver;

	    // Constructor
	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this); // Initialize elements
	    }
	@FindBy (name="username") WebElement username;
	@FindBy (name="password") WebElement password;
	@FindBy(xpath="//button[contains(@class,'orangehrm-login-button')]") WebElement loginBtn;
	String expUrl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	
	public void enterUsername(String un) {
		username.sendKeys(un);
	}

	public void enterPassword(String pw) {
		password.sendKeys(pw);
	}
	
	public void clickOnLogin() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();
		Assert.assertEquals(driver.getCurrentUrl(), expUrl ,"Login to OHRM is successfull");
		//Thread.sleep(2000);
	}
	
}
