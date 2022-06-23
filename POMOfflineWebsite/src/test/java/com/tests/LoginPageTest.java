package com.tests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.LoginPage;

public class LoginPageTest extends BaseClass{

	LoginPage lp;
	
	@BeforeSuite
	public void setup() throws Exception
	{
		initialization();
		log.info("Browser initialized");
		lp = new LoginPage(driver);
	}
	
	@AfterSuite
	public void tearDown()
	{
		driver.close();
		log.info("browser window closed");
	}
	
	@Test(dependsOnMethods = "verifyInavlidCred")
	public void verifyTitleDashboardPage()
	{
		//if(! driver.getTitle().equals("JavaByKiran | Dashboard")) 
		//driver.navigate().to("file:///E:/Selenium/Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		Assert.assertTrue(lp.checkCorrectCred());
	}
	
	@Test(dependsOnMethods = "verifyBlankEmailErrMsg")
	public void verifyInavlidCred()
	{
		Assert.assertFalse(lp.checkInvalidCred());
	}
	
	@Test
	public void verifyBlankEmailErrMsg()
	{
		Assert.assertTrue(lp.checkBlankEmailErrMsg());
	}
}
