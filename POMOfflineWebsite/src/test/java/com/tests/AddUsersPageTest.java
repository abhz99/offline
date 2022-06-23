package com.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.AddUsersPage;
import com.utils.Utility;

public class AddUsersPageTest extends BaseClass{

	AddUsersPage addUsersPage;
	
	@BeforeClass
	public void setup() throws Exception
	{
		//initialization();
		addUsersPage = loadLoginPage().navigateToDashboardPage(driver).navigateToUsersPage(driver).navigateToAddUsersPage(driver);
	}
	
//	@AfterClass
//	public void tearDown()
//	{
//		driver.close();
//		log.info("browser window closed");
//	}
	
	@Test(dataProvider = "userData")
	public void verifyAddNewUser(String uname, String mob, String eid, String courses, String gender, String state, String pass, String fmob)
	{
		Assert.assertTrue(addUsersPage.addNewUser(uname, mob, eid, courses, gender, state, pass, fmob));
	}
	
	@DataProvider
	public String[][] userData() throws Exception
	{
		return Utility.getDataFromAnyExcelSheet("E:\\Handson\\AddUser.xlsx", "usersPage");
	}
}
