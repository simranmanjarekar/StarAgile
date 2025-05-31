package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class WriteToExcel1 {
	String path="ExcelFiles/FriendsData.xlsx";
	File file;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	int index=0;
	
  @Test(dataProvider="data")
  public void writeExcel(String username, String password) {
	  row=sheet.createRow(index);
	  cell=row.createCell(0);
	  cell.setCellValue(username);
	  cell=row.createCell(1);
	  cell.setCellValue(password);
	  cell=row.createCell(2);
	  cell.setCellValue("Not Run");
	  index++;
  }
  
  @DataProvider
  public Object[][] data(){
	  return new Object[][] {
//		{"User Name","Password","Result"},
		{"admin","admin123"},
		{"pratiksha","prati123"},
		{"simran","simran123"},
		{"Raj","Raj123"},
	  };
  }
  @BeforeTest
  public void beforeTest() throws FileNotFoundException {
	  file=new File(path);
	  fos=new FileOutputStream(file);
	  wb=new XSSFWorkbook();
	  sheet=wb.createSheet("Friends Data");
	  sheet.createRow(index).createCell(0).setCellValue("Username");
	  sheet.getRow(index).createCell(1).setCellValue("Password");
	  sheet.getRow(index).createCell(2).setCellValue("Result");
	  index++;
  }

  @AfterTest
  public void afterTest() throws IOException {
	  wb.write(fos);
	  wb.close();
	  fos.close();
  }

}
