package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelRead {
	public static File file;
	public static InputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileOutputStream fos;
	public static int index = 1;
	public static XSSFCellStyle style;
	public static XSSFFont font;

	@DataProvider
	public Object[][] readExcel() throws IOException {
		file = new File("ExcelFile/LoginData.xlsx");
		fis = new FileInputStream(file);
		// fis
		// =getClass().getClassLoader().getResourceAsStream("ExcelFile/LoginData.xlsx");
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);
		int rows = sheet.getPhysicalNumberOfRows();
		System.out.println(rows);
		int cells = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(cells);
		Object[][] o = new Object[rows - 1][cells];
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < cells; j++) {
				o[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return o;
	}

	public void writeToExcel(String result, boolean isPass) throws IOException {

		file = new File("ExcelFile/LoginData.xlsx");

	    // Step 1: Open for reading FIRST
//	    fis = new FileInputStream(file);
//	    wb = new XSSFWorkbook(fis);
//	    fis.close(); // Close immediately after reading

	    // Step 2: Access sheet and cell
	    sheet = wb.getSheetAt(0);
	    if (sheet.getRow(0).getCell(2) == null) {
	        sheet.getRow(0).createCell(2).setCellValue("Result");
	    }

	    row = sheet.getRow(index);
	    if (row == null) row = sheet.createRow(index);

	    cell = row.getCell(2);
	    if (cell == null) cell = row.createCell(2);

	    cell.setCellValue(result);

	    // Step 3: Apply formatting
	    style = wb.createCellStyle();
	    font = wb.createFont();
	    font.setBold(true);
	    font.setColor(isPass ? HSSFColorPredefined.GREEN.getIndex() : HSSFColorPredefined.RED.getIndex());
	    if (!isPass) font.setStrikeout(true);
	    style.setFont(font);
	    cell.setCellStyle(style);

	    // Step 4: Write back to file
	    fos = new FileOutputStream(file);
	    wb.write(fos);
	    fos.close();

	    index++;
	}

//	public static void initWorkbook() throws IOException {
//	    file = new File("ExcelFile/LoginData.xlsx");
//
//	    // If file doesn't exist or is empty, initialize it properly
//	    if (!file.exists() || file.length() == 0) {
//	        wb = new XSSFWorkbook();
//	        sheet = wb.createSheet("Results");
//
//	        // Create a header row (optional but recommended)
//	        XSSFRow header = sheet.createRow(0);
//	        header.createCell(0).setCellValue("Username");
//	        header.createCell(1).setCellValue("Password");
//	        header.createCell(2).setCellValue("Result");
//
//	        try (FileOutputStream fos = new FileOutputStream(file)) {
//	            wb.write(fos); // Save the empty but valid workbook
//	        }
//	    } else {
//	        try (FileInputStream fis = new FileInputStream(file)) {
//	            wb = new XSSFWorkbook(fis);
//	            sheet = wb.getSheetAt(0);
//	        }
//	    }
//	}

}
