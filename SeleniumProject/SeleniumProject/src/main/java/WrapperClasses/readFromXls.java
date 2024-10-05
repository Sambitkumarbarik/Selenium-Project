package WrapperClasses;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.IOException;

public class readFromXls {
	private static Workbook workbook;
    private static Sheet sheet;

    // Load Excel file
    public static void loadExcelFile(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheetAt(0); // Assume credentials are on the first sheet
    }

    // Get data from specific cell
    public static String getCellData(int rowNum, int colNum) {
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);
        return cell.getStringCellValue();
    }
}