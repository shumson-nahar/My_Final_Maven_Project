package automation_medium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {
	private WebDriver driver;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        driver.get("http://tutorialsninja.com/demo/");
    }

    @Test
    public void testHomePage() {
		homePage.clickMyAccountLink(); 
        homePage.clickRegisterLink();
        homePage.clickMyAccountLink();
    }

    @AfterMethod
    public void tearDown() {
        
        driver.quit();
    }
}


