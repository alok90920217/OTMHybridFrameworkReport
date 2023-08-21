package com.otm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.otm.qa.base.Base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorklistTest extends Base {
	
	public WorklistTest() {
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
	
	@Test
	public void verifyBookingRequestMandatoryFields(){
		
		
		driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//button[@id=\"login\"]")).click();
		driver.findElement(By.id("dropdownMenuLink2")).click();
		driver.findElement(By.xpath("//a[(text()='Booking Requests')]")).click();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
