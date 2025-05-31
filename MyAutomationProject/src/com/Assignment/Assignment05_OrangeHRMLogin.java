package com.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment05_OrangeHRMLogin {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(("Admin"));
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(("admin123"));
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        driver.findElement(By.xpath("//span[text()=\"PIM\"]")).click();
        driver.findElement(By.xpath("//i[@class=\"oxd-icon bi-plus oxd-button-icon\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"firstName\"]")).sendKeys("Ritu");
        driver.findElement(By.xpath("//input[@name=\"middleName\"]")).sendKeys("Audumbar");
        driver.findElement(By.xpath("//input[@name=\"lastName\"]")).sendKeys("Manjarekar");
        driver.findElement(By.xpath("//span[@class=\"oxd-switch-input oxd-switch-input--active --label-right\"]")).click();
        driver.findElement(By.xpath("(//div[@class=\"orangehrm-employee-form\"]//input[@class=\"oxd-input oxd-input--active\"])[2]")).sendKeys("Vinod1");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@type=\"password\"])[1]")).sendKeys("vinod1234");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@type=\"password\"])[2]")).sendKeys("vinod1234");
//        driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]")).click();
       JavascriptExecutor js= (JavascriptExecutor)driver;
       WebElement save=driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]"));
       js.executeScript("window.scrollBy(0,500)","");
       js.executeScript("arguments[0].click()", save);
//       Thread.sleep(1000);
//       boolean savebtn=driver.findElement(By.xpath("//p[text()=\"Successfully Updated\"]")).isDisplayed();
//       System.out.println(savebtn);
       Thread.sleep(3000);
       driver.findElement(By.xpath("//i[contains(@class,\"oxd-userdropdown-icon\")]")).click();
        driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(("Vinod1"));
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(("vinod1234"));
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        String empname=driver.findElement(By.xpath("//p[@class=\"oxd-userdropdown-name\"]")).getText();
        System.out.println(empname);
        driver.findElement(By.xpath("//span[text()=\"My Info\"]")).click();
        Thread.sleep(3000);
        String empID=driver.findElement(By.xpath("//label[text()=\"Employee Id\"]/following::div/input")).getAttribute("value");
        System.out.println(empID);
        driver.findElement(By.xpath("//i[contains(@class,\"oxd-userdropdown-icon\")]")).click();
        driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(("Admin"));
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(("admin123"));
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        driver.findElement(By.xpath("//span[text()=\"Admin\"]")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("(//button[@class=\"oxd-icon-button\"])[2]")).click();
        driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]")).sendKeys("Vinod1");
        driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]")).click();
	    driver.findElement(By.xpath("(//button[@class=\"oxd-icon-button oxd-table-cell-action-space\"]/i)[1]")).click();
	    driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin\"]/i")).click();	
	    driver.findElement(By.xpath("//i[contains(@class,\"oxd-userdropdown-icon\")]")).click();
	    driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();
	    System.out.println("Account deleted successfully");
	}
}
