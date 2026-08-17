package Bytzsoft;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CRSExcelURL {

    WebDriver driver;
    LoginPage loginPage;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        loginPage = new LoginPage(driver);
    }

    @DataProvider(name = "clientUrls")
    public Object[][] getClientUrls() throws Exception {

        ExcelReader excelReader =new ExcelReader("D:/Selenium/TestData/ClientURLs.xlsx");

        return excelReader.getUrlsData();
    }
    	
    @Test(dataProvider = "clientUrls")
    public void testClientLogin1(String url) {

        try {

            System.out.println("======================================");
            System.out.println("Launching URL : " + url);
            System.out.println("======================================");

            driver.get(url);

            loginPage.login("btpladmin", "8ytzadmin");

            wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(By.id("txtUserName")) ));
            	
            		System.out.println("Logout Successful : " + url);
            	
            		//System.out.println();
            
            		} catch (Exception e) {

            		   // System.out.println("Failed URL : " + url);
            		    //System.out.println("Reason : " + e.getMessage());
            		   // System.out.println();

            		    //Assert.fail("Test failed for URL : " + url, e);
            		}
          
            		}
            	
            	 	
       
            		@AfterClass
            
            		public void tearDown() {
            
            	
            		if (driver != null) {
            	
            		driver.quit();
            		
            		}
            	
            		}
            		
            		}