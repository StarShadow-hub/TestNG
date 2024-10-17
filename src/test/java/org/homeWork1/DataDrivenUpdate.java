package org.homeWork1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenUpdate {
	public static void main(String[] args) throws IOException {
		File file= new File("C:\\Users\\Vijai\\eclipse-workspace\\TestNgProject\\ExcelDatas\\Excell.xlsx");
		FileInputStream input = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(input);
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(0);
		String scv = cell.getStringCellValue();
		if(scv.equals("kumar")) {
			cell.setCellValue("vijay");
		}else {
			System.out.println("invalid data");
		}
		
		FileOutputStream out = new FileOutputStream(file);
		book.write(out);
		
		
	}}

