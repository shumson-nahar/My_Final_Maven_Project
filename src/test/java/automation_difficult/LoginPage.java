package automation_difficult;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	 private WebDriver driver;

	    @FindBy(id= "input-email")
	    private WebElement usernameTextBox;

	    @FindBy(id = "input-password")
	    private WebElement passwordTextBox;

	    @FindBy(css = "input.btn.btn-primary")
	    private WebElement loginButton;

	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void enterUsername(String username) {
	    	usernameTextBox.sendKeys(username);
	    }

	    public void enterPassword(String password) {
	    	passwordTextBox.sendKeys(password);
	    }

	    public void clickLoginButton() {
	        loginButton.click();
	    }
	}

