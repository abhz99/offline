package com.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.DownloadsPage;

public class DownloadsPageTest extends BaseClass{

	DownloadsPage downloadsPage;
	
	@BeforeClass
	public void setUp() throws Exception
	{
		//initialization();
		downloadsPage = loadLoginPage().navigateToDashboardPage(driver).navigateToDownloadsPage(driver);
	}
	
//	@AfterClass
//	public void tearDown()
//	{
//		driver.close();
//		log.info("browser window closed");
//	}
	
	@Test
	public void checkTitleSelSourceJarPage()
	{
		Assert.assertTrue(downloadsPage.getTitleSelSourceJarPage());
	}
	
	@Test
	public void checkGoogleChromeVersion()
	{
		Assert.assertTrue(downloadsPage.getGoogleChromeVersion());
	}
}
