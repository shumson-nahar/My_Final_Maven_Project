package automation_difficult;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	 private WebDriver driver;
	    
	    @FindBy(xpath = "//*[@id=\"search\"]/input")
	    private WebElement searchInput;
	    
	    @FindBy(xpath = "//*[@id=\"search\"]/span/button/i")
	    private WebElement searchButton;
	    
	    @FindBy(xpath = "//*[@id=\"content\"]/h2")
	    private WebElement searchResult;
	    
	    public SearchPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    public void searchForProduct(String productName) {
	        searchInput.sendKeys(productName);
	        searchButton.click();
	    }
	    
	    public boolean isSearchResultDisplayed() {
	        return searchResult.isDisplayed();
	    }
	    
	    public void clickOnProduct() {
	        searchResult.click();
	    }
	}

