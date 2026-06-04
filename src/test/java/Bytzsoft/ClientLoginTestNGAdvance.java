package Bytzsoft;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ClientLoginTestNGAdvance {

    ConfigLoader config = new ConfigLoader();
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
    }

    @DataProvider(name = "client.urls")//    @DataProvider(name = "client.urls", parallel = true)
    public Object[][] getData() {
        String[] urls = config.getClientUrls();
        Object[][] data = new Object[urls.length][1];

        for (int i = 0; i < urls.length; i++) {
            data[i][0] = urls[i].trim();
        }
        return data;
    }

    @Test(dataProvider = "client.urls")
    public void testClientLogin(String url) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        driver.get(url);

        loginPage.login(config.getUsername(), config.getPassword());
        System.out.println("*** Login success for: " + url + " ***");

        loginPage.logout();
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
