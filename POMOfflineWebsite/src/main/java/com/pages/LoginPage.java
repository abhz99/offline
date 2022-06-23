package com.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
//=================================
	public LoginPage(WebDriver driver) 		// constructor to initialize non-static variable
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	// iniitElements() method will provide driver to WebElements passed to the @FindBy annotation
	}
//==================================	
	public static Logger log = Logger.getLogger(LoginPage.class);
	
	@FindBy(id = "email")
	WebElement uname;
	
	@FindBy(id = "email_error")
	WebElement emailErrMsg;
	
	@FindBy(id = "password")
	WebElement pass;
	
	@FindBy(xpath = "//button")
	WebElement loginButton;
	
//====================================	
	public boolean checkCorrectCred() 
	{
		uname.clear();
		pass.clear();
		uname.sendKeys("kiran@gmail.com");
		pass.sendKeys("123456");
		loginButton.click();
		String expTitle = "JavaByKiran | Dashboard";
		if(driver.getTitle().equals(expTitle))
		{
			log.info("JavaByKiran | Dashboard ......title matches");
			return true;
		}
		else
		{
			log.info("JavaByKiran | Dashboard .....title does not matches");
			return false;
		}
	}
	
	public boolean checkInvalidCred() 
	{
		uname.sendKeys("abhi.com");
		pass.sendKeys("111111");
		loginButton.click();
		String expTitle = "JavaByKiran | Dashboard";
		if(driver.getTitle().equals(expTitle))
		{
			log.info("JavaByKiran | Dashboard ......title matches");
			return true;
		}
		else
		{
			log.info("JavaByKiran | Dashboard .....title does not matches");
			return false;
		}
	}
	
	public boolean checkBlankEmailErrMsg()
	{
		uname.clear();
		pass.clear();
		loginButton.click();
		String expMsg = "Please enter email.";
		if(emailErrMsg.getText().equals(expMsg))
		{
			log.info("Error msg matches");
			return true;
		}
		else
		{
			log.info("Error msg does not matches");
			return false;
		}
	}
	
	public DashboardPage navigateToDashboardPage(WebDriver driver)
	{
		uname.clear();
		pass.clear();
		uname.sendKeys("kiran@gmail.com");
		pass.sendKeys("123456");
		loginButton.click();
		log.info("navigated to dashboard page");
		return new DashboardPage(driver);
	}
		
}
