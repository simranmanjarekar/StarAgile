package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ReadWriteToExcel {
	String path="ExcelFiles/FriendsData.xlsx";
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	WebDriver driver;
	FileOutputStream fos;
	int index=1;
	XSSFCellStyle style;
	XSSFFont font;
  @Test(dataProvider = "data")
  public void loginOHRM(String name, String pass) {
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click(); 
  }


  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  cell=sheet.getRow(index).getCell(2);
	  if(driver.getCurrentUrl().contains("dashboard")) {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//i[contains(@class,\"oxd-userdropdown-icon\")]")).click();
	        driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();
	        System.out.println("Test case Pass");
	        style=wb.createCellStyle();
	        font=wb.createFont();
	        font.setColor(HSSFColorPredefined.GREEN.getIndex());
	        font.setBold(true);
	        cell.setCellStyle(style);
	        cell.setCellValue("Pass");	        
		}
			else
			{
				System.out.println("Test case fail");
				font.setColor(HSSFColorPredefined.RED.getIndex());
				font.setStrikeout(true);
		        font.setBold(true);
		        cell.setCellStyle(style);
				cell.setCellValue("Fail");
			}	
	  index++;
  }


  @DataProvider
  public Object[][] data(){
	  int rows=sheet.getPhysicalNumberOfRows();
	  int cells=sheet.getRow(0).getPhysicalNumberOfCells();
	  String[][] s=new String[rows-1][cells-1];
	  for(int i=1;i<rows;i++)
	  {
		  row=sheet.getRow(i);
		  for(int j=0;j<cells-1;j++)
		  {
			  cell=row.getCell(j);
			  s[i-1][j]=cell.getStringCellValue();			  
		  }		  
	  }
	return s;
	  
  }
  @BeforeTest
  public void beforeTest() throws IOException {
	  file=new File(path);
	  fis=new FileInputStream(file);
	  wb=new XSSFWorkbook(fis);
	  sheet=wb.getSheetAt(0);
       fos=new FileOutputStream(file);
	    driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
  }

  @AfterTest
  public void afterTest() throws IOException {
	  wb.write(fos);
	  wb.close();
	  fis.close();
	  fos.close();
	  driver.close();
  }

}
