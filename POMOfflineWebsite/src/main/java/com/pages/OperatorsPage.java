package com.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OperatorsPage {

	WebDriver driver;
	
	public OperatorsPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static Logger log = Logger.getLogger(OperatorsPage.class);
	
	@FindBy(tagName = "tr")
	private List<WebElement> tableRows;
	
	@FindBy(tagName = "th")
	private List<WebElement> tableHeadings;
	
	@FindBy(tagName = "td")
	private List<WebElement> tableData;
	
	public boolean compareTableHeadingWithExcel() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		ArrayList<String> expList = new ArrayList<String>();
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("E:\\Handson\\offlineWeb.xlsx");
		Workbook workBook =  WorkbookFactory.create(fis);
		Sheet sheet = workBook.getSheet("operators");
	//	int rows = sheet.getLastRowNum();	// 5 [actual 6 but gives 5]....row count starts with 0
		for (int i = 0; i <= 0; i++)	// 0 
		{
			int cols = sheet.getRow(i).getLastCellNum();	// 6 [actual 6, gives 6].....column count starts with 1
			for (int j = 0; j < cols; j++) 
			{
				Cell cell = sheet.getRow(i).getCell(j);
				String data = df.formatCellValue(cell);
				expList.add(data);
			}
		}
		
		ArrayList<String> actList = new ArrayList<String>();
		for (WebElement heading : tableHeadings) 
		{
			String head = heading.getText();
			actList.add(head);
		}
		
		if(expList.equals(actList))
			return true;
		else
			return false;
	}
	
	public boolean getPersonOnSms() throws Exception
	{
		ArrayList<String> expList = new ArrayList<String>();
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("E:\\Handson\\offlineWeb.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("operators");
		int rows = sheet.getLastRowNum();	// 5 [actual 6 but gives 5]....row count starts with 0
		for (int i = 1; i <= rows; i++)  // 1,2,3,4,5
		{
			int cols = sheet.getRow(i).getLastCellNum();	// 6 [actual 6, gives 6].....column count starts with 1
			for (int j = 0; j < cols; j++) // 0,1,2,3,4,5
			{
				Cell cell = sheet.getRow(i).getCell(j);
				if(df.formatCellValue(cell).contains("SMS"))
				{
					expList.add(df.formatCellValue(sheet.getRow(i).getCell(j-2)));
				}
				
			}
		}
		
		ArrayList<String> actList = new ArrayList<String>();
		for (int i = 0; i < tableData.size(); i++) 
		{
			WebElement ele = tableData.get(i);
			if(ele.getText().contains("SMS"))
			{
				actList.add(tableData.get(i-2).getText());
			}
		}
		
		if(expList.equals(actList))
			return true;
		else
			return false;
		}
	
	public boolean getPhoneOfTechnicalPersons()
	{
		ArrayList<String> actPh = new ArrayList<String>();
		for (int i = 0; i < tableData.size(); i++) 
		{
			if(tableData.get(i).getText().contains("Technical"))
				actPh.add(tableData.get(i+2).getText()); 
		}
		
		LinkedHashSet<String> expPh = new LinkedHashSet<String>();
		expPh.addAll(actPh);
		
		if(actPh.containsAll(expPh))
			return true;
		else
			return false;
	}
	
	public boolean comprareTableWithExcel() throws Exception	// this testcase will fail
	{
		ArrayList<String> expList = new ArrayList<String>();
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("E:\\Handson\\offlineWeb.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("operators");
		int rows = sheet.getLastRowNum(); // 5 [actual rows=6 but gives 5] row count starts with 0
		for (int i = 0; i <= rows; i++) 
		{
			int cols = sheet.getRow(i).getLastCellNum(); // 6 [actual cols=6 and gives 6] column count starts with 1
			for (int j = 0; j < cols; j++) 
			{
				Cell cell = sheet.getRow(i).getCell(j);
				String data = df.formatCellValue(cell);
				expList.add(data);
			}
		}// excel sheet takes 1,2,3,4,5 instead of 01,02,03,04,05 
		
		ArrayList<String> actList = new ArrayList<String>();
//		for(WebElement tableRow : tableRows)
//		{
//			actList.add(tableRow.getText());	// entire row's data is returned as a single String
//		}										//	1 row = 1 WebElement
		
		for (WebElement tableHeading : tableHeadings) 
		{
			actList.add(tableHeading.getText()); 
		}
		for (WebElement data : tableData) 
		{
			actList.add(data.getText());
		}
		
		if(actList.equals(expList))
			return true;
		else
			return false;
//		System.out.println(actList);
//		System.out.println(expList);
	}
}
