package Bytzsoft;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage1 {

    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By usernameField = By.id("txtUserName");
    By nextButton = By.id("lnkArrow");
    By passwordField = By.id("txtPassword");
    By loginButton = By.id("btnLogin");
    By logoutButton = By.id("ctl00_lnkBtnLogout");

    // Constructor
    public LoginPage1(WebDriver driver) {
        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }

    // Enter Username
    public void enterUsername(String username) {

        WebElement usernameElement =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(usernameField)
                );

        usernameElement.clear();
        usernameElement.sendKeys(username);

        // Click Next
        WebElement next =
                wait.until(
                        ExpectedConditions.elementToBeClickable(nextButton)
                );

        next.click();
    }

    // Enter Password
    public void enterPassword(String password) {

        WebElement passwordElement =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(passwordField)
                );

        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    // Click Login
    public void clickLogin() {

        WebElement login =
                wait.until(
                        ExpectedConditions.elementToBeClickable(loginButton)
                );

        login.click();
    }

    // Check Login Success
    public boolean isLoginSuccessful() {

        try {

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(logoutButton)
            );

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    // Logout
    public void logout() {

        WebElement logout =
                wait.until(
                        ExpectedConditions.elementToBeClickable(logoutButton)
                );

        logout.click();
    }

    // Complete Login
    public void login(String username, String password) {

        driver.manage().window().maximize();

        enterUsername(username);

        enterPassword(password);

        clickLogin();

        // Verify successful login
        if (!isLoginSuccessful()) {

            throw new RuntimeException(
                    "Login button was clicked, but login was not successful."
            );
        }
    }
}