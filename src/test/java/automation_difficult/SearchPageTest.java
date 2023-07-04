package automation_difficult;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchPageTest {
	private WebDriver driver;
    private SearchPage searchPage;
    
    @BeforeMethod
    public void setUp() {
      
        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        searchPage = new SearchPage(driver);
    }
   
    @Test
    public void testSearchAndClickProduct() {
        String productName = "HP";
        
        searchPage.searchForProduct(productName);
        Assert.assertTrue(searchPage.isSearchResultDisplayed(), "Search results not displayed");
        
        searchPage.clickOnProduct();
     
    }
    
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    
}


