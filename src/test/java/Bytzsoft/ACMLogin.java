package Bytzsoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ACMLogin {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bytzsoft.net/AccessControlManagement/wfAuth.aspx");
    }

    @Test
    public void verifyLoginPageIsOpen() throws InterruptedException {
        System.out.println("Page Title: " + driver.getTitle());
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='btnSignIn']"));
        driver.findElement(By.xpath("//button[@id='btnSignIn']")).click();
      //input[@id='signin_email']
      //input[@id='signin_password']
       driver.findElement(By.xpath("//button[@id='btnSignIn']")).click();
    }
    
    

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

	    
	   
	       