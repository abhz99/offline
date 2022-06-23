package com.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	WebDriver driver;

	

	public static Logger log = Logger.getLogger(DashboardPage.class);
	
	@FindBy(xpath = "//span[text()='Users']")
	private WebElement users;
	
	@FindBy(linkText = "Operators")
	private WebElement operators;
	
	@FindBy(linkText = "Useful Links")
	private WebElement  usefulLinks;
	
	@FindBy(xpath = "//span[text()='Downloads']")
	private WebElement downloads;
	
	@FindBy(linkText = "Logout")
	private WebElement logout;
	
	
	public DashboardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean checkUsersLink()
	{
		users.click();
		log.info("clicked on Users link");
		if(driver.getTitle().equals("JavaByKiran | User"))
		{
			log.info("page title matches");
			return true;
		}	
		else
		{
			log.info("page title mis-match");
			return false;
		}
	}
	
	public boolean checkOperatorsLink()
	{
		operators.click();
		log.info("clicked on Operators link");
		if(driver.getTitle().equals("JavaByKiran | Operators"))
		{
			log.info("page title matches");
			return true;
		}	
		else
		{
			log.info("page title mis-match");
			return false;
		}
	}
	
	public boolean checkUsefulLink()
	{
		usefulLinks.click();
		log.info("clicked on UsefullLinks link");
		if(driver.getTitle().equals("JavaByKiran | Useful Links"))
		{
			log.info("page title matches");
			return true;
		}	
		else
		{
			log.info("page title mis-match");
			return false;
		}		
	}
	
	public boolean checkDownloadsLink()
	{
		downloads.click();
		log.info("clicked on Downloads link");
		if(driver.getTitle().equals("JavaByKiran | Downloads"))
		{
			log.info("page title matches");
			return true;
		}	
		else
		{
			log.info("page title mis-match");
			return false;
		}		
	}
	
	public boolean checkLogoutLink()
	{
		logout.click();
		log.info("clicked on Logout link");
		if(driver.getTitle().equals("JavaByKiran | Log in"))
		{
			log.info("page title matches");
			return true;
		}	
		else
		{
			log.info("page title mis-match");
			return false;
		}		
	}
	
//=========================================================================	
		public UsersPage navigateToUsersPage(WebDriver driver)
		{
			users.click();
			return new UsersPage(driver);
		}
	
		public OperatorsPage navigateToOperatorsPage(WebDriver driver)
		{
			operators.click();
			return new OperatorsPage(driver);
		}
			
		public UsefulLinksPage navigateToUsefulLinksPage(WebDriver driver)
		{
			usefulLinks.click();
			return new UsefulLinksPage(driver);
		}
					
		public DownloadsPage navigateToDownloadsPage(WebDriver driver)
		{
			downloads.click();
			return new DownloadsPage(driver);
		}

}
