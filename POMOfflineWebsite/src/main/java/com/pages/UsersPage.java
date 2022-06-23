package com.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {

	WebDriver driver;
	
	public UsersPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static Logger log = Logger.getLogger(UsersPage.class);
	
	@FindBy(xpath = "//button[text()='Add User']")
	private WebElement addUserButton;
	
	
	public AddUsersPage navigateToAddUsersPage(WebDriver driver)
	{
		addUserButton.click();
		return new AddUsersPage(driver);
	}
}
