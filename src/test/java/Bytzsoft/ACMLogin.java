package Bytzsoft;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("signin_email")))
            .sendKeys("harshada@bytzsoft.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("signin_password")))
            .sendKeys("harshada@bytzsoft.com");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("btnSignIn")))
            .click();

        wait.until(ExpectedConditions.urlContains("Dashboard"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("Div_NewRequest")))
        .click();
      //select[@id='cmbUserApplications']
    }
    
    

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

	    
	   
	       