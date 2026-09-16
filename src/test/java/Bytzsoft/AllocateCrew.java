import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllocateCrew {

    WebDriver driver;
    LoginAllocation loginPage;

    @BeforeTest
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginAllocation(driver);
    }

    @Test
    public void loginTest() {

        driver.get("https://www.bytzsoft.net/CrewRostering/Login.aspx");

        loginPage.login("admin2", "admin2");

        // Continue with Crew Allocation steps
    }

    @AfterTest
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}