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

	public class LoginAvoidLoad {

	    WebDriver driver;
	    LoginPage loginPage;
	    WebDriverWait wait;

	    ExcelReader excelReader =new ExcelReader("D:/Selenium/TestData/ClientURLs.xlsx");

	    @BeforeClass
	    public void setup() {

	        driver = new ChromeDriver();

	        driver.manage().window().maximize();

	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	        loginPage = new LoginPage(driver);
	    }

	    @DataProvider(name = "clientUrls", parallel = false)
	    public Object[][] getClientUrls() throws Exception {

	        return excelReader.getUrlsData();
	    }

	    @Test(dataProvider = "clientUrls")
	    public void testClientLogin1(String url) {

	        try {

	            System.out.println("====================================");
	            System.out.println("Launching URL : " + url);
	            System.out.println("====================================");

	            driver.get(url);

	            loginPage.login("btpladmin", "8ytzadmin");

	            wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(By.id("txtUserName"))));

	            System.out.println("Execution Completed : " + url);

	            // Optional Logout
	            // loginPage.logout();

	            // Clear session to avoid load issue
	            driver.manage().deleteAllCookies();

	            // Wait before next URL
	            Thread.sleep(5000);

	        } catch (Exception e) {

	           /* System.out.println("Failed URL : " + url);
	            System.out.println("Reason : " + e.getMessage());*/

	            driver.manage().deleteAllCookies();

	            try {
	                Thread.sleep(5000);
	            } catch (InterruptedException ex) {
	            	ex.printStackTrace();
	            }
	        }
	    }

	    @AfterClass
	    public void tearDown() {

	        if (driver != null) {
	            driver.quit();
	        }
	    }
	
}
