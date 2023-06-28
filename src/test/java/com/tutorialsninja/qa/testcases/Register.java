package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class Register extends Base {
	AccountSuccessPage accountSuccessPage;
	RegisterPage registerPage;
	public Register() {
		super();
	}
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		  driver = initializeBrowserAndopenApplicationURL(prop.getProperty("browserName")) ;
		  HomePage homePage = new   HomePage(driver);
		  registerPage = homePage.navigateToRegisterPage();
		 // homePage.clickOnMyAccount();
		 // registerPage = homePage.selectRegisterOption();
		
	}
	@Test(priority = 1) 
	public void verifyRegisteringAnAccountWithMandatoryFields() {
	
		accountSuccessPage=registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"),dataProp.getProperty("lastName"),Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"));
		//Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(),prop.getProperty("accountSuccessfullyCreatedHeading"));


		
		
	}
	@Test(priority = 2) 
	public void verifyRegisteringAccountByProvidingAllFields() {
		
		accountSuccessPage=registerPage.registerWithAllFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"));
		//Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(),prop.getProperty("accountSuccessfullyCreatedHeading"),"Account Success page is not displayed");
		
		
		
		
		
		
	}
	@Test(priority = 3) 
	public void verifyregisteringAccountWithExistingEmailAddress() {
		
		registerPage.registerWithAllFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				prop.getProperty("validEmail"), dataProp.getProperty("telephoneNumber"), 
				prop.getProperty("validPassword"));
	  //  Assert.assertTrue(registerPage.retrieveDuplicateEmailAddressWarning().contains(dataProp.getProperty("duplicateEmailWarning ")),("Warning message regaring duplicate email address is not displayed"));
	
		
		
	}
	@Test(priority = 4) 

	public void verifyRegisteringAccountWithoutFillingAnyDetails() throws InterruptedException {
		
		registerPage.clickOnContinueButton();
	  // Assert.assertTrue(registerPage.displayStatusOfWarningMessages(dataProp.getProperty("privacyPolicyWarning"), dataProp.getProperty("firstNameWarning"), dataProp.getProperty ("lastNameWarning"), dataProp.getProperty ("emailWarning "), dataProp.getProperty("telephoneWarning"), dataProp.getProperty ("passwordWarning")));
		
	    
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

	
	


