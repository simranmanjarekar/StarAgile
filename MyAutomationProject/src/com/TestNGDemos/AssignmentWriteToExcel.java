package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class AssignmentWriteToExcel {
	String path="ExcelFiles\\FriendsDetailedData.xlsx";
	File file;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	int index=0;
  
  @Test(dataProvider="data")
  public void writeExcel(Integer sr_no, String first_name, String last_name, String Gender, String Address, Long Phone_no) {
	  row=sheet.createRow(index);
	  cell=row.createCell(0);
	  cell.setCellValue(sr_no);
	  cell=row.createCell(1);
	  cell.setCellValue(first_name);
	  cell=row.createCell(2);
	  cell.setCellValue(last_name);
	  cell=row.createCell(3);
	  cell.setCellValue(Gender);
	  cell=row.createCell(4);
	  cell.setCellValue(Address);
	  cell=row.createCell(5);
	  cell.setCellValue(Phone_no);
	  index++;
  }
  @DataProvider
  public Object[][] data(){
	  return new Object[][] {
		{1,"admin","adminM","male","khareast",2468189112l},
		{2,"pratiksha","pratiL","Female","khareast",2468189112l},
		{3,"simran","manjarekar","female","khareast",2468189112l},
		{4,"Raj","sakpal","male","khareast",2468189112l},
	  };
  }
  @BeforeTest
  public void beforeTest() throws IOException {
	  file=new File(path);
	  fos=new FileOutputStream(file);
	  wb=new XSSFWorkbook();
	  sheet=wb.createSheet("Friends Data");
	  sheet.createRow(index).createCell(0).setCellValue("Sr.No.");
	  sheet.getRow(index).createCell(1).setCellValue("First Name");
	  sheet.getRow(index).createCell(2).setCellValue("Last Name");
	  sheet.getRow(index).createCell(3).setCellValue("Gender");
	  sheet.getRow(index).createCell(4).setCellValue("Address");
	  sheet.getRow(index).createCell(5).setCellValue("Phone No");
	  index++;
  }

  @AfterTest
  public void afterTest() throws IOException {
	  wb.write(fos);
	  wb.close();
	  fos.close();
  }

}
