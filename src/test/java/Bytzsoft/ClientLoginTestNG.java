package Bytzsoft;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class ClientLoginTestNG{                                
    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void setup() {
        // Setup ChromeDriver automatically no need to declare path here of driver
    	//  System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64 (3)\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe");
	        driver = new ChromeDriver();// Browser is launched
	        loginPage = new LoginPage(driver);// Pass driver to LoginPage
	    }
  
    @DataProvider(name = "clientUrls")
    public Object[][] getData() {
        return new Object[][] {
       /*//	1st slot
        	{"https://bytzsoft.net/CrewRostering7AR/login.aspx"},//1
  			{"https://bytzsoft.net/CrewRosteringACC/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringABR/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringASH/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringARO/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringA2Z/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringARJ/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringAR2/login.aspx"},//7
        	
        	{"https://bytzsoft.net/CrewRosteringBAR/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringBGS/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringBHA/login.aspx"},//3*/
        	
       /*//slot1
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
        	{"https://bytzsoft.net/CrewRosteringFB2/login.aspx"},
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
        	//{"https://bytzsoft.net/CrewRosteringKAS/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringKNG/login.aspx"},//3
       //..........................
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
        	{"https://bytzsoft.net/CrewRosteringPNW/login.aspx"},//3
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
        	{"https://bytzsoft.net/CrewRosteringSAI/login.aspx"},//8-18*/
        
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
        	
    /*//  Slot 5
        	{"https://www.bytzsoft.net/CrewRostering"},
        	{"https://bytzsoft.net/CrewRosteringAPP/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringDMO/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringSYN/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringSVN/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringUSA/login.aspx"},
        	{"https://bytzsoft.net/CrewRosteringRCD/login.aspx"},
        	//6-18-71*/
        	
        	
        	
            // Add more URLs here
        };
    }

    @Test(dataProvider = "clientUrls")
    public void testClientLogin1(String url) throws InterruptedException, IOException {
        driver.get(url);

        loginPage.login("btpladmin", "8ytzadmin");
       /* driver.findElement(By.xpath("//span[@id='ctl00_lnkLoggedInUser']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@id='ctl00_lnkProfile']")).click();
        Thread.sleep(1000);
       
        String e=driver.findElement(By.xpath("//span[@id='ctl00_lblCabinCrew']")).getText();
        Thread.sleep(1000);
		System.out.println("Cabin Count" +e);*/
      
      
		 Thread.sleep(1000);

        System.out.println("*** Login success for: " + url + " ***");

        loginPage.logout();
       

        Thread.sleep(2000);
        }

     /*   File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("D:\\temp\\SCREENSHOT\\" + timestamp() + ".png");
        FileUtils.copyFile(scr, dest);

  
    

    private String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }*/

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}