package automation_difficult;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	private WebDriver driver;

    @FindBy(linkText = "My Account")
    private WebElement myAccountLink;

    @FindBy(xpath = "//*[@id=\"search\"]/input")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    private WebElement searchButton;

    @FindBy(xpath ="//input[@type='number']")                          
    private WebElement quantityInput;

    @FindBy(xpath = "//button[@id='button-cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement successAlert;

    @FindBy(xpath = "//span[contains(text(), 'Shopping Cart')]")
    private WebElement shoppingCartLink;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickMyAccountLink() {
        myAccountLink.click();
    }

    public void setSearchInput(String searchText) {
        searchInput.sendKeys(searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

	
	  public void setQuantityInput(String quantity) { 
	  quantityInput.clear();
	  quantityInput.sendKeys(quantity);
	  }
	 

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public String getSuccessAlertText() {
        return successAlert.getText();
    }

    public void clickShoppingCartLink() {
        shoppingCartLink.click();
    }
}


