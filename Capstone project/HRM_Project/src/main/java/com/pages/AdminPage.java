package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {
	WebDriver driver;

	// Constructor
	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize elements
	}

	@FindBy(xpath = "//span[text()='Admin']")
	WebElement AdminBtn;
	@FindBy(xpath = "//ul[@class=\"oxd-main-menu\"]//li")
	List<WebElement> SideMenus;
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement username;
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement searchBtn;
	@FindBy(xpath = "//div[@class='oxd-table-card']")
	List<WebElement> searchResultsByUN;
	@FindBy(xpath = "(//div[@class='oxd-select-text-input'])[1]")
	WebElement userRoleDropdown;
	@FindBy(xpath = "(//*[text()='Admin'])[3]")
	WebElement selectAdmin;
	@FindBy(xpath = "(//div[@class='oxd-select-text-input'])[2]")
	WebElement statusDropdown;
	@FindBy(xpath = "//*[text()='Enabled']")
	WebElement selectEnabled;

	public void printLeftMenuOptions() {
		System.out.println("Left Menu Option Count: " + SideMenus.size());
		for (WebElement option : SideMenus) {
			System.out.println(option.getText());
		}
		AdminBtn.click();
	}

	public void existingEmployeeSearchByUserName() {
		username.sendKeys("Admin");
		searchBtn.click();
		System.out.println("Total record found for existing employee(Admin) by user name: " + searchResultsByUN.size());
		driver.navigate().refresh();
	}

	public void existingEmployeeSearchByUserRole() {
		elementToBeClickable(userRoleDropdown);
		userRoleDropdown.click();
		selectAdmin.click();
		searchBtn.click();
		System.out.println("Total record found for existing employee(Admin) by user role: " + searchResultsByUN.size());
		driver.navigate().refresh();
	}

	public void existingEmployeeSearchByUserStatus() {
		elementToBeClickable(statusDropdown);
		statusDropdown.click();
		selectEnabled.click();
		searchBtn.click();
		System.out.println("Total record found for existing employee(Admin) by user status: " + searchResultsByUN.size());
		driver.navigate().refresh();
	}

	public void elementToBeClickable(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
}
