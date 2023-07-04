package automation_easy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FilloutLoginForm {
	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
	}
	
	@Test
	public void verifyingLoginWithValidCredentials() {
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("naharshumson@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Farabi1234");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualUrl="https://tutorialsninja.com/demo/index.php?route=account/account";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl,actualUrl);
		softassert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		System.out.println(actualUrl);
		softassert.assertAll();
	}

}
