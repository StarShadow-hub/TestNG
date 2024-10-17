package org.homeWork1;

import java.io.File;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenWrite {
	public static void main(String[] args) {
		File file = new File("C:\\Users\\Vijai\\eclipse-workspace\\TestNgProject\\ExcelDatas\\write.xlsx");
		Workbook book = new XSSFWorkbook();
		Sheet sheet = book.createSheet("Vijay");
		Row row = sheet.createRow(0);
		
	}

}
