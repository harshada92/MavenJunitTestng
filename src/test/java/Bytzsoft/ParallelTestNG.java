package Bytzsoft;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ParallelTestNG {

    ConfigLoader config = new ConfigLoader();

    @DataProvider(name = "client.urls", parallel = true)
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
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);

        driver.get(url);
        loginPage.login(config.getUsername(), config.getPassword());

        // ASSERT SUCCESS
        Assert.assertTrue(driver.getPageSource().contains("Dashboard"),
                "Login Failed for: " + url);

        System.out.println("*** Login success for: " + url + " ***");

        loginPage.logout();
        driver.quit();
}
}
