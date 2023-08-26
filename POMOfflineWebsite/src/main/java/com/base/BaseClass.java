package com.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pages.LoginPage;
import com.utils.Utility;

public class BaseClass {

	public static WebDriver driver;
	
	public static Logger log = Logger.getLogger(BaseClass.class);
	
	/*	In log4j.prop file if log4j.appender.file.Append = true,   
	 *	then each time Base class is run, logs are appended in application.log 
	 */
	public static void initialization() throws Exception
	{
	
		System.out.println("reading a property file to get browser name");	// simply print on console
				
		log.info("reading a property file to get browser name");	// read log4j.prop file and accordingly print on console and store in location given in properties file 
																// src/test/resources/projectlog/application.log
		String browserName = Utility.readProperties("browser");
		log.info("browser name in file found as "+ browserName);
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhilash\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();		// initializing driver and launching browser
			log.info("user launched chrome browser");
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\abhilash\\Downloads\\geckodriver.exe");
			driver = new FirefoxDriver();		// initializing driver and launching browser
			log.info("user launched firefox browser");
		}
		
		driver.get(Utility.readProperties("url"));
		log.info("JBK offline application launched");
		driver.manage().window().maximize();		
		log.info("browser window maximized");
	}
	
	// public LoginPage loadLoginPage()
	// {
	// 	LoginPage loginPage = new LoginPage(driver);
	// 	return loginPage;
	// }
}
