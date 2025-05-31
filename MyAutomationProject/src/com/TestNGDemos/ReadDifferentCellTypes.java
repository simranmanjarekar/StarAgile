package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class ReadDifferentCellTypes {
	File file;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	int index=0;
	FileInputStream fis;
  @Test(priority=0,dataProvider="data")
  public void writeDifferentCellTypes(Object obj) {
	  cell=sheet.createRow(index).createCell(0);
	  if (obj instanceof Date) {
		  CellStyle cellStyle = wb.createCellStyle();
		  XSSFCreationHelper createHelper = wb.getCreationHelper();
		  cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("MM-dd-yyyy"));
//		  cell = row.createCell(1);
		  cell.setCellValue((Date)obj);
		  cell.setCellStyle(cellStyle);
      } else if (obj instanceof String) {
          cell.setCellValue((String) obj);
      } else if (obj instanceof Integer) {
          cell.setCellValue((Integer) obj);
      } else if (obj instanceof Boolean) {
          cell.setCellValue((Boolean) obj);
      } else if (obj instanceof Double) {
          cell.setCellValue((Double) obj);
      }
	  index++;
  }
  @Test(priority=1)
  public void readDifferentCellTypes() {
	  int rows=sheet.getPhysicalNumberOfRows();
	  int cells=sheet.getRow(0).getPhysicalNumberOfCells();
	  for(int i=0;i<rows;i++) {
		  for(int j=0;j<cells;j++)
		  {
			  cell=sheet.getRow(i).getCell(j);
			  switch(cell.getCellType()) {
			  case STRING:
				  System.out.println("String: "+cell.getStringCellValue());
				  break;
			  case NUMERIC:
			       if(DateUtil.isCellDateFormatted(cell)) {
			    	   SimpleDateFormat date=new SimpleDateFormat("MM-dd-yyyy");
			    	   System.out.println("Date: "+date.format(cell.getDateCellValue()));
			       }else {
			    	   double numericvalue= cell.getNumericCellValue();
			    	   if(numericvalue==(int)numericvalue)
			    	   {
			    		   System.out.println("integer: "+(int)numericvalue);
			    	   }
			    	   else {
			    		   
			    		   System.out.println("double: "+ numericvalue);
			    	   }
			       }
			       break;
			  case BOOLEAN: 
				  System.out.println("Boolean: "+cell.getBooleanCellValue());
			      break;
			  case FORMULA:
				  System.out.println("Boolean: "+cell.getCellFormula());
			      break;
			  default:
				  System.out.println("Unknown cell type");
			  }
		  }
	  }
  }
  @BeforeTest
  public void beforeTest() throws FileNotFoundException {
	  file=new File("ExcelFiles/ReadDifferentCellTypes.xlsx");
	  fos=new FileOutputStream(file);
	  wb=new XSSFWorkbook();
	  sheet=wb.createSheet("cellTypes");
	  fis=new FileInputStream(file);
  }
  
  @DataProvider
  public Object[][] data() throws ParseException {
	  return new Object[][] {
		  {"simran"},{new SimpleDateFormat("MM-dd-yyyy").parse("05-09-1997")},{5.36829},{123},{true}
		  };
  }

  @AfterTest
  public void afterTest() throws IOException {
	  wb.write(fos);
	  wb.close();
	  fos.close();
  }

}
