package com.TestSuite;

import org.testng.annotations.Test;

import com.pages.LoginPage;

public class OHRM_PomModel extends MyHooks{
	
	
	
  @Test(priority=0)
  public void CheckLogin() throws InterruptedException {
	  page.enterUsername("Admin");
	  page.enterPassword("admin123");
	  page.clickOnLogin();
	  //lPage.validateLogin();
  }
  
  @Test(priority=1)
  public void printSideMenusandCount() {
	 aPage.printLeftMenuOptions(); 
  }
  
  @Test(priority=2)
  public void byUserName() {
	  aPage.existingEmployeeSearchByUserName();
  }
  
  @Test(priority=3)
  public void byUserRole() {
	  aPage.existingEmployeeSearchByUserRole();
  }
  
  @Test(priority=4)
  public void byUserStatus() {
	  aPage.existingEmployeeSearchByUserStatus();
  }
}
	