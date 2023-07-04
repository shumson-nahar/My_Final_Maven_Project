package automation_medium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	 private WebDriver driver;

	    // Constructor
	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    // Elements on the home page
	    @FindBy(xpath = "//a[text()='My Account']")
	    private WebElement myAccountLink;

	    @FindBy(linkText = "Register")
	    private WebElement registerLink;

	    @FindBy(linkText = "Login")
	    private WebElement loginLink;

	    // Methods for actions on the home page
	    public void clickMyAccountLink() {
	        myAccountLink.click();
	    }

	    public void clickRegisterLink() {
	        registerLink.click();
	    }

	    public void clickLoginLink() {
	        loginLink.click();
	    }

		
	}


