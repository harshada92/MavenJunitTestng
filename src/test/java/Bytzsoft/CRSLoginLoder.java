package Bytzsoft;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CRSLoginLoder {

    private static final int PAGE_LOAD_TIMEOUT = 30;

    private static final String USERNAME = "btpladmin";
    private static final String PASSWORD = "8ytzadmin";


    // ============================================================
    // CLIENT URLS
    // ============================================================

    @DataProvider(name = "clientUrls")
    public Object[][] getClientUrls() {

        return new Object[][] {

        	{"https://bytzsoft.net/CrewRostering7AR/login.aspx"},//1
  			{"https://bytzsoft.net/CrewRosteringACC/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringABR/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringASH/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringARO/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringA2Z/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringARJ/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringAR2/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringARA/login.aspx"},//8
        	
        	{"https://bytzsoft.net/CrewRosteringBAR/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringBGS/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringBHA/login.aspx"},//3
        	
     //slot1
        	{"https://bytzsoft.net/CrewRosteringCAI/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringCRL/login.aspx"},//2
        	
        	{"https://bytzsoft.net/CrewRosteringDAD/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringDEC/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringDHL/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringDMO/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringDUN/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringDDL/Login.aspx"},//6-19
        	
        	{"https://bytzsoft.net/CrewRosteringEFL/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringEIH/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringEMS/login.aspx"},//
        	
        	
   //3 slot............................
        	//{"https://bytzsoft.net/CrewRosteringFB2/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringFBW/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringFOR/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringFRE/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringFRM/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringFUT/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringFLK/login.aspx"},//7
        	
        	{"https://bytzsoft.net/CrewRosteringGLD/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringGSC/Login.aspx"},//2
        	
        	{"https://bytzsoft.net/CrewRosteringHNS/login.aspx"},//1
        	
        	{"https://bytzsoft.net/CrewRosteringIDC/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringIAD/Login.aspx"},//2
        	
        	{"https://bytzsoft.net/CrewRosteringKAL/login.aspx"},
        
        	{"https://bytzsoft.net/CrewRosteringKNG/login.aspx"},//2
     ///..........................
        	{"https://bytzsoft.net/CrewRosteringLMW/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringLNT/login.aspx"},//2
        	
        	{"https://bytzsoft.net/CrewRosteringMAL/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringMDU/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringMOD/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringMYT/login.aspx"},//4-23
        	
        	{"https://bytzsoft.net/CrewRosteringNEX/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringNRM/login.aspx"},//2
        	
        	
        	
        	{"https://bytzsoft.net/CrewRosteringPAB/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringPIN/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringPNW/login.aspx"},//
  //...............
        	{"https://bytzsoft.net/CrewRosteringRAJ/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringRJH/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringRTT/login.aspx"},
        	{"https://rcdl.bytzsoft.in/CrewRosteringRIL/Login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringRWK/login.aspx"},//5
   
        	{"https://bytzsoft.net/CrewRosteringSAP/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringSAR/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringSBS/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringSHN/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringSHR/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringSKY/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringSOB/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringSAI/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringSPZ/login.aspx"},//9-18
        
    //slot 4
       		{"https://bytzsoft.net/CrewRosteringTA2/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringTAJ/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringTPS/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringTPW/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringTRI/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringTSL/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringTXI/login.aspx"},//7
        	
        
        	{"https://bytzsoft.net/CrewRosteringVEN/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringVIM/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringVSC/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringVSR/login.aspx"},//4
        	{"https://bytzsoft.net/CrewRosteringZES/login.aspx"},//1
        	
   //  Slot 5
        	{"https://www.bytzsoft.net/CrewRostering"},
        	{"https://bytzsoft.net/CrewRosteringAPP/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringDMO/login.aspx"},
        	
        	{"https://bytzsoft.net/CrewRosteringSYN/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringSVN/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringUSA/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringRCD/login.aspx"},
        	//6-18-71
        	
        	
        	//SMS
        	/*{"https://www.bytzsoft.net/SMS/FlyPalSMSBTP/Login.aspx"},
        	{"https://rcdl.bytzsoft.in/SMS/FlyPalSMSRIL/Login.aspx"},
        	//{"https://www.bytzsoft.net/SMS/FlyPalSMSDMO/Login.aspx"},
        	{"https://www.bytzsoft.net/SMS/FlyPalSMSPTC/Login.aspx"},
        	{"https://www.bytzsoft.net/SMS/FlyPalSMSPTW/Login.aspx"},
        	{"https://www.bytzsoft.net /SMS/FlyPalSMSMOD/Login.aspx"},
        	//{"https://www.bytzsoft.net/SMS/FlyPalSMSMAL/Login.aspx"},
        	{"https://www.bytzsoft.net/SMS/FlyPalSMSYET/Login.aspx"},*/
        	

        };
    }


    // ============================================================
    // TEST
    // ============================================================

    @Test(dataProvider = "clientUrls")
    public void testClientLogin(String url) {

        WebDriver driver = null;

        try {

            System.out.println();
            System.out.println("==================================================");
            System.out.println("CLIENT : " + url);
            System.out.println("==================================================");


            // ------------------------------------------------
            // Start new browser
            // ------------------------------------------------

            driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));


            // ------------------------------------------------
            // Create LoginPage1
            // ------------------------------------------------

            LoginPage1 loginPage =new LoginPage1(driver);


            // ------------------------------------------------
            // Open client
            // ------------------------------------------------

            System.out.println("Opening client...");

            driver.get(url);

            System.out.println("Client page opened.");


            // ------------------------------------------------
            // Login
            // ------------------------------------------------

            System.out.println("Starting login...");

            loginPage.login(USERNAME,PASSWORD);


            // ------------------------------------------------
            // SUCCESS
            // ------------------------------------------------

            System.out.println();
            System.out.println("**********************************************");
            System.out.println("LOGIN SUCCESS");
            System.out.println("CLIENT : " + url);
            System.out.println("**********************************************");


            // ------------------------------------------------
            // Logout
            // ------------------------------------------------

            System.out.println("Logging out...");

            loginPage.logout();

            System.out.println("Logout successful.");

            System.out.println();
            System.out.println("FINAL RESULT : PASS");
            System.out.println("CLIENT       : " + url);


        } catch (Exception e) {

            // ------------------------------------------------
            // FAILURE
            // ------------------------------------------------

            System.out.println();
            System.out.println("**********************************************");
            System.out.println("CLIENT FAILED");
            System.out.println("CLIENT : " + url);
            System.out.println("ERROR  : " + e.getMessage());
            System.out.println("**********************************************");

            // Mark this particular client as FAILED
            Assert.fail("Login failed for client: " + url,e);


        } finally {

            // ------------------------------------------------
            // Always close browser
            // ------------------------------------------------

            if (driver != null) {

                try {

                    driver.quit();

                    System.out.println("Browser closed.");

                } catch (Exception e) {

                    System.out.println( "Could not close browser.");
                }
            }
        }
    }
}