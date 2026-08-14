package Bytzsoft;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CRSExcelURL {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
    }

    @DataProvider(name = "clientUrls")
    public Object[][] getData() throws IOException {

        String excelPath = "D:/Selenium/TestData/ClientURLs.xlsx";

        FileInputStream fis = new FileInputStream(excelPath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheetAt(0);

        List<Object[]> data = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

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

    @Test(dataProvider = "clientUrls")
    public void testClientLogin1(String url)
            throws InterruptedException, IOException {

        try {

            System.out.println("====================================");
            System.out.println("Launching URL : " + url);
            System.out.println("====================================");

            driver.get(url);

            loginPage.login("btpladmin", "8ytzadmin");

            Thread.sleep(2000);

            System.out.println("Login Successful : " + url);

            loginPage.logout();

            Thread.sleep(2000);

        } catch (Exception e) {

            System.out.println("Failed URL : " + url);
            System.out.println("Reason : " + e.getMessage());

        }
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}