package SeleniumTests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import PageObjectModel.loginPage;
import WrapperClasses.readFromXls;
import WrapperClasses.ExtentReportManager;
import PageObjectModel.homePage;
public class LoginPageTest {

    static WebDriver driver;
    static loginPage loginpage;
    static readFromXls readfromxls;
    static homePage homepage;
    //static ExtentReportManager extentreport;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize the window if necessary
        loginpage = new loginPage(driver);
        readfromxls = new readFromXls();
        homepage =  new homePage(driver);
        ExtentReportManager.initReport("C:\\Users\\sambi\\eclipse-workspace\\SeleniumProject\\test-output\\ExtentReport\\extent.html");
        
    }

    @BeforeMethod
    public void loadData() throws IOException {
        driver.get("https://www.saucedemo.com/");   // Navigate to login page
        String excelFilePath = "C:\\Users\\sambi\\Downloads\\UserAndPassword.xlsx"; // Your actual Excel file path
        readfromxls.loadExcelFile(excelFilePath);  // Load the Excel file data
    }

    @Test(priority = 0)
    public void loginTest() {
    	ExtentReportManager.startTest("Login Test");
        String UName = readfromxls.getCellData(1, 0); // Fetch username from Excel
        String Pword = readfromxls.getCellData(1, 1); // Fetch password from Excel
        
        loginpage.setUserName(UName);   // Set username on the login page
        loginpage.setPassword(Pword);   // Set password on the login page
        loginpage.ClickOnlogin();       // Click login button
        
        // Example assertion to check if login was successful by verifying page title
        String expectedTitle = "Swag Labs";  // Replace with the actual title after login
        String Actual = driver.getTitle();
        ExtentReportManager.logInfo("Page title is: " + Actual);
        if (Actual.equals("Swag Labs")) {
            ExtentReportManager.logPass("Login successful.");
        } else {
            ExtentReportManager.logFail("Login failed.");
        }

        Assert.assertEquals(Actual, expectedTitle);
    }
    
    
    @Test(priority = 1)
    public void loginTestFail() {
    	ExtentReportManager.startTest("Login Test");
        String UName = readfromxls.getCellData(1, 0); // Fetch username from Excel
        String Pword = readfromxls.getCellData(1, 1); // Fetch password from Excel
        
        loginpage.setUserName(UName);   // Set username on the login page
        loginpage.setPassword(Pword);   // Set password on the login page
        loginpage.ClickOnlogin();       // Click login button
        
        // Example assertion to check if login was successful by verifying page title
        String expectedTitle = "Swag Not Labs";  // Replace with the actual title after login
        String Actual = driver.getTitle();
        ExtentReportManager.logInfo("Page title is: " + Actual);
        if (Actual.equals("Swag Labs")) {
            ExtentReportManager.logPass("Login successful.");
        } else {
            ExtentReportManager.logFail("Login failed.");
        }

        Assert.assertEquals(Actual, expectedTitle);
    }
    
    @Test(priority = 2)
    public void verifyLogo() {
    	String str = homepage.verifyLogo();
    	String expectedTitle = "Swag Labs";
    	 Assert.assertEquals(str, expectedTitle);
    	
    }
    @Test(priority = 3)
    public void addtoCart() {
    	homepage.clickOnAddToCart();
    	String str = homepage.getCartText();
    	String expectedTitle = "Add to cart";
    	 Assert.assertEquals(str, expectedTitle);
    } 
    
    @Test(priority = 4)
    public void removeCart() {
    	homepage.remove();
    	String str = homepage.getRemoveText();
    	String expectedTitle = "Add to cart";
    	 Assert.assertNotEquals(str, expectedTitle);
    } 
        
    }

    // Optional: Add @AfterClass to close browser after tests

