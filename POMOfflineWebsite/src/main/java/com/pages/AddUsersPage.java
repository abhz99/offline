package com.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddUsersPage {

	WebDriver driver;
	
	public AddUsersPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static Logger log = Logger.getLogger(AddUsersPage.class);
	
	@FindBy(id = "username")
	private WebElement userName;
	
	@FindBy(id = "mobile")
	private WebElement mobile;
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "course")
	private WebElement course;
	
	@FindBy(id = "Male")
	private WebElement male;
	
	@FindBy(id = "Female")
	private WebElement female;
	
	@FindBy(tagName = "select")
	private WebElement selectStates;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(xpath = "//input[@placeholder='FriendMobile']")
	private WebElement friendMob;
	
	@FindBy(id = "submit")
	private WebElement submit;
	
	public boolean addNewUser(String uname, String mob, String eid, String courses, String gender, String state, String pass, String fmob)
	{
		userName.sendKeys(uname);
		mobile.sendKeys(mob);
		email.sendKeys(eid);
		course.sendKeys(courses);
		if(gender.equalsIgnoreCase("male"))
			male.click();
		else if(gender.equalsIgnoreCase("female"))
			female.click();
		Select select = new Select(selectStates);
		select.selectByVisibleText(state);
		password.sendKeys(pass);
		friendMob.sendKeys(fmob);
		submit.click();
		String alertTxt = driver.switchTo().alert().getText();
		if(alertTxt.equals("User Added Successfully. You can not see added user."))
		{
			driver.switchTo().alert().accept();
			log.info("user added");
			return true;
		}
		else
		{
			log.info("user not added");
			return false;
		}
	}
}
