package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	@FindBy(id="input-firstname")
	 private WebElement firstNameField;

	@FindBy(id="input-lastname")
	 private WebElement lastNameField;
	
	@FindBy(id="input-email")
	 private WebElement emailAddressField;
	
	@FindBy(id="input-telephone")
	 private WebElement telephoneField;
	
	@FindBy(id="input-password")
	 private WebElement passwordField;

    @FindBy(id="input-confirm")
   private WebElement passwordConfirmField;
    @FindBy(name="agree")
    private WebElement  privactPolicyField;
    @FindBy(xpath="//div[@id='content']/h1")
    private WebElement continueButton;
    @FindBy(xpath="//input[@name='newsletter'][@value='1']")
    private WebElement yesNewsletterOption;
    @FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
    private WebElement duplicateEmailAddressWarning;
    @FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
    private WebElement privacyPolicyWarning;
    @FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
    private WebElement firstNamWarning;
    @FindBy(xpath="//input[@id='input-lastname']//following-sibling::div")
    private WebElement lastNameWarning;
    @FindBy(xpath="//input[@id='input-email']//following-sibling::div")
    private WebElement emailWarning; 
    @FindBy(xpath="//input[@id='input-telephone']//following-sibling::div")
    private WebElement telephoneWarning;
    @FindBy(xpath="//input[@id='input-password']//following-sibling::div")
    private WebElement passwordWarning;
    
    public RegisterPage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    	
    }
    public void enterFirstName(String firstNameText) {
    	firstNameField.sendKeys(firstNameText);
    	
    }
    public void enterLastName(String lastNameText) {
    	lastNameField.sendKeys(lastNameText);
    	
    }
    public void enterEmailAddress(String emailText) {
    	emailAddressField.sendKeys(emailText);
    	
    }
    public void enterTelephoneNumber(String telephoneText) {
    	telephoneField.sendKeys(telephoneText);
    	
    }
    public void enterpassword(String passwordText) {
    	passwordField.sendKeys(passwordText);
    	
    }
    public void enterConfirmpassword(String passwordText) {
    	passwordConfirmField.sendKeys(passwordText);
    	
    }
    public void selectPrivacyPolicy() {
    	 privactPolicyField.click();
    }
    public AccountSuccessPage clickOnContinueButton() {
    	 continueButton.click();
    	 return new AccountSuccessPage(driver);
   }
    public void selectYesNewsletterOption() {
    	yesNewsletterOption.click();
    	
    }
    public String retrieveDuplicateEmailAddressWarning() {
    	
    	String duplicateEmailWarningText= duplicateEmailAddressWarning.getText();
    	return duplicateEmailWarningText;
    	
    }
    
    public String privacyPolicyWarning() {
    	String firstNameWarningText= privacyPolicyWarning.getText();
    	return firstNameWarningText;
    	
    }
    public String retrieveFirstNameWarning() {
    	String FirstNameWarningText= firstNamWarning.getText();
    	return FirstNameWarningText;
    	
    }
    public String retrievePrivacyPolicyWarning() {
    	String privacyPolicyWarningText = privacyPolicyWarning.getText();
    	return privacyPolicyWarningText;
    }
    
    public String retrieveLastNameWarning() {
    	String LastNameWarningText= lastNameWarning.getText();
    	return LastNameWarningText;
    	
    }
    public String retrieveEmailWarning() {
    	String EmailWarningText= emailWarning.getText();
    	return EmailWarningText;
    	
    }
    public String telephoneWarning() {
    	String TelephoneWarningText=  telephoneWarning.getText();
    	return TelephoneWarningText;
    	
    }
    public String passwordWarning() {
    	String PasswordWarningText=  passwordWarning.getText();
    	return  PasswordWarningText;
    	
    }
    public AccountSuccessPage registerWithMandatoryFields(String firstNameText ,String lastNameText,String emailText ,String telephoneText ,String passwordText) {
    	firstNameField.sendKeys(firstNameText);
    	lastNameField.sendKeys(lastNameText);
    	emailAddressField.sendKeys(emailText);
    	telephoneField.sendKeys(telephoneText);
    	passwordField.sendKeys(passwordText);
    	passwordConfirmField.sendKeys(passwordText);
    	 privactPolicyField.click();
    	 continueButton.click();
    	 return new AccountSuccessPage(driver);
    	
    }
    public AccountSuccessPage registerWithAllFields(String firstNameText ,String lastNameText,String emailText ,String telephoneText ,String passwordText) {
    	firstNameField.sendKeys(firstNameText);
    	lastNameField.sendKeys(lastNameText);
    	emailAddressField.sendKeys(emailText);
    	telephoneField.sendKeys(telephoneText);
    	passwordField.sendKeys(passwordText);
    	passwordConfirmField.sendKeys(passwordText);
    	yesNewsletterOption.click();
    	 privactPolicyField.click();
    	 continueButton.click();
    	 return new AccountSuccessPage(driver);
    	
    }

    public boolean displayStatusOfWarningMessages(String expectedprovacyPolicyWarning,String expectedfirstNameWarning,String expectedlastNameWarning,String expectedemailWarning,String expectedtelephoneWarning,String expectedpasswordWarning) {
    	
    	boolean privacyPolicyWarningStatus = privacyPolicyWarning.getText().contains(expectedpasswordWarning);
    	
    	boolean firstNameWarningStatus = firstNamWarning.getText().equals(expectedfirstNameWarning);
    	
    	
    	boolean lastNameWarningStatus = lastNameWarning.getText().equals(expectedlastNameWarning);
    	
    	boolean emailWarningStatus = emailWarning.getText().equals(expectedemailWarning);
    	
    	boolean telephoneWarningStatus =telephoneWarning.getText().equals(expectedtelephoneWarning);
    	
    	boolean PasswordWarningStatus =passwordWarning.getText().equals(expectedpasswordWarning);
    	return privacyPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus && emailWarningStatus && telephoneWarningStatus && PasswordWarningStatus;
    }
}










