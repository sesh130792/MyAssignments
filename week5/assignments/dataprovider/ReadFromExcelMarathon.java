package marathon.testng.dataprovider;

import java.io.IOException;


import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcelMarathon {

	public static String[][] readExcel(String path) throws IOException {
		XSSFWorkbook book = new XSSFWorkbook(path);
		XSSFSheet sheet1 = book.getSheet("Sheet1");
		int rows = sheet1.getLastRowNum();
		int columns = sheet1.getRow(0).getLastCellNum();
		String data[][] = new String[rows][columns];

		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j < columns; j++) {
				XSSFRow row = sheet1.getRow(i);
				XSSFCell cell = row.getCell(j);
				cell.setCellType(CellType.STRING);
				data[i - 1][j] = cell.getStringCellValue();
			}
		}
		book.close();

		return data;
	}
}
