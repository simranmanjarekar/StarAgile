package com.TestSuite;

import org.testng.annotations.Test;

import com.pages.HomePage;

public class BaseTest extends MyHooks {

	
  @Test(priority=0)
  public void registerUser() throws InterruptedException {
	  hPage.registerUser(); 
//	  Thread.sleep(1000);
  }
  
  @Test(priority=1)
  public void loginUser() throws InterruptedException
  {
	  hPage.loginUser();
//	  Thread.sleep(1000);
  }
  
  @Test(priority=2)
  public void addToCart() throws InterruptedException
  {
	  hPage.addToCart();
//	  Thread.sleep(1000);
  }
  
  @Test(priority=3)
  public void checkOut() throws InterruptedException
  {
	  hPage.checkOut();
//	  Thread.sleep(1000);
  }
  
  
}
