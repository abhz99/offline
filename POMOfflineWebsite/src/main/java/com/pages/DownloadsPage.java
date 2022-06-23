package com.pages;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DownloadsPage {

	WebDriver driver;
	
	public DownloadsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static Logger log = Logger.getLogger(DownloadsPage.class);
	
	@FindBy(xpath = "//td[text()='03']//following::span[text()='Official Website']")
	private WebElement selSourceJarOfficialWeb;
	
	@FindBy(xpath = "//td[text()='Google Chrome ']//following::span")
	private WebElement chromeVersion;
	
	public boolean getTitleSelSourceJarPage()
	{
		String expTitle = "Overview";
		String actTitle = "";
		String parentWin = driver.getWindowHandle();
		selSourceJarOfficialWeb.click();
		Set<String> allWin = driver.getWindowHandles();
		for (String window : allWin) 
		{
			if(! window.equals(parentWin))
			{
				driver.switchTo().window(window);
				actTitle = driver.getTitle();
			}
		}
		if(expTitle.equals(actTitle))
			return true;
		else 
			return false;	
	}
	
	public boolean getGoogleChromeVersion()
	{
		String expText = "76.0";
		if(expText.equals(chromeVersion.getText()))
			return true;
		else
			return false;
	}
}
