package Bytzsoft;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CRSExcelURL {

    // ============================================================
    // SETTINGS
    // ============================================================

    private static final int PAGE_LOAD_TIMEOUT = 30;

    private static final String USERNAME = "abc";
    private static final String PASSWORD = "pqr";

    private static final String EXCEL_PATH ="D:\\Selenium\\TestData\\ClientURLs.xlsx";

    private static final String SHEET_NAME = "Sheet1";


    // ============================================================
    // READ URLS FROM EXCEL
    // ============================================================

    @DataProvider(name = "clientUrls")
    public Object[][] getClientUrls() throws Exception {

        System.out.println();
        System.out.println("==============================================");
        System.out.println("READING CLIENT URLS FROM EXCEL");
        System.out.println("==============================================");

        FileInputStream file =new FileInputStream(EXCEL_PATH);

        Workbook workbook =WorkbookFactory.create(file);

        Sheet sheet =workbook.getSheet(SHEET_NAME);

        if (sheet == null) {

            workbook.close();
            file.close();

            throw new RuntimeException("Sheet '" + SHEET_NAME + "' not found in Excel.");
        }

        List<String> urls =new ArrayList<>();


        // Start from row 1 because row 0 is header

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            Row row =sheet.getRow(i);

            if (row == null) {
                continue;
            }

            Cell urlCell =row.getCell(0);

            if (urlCell == null) {
                continue;
            }

            String url = urlCell.toString().trim();

            if (!url.isEmpty()) {

                urls.add(url);

                System.out.println( "URL FOUND : " + url);
            }
        }


        workbook.close();
        file.close();


        if (urls.isEmpty()) {

            throw new RuntimeException(
                    "No client URLs found in Excel."
            );
        }


        // Convert List to Object[][]

        Object[][] data =
                new Object[urls.size()][1];

        for (int i = 0; i < urls.size(); i++) {

            data[i][0] =
                    urls.get(i);
        }


        System.out.println();
        System.out.println(
                "TOTAL CLIENTS FOUND : " + urls.size()
        );

        System.out.println(
                "=============================================="
        );

        return data;
    }


    // ============================================================
    // TEST
    // ============================================================

    @Test(dataProvider = "clientUrls")
    public void testClientLogin(String url) {

        WebDriver driver = null;

        try {

            System.out.println();
            System.out.println(
                    "=================================================="
            );

            System.out.println(
                    "STARTING CLIENT : " + url
            );

            System.out.println(
                    "=================================================="
            );


            // ====================================================
            // START NEW CHROME
            // ====================================================

            System.out.println(
                    "Starting Chrome..."
            );

            driver =
                    new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage()
                    .timeouts()
                    .pageLoadTimeout(
                            Duration.ofSeconds(
                                    PAGE_LOAD_TIMEOUT
                            )
                    );


            // ====================================================
            // CREATE LOGIN PAGE
            // ====================================================

            LoginPage1 loginPage =
                    new LoginPage1(driver);


            // ====================================================
            // OPEN CLIENT
            // ====================================================

            System.out.println(
                    "Opening client..."
            );

            driver.get(url);

            System.out.println(
                    "Client page opened."
            );


            // ====================================================
            // LOGIN
            // ====================================================

            System.out.println(
                    "Starting login..."
            );

            loginPage.login(
                    USERNAME,
                    PASSWORD
            );


            // ====================================================
            // LOGIN SUCCESS
            // ====================================================

            System.out.println();
            System.out.println(
                    "**********************************************"
            );

            System.out.println(
                    "LOGIN SUCCESS"
            );

            System.out.println(
                    "CLIENT : " + url
            );

            System.out.println(
                    "**********************************************"
            );


            // ====================================================
            // LOGOUT
            // ====================================================

            System.out.println(
                    "Logging out..."
            );

            loginPage.logout();

            System.out.println(
                    "Logout successful."
            );


            // ====================================================
            // FINAL RESULT
            // ====================================================

            System.out.println();
            System.out.println(
                    "FINAL RESULT : PASS"
            );

            System.out.println(
                    "CLIENT       : " + url
            );


        } catch (Exception e) {

            // ====================================================
            // CLIENT FAILED
            // ====================================================

            System.out.println();
            System.out.println(
                    "**********************************************"
            );

            System.out.println(
                    "CLIENT FAILED"
            );

            System.out.println(
                    "CLIENT : " + url
            );

            System.out.println(
                    "ERROR  : " + e.getMessage()
            );

            System.out.println(
                    "**********************************************"
            );


            // Mark this client as FAILED

            Assert.fail(
                    "Login failed for client: " + url,
                    e
            );


        } finally {

            // ====================================================
            // ALWAYS CLOSE BROWSER
            // ====================================================

            if (driver != null) {

                try {

                    driver.quit();

                    System.out.println(
                            "Browser closed."
                    );

                } catch (Exception e) {

                    System.out.println(
                            "Could not close browser."
                    );
                }
            }
        }
    }
}