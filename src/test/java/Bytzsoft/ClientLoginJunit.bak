package Bytzsoft;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.TestInstance;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClientLoginJunit {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeAll
    void setupClass() {
        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
    }

    @ParameterizedTest
    @ValueSource(strings = {
    		"https://bytzsoft.net/CrewRosteringBAR/login.aspx, https://bytzsoft.net/CrewRostering7AR/login.aspx,https://bytzsoft.net/CrewRostering7AR/login.aspx, https://bytzsoft.net/CrewRosteringABR/login.aspx, https://bytzsoft.net/CrewRosteringACC/login.aspx, https://bytzsoft.net/CrewRosteringAPP/login.aspx, https://bytzsoft.net/CrewRosteringAR2/login.aspx https://bytzsoft.net/CrewRosteringABR/login.aspx, https://bytzsoft.net/CrewRosteringACC/login.aspx, https://bytzsoft.net/CrewRosteringAPP/login.aspx, https://bytzsoft.net/CrewRosteringARJ/login.aspx, https://bytzsoft.net/CrewRosteringARO/login.aspx, https://bytzsoft.net/CrewRosteringASH/login.aspx, https://bytzsoft.net/CrewRosteringBAR/login.aspx, https://bytzsoft.net/CrewRosteringBGS/login.aspx, https://bytzsoft.net/CrewRosteringBHA/login.aspx, https://www.bytzsoft.net/CrewRostering, https://bytzsoft.net/CrewRosteringCAI/login.aspx, https://bytzsoft.net/CrewRosteringCRL/login.aspx, https://bytzsoft.net/CrewRosteringDAD/login.aspx, https://bytzsoft.net/CrewRosteringDEC/login.aspx, https://bytzsoft.net/CrewRosteringDHL/login.aspx, https://bytzsoft.net/CrewRosteringDMO/login.aspx, https://bytzsoft.net/CrewRosteringDUN/login.aspx, https://bytzsoft.net/CrewRosteringEFL/login.aspx, https://bytzsoft.net/CrewRosteringEIH/login.aspx, https://bytzsoft.net/CrewRosteringFB2/login.aspx, https://bytzsoft.net/CrewRosteringFBW/login.aspx, https://bytzsoft.net/CrewRosteringFOR/login.aspx, https://bytzsoft.net/CrewRosteringFRE/login.aspx, https://bytzsoft.net/CrewRosteringFRM/login.aspx, https://bytzsoft.net/CrewRosteringFUT/login.aspx, https://bytzsoft.net/CrewRosteringGLD/login.aspx, https://bytzsoft.net/CrewRosteringHNS/login.aspx, https://bytzsoft.net/CrewRosteringIDC/login.aspx, https://bytzsoft.net/CrewRosteringKAL/login.aspx, https://bytzsoft.net/CrewRosteringKAS/login.aspx, https://bytzsoft.net/CrewRosteringKNG/login.aspx, https://bytzsoft.net/CrewRosteringLMW/login.aspx, https://bytzsoft.net/CrewRosteringLNT/login.aspx, https://bytzsoft.net/CrewRosteringMAL/login.aspx, https://bytzsoft.net/CrewRosteringMDU/login.aspx, https://bytzsoft.net/CrewRosteringMOD/login.aspx, https://bytzsoft.net/CrewRosteringMYT/login.aspx, https://bytzsoft.net/CrewRosteringNEX/login.aspx, https://bytzsoft.net/CrewRosteringNRM/login.aspx, https://bytzsoft.net/CrewRosteringOXF/login.aspx, https://bytzsoft.net/CrewRosteringPAB/login.aspx, https://bytzsoft.net/CrewRosteringPIN/login.aspx, https://bytzsoft.net/CrewRosteringPNW/login.aspx, https://bytzsoft.net/CrewRosteringRAJ/login.aspx, https://bytzsoft.net/CrewRosteringRCD/login.aspx, https://bytzsoft.net/CrewRosteringRJH/login.aspx, https://bytzsoft.net/CrewRosteringRTT/login.aspx, https://bytzsoft.net/CrewRosteringRWK/login.aspx, https://bytzsoft.net/CrewRosteringSAP/login.aspx, https://bytzsoft.net/CrewRosteringSAR/login.aspx, https://bytzsoft.net/CrewRosteringSBS/login.aspx, https://bytzsoft.net/CrewRosteringSHN/login.aspx, https://bytzsoft.net/CrewRosteringSHR/login.aspx, https://bytzsoft.net/CrewRosteringSKY/login.aspx, https://bytzsoft.net/CrewRosteringSOB/login.aspx, https://bytzsoft.net/CrewRosteringSYN/login.aspx, https://bytzsoft.net/CrewRosteringTA2/login.aspx, https://bytzsoft.net/CrewRosteringTAJ/login.aspx, https://bytzsoft.net/CrewRosteringTPS/login.aspx, https://bytzsoft.net/CrewRosteringTPW/login.aspx, https://bytzsoft.net/CrewRosteringTRI/login.aspx, https://bytzsoft.net/CrewRosteringTSL/login.aspx, https://bytzsoft.net/CrewRosteringTXI/login.aspx, https://bytzsoft.net/CrewRosteringUSA/login.aspx, https://bytzsoft.net/CrewRosteringVEN/login.aspx, https://bytzsoft.net/CrewRosteringVIM/login.aspx, https://bytzsoft.net/CrewRosteringVSC/login.aspx, https://bytzsoft.net/CrewRosteringVSR/login.aspx, https://bytzsoft.net/CrewRosteringZES/login.aspx, https://bytzsoft.net/CrewRosteringSYN/login.aspx, https://bytzsoft.net/CrewRosteringSVN/login.aspx, https://bytzsoft.net/CrewRosteringAPP/login.aspx, https://bytzsoft.net/CrewRosteringDMO/login.aspx,https://www.bytzsoft.net/CrewRosteringGSC/Login.aspx,https://www.bytzsoft.net/CrewRosteringIAD/Login.aspx,https://www.bytzsoft.net/CrewRosteringDDL/Login.aspx,https://rcdl.bytzsoft.in/CrewRosteringRIL/Login.aspx}"
    		// Add more URLs here if needed
    })
    void testClientLogin(String url) throws InterruptedException, IOException {
        driver.get(url);

        loginPage.login("btpladmin", "8ytzadmin");
        System.out.println("*** Login success for: " + url + " ***");

        // Add a basic assertion (optional)
        /*Assertions.assertTrue(driver.getTitle().toLowerCase().contains("login")
                || driver.getTitle().toLowerCase().contains("crew"),
                "Page title should indicate a login page or app");
        
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);

        Assertions.assertTrue(title.toLowerCase().contains("login")
        		|| title.toLowerCase().contains("crew")
        		 || title.toLowerCase().contains("flypal")
        		    || title.toLowerCase().contains("crs"),
        		
            "Page title should indicate a login page or app");*/

        loginPage.logout();
        Thread.sleep(2000);
    }
       /*// Capture screenshot
        File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("D:\\temp\\SCREENSHOT\\" + timestamp() + ".png");
        FileUtils.copyFile(scr, dest);

        Thread.sleep(2000);
    }

    private String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
    }*/

    @AfterAll
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}