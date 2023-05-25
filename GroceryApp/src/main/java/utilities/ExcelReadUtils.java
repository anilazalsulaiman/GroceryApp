package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadUtils {
	public static FileInputStream obj1;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;

	public static String readStringData(int i, int j,String sheetName,String excelFileName) throws IOException {
		obj1 = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\ExcelReadWrite\\"+excelFileName+"");
		wb = new XSSFWorkbook(obj1);
		sheet = wb.getSheet(sheetName);

		Row r = sheet.getRow(i);
		Cell c = r.getCell(j);
		return c.getStringCellValue();
	}

}
