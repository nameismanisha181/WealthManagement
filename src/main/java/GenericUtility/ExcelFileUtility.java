package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelFileUtility {

	public String getDataFromExcel(String sheetName,int row ,int column) throws IOException
	{
		FileInputStream fis = new FileInputStream("./testData/TestDataVtiger.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		XSSFRow rowN = sheet.getRow(row);
		
		XSSFCell colN = rowN.getCell(column);
		
		String value = colN.getStringCellValue();
		
		return value;			
				
	}
	
	public XSSFCell getDataFromExcel1(String sheetName,int row ,int column) throws IOException
	{
		FileInputStream fis = new FileInputStream("./testData/TestDataVtiger.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		XSSFRow rowN = sheet.getRow(row);
		
		XSSFCell colN = rowN.getCell(column);
		
		return colN;		
	}
}
