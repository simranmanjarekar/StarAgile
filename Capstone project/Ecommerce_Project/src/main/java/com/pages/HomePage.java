package com.pages;



import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Factory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy (id="signin2") WebElement SignUp;
	@FindBy (id="sign-username") WebElement username;
    @FindBy (id="sign-password") WebElement password;
    @FindBy (xpath="//button[text()='Sign up']") WebElement signUpBtn;
    @FindBy (id="login2") WebElement login;
    @FindBy (id="loginusername") WebElement lusername;
    @FindBy (id="loginpassword") WebElement lpassword;
    @FindBy (xpath="//button[text()='Log in']") WebElement loginBtn;
    @FindBy (xpath="//a[@id='nameofuser'][contains(text(),'Welcome')]") WebElement welcomeText;
    @FindBy (xpath="//a[text()='Samsung galaxy s6']") WebElement Samsung;
    @FindBy (xpath="//a[text()='Add to cart']") WebElement addToCart;
    @FindBy (id="cartur") WebElement cartBtn;
    @FindBy (xpath="//button[text()='Place Order']") WebElement placeOrderBtn;
    @FindBy (id="name") WebElement name;
    @FindBy (id="country") WebElement country;
    @FindBy (id="city") WebElement city;
    @FindBy (id="card") WebElement card;
    @FindBy (id="month") WebElement month;
    @FindBy (id="year") WebElement year;
    @FindBy (xpath="//button[text()='Purchase']") WebElement purchase;
    @FindBy (xpath="//h2[text()='Thank you for your purchase!']") WebElement purchased;
    @FindBy (xpath="//button[text()='OK']") WebElement okBtn;
    @FindBy (xpath="//a[text()='Log out']") WebElement logoutBtn;
    @FindBy (xpath="//button[text()='Purchase']/preceding-sibling::button[text()='Close']") WebElement closeBtn;
    
    public HomePage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    	wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public void registerUser() {
    	SignUp.click();
    	username.sendKeys("Simran005");
    	password.sendKeys("simran@1224");
    	signUpBtn.click();   	
    	validateAlert("Sign up successful.");
    }
    
    public void loginUser() {
    	
    	login.click();
    	wait.until(ExpectedConditions.elementToBeClickable(lusername));
    	lusername.sendKeys("Simran005");
    	lpassword.sendKeys("simran@1224");
    	loginBtn.click();
    	Assert.assertTrue(welcomeText.isDisplayed(),"User logged in successfully");
    }
    
    public void addToCart() {
    	Samsung.click();
    	addToCart.click();
    	validateAlert("Product added.");
    }
    
    public void validateAlert(String expectedAlertText) {
    	try {
    	    wait.until(ExpectedConditions.alertIsPresent());
    	    Alert a = driver.switchTo().alert();
    	    String actualAlertText = a.getText();
    	    Assert.assertEquals(actualAlertText, expectedAlertText, "Alert text is incorrect");
    	    a.accept();
    	} catch (TimeoutException e) {
    	    Assert.fail("Alert was not displayed in time.");
    	}
    }
    	
    	public void checkOut() {
    		cartBtn.click();
    		placeOrderBtn.click();
    		name.sendKeys("Simran");
    		country.sendKeys("India");
    		city.sendKeys("Mumbai");
    		card.sendKeys("1234123412341234");
    		month.sendKeys("May");
    		year.sendKeys("2025");
    		purchase.click();
    		Assert.assertTrue(purchased.isDisplayed(),"Product purchased successfully");
    		okBtn.click();
    		closeBtn.click();
    		logoutBtn.click();
    	}
    
}
