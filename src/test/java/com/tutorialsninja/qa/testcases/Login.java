package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class Login extends Base{
	LoginPage loginPage;
	public Login() throws IOException {
		super();
	}
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		
		    driver = initializeBrowserAndopenApplicationURL(prop.getProperty("browserName")) ;
		    HomePage homePage = new   HomePage(driver);
		    loginPage = homePage.naviagToLoginPage();
		
	}
	
	@Test(priority = 1,dataProvider = "validCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String email,String password) throws InterruptedException {
		AccountPage accountPage = loginPage.login(email, password);
		Assert.assertTrue(accountPage.getDisplayStausOfEditYourAccountInformationOption());
		
		 Thread.sleep(3000);
	}
	@DataProvider(name ="validCredentialsSupplier")
	public Object supplyTestData() throws IOException  {
		Object[][] data = Utilities.readDataTNFromExcel("Login");
	return data;
	}
	
	
	
	@Test(priority=2)
	public void verifyLoginWithInvalidCredentials() throws InterruptedException {
		loginPage.login(Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("InvalidPassword"));
		 Assert.assertTrue( loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().
        contains(dataProp.getProperty ("emailPasswordNoMatchWarning")),"Expected Warning message is not displayed");
		 Thread.sleep(3000);
	
}
	@Test(priority=3)
	public void verifyLoginWithInvalidEmailAndValidPassword() throws InterruptedException {
		loginPage.login(Utilities.generateEmailWithTimeStamp(),prop.getProperty("validPassword"));
		Assert.assertTrue( loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().contains
				(dataProp.getProperty ("emailPasswordNoMatchWarning")),"Expected Warning message is not displayed");
		 Thread.sleep(3000);
	
		
		
	}
	@Test(priority=4)
	public void verifyLoginWithValidEmailAndInvalidPassword() throws InterruptedException {
		loginPage.login(prop.getProperty("validEmail"),dataProp.getProperty("InvalidPassword"));
		Assert.assertFalse( loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().contains(dataProp.getProperty ("emailPasswordNoMatchWarning")),"Expected Warning message is not displayed");
		 Thread.sleep(3000);
		
	}
	@Test(priority=5)
	public void verifyLoginWithoutProvidingCredentials() throws InterruptedException {
		
		loginPage.clickOnLoginButton();
		Assert.assertTrue( loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().contains(dataProp.getProperty ("emailPasswordNoMatchWarning")),"Expected Warning message is not displayed");
	   Thread.sleep(3000);
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
