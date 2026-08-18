package Bytzsoft;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    private String excelPath;

    public ExcelReader(String excelPath) {
        this.excelPath = excelPath;
    }

    public Object[][] getUrlsData() throws Exception {

        FileInputStream fis = new FileInputStream(excelPath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheetAt(0);

        List<Object[]> data = new ArrayList<>();

        for (int i = 0; i <= sheet.getLastRowNum(); i++) {

            Row row = sheet.getRow(i);

            if (row != null && row.getCell(0) != null) {

                String url = row.getCell(0).getStringCellValue().trim();

                if (!url.isEmpty()) {
                    data.add(new Object[] { url });
                }
            }
        }

        workbook.close();
        fis.close();

        return data.toArray(new Object[0][]);
    }
}