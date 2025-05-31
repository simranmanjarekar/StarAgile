package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class ReadDataFromExcel {
	String path="ExcelFiles/FriendsData.xlsx";
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
  @Test
  public void readFromExcel() {
	  int cells=sheet.getRow(0).getPhysicalNumberOfCells();
	  System.out.println(cells);
	  for(int i=0;i<sheet.getPhysicalNumberOfRows()-1;i++) {
	  for(int j=0;j<cells;j++) {
	  System.out.println(sheet.getRow(i+1).getCell(j).getStringCellValue());
	  }  
	  }
  }
  @BeforeTest
  public void beforeTest() throws IOException {
	  file=new File(path);
	  fis=new FileInputStream(file);
	  wb=new XSSFWorkbook(fis);
	  sheet=wb.getSheetAt(0);
	  
  }
  


  @AfterTest
  public void afterTest() throws IOException {
	  wb.close();
	  fis.close();
  }

}
