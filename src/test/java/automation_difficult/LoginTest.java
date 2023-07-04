package automation_difficult;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest  {
	WebDriverWait wait;
	

	 private WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	        // Set up the WebDriver instance
	       
	        driver = new ChromeDriver();
	        driver.get("https://tutorialsninja.com/demo/");
	    }

	   

	    @Test
	    public void tnSuccessfulLogin()  {
	        // Create an instance of the LoginPage
	        LoginPage loginPage = new LoginPage(driver);

	        // Enter valid credentials
	        loginPage.enterUsername("naharshumson@gmail.com");
	        loginPage.enterPassword("Farabi1234");

	        // Click the login button
	        loginPage.clickLoginButton();
	     

	        
	        String expectedTitle = "Your store";
	        String actualTitle = driver.getTitle();
	        Assert.assertEquals(actualTitle, expectedTitle, "Login failed. Invalid credentials.");
	        System.out.println( driver.getTitle());

	       
	    }
	    @AfterMethod
	    public void tearDown() {
	       driver.quit();
	    }
	}

