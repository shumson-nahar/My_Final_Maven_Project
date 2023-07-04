package automation_difficult;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingCartTest {
	 private WebDriver driver;
	    private ShoppingCartPage shoppingCartPage;

	    @BeforeMethod
	    public void setUp() {
	       
	        driver = new ChromeDriver();
	        driver.get("https://tutorialsninja.com/demo/");
	        shoppingCartPage = new ShoppingCartPage(driver);
	    }

	    @Test
	    public void testAddProductToCart() {
	        shoppingCartPage.setSearchInput("iPhone");
	        shoppingCartPage.clickSearchButton();
	        shoppingCartPage.setQuantityInput("1");
	        shoppingCartPage.clickAddToCartButton();
	        String successMessage = shoppingCartPage.getSuccessAlertText();
	        Assert.assertTrue(successMessage.contains("Success: You have added iPhone"));
	        shoppingCartPage.clickShoppingCartLink();
	         
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }
	}


