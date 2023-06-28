package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	@FindBy(id="input-email")
	WebElement emailAdderssField;
	@FindBy(id="input-password")
	WebElement passwordField;
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement emailPasswordNotMatchingWarning;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
		
	}
	public void enterEmailAddress(String emailText) {
		emailAdderssField.sendKeys(emailText);
		
		
	}
	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
		
	}
	public AccountPage clickOnLoginButton() {
		loginButton.click();
		return new AccountPage(driver);
		
		
		
	}
	public AccountPage login(String emailText,String passwordText) {
		emailAdderssField.sendKeys(emailText);
		passwordField.sendKeys(passwordText);
		loginButton.click();
		return new AccountPage(driver);
		
	}
	public String retrieveEmailPasswordNotMatchingWarningMessageText() {
		String warningText= emailPasswordNotMatchingWarning.getText();
		return warningText;
	}

}
