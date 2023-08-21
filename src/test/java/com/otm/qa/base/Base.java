package com.otm.qa.base;

import java.io.File;
import java.time.Duration;
import java.util.Properties;
import java.io.FileInputStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.otm.qa.util.Utilities;

public class Base {
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;

	public  Base() {
		prop = new Properties();
		File propFile = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\otm\\qa\\config\\config.properties");
		
		dataProp = new Properties();
		File dataPropFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\otm\\qa\\testdata\\testdata.properties");
		try {
		FileInputStream fis2 = new FileInputStream(dataPropFile);
		dataProp.load(fis2);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public WebDriver intializeBrowserAndOpenApplicationURL(String browserName) {
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("firebox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("url"));

		return driver;
	}

}
