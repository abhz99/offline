package com.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.DashboardPage;

public class DashboardPageTest extends BaseClass {

	DashboardPage dashboardPage = null;

	@BeforeClass
	public void setup() throws Exception {
		
		dashboardPage = new DashboardPage(driver);
		
	}

//	@AfterClass
//	public void tearDown()
//	{
//		driver.close();
//		log.info("browser window closed");
//	}

	@Test(groups = "beforeLogout")
	public void verifyTitleUsersPage() {
		Assert.assertTrue(dashboardPage.checkUsersLink());

	}

	@Test(groups = "beforeLogout")
	public void verifyTitleOperatorsPage() {
		Assert.assertTrue(dashboardPage.checkOperatorsLink());

	}

	@Test(groups = "beforeLogout")
	public void verifyTitleDownloadsPage()
	{
		System.out.println(driver.getTitle()+"----------------------------------");
		Assert.assertTrue(dashboardPage.checkDownloadsLink());
		
	}

	@Test(groups = "beforeLogout")
	public void verifyTitleUsefulLinkPage() {
		Assert.assertTrue(dashboardPage.checkUsefulLink());

	}

	@Test(dependsOnGroups = "beforeLogout")
	public void verifyTitleLogoutPage() {
		Assert.assertTrue(dashboardPage.checkLogoutLink());

	}
}
