package com.tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.OperatorsPage;

public class OperatorsPageTest extends BaseClass{

	OperatorsPage operatorsPage; 
	
	@BeforeClass
	public void setup() throws Exception
	{
		//initialization();
		operatorsPage = loadLoginPage().navigateToDashboardPage(driver).navigateToOperatorsPage(driver);
	}
	
//	@AfterClass
//	public void tearDown()
//	{
//		driver.close();
//		log.info("browser window closed");
//	}
	
	@Test
	public void CheckTableHeading() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		Assert.assertTrue(operatorsPage.compareTableHeadingWithExcel());
	}
	
	@Test
	public void checkPersonOnSms() throws Exception
	{
		Assert.assertTrue(operatorsPage.getPersonOnSms());
	}
	
	@Test
	public void checkPhoneOfTechnicalPersons()
	{
		Assert.assertTrue(operatorsPage.getPhoneOfTechnicalPersons());
	}
	
	@Test
	public void checkTableWithExcel() throws Exception
	{
		Assert.assertTrue(operatorsPage.comprareTableWithExcel());	// intentionally failed
		//operatorsPage.comprareTableWithExcel();
	}
}
