package Bytzsoft;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeadHeadFlow {

    WebDriver driver;
    LoginPage loginPage;

    private String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss")
                .format(new Date());
    }

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);

        driver.manage().window().maximize();
        driver.get("http://52.172.171.166/CRS/CrewRostering_BS/login.aspx");
    }

    @Test
    public void testClientLogin1() throws InterruptedException, IOException {

        loginPage.login("btpladmin", "8ytzadmin");

        Thread.sleep(1000);

        System.out.println("*** Login success ***");
        

        loginPage.logout();

        Thread.sleep(1000);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}