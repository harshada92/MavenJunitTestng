package Bytzsoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	 WebDriver driver;

	    // Locators
	    By usernameField = By.id("txtUserName");
	    By nextButton = By.id("lnkArrow");
	    By passwordField = By.id("txtPassword");
	    By loginButton = By.id("btnLogin");
	    By logoutButton = By.id("ctl00_lnkBtnLogout");

	    /*Constructor-The constructor is used to pass the browser session (driver) 
	    into the LoginPage class.*/
	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        /*WebDriver is the interface that allows your automation script 
	         * to control the browser (like Chrome, Firefox, etc.).
	         * driver is a variable that holds the reference to that browser session.
	         * Now, inside your LoginPage class, 
	         * you can use this.driver to interact with web elements:*/
	    }
	   /* This works because the driver you created in your test 
	    * (which is connected to a real browser) has been passed to the page class.
	    */
	    public void enterUsername(String username) {
	        driver.findElement(usernameField).sendKeys(username);
	        driver.findElement(nextButton).click();
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    public void clickLogin() {
	        driver.findElement(loginButton).click();
	    }

	    public void logout() {
	        driver.findElement(logoutButton).click();
	    }
	    /*public boolean isLoginSuccessful() {
			return false;}*/
	    
	    public void login(String username, String password) throws InterruptedException {
	        driver.manage().window().maximize();
	        Thread.sleep(1000);
	        enterUsername(username);
	        Thread.sleep(1000);
	        enterPassword(password);
	        clickLogin();
	        Thread.sleep(3000);
	    }
		
		}
	

