package com.otm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//a[text()='Home']")
	private WebElement HomeTEXT;
	
	@FindBy(xpath="//li[@class='list-inline-item']//a[@id='dropdownMenuLink3']")
	private WebElement userNameLabel;
	
	@FindBy(xpath="//a[normalize-space()='Dashboard']")
	private WebElement Dashboard;
	 
	@FindBy(xpath="//a[@id='dropdownMenuLink1']")
	private WebElement Appointments;
	
	@FindBy(xpath="//a[text()='OT Appointments']")
	private WebElement OTAppointments;
	
	@FindBy(xpath="//div[229]//div[2]//div[1]//div[2]//div[1]//div[1]")
	private WebElement OtAppointments;
	
	@FindBy(xpath="//a[@id='dropdownMenuLink2']")
	private WebElement Worklist;
	
	@FindBy(xpath="//li[@class='list-inline-item mr-0 dropdown']//a[@id='dropdownMenuLink3']")
	private WebElement Reports;
	
	@FindBy(xpath="//a[@id='dropdownMenuLink4']")
	private WebElement Settings;	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean getDisplayHome() {
		boolean displayStatus = HomeTEXT.isDisplayed();
		return displayStatus;
	}
	
	
	

}
