package com.otm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@id='login']")
	private WebElement LoginBtn;
	
	@FindBy(xpath="//div[text()='Invalid Username and Password']")
	private WebElement InvalidUsernameandPassword;
	
	@FindBy(xpath="//button[@class='ant-btn ant-btn-primary']")
	private WebElement OKBUTTON;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	 public void enterUserName(String userText) {
		 username.sendKeys(userText);
	 }
	  
	 public void enterPassword(String passwordText) {
		 password.sendKeys(passwordText);
	 }
	 
	 public void clickOnLoginButton() {
		 LoginBtn.click();
	 }
	 public String retrieveWarningMessasgeText() {
		 String warningText = InvalidUsernameandPassword.getText();
		 return warningText;
		 
		 
	 }
	 
	 public void clickonOKButton() {
		 OKBUTTON.click();
	 }
	
		
	}
	


