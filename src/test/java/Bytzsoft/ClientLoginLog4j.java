package Bytzsoft;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ClientLoginLog4j {
    WebDriver driver;
    LoginPage loginPage;
    ConfigLoader config;

    // Initialize Log4j logger
    private static final Logger logger = LogManager.getLogger(ClientLoginLog4j.class);

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        config = new ConfigLoader(); // load URLs, username, password
        logger.info("Setup completed. Browser launched.");
    }

    // DataProvider that reads URLs from config loader
    @DataProvider(name = "clientUrls")
    public Object[][] getData() {
        String[] urls = config.getClientUrls();
        Object[][] data = new Object[urls.length][1];
        for (int i = 0; i < urls.length; i++) {
            data[i][0] = urls[i];
        }
        logger.info("DataProvider prepared with {} URLs.", urls.length);
        return data;
    }

    @Test(dataProvider = "clientUrls")
    public void testClientLogin(String url) throws InterruptedException, IOException {
        logger.info("Navigating to URL: {}", url);
        driver.get(url);

        try {
            loginPage.login(config.getUsername(), config.getPassword());
            logger.info("Login successful for URL: {}", url);
        } catch (Exception e) {
            logger.error("Login failed for URL: {}", url, e);
        }

        try {
            loginPage.logout();
            logger.info("Logout successful for URL: {}", url);
        } catch (Exception e) {
            logger.warn("Logout may have failed for URL: {}", url, e);
        }

        Thread.sleep(500); // ideally use WebDriverWait instead
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed successfully.");
        }
    }
}
