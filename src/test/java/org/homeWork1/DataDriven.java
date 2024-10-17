package org.homeWork1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.classfile.instruction.SwitchCase;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.asynchttpclient.util.DateUtils;

import io.cucumber.java.it.Date;

public class DataDriven {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Vijai\\eclipse-workspace\\TestNgProject\\ExcelDatas\\Excell.xlsx");
		FileInputStream input = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(input);
		Sheet sheet = book.getSheet("Sheet1");
		for (int i = 0; i <sheet.getPhysicalNumberOfRows() ; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				String value = null;
				switch(cellType) {
				case STRING:
					value = cell.getStringCellValue();
					System.out.println(value);
					break;
					
				case NUMERIC:
				if(DateUtil.isCellDateFormatted(cell)) {
					java.util.Date dcv = cell.getDateCellValue();
					SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
					value = date.format(dcv);
					System.out.println(value);
				}else {
					double numericCellValue = cell.getNumericCellValue();
					long round = Math.round(numericCellValue);
					value = String.valueOf(round);
					System.out.println(value);
					break;
				}
				default:
				break;
				
					
					
				}
			}
		}
		
	}
}
