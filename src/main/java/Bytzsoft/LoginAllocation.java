package Bytzsoft;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginAllocation {

    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By usernameField = By.id("txtUserName");
    By nextButton = By.id("lnkArrow");
    By passwordField = By.id("txtPassword");
    By loginButton = By.id("btnLogin");
    By logoutButton = By.id("ctl00_lnkBtnLogout");

    public LoginAllocation(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void enterUsername(String username) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField))
                .sendKeys(username);

        driver.findElement(nextButton).click();
    }

    public void enterPassword(String password) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField))
                .sendKeys(password);
    }

    public void clickLogin() {

        wait.until(ExpectedConditions.elementToBeClickable(loginButton))
                .click();
    }

    public void logout() {

        wait.until(ExpectedConditions.elementToBeClickable(logoutButton))
                .click();
    }

    public void login(String username, String password) {

        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}