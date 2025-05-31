package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class ReadNumericData {
	String path="ExcelFiles/NumericData.xlsx";
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
  @Test
  public void readData() {
	  int rows=sheet.getPhysicalNumberOfRows();
	  int cells=sheet.getRow(0).getPhysicalNumberOfCells();
	  for(int i=0;i<rows;i++)
	  {
		  
		  for(int j=0;j<cells;j++)
		  {
			cell=sheet.getRow(i).getCell(j); 
			switch (cell.getCellType()) {
            case STRING:
//            	if (cell == null || cell.getCellType().equals("BLANK"))
//              System.out.println("This cell is blank.");
//            	else
                System.out.println("Cell contains a string: " + cell.getStringCellValue());
                break;
            case NUMERIC:
            	if (DateUtil.isCellDateFormatted(cell)) {
                    // If it's a date, format it properly
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                    System.out.println("Date Value: " + dateFormat.format(cell.getDateCellValue()));
                } else {
                	double numericValue = cell.getNumericCellValue();
                    // Check if it should be an integer, float, or double
                    if (numericValue == (int) numericValue) {
                        System.out.println("Integer Value: " + (int) numericValue);
                    } else {
                        System.out.println("Double Value: " + numericValue);
                    }
                }
                break;
            case BOOLEAN:
                System.out.println("Cell contains a boolean: " + cell.getBooleanCellValue());
                break;
            case FORMULA:
                System.out.println("Cell contains a formula: " + cell.getCellFormula());
                break;
            
//            case BLANK:
//            	if (cell == null && cell.getCellType() == CellType.BLANK)
//                System.out.println("This cell is blank.");
//                break;
            default:
                System.out.println("Unknown cell type");
        }
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
