package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class WriteToExcel {
	File file;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
  @Test
  public void writeData() {
	  row=sheet.createRow(0);
	  cell=row.createCell(0);
	  cell.setCellValue("Aman");
  }
  @BeforeTest
  public void beforeTest() throws FileNotFoundException {
	  file=new File("ExcelFiles/MyFirstExcelFile.xlsx");
	  fos=new FileOutputStream(file);
	  wb=new XSSFWorkbook();
	  sheet=wb.createSheet("My first sheet");
  }

  @AfterTest
  public void afterTest() throws IOException {
	  wb.write(fos);
	  wb.close();
	  fos.close();
  }

}
