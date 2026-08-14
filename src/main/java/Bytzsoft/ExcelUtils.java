package Bytzsoft;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static Object[][] getExcelData(String filePath, String sheetName)
            throws Exception {

        FileInputStream fis = new FileInputStream(filePath);

        Workbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount - 1][1];

        for (int i = 1; i < rowCount; i++) {

            data[i - 1][0] =
                    sheet.getRow(i).getCell(0).getStringCellValue();

        }

        workbook.close();
        fis.close();

        return data;
    }
}