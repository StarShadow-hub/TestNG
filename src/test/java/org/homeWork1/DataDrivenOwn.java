package org.homeWork1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenOwn {
	
	public static void main(String[] args) throws IOException {
	
		File file = new File("C:\\Users\\Vijai\\eclipse-workspace\\TestNgProject\\ExcelDatas\\Excell.xlsx");
		FileInputStream input = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(input);
		Sheet sheet = book.getSheet("Sheet1");
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				switch (cellType) {
				case STRING:
					String scv = cell.getStringCellValue();
					System.out.println(scv);
					break;
					
				case NUMERIC:
					if(DateUtil.isCellDateFormatted(cell)) {
						Date dcv = cell.getDateCellValue();
						SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
						String format = date.format(dcv);
						System.out.println(format);
					}else {
						double ncv = cell.getNumericCellValue();
						long round = Math.round(ncv);
						String valueOf = String.valueOf(round);
						System.out.println(valueOf);
					}

				default:
					break;
				}
				
			}
			
		}
		
		
		
	}
	
	

}
