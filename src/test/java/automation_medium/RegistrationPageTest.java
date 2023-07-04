package automation_medium;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class RegistrationPageTest {
	private WebDriver driver;
    private RegistrationPage registrationPage;

    @BeforeMethod
    public void setUp() {
       driver = new ChromeDriver();
       driver.get("https://tutorialsninja.com/demo/");
       driver.manage().deleteAllCookies();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       registrationPage = new RegistrationPage(driver);
    }

    @Test
    public void testSuccessfulRegistration() {
        // Enter valid registration details
        registrationPage.enterFirstName("Shumson");
        registrationPage.enterLastName("Nahar");
        registrationPage.enterEmail("naharshumson@gmail.com");
        registrationPage.enterTelephone("2676001308");
        registrationPage.enterPassword("Farabi1234");
        registrationPage.enterConfirmPassword("Farabi1234");
        registrationPage.checkPrivacyPolicy();
        registrationPage.clickContinueButton();
        String successMessage = driver.findElement(By.xpath( "//div[contains(@class, 'alert-dismissible')]")).getText();
        Assert.assertEquals(successMessage, "Your Account Has Been Created!");
    }

    @AfterMethod
    public void tearDown() {
        
        driver.quit();
    }
}


