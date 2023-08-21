package com.otm.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.otm.qa.base.Base;
import com.otm.qa.pages.HomePage;
import com.otm.qa.pages.LoginPage;
import com.otm.qa.util.Utilities;

public class LoginTest extends Base {
	
	public LoginTest() {
		super();
	}
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void setup() {
		
		driver = intializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1,dataProvider="validCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String username,String password) {
		
	   LoginPage loginPage = new LoginPage(driver);
	   loginPage.enterUserName(username);
	   loginPage.enterPassword(password);
	   loginPage.clickOnLoginButton();
	   
	   HomePage homePage = new HomePage(driver);
	
		Assert.assertTrue(homePage.getDisplayHome(),"Home");
		//driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary']")).click();
		
	}
	
	@DataProvider(name="validCredentialsSupplier")
	public Object [] [] supplyTestData()  {
		Object[] [] data = Utilities.getTestDataFromExcel("Login");
		return data;
	}

	@Test(priority=2)
	public void verifyLoginWithInvalidCardentials() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(dataProp.getProperty("invalidusername"));
		loginPage.enterPassword(dataProp.getProperty("invalidpassword"));
		loginPage.clickOnLoginButton();
	
		String actualWarningMessage = loginPage.retrieveWarningMessasgeText();
		String expectedWarningMessage = ("Warning :Invalid Username and Password");
	    //Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Invalid Username and Password");
		loginPage.clickonOKButton();
	}
	@Test(priority=3)
	public void verifyLoginWithValidAndInvalidPassword() {
	   
		   LoginPage loginPage = new LoginPage(driver);
		
		   loginPage.enterUserName(prop.getProperty("username"));
		   loginPage.enterPassword(dataProp.getProperty("invalidpassword"));
		   loginPage.clickOnLoginButton();
		
		   String actualWarningMessage = loginPage.retrieveWarningMessasgeText();
		String expectedWarningMessage = ("Warning :Invalid Username and Password");
	   // Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Invalid Username and Password");
		loginPage.clickonOKButton();
		
	}
	
	@Test(priority=4)
	public void verifyLoginWithInValidAndValidPassword() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(dataProp.getProperty("invalidusername"));
		
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.clickOnLoginButton();
		
		   String actualWarningMessage = loginPage.retrieveWarningMessasgeText();
			String expectedWarningMessage = ("Warning :Invalid Username and Password");
		   // Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Invalid Username and Password");
			loginPage.clickonOKButton();
			
		
	}
	@Test(priority=5)
	public void VerifWithoutCardentials() {
	    
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickOnLoginButton();
		
		String actualWarningMessage = loginPage.retrieveWarningMessasgeText();
	   	String expectedWarningMessage = ("Warning :Invalid Username and Password");
		   // Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Invalid Username and Password");
		
	}

}
